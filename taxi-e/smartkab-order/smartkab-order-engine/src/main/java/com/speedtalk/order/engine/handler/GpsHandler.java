package com.speedtalk.order.engine.handler;

import com.speedtalk.order.engine.IOrderHandler;
import com.speedtalk.order.engine.OrderLogger;
import com.speedtalk.order.engine.dao.BaseDao;
import com.speedtalk.order.engine.dao.DriverDao;
import com.speedtalk.order.engine.db.TabDriver;
import com.speedtalk.order.engine.db.TabPhonecallbuss;
import com.speedtalk.order.engine.db.TabPosOfOrderTrack;
import com.speedtalk.order.engine.kabs.KabInfo;
import com.speedtalk.order.engine.kabs.KabTeam;
import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.constants.LengthConstants;
import com.speedtalk.protocol.order.mq.MQSender;
import com.speedtalk.protocol.tscobjs.GPS;
import com.speedtalk.utils.ExcepPrinter;
import com.speedtalk.utils.LoadXmlConfig;
import org.apache.mina.core.session.IoSession;

import javax.jms.JMSException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class GpsHandler implements IOrderHandler {
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyMM");
    private final SimpleDateFormat gpsSdf = new SimpleDateFormat("yyyyMMddHHmmss");
    private DriverDao driverDao = new DriverDao();
    private BaseDao baseDao = new BaseDao();
    private MQSender mqSender = null;

    public GpsHandler() {
        try {
            initMqSender();
        } catch (JMSException jme) {
            ExcepPrinter.print(jme);
            OrderLogger.getLogger().debug("init MQ Sender occur exception!!!");
        }
    }

    private void initMqSender() throws JMSException {
        String mqAddr = null, queueName = null;
        try {
            mqAddr = LoadXmlConfig.getConfigHash().get("mq-addr");
            queueName = LoadXmlConfig.getConfigHash().get("etows-queue");
        } catch (Exception e) {
        }
        mqSender = new MQSender(mqAddr, queueName);
    }

    @Override
    public void handler(IoSession session, TSCObject obj) {
        try {
            GPS gps = (GPS) obj;

            TabDriver driver = driverDao.getByAccount(gps.getSrcMsID());
            driver.setLastlg(gps.getLg());
            driver.setLastlt(gps.getLt());
            driver.setGpstime(new Timestamp(System.currentTimeMillis()));
            driverDao.update(driver);

            KabInfo kabInfo = KabTeam.getInstance().getKab(gps.getSrcMsID());
            if (null == kabInfo.getSession()) {
                session.close(true);
                OrderLogger.getLogger().debug("账号没登录！ " + kabInfo.getAccount() + "," + gps.getSrcMsID());
            }

            kabInfo.setLg(gps.getLg());
            kabInfo.setLt(gps.getLt());
            kabInfo.setTime(System.currentTimeMillis());
            OrderLogger.getLogger().debug(kabInfo.toString());

            if (KabTeam.NORMAL != driver.getIsstop()) {
                kabInfo.setIsstop(driver.getIsstop());
                kabInfo.getSession().close(true);
                OrderLogger.getLogger().debug("****** 账号被停用！ " + kabInfo.getAccount());
            }

            if (gps.getDstMsID() != null && gps.getDstMsID().length() == LengthConstants.ID_LENGTH) {
                String orderNum = sdf.format(System.currentTimeMillis()) + gps.getDstMsID();
                TabPhonecallbuss tbOrder = (TabPhonecallbuss) baseDao.get(TabPhonecallbuss.class, orderNum);
                if (null == tbOrder)
                    OrderLogger.getLogger().debug("Order num error! " + orderNum);
                else {
                    TabPosOfOrderTrack track = new TabPosOfOrderTrack(orderNum, gps.getSrcMsID(), (byte) 1, gps.getLg(), gps
                            .getLt(), new Timestamp(gpsSdf.parse(gps.getTime())
                            .getTime()), new Timestamp(System.currentTimeMillis()));
                    baseDao.save(track);
                }
            }

            try {
                mqSender.sendMessage(gps);
            } catch (JMSException jme) {
                ExcepPrinter.print(jme);
            }
        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
    }
}

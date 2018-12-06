package com.speedtalk.order.engine.handler;

import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.speedtalk.order.engine.IOrderHandler;
import com.speedtalk.order.engine.OrderLogger;
import com.speedtalk.order.engine.OrderNumUtils;
import com.speedtalk.order.engine.ScoreMqSender;
import com.speedtalk.order.engine.dao.BaseDao;
import com.speedtalk.order.engine.db.TabPayrecords;
import com.speedtalk.order.engine.db.TabPhonecallbuss;
import com.speedtalk.order.engine.kabs.KabInfo;
import com.speedtalk.order.engine.kabs.KabTeam;
import com.speedtalk.order.engine.pay.AlipayPrecreate;
import com.speedtalk.order.engine.pay.WeChatPay;
import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.order.OrderConstants;
import com.speedtalk.protocol.order.OrderMessConstants;
import com.speedtalk.protocol.order.objs.PayInfo;
import com.speedtalk.protocol.order.objs.PayInfoResp;
import com.speedtalk.utils.ExcepPrinter;
import com.speedtalk.utils.LoadXmlConfig;
import org.apache.mina.core.session.IoSession;

import javax.jms.JMSException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Map;

public class PayInfoHandler implements IOrderHandler {
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
    private BaseDao baseDao = new BaseDao();

    @Override
    public void handler(IoSession session, TSCObject obj) {
        try {
            PayInfo payInfo = (PayInfo) obj;
            OrderLogger.getLogger().debug(payInfo.toString() + "--" + session.getRemoteAddress());
            PayInfoResp resp = new PayInfoResp(payInfo.getSrcMsID(), payInfo.getMsName(), payInfo.getOrderNum(), payInfo
                    .getPayType(), null);
            resp.setMessNo(payInfo.getMessNo());
            TabPhonecallbuss order = null;
            if (null == payInfo.getOrderNum() || payInfo.getOrderNum().trim().equals("null") || payInfo.getOrderNum()
                    .trim()
                    .equals("")) {
                OrderLogger.getLogger()
                        .debug("pay info OrderNum is null,create new order!" + payInfo.getOrderNum() + "," + session.getRemoteAddress());
                String orderNum = OrderNumUtils.getOrderSerialNum();
                KabInfo kabInfo = KabTeam.getInstance().getKab(payInfo.getSrcMsID());
                order = new TabPhonecallbuss(orderNum, OrderConstants.FINISHED_ORDER, "0", "0", kabInfo.getKabNum(), kabInfo
                        .getMsId(), new Timestamp(System.currentTimeMillis()), OrderConstants.PHONE_ORDER);
                order.setEnterpriseid(kabInfo.getClientId());
                baseDao.save(order);
                payInfo.setOrderNum(orderNum);
                resp.setOrderNum(orderNum);
            }
            //			else
            //			{
            if (null == order)
                order = (TabPhonecallbuss) baseDao.get(TabPhonecallbuss.class, payInfo.getOrderNum());
            try {
                order.setMoney(Float.parseFloat(payInfo.getMoney()) / 100f);
                baseDao.update(order);    //更新订单金额
            } catch (Exception e) {
                ExcepPrinter.print(e);
            }

            TabPayrecords payrecords = (TabPayrecords) baseDao.get(TabPayrecords.class, payInfo.getOrderNum());
            if (null == payrecords) {
                try {
                    payrecords = new TabPayrecords(payInfo.getOrderNum(), new Timestamp(sdf.parse(payInfo.getGetOnTime())
                            .getTime()), new Timestamp(sdf.parse(payInfo.getGetOffTime())
                            .getTime()), payInfo.getSrcMsID(), Double.parseDouble(payInfo.getMileage()) / 1000d, Double.parseDouble(payInfo
                            .getMoney()) / 100d, Double.parseDouble(payInfo.getUselessMileage()) / 1000d, Double.parseDouble(payInfo
                            .getExtraMoney()) / 100d, Integer.parseInt(payInfo.getWaitTime()), (int) payInfo.getPayType(), null);
                    if (payInfo.getPayType() == OrderMessConstants.CASH_PAY)
                        payrecords.setPaytime(new Timestamp(System.currentTimeMillis()));
                    baseDao.save(payrecords);
                } catch (Exception e) {
                    ExcepPrinter.print(e);
                }
            }
            if (payInfo.getPayType() == OrderMessConstants.ALIPAY_PAY) {
                AlipayTradePrecreateResponse aliResp = AlipayPrecreate.precreate(payInfo);
                OrderLogger.getLogger()
                        .debug("Ali Precreate resp -- code:" + aliResp.getCode() + ",msg:" + aliResp.getMsg() + "OutTradeNo:" + aliResp
                                .getOutTradeNo() + "QrCode:" + aliResp.getQrCode());
                if (aliResp != null)
                    resp.setPayLink(aliResp.getQrCode());
            } else if (payInfo.getPayType() == OrderMessConstants.CASH_PAY) {
                OrderLogger.getLogger().debug(payInfo.getOrderNum() + " cash payment!");
            } else if (payInfo.getPayType() == OrderMessConstants.WECHAT_PAY) {
                Map<String, String> map = WeChatPay.unifiedOrder(payInfo);
                if (map != null && (map.get("code_url") != null && !map.get("code_url").trim().equals("")))
                    resp.setPayLink(map.get("code_url"));
            }
            //			}
            session.write(resp);
            OrderLogger.getLogger().debug(resp.toString() + "--" + session.getRemoteAddress());

            /**
             * 按距离计算积分
             */
            if ("1".equals(LoadXmlConfig.getConfigHash().get("is-score")) && "1".equals(LoadXmlConfig.getConfigHash()
                    .get("score-type"))) {
                try {
                    ScoreMqSender.getInstance().sendMessage(payInfo);
                } catch (JMSException jmse) {
                    ExcepPrinter.print(jmse);
                    OrderLogger.getLogger().debug(payInfo.getSrcMsID() + "完成订单!发送计算积分信息时队列发生异常!");
                }
            }
        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
    }
}

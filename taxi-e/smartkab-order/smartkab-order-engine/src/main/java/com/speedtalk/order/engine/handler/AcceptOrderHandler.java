package com.speedtalk.order.engine.handler;

import com.speedtalk.order.engine.*;
import com.speedtalk.order.engine.dao.BaseDao;
import com.speedtalk.order.engine.dao.DriverDao;
import com.speedtalk.order.engine.dao.OrderDao;
import com.speedtalk.order.engine.db.TabClientSetting;
import com.speedtalk.order.engine.db.TabDriver;
import com.speedtalk.order.engine.db.TabLogSmsdiary;
import com.speedtalk.order.engine.db.TabPhonecallbuss;
import com.speedtalk.order.engine.kabs.KabInfo;
import com.speedtalk.order.engine.kabs.KabTeam;
import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.order.OrderConstants;
import com.speedtalk.protocol.order.OrderMessConstants;
import com.speedtalk.protocol.order.objs.AcceptOrderResp;
import com.speedtalk.protocol.order.objs.Order;
import com.speedtalk.protocol.order.objs.OrderInteractive;
import com.speedtalk.utils.ExcepPrinter;
import com.speedtalk.utils.LoadXmlConfig;
import org.apache.mina.core.session.IoSession;

import java.sql.Timestamp;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AcceptOrderHandler implements IOrderHandler {
    private BaseDao baseDao = new BaseDao();
    private OrderDao orderDao = new OrderDao();
    private DriverDao driverDao = new DriverDao();

    public static boolean isPhone(String mobile) {
        try {
            Pattern p = Pattern.compile("^((13[0-9])|(14[5,7])|(15[^4,\\D])|(17[0,6-8])|(18[0-9]))\\d{8}$");
            Matcher m = p.matcher(mobile);
            return m.matches();
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void handler(IoSession session, TSCObject obj) {
        try {
            Order order = (Order) obj;
            OrderLogger.getLogger().debug(order.toString() + "--" + session.getRemoteAddress());
            AcceptOrderResp resp = new AcceptOrderResp(order.getSrcMsID(), order.getMsName(), order.getOrderNum(), OrderMessConstants.FAILURE, null);
            resp.setMessNo(order.getMessNo());
            boolean accept = false;
            TabPhonecallbuss tbOrder = orderDao.getOrder(order.getOrderNum());
            try {
                OrderLogger.getLogger().debug(tbOrder.toString());
            } catch (Exception e) {
            }
            KabInfo kabInfo = KabTeam.getInstance().getKab(order.getSrcMsID());
            TabDriver driver = null;
            if (null == tbOrder)
                resp.setDesc(OrderMessConstants.E10);
            else if (tbOrder.getStatus() == OrderConstants.ACCEPTED_ORDER) {
                driver = driverDao.getByMsId(tbOrder.getMsid());
                if (driver != null && driver.getAccount().equals(order.getSrcMsID()))
                    resp.setCode(OrderMessConstants.SUCCESS);
                else {
                    resp.setDesc(OrderMessConstants.ACCEPT_ORDER_FAILURED_TIP.replace("?", driver.getKabnum()));
                }
            } else if (kabInfo.getRemain() <= 0) {
                resp.setDesc(OrderMessConstants.E13);
            } else if (tbOrder.getStatus() == OrderConstants.DROPPED_ORDER)
                resp.setDesc(OrderMessConstants.E08);
            else if (tbOrder.getStatus() == OrderConstants.FINISHED_ORDER)
                resp.setDesc(OrderMessConstants.E09);
            else {
                try {
                    accept = Orders.getInstance().acceptOrder(order);
                } catch (Exception e) {
                    ExcepPrinter.print(e);
                }
                if (accept) {
                    resp.setCode(OrderMessConstants.SUCCESS);
                    //					kabInfo = KabTeam.getInstance().getKab(order.getSrcMsID());
                    kabInfo.setCarry(KabTeam.CARRY);
                    OrderLogger.getLogger().debug(order.getSrcMsID() + "抢单成功！设置为载客状态!");
                } else {
                    tbOrder = orderDao.getOrder(order.getOrderNum());
                    try {
                        OrderLogger.getLogger().debug(tbOrder.toString());
                    } catch (Exception e) {
                    }
                    try {
                        resp.setDesc(OrderMessConstants.ACCEPT_ORDER_FAILURED_TIP.replace("?", tbOrder.getCarbox()));
                    } catch (NullPointerException npe) {
                        resp.setDesc(OrderMessConstants.E08);
                    }
                }
            }
            session.write(resp);
            String isSms = LoadXmlConfig.getConfigHash().get("is-sms");
            if ((isSms != null && isSms.equals("1")) && (tbOrder.getOrdertype() == OrderConstants.PHONE_ORDER || tbOrder
                    .getOrdertype() == OrderConstants.VOICE_ORDER) && accept && isPhone(tbOrder.getCallnumber()))    //发送短信通知
            {
                try {
                    TabClientSetting clientSet = (TabClientSetting) baseDao.get(TabClientSetting.class, tbOrder.getEnterpriseid());
                    if (clientSet != null && clientSet.getMessagenum() > 0 && clientSet.getSmsid() != null && !clientSet
                            .getSmsid()
                            .trim()
                            .equals("") && clientSet.getSmskey() != null && !clientSet.getSmskey().trim().equals("")) {
                        SmsSender.sendSms(clientSet.getSmsid(), clientSet.getSmskey(), tbOrder.getBillid(), tbOrder.getCallnumber(), kabInfo
                                .getKabNum(), kabInfo.getName(), kabInfo.getPhone());
                        clientSet.setMessagenum(clientSet.getMessagenum() - 1);
                        baseDao.update(clientSet);
                        String smsTpl = LoadXmlConfig.getConfigHash().get("sms-tpl");
                        if (smsTpl != null && !smsTpl.trim().equals("")) {
                            OrderLogger.getLogger().debug("SMS tpl:" + smsTpl);
                            smsTpl = smsTpl.replace("#kab#", kabInfo.getKabNum())
                                    .replace("#driver#", kabInfo.getName())
                                    .replace("#phone#", kabInfo.getPhone());
                            TabLogSmsdiary sms = new TabLogSmsdiary("【engine】-" + smsTpl, tbOrder.getCallnumber(), new Timestamp(System
                                    .currentTimeMillis()), tbOrder.getEnterpriseid());
                            baseDao.save(sms);
                        }
                    } else
                        OrderLogger.getLogger().debug(tbOrder.getEnterpriseid() + " 公司没有短信可以发送!!!");
                } catch (Exception e) {
                    OrderLogger.getLogger().debug(tbOrder.getBillid() + "编码短信内容异常！");
                }
            }

            if (accept)    //发送订单同步通知
            {
                List<String> list = OrderSentRecorder.getInstance().removeRecord(order.getOrderNum());
                OrderInteractive interactive = null;
                KabInfo kab = null, acceptedKab = KabTeam.getInstance().getKab(order.getSrcMsID());
                StringBuilder buf = new StringBuilder("同步订单 ");
                buf.append(order.getOrderNum()).append(" 状态-->>");
                try {
                    for (String account : list) {
                        try {
                            if (account.equalsIgnoreCase(order.getSrcMsID()))
                                continue;
                            kab = KabTeam.getInstance().getKab(account);
                            interactive = new OrderInteractive(account, account, order.getOrderNum(), OrderConstants.ORDER_ACCEPTED, (null == acceptedKab
                                    .getKabNum() ? " " : acceptedKab.getKabNum()) + "已抢单!");
                            kab.getSession().write(interactive);
                            buf.append(account).append(",").append(kab.getSessionInfo()).append(";");
                        } catch (NullPointerException npe) {
                        } catch (Exception e) {
                            ExcepPrinter.print(e);
                        }
                    }
                    OrderLogger.getLogger().debug(buf);
                } catch (Exception e) {
                    ExcepPrinter.print(e);
                }
            }
            if (accept)    //更新接单数
            {
                driver = driverDao.getByAccount(order.getSrcMsID());
                int remain = driver.getRemain();
                driver.setRemain(remain > 0 ? remain - 1 : 0);
                baseDao.update(driver);
                kabInfo.setRemain(driver.getRemain());
            }
            OrderLogger.getLogger().debug(resp.toString() + "--" + session.getRemoteAddress());
        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
    }
}

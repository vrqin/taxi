package com.speedtalk.order.engine.handler;

import com.speedtalk.order.engine.IOrderHandler;
import com.speedtalk.order.engine.OrderLogger;
import com.speedtalk.order.engine.dao.DriverDao;
import com.speedtalk.order.engine.db.TabDriver;
import com.speedtalk.order.engine.kabs.KabInfo;
import com.speedtalk.order.engine.kabs.KabTeam;
import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.order.OrderMessConstants;
import com.speedtalk.protocol.order.objs.ForceLogout;
import com.speedtalk.protocol.order.objs.OrderLoginExt;
import com.speedtalk.protocol.order.objs.OrderLoginResp;
import com.speedtalk.utils.ExcepPrinter;
import com.speedtalk.utils.LoadXmlConfig;
import org.apache.mina.core.session.IoSession;

import java.util.List;

public class LoginExtHandler implements IOrderHandler {
    public static final String ACCOUNT_SESSION_KEY = "ACCOUNT";
    private DriverDao driverDao = new DriverDao();

    @Override
    public void handler(IoSession session, TSCObject obj) {
        try {
            OrderLoginExt login = (OrderLoginExt) obj;
            OrderLogger.getLogger().debug(login.toString() + "--" + session.getRemoteAddress());
            OrderLoginResp resp = new OrderLoginResp(login.getSrcMsID(), login.getMsName(), null, null, null, null, null, null, null, null, null, null, null);
            resp.setMessNo(login.getMessNo());
            String upgradeList = LoadXmlConfig.getConfigHash().get("must-upgrade-list");
            if (upgradeList != null && !upgradeList.isEmpty()) {
                try {
                    for (String list : upgradeList.split(",")) {
                        if (list.toLowerCase().contains(login.getSrcMsID().toLowerCase())) {
                            try {
                                String version = login.getAttach().get(0).replaceAll("[Vv]", "");
                                if (version.startsWith("2"))//>v2.0.0不用升级
                                    break;
                            } catch (NullPointerException npe) {
                                break;
                            }//IOS没有版本信息
                            catch (Exception e) {
                            }
                            resp.setCode(OrderMessConstants.FAILURE);
                            resp.setDesc(OrderMessConstants.E11);
                            session.write(resp);
                            session.close(false);
                            OrderLogger.getLogger().debug("YYYYYY 司机端被要求强制升级才能登录! " + login.getSrcMsID());
                            return;
                        }
                    }
                } catch (Exception e) {
                }
            }
            TabDriver driver = null;
            if (login.getLoginType() == OrderMessConstants.ACCOUNT_LOGIN_TYPE)
                driver = driverDao.getByAccount(login.getSrcMsID());
            else
                driver = driverDao.getByICcard(login.getSrcMsID());
            if (null == driver) {
                resp.setCode(OrderMessConstants.FAILURE);
                if (login.getLoginType() == OrderMessConstants.ACCOUNT_LOGIN_TYPE)
                    resp.setDesc(OrderMessConstants.E02);
                else
                    resp.setDesc(OrderMessConstants.E12);
                session.write(resp);
                session.close(false);
            } else if (KabTeam.NORMAL != driver.getIsstop()) {
                resp.setCode(OrderMessConstants.FAILURE);
                resp.setDesc(OrderMessConstants.E11);
                session.write(resp);
                session.close(false);
            } else if (login.getLoginType() == OrderMessConstants.ACCOUNT_LOGIN_TYPE && !login.getPwd()
                    .equals(driver.getPwd())) {
                resp.setCode(OrderMessConstants.FAILURE);
                resp.setDesc(OrderMessConstants.E02);
                session.write(resp);
                session.close(false);
            } else {
                resp.setSrcMsID(driver.getAccount());
                resp.setCode(OrderMessConstants.SUCCESS);
                resp.setDriverName(driver.getName());
                resp.setVehicleNum(driver.getKabnum());
                resp.setDriverMobile(driver.getPhone());
                resp.setLevel(driver.getLevel());
                resp.setTradeCer(driver.getTradeCer());
                resp.setSerialNum(driver.getSerialNum());
                resp.setCompany(driver.getCompany());
                resp.setDriveLicense(driver.getDriveLicense());
                resp.setIconUrl(null == driver.getIconUrl() ? " " : LoadXmlConfig.getConfigHash()
                        .get("iconurl-prefix") + driver.getIconUrl());
                driverDao.updateOnlineStatus(driver.getAccount(), KabTeam.ONLINE);
                session.write(resp);
                session.setAttribute(ACCOUNT_SESSION_KEY, driver.getAccount());
                KabInfo newKabInfo = null;
                if (login.getLoginType() == OrderMessConstants.IC_CARD_LOGIN_TYPE)
                    newKabInfo = KabTeam.getInstance().getKabByIccard(login.getSrcMsID());
                else
                    newKabInfo = KabTeam.getInstance().getKab(login.getSrcMsID());
                if (null == newKabInfo) {
                    newKabInfo = new KabInfo();
                    newKabInfo.setAccount(driver.getAccount());
                    newKabInfo.setMsId(driver.getMsid());
                    newKabInfo.setName(driver.getName());
                    newKabInfo.setKabNum(driver.getKabnum());
                    newKabInfo.setCarry(KabTeam.UNCARRY);
                    newKabInfo.setOnline(KabTeam.ONLINE);
                    newKabInfo.setLg(null == driver.getLastlg() ? 0.0 : driver.getLastlg());
                    newKabInfo.setLt(null == driver.getLastlt() ? 0.0 : driver.getLastlt());
                    newKabInfo.setTime(null == driver.getGpstime() ? 0 : driver.getGpstime().getTime());
                    newKabInfo.setIccard(driver.getIccard());
                    newKabInfo.setSession(session);
                    KabTeam.getInstance().addKab(newKabInfo);
                } else {
                    if (newKabInfo.getSession() != null) {
                        OrderLogger.getLogger().debug("可能重复登录,关闭旧连接：" + newKabInfo.getSessionInfo());
                        try {
                            newKabInfo.getSession().close(true);
                        } catch (Exception e) {
                        }
                    }
                    newKabInfo.setOnline(KabTeam.ONLINE);
                    newKabInfo.setSession(session);
                }

                /**
                 * 处理同一车牌号只能一个账号登录
                 */
                List<KabInfo> list = KabTeam.getInstance().getKabByKabNum(driver.getKabnum());
                try {
                    ForceLogout forceLogout = new ForceLogout("", "", driver.getName());

                    for (KabInfo kabInfo : list) {
                        try {
                            if (!kabInfo.getAccount().equalsIgnoreCase(driver.getAccount())/*
									&& !login.getSrcMsID().equalsIgnoreCase(kabInfo.getIccard())*/) {
                                if (kabInfo.getSession() != null && kabInfo.getSession().isConnected()) {
                                    forceLogout.setSrcMsID(kabInfo.getAccount());
                                    forceLogout.setMsName(kabInfo.getName());
                                    kabInfo.getSession().write(forceLogout);
                                    kabInfo.setOnline(KabTeam.OFFLINE);
                                    kabInfo.getSession().close(false);
                                    kabInfo.setSession(null);
                                    driverDao.updateOnlineStatus(kabInfo.getAccount(), KabTeam.OFFLINE);
                                    OrderLogger.getLogger().debug(kabInfo.toString() + "***被强制下线!");
                                }
                            }
                        } catch (Exception e) {
                            ExcepPrinter.print(e);
                        }
                    }
                } catch (Exception e) {
                    ExcepPrinter.print(e);
                }
            }
            OrderLogger.getLogger().debug(resp.toString() + "--" + session.getRemoteAddress());
        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
    }
}

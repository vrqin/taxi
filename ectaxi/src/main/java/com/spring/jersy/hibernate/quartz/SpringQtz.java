package com.spring.jersy.hibernate.quartz;


import com.spring.jersy.hibernate.model.dao.*;
import com.spring.jersy.hibernate.model.entity.*;
import com.spring.jersy.hibernate.publics.bean.CallbussTimeOutBean;
import com.spring.jersy.hibernate.publics.bean.PunishmentBean;
import com.spring.jersy.hibernate.publics.sms.SmsSender;
import com.spring.jersy.hibernate.publics.util.DateUtil;
import com.spring.jersy.hibernate.publics.util.S;
import com.spring.jersy.hibernate.publics.util.SpringUtils;
import com.spring.jersy.hibernate.servlet.StartupServlet;
import com.spring.jersy.hibernate.synch.Synch;
import org.apache.log4j.Logger;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import static com.spring.jersy.hibernate.publics.sms.SmsSender.SMS_ID;
//import static com.spring.jersy.hibernate.publics.sms.SmsSender.SMS_Key;

@Service
public class SpringQtz {
    private static final Logger LOGGER = Logger.getLogger(SpringQtz.class);


    @Autowired

    private Synch synch;

    public SpringQtz() {

        LOGGER.warn("SpringQtz");
    }


    //默认2分钟开始扫超时
    public static StringBuffer CallBussTimeOUt() {
        StringBuffer sqllsit = new StringBuffer();
        sqllsit.append(" SELECT billid,enterpriseid,`status`,opruser,calltime,clientmobile,ordertype,TIMESTAMPDIFF(MINUTE,calltime, now()) FROM tab_phonecallbuss  ");
        sqllsit.append(" WHERE calltime > date(NOW()) AND (`status` =0 OR `status` = 1) AND clientmobile REGEXP '^[1][35678][0-9]{9}$' AND TIMESTAMPDIFF(MINUTE,calltime, now()) > " + 2);
        return sqllsit;

    }

    // 默认2分钟开始扫超时
    public static StringBuffer PunishmentCancal() {
        StringBuffer sqllsit = new StringBuffer();
        sqllsit.append(" SELECT enterpriseid,msid,carbox,COUNT(msid) FROM `tab_phonecallbuss` ");
        sqllsit.append("  WHERE enterpriseid IS NOT NULL AND msid IS NOT NULL AND `status`=3 ");
        sqllsit.append("  AND calltime > date(NOW()) ");
        sqllsit.append("  GROUP BY msid ");
        return sqllsit;

    }

    @Scheduled(cron = "*/30 * * * * ?") // 任务刷新时限:不限年,月,日,时,每30秒触发一次
    public void execute() {
        //
        // try {
        //     synch.init();
        // }catch (Exception e){
        //     e.printStackTrace();
        // }
        // LOGGER.warn("------ 30s Spring+Quartz实现定时任务的配置方法 -----");
        // // loadTimeoutOrder();
        //
        // LOGGER.warn("----------检查优惠券是否有效----------");
        // // detectionCoupons();
        //
        // LOGGER.warn("----------优惠券扫描----------");
        // // distributingCoupons();
        //
        // LOGGER.warn("----------取消惩罚记录----------");
        // punishmentOrder();

    }

    /**
     * 查询超时电召单，超时电召单以短信形式发送给乘客
     */
    @SuppressWarnings("unchecked")
    public void loadTimeoutOrder() {
        //默认超时
        Integer Timeout = 30;
        LOGGER.warn("------loadTimeoutOrder---");

        CallBussDao callBussDao = SpringUtils.getBeanFactory().getBean(CallBussDao.class);

        List<CallbussTimeOutBean> callbussTimeOutBeanList = findList();

        //公司配置
        ClientSettingDao clientSettingDao = SpringUtils.getBeanFactory().getBean(ClientSettingDao.class);
        LOGGER.warn(callbussTimeOutBeanList);

        if (!S.isListNull(callbussTimeOutBeanList)) {
            for (CallbussTimeOutBean c : callbussTimeOutBeanList) {
                try {
                    //公司配置参数
                    ClientSetting clientSetting = clientSettingDao.get(c.getEnterpriseid());
                    if (!S.isNull(clientSetting)) {
                        //短信总数不为0
                        if (clientSetting.getMessagenum() > 0) {
                            LOGGER.warn("-------------  公司id：" + clientSetting.getClientId() + " 剩余短信数" + clientSetting
                                    .getMessagenum() + " 条, 设置超时时间为 " + clientSettingDao.get(c.getEnterpriseid())
                                    .getOrderovertime() + " 分钟----------------");
                            LOGGER.warn("-------------  短信ID：" + clientSetting.getSmsid() + " 短信KEY：" + clientSetting
                                    .getSmskey() + " ----------------");
                            LOGGER.warn(clientSettingDao.get(c.getEnterpriseid()).getOrderovertime());
                            if (c.getTimeoutnum() > clientSettingDao.get(c.getEnterpriseid()).getOrderovertime()) {
                                //发送短信 在测试环境关闭发短信
                                if (!S.isNull(clientSetting.getSmskey())) {
                                    LOGGER.warn(SmsSender.sendSms(c.getBillid(), c.getClientmobile(), clientSettingDao
                                            .get(c.getEnterpriseid())
                                            .getOrderovertime()
                                            .toString(), clientSetting.getSmscancelid(), clientSetting.getSmskey()));
                                } else {
                                    LOGGER.warn(" -----   短信ID 或 短信KEY 为空，重新设置   ------");
                                }
                                DetachedCriteria dc = DetachedCriteria.forClass(Callbuss.class);
                                dc.add(Restrictions.eq("billid", c.getBillid()));
                                Callbuss callbuss = callBussDao.findByDetachedCriteriaObj(dc);
                                if (!S.isNull(callbuss)) {
                                    //把取消当前电召单
                                    callbuss.setStatus(3);
                                    callBussDao.saveOrUpdate(callbuss);
                                    //写日志
                                    ClientSetting cs = clientSettingDao.get(c.getEnterpriseid());
                                    saveLogSms(c, cs.getOrderovertime(), cs.getSysname(), cs.getWeixinname());

                                    //当前公司短信数-1
                                    clientSetting.setMessagenum(clientSetting.getMessagenum() - 1);
                                    clientSettingDao.saveOrUpdate(clientSetting);
                                }
                            }
                        } else {
                            LOGGER.warn("----------公司id：" + clientSetting.getClientId() + " 短信已用完--------------------");
                            //取消电召单
                            if (c.getTimeoutnum() > clientSettingDao.get(c.getEnterpriseid()).getOrderovertime()) {
                                //发送短信
                                // LOGGER.warn(SmsSender.sendSms(c.getBillid(), c.getClientmobile(), clientSettingDao
                                //         .get(c.getEnterpriseid())
                                //         .getOrderovertime()
                                //         .toString(), SMS_ID, SMS_Key));
                                DetachedCriteria dc = DetachedCriteria.forClass(Callbuss.class);
                                dc.add(Restrictions.eq("billid", c.getBillid()));
                                Callbuss callbuss = callBussDao.findByDetachedCriteriaObj(dc);
                                if (!S.isNull(callbuss)) {
                                    //把取消当前电召单
                                    callbuss.setStatus(3);
                                    callBussDao.saveOrUpdate(callbuss);

                                }
                            }
                        }

                    } else {
                        //使用默认
                        LOGGER.warn("取消电召单");
                        LOGGER.warn("-------------   没有设置系统参数无法派发短信   ----------------");
                        //取消电召单
                        if (c.getTimeoutnum() > Timeout) {
                            DetachedCriteria dc = DetachedCriteria.forClass(Callbuss.class);
                            dc.add(Restrictions.eq("billid", c.getBillid()));
                            Callbuss callbuss = callBussDao.findByDetachedCriteriaObj(dc);
                            if (!S.isNull(callbuss)) {
                                //把取消当前电召单
                                callbuss.setStatus(3);
                                callBussDao.saveOrUpdate(callbuss);
                            }

                        }


                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 检查优惠券是否有效
     */
    public void detectionCoupons() {
        DiscountCouponDao discountCouponDao = SpringUtils.getBeanFactory().getBean(DiscountCouponDao.class);
        DetachedCriteria disdc = DetachedCriteria.forClass(DiscountCoupon.class);
        List<DiscountCoupon> discountCoupons = discountCouponDao.findByDetachedCriteria(disdc);

        for (DiscountCoupon d : discountCoupons) {

            if (S.belongCalendar(new Date(), d.getStarttime(), d.getEndtime())) {
                if (d.getIsvalid() != 0) {
                    d.setIsvalid(0);
                    discountCouponDao.saveOrUpdate(d);
                }
            } else {
                if (d.getIsvalid() != 1) {
                    d.setIsvalid(1);
                    discountCouponDao.saveOrUpdate(d);
                }
            }
        }
    }

    /**
     * 派发优惠券
     */
    public void distributingCoupons() {

        DiscountCouponDao discountCouponDao = SpringUtils.getBeanFactory().getBean(DiscountCouponDao.class);
        DiscountPassengerDao discountPassengerDao = SpringUtils.getBeanFactory().getBean(DiscountPassengerDao.class);

        LOGGER.warn("---------获取有效的优惠券---------");

        //获取有效的优惠券
        DetachedCriteria disdc = DetachedCriteria.forClass(DiscountCoupon.class);
        disdc.add(Restrictions.eq("isvalid", 0));
        List<DiscountCoupon> discountCoupons = discountCouponDao.findByDetachedCriteria(disdc);


        LOGGER.warn("---------分派都乘客---------");
        //分派都乘客
        if (!S.isListNull(discountCoupons) && discountCoupons.size() > 0) {
            int passnum = 0;
            for (DiscountCoupon d : discountCoupons) {

                LOGGER.warn("---------获取乘客---------");
                //获取乘客
                List<Passenger> passengerList = findPassengerList(d.getDaytype());
                if (!S.isListNull(passengerList) && passengerList.size() > 0) {
                    for (Passenger passenger : passengerList) {
                        DiscountPassenger dispasser = findChecke(d.getId(), passenger.getOpruser());
                        if (S.isNull(dispasser)) {
                            DiscountPassenger discountPassenger = new DiscountPassenger();
                            discountPassenger.setDiscid(d.getId());
                            discountPassenger.setOpruser(passenger.getOpruser());
                            discountPassenger.setIsreceive(0);
                            discountPassenger.setIsuse(0);
                            discountPassengerDao.save(discountPassenger);
                            passnum++;
                        }


                    }
                }


            }
            LOGGER.warn("---------------成功分派都乘客 " + passnum + " 张--------------");
        }


    }

    /**
     * 扫描所有取消电召单,写日志
     */
    public void punishmentOrder() {

        List<PunishmentBean> callbussPunishmentBeanList = findPunishmentList();

        //公司配置
        ClientSettingDao clientSettingDao = SpringUtils.getBeanFactory().getBean(ClientSettingDao.class);
        PunishmentLogDao punishmentLogDao = SpringUtils.getBeanFactory().getBean(PunishmentLogDao.class);
        //        DriverDao driverDao = SpringUtils.getBeanFactory().getBean(DriverDao.class);
        if (!S.isListNull(callbussPunishmentBeanList)) {
            for (PunishmentBean c : callbussPunishmentBeanList) {
                //公司配置参数
                ClientSetting clientSetting = clientSettingDao.get(c.getClientid());
                if (!S.isNull(clientSetting)) {
                    LOGGER.warn("取消次数---》" + c.getCancelnum());
                    LOGGER.warn("系统次数---》" + clientSetting.getDroporder());
                    Integer punnum = findPunishmentloglist(c);
                    LOGGER.warn("punnum---》" + punnum);
                    LOGGER.warn("  %---》" + c.getCancelnum() % clientSetting.getDroporder());
                    LOGGER.warn("  %---》" + (c.getCancelnum() % clientSetting.getDroporder() == 0));
                    LOGGER.warn("  /---》" + c.getCancelnum() / clientSetting.getDroporder());
                    LOGGER.warn("  /---》" + (c.getCancelnum() / clientSetting.getDroporder() > punnum));
                    if (punnum == 0) {
                        if (c.getCancelnum() % clientSetting.getDroporder() == 0) {
                            PunishmentLog punishmentLog = new PunishmentLog();
                            punishmentLog.setClientid(c.getClientid());
                            punishmentLog.setHandleDatetime(new Date());
                            punishmentLog.setKabnum(c.getKabnum());
                            punishmentLog.setMsid(c.getMsid());
                            punishmentLogDao.save(punishmentLog);

                            //设置当前司机无法接单或登录
                            LOGGER.warn("设置当前司机无法接单或登录");
                            //                            SetDriverPunishment(c.getMsid());
                        }
                    } else {
                        if ((c.getCancelnum() / clientSetting.getDroporder() > punnum && (c.getCancelnum() % clientSetting
                                .getDroporder() == 0))) {
                            PunishmentLog punishmentLog = new PunishmentLog();
                            punishmentLog.setClientid(c.getClientid());
                            punishmentLog.setHandleDatetime(new Date());
                            punishmentLog.setKabnum(c.getKabnum());
                            punishmentLog.setMsid(c.getMsid());
                            punishmentLogDao.save(punishmentLog);

                            //设置当前司机无法接单或登录
                            LOGGER.warn("设置当前司机无法接单或登录");
                            //                            SetDriverPunishment(c.getMsid());
                        }
                    }

                }

            }
        }
    }

    /**
     * 恢复禁止的司机账号
     */
    public void punishmentrecover() {


    }

    public boolean SetDriverPunishment(String msid) {
        DriverDao driverDao = SpringUtils.getBeanFactory().getBean(DriverDao.class);
        DetachedCriteria dc = DetachedCriteria.forClass(Driver.class);
        dc.add(Restrictions.eq("msid", msid));
        Driver driver = driverDao.findByDetachedCriteriaObj(dc);
        if (!S.isNull(driver)) {
            driver.setIsstop(1);
            driverDao.save(driver);
            return true;
        } else {
            return false;
        }

    }

    /**
     * 返回true
     *
     * @param punishment
     * @param clientSetting
     * @return
     */
    public boolean findPunishmentlogBean(Punishment punishment, ClientSetting clientSetting) {
        PunishmentLogDao punishmentLogDao = SpringUtils.getBeanFactory().getBean(PunishmentLogDao.class);
        DetachedCriteria dc = DetachedCriteria.forClass(PunishmentLog.class);
        dc.add(Restrictions.eq("msid", punishment.getMsid()));
        dc.addOrder(Order.desc("handleDatetime"));
        List<PunishmentLog> punishmentLogs = punishmentLogDao.findByDetachedCriteria(dc);
        PunishmentLog punishmentLog = punishmentLogs.get(0);
        if (System.currentTimeMillis() - punishmentLog.getHandleDatetime()
                .getTime() > (clientSetting.getWaitminute() * 60 * 1000)) {

        }

        return true;
    }

    /**
     * 返回true
     *
     * @param punishment
     * @return
     */
    public Integer findPunishmentloglist(PunishmentBean punishment) {
        PunishmentLogDao punishmentLogDao = SpringUtils.getBeanFactory().getBean(PunishmentLogDao.class);
        DetachedCriteria dc = DetachedCriteria.forClass(PunishmentLog.class);
        dc.add(Restrictions.eq("msid", punishment.getMsid()));
        dc.add(Restrictions.sqlRestriction(" handleDatetime > date(NOW()) "));
        dc.addOrder(Order.desc("handleDatetime"));
        List<PunishmentLog> punishmentLogs = punishmentLogDao.findByDetachedCriteria(dc);
        return punishmentLogs.size();
    }

    public List<Passenger> findPassengerList(Integer daytype) {
        PassengerDao passengerDao = SpringUtils.getBeanFactory().getBean(PassengerDao.class);
        DetachedCriteria passdc = DetachedCriteria.forClass(Passenger.class);
        List<Passenger> passengerList;
        if (daytype == 1) {
            String createdate = "2017-07-15 00:00:00";
            Date start = null;
            try {
                start = DateUtil.stringToDate(createdate, "yyyy-MM-dd HH:mm:ss");
            } catch (Exception e) {
                e.printStackTrace();
            }
            passdc.add(Restrictions.ge("createdate", start));
        } else {
            passdc.add(Restrictions.ne("opruser", ""));
        }
        passengerList = passengerDao.findByDetachedCriteria(passdc);

        return passengerList;
    }

    /**
     * 检查优惠券是否派送
     *
     * @param discid
     * @param opruser
     * @return
     */
    public DiscountPassenger findChecke(int discid, String opruser) {
        DiscountPassengerDao discountPassengerDao = SpringUtils.getBeanFactory().getBean(DiscountPassengerDao.class);
        DetachedCriteria passdc = DetachedCriteria.forClass(DiscountPassenger.class);
        passdc.add(Restrictions.eq("discid", discid));
        passdc.add(Restrictions.eq("opruser", opruser));
        DiscountPassenger discountPassenger = discountPassengerDao.findByDetachedCriteriaObj(passdc);
        return discountPassenger;
    }

    public DiscountPassenger findChecke(double discid, String opruser) {
        DiscountPassengerDao discountPassengerDao = SpringUtils.getBeanFactory().getBean(DiscountPassengerDao.class);
        DetachedCriteria passdc = DetachedCriteria.forClass(DiscountPassenger.class);
        passdc.add(Restrictions.eq("discid", discid));
        passdc.add(Restrictions.eq("opruser", opruser));
        DiscountPassenger discountPassenger = discountPassengerDao.findByDetachedCriteriaObj(passdc);
        return discountPassenger;
    }

    public List<PunishmentBean> findPunishmentList() {
        StringBuffer sqllsit = PunishmentCancal();
        CallBussDao callBussDao = SpringUtils.getBeanFactory().getBean(CallBussDao.class);
        List<Object[]> list = callBussDao.findListSql(String.valueOf(sqllsit));
        List<PunishmentBean> callBusslist = new ArrayList<PunishmentBean>();
        PunishmentBean callBean;
        for (Object[] objects : list) {
            callBean = new PunishmentBean();
            callBean.setClientid(objects[0] == null ? 0 : Integer.parseInt(objects[0].toString()));
            callBean.setMsid(objects[1] == null ? "" : objects[1].toString());
            callBean.setKabnum(objects[2] == null ? "" : objects[2].toString());
            callBean.setCancelnum(objects[3] == null ? 0 : Integer.parseInt(objects[3].toString()));
            callBusslist.add(callBean);
        }
        return callBusslist;

    }

    public List<CallbussTimeOutBean> findList() {
        StringBuffer sqllsit = CallBussTimeOUt();
        CallBussDao callBussDao = SpringUtils.getBeanFactory().getBean(CallBussDao.class);
        List<Object[]> list = callBussDao.findListSql(String.valueOf(sqllsit));
        List<CallbussTimeOutBean> callBusslist = new ArrayList<>();
        CallbussTimeOutBean callBean;
        for (Object[] objects : list) {
            callBean = new CallbussTimeOutBean();
            callBean.setBillid(objects[0] == null ? "" : objects[0].toString());
            callBean.setEnterpriseid(objects[1] == null ? 0 : Integer.parseInt(objects[1].toString()));
            callBean.setStatus(objects[2] == null ? 0 : Integer.parseInt(objects[2].toString()));
            callBean.setOpruser(objects[3] == null ? "" : objects[3].toString());
            try {
                callBean.setCalltime(objects[4] == null ? null : DateUtil.stringToDate(objects[4].toString(), "yyyy-MM-dd HH:mm:ss"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            callBean.setClientmobile(objects[5] == null ? "" : objects[5].toString());
            callBean.setOrderType(objects[6] == null ? 0 : Integer.parseInt(objects[6].toString()));
            callBean.setTimeoutnum(objects[7] == null ? 0 : Integer.parseInt(objects[7].toString()));
            callBusslist.add(callBean);
        }
        return callBusslist;

    }

    public void saveLogSms(CallbussTimeOutBean callbuss, Integer Timeout, String Systemname, String Weixinname) {
        if (S.isNull(Weixinname)) {
            Weixinname = Systemname;
        }
        LogSMSDiaryDao logSMSDiaryDao = SpringUtils.getBeanFactory().getBean(LogSMSDiaryDao.class);
        LogSMSDiary logSMSDiary = new LogSMSDiary();
        logSMSDiary.setPhone(callbuss.getClientmobile());
        logSMSDiary.setSendtime(new Date());
        //        logSMSDiary.setStatus((byte) 1);
        logSMSDiary.setContent("电召单号：" + callbuss.getBillid() + ",【" + Systemname + "】尊敬的乘客，您的订单在" + Timeout + "分钟内无司机接单,系统帮您自动取消,请重新下单。微信关注\"" + Weixinname + "\",让您叫车方便又轻松!");
        logSMSDiary.setClientid(callbuss.getEnterpriseid());
        logSMSDiaryDao.saveOrUpdate(logSMSDiary);
    }


}

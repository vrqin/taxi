package com.speedtalk.order.engine.threads;

import com.speedtalk.order.engine.*;
import com.speedtalk.order.engine.dao.BaseDao;
import com.speedtalk.order.engine.dao.OrderDao;
import com.speedtalk.order.engine.db.TabOrderTrack;
import com.speedtalk.order.engine.db.TabPhonecallbuss;
import com.speedtalk.order.engine.db.TabSendRecords;
import com.speedtalk.order.engine.kabs.KabInfo;
import com.speedtalk.order.engine.kabs.KabTeam;
import com.speedtalk.order.engine.setting.CompanySetting;
import com.speedtalk.order.engine.setting.Companys;
import com.speedtalk.protocol.order.OrderConstants;
import com.speedtalk.protocol.order.objs.NewOrder;
import com.speedtalk.protocol.utils.DateUtils;
import com.speedtalk.utils.ExcepPrinter;
import com.speedtalk.utils.LoadXmlConfig;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrderSender implements Runnable {
    private static final String NO_ORDER_TO_CARRY = "0";
    private static final String ORDER_TO_CARRY = "1";
    private OrderDao orderDao = new OrderDao();
    private BaseDao baseDao = new BaseDao();

    /**
     * 根据经纬度计算距离
     *
     * @param curr_lt 当前纬度
     * @param curr_lg 当前经度
     * @param last_lt 上一次纬度
     * @param last_lg 上一次经度
     * @return
     */
    public static double calDistance(double curr_lt, double curr_lg, double last_lt, double last_lg) {
        double x; //直解边长度
        double y; //直解边长度
        double nRet; //斜边长度
        double PI = 3.14159265;
        double R = 6.371229 * 1e6;
        x = (last_lg - curr_lg) * PI * R * Math.cos(((curr_lt + last_lt) / 2) * PI / 180) / 180;
        y = (last_lt - curr_lt) * PI * R / 180;

        nRet = Math.hypot(x, y); //计算一直角三角形的斜边长度
        return nRet;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            //			System.out.println(calDistance(22.604234d,114.052139d,
            //					23.169439d,113.42919d));
            double result = calDistance(22.604234d, 114.052139d, 23.169439d, 113.42919d);
        }
        System.out.println(System.currentTimeMillis() - start);

        //		List<DriverDistance> list = new ArrayList<DriverDistance>();
        //		KabInfo k1 = new KabInfo();
        //		k1.setAccount("k1");
        //		KabInfo k2 = new KabInfo();
        //		k2.setAccount("k2");
        //		KabInfo k3 = new KabInfo();
        //		k3.setAccount("k3");
        //		DriverDistance d1 = new DriverDistance(k1,1.1d);
        //		DriverDistance d2 = new DriverDistance(k2,1.2d);
        //		DriverDistance d3 = new DriverDistance(k3,1.3d);
        //		list.add(d3);
        //		list.add(d1);
        //		list.add(d2);
        //		System.out.println("before sort:" + list.toString());
        //		Collections.sort(list,new DistanceComparator());
        //		System.out.println("after sort:" + list.toString());
    }

    @Override
    public void run() {
        OrderLogger.log("OrderSender is running...");
        long sleep = 3000;
        double range = 3000d;
        String isOrderToCarry = ORDER_TO_CARRY;
        TabPhonecallbuss order = null;
        NewOrder newOrder = null;
        TabOrderTrack track = null;
        List<DriverDistance> list = null;
        StringBuilder buf = new StringBuilder(), carryBuf = new StringBuilder("\nCarry driver:");
        int i = 0, nearestCount = 5;
        TabSendRecords sendRecord = null;
        List<KabInfo> kabList = null;
        /**
         * 坐标类型,调用百度接口时使用(bd09ll（百度经纬度坐标）、bd09mc（百度摩卡托坐标）、
         * gcj02（国测局加密坐标）、wgs84（gps设备获取的坐标）)
         */
        String coordType = "bd09ll";
        List<KabInfo> seemlyList = new ArrayList<KabInfo>();
        while (true) {
            seemlyList.clear();
            try {
                try {
                    range = Double.parseDouble(LoadXmlConfig.getConfigHash().get("range")) * 1000;
                } catch (Exception e) {
                }
                try {
                    nearestCount = Integer.parseInt(LoadXmlConfig.getConfigHash().get("nearest-count"));
                } catch (Exception e) {
                }
                try {
                    isOrderToCarry = LoadXmlConfig.getConfigHash().get("is-order-to-carry");
                } catch (Exception e) {
                }
                if (LoadXmlConfig.getConfigHash().get("coord_type") != null)
                    coordType = LoadXmlConfig.getConfigHash().get("coord_type");

                order = Orders.getInstance().getNewOrder();
                if (order != null) {
                    buf.setLength(0);
                    i = 0;
                    list = new ArrayList<DriverDistance>();

                    if (null == order.getEnterpriseid())
                        kabList = KabTeam.getInstance().getOnlineKabs();
                    else
                        kabList = KabTeam.getInstance().getOnlineKabs(order.getEnterpriseid());

                    if (order.getMsid() != null && !order.getMsid().equals("")) {
                        try {
                            KabInfo info = KabTeam.getInstance().getKabByMsId(order.getMsid());
                            newOrder = new NewOrder(info.getAccount(), info.getName(), order.getClientmobile(), order.getSrcaddr(), String
                                    .valueOf(order.getSrclg()), String.valueOf(order.getSrclt()), order.getAddress(), String
                                    .valueOf(order.getLg()), String.valueOf(order.getLt()), DateUtils.getCommonTimeFormat()
                                    .format(order.getCalltime()), order.getRemark(), String.valueOf(order.getOrdertype()));
                            newOrder.setOrderNum(order.getBillid());
                            try {
                                info.getSession().write(newOrder);
                                buf.append(info.getAccount()).append(",指定司机派单!!!");
                                i++;
                                //								order.setStatus(OrderConstants.SENTED_ORDER);
                                sendRecord = new TabSendRecords(order.getBillid(), info.getAccount(), info.getLg(), info
                                        .getLt(), info.getCarry());
                                baseDao.save(sendRecord);
                            } catch (NullPointerException e) {
                            }
                        } catch (Exception e) {
                            ExcepPrinter.print(e);
                            OrderLogger.getLogger().debug(order.getBillid() + " 派发指定司机的电召单异常:" + order.getMsid());
                        }
                    } else {
                        String areaCode = parseAreaCode(order);
                        CompanySetting set = null;
                        try {
                            set = Companys.getInstance().getSettingByAreaCode(areaCode);
                            range = set.getDistance();
                        } catch (Exception e) {
                        }
                        OrderLogger.getLogger().debug(order.getBillid() + ",range:" + range + ",areaCode:" + areaCode);

                        //获取司机派单
                        for (KabInfo info : kabList) {
                            int matrixDis = 1000000;
                            try {
                                if (NO_ORDER_TO_CARRY.equals(isOrderToCarry) && KabTeam.CARRY == info.getCarry()) {
                                    carryBuf.append(info.getAccount()).append(",");
                                    continue;
                                }
                                if (info.getRemain() <= 0)
                                    continue;
                                if (!info.isCanAcceptOrder())
                                    continue;
                                if (order.getOrdertype() == OrderConstants.VOICE_ORDER) {
                                    //									newOrder = new NewOrder(info.getAccount(),info.getName(),
                                    //											order.getClientmobile(),order.getSrcaddr(),
                                    //											String.valueOf(order.getSrclg()),String.valueOf(order.getSrclt()),
                                    //											order.getAddress(),String.valueOf(order.getLg()),
                                    //											String.valueOf(order.getLt()),DateUtils.getCommonTimeFormat().format(order.getCalltime()),
                                    //											order.getRemark(),String.valueOf(order.getOrdertype()));
                                    //									newOrder.setOrderNum(order.getBillid());
                                    //									try
                                    //									{
                                    ////										info.getSession().write(newOrder);
                                    ////										buf.append(info.getAccount()).append(",");
                                    ////										i++;
                                    ////										order.setStatus(OrderConstants.SENTED_ORDER);
                                    ////										sendRecord = new TabSendRecords(order.getBillid(),info.getAccount(),info.getLg(),info.getLt(),info.getCarry());
                                    ////										baseDao.save(sendRecord);
                                    seemlyList.add(info);
                                    //									}
                                    //									catch(NullPointerException e){}
                                } else {
                                    double distance = calDistance(order.getSrclt(), order.getSrclg(), info.getLt(), info
                                            .getLg());
                                    list.add(new DriverDistance(info, distance));
                                    if (distance <= range * 1.5)    //先过滤直线距离=（配置距离的1.5倍）
                                    {
                                        try {
                                            /**
                                             * 调用百度接口计算路程，
                                             * 主要是通过坐标来计算，所以城市名称都用广州
                                             */
                                            matrixDis = RouteMatrixRequester.getInstance()
                                                    .getDircetionDis("广州", "广州", order.getSrclt(), order.getSrclg(), info
                                                            .getLt(), info.getLg(), coordType);
                                            OrderLogger.getLogger()
                                                    .debug(order.getBillid() + "," + info.getAccount() + ",Baidu API distance:" + matrixDis);
                                            if (matrixDis <= range) {
                                                //												newOrder = new NewOrder(info.getAccount(),info.getName(),
                                                //														order.getClientmobile(),order.getSrcaddr(),
                                                //														String.valueOf(order.getSrclg()),String.valueOf(order.getSrclt()),
                                                //														order.getAddress(),String.valueOf(order.getLg()),
                                                //														String.valueOf(order.getLt()),DateUtils.getCommonTimeFormat().format(order.getCalltime()),
                                                //														order.getRemark(),String.valueOf(order.getOrdertype()));
                                                //												newOrder.setOrderNum(order.getBillid());
                                                //												try
                                                //												{
                                                ////													info.getSession().write(newOrder);
                                                ////													buf.append(info.getAccount()).append(",");
                                                ////													i++;
                                                ////													order.setStatus(OrderConstants.SENTED_ORDER);
                                                ////													sendRecord = new TabSendRecords(order.getBillid(),info.getAccount(),info.getLg(),info.getLt(),info.getCarry());
                                                ////													baseDao.save(sendRecord);
                                                seemlyList.add(info);
                                                //												}
                                                //												catch(NullPointerException e){}
                                            }
                                        } catch (IOException ioe) {
                                            ExcepPrinter.print(ioe);
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                ExcepPrinter.print(e);
                            }
                        }
                    }
                    for (KabInfo kabInfo : seemlyList) {
                        newOrder = new NewOrder(kabInfo.getAccount(), kabInfo.getName(), order.getClientmobile(), order.getSrcaddr(), String
                                .valueOf(order.getSrclg()), String.valueOf(order.getSrclt()), order.getAddress(), String
                                .valueOf(order.getLg()), String.valueOf(order.getLt()), DateUtils.getCommonTimeFormat()
                                .format(order.getCalltime()), order.getRemark(), String.valueOf(order.getOrdertype()));
                        newOrder.setOrderNum(order.getBillid());
                        try {
                            kabInfo.getSession().write(newOrder);
                            buf.append(kabInfo.getAccount()).append(",");
                            i++;
                            order.setStatus(OrderConstants.SENTED_ORDER);
                            sendRecord = new TabSendRecords(order.getBillid(), kabInfo.getAccount(), kabInfo.getLg(), kabInfo
                                    .getLt(), kabInfo.getCarry());
                            baseDao.save(sendRecord);
                        } catch (Exception e) {
                        }
                    }
                    OrderLogger.getLogger()
                            .debug(null == newOrder ? order.getBillid() : newOrder.toString() + "-->>" + i + "==:" + buf
                                    .toString());
                    if (0 == i) {
                        Orders.getInstance().addWaitingOrder(order);
                        OrderLogger.getLogger().debug(order.getBillid() + " waiting...");
                    } else {
                        orderDao.update(order);
                        track = new TabOrderTrack("sys", order.getBillid(), OrderConstants.ORDER_TRACK_SEDT, new Timestamp(System
                                .currentTimeMillis()));
                        baseDao.save(track);
                        Orders.getInstance().removeWaitOrder(order);

                        OrderSentRecorder.getInstance().addRecord(order.getBillid(), buf.toString());
                    }
                }
                sleep = Integer.parseInt(LoadXmlConfig.getConfigHash().get("send-order-sleep"));
            } catch (Exception e) {
                ExcepPrinter.print(e);
            }
            try {
                Thread.sleep(sleep);
            } catch (Exception e) {
            }
        }
    }

    private String parseAreaCode(TabPhonecallbuss order) {
        if (null == order)
            return null;
        else {
            String resp = RouteMatrixRequester.getInstance().getGeocoding(null, order.getSrclt(), order.getSrclg());
            try {
                return RouteMatrixRequester.getInstance().parseAreaFromGeocodingAPI(resp);
            } catch (Exception e) {
                return null;
            }
        }
    }

    static class DistanceComparator implements Comparator<DriverDistance> {
        @Override
        public int compare(DriverDistance o1, DriverDistance o2) {
            return new Double(o1.getDistance()).compareTo(new Double(o2.getDistance()));
        }
    }
}

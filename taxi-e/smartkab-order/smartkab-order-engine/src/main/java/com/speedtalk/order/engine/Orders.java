package com.speedtalk.order.engine;

import com.speedtalk.order.engine.dao.BaseDao;
import com.speedtalk.order.engine.dao.DriverDao;
import com.speedtalk.order.engine.dao.OrderDao;
import com.speedtalk.order.engine.db.TabDriver;
import com.speedtalk.order.engine.db.TabOrderTrack;
import com.speedtalk.order.engine.db.TabPhonecallbuss;
import com.speedtalk.protocol.order.OrderConstants;
import com.speedtalk.protocol.order.objs.Order;
import com.speedtalk.utils.ExcepPrinter;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public class Orders {
    public static final int SECONDS = 3600;    //one hour
    private static Orders instance = new Orders();
    private LinkedList<TabPhonecallbuss> unfinished;
    /**
     * 保存第一次派发没有司机的电召单
     */
    private ConcurrentHashMap<String, WaitOrder> waitOrderMap;
    private OrderDao orderDao;
    private DriverDao driverDao;
    private BaseDao baseDao;

    private Orders() {
        unfinished = new LinkedList<>();
        waitOrderMap = new ConcurrentHashMap<>();
        orderDao = new OrderDao();
        driverDao = new DriverDao();
        baseDao = new BaseDao();
    }

    public static Orders getInstance() {
        if (null == instance)
            instance = new Orders();
        return instance;
    }

    public TabPhonecallbuss getNewOrder() {
        TabPhonecallbuss order = unfinished.poll();
        return order;
    }

    public boolean putNewOrder(TabPhonecallbuss order) {
        return unfinished.offer(order);
    }

    public int setUnfinishedOrder(LinkedList<TabPhonecallbuss> list) {
        unfinished = list;
        return null == unfinished ? 0 : unfinished.size();
    }

    public ConcurrentHashMap<String, WaitOrder> getWaitOrderMap() {
        return new ConcurrentHashMap<>(waitOrderMap);
    }

    public boolean putWaitingOrder(TabPhonecallbuss order) {
        return unfinished.offerFirst(order);
    }

    public WaitOrder addWaitingOrder(TabPhonecallbuss order) {
        if (null == order)
            return null;
        WaitOrder waitOrder = waitOrderMap.get(order.getBillid());
        if (null == waitOrder) {
            waitOrder = new WaitOrder(order);
            waitOrderMap.put(order.getBillid(), waitOrder);
        } else
            waitOrder.setFindDriverTime(System.currentTimeMillis());
        return waitOrder;
    }

    public void removeWaitOrder(WaitOrder waitOrder) {
        waitOrderMap.remove(waitOrder.getTbOrder().getBillid());
    }

    public void removeWaitOrder(TabPhonecallbuss order) {
        waitOrderMap.remove(order.getBillid());
    }

    /**
     * 抢单
     *
     * @param acceptOrder
     * @return
     * @throws NullPointerException
     */
    public synchronized boolean acceptOrder(Order acceptOrder) throws NullPointerException {
        if (null == acceptOrder)
            throw new NullPointerException("Order info is null!");
        TabDriver driver = driverDao.getByAccount(acceptOrder.getSrcMsID());
        if (null == driver) {
            OrderLogger.getLogger().debug("account error!" + acceptOrder.getSrcMsID());
            throw new NullPointerException("account error!" + acceptOrder.getSrcMsID());
        }
        TabPhonecallbuss order = orderDao.getOrder(acceptOrder.getOrderNum());
        try {
            OrderLogger.getLogger().debug(order.toString());
        } catch (Exception e) {
        }
        try {
            if (order.getStatus() < OrderConstants.ACCEPTED_ORDER) {
                order.setStatus(OrderConstants.ACCEPTED_ORDER);
                order.setCarbox(driver.getKabnum());
                order.setMsid(driver.getMsid());

                order.setEnterpriseid(driver.getClientId());

                orderDao.update(order);

                TabOrderTrack track = new TabOrderTrack(acceptOrder.getSrcMsID(), order.getBillid(), OrderConstants.ORDER_TRACK_ACCEPTED, new Timestamp(System
                        .currentTimeMillis()));
                baseDao.save(track);
                OrderLogger.getLogger()
                        .debug(acceptOrder.toString() + " accept order!" + driver.getAccount() + "," + driver.getMsid() + driver
                                .getKabnum());
                return true;
            } else
                return false;
        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
        return false;
    }

    class WaitOrder {
        private TabPhonecallbuss tbOrder;
        private long firstWaitTime;        //开始等待时间
        private long findDriverTime;    //最后一次查找司机的时间

        public WaitOrder(TabPhonecallbuss tbOrder) {
            super();
            long currentTime = System.currentTimeMillis();
            this.tbOrder = tbOrder;
            this.firstWaitTime = currentTime;
            this.findDriverTime = currentTime;
        }

        public long getFindDriverTime() {
            return findDriverTime;
        }

        public void setFindDriverTime(long findDriverTime) {
            this.findDriverTime = findDriverTime;
        }

        public TabPhonecallbuss getTbOrder() {
            return tbOrder;
        }

        public long getFirstWaitTime() {
            return firstWaitTime;
        }
    }
}

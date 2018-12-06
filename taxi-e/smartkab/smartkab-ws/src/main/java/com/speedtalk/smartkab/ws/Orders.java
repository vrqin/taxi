package com.speedtalk.smartkab.ws;

import com.speedtalk.smartkab.ws.dao.OrderTempDao;
import com.speedtalk.smartkab.ws.db.TabPhonecallbuss;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public class Orders {
    private static final int SECONDS = 3600;    //one hour
    private static Orders instance = new Orders();
    private LinkedList<TabPhonecallbuss> unfinished;
    private ConcurrentHashMap<String, TabPhonecallbuss> handling;
    private OrderTempDao tempDao;

    //	private OrderDao dao;
    private Orders() {
        unfinished = new LinkedList<>();
        handling = new ConcurrentHashMap<>();
        tempDao = new OrderTempDao();
        //		dao = new OrderDao();
    }

    public static Orders getInstance() {
        if (null == instance)
            instance = new Orders();
        return instance;
    }

    public void loadOrder() {
        LinkedHashMap<String, TabPhonecallbuss> tempMap = (LinkedHashMap<String, TabPhonecallbuss>) tempDao.getUnfinishedOrder(SECONDS);
        for (TabPhonecallbuss order : tempMap.values()) {
            try {
                if (Constants.NEW_ORDER.byteValue() == order.getStatus()) {
                    unfinished.offer(order);
                    System.out.println(Utils.getLogFix() + order.getBillid() + "--" + Utils.getCommonsdf()
                            .format(order.getCalltime()));
                } else if (Constants.DROPPED_ORDER.byteValue() == order.getStatus() || Constants.FINISHED_ORDER.byteValue() == order
                        .getStatus()) {
                    tempDao.deleteOrder(order.getBillid());
                } else {
                    handling.put(order.getBillid(), order);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(Utils.getLogFix() + "Load order finished! New order:" + unfinished.size() + ",handling order:" + handling
                .size());
    }

    public TabPhonecallbuss getOrder() {
        return unfinished.poll();
    }

    public boolean putOrder(TabPhonecallbuss order) {
        return unfinished.offer(order);
    }

    public boolean finishOrder(TabPhonecallbuss order) {
        try {
            Object obj = handling.remove(order.getBillid());
            return (null != obj);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean dropOrder(TabPhonecallbuss order) {
        return finishOrder(order);
    }
}

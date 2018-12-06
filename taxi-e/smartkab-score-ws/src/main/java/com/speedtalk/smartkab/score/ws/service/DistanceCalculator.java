package com.speedtalk.smartkab.score.ws.service;

import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.order.objs.Order;
import com.speedtalk.smartkab.score.ws.ICalculator;
import com.speedtalk.smartkab.score.ws.dao.BaseDao;
import com.speedtalk.smartkab.score.ws.db.TabDriverScore;
import com.speedtalk.smartkab.score.ws.db.TabPhonecallbuss;

import java.util.logging.Logger;

public class DistanceCalculator implements ICalculator {
    private Logger log = Logger.getLogger(DistanceCalculator.class.getName());
    private BaseDao baseDao = new BaseDao();

    public static void main(String[] args) {
        int score = 0;
        int distance = 1000;
        score = distance / 1000 * 2;
        if (distance % 1000 > 0)
            ++score;
        System.out.println(score);
    }

    @Override
    public void cal(TSCObject obj) {
        Order order = null;
        try {
            order = (Order) obj;
        } catch (Exception e) {
            e.printStackTrace();
            log.info("*** Occured exception when cal score by distance!");
            return;
        }
        TabPhonecallbuss tbOrder = (TabPhonecallbuss) baseDao.get(TabPhonecallbuss.class, order.getOrderNum());
        /**
         * 计算积分：1公里=2积分，不足1公里算1积分
         */
        int score = 2;
        int distance = 0;
        try {
            if (tbOrder.getSrclt() != null && tbOrder.getSrclg() != null && tbOrder.getLt() != null && tbOrder.getLt() > 0 && tbOrder
                    .getLg() != null && tbOrder.getLg() > 0) {
                String resp = RouteMatrixRequester.getInstance()
                        .getRouteMatrix(tbOrder.getSrclt(), tbOrder.getSrclg(), tbOrder.getLt(), tbOrder.getLg());
                try {
                    distance = RouteMatrixRequester.getInstance().parseRouteMatrixDistance(resp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info("incorrect orderId!" + order.getOrderNum());
            return;
        }
        if (distance > 0) {
            score = distance / 1000 * 2;
            if (distance % 1000 > 0)
                ++score;
        }
        if (score > 0) {
            TabDriverScore driverScore = ScoreUpdater.updateDriverScore(tbOrder, score);
            ScoreUpdater.saveDriverScoreRecord(driverScore.getAccount(), tbOrder.getBillid(), score, "完成订单！+" + score + "积分");
            ScoreUpdater.updatePasserScore(tbOrder, score);
            ScoreUpdater.savePasserScoreRecord(tbOrder.getCallnumber(), tbOrder.getBillid(), score, "完成订单！+" + score + "积分");
        }
        log.info(order.getOrderNum() + " distance " + distance + " score " + score);
    }
}

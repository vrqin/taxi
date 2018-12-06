package com.speedtalk.smartkab.score.ws.service;

import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.order.objs.PayInfo;
import com.speedtalk.smartkab.score.ws.ICalculator;
import com.speedtalk.smartkab.score.ws.dao.BaseDao;
import com.speedtalk.smartkab.score.ws.db.TabDriverScore;
import com.speedtalk.smartkab.score.ws.db.TabPhonecallbuss;

import java.util.logging.Logger;

public class MoneyCalculator implements ICalculator {
    private Logger log = Logger.getLogger(MoneyCalculator.class.getName());
    private BaseDao baseDao = new BaseDao();

    @Override
    public void cal(TSCObject obj) {
        PayInfo payInfo;
        try {
            payInfo = (PayInfo) obj;
        } catch (Exception e) {
            e.printStackTrace();
            log.info("*** Occured exception when cal score by money!");
            return;
        }
        TabPhonecallbuss tbOrder = (TabPhonecallbuss) baseDao.get(TabPhonecallbuss.class, payInfo.getOrderNum());
        float money = 0f;
        int score = 2;
        try {
            money = tbOrder.getMoney();
        } catch (NullPointerException npe) {
            log.info("incorrect orderId!" + payInfo.getOrderNum());
            return;
        }
        /**
         * 计算积分：1元=1积分，不足1元算1积分
         */
        if (money > 0) {
            score = (int) money;
            if (money - score > 0)
                ++score;
        }
        if (score > 0) {
            TabDriverScore driverScore = ScoreUpdater.updateDriverScore(tbOrder, score);
            ScoreUpdater.saveDriverScoreRecord(driverScore.getAccount(), tbOrder.getBillid(), score, "完成订单！+" + score + "积分");
            ScoreUpdater.updatePasserScore(tbOrder, score);
            ScoreUpdater.savePasserScoreRecord(tbOrder.getCallnumber(), tbOrder.getBillid(), score, "完成订单！+" + score + "积分");
        }
        log.info(payInfo.getOrderNum() + " money " + money + " score " + score);
    }
}

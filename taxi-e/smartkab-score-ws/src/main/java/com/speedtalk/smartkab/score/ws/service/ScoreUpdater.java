package com.speedtalk.smartkab.score.ws.service;

import com.speedtalk.smartkab.score.ws.dao.BaseDao;
import com.speedtalk.smartkab.score.ws.dao.DriverDao;
import com.speedtalk.smartkab.score.ws.dao.DriverScoreDao;
import com.speedtalk.smartkab.score.ws.dao.PassengerScoreDao;
import com.speedtalk.smartkab.score.ws.db.*;

import java.util.logging.Logger;

public class ScoreUpdater {
    private static final Short DRIVER = 0;
    private static final Short PASSER = 1;
    private static Logger log = Logger.getLogger(ScoreUpdater.class.getName());
    private static BaseDao baseDao = new BaseDao();
    private static DriverScoreDao driverScoreDao = new DriverScoreDao();
    private static PassengerScoreDao passerScoreDao = new PassengerScoreDao();
    private static DriverDao driverDao = new DriverDao();

    public static TabDriverScore updateDriverScore(TabPhonecallbuss order, int score) throws NullPointerException {
        if (null == order)
            throw new NullPointerException("order is null!");
        TabDriver driver = driverDao.getByMsId(order.getMsid());
        TabDriverScore driverScore = null;
        try {
            driverScore = driverScoreDao.getByAccount(driver.getAccount());
        } catch (NullPointerException npe) {
            log.info(order.getBillid() + "'s msid error!" + order.getMsid());
            return driverScore;
        }

        try {
            int oldScore = driverScore.getScore();
            driverScore.setScore(oldScore + score);
            baseDao.update(driverScore);
            log.info(driverScore.getAccount() + " update score from order " + order.getBillid() + "--" + oldScore + " ->" + driverScore
                    .getScore());
        } catch (NullPointerException npe) {
            driverScore = new TabDriverScore(driver.getAccount(), score);
            baseDao.save(driverScore);
            log.info(driverScore.getAccount() + " save score from order " + order.getBillid() + " ->" + driverScore.getScore());
        }
        return driverScore;
    }

    public static void saveDriverScoreRecord(String account, String orderNum, int score, String remark)
            throws NullPointerException {
        if (null == account || account.trim().equals(""))
            throw new NullPointerException("account is null");
        if (null == orderNum || orderNum.trim().equals(""))
            throw new NullPointerException("orderNum is null");

        saveScoreRecord(account, DRIVER, orderNum, score, remark);
    }

    public static void savePasserScoreRecord(String account, String orderNum, int score, String remark)
            throws NullPointerException {
        if (null == account || account.trim().equals(""))
            throw new NullPointerException("account is null");
        if (null == orderNum || orderNum.trim().equals(""))
            throw new NullPointerException("orderNum is null");

        saveScoreRecord(account, PASSER, orderNum, score, remark);
    }

    private static void saveScoreRecord(String account, short type, String orderNum, int score, String remark) {
        TabScoreRecords records = new TabScoreRecords(account, type, orderNum, score, remark);
        baseDao.save(records);
    }

    public static TabPassengerScore updatePasserScore(TabPhonecallbuss order, int score) throws NullPointerException {
        if (null == order)
            throw new NullPointerException("order is null!");
        TabPassengerScore passerScore = null;
        try {
            passerScore = passerScoreDao.getByAccount(order.getCallnumber());
        } catch (NullPointerException npe) {
            log.info(order.getBillid() + "'s passer error!" + order.getCallnumber());
            return passerScore;
        }

        try {
            int oldScore = passerScore.getScore();
            passerScore.setScore(oldScore + score);
            baseDao.update(passerScore);
            log.info(passerScore.getAccount() + " update score from order " + order.getBillid() + "--" + oldScore + " ->" + passerScore
                    .getScore());
        } catch (NullPointerException npe) {
            passerScore = new TabPassengerScore(order.getCallnumber(), score);
            baseDao.save(passerScore);
            log.info(passerScore.getAccount() + " save score from order " + order.getBillid() + " ->" + passerScore.getScore());
        }
        return passerScore;
    }
}

package com.speedtalk.smartkab.ws;

import com.speedtalk.smartkab.ws.dao.BaseDao;
import com.speedtalk.smartkab.ws.db.TabStatusremark;

public class DbConnKeeper implements Runnable {
    private static final long SLEEP_TIME = 3600000;
    private final BaseDao baseDao = new BaseDao();

    @Override
    public void run() {
        // FeedbackDao dao = new FeedbackDao();
        TabStatusremark status;
        while (true) {
            try {
                status = (TabStatusremark) baseDao.get(TabStatusremark.class, 0);
                baseDao.update(status);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(SLEEP_TIME);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

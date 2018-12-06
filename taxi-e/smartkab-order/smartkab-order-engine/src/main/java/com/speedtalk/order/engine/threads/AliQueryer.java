package com.speedtalk.order.engine.threads;

import com.alipay.api.response.AlipayTradeQueryResponse;
import com.speedtalk.order.engine.OrderLogger;
import com.speedtalk.order.engine.dao.BaseDao;
import com.speedtalk.order.engine.db.TabPayrecords;
import com.speedtalk.order.engine.kabs.KabInfo;
import com.speedtalk.order.engine.kabs.KabTeam;
import com.speedtalk.order.engine.pay.AliQuery;
import com.speedtalk.protocol.order.OrderMessConstants;
import com.speedtalk.protocol.order.objs.PayInfo;
import com.speedtalk.protocol.order.objs.PayResult;
import com.speedtalk.utils.ExcepPrinter;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AliQueryer implements Runnable {
    private static AliQueryer instance = new AliQueryer();
    private BaseDao baseDao = new BaseDao();
    private Map<String, PayInfo> queryMap;

    private AliQueryer() {
        queryMap = new ConcurrentHashMap<String, PayInfo>();
    }

    //	public static AliQueryer getInstance()
    //	{
    //		if(null == instance)
    //			instance = new AliQueryer();
    //		return instance;
    //	}
    public void addQuery(PayInfo payInfo) {
        queryMap.put(payInfo.getOrderNum(), payInfo);
    }

    @Override
    public void run() {
        OrderLogger.getLogger().debug("AliQueryer is running...");
        PayInfo payInfo = null;
        PayResult payResult = null;
        String orderNum = null;
        AlipayTradeQueryResponse resp = null;
        KabInfo kabInfo = null;
        TabPayrecords payrecords = null;
        while (true) {
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
            }
            for (Iterator<String> ite = queryMap.keySet().iterator(); ite.hasNext(); ) {
                try {
                    orderNum = ite.next();
                    payInfo = queryMap.get(orderNum);
                    if (payInfo.getPayType() == OrderMessConstants.ALIPAY_PAY) {
                        resp = AliQuery.query(orderNum);
                        if (resp != null && resp.getCode().equals("10000") && resp.getTradeStatus()
                                .equalsIgnoreCase("TRADE_SUCCESS")) {
                            payResult = new PayResult(payInfo.getSrcMsID(), payInfo.getMsName(), orderNum, payInfo.getPayType(), "success");
                            kabInfo = KabTeam.getInstance().getKab(payInfo.getSrcMsID());
                            kabInfo.getSession().write(payResult);
                            OrderLogger.getLogger()
                                    .debug(payResult.toString() + "--" + kabInfo.getSession().getRemoteAddress());
                            queryMap.remove(orderNum);
                            payrecords = (TabPayrecords) baseDao.get(TabPayrecords.class, payInfo.getOrderNum());
                            try {
                                payrecords.setPaytype((int) OrderMessConstants.ALIPAY_PAY);
                                payrecords.setPaytime(new Timestamp(System.currentTimeMillis()));
                                baseDao.update(payrecords);
                            } catch (Exception e) {
                                ExcepPrinter.print(e);
                            }
                        }
                    } else if (payInfo.getPayType() == OrderMessConstants.WECHAT_PAY) {
                        //待处理
                    }
                } catch (Exception e) {
                    ExcepPrinter.print(e);
                }
            }
        }
    }
}

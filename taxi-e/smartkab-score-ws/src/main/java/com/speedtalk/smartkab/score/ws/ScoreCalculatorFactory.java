package com.speedtalk.smartkab.score.ws;

import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.order.objs.Order;
import com.speedtalk.protocol.order.objs.PayInfo;
import com.speedtalk.smartkab.score.ws.service.DefaultCalculator;
import com.speedtalk.smartkab.score.ws.service.DistanceCalculator;
import com.speedtalk.smartkab.score.ws.service.MoneyCalculator;


public class ScoreCalculatorFactory {
    private static ScoreCalculatorFactory instance = new ScoreCalculatorFactory();
    private DefaultCalculator defaultCalculator;
    private MoneyCalculator moneyCalculator;
    private DistanceCalculator distanceCalculator;

    private ScoreCalculatorFactory() {
        defaultCalculator = new DefaultCalculator();
        moneyCalculator = new MoneyCalculator();
        distanceCalculator = new DistanceCalculator();
    }

    public static ScoreCalculatorFactory getInstance() {
        if (null == instance)
            instance = new ScoreCalculatorFactory();
        return instance;
    }

    public ICalculator getCalculator(TSCObject obj) {
        if (null == obj)
            return defaultCalculator;
        else if (obj instanceof PayInfo)
            return moneyCalculator;
        else if (obj instanceof Order)
            return distanceCalculator;
        else
            return defaultCalculator;
    }
}

package com.speedtalk.smartkab.score.ws.service;

import com.speedtalk.protocol.TSCObject;
import com.speedtalk.smartkab.score.ws.ICalculator;

public class DefaultCalculator implements ICalculator {
    @Override
    public void cal(TSCObject obj) {
        if (null == obj) {
            System.out.println("cal obj is null!");
            return;
        }
        System.out.println("unsupported cal type!" + obj.toString());
    }
}

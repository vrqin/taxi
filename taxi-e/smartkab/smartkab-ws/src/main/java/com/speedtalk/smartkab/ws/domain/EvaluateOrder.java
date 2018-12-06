package com.speedtalk.smartkab.ws.domain;

public class EvaluateOrder extends DropOrder {
    private byte evaluate;

    public EvaluateOrder() {
        super();
    }

    public byte getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(byte evaluate) {
        this.evaluate = evaluate;
    }
}

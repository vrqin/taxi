package com.speedtalk.protocol.order.objs;

import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.exceptions.CheckMistakenException;
import com.speedtalk.protocol.exceptions.MessageMistakenException;
import com.speedtalk.protocol.order.OrderMessConstants;
import com.speedtalk.protocol.tscobjs.SMS;

import java.util.List;

public class PayResult extends Order {
    private byte payType;
    private String result;

    public PayResult() {
        super();
        this.setOrderMessId(OrderMessConstants.PAY_RESULT);
    }

    public PayResult(String account, String name, String orderNum, byte payType, String result) {
        super(account, name, OrderMessConstants.PAY_RESULT, orderNum);
        this.payType = payType;
        this.result = result;
    }

    public byte getPayType() {
        return payType;
    }

    public void setPayType(byte payType) {
        this.payType = payType;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "PayResult [payType=" + payType + ", result=" + result + ", getOrderNum()=" + getOrderNum() + ", getOrderMessId()=" + getOrderMessId() + ", getBody()=" + getBody() + ", getContent()=" + getContent() + "]";
    }

    @Override
    public List<byte[]> objToBytes() throws NullPointerException, MessageMistakenException {
        setBody(payType + OrderMessConstants.SPEPERATOR + result);
        return super.objToBytes();
    }

    @Override
    public TSCObject bytesToObj(byte[] datas)
            throws NullPointerException, CheckMistakenException, MessageMistakenException {
        try {
            Order order = (Order) super.bytesToObj(datas);
            String[] params = order.getBody().split(OrderMessConstants.SPLITTER);

            this.setMessID(order.getMessID());
            this.setMessNo(order.getMessNo());
            this.setSrcMsID(order.getSrcMsID());
            this.setDstMsID(order.getDstMsID());
            this.setContent(order.getContent());
            this.setOrderMessId(params[1]);
            this.setOrderNum(params[2]);
            this.setPayType(Byte.parseByte(params[3]));
            this.setResult(params[4]);
        } catch (Exception e) {
            try {
                throw e;
            } catch (Exception e1) {
            }
        }
        return this;
    }

    @Override
    public OrderMess toOrderMess(SMS sms) throws Exception {
        try {
            String[] params = sms.getContent().split(OrderMessConstants.SPLITTER);

            this.setMessID(sms.getMessID());
            this.setMessNo(sms.getMessNo());
            this.setSrcMsID(sms.getSrcMsID());
            this.setDstMsID(sms.getDstMsID());
            this.setMsName(sms.getMsName());
            this.setBody(sms.getContent());
            this.setContent(sms.getContent());
            this.setTime(sms.getTime());
            this.setOrderMessId(params[1]);
            this.setOrderNum(params[2]);
            this.setPayType(Byte.parseByte(params[3]));
            this.setResult(params[4]);
        } catch (Exception e) {
            throw e;
        }
        return this;
    }
}

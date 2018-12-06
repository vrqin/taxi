package com.speedtalk.protocol.order.objs;

import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.exceptions.CheckMistakenException;
import com.speedtalk.protocol.exceptions.MessageMistakenException;
import com.speedtalk.protocol.order.OrderMessConstants;
import com.speedtalk.protocol.tscobjs.SMS;

import java.util.List;

public class PayInfo extends Order {
    private byte payType;
    private String getOnTime;
    private String getOffTime;
    private String mileage;
    private String uselessMileage;
    private String extraMoney;
    private String waitTime;
    private String money;

    public PayInfo() {
        super();
        this.setOrderMessId(OrderMessConstants.PAY_INFO);
    }

    public PayInfo(String account, String name, byte payType, String orderNum, String getOnTime, String getOffTime, String mileage, String uselessMileage, String extraMoney, String waitTime, String money) {
        super(account, name, OrderMessConstants.PAY_INFO, orderNum);
        this.payType = payType;
        this.getOnTime = getOnTime;
        this.getOffTime = getOffTime;
        this.mileage = mileage;
        this.uselessMileage = uselessMileage;
        this.extraMoney = extraMoney;
        this.waitTime = waitTime;
        this.money = money;
    }

    public byte getPayType() {
        return payType;
    }

    public void setPayType(byte payType) {
        this.payType = payType;
    }

    public String getGetOnTime() {
        return getOnTime;
    }

    public void setGetOnTime(String getOnTime) {
        this.getOnTime = getOnTime;
    }

    public String getGetOffTime() {
        return getOffTime;
    }

    public void setGetOffTime(String getOffTime) {
        this.getOffTime = getOffTime;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getUselessMileage() {
        return uselessMileage;
    }

    public void setUselessMileage(String uselessMileage) {
        this.uselessMileage = uselessMileage;
    }

    public String getExtraMoney() {
        return extraMoney;
    }

    public void setExtraMoney(String extraMoney) {
        this.extraMoney = extraMoney;
    }

    public String getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(String waitTime) {
        this.waitTime = waitTime;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "PayInfo [payType=" + payType + ", getOnTime=" + getOnTime + ", getOffTime=" + getOffTime + ", mileage=" + mileage + ", uselessMileage=" + uselessMileage + ", extraMoney=" + extraMoney + ", waitTime=" + waitTime + ", money=" + money + ", getOrderNum()=" + getOrderNum() + ", getOrderMessId()=" + getOrderMessId() + ", getBody()=" + getBody() + ", getMsName()=" + getMsName() + ", getContent()=" + getContent() + ", getMessID()=" + getMessID() + "]";
    }

    @Override
    public List<byte[]> objToBytes() throws NullPointerException, MessageMistakenException {
        setBody(payType + OrderMessConstants.SPEPERATOR + getOnTime + OrderMessConstants.SPEPERATOR + getOffTime + OrderMessConstants.SPEPERATOR + mileage + OrderMessConstants.SPEPERATOR + uselessMileage + OrderMessConstants.SPEPERATOR + extraMoney + OrderMessConstants.SPEPERATOR + waitTime + OrderMessConstants.SPEPERATOR + money);
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
            this.setGetOnTime(params[4]);
            this.setGetOffTime(params[5]);
            this.setMileage(params[6]);
            this.setUselessMileage(params[7]);
            this.setExtraMoney(params[8]);
            this.setWaitTime(params[9]);
            this.setMoney(params[10]);
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
            this.setGetOnTime(params[4]);
            this.setGetOffTime(params[5]);
            this.setMileage(params[6]);
            this.setUselessMileage(params[7]);
            this.setExtraMoney(params[8]);
            this.setWaitTime(params[9]);
            this.setMoney(params[10]);
        } catch (Exception e) {
            throw e;
        }
        return this;
    }

}

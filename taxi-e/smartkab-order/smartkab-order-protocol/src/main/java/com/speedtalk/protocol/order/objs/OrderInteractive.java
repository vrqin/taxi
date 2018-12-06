package com.speedtalk.protocol.order.objs;

import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.exceptions.CheckMistakenException;
import com.speedtalk.protocol.exceptions.MessageMistakenException;
import com.speedtalk.protocol.order.OrderMessConstants;
import com.speedtalk.protocol.tscobjs.SMS;

import java.util.List;

/**
 * 订单交互通知
 *
 * @author chen
 */
public class OrderInteractive extends Order {
    private byte action;
    private String desc;

    public OrderInteractive(String account, String name, String orderNum, byte action, String desc) {
        super(account, name, OrderMessConstants.ORDER_INTERACTIVE, null);
        this.setOrderNum(orderNum);
        this.action = action;
        this.desc = desc;
    }

    public byte getAction() {
        return action;
    }

    public void setAction(byte action) {
        this.action = action;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "OrderInteractive [action=" + action + ", getDesc()=" + getDesc() + ", getOrderNum()=" + getOrderNum() + ", getOrderMessId()=" + getOrderMessId() + ", getBody()=" + getBody() + ", getContent()=" + getContent() + ", getSrcMsID()=" + getSrcMsID() + "]";
    }

    @Override
    public List<byte[]> objToBytes() throws NullPointerException, MessageMistakenException {
        setBody(String.valueOf(action) + OrderMessConstants.SPEPERATOR + getDesc());
        return super.objToBytes();
    }

    @Override
    public TSCObject bytesToObj(byte[] datas)
            throws NullPointerException, CheckMistakenException, MessageMistakenException {
        try {
            OrderMess orderMess = (OrderMess) super.bytesToObj(datas);
            String[] params = orderMess.getBody().split(OrderMessConstants.SPLITTER);

            this.setMessID(orderMess.getMessID());
            this.setMessNo(orderMess.getMessNo());
            this.setSrcMsID(orderMess.getSrcMsID());
            this.setDstMsID(orderMess.getDstMsID());
            this.setContent(orderMess.getContent());
            this.setOrderMessId(params[1]);
            this.setOrderNum(params[2]);
            this.setAction(Byte.parseByte(params[3]));
            try {
                this.setDesc(params[4]);
            } catch (Exception e) {
            }
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
            this.setAction(Byte.parseByte(params[3]));
            try {
                this.setDesc(params[4]);
            } catch (Exception e) {
            }
        } catch (Exception e) {
            throw e;
        }
        return this;
    }
}

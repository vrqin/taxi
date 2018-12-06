package com.speedtalk.protocol.order.objs;

import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.exceptions.CheckMistakenException;
import com.speedtalk.protocol.exceptions.MessageMistakenException;
import com.speedtalk.protocol.order.OrderMessConstants;
import com.speedtalk.protocol.tscobjs.SMS;

import java.util.List;

public class CommonConfirm extends OrderMess {
    private String confirmId;

    public CommonConfirm() {
        super();
        this.setOrderMessId(OrderMessConstants.COMMOM_CONFIRM);
    }

    /**
     * @param account
     * @param name
     * @param confirmId
     */
    public CommonConfirm(String account, String name, String confirmId) {
        super(account, name, OrderMessConstants.COMMOM_CONFIRM, null);
        this.confirmId = confirmId;
    }

    public String getConfirmId() {
        return confirmId;
    }

    public void setConfirmId(String confirmId) {
        this.confirmId = confirmId;
    }

    @Override
    public String toString() {
        return "OrderConfirm [confirmId=" + confirmId + ", getOrderMessId()=" + getOrderMessId() + ", getBody()=" + getBody() + ", getMsName()=" + getMsName() + ", getContent()=" + getContent() + ", getMessID()=" + getMessID() + ", getSrcMsID()=" + getSrcMsID() + "]";
    }

    @Override
    public List<byte[]> objToBytes() throws NullPointerException, MessageMistakenException {
        setBody(confirmId);
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
            this.setConfirmId(params[2]);
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
            this.setConfirmId(params[2]);
        } catch (Exception e) {
            throw e;
        }
        return this;
    }
}

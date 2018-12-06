package com.speedtalk.protocol.order.objs;

import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.exceptions.CheckMistakenException;
import com.speedtalk.protocol.exceptions.MessageMistakenException;
import com.speedtalk.protocol.order.OrderMessConstants;
import com.speedtalk.protocol.tscobjs.SMS;

import java.util.List;

/**
 * 强制司机下线类
 *
 * @author chen
 */
public class ForceLogout extends OrderMess {
    private String driverName;

    public ForceLogout() {
        super();
    }

    public ForceLogout(String account, String name, String driverName) {
        super(account, name, OrderMessConstants.FORCE_LOGOUT, null);
        this.driverName = driverName;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    @Override
    public String toString() {
        return "Order [driverName=" + driverName + ", getMsName()=" + getMsName() + ", getContent()=" + getContent() + ", getSrcMsID()=" + getSrcMsID() + ", getDstMsID()=" + getDstMsID() + "]";
    }

    @Override
    public List<byte[]> objToBytes() throws NullPointerException, MessageMistakenException {
        if (getBody() != null && !getBody().trim().equals(""))
            setBody(driverName + OrderMessConstants.SPEPERATOR + getBody());
        else
            setBody(driverName);
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
            this.setDriverName(params[2]);
            this.setOrderMessId(params[1]);
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
            this.setDriverName(params[2]);
        } catch (Exception e) {
            throw e;
        }
        return this;
    }
}

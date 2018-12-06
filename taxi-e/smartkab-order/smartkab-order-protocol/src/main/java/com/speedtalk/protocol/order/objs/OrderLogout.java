package com.speedtalk.protocol.order.objs;

import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.exceptions.CheckMistakenException;
import com.speedtalk.protocol.exceptions.MessageMistakenException;
import com.speedtalk.protocol.order.OrderMessConstants;
import com.speedtalk.protocol.tscobjs.SMS;

import java.util.List;

/**
 * 注销指令类
 *
 * @author chen
 */
public class OrderLogout extends OrderMess {
    //	public Logout()
    //	{
    //		super();
    //		this.setOrderMessId(OrderMessConstants.LOGOUT);
    //	}
    public OrderLogout(String account, String name) {
        super(account, name, OrderMessConstants.LOGOUT, null);
    }

    @Override
    public String toString() {
        return "Logout [getMsName()=" + getMsName() + ", getContent()=" + getContent() + ", getSrcMsID()=" + getSrcMsID() + ", getDstMsID()=" + getDstMsID() + "]";
    }

    @Override
    public List<byte[]> objToBytes() throws NullPointerException, MessageMistakenException {
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
        } catch (Exception e) {
            throw e;
        }
        return this;
    }
}

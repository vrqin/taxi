package com.speedtalk.protocol.order.objs;

import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.exceptions.CheckMistakenException;
import com.speedtalk.protocol.exceptions.MessageMistakenException;
import com.speedtalk.protocol.order.OrderMessConstants;
import com.speedtalk.protocol.tscobjs.SMS;

import java.util.List;

/**
 * 取消订单指令类
 *
 * @author chen
 */
public class DropOrder extends Order {
    private String desc;

    //	public DropOrder()
    //	{
    //		super();
    //		this.setOrderMessId(OrderMessConstants.DROP_ORDER);
    //	}
    public DropOrder(String account, String name, String orderNum, String desc) {
        super(account, name, OrderMessConstants.DROP_ORDER, null);
        this.setOrderNum(orderNum);
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "DropOrder [desc=" + desc + ", getOrderNum()=" + getOrderNum() + ", getOrderMessId()=" + getOrderMessId() + ", getBody()=" + getBody() + ", getMsName()=" + getMsName() + ", getContent()=" + getContent() + "]";
    }

    @Override
    public List<byte[]> objToBytes() throws NullPointerException, MessageMistakenException {
        setBody(desc);
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
            if (params.length > 3)
                this.setDesc(params[3]);
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
            if (params.length > 3)
                this.setDesc(params[3]);
        } catch (Exception e) {
            throw e;
        }
        return this;
    }
}

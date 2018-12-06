package com.speedtalk.protocol.order.objs;

import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.exceptions.CheckMistakenException;
import com.speedtalk.protocol.exceptions.MessageMistakenException;
import com.speedtalk.protocol.order.OrderMessConstants;
import com.speedtalk.protocol.tscobjs.SMS;

import java.util.List;

/**
 * 抢单回复指令类
 *
 * @author chen
 */
public class AcceptOrderResp extends OrderMess {
    private Order order;
    private Resp resp;

    //	public AcceptOrderResp()
    //	{
    //		super();
    //		this.setOrderMessId(OrderMessConstants.ACCEPT_ORDER_RESP);
    //	}
    public AcceptOrderResp(String account, String name, String orderNum, String code, String desc) {
        super(account, name, OrderMessConstants.ACCEPT_ORDER_RESP, null);
        order = new Order(account, name, OrderMessConstants.ACCEPT_ORDER_RESP, orderNum);
        resp = new Resp(account, name, OrderMessConstants.ACCEPT_ORDER_RESP, code, desc);
    }

    public String getOrderNum() {
        if (order != null)
            return order.getOrderNum();
        else
            return null;
    }

    public String getCode() {
        if (resp != null)
            return resp.getCode();
        else
            return null;
    }

    public void setCode(String code) {
        try {
            resp.setCode(code);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public String getDesc() {
        if (resp != null)
            return resp.getDesc();
        else
            return null;
    }

    public void setDesc(String desc) {
        try {
            resp.setDesc(desc);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Override
    public String toString() {
        return "OrderResp [orderNum=" + getOrderNum() + ", getMsName()=" + getMsName() + ", getContent()=" + getContent() + ", getSrcMsID()=" + getSrcMsID() + ", getCode()=" + getCode() + ", getDesc()=" + getDesc() + "]";
    }

    @Override
    public List<byte[]> objToBytes() throws NullPointerException, MessageMistakenException {
        if (resp.getCode() == OrderMessConstants.SUCCESS)
            setBody(order.getOrderNum() + OrderMessConstants.SPEPERATOR + resp.getCode());
        else
            setBody(order.getOrderNum() + OrderMessConstants.SPEPERATOR + resp.getCode() + OrderMessConstants.SPEPERATOR + resp
                    .getDesc());
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
            this.order.setOrderNum(params[2]);
            this.resp.setCode(params[3]);
            if (resp.getCode().equals(OrderMessConstants.FAILURE))
                this.resp.setDesc(params[4]);
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
            this.setContent(sms.getContent());
            this.setBody(sms.getContent());
            this.setTime(sms.getTime());
            this.setOrderMessId(params[1]);
            this.order.setOrderNum(params[2]);
            this.resp.setCode(params[3]);
            if (resp.getCode().equals(OrderMessConstants.FAILURE))
                this.resp.setDesc(params[4]);
        } catch (Exception e) {
            throw e;
        }
        return this;
    }
}

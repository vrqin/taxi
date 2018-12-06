package com.speedtalk.protocol.order.objs;

import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.exceptions.CheckMistakenException;
import com.speedtalk.protocol.exceptions.MessageMistakenException;
import com.speedtalk.protocol.order.OrderMessConstants;
import com.speedtalk.protocol.tscobjs.SMS;
import com.speedtalk.protocol.utils.DateUtils;
import com.speedtalk.protocol.utils.MessageUtils;

import java.util.List;

/**
 * 《司机APP和服务端通讯协议》中的指令父类
 *
 * @author chen
 */
public abstract class OrderMess extends SMS {
    /**
     * 指令ID
     */
    protected String orderMessId;
    /**
     * 参数
     */
    protected String body;

    public OrderMess() {
        super();
        setTime(DateUtils.getSmsTimeFormatter().format(System.currentTimeMillis()));
        setMessNo(MessageUtils.getMessNo());
    }

    /**
     * 指令构造函数，所有的指令子类必须提供<b>account<\b>，<b>name<\b>，<b>orderMessId<\b>
     *
     * @param account     账号(终端ID),必须提供<b>*<\b>
     * @param name        名称(终端名称),必须提供<b>*<\b>
     * @param orderMessId 指令ID,必须提供<b>*<\b>
     * @param body
     */
    public OrderMess(String account, String name, String orderMessId, String body) {
        this.setSrcMsID(account);
        this.setMsName(name);
        this.orderMessId = orderMessId;
        this.body = body;
        setMessNo(MessageUtils.getMessNo());
        setTime(DateUtils.getSmsTimeFormatter().format(System.currentTimeMillis()));
    }

    public String getOrderMessId() {
        return orderMessId;
    }

    public void setOrderMessId(String orderMessId) {
        this.orderMessId = orderMessId;
    }

    protected String getBody() {
        return body;
    }

    protected void setBody(String body) {
        this.body = body;
    }

    @Override
    public List<byte[]> objToBytes() throws NullPointerException, MessageMistakenException {
        if (null == body || body.trim().equals(""))
            setContent(OrderMessConstants.HEAD + OrderMessConstants.SPEPERATOR + orderMessId);
        else
            setContent(OrderMessConstants.HEAD + OrderMessConstants.SPEPERATOR + orderMessId + OrderMessConstants.SPEPERATOR + body);
        //		System.out.println("Content:" + getContent());
        setTime(DateUtils.getSmsTimeFormatter().format(System.currentTimeMillis()));
        return super.objToBytes();
    }

    @Override
    public TSCObject bytesToObj(byte[] datas)
            throws NullPointerException, CheckMistakenException, MessageMistakenException {
        try {
            SMS sms = (SMS) super.bytesToObj(datas);
            this.setMessID(sms.getMessID());
            this.setMessNo(sms.getMessNo());
            this.setSrcMsID(sms.getSrcMsID());
            this.setDstMsID(sms.getDstMsID());
            this.setBody(sms.getContent());
        } catch (Exception e) {
            try {
                throw e;
            } catch (Exception e1) {
            }
        }
        return this;
    }

    public String toString() {
        return super.toString();
    }

    public abstract OrderMess toOrderMess(SMS sms) throws Exception;
}

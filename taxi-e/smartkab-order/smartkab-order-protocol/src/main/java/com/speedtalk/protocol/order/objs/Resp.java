package com.speedtalk.protocol.order.objs;

import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.exceptions.CheckMistakenException;
import com.speedtalk.protocol.exceptions.MessageMistakenException;
import com.speedtalk.protocol.order.OrderMessConstants;
import com.speedtalk.protocol.tscobjs.SMS;

import java.util.List;

/**
 * 指令回复类
 * 包含两个参数：回复代码和错误描述
 * 如果回复代码为：OrderMessConstants.SUCCESS,没有错误描述；
 * 如果回复代码为：OrderMessConstants.FAILURE,有错误描述；
 * 错误描述的定义查看OrderMessConstants中**_ERR的常量定义。
 * <b>使用该回复类的指令列表：注销回复指令、修改司机信息回复、修改密码回复、
 * 接到乘客回复、到达回复</b>
 *
 * @author chen
 */
public class Resp extends OrderMess {
    /**
     * 回复代码
     */
    private String code;
    /**
     * 错误描述
     */
    private String desc;

    //	public Resp()
    //	{
    //		super();
    //	}
    public Resp(String account, String name, String orderMessId, String code, String desc) {
        super(account, name, orderMessId, null);
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Resp [code=" + code + ", desc=" + desc + ", getMsName()=" + getMsName() + ", getContent()=" + getContent() + ", getSrcMsID()=" + getSrcMsID() + ", getDstMsID()=" + getDstMsID() + "]";
    }

    @Override
    public List<byte[]> objToBytes() throws NullPointerException, MessageMistakenException {
        if (getBody() != null && !getBody().trim().equals("")) {
            if (getCode().equals(OrderMessConstants.SUCCESS))
                setBody(code + OrderMessConstants.SPEPERATOR + getBody());
            else
                setBody(code + OrderMessConstants.SPEPERATOR + desc + OrderMessConstants.SPEPERATOR + getBody());
        } else {
            if (getCode().equals(OrderMessConstants.SUCCESS))
                setBody(code);
            else
                setBody(code + OrderMessConstants.SPEPERATOR + desc);
        }
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
            this.setCode(params[2]);
            if (getCode().equals(OrderMessConstants.FAILURE))
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
            this.setCode(params[2]);
            if (getCode().equals(OrderMessConstants.FAILURE))
                this.setDesc(params[3]);
        } catch (Exception e) {
            throw e;
        }
        return this;
    }
}

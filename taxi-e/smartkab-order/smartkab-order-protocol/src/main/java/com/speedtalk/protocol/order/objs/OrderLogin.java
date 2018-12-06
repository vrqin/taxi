package com.speedtalk.protocol.order.objs;

import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.exceptions.CheckMistakenException;
import com.speedtalk.protocol.exceptions.MessageMistakenException;
import com.speedtalk.protocol.order.OrderMessConstants;
import com.speedtalk.protocol.tscobjs.SMS;

import java.util.ArrayList;
import java.util.List;

/**
 * 登录指令类
 *
 * @author chen
 */
public class OrderLogin extends OrderMess {
    /**
     * 登录密码
     */
    private String pwd;
    /**
     * 附加属性
     */
    private List<String> attach;
    //	public Login()
    //	{
    //		super();
    //		this.setOrderMessId(OrderMessConstants.LOGIN);
    //	}

    /**
     * 登录指令类构造函数
     *
     * @param account 账号<b>*<\b>
     * @param name    姓名<b>*<\b>
     * @param pwd
     */
    public OrderLogin(String account, String name, String pwd) {
        super(account, name, OrderMessConstants.LOGIN, null);
        this.pwd = pwd;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public List<String> getAttach() {
        return attach;
    }

    public void setAttach(List<String> attach) {
        this.attach = attach;
    }

    @Override
    public String toString() {
        return "Login [pwd=" + pwd + ", getMsName()=" + getMsName() + ", getContent()=" + getContent() + ", getSrcMsID()=" + getSrcMsID() + ", getDstMsID()=" + getDstMsID() + ", getAttach()=" + (getAttach() == null ? "" : getAttach()
                .toString()) + "]";
    }

    @Override
    public List<byte[]> objToBytes() throws NullPointerException, MessageMistakenException {
        if (attach == null || attach.isEmpty())
            setBody(pwd);
        else {
            StringBuilder body = new StringBuilder(pwd);
            body.append(OrderMessConstants.SPEPERATOR);
            for (String str : attach) {
                body.append(str).append(OrderMessConstants.SPEPERATOR);
            }
            body.setLength(body.length() - 1);    //delete OrderMessConstants.SPEPERATOR
            setBody(body.toString());
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
            this.setPwd(params[2]);
            int len = params.length;
            if (len > 3) {
                attach = new ArrayList<String>();
                try {
                    for (int i = 3; i < len; i++) {
                        attach.add(params[i]);
                    }
                } catch (Exception e) {
                }
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
            this.setPwd(params[2]);
            int len = params.length;
            if (len > 3) {
                attach = new ArrayList<String>();
                try {
                    for (int i = 3; i < len; i++) {
                        attach.add(params[i]);
                    }
                } catch (Exception e) {
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return this;
    }
}

package com.speedtalk.protocol.order.objs;

import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.exceptions.CheckMistakenException;
import com.speedtalk.protocol.exceptions.MessageMistakenException;
import com.speedtalk.protocol.order.OrderMessConstants;
import com.speedtalk.protocol.tscobjs.SMS;

import java.util.ArrayList;
import java.util.List;

public class OrderLoginExt extends OrderMess {
    /**
     * 登录方式
     */
    private byte loginType;
    /**
     * 登录密码
     */
    private String pwd;
    /**
     * 附加属性
     */
    private List<String> attach;

    /**
     * 登录指令类构造函数
     *
     * @param account 账号<b>*<\b>
     * @param name    姓名<b>*<\b>
     * @param pwd
     */
    public OrderLoginExt(String account, String name, String pwd, byte loginType) {
        super(account, name, OrderMessConstants.LOGIN_EXT, null);
        this.loginType = loginType;
        this.pwd = pwd;
    }

    public byte getLoginType() {
        return loginType;
    }

    public void setLoginType(byte loginType) {
        this.loginType = loginType;
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
        return "OrderLoginExt [loginType=" + loginType + ", getPwd()=" + pwd + ", getMsName()=" + getMsName() + ", getContent()=" + getContent() + ", getMessID()=" + getMessID() + ", getSrcMsID()=" + getSrcMsID() + "]";
    }

    @Override
    public List<byte[]> objToBytes() throws NullPointerException, MessageMistakenException {
        StringBuilder body = new StringBuilder();
        body.append(loginType).append(OrderMessConstants.SPEPERATOR).append(pwd).append(OrderMessConstants.SPEPERATOR);
        if (attach != null && !attach.isEmpty()) {
            for (String str : attach) {
                body.append(str).append(OrderMessConstants.SPEPERATOR);
            }
            body.setLength(body.length() - 1);    //delete OrderMessConstants.SPEPERATOR
        }
        setBody(body.toString());
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
            this.setLoginType(Byte.parseByte(params[2]));
            this.setPwd(params[3]);
            int len = params.length;
            if (len > 4) {
                attach = new ArrayList<String>();
                try {
                    for (int i = 4; i < len; i++) {
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
            this.setLoginType(Byte.parseByte(params[2]));
            this.setPwd(params[3]);
            int len = params.length;
            if (len > 4) {
                attach = new ArrayList<String>();
                try {
                    for (int i = 4; i < len; i++) {
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

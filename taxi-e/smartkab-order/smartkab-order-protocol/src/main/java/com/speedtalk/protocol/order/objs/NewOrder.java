package com.speedtalk.protocol.order.objs;

import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.exceptions.CheckMistakenException;
import com.speedtalk.protocol.exceptions.MessageMistakenException;
import com.speedtalk.protocol.order.OrderMessConstants;
import com.speedtalk.protocol.tscobjs.SMS;

import java.util.List;

/**
 * 新订单指令类
 *
 * @author chen
 */
public class NewOrder extends Order {
    private String clientMobile;
    private String srcAddr;
    private String srcLg;
    private String srcLt;
    private String dstAddr;
    private String dstLg;
    private String dstLt;
    private String submitTime;
    private String remark;
    private String orderType;
    private String driver;

    public NewOrder() {
        super();
        this.setOrderMessId(OrderMessConstants.NEW_ORDER);
    }

    public NewOrder(String account, String name, String clientMobile, String srcAddr, String srcLg, String srcLt, String dstAddr, String dstLg, String dstLt, String submitTime, String remark, String orderType) {
        super(account, name, OrderMessConstants.NEW_ORDER, null);
        this.clientMobile = clientMobile;
        this.srcAddr = srcAddr;
        this.srcLg = srcLg;
        this.srcLt = srcLt;
        this.dstAddr = dstAddr;
        this.dstLg = dstLg;
        this.dstLt = dstLt;
        this.submitTime = submitTime;
        this.remark = remark;
        this.orderType = orderType;
    }

    public String getClientMobile() {
        return clientMobile;
    }

    public void setClientMobile(String clientMobile) {
        this.clientMobile = clientMobile;
    }

    public String getSrcAddr() {
        return srcAddr;
    }

    public void setSrcAddr(String srcAddr) {
        this.srcAddr = srcAddr;
    }

    public String getSrcLg() {
        return srcLg;
    }

    public void setSrcLg(String srcLg) {
        this.srcLg = srcLg;
    }

    public String getSrcLt() {
        return srcLt;
    }

    public void setSrcLt(String srcLt) {
        this.srcLt = srcLt;
    }

    public String getDstAddr() {
        return dstAddr;
    }

    public void setDstAddr(String dstAddr) {
        this.dstAddr = dstAddr;
    }

    public String getDstLg() {
        return dstLg;
    }

    public void setDstLg(String dstLg) {
        this.dstLg = dstLg;
    }

    public String getDstLt() {
        return dstLt;
    }

    public void setDstLt(String dstLt) {
        this.dstLt = dstLt;
    }

    public String getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(String submitTime) {
        this.submitTime = submitTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "NewOrder [clientMobile=" + clientMobile + ", srcAddr=" + srcAddr + ", srcLg=" + srcLg + ", srcLt=" + srcLt + ", dstAddr=" + dstAddr + ", dstLg=" + dstLg + ", dstLt=" + dstLt + ", orderMessId=" + orderMessId + ", body=" + body + ", getOrderNum()=" + getOrderNum() + ", submitTime=" + submitTime + ", remark=" + remark + ", orderType=" + orderType + ", driver=" + driver + "]";
    }

    @Override
    public List<byte[]> objToBytes() throws NullPointerException, MessageMistakenException {
        String body = clientMobile + OrderMessConstants.SPEPERATOR + srcAddr + OrderMessConstants.SPEPERATOR + srcLg + OrderMessConstants.SPEPERATOR + srcLt + OrderMessConstants.SPEPERATOR + dstAddr + OrderMessConstants.SPEPERATOR + dstLg + OrderMessConstants.SPEPERATOR + dstLt + OrderMessConstants.SPEPERATOR + submitTime + OrderMessConstants.SPEPERATOR + remark + OrderMessConstants.SPEPERATOR + orderType;
        if (driver != null && !driver.trim().equals(""))
            body += OrderMessConstants.SPEPERATOR + driver;
        setBody(body);
        return super.objToBytes();
    }

    @Override
    public TSCObject bytesToObj(byte[] datas)
            throws NullPointerException, CheckMistakenException, MessageMistakenException {
        try {
            Order order = (Order) super.bytesToObj(datas);
            String[] params = order.getBody().split(OrderMessConstants.SPLITTER);

            this.setMessID(order.getMessID());
            this.setMessNo(order.getMessNo());
            this.setSrcMsID(order.getSrcMsID());
            this.setDstMsID(order.getDstMsID());
            this.setContent(order.getContent());
            this.setOrderMessId(params[1]);
            this.setOrderNum(params[2]);
            this.setClientMobile(params[3]);
            this.setSrcAddr(params[4]);
            this.setSrcLg(params[5]);
            this.setSrcLt(params[6]);
            this.setDstAddr(params[7]);
            this.setDstLg(params[8]);
            this.setDstLt(params[9]);
            this.setSubmitTime(params[10]);
            if (params.length > 12) {
                this.setRemark(params[11]);
                this.setOrderType(params[12]);
            }
            if (params.length > 13)
                this.setDriver(params[13]);
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
            this.setClientMobile(params[3]);
            this.setSrcAddr(params[4]);
            this.setSrcLg(params[5]);
            this.setSrcLt(params[6]);
            this.setDstAddr(params[7]);
            this.setDstLg(params[8]);
            this.setDstLt(params[9]);
            this.setSubmitTime(params[10]);
            if (params.length > 12) {
                this.setRemark(params[11]);
                this.setOrderType(params[12]);
            }
            if (params.length > 13)
                this.setDriver(params[13]);
        } catch (Exception e) {
            throw e;
        }
        return this;
    }
}

package com.speedtalk.protocol.order.objs;

import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.exceptions.CheckMistakenException;
import com.speedtalk.protocol.exceptions.MessageMistakenException;
import com.speedtalk.protocol.order.OrderMessConstants;
import com.speedtalk.protocol.tscobjs.SMS;

import java.util.List;

/**
 * 修改司机信息指令类
 *
 * @author chen
 */
public class UpdateDriverInfo extends OrderMess {
    /**
     * 司机名称
     */
    private String driverName;
    /**
     * 车牌号
     */
    private String vehicleNum;
    /**
     * 司机联系电话
     */
    private String driverMobile;

    // public UpdateDriverInfo() {
    //     super();
    //     this.setOrderMessId(OrderMessConstants.UPDATE_DRIVER_INFO);
    // }
    public UpdateDriverInfo(String account, String name, String driverName, String vehicleNum, String driverMobile) {
        super(account, name, OrderMessConstants.UPDATE_DRIVER_INFO, null);
        this.driverName = driverName;
        this.vehicleNum = vehicleNum;
        this.driverMobile = driverMobile;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getVehicleNum() {
        return vehicleNum;
    }

    public void setVehicleNum(String vehicleNum) {
        this.vehicleNum = vehicleNum;
    }

    public String getDriverMobile() {
        return driverMobile;
    }

    public void setDriverMobile(String driverMobile) {
        this.driverMobile = driverMobile;
    }

    @Override
    public String toString() {
        return "UpdateDriverInfo [driverName=" + driverName + ", vehicleNum=" + vehicleNum + ", driverMobile=" + driverMobile + ", getMsName()=" + getMsName() + ", getContent()=" + getContent() + ", getSrcMsID()=" + getSrcMsID() + ", getDstMsID()=" + getDstMsID() + "]";
    }

    @Override
    public List<byte[]> objToBytes() throws NullPointerException, MessageMistakenException {
        setBody(driverName + OrderMessConstants.SPEPERATOR + vehicleNum + OrderMessConstants.SPEPERATOR + driverMobile);
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
            this.driverName = params[2];
            this.vehicleNum = params[3];
            this.driverMobile = params[4];
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
            this.driverName = params[2];
            this.vehicleNum = params[3];
            this.driverMobile = params[4];
        } catch (Exception e) {
            throw e;
        }
        return this;
    }
}

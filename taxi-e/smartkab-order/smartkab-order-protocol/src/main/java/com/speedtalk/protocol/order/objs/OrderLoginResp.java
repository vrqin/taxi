package com.speedtalk.protocol.order.objs;

import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.exceptions.CheckMistakenException;
import com.speedtalk.protocol.exceptions.MessageMistakenException;
import com.speedtalk.protocol.order.OrderMessConstants;
import com.speedtalk.protocol.tscobjs.SMS;

import java.util.List;

/**
 * 登录回复指令类
 *
 * @author chen
 */
public class OrderLoginResp extends Resp {
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
    /**
     * 星级
     */
    private String level;
    /**
     * 营运证号
     */
    private String tradeCer;
    /**
     * 编号
     */
    private String serialNum;
    /**
     * 公司名
     */
    private String company;
    /**
     * 驾驶证号
     */
    private String driveLicense;
    /**
     * 头像url
     */
    private String iconUrl;

    //	public LoginResp()
    //	{
    //		super();
    //		this.setOrderMessId(OrderMessConstants.LOGIN_RESP);
    //	}
    public OrderLoginResp(String account, String name, String code, String desc, String driverName, String vehicleNum, String driverMobile, String level, String tradeCer, String serialNum, String company, String driveLicense, String iconUrl) {
        super(account, name, OrderMessConstants.LOGIN_RESP, code, desc);
        this.driverName = driverName;
        this.vehicleNum = vehicleNum;
        this.driverMobile = driverMobile;
        this.level = level;
        this.tradeCer = tradeCer;
        this.serialNum = serialNum;
        this.company = company;
        this.driveLicense = driveLicense;
        this.iconUrl = iconUrl;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getTradeCer() {
        return tradeCer;
    }

    public void setTradeCer(String tradeCer) {
        this.tradeCer = tradeCer;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDriveLicense() {
        return driveLicense;
    }

    public void setDriveLicense(String driveLicense) {
        this.driveLicense = driveLicense;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    @Override
    public String toString() {
        return "OrderLoginResp [driverName=" + driverName + ", vehicleNum=" + vehicleNum + ", driverMobile=" + driverMobile + ", level=" + level + ", tradeCer=" + tradeCer + ", serialNum=" + serialNum + ", company=" + company + ", driveLicense=" + driveLicense + ", iconUrl=" + iconUrl + ", getCode()=" + getCode() + ", getDesc()=" + getDesc() + ", getOrderMessId()=" + getOrderMessId() + ", getBody()=" + getBody() + ", getMsName()=" + getMsName() + ", getTime()=" + getTime() + ", getContent()=" + getContent() + "]";
    }

    @Override
    public List<byte[]> objToBytes() throws NullPointerException, MessageMistakenException {
        if (getCode().equals(OrderMessConstants.SUCCESS)) {
            setBody(driverName + OrderMessConstants.SPEPERATOR + vehicleNum + OrderMessConstants.SPEPERATOR + driverMobile + OrderMessConstants.SPEPERATOR + level + OrderMessConstants.SPEPERATOR + tradeCer + OrderMessConstants.SPEPERATOR + serialNum + OrderMessConstants.SPEPERATOR + company + OrderMessConstants.SPEPERATOR + driveLicense + OrderMessConstants.SPEPERATOR + iconUrl);
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
            if (getCode().equals(OrderMessConstants.SUCCESS)) {
                this.driverName = params[3];
                this.vehicleNum = params[4];
                this.driverMobile = params[5];
                this.level = params[6];
                this.tradeCer = params[7];
                this.serialNum = params[8];
                this.company = params[9];
                this.driveLicense = params[10];
                this.iconUrl = params[11];
            } else
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
            if (getCode().equals(OrderMessConstants.SUCCESS)) {
                this.driverName = params[3];
                this.vehicleNum = params[4];
                this.driverMobile = params[5];
                this.level = params[6];
                this.tradeCer = params[7];
                this.serialNum = params[8];
                this.company = params[9];
                this.driveLicense = params[10];
                this.iconUrl = params[11];
            } else
                this.setDesc(params[3]);
        } catch (Exception e) {
            throw e;
        }
        return this;
    }
}

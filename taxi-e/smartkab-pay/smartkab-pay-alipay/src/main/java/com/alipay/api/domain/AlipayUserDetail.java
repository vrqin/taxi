package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class AlipayUserDetail extends AlipayObject {
    private static final long serialVersionUID = 8145736133155788665L;


    @ApiField("alipay_user_id")
    private String alipayUserId;


    @ApiField("certified")
    private Boolean certified;


    @ApiField("logon_id")
    private String logonId;


    @ApiField("real_name")
    private String realName;


    @ApiField("sex")
    private String sex;


    @ApiField("user_status")
    private String userStatus;


    @ApiField("user_type")
    private String userType;


    public String getAlipayUserId() {
        /*  59 */
        return this.alipayUserId;

    }


    public void setAlipayUserId(String alipayUserId) {
        /*  62 */
        this.alipayUserId = alipayUserId;

    }


    public Boolean getCertified() {
        /*  66 */
        return this.certified;

    }


    public void setCertified(Boolean certified) {
        /*  69 */
        this.certified = certified;

    }


    public String getLogonId() {
        /*  73 */
        return this.logonId;

    }


    public void setLogonId(String logonId) {
        /*  76 */
        this.logonId = logonId;

    }


    public String getRealName() {
        /*  80 */
        return this.realName;

    }


    public void setRealName(String realName) {
        /*  83 */
        this.realName = realName;

    }


    public String getSex() {
        /*  87 */
        return this.sex;

    }


    public void setSex(String sex) {
        /*  90 */
        this.sex = sex;

    }


    public String getUserStatus() {
        /*  94 */
        return this.userStatus;

    }


    public void setUserStatus(String userStatus) {
        /*  97 */
        this.userStatus = userStatus;

    }


    public String getUserType() {
        /* 101 */
        return this.userType;

    }


    public void setUserType(String userType) {
        /* 104 */
        this.userType = userType;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayUserDetail
 * JD-Core Version:    0.6.0
 */
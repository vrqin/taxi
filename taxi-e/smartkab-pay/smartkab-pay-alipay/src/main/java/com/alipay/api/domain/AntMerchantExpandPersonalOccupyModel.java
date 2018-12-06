package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class AntMerchantExpandPersonalOccupyModel extends AlipayObject {
    private static final long serialVersionUID = 8158498885699341289L;


    @ApiField("base_info")
    private BaseInfo baseInfo;


    @ApiField("business_license_info")
    private BusinessLicenceInfo businessLicenseInfo;


    @ApiField("login_id")
    private String loginId;


    @ApiField("operator_info")
    private OperatorInfo operatorInfo;


    @ApiField("out_biz_no")
    private String outBizNo;


    @ApiField("personal_bank_account_info")
    private PersonnalBankAccountInfo personalBankAccountInfo;


    @ApiField("shop_info")
    private ShopInfo shopInfo;


    public BaseInfo getBaseInfo() {
        /*  59 */
        return this.baseInfo;

    }


    public void setBaseInfo(BaseInfo baseInfo) {
        /*  62 */
        this.baseInfo = baseInfo;

    }


    public BusinessLicenceInfo getBusinessLicenseInfo() {
        /*  66 */
        return this.businessLicenseInfo;

    }


    public void setBusinessLicenseInfo(BusinessLicenceInfo businessLicenseInfo) {
        /*  69 */
        this.businessLicenseInfo = businessLicenseInfo;

    }


    public String getLoginId() {
        /*  73 */
        return this.loginId;

    }


    public void setLoginId(String loginId) {
        /*  76 */
        this.loginId = loginId;

    }


    public OperatorInfo getOperatorInfo() {
        /*  80 */
        return this.operatorInfo;

    }


    public void setOperatorInfo(OperatorInfo operatorInfo) {
        /*  83 */
        this.operatorInfo = operatorInfo;

    }


    public String getOutBizNo() {
        /*  87 */
        return this.outBizNo;

    }


    public void setOutBizNo(String outBizNo) {
        /*  90 */
        this.outBizNo = outBizNo;

    }


    public PersonnalBankAccountInfo getPersonalBankAccountInfo() {
        /*  94 */
        return this.personalBankAccountInfo;

    }


    public void setPersonalBankAccountInfo(PersonnalBankAccountInfo personalBankAccountInfo) {
        /*  97 */
        this.personalBankAccountInfo = personalBankAccountInfo;

    }


    public ShopInfo getShopInfo() {
        /* 101 */
        return this.shopInfo;

    }


    public void setShopInfo(ShopInfo shopInfo) {
        /* 104 */
        this.shopInfo = shopInfo;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AntMerchantExpandPersonalOccupyModel
 * JD-Core Version:    0.6.0
 */
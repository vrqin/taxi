package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class AlipayOpenAppIsvOccupyModel extends AlipayObject {
    private static final long serialVersionUID = 2535313367296132584L;


    @ApiField("base_info")
    private BaseInfo baseInfo;


    @ApiField("business_bank_account_info")
    private BusinessBankAccountInfo businessBankAccountInfo;


    @ApiField("business_license_info")
    private BusinessLicenceInfo businessLicenseInfo;


    @ApiField("legal_representative_info")
    private LegalRepresentativeInfo legalRepresentativeInfo;


    @ApiField("login_id")
    private String loginId;


    @ApiField("out_biz_no")
    private String outBizNo;


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


    public BusinessBankAccountInfo getBusinessBankAccountInfo() {
        /*  66 */
        return this.businessBankAccountInfo;

    }


    public void setBusinessBankAccountInfo(BusinessBankAccountInfo businessBankAccountInfo) {
        /*  69 */
        this.businessBankAccountInfo = businessBankAccountInfo;

    }


    public BusinessLicenceInfo getBusinessLicenseInfo() {
        /*  73 */
        return this.businessLicenseInfo;

    }


    public void setBusinessLicenseInfo(BusinessLicenceInfo businessLicenseInfo) {
        /*  76 */
        this.businessLicenseInfo = businessLicenseInfo;

    }


    public LegalRepresentativeInfo getLegalRepresentativeInfo() {
        /*  80 */
        return this.legalRepresentativeInfo;

    }


    public void setLegalRepresentativeInfo(LegalRepresentativeInfo legalRepresentativeInfo) {
        /*  83 */
        this.legalRepresentativeInfo = legalRepresentativeInfo;

    }


    public String getLoginId() {
        /*  87 */
        return this.loginId;

    }


    public void setLoginId(String loginId) {
        /*  90 */
        this.loginId = loginId;

    }


    public String getOutBizNo() {
        /*  94 */
        return this.outBizNo;

    }


    public void setOutBizNo(String outBizNo) {
        /*  97 */
        this.outBizNo = outBizNo;

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
 * Qualified Name:     com.alipay.api.domain.AlipayOpenAppIsvOccupyModel
 * JD-Core Version:    0.6.0
 */
/*      */
package com.alipay.api.response;
/*      */
/*      */

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

import java.util.Date;

/*      */
/*      */

/*      */
/*      */ public class AlipayOfflineMarketReportGetResponse extends AlipayResponse
        /*      */ {
    /*      */   private static final long serialVersionUID = 6245573186945585835L;
    /*      */
    /*      */
    @ApiField("address")
    /*      */ private String address;
    /*      */
    /*      */
    @ApiField("amount_in_30_days")
    /*      */ private String amountIn30Days;
    /*      */
    /*      */
    @ApiField("amount_in_7_days")
    /*      */ private String amountIn7Days;
    /*      */
    /*      */
    @ApiField("amount_per_capita")
    /*      */ private String amountPerCapita;
    /*      */
    /*      */
    @ApiField("amount_yesterday")
    /*      */ private String amountYesterday;
    /*      */
    /*      */
    @ApiField("area")
    /*      */ private String area;
    /*      */
    /*      */
    @ApiField("assign_status")
    /*      */ private String assignStatus;
    /*      */
    /*      */
    @ApiField("bd_staff_uid")
    /*      */ private String bdStaffUid;
    /*      */
    /*      */
    @ApiField("brand_name")
    /*      */ private String brandName;
    /*      */
    /*      */
    @ApiField("city")
    /*      */ private String city;
    /*      */
    /*      */
    @ApiField("city_code")
    /*      */ private String cityCode;
    /*      */
    /*      */
    @ApiField("city_manager_name")
    /*      */ private String cityManagerName;
    /*      */
    /*      */
    @ApiField("city_manager_uid")
    /*      */ private String cityManagerUid;
    /*      */
    /*      */
    @ApiField("competitor_lowest_discount")
    /*      */ private String competitorLowestDiscount;
    /*      */
    /*      */
    @ApiField("create_channel")
    /*      */ private String createChannel;
    /*      */
    /*      */
    @ApiField("detail_category")
    /*      */ private String detailCategory;
    /*      */
    /*      */
    @ApiField("detail_category_code")
    /*      */ private String detailCategoryCode;
    /*      */
    /*      */
    @ApiField("discount_id")
    /*      */ private String discountId;
    /*      */
    /*      */
    @ApiField("district")
    /*      */ private String district;
    /*      */
    /*      */
    @ApiField("district_code")
    /*      */ private String districtCode;
    /*      */
    /*      */
    @ApiField("f2f_audit_status")
    /*      */ private String f2fAuditStatus;
    /*      */
    /*      */
    @ApiField("f2f_online")
    /*      */ private Date f2fOnline;
    /*      */
    /*      */
    @ApiField("f2f_sign_count")
    /*      */ private String f2fSignCount;
    /*      */
    /*      */
    @ApiField("f2f_status")
    /*      */ private String f2fStatus;
    /*      */
    /*      */
    @ApiField("f2f_version")
    /*      */ private String f2fVersion;
    /*      */
    /*      */
    @ApiField("ff_audit_status")
    /*      */ private String ffAuditStatus;
    /*      */
    /*      */
    @ApiField("ff_online")
    /*      */ private Date ffOnline;
    /*      */
    /*      */
    @ApiField("ff_sign_count")
    /*      */ private String ffSignCount;
    /*      */
    /*      */
    @ApiField("ff_status")
    /*      */ private String ffStatus;
    /*      */
    /*      */
    @ApiField("ff_version")
    /*      */ private String ffVersion;
    /*      */
    /*      */
    @ApiField("gmt_create")
    /*      */ private Date gmtCreate;
    /*      */
    /*      */
    @ApiField("gmt_modified")
    /*      */ private Date gmtModified;
    /*      */
    /*      */
    @ApiField("has_discount")
    /*      */ private String hasDiscount;
    /*      */
    /*      */
    @ApiField("has_discount_privilege")
    /*      */ private String hasDiscountPrivilege;
    /*      */
    /*      */
    @ApiField("has_equipment")
    /*      */ private String hasEquipment;
    /*      */
    /*      */
    @ApiField("has_shuangzheng")
    /*      */ private String hasShuangzheng;
    /*      */
    /*      */
    @ApiField("has_whole_people_discount")
    /*      */ private String hasWholePeopleDiscount;
    /*      */
    /*      */
    @ApiField("id")
    /*      */ private String id;
    /*      */
    /*      */
    @ApiField("in_blacklist")
    /*      */ private String inBlacklist;
    /*      */
    /*      */
    @ApiField("item_consumed_30")
    /*      */ private String itemConsumed30;
    /*      */
    /*      */
    @ApiField("item_count_30")
    /*      */ private String itemCount30;
    /*      */
    /*      */
    @ApiField("ka")
    /*      */ private String ka;
    /*      */
    /*      */
    @ApiField("leads_name")
    /*      */ private String leadsName;
    /*      */
    /*      */
    @ApiField("manual_confirm_assign_time")
    /*      */ private Date manualConfirmAssignTime;
    /*      */
    /*      */
    @ApiField("merchant_name")
    /*      */ private String merchantName;
    /*      */
    /*      */
    @ApiField("merchant_pid")
    /*      */ private String merchantPid;
    /*      */
    /*      */
    @ApiField("mobile")
    /*      */ private String mobile;
    /*      */
    /*      */
    @ApiField("order_1")
    /*      */ private String order1;
    /*      */
    /*      */
    @ApiField("order_in_1_day")
    /*      */ private String orderIn1Day;
    /*      */
    /*      */
    @ApiField("order_in_7_days")
    /*      */ private String orderIn7Days;
    /*      */
    /*      */
    @ApiField("pri_category")
    /*      */ private String priCategory;
    /*      */
    /*      */
    @ApiField("pri_category_code")
    /*      */ private String priCategoryCode;
    /*      */
    /*      */
    @ApiField("prov_code")
    /*      */ private String provCode;
    /*      */
    /*      */
    @ApiField("provider_name")
    /*      */ private String providerName;
    /*      */
    /*      */
    @ApiField("provider_pid")
    /*      */ private String providerPid;
    /*      */
    /*      */
    @ApiField("provider_staff_name")
    /*      */ private String providerStaffName;
    /*      */
    /*      */
    @ApiField("provider_staff_uid")
    /*      */ private String providerStaffUid;
    /*      */
    /*      */
    @ApiField("province")
    /*      */ private String province;
    /*      */
    /*      */
    @ApiField("recommender")
    /*      */ private String recommender;
    /*      */
    /*      */
    @ApiField("recommender_type")
    /*      */ private String recommenderType;
    /*      */
    /*      */
    @ApiField("shop_audit_status")
    /*      */ private String shopAuditStatus;
    /*      */
    /*      */
    @ApiField("shop_id")
    /*      */ private String shopId;
    /*      */
    /*      */
    @ApiField("shop_level")
    /*      */ private String shopLevel;
    /*      */
    /*      */
    @ApiField("shop_name")
    /*      */ private String shopName;
    /*      */
    /*      */
    @ApiField("shop_online")
    /*      */ private Date shopOnline;
    /*      */
    /*      */
    @ApiField("shop_source")
    /*      */ private String shopSource;
    /*      */
    /*      */
    @ApiField("shop_tag")
    /*      */ private String shopTag;
    /*      */
    /*      */
    @ApiField("sub_category")
    /*      */ private String subCategory;
    /*      */
    /*      */
    @ApiField("sub_category_code")
    /*      */ private String subCategoryCode;
    /*      */
    /*      */
    @ApiField("telephone")
    /*      */ private String telephone;
    /*      */
    /*      */
    @ApiField("user_1")
    /*      */ private String user1;
    /*      */
    /*      */
    @ApiField("user_in_1_day")
    /*      */ private String userIn1Day;
    /*      */
    /*      */
    @ApiField("user_in_7_days")
    /*      */ private String userIn7Days;
    /*      */
    /*      */
    @ApiField("verification_in_1_day")
    /*      */ private String verificationIn1Day;
    /*      */
    /*      */
    @ApiField("verification_in_30_days")
    /*      */ private String verificationIn30Days;
    /*      */
    /*      */
    @ApiField("verification_in_7_days")
    /*      */ private String verificationIn7Days;
    /*      */
    /*      */
    @ApiField("whole_people_lowest_discount")
    /*      */ private String wholePeopleLowestDiscount;

    /*      */
    public String getAddress() {
        /*  484 */
        return this.address;
        /*      */
    }

    /*      */
    /*      */
    public void setAddress(String address)
    /*      */ {
        /*  481 */
        this.address = address;
        /*      */
    }

    /*      */
    public String getAmountIn30Days() {
        /*  491 */
        return this.amountIn30Days;
        /*      */
    }

    /*      */
    /*      */
    public void setAmountIn30Days(String amountIn30Days) {
        /*  488 */
        this.amountIn30Days = amountIn30Days;
        /*      */
    }

    /*      */
    public String getAmountIn7Days() {
        /*  498 */
        return this.amountIn7Days;
        /*      */
    }

    /*      */
    /*      */
    public void setAmountIn7Days(String amountIn7Days) {
        /*  495 */
        this.amountIn7Days = amountIn7Days;
        /*      */
    }

    /*      */
    public String getAmountPerCapita() {
        /*  505 */
        return this.amountPerCapita;
        /*      */
    }

    /*      */
    /*      */
    public void setAmountPerCapita(String amountPerCapita) {
        /*  502 */
        this.amountPerCapita = amountPerCapita;
        /*      */
    }

    /*      */
    public String getAmountYesterday() {
        /*  512 */
        return this.amountYesterday;
        /*      */
    }

    /*      */
    /*      */
    public void setAmountYesterday(String amountYesterday) {
        /*  509 */
        this.amountYesterday = amountYesterday;
        /*      */
    }

    /*      */
    public String getArea() {
        /*  519 */
        return this.area;
        /*      */
    }

    /*      */
    /*      */
    public void setArea(String area) {
        /*  516 */
        this.area = area;
        /*      */
    }

    /*      */
    public String getAssignStatus() {
        /*  526 */
        return this.assignStatus;
        /*      */
    }

    /*      */
    /*      */
    public void setAssignStatus(String assignStatus) {
        /*  523 */
        this.assignStatus = assignStatus;
        /*      */
    }

    /*      */
    public String getBdStaffUid() {
        /*  533 */
        return this.bdStaffUid;
        /*      */
    }

    /*      */
    /*      */
    public void setBdStaffUid(String bdStaffUid) {
        /*  530 */
        this.bdStaffUid = bdStaffUid;
        /*      */
    }

    /*      */
    public String getBrandName() {
        /*  540 */
        return this.brandName;
        /*      */
    }

    /*      */
    /*      */
    public void setBrandName(String brandName) {
        /*  537 */
        this.brandName = brandName;
        /*      */
    }

    /*      */
    public String getCity() {
        /*  547 */
        return this.city;
        /*      */
    }

    /*      */
    /*      */
    public void setCity(String city) {
        /*  544 */
        this.city = city;
        /*      */
    }

    /*      */
    public String getCityCode() {
        /*  554 */
        return this.cityCode;
        /*      */
    }

    /*      */
    /*      */
    public void setCityCode(String cityCode) {
        /*  551 */
        this.cityCode = cityCode;
        /*      */
    }

    /*      */
    public String getCityManagerName() {
        /*  561 */
        return this.cityManagerName;
        /*      */
    }

    /*      */
    /*      */
    public void setCityManagerName(String cityManagerName) {
        /*  558 */
        this.cityManagerName = cityManagerName;
        /*      */
    }

    /*      */
    public String getCityManagerUid() {
        /*  568 */
        return this.cityManagerUid;
        /*      */
    }

    /*      */
    /*      */
    public void setCityManagerUid(String cityManagerUid) {
        /*  565 */
        this.cityManagerUid = cityManagerUid;
        /*      */
    }

    /*      */
    public String getCompetitorLowestDiscount() {
        /*  575 */
        return this.competitorLowestDiscount;
        /*      */
    }

    /*      */
    /*      */
    public void setCompetitorLowestDiscount(String competitorLowestDiscount) {
        /*  572 */
        this.competitorLowestDiscount = competitorLowestDiscount;
        /*      */
    }

    /*      */
    public String getCreateChannel() {
        /*  582 */
        return this.createChannel;
        /*      */
    }

    /*      */
    /*      */
    public void setCreateChannel(String createChannel) {
        /*  579 */
        this.createChannel = createChannel;
        /*      */
    }

    /*      */
    public String getDetailCategory() {
        /*  589 */
        return this.detailCategory;
        /*      */
    }

    /*      */
    /*      */
    public void setDetailCategory(String detailCategory) {
        /*  586 */
        this.detailCategory = detailCategory;
        /*      */
    }

    /*      */
    public String getDetailCategoryCode() {
        /*  596 */
        return this.detailCategoryCode;
        /*      */
    }

    /*      */
    /*      */
    public void setDetailCategoryCode(String detailCategoryCode) {
        /*  593 */
        this.detailCategoryCode = detailCategoryCode;
        /*      */
    }

    /*      */
    public String getDiscountId() {
        /*  603 */
        return this.discountId;
        /*      */
    }

    /*      */
    /*      */
    public void setDiscountId(String discountId) {
        /*  600 */
        this.discountId = discountId;
        /*      */
    }

    /*      */
    public String getDistrict() {
        /*  610 */
        return this.district;
        /*      */
    }

    /*      */
    /*      */
    public void setDistrict(String district) {
        /*  607 */
        this.district = district;
        /*      */
    }

    /*      */
    public String getDistrictCode() {
        /*  617 */
        return this.districtCode;
        /*      */
    }

    /*      */
    /*      */
    public void setDistrictCode(String districtCode) {
        /*  614 */
        this.districtCode = districtCode;
        /*      */
    }

    /*      */
    public String getF2fAuditStatus() {
        /*  624 */
        return this.f2fAuditStatus;
        /*      */
    }

    /*      */
    /*      */
    public void setF2fAuditStatus(String f2fAuditStatus) {
        /*  621 */
        this.f2fAuditStatus = f2fAuditStatus;
        /*      */
    }

    /*      */
    public Date getF2fOnline() {
        /*  631 */
        return this.f2fOnline;
        /*      */
    }

    /*      */
    /*      */
    public void setF2fOnline(Date f2fOnline) {
        /*  628 */
        this.f2fOnline = f2fOnline;
        /*      */
    }

    /*      */
    public String getF2fSignCount() {
        /*  638 */
        return this.f2fSignCount;
        /*      */
    }

    /*      */
    /*      */
    public void setF2fSignCount(String f2fSignCount) {
        /*  635 */
        this.f2fSignCount = f2fSignCount;
        /*      */
    }

    /*      */
    public String getF2fStatus() {
        /*  645 */
        return this.f2fStatus;
        /*      */
    }

    /*      */
    /*      */
    public void setF2fStatus(String f2fStatus) {
        /*  642 */
        this.f2fStatus = f2fStatus;
        /*      */
    }

    /*      */
    public String getF2fVersion() {
        /*  652 */
        return this.f2fVersion;
        /*      */
    }

    /*      */
    /*      */
    public void setF2fVersion(String f2fVersion) {
        /*  649 */
        this.f2fVersion = f2fVersion;
        /*      */
    }

    /*      */
    public String getFfAuditStatus() {
        /*  659 */
        return this.ffAuditStatus;
        /*      */
    }

    /*      */
    /*      */
    public void setFfAuditStatus(String ffAuditStatus) {
        /*  656 */
        this.ffAuditStatus = ffAuditStatus;
        /*      */
    }

    /*      */
    public Date getFfOnline() {
        /*  666 */
        return this.ffOnline;
        /*      */
    }

    /*      */
    /*      */
    public void setFfOnline(Date ffOnline) {
        /*  663 */
        this.ffOnline = ffOnline;
        /*      */
    }

    /*      */
    public String getFfSignCount() {
        /*  673 */
        return this.ffSignCount;
        /*      */
    }

    /*      */
    /*      */
    public void setFfSignCount(String ffSignCount) {
        /*  670 */
        this.ffSignCount = ffSignCount;
        /*      */
    }

    /*      */
    public String getFfStatus() {
        /*  680 */
        return this.ffStatus;
        /*      */
    }

    /*      */
    /*      */
    public void setFfStatus(String ffStatus) {
        /*  677 */
        this.ffStatus = ffStatus;
        /*      */
    }

    /*      */
    public String getFfVersion() {
        /*  687 */
        return this.ffVersion;
        /*      */
    }

    /*      */
    /*      */
    public void setFfVersion(String ffVersion) {
        /*  684 */
        this.ffVersion = ffVersion;
        /*      */
    }

    /*      */
    public Date getGmtCreate() {
        /*  694 */
        return this.gmtCreate;
        /*      */
    }

    /*      */
    /*      */
    public void setGmtCreate(Date gmtCreate) {
        /*  691 */
        this.gmtCreate = gmtCreate;
        /*      */
    }

    /*      */
    public Date getGmtModified() {
        /*  701 */
        return this.gmtModified;
        /*      */
    }

    /*      */
    /*      */
    public void setGmtModified(Date gmtModified) {
        /*  698 */
        this.gmtModified = gmtModified;
        /*      */
    }

    /*      */
    public String getHasDiscount() {
        /*  708 */
        return this.hasDiscount;
        /*      */
    }

    /*      */
    /*      */
    public void setHasDiscount(String hasDiscount) {
        /*  705 */
        this.hasDiscount = hasDiscount;
        /*      */
    }

    /*      */
    public String getHasDiscountPrivilege() {
        /*  715 */
        return this.hasDiscountPrivilege;
        /*      */
    }

    /*      */
    /*      */
    public void setHasDiscountPrivilege(String hasDiscountPrivilege) {
        /*  712 */
        this.hasDiscountPrivilege = hasDiscountPrivilege;
        /*      */
    }

    /*      */
    public String getHasEquipment() {
        /*  722 */
        return this.hasEquipment;
        /*      */
    }

    /*      */
    /*      */
    public void setHasEquipment(String hasEquipment) {
        /*  719 */
        this.hasEquipment = hasEquipment;
        /*      */
    }

    /*      */
    public String getHasShuangzheng() {
        /*  729 */
        return this.hasShuangzheng;
        /*      */
    }

    /*      */
    /*      */
    public void setHasShuangzheng(String hasShuangzheng) {
        /*  726 */
        this.hasShuangzheng = hasShuangzheng;
        /*      */
    }

    /*      */
    public String getHasWholePeopleDiscount() {
        /*  736 */
        return this.hasWholePeopleDiscount;
        /*      */
    }

    /*      */
    /*      */
    public void setHasWholePeopleDiscount(String hasWholePeopleDiscount) {
        /*  733 */
        this.hasWholePeopleDiscount = hasWholePeopleDiscount;
        /*      */
    }

    /*      */
    public String getId() {
        /*  743 */
        return this.id;
        /*      */
    }

    /*      */
    /*      */
    public void setId(String id) {
        /*  740 */
        this.id = id;
        /*      */
    }

    /*      */
    public String getInBlacklist() {
        /*  750 */
        return this.inBlacklist;
        /*      */
    }

    /*      */
    /*      */
    public void setInBlacklist(String inBlacklist) {
        /*  747 */
        this.inBlacklist = inBlacklist;
        /*      */
    }

    /*      */
    public String getItemConsumed30() {
        /*  757 */
        return this.itemConsumed30;
        /*      */
    }

    /*      */
    /*      */
    public void setItemConsumed30(String itemConsumed30) {
        /*  754 */
        this.itemConsumed30 = itemConsumed30;
        /*      */
    }

    /*      */
    public String getItemCount30() {
        /*  764 */
        return this.itemCount30;
        /*      */
    }

    /*      */
    /*      */
    public void setItemCount30(String itemCount30) {
        /*  761 */
        this.itemCount30 = itemCount30;
        /*      */
    }

    /*      */
    public String getKa() {
        /*  771 */
        return this.ka;
        /*      */
    }

    /*      */
    /*      */
    public void setKa(String ka) {
        /*  768 */
        this.ka = ka;
        /*      */
    }

    /*      */
    public String getLeadsName() {
        /*  778 */
        return this.leadsName;
        /*      */
    }

    /*      */
    /*      */
    public void setLeadsName(String leadsName) {
        /*  775 */
        this.leadsName = leadsName;
        /*      */
    }

    /*      */
    public Date getManualConfirmAssignTime() {
        /*  785 */
        return this.manualConfirmAssignTime;
        /*      */
    }

    /*      */
    /*      */
    public void setManualConfirmAssignTime(Date manualConfirmAssignTime) {
        /*  782 */
        this.manualConfirmAssignTime = manualConfirmAssignTime;
        /*      */
    }

    /*      */
    public String getMerchantName() {
        /*  792 */
        return this.merchantName;
        /*      */
    }

    /*      */
    /*      */
    public void setMerchantName(String merchantName) {
        /*  789 */
        this.merchantName = merchantName;
        /*      */
    }

    /*      */
    public String getMerchantPid() {
        /*  799 */
        return this.merchantPid;
        /*      */
    }

    /*      */
    /*      */
    public void setMerchantPid(String merchantPid) {
        /*  796 */
        this.merchantPid = merchantPid;
        /*      */
    }

    /*      */
    public String getMobile() {
        /*  806 */
        return this.mobile;
        /*      */
    }

    /*      */
    /*      */
    public void setMobile(String mobile) {
        /*  803 */
        this.mobile = mobile;
        /*      */
    }

    /*      */
    public String getOrder1() {
        /*  813 */
        return this.order1;
        /*      */
    }

    /*      */
    /*      */
    public void setOrder1(String order1) {
        /*  810 */
        this.order1 = order1;
        /*      */
    }

    /*      */
    public String getOrderIn1Day() {
        /*  820 */
        return this.orderIn1Day;
        /*      */
    }

    /*      */
    /*      */
    public void setOrderIn1Day(String orderIn1Day) {
        /*  817 */
        this.orderIn1Day = orderIn1Day;
        /*      */
    }

    /*      */
    public String getOrderIn7Days() {
        /*  827 */
        return this.orderIn7Days;
        /*      */
    }

    /*      */
    /*      */
    public void setOrderIn7Days(String orderIn7Days) {
        /*  824 */
        this.orderIn7Days = orderIn7Days;
        /*      */
    }

    /*      */
    public String getPriCategory() {
        /*  834 */
        return this.priCategory;
        /*      */
    }

    /*      */
    /*      */
    public void setPriCategory(String priCategory) {
        /*  831 */
        this.priCategory = priCategory;
        /*      */
    }

    /*      */
    public String getPriCategoryCode() {
        /*  841 */
        return this.priCategoryCode;
        /*      */
    }

    /*      */
    /*      */
    public void setPriCategoryCode(String priCategoryCode) {
        /*  838 */
        this.priCategoryCode = priCategoryCode;
        /*      */
    }

    /*      */
    public String getProvCode() {
        /*  848 */
        return this.provCode;
        /*      */
    }

    /*      */
    /*      */
    public void setProvCode(String provCode) {
        /*  845 */
        this.provCode = provCode;
        /*      */
    }

    /*      */
    public String getProviderName() {
        /*  855 */
        return this.providerName;
        /*      */
    }

    /*      */
    /*      */
    public void setProviderName(String providerName) {
        /*  852 */
        this.providerName = providerName;
        /*      */
    }

    /*      */
    public String getProviderPid() {
        /*  862 */
        return this.providerPid;
        /*      */
    }

    /*      */
    /*      */
    public void setProviderPid(String providerPid) {
        /*  859 */
        this.providerPid = providerPid;
        /*      */
    }

    /*      */
    public String getProviderStaffName() {
        /*  869 */
        return this.providerStaffName;
        /*      */
    }

    /*      */
    /*      */
    public void setProviderStaffName(String providerStaffName) {
        /*  866 */
        this.providerStaffName = providerStaffName;
        /*      */
    }

    /*      */
    public String getProviderStaffUid() {
        /*  876 */
        return this.providerStaffUid;
        /*      */
    }

    /*      */
    /*      */
    public void setProviderStaffUid(String providerStaffUid) {
        /*  873 */
        this.providerStaffUid = providerStaffUid;
        /*      */
    }

    /*      */
    public String getProvince() {
        /*  883 */
        return this.province;
        /*      */
    }

    /*      */
    /*      */
    public void setProvince(String province) {
        /*  880 */
        this.province = province;
        /*      */
    }

    /*      */
    public String getRecommender() {
        /*  890 */
        return this.recommender;
        /*      */
    }

    /*      */
    /*      */
    public void setRecommender(String recommender) {
        /*  887 */
        this.recommender = recommender;
        /*      */
    }

    /*      */
    public String getRecommenderType() {
        /*  897 */
        return this.recommenderType;
        /*      */
    }

    /*      */
    /*      */
    public void setRecommenderType(String recommenderType) {
        /*  894 */
        this.recommenderType = recommenderType;
        /*      */
    }

    /*      */
    public String getShopAuditStatus() {
        /*  904 */
        return this.shopAuditStatus;
        /*      */
    }

    /*      */
    /*      */
    public void setShopAuditStatus(String shopAuditStatus) {
        /*  901 */
        this.shopAuditStatus = shopAuditStatus;
        /*      */
    }

    /*      */
    public String getShopId() {
        /*  911 */
        return this.shopId;
        /*      */
    }

    /*      */
    /*      */
    public void setShopId(String shopId) {
        /*  908 */
        this.shopId = shopId;
        /*      */
    }

    /*      */
    public String getShopLevel() {
        /*  918 */
        return this.shopLevel;
        /*      */
    }

    /*      */
    /*      */
    public void setShopLevel(String shopLevel) {
        /*  915 */
        this.shopLevel = shopLevel;
        /*      */
    }

    /*      */
    public String getShopName() {
        /*  925 */
        return this.shopName;
        /*      */
    }

    /*      */
    /*      */
    public void setShopName(String shopName) {
        /*  922 */
        this.shopName = shopName;
        /*      */
    }

    /*      */
    public Date getShopOnline() {
        /*  932 */
        return this.shopOnline;
        /*      */
    }

    /*      */
    /*      */
    public void setShopOnline(Date shopOnline) {
        /*  929 */
        this.shopOnline = shopOnline;
        /*      */
    }

    /*      */
    public String getShopSource() {
        /*  939 */
        return this.shopSource;
        /*      */
    }

    /*      */
    /*      */
    public void setShopSource(String shopSource) {
        /*  936 */
        this.shopSource = shopSource;
        /*      */
    }

    /*      */
    public String getShopTag() {
        /*  946 */
        return this.shopTag;
        /*      */
    }

    /*      */
    /*      */
    public void setShopTag(String shopTag) {
        /*  943 */
        this.shopTag = shopTag;
        /*      */
    }

    /*      */
    public String getSubCategory() {
        /*  953 */
        return this.subCategory;
        /*      */
    }

    /*      */
    /*      */
    public void setSubCategory(String subCategory) {
        /*  950 */
        this.subCategory = subCategory;
        /*      */
    }

    /*      */
    public String getSubCategoryCode() {
        /*  960 */
        return this.subCategoryCode;
        /*      */
    }

    /*      */
    /*      */
    public void setSubCategoryCode(String subCategoryCode) {
        /*  957 */
        this.subCategoryCode = subCategoryCode;
        /*      */
    }

    /*      */
    public String getTelephone() {
        /*  967 */
        return this.telephone;
        /*      */
    }

    /*      */
    /*      */
    public void setTelephone(String telephone) {
        /*  964 */
        this.telephone = telephone;
        /*      */
    }

    /*      */
    public String getUser1() {
        /*  974 */
        return this.user1;
        /*      */
    }

    /*      */
    /*      */
    public void setUser1(String user1) {
        /*  971 */
        this.user1 = user1;
        /*      */
    }

    /*      */
    public String getUserIn1Day() {
        /*  981 */
        return this.userIn1Day;
        /*      */
    }

    /*      */
    /*      */
    public void setUserIn1Day(String userIn1Day) {
        /*  978 */
        this.userIn1Day = userIn1Day;
        /*      */
    }

    /*      */
    public String getUserIn7Days() {
        /*  988 */
        return this.userIn7Days;
        /*      */
    }

    /*      */
    /*      */
    public void setUserIn7Days(String userIn7Days) {
        /*  985 */
        this.userIn7Days = userIn7Days;
        /*      */
    }

    /*      */
    public String getVerificationIn1Day() {
        /*  995 */
        return this.verificationIn1Day;
        /*      */
    }

    /*      */
    /*      */
    public void setVerificationIn1Day(String verificationIn1Day) {
        /*  992 */
        this.verificationIn1Day = verificationIn1Day;
        /*      */
    }

    /*      */
    public String getVerificationIn30Days() {
        /* 1002 */
        return this.verificationIn30Days;
        /*      */
    }

    /*      */
    /*      */
    public void setVerificationIn30Days(String verificationIn30Days) {
        /*  999 */
        this.verificationIn30Days = verificationIn30Days;
        /*      */
    }

    /*      */
    public String getVerificationIn7Days() {
        /* 1009 */
        return this.verificationIn7Days;
        /*      */
    }

    /*      */
    /*      */
    public void setVerificationIn7Days(String verificationIn7Days) {
        /* 1006 */
        this.verificationIn7Days = verificationIn7Days;
        /*      */
    }

    /*      */
    public String getWholePeopleLowestDiscount() {
        /* 1016 */
        return this.wholePeopleLowestDiscount;
        /*      */
    }

    /*      */
    /*      */
    public void setWholePeopleLowestDiscount(String wholePeopleLowestDiscount) {
        /* 1013 */
        this.wholePeopleLowestDiscount = wholePeopleLowestDiscount;
        /*      */
    }
    /*      */
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOfflineMarketReportGetResponse
 * JD-Core Version:    0.6.0
 */
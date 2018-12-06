package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class OrderItem extends AlipayObject {
    private static final long serialVersionUID = 6212988269918483512L;


    @ApiField("address")
    private String address;


    @ApiField("brand_name")
    private String brandName;


    @ApiField("category")
    private String category;


    @ApiField("city")
    private String city;


    @ApiField("commodity_id")
    private String commodityId;


    @ApiField("contacts")
    private String contacts;


    @ApiField("creator")
    private String creator;


    @ApiField("expire_date")
    private String expireDate;


    @ApiField("online_time")
    private String onlineTime;


    @ApiField("order_status")
    private String orderStatus;


    @ApiField("phone_no")
    private String phoneNo;


    @ApiField("province")
    private String province;


    @ApiField("shop_id")
    private String shopId;


    @ApiField("shop_name")
    private String shopName;


    @ApiField("shop_status")
    private String shopStatus;


    @ApiField("status")
    private String status;


    public String getAddress() {
        /* 113 */
        return this.address;

    }


    public void setAddress(String address) {
        /* 116 */
        this.address = address;

    }


    public String getBrandName() {
        /* 120 */
        return this.brandName;

    }


    public void setBrandName(String brandName) {
        /* 123 */
        this.brandName = brandName;

    }


    public String getCategory() {
        /* 127 */
        return this.category;

    }


    public void setCategory(String category) {
        /* 130 */
        this.category = category;

    }


    public String getCity() {
        /* 134 */
        return this.city;

    }


    public void setCity(String city) {
        /* 137 */
        this.city = city;

    }


    public String getCommodityId() {
        /* 141 */
        return this.commodityId;

    }


    public void setCommodityId(String commodityId) {
        /* 144 */
        this.commodityId = commodityId;

    }


    public String getContacts() {
        /* 148 */
        return this.contacts;

    }


    public void setContacts(String contacts) {
        /* 151 */
        this.contacts = contacts;

    }


    public String getCreator() {
        /* 155 */
        return this.creator;

    }


    public void setCreator(String creator) {
        /* 158 */
        this.creator = creator;

    }


    public String getExpireDate() {
        /* 162 */
        return this.expireDate;

    }


    public void setExpireDate(String expireDate) {
        /* 165 */
        this.expireDate = expireDate;

    }


    public String getOnlineTime() {
        /* 169 */
        return this.onlineTime;

    }


    public void setOnlineTime(String onlineTime) {
        /* 172 */
        this.onlineTime = onlineTime;

    }


    public String getOrderStatus() {
        /* 176 */
        return this.orderStatus;

    }


    public void setOrderStatus(String orderStatus) {
        /* 179 */
        this.orderStatus = orderStatus;

    }


    public String getPhoneNo() {
        /* 183 */
        return this.phoneNo;

    }


    public void setPhoneNo(String phoneNo) {
        /* 186 */
        this.phoneNo = phoneNo;

    }


    public String getProvince() {
        /* 190 */
        return this.province;

    }


    public void setProvince(String province) {
        /* 193 */
        this.province = province;

    }


    public String getShopId() {
        /* 197 */
        return this.shopId;

    }


    public void setShopId(String shopId) {
        /* 200 */
        this.shopId = shopId;

    }


    public String getShopName() {
        /* 204 */
        return this.shopName;

    }


    public void setShopName(String shopName) {
        /* 207 */
        this.shopName = shopName;

    }


    public String getShopStatus() {
        /* 211 */
        return this.shopStatus;

    }


    public void setShopStatus(String shopStatus) {
        /* 214 */
        this.shopStatus = shopStatus;

    }


    public String getStatus() {
        /* 218 */
        return this.status;

    }


    public void setStatus(String status) {
        /* 221 */
        this.status = status;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.OrderItem
 * JD-Core Version:    0.6.0
 */
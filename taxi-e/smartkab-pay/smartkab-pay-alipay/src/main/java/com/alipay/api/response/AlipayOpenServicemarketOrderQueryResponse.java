package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.OrderItem;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayOpenServicemarketOrderQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 3226381262365487161L;

    @ApiField("commodity_id")
    private String commodityId;

    @ApiField("current_page")
    private Long currentPage;

    @ApiListField("order_items")
    @ApiField("order_item")
    private List<OrderItem> orderItems;

    @ApiField("status")
    private String status;

    @ApiField("total_size")
    private Long totalSize;

    public String getCommodityId() {
        /* 55 */
        return this.commodityId;
    }

    public void setCommodityId(String commodityId) {
        /* 52 */
        this.commodityId = commodityId;
    }

    public Long getCurrentPage() {
        /* 62 */
        return this.currentPage;
    }

    public void setCurrentPage(Long currentPage) {
        /* 59 */
        this.currentPage = currentPage;
    }

    public List<OrderItem> getOrderItems() {
        /* 69 */
        return this.orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        /* 66 */
        this.orderItems = orderItems;
    }

    public String getStatus() {
        /* 76 */
        return this.status;
    }

    public void setStatus(String status) {
        /* 73 */
        this.status = status;
    }

    public Long getTotalSize() {
        /* 83 */
        return this.totalSize;
    }

    public void setTotalSize(Long totalSize) {
        /* 80 */
        this.totalSize = totalSize;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOpenServicemarketOrderQueryResponse
 * JD-Core Version:    0.6.0
 */
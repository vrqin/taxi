package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayEcoMycarMaitainDataUpdateModel extends AlipayObject {
    private static final long serialVersionUID = 1447752367332919415L;

    @ApiField("biz_id")
    private String bizId;

    @ApiField("event_id")
    private Long eventId;

    @ApiField("source")
    private String source;

    @ApiField("type_id")
    private String typeId;

    public String getBizId() {
        /* 41 */
        return this.bizId;
    }

    public void setBizId(String bizId) {
        /* 44 */
        this.bizId = bizId;
    }

    public Long getEventId() {
        /* 48 */
        return this.eventId;
    }

    public void setEventId(Long eventId) {
        /* 51 */
        this.eventId = eventId;
    }

    public String getSource() {
        /* 55 */
        return this.source;
    }

    public void setSource(String source) {
        /* 58 */
        this.source = source;
    }

    public String getTypeId() {
        /* 62 */
        return this.typeId;
    }

    public void setTypeId(String typeId) {
        /* 65 */
        this.typeId = typeId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayEcoMycarMaitainDataUpdateModel
 * JD-Core Version:    0.6.0
 */
package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class AlipayCommerceDataSendModel extends AlipayObject {
    private static final long serialVersionUID = 5348764233433197835L;


    @ApiField("channel")
    private String channel;


    @ApiField("op_code")
    private String opCode;


    @ApiField("op_data")
    private String opData;


    @ApiField("scene_code")
    private String sceneCode;


    @ApiField("scene_data")
    private String sceneData;


    @ApiField("target_id")
    private String targetId;


    @ApiField("version")
    private String version;


    public String getChannel() {
        /*  74 */
        return this.channel;

    }


    public void setChannel(String channel) {
        /*  77 */
        this.channel = channel;

    }


    public String getOpCode() {
        /*  81 */
        return this.opCode;

    }


    public void setOpCode(String opCode) {
        /*  84 */
        this.opCode = opCode;

    }


    public String getOpData() {
        /*  88 */
        return this.opData;

    }


    public void setOpData(String opData) {
        /*  91 */
        this.opData = opData;

    }


    public String getSceneCode() {
        /*  95 */
        return this.sceneCode;

    }


    public void setSceneCode(String sceneCode) {
        /*  98 */
        this.sceneCode = sceneCode;

    }


    public String getSceneData() {
        /* 102 */
        return this.sceneData;

    }


    public void setSceneData(String sceneData) {
        /* 105 */
        this.sceneData = sceneData;

    }


    public String getTargetId() {
        /* 109 */
        return this.targetId;

    }


    public void setTargetId(String targetId) {
        /* 112 */
        this.targetId = targetId;

    }


    public String getVersion() {
        /* 116 */
        return this.version;

    }


    public void setVersion(String version) {
        /* 119 */
        this.version = version;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayCommerceDataSendModel
 * JD-Core Version:    0.6.0
 */
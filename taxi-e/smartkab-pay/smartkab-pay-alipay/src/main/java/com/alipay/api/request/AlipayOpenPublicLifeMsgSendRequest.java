package com.alipay.api.request;


import com.alipay.api.AlipayUploadRequest;
import com.alipay.api.FileItem;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayOpenPublicLifeMsgSendResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AlipayOpenPublicLifeMsgSendRequest implements AlipayUploadRequest<AlipayOpenPublicLifeMsgSendResponse> {
    private AlipayHashMap udfParams;
    /*  21 */   private String apiVersion = "1.0";
    private String category;
    private String content;
    private FileItem cover;
    private String desc;
    private String msgType;
    private String sourceExtInfo;
    private String title;
    private String uniqueMsgId;
    private String videoLength;
    private List<String> videoSamples;
    private String videoSize;
    private String videoSource;
    private String videoUrl;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /* 194 */   private boolean needEncrypt = false;


    public String getCategory() {
        /* 103 */
        return this.category;

    }


    public void setCategory(String category) {
        /* 100 */
        this.category = category;

    }


    public String getContent() {
        /* 110 */
        return this.content;

    }


    public void setContent(String content) {
        /* 107 */
        this.content = content;

    }


    public FileItem getCover() {
        /* 117 */
        return this.cover;

    }


    public void setCover(FileItem cover) {
        /* 114 */
        this.cover = cover;

    }


    public String getDesc() {
        /* 124 */
        return this.desc;

    }


    public void setDesc(String desc) {
        /* 121 */
        this.desc = desc;

    }


    public String getMsgType() {
        /* 131 */
        return this.msgType;

    }


    public void setMsgType(String msgType) {
        /* 128 */
        this.msgType = msgType;

    }


    public String getSourceExtInfo() {
        /* 138 */
        return this.sourceExtInfo;

    }


    public void setSourceExtInfo(String sourceExtInfo) {
        /* 135 */
        this.sourceExtInfo = sourceExtInfo;

    }


    public String getTitle() {
        /* 145 */
        return this.title;

    }


    public void setTitle(String title) {
        /* 142 */
        this.title = title;

    }


    public String getUniqueMsgId() {
        /* 152 */
        return this.uniqueMsgId;

    }


    public void setUniqueMsgId(String uniqueMsgId) {
        /* 149 */
        this.uniqueMsgId = uniqueMsgId;

    }


    public String getVideoLength() {
        /* 159 */
        return this.videoLength;

    }


    public void setVideoLength(String videoLength) {
        /* 156 */
        this.videoLength = videoLength;

    }


    public List<String> getVideoSamples() {
        /* 166 */
        return this.videoSamples;

    }


    public void setVideoSamples(List<String> videoSamples) {
        /* 163 */
        this.videoSamples = videoSamples;

    }


    public String getVideoSize() {
        /* 173 */
        return this.videoSize;

    }


    public void setVideoSize(String videoSize) {
        /* 170 */
        this.videoSize = videoSize;

    }


    public String getVideoSource() {
        /* 180 */
        return this.videoSource;

    }


    public void setVideoSource(String videoSource) {
        /* 177 */
        this.videoSource = videoSource;

    }


    public String getVideoUrl() {
        /* 187 */
        return this.videoUrl;

    }


    public void setVideoUrl(String videoUrl) {
        /* 184 */
        this.videoUrl = videoUrl;

    }


    public String getNotifyUrl() {
        /* 197 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /* 201 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /* 205 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /* 209 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /* 213 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /* 216 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /* 224 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /* 220 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /* 232 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /* 228 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /* 236 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /* 240 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /* 244 */
        return "alipay.open.public.life.msg.send";

    }


    public Map<String, String> getTextParams() {
        /* 248 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 249 */
        txtParams.put("category", this.category);
        /* 250 */
        txtParams.put("content", this.content);
        /* 251 */
        txtParams.put("desc", this.desc);
        /* 252 */
        txtParams.put("msg_type", this.msgType);
        /* 253 */
        txtParams.put("source_ext_info", this.sourceExtInfo);
        /* 254 */
        txtParams.put("title", this.title);
        /* 255 */
        txtParams.put("unique_msg_id", this.uniqueMsgId);
        /* 256 */
        txtParams.put("video_length", this.videoLength);
        /* 257 */
        txtParams.put("video_samples", this.videoSamples);
        /* 258 */
        txtParams.put("video_size", this.videoSize);
        /* 259 */
        txtParams.put("video_source", this.videoSource);
        /* 260 */
        txtParams.put("video_url", this.videoUrl);
        /* 261 */
        if (this.udfParams != null) {
            /* 262 */
            txtParams.putAll(this.udfParams);

        }
        /* 264 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 268 */
        if (this.udfParams == null) {
            /* 269 */
            this.udfParams = new AlipayHashMap();

        }
        /* 271 */
        this.udfParams.put(key, value);

    }


    public Map<String, FileItem> getFileParams() {
        /* 275 */
        Map params = new HashMap();
        /* 276 */
        params.put("cover", this.cover);
        /* 277 */
        return params;

    }


    public Class<AlipayOpenPublicLifeMsgSendResponse> getResponseClass() {
        /* 281 */
        return AlipayOpenPublicLifeMsgSendResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 286 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 292 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipayOpenPublicLifeMsgSendRequest
 * JD-Core Version:    0.6.0
 */
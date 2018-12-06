package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;


public class AlipaySocialBaseMcommentNewsfeedAddModel extends AlipayObject {
    private static final long serialVersionUID = 6161551894846829654L;


    @ApiField("activity_address")
    private String activityAddress;


    @ApiField("activity_name")
    private String activityName;


    @ApiField("aid")
    private String aid;


    @ApiField("biz_no")
    private String bizNo;


    @ApiField("content")
    private String content;


    @ApiField("gift_info")
    private NewsfeedMediaGiftInfo giftInfo;


    @ApiListField("img_infos")

    @ApiField("newsfeed_media_img")
    private List<NewsfeedMediaImg> imgInfos;


    @ApiField("label_info")
    private NewsfeedLabelInfo labelInfo;


    @ApiField("link_info")
    private NewsfeedMediaLinkInfo linkInfo;


    @ApiField("location_info")
    private NewsfeedLocationInfo locationInfo;


    @ApiField("location_name")
    private String locationName;


    @ApiField("location_scheme")
    private String locationScheme;


    @ApiField("scene_code")
    private String sceneCode;


    @ApiField("score")
    private Long score;


    @ApiField("source")
    private String source;


    @ApiField("source_icon")
    private String sourceIcon;


    @ApiField("source_name")
    private String sourceName;


    @ApiField("spread_range")
    private Long spreadRange;


    @ApiField("type")
    private String type;


    @ApiField("user_id")
    private String userId;


    @ApiField("video_info")
    private NewsfeedMediaVideoInfo videoInfo;


    @ApiField("visible")
    private Long visible;


    @ApiListField("visible_range")

    @ApiField("string")
    private List<String> visibleRange;


    @ApiListField("with_me")

    @ApiField("newsfeed_with_me_info")
    private List<NewsfeedWithMeInfo> withMe;


    public String getActivityAddress() {
        /* 175 */
        return this.activityAddress;

    }


    public void setActivityAddress(String activityAddress) {
        /* 178 */
        this.activityAddress = activityAddress;

    }


    public String getActivityName() {
        /* 182 */
        return this.activityName;

    }


    public void setActivityName(String activityName) {
        /* 185 */
        this.activityName = activityName;

    }


    public String getAid() {
        /* 189 */
        return this.aid;

    }


    public void setAid(String aid) {
        /* 192 */
        this.aid = aid;

    }


    public String getBizNo() {
        /* 196 */
        return this.bizNo;

    }


    public void setBizNo(String bizNo) {
        /* 199 */
        this.bizNo = bizNo;

    }


    public String getContent() {
        /* 203 */
        return this.content;

    }


    public void setContent(String content) {
        /* 206 */
        this.content = content;

    }


    public NewsfeedMediaGiftInfo getGiftInfo() {
        /* 210 */
        return this.giftInfo;

    }


    public void setGiftInfo(NewsfeedMediaGiftInfo giftInfo) {
        /* 213 */
        this.giftInfo = giftInfo;

    }


    public List<NewsfeedMediaImg> getImgInfos() {
        /* 217 */
        return this.imgInfos;

    }


    public void setImgInfos(List<NewsfeedMediaImg> imgInfos) {
        /* 220 */
        this.imgInfos = imgInfos;

    }


    public NewsfeedLabelInfo getLabelInfo() {
        /* 224 */
        return this.labelInfo;

    }


    public void setLabelInfo(NewsfeedLabelInfo labelInfo) {
        /* 227 */
        this.labelInfo = labelInfo;

    }


    public NewsfeedMediaLinkInfo getLinkInfo() {
        /* 231 */
        return this.linkInfo;

    }


    public void setLinkInfo(NewsfeedMediaLinkInfo linkInfo) {
        /* 234 */
        this.linkInfo = linkInfo;

    }


    public NewsfeedLocationInfo getLocationInfo() {
        /* 238 */
        return this.locationInfo;

    }


    public void setLocationInfo(NewsfeedLocationInfo locationInfo) {
        /* 241 */
        this.locationInfo = locationInfo;

    }


    public String getLocationName() {
        /* 245 */
        return this.locationName;

    }


    public void setLocationName(String locationName) {
        /* 248 */
        this.locationName = locationName;

    }


    public String getLocationScheme() {
        /* 252 */
        return this.locationScheme;

    }


    public void setLocationScheme(String locationScheme) {
        /* 255 */
        this.locationScheme = locationScheme;

    }


    public String getSceneCode() {
        /* 259 */
        return this.sceneCode;

    }


    public void setSceneCode(String sceneCode) {
        /* 262 */
        this.sceneCode = sceneCode;

    }


    public Long getScore() {
        /* 266 */
        return this.score;

    }


    public void setScore(Long score) {
        /* 269 */
        this.score = score;

    }


    public String getSource() {
        /* 273 */
        return this.source;

    }


    public void setSource(String source) {
        /* 276 */
        this.source = source;

    }


    public String getSourceIcon() {
        /* 280 */
        return this.sourceIcon;

    }


    public void setSourceIcon(String sourceIcon) {
        /* 283 */
        this.sourceIcon = sourceIcon;

    }


    public String getSourceName() {
        /* 287 */
        return this.sourceName;

    }


    public void setSourceName(String sourceName) {
        /* 290 */
        this.sourceName = sourceName;

    }


    public Long getSpreadRange() {
        /* 294 */
        return this.spreadRange;

    }


    public void setSpreadRange(Long spreadRange) {
        /* 297 */
        this.spreadRange = spreadRange;

    }


    public String getType() {
        /* 301 */
        return this.type;

    }


    public void setType(String type) {
        /* 304 */
        this.type = type;

    }


    public String getUserId() {
        /* 308 */
        return this.userId;

    }


    public void setUserId(String userId) {
        /* 311 */
        this.userId = userId;

    }


    public NewsfeedMediaVideoInfo getVideoInfo() {
        /* 315 */
        return this.videoInfo;

    }


    public void setVideoInfo(NewsfeedMediaVideoInfo videoInfo) {
        /* 318 */
        this.videoInfo = videoInfo;

    }


    public Long getVisible() {
        /* 322 */
        return this.visible;

    }


    public void setVisible(Long visible) {
        /* 325 */
        this.visible = visible;

    }


    public List<String> getVisibleRange() {
        /* 329 */
        return this.visibleRange;

    }


    public void setVisibleRange(List<String> visibleRange) {
        /* 332 */
        this.visibleRange = visibleRange;

    }


    public List<NewsfeedWithMeInfo> getWithMe() {
        /* 336 */
        return this.withMe;

    }


    public void setWithMe(List<NewsfeedWithMeInfo> withMe) {
        /* 339 */
        this.withMe = withMe;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipaySocialBaseMcommentNewsfeedAddModel
 * JD-Core Version:    0.6.0
 */
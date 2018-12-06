package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

import java.util.Date;

public class AlipayOfflineMarketMcommentQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 5724252942351855462L;

    @ApiField("comment_id")
    private String commentId;

    @ApiField("comment_status")
    private String commentStatus;

    @ApiField("comment_time")
    private Date commentTime;

    @ApiField("score")
    private Long score;

    public String getCommentId() {
        /* 52 */
        return this.commentId;
    }

    public void setCommentId(String commentId) {
        /* 49 */
        this.commentId = commentId;
    }

    public String getCommentStatus() {
        /* 59 */
        return this.commentStatus;
    }

    public void setCommentStatus(String commentStatus) {
        /* 56 */
        this.commentStatus = commentStatus;
    }

    public Date getCommentTime() {
        /* 66 */
        return this.commentTime;
    }

    public void setCommentTime(Date commentTime) {
        /* 63 */
        this.commentTime = commentTime;
    }

    public Long getScore() {
        /* 73 */
        return this.score;
    }

    public void setScore(Long score) {
        /* 70 */
        this.score = score;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOfflineMarketMcommentQueryResponse
 * JD-Core Version:    0.6.0
 */
package com.alipay.api.response;


import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;


public class AlipayBossCsChannelQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 3371415425159579169L;


    @ApiField("att")
    private String att;


    @ApiField("comment")
    private String comment;


    @ApiField("connection_rate")
    private String connectionRate;


    @ApiField("curr_agent_talking")
    private String currAgentTalking;


    @ApiField("curr_agents_logged_in")
    private String currAgentsLoggedIn;


    @ApiField("curr_number_waiting_calls")
    private String currNumberWaitingCalls;


    @ApiField("current_not_ready_agents")
    private String currentNotReadyAgents;


    @ApiField("current_ready_agents")
    private String currentReadyAgents;


    @ApiField("row_key")
    private String rowKey;


    @ApiField("visitor_inflow")
    private String visitorInflow;


    @ApiField("visitor_response")
    private String visitorResponse;


    @ApiField("visitor_response_transfer")
    private String visitorResponseTransfer;


    public String getAtt() {
        /*  93 */
        return this.att;

    }


    public void setAtt(String att) {
        /*  90 */
        this.att = att;

    }


    public String getComment() {
        /* 100 */
        return this.comment;

    }


    public void setComment(String comment) {
        /*  97 */
        this.comment = comment;

    }


    public String getConnectionRate() {
        /* 107 */
        return this.connectionRate;

    }


    public void setConnectionRate(String connectionRate) {
        /* 104 */
        this.connectionRate = connectionRate;

    }


    public String getCurrAgentTalking() {
        /* 114 */
        return this.currAgentTalking;

    }


    public void setCurrAgentTalking(String currAgentTalking) {
        /* 111 */
        this.currAgentTalking = currAgentTalking;

    }


    public String getCurrAgentsLoggedIn() {
        /* 121 */
        return this.currAgentsLoggedIn;

    }


    public void setCurrAgentsLoggedIn(String currAgentsLoggedIn) {
        /* 118 */
        this.currAgentsLoggedIn = currAgentsLoggedIn;

    }


    public String getCurrNumberWaitingCalls() {
        /* 128 */
        return this.currNumberWaitingCalls;

    }


    public void setCurrNumberWaitingCalls(String currNumberWaitingCalls) {
        /* 125 */
        this.currNumberWaitingCalls = currNumberWaitingCalls;

    }


    public String getCurrentNotReadyAgents() {
        /* 135 */
        return this.currentNotReadyAgents;

    }


    public void setCurrentNotReadyAgents(String currentNotReadyAgents) {
        /* 132 */
        this.currentNotReadyAgents = currentNotReadyAgents;

    }


    public String getCurrentReadyAgents() {
        /* 142 */
        return this.currentReadyAgents;

    }


    public void setCurrentReadyAgents(String currentReadyAgents) {
        /* 139 */
        this.currentReadyAgents = currentReadyAgents;

    }


    public String getRowKey() {
        /* 149 */
        return this.rowKey;

    }


    public void setRowKey(String rowKey) {
        /* 146 */
        this.rowKey = rowKey;

    }


    public String getVisitorInflow() {
        /* 156 */
        return this.visitorInflow;

    }


    public void setVisitorInflow(String visitorInflow) {
        /* 153 */
        this.visitorInflow = visitorInflow;

    }


    public String getVisitorResponse() {
        /* 163 */
        return this.visitorResponse;

    }


    public void setVisitorResponse(String visitorResponse) {
        /* 160 */
        this.visitorResponse = visitorResponse;

    }


    public String getVisitorResponseTransfer() {
        /* 170 */
        return this.visitorResponseTransfer;

    }


    public void setVisitorResponseTransfer(String visitorResponseTransfer) {
        /* 167 */
        this.visitorResponseTransfer = visitorResponseTransfer;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayBossCsChannelQueryResponse
 * JD-Core Version:    0.6.0
 */
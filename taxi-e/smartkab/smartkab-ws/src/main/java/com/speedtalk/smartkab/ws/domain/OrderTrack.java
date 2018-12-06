package com.speedtalk.smartkab.ws.domain;

public class OrderTrack extends DropOrder {
    private byte nodeId;

    public OrderTrack() {
        super();
    }

    public byte getNodeId() {
        return nodeId;
    }

    public void setNodeId(byte nodeId) {
        this.nodeId = nodeId;
    }

}

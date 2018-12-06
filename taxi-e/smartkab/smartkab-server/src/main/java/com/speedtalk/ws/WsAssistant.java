package com.speedtalk.ws;

import com.speedtalk.ClientInfo;
import com.speedtalk.protocol.ws.Utility;
import com.speedtalk.services.PhoenixWSStub;
import com.speedtalk.utils.ExcepPrinter;

import java.text.SimpleDateFormat;

public class WsAssistant {
    private static WsAssistant instance = new WsAssistant();
    private SimpleDateFormat sdf;
    private Utility utility;
    private PhoenixWSStub stub;

    private WsAssistant() {
        sdf = new SimpleDateFormat("yyyyMMdd");
        utility = new Utility();
    }

    public static WsAssistant getInstance() {
        return instance;
    }

    public String getAuthId() {
        return utility.encryptAuthId(ClientInfo.getInstance().getMsId(), ClientInfo.getInstance()
                .getPwd(), sdf.format(System.currentTimeMillis()));
    }

    public PhoenixWSStub getStub() {
        try {
            stub = new PhoenixWSStub();
        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
        return stub;
    }
}

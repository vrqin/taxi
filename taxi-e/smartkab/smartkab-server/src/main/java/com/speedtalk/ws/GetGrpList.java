package com.speedtalk.ws;

import com.speedtalk.ClientInfo;
import com.speedtalk.datas.xsd.GrpInfo;
import com.speedtalk.services.GetGrpListByMsId;
import com.speedtalk.services.PhoenixWSStub;

import java.rmi.RemoteException;

public class GetGrpList {
    private static GetGrpList instance = new GetGrpList();

    private GetGrpList() {
    }

    public static GetGrpList getInstance() {
        return instance;
    }

    public GrpInfo[] getGrpList(PhoenixWSStub stub) throws NullPointerException, RemoteException {
        GetGrpListByMsId grpList = new GetGrpListByMsId();
        grpList.setAuthId(WsAssistant.getInstance().getAuthId());
        grpList.setMsId(ClientInfo.getInstance().getMsId());
        return stub.getGrpListByMsId(grpList).get_return();
    }

    public GrpInfo[] getGrpList() throws NullPointerException, RemoteException {
        PhoenixWSStub stub = new PhoenixWSStub();
        stub._getServiceClient().getOptions().setTimeOutInMilliSeconds(40000);
        GetGrpListByMsId grpList = new GetGrpListByMsId();
        grpList.setAuthId(WsAssistant.getInstance().getAuthId());
        grpList.setMsId(ClientInfo.getInstance().getMsId());
        return stub.getGrpListByMsId(grpList).get_return();
    }
}

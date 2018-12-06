package com.speedtalk.ws;

import com.speedtalk.datas.xsd.GrpInfo;
import com.speedtalk.datas.xsd.MsInfoExt;
import com.speedtalk.kabs.KabInfo;
import com.speedtalk.services.GetMsListByGrpId;
import com.speedtalk.services.PhoenixWSStub;
import com.speedtalk.utils.ExcepPrinter;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

public class GetMsList {
    private static GetMsList instance = new GetMsList();

    private GetMsList() {
    }

    public static GetMsList getInstance() {
        return instance;
    }

    public MsInfoExt[] getMsListByGrpId(PhoenixWSStub stub, String grpId) throws NullPointerException, RemoteException {
        GetMsListByGrpId msList = new GetMsListByGrpId();
        msList.setAuthId(WsAssistant.getInstance().getAuthId());
        msList.setGrpId(grpId);
        return stub.getMsListByGrpId(msList).get_return();
    }

    public MsInfoExt[] getMsListByGrpId(String grpId) throws NullPointerException, RemoteException {
        PhoenixWSStub stub = new PhoenixWSStub();
        stub._getServiceClient().getOptions().setTimeOutInMilliSeconds(40000);
        GetMsListByGrpId msList = new GetMsListByGrpId();
        msList.setAuthId(WsAssistant.getInstance().getAuthId());
        msList.setGrpId(grpId);
        return stub.getMsListByGrpId(msList).get_return();
    }

    public Map<String, KabInfo> getAllMsViaWS() {
        HashMap<String, KabInfo> kabMap = new HashMap<String, KabInfo>();
        GrpInfo[] grps = null;
        try {
            grps = GetGrpList.getInstance().getGrpList();
        } catch (RemoteException e) {
            ExcepPrinter.print(e);
            return kabMap;
        }
        MsInfoExt[] msInfos = null;
        KabInfo kabInfo = null;
        try {
            for (GrpInfo grpInfo : grps) {
                try {
                    msInfos = getMsListByGrpId(grpInfo.getGrpId());
                    for (MsInfoExt msInfo : msInfos) {
                        if (null == kabMap.get(msInfo.getMsId())) {
                            kabInfo = new KabInfo();
                            kabInfo.setId(msInfo.getMsId());
                            kabInfo.setOnline((byte) msInfo.getOnline());
                            kabMap.put(msInfo.getMsId(), kabInfo);
                        }
                    }
                } catch (Exception e) {
                    ExcepPrinter.print(e);
                }
            }
        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
        return kabMap;
    }
}

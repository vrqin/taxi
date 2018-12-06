package com.speedtalk.workers;

import com.speedtalk.ClientInfo;
import com.speedtalk.KabConstants;
import com.speedtalk.StartUp;
import com.speedtalk.kabs.KabInfo;
import com.speedtalk.kabs.KabTeam;
import com.speedtalk.oldprotol.OptionConstants;
import com.speedtalk.oldprotol.mess.Query;
import com.speedtalk.utils.ExcepPrinter;
import com.speedtalk.utils.LoadXmlConfig;
import com.speedtalk.ws.GetMsList;

import java.util.Map;

/**
 * 获取终端信息
 */
public class GetKabs implements Runnable {
    private int sleepTime;

    public GetKabs() {
        sleepTime = 20;    //minute
    }

    @Override
    public void run() {
        Map<String, KabInfo> kabMap = null;
        Query query = new Query(ClientInfo.getInstance().getMsId(), OptionConstants.GRPS_OF_MS_QUERY);
        while (true) {
            try {
                if (LoadXmlConfig.getConfigHash().get("protocol").equals(KabConstants.PHOENIX_PROTOCOL)) {
                    kabMap = GetMsList.getInstance().getAllMsViaWS();
                    for (KabInfo kabInfo : kabMap.values())
                        KabTeam.getInstance().updateKab(kabInfo);
                } else {
                    ClientInfo.getInstance().getSession().write(query);
                    StartUp.LOG.debug(KabConstants.getOldLogPrefix() + query.toString());
                }
            } catch (Exception e) {
                ExcepPrinter.print(e);
            }

            try {
                sleepTime = Integer.parseInt(LoadXmlConfig.getConfigHash().get("get-kabs-sleep"));
                Thread.sleep(sleepTime * 60000);
            } catch (Exception e) {
            }
        }
    }
}

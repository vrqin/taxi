package com.speedtalk.order.engine.threads;

import com.speedtalk.order.engine.CompanySettingLoader;
import com.speedtalk.order.engine.KabInfoLoader;
import com.speedtalk.order.engine.OrderLogger;
import com.speedtalk.utils.LoadXmlConfig;

import java.util.concurrent.TimeUnit;

public class DataReloader implements Runnable {
    private static long sleep = 5;

    @Override
    public void run() {
        OrderLogger.getLogger().debug("DataReloader is running...");
        while (true) {
            try {
                sleep = Long.parseLong(LoadXmlConfig.getConfigHash().get("reload-data"));
            } catch (Exception e) {
            }
            try {
                TimeUnit.MINUTES.sleep(sleep);
            } catch (Exception e) {
            }

            KabInfoLoader.reloadKabInfos();
            CompanySettingLoader.loadCompanySetting();
        }
    }
}

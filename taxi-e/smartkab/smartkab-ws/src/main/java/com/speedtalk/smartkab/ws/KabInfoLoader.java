package com.speedtalk.smartkab.ws;

import com.speedtalk.smartkab.ws.dao.DriverDao;
import com.speedtalk.smartkab.ws.db.TabDriver;
import com.speedtalk.smartkab.ws.kabs.KabInfo;
import com.speedtalk.smartkab.ws.kabs.KabTeam;
import com.speedtalk.utils.ExcepPrinter;

import java.util.Map;

public class KabInfoLoader {
    private static DriverDao driverDao = new DriverDao();

    public static void loadKabInfos() {
        Map<String, TabDriver> driverMap = driverDao.getDriverMap();
        KabInfo kabInfo;
        for (TabDriver driver : driverMap.values()) {
            try {
                kabInfo = new KabInfo();
                kabInfo.setAccount(driver.getAccount());
                kabInfo.setMsId(driver.getMsid());
                kabInfo.setName(driver.getKabnum());
                kabInfo.setCarry(KabTeam.UNCARRY);
                kabInfo.setOnline(KabTeam.OFFLINE);
                kabInfo.setLg(null == driver.getLastlg() ? 0.0 : driver.getLastlg());
                kabInfo.setLt(null == driver.getLastlt() ? 0.0 : driver.getLastlt());
                kabInfo.setTime(null == driver.getGpstime() ? 0 : driver.getGpstime().getTime());
                kabInfo.setIsApp(KabTeam.APP);

                KabTeam.getInstance().updateKab(kabInfo);
            } catch (Exception e) {
                ExcepPrinter.print(e);
            }
        }
        System.out.println("加载司机信息：" + KabTeam.getInstance().getAllCount());
    }
}

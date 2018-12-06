package com.speedtalk.order.engine;

import com.speedtalk.order.engine.dao.DriverDao;
import com.speedtalk.order.engine.db.TabDriver;
import com.speedtalk.order.engine.kabs.KabInfo;
import com.speedtalk.order.engine.kabs.KabTeam;
import com.speedtalk.utils.ExcepPrinter;

import java.sql.Timestamp;
import java.util.Map;

public class KabInfoLoader {
    private static Timestamp lastTime;
    private static DriverDao driverDao = new DriverDao();

    public static void loadKabInfos() {
        Map<String, TabDriver> driverMap = driverDao.getDriverMap();
        updateLastTime(driverMap);
        updateKabInfo(driverMap);
    }

    public static void reloadKabInfos() {
        //		Map<String,TabDriver> driverMap = driverDao.getDriverMap(lastTime);
        Map<String, TabDriver> driverMap = driverDao.getDriverMap();
        updateLastTime(driverMap);
        updateKabInfo(driverMap);
    }

    private static void updateLastTime(Map<String, TabDriver> driverMap) {
        try {
            for (TabDriver driver : driverMap.values()) {
                lastTime = driver.getCurtime();
                break;
            }
        } catch (Exception e) {
        }
    }

    private static void updateKabInfo(Map<String, TabDriver> driverMap) {
        KabInfo kabInfo = null;
        for (TabDriver driver : driverMap.values()) {
            try {
                kabInfo = KabTeam.getInstance().getKab(driver.getAccount());

                if (null == kabInfo) {
                    kabInfo = new KabInfo();
                    kabInfo.setId(driver.getId());
                    kabInfo.setAccount(driver.getAccount());
                    //					kabInfo.setMsId(driver.getMsid());
                    //					kabInfo.setName(driver.getName());
                    //					kabInfo.setKabNum(driver.getKabnum());
                    kabInfo.setCarry(KabTeam.UNCARRY);
                    kabInfo.setOnline(KabTeam.OFFLINE);
                    //					kabInfo.setIsstop(driver.getIsstop());
                    kabInfo.setLg(null == driver.getLastlg() ? 0.0 : driver.getLastlg());
                    kabInfo.setLt(null == driver.getLastlt() ? 0.0 : driver.getLastlt());
                    kabInfo.setTime(null == driver.getGpstime() ? 0 : driver.getGpstime().getTime());
                    //					kabInfo.setIccard(driver.getIccard());
                    //					kabInfo.setPhone(driver.getPhone());
                    //					kabInfo.setClientId(driver.getClientId());
                    //					kabInfo.setRemain(driver.getRemain());
                } else {
                    //					kabInfo.setMsId(driver.getMsid());
                    //					kabInfo.setName(driver.getName());
                    //					kabInfo.setKabNum(driver.getKabnum());
                    //					kabInfo.setIsstop(driver.getIsstop());
                    //					kabInfo.setIccard(driver.getIccard());
                    //					kabInfo.setPhone(driver.getPhone());
                    if (kabInfo.getClientId() != driver.getClientId())
                        KabTeam.getInstance().removeClientKabInfo(kabInfo);
                    //					kabInfo.setClientId(driver.getClientId());
                    //					kabInfo.setRemain(driver.getRemain());
                }

                kabInfo.setMsId(driver.getMsid());
                kabInfo.setName(driver.getName());
                kabInfo.setKabNum(driver.getKabnum());
                kabInfo.setIsstop(driver.getIsstop());
                kabInfo.setIccard(driver.getIccard());
                kabInfo.setPhone(driver.getPhone());
                kabInfo.setClientId(null == driver.getClientId() ? 0 : driver.getClientId());
                kabInfo.setRemain(null == driver.getRemain() ? 0 : driver.getRemain());

                KabTeam.getInstance().updateKab(kabInfo);
            } catch (Exception e) {
                ExcepPrinter.print(e);
            }
        }
        OrderLogger.log(OrderLogger.VERSION + " Load driver info：" + driverMap.size());
    }
}

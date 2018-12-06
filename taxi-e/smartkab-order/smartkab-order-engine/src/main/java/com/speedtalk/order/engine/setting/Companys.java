package com.speedtalk.order.engine.setting;

import com.speedtalk.order.engine.db.TabClientSetting;
import com.speedtalk.utils.ExcepPrinter;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Companys {
    private static Companys instance = new Companys();
    private ConcurrentHashMap<Integer, CompanySetting> settingMap;

    private Companys() {
        settingMap = new ConcurrentHashMap<>();
    }

    public static Companys getInstance() {
        if (null == instance)
            instance = new Companys();
        return instance;
    }

    public void update(List<TabClientSetting> list) {
        if (list != null) {
            CompanySetting setting;
            for (TabClientSetting s : list) {
                try {
                    setting = settingMap.get(s.getClientid());
                    try {
                        setting.setDropOrder(s.getDroporder());
                        setting.setWaitMinute(s.getWaitminute());
                        setting.setSmsId(s.getSmsid());
                        setting.setSmsKey(s.getSmskey());
                        setting.setSmsCancelId(s.getSmscancelid());
                        setting.setDistance(s.getDistance());
                        setting.setAreaCode(s.getAreaname());
                    } catch (Exception e) {
                        setting = new CompanySetting(s.getClientid(), s.getDroporder(), s.getWaitminute(), s.getSmsid(), s
                                .getSmskey(), s.getSmscancelid(), s.getDistance(), s.getAreaname());
                        settingMap.put(setting.getId(), setting);
                    }
                } catch (Exception e) {
                    ExcepPrinter.print(e);
                }
            }
        }
    }

    public CompanySetting getSetting(int companyId) {
        try {
            return settingMap.get(companyId);
        } catch (Exception e) {
            return null;
        }
    }

    public CompanySetting getSettingByAreaCode(String areaCode) {
        try {
            for (CompanySetting set : settingMap.values()) {
                if (set.getAreaCode() != null && set.getAreaCode().equals(areaCode))
                    return set;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}

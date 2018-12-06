package com.speedtalk.order.engine;

import com.speedtalk.order.engine.dao.BaseDao;
import com.speedtalk.order.engine.db.TabClientSetting;
import com.speedtalk.order.engine.setting.Companys;
import com.speedtalk.utils.ExcepPrinter;
import org.hibernate.criterion.DetachedCriteria;

import java.util.ArrayList;
import java.util.List;

public class CompanySettingLoader {
    private static BaseDao baseDao = new BaseDao();

    public static void loadCompanySetting() {
        Companys.getInstance().update(getSettings());
    }

    private static List<TabClientSetting> getSettings() {
        List<TabClientSetting> list = new ArrayList<TabClientSetting>();
        DetachedCriteria dc = DetachedCriteria.forClass(TabClientSetting.class);
        try {
            for (Object o : baseDao.findByDetachedCriteria(dc)) {
                list.add((TabClientSetting) o);
            }
        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
        return list;
    }
}

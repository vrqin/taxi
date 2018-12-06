package com.speedtalk.smartkab.ws.kabs;

import com.speedtalk.smartkab.ws.Utils;
import com.speedtalk.utils.LoadXmlConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class KabTeam {
    public static final byte OFFLINE = 0;
    public static final byte ONLINE = 1;

    public static final byte UNCARRY = 0;    //空载
    public static final byte CARRY = 1;        //载客

    public static final byte APP = 0;
    public static final byte UNAPP = 1;
    private static KabTeam instance = new KabTeam();
    private long offlineTime = 15 * 60000;
    /**
     * key:account
     */
    private ConcurrentHashMap<String, KabInfo> allMap = new ConcurrentHashMap<String, KabInfo>();
    /**
     * key:name
     */
    private ConcurrentHashMap<String, KabInfo> onlineMap = new ConcurrentHashMap<String, KabInfo>();

    private KabTeam() {
    }

    public static KabTeam getInstance() {
        return instance;
    }

    public void updateKab(KabInfo newKab) throws NullPointerException {
        if (null == newKab || null == newKab.getAccount() || newKab.getAccount().trim().equals(""))
            throw new NullPointerException("Kab is null!");
        // KabInfo temp = allMap.get(newKab.getAccount());
        // if (null == temp)
        //     allMap.put(newKab.getAccount(), newKab);
        // else {
        //     temp.setOnline(newKab.getOnline());
        //     temp.setLg(newKab.getLg());
        //     temp.setLt(newKab.getLt());
        //     temp.setTime(newKab.getTime());
        // }

        allMap.put(newKab.getAccount().toUpperCase(), newKab);
        if (newKab.getOnline() == KabTeam.ONLINE)
            onlineMap.put(newKab.getName().toUpperCase(), newKab);
    }

    /**
     * find a Kab by kab account
     *
     * @param account
     * @return
     * @throws NullPointerException
     */
    public KabInfo getKab(String account) throws NullPointerException {
        if (null == account || account.trim().equals(""))
            throw new NullPointerException("Kab account is null!");
        return allMap.get(account.toUpperCase());
    }

    public KabInfo getKabByMsId(String msId) throws NullPointerException {
        if (null == msId || msId.trim().equals(""))
            throw new NullPointerException("Kab msId is null!");
        for (KabInfo kabInfo : allMap.values()) {
            if (kabInfo.getMsId().equals(msId))
                return kabInfo;
        }
        return null;
    }

    /**
     * 当Gps更新时间大于offlineTime作离线
     *
     * @return
     */
    public List<KabInfo> getOnlineKabs() {
        List<KabInfo> list = new ArrayList<>();
        try {
            offlineTime = Integer.parseInt(LoadXmlConfig.getConfigHash().get("offline-gps-time")) * 60000;
        } catch (Exception e) {
            e.printStackTrace();
        }
        long curTime = System.currentTimeMillis();
        for (KabInfo kab : onlineMap.values()) {
            if (curTime - kab.getTime() <= offlineTime)
                list.add(kab);
        }
        System.out.println(Utils.getLogFix() + " online kab: " + list.size());
        return list;
    }

    public int getOnlineCount() {
        return onlineMap.size();
    }

    public int getAllCount() {
        return allMap.size();
    }
}

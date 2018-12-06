package com.speedtalk.kabs;

import com.speedtalk.utils.LoadXmlConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class KabTeam {
    public static final byte OFFLINE = 0;
    public static final byte ONLINE = 1;

    public static final byte UNCARRY = 0;    //空载
    public static final byte CARRY = 1;        //载客
    private static KabTeam instance = new KabTeam();
    private long offlineTime = 15 * 60000;
    private ConcurrentHashMap<String, KabInfo> kabMap = new ConcurrentHashMap<String, KabInfo>();

    private KabTeam() {
    }

    public static KabTeam getInstance() {
        return instance;
    }

    /**
     * add Kab
     *
     * @param newKab
     * @return oldKab or null
     * @throws NullPointerException newKab is null or newKab.id is null
     */
    public KabInfo addKab(KabInfo newKab) throws NullPointerException {
        if (null == newKab || null == newKab.getId() || newKab.getId().trim().equals(""))
            throw new NullPointerException("Kab is null!");
        KabInfo temp = kabMap.get(newKab.getId());
        kabMap.put(newKab.getId(), newKab);
        return temp;
    }

    public void updateKab(KabInfo newKab) throws NullPointerException {
        if (null == newKab || null == newKab.getId() || newKab.getId().trim().equals(""))
            throw new NullPointerException("Kab is null!");
        KabInfo temp = kabMap.get(newKab.getId());
        if (null == temp)
            kabMap.put(newKab.getId(), newKab);
        else
            temp.setOnline(newKab.getOnline());
    }

    /**
     * find a Kab by kab id
     *
     * @param id
     * @return
     * @throws NullPointerException
     */
    public KabInfo getKab(String id) throws NullPointerException {
        if (null == id || id.trim().equals(""))
            throw new NullPointerException("Kab id is null!");
        return kabMap.get(id);
    }

    /**
     * 当Gps更新时间大于offlineTime作离线
     *
     * @return
     */
    public List<KabInfo> getOnlineKabs() {
        List<KabInfo> list = new ArrayList<KabInfo>();
        try {
            offlineTime = Integer.parseInt(LoadXmlConfig.getConfigHash().get("offline-gps-time")) * 60000;
        } catch (Exception e) {
            // TODO: handle exception
        }
        long curTime = System.currentTimeMillis();
        for (KabInfo kab : kabMap.values()) {
            if (curTime - kab.getTime() <= offlineTime)
                list.add(kab);
        }
        return list;
    }

    public int getOnlineCount() {
        return getOnlineKabs().size();
    }
}

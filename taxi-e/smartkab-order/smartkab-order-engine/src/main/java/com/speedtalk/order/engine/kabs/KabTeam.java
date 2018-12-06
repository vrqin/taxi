package com.speedtalk.order.engine.kabs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class KabTeam {
    public static final byte OFFLINE = 0;
    public static final byte ONLINE = 1;

    public static final byte UNCARRY = 0;    //空载
    public static final byte CARRY = 1;        //载客

    public static final byte NORMAL = 0;        //停用
    private static KabTeam instance = new KabTeam();
    /**
     * key:account
     */
    private ConcurrentHashMap<String, KabInfo> kabMap = new ConcurrentHashMap<String, KabInfo>();
    /**
     * key:clientId
     */
    private ConcurrentHashMap<Integer, HashSet<KabInfo>> clientKabMap = new ConcurrentHashMap<Integer, HashSet<KabInfo>>();

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
     * @throws NullPointerException newKab is null or newKab.account is null
     */
    public KabInfo addKab(KabInfo newKab) throws NullPointerException {
        if (null == newKab || null == newKab.getAccount() || newKab.getAccount().trim().equals(""))
            throw new NullPointerException("Kab is null!");
        KabInfo temp = kabMap.get(newKab.getAccount().toUpperCase());
        kabMap.put(newKab.getAccount().toUpperCase(), newKab);

        saveOrUpdateClientMap(newKab);

        return temp;
    }

    private void saveOrUpdateClientMap(KabInfo newKab) {
        HashSet<KabInfo> set = clientKabMap.get(newKab.getClientId());
        if (set != null) {
            set.remove(newKab);
            set.add(newKab);
        } else {
            set = new HashSet<KabInfo>();
            set.add(newKab);
            clientKabMap.put(newKab.getClientId(), set);
        }
    }

    public void removeClientKabInfo(KabInfo kabInfo) throws NullPointerException {
        if (null == kabInfo || null == kabInfo.getAccount() || kabInfo.getAccount().trim().equals(""))
            throw new NullPointerException("Kab is null!");
        try {
            clientKabMap.get(kabInfo.getClientId()).remove(kabInfo);
        } catch (Exception e) {
        }
    }

    public void updateKab(KabInfo newKab) throws NullPointerException {
        if (null == newKab || null == newKab.getAccount() || newKab.getAccount().trim().equals(""))
            throw new NullPointerException("Kab is null!");

        kabMap.put(newKab.getAccount().toUpperCase(), newKab);

        saveOrUpdateClientMap(newKab);
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
        return kabMap.get(account.toUpperCase());
    }

    public KabInfo getKabByIccard(String iccard) throws NullPointerException {
        if (null == iccard || iccard.trim().equals(""))
            throw new NullPointerException("iccard is null!");
        for (KabInfo kabInfo : kabMap.values()) {
            if (iccard.equalsIgnoreCase(kabInfo.getIccard()))
                return kabInfo;
        }
        return null;
    }

    public KabInfo getKabById(int id) {
        for (KabInfo kabInfo : kabMap.values()) {
            if (kabInfo.getId() == id)
                return kabInfo;
        }
        return null;
    }

    public KabInfo getKabByMsId(String msId) throws NullPointerException {
        if (null == msId || msId.trim().equals(""))
            throw new NullPointerException("Kab msId is null!");
        for (KabInfo kabInfo : kabMap.values()) {
            if (kabInfo.getMsId().equals(msId))
                return kabInfo;
        }
        return null;
    }

    public void setOffLine(String account) {
        KabInfo kabInfo = getKab(account);
        try {
            kabInfo.setOnline(OFFLINE);
            try {
                kabInfo.getSession().close(true);
            } catch (Exception e) {
            }
            kabInfo.setSession(null);
        } catch (Exception e) {
        }
    }

    /**
     * 当Gps更新时间大于offlineTime作离线
     *
     * @return
     */
    public List<KabInfo> getOnlineKabs() {
        List<KabInfo> list = new ArrayList<KabInfo>();
        for (KabInfo kabInfo : kabMap.values()) {
            if (kabInfo.getSession() == null && kabInfo.getOnline() == ONLINE) {
                kabInfo.setOnline(OFFLINE);
                continue;
            }
            if (kabInfo.getOnline() == ONLINE)
                list.add(kabInfo);
        }
        return list;
    }

    public List<KabInfo> getOnlineKabs(int clientId) {
        List<KabInfo> list = new ArrayList<KabInfo>();
        try {
            for (KabInfo kabInfo : clientKabMap.get(clientId)) {
                if (kabInfo.getSession() == null && kabInfo.getOnline() == ONLINE) {
                    kabInfo.setOnline(OFFLINE);
                    continue;
                }
                if (kabInfo.getOnline() == ONLINE)
                    list.add(kabInfo);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<KabInfo> getKabByKabNum(String kabNum) {
        List<KabInfo> list = new ArrayList<KabInfo>();
        for (KabInfo kabInfo : kabMap.values()) {
            if (kabInfo.getKabNum().equalsIgnoreCase(kabNum))
                list.add(kabInfo);
        }
        return list;
    }

    public List<KabInfo> getForbidOrderKab() {
        List<KabInfo> list = new ArrayList<KabInfo>();

        for (KabInfo kabInfo : kabMap.values()) {
            try {
                if (kabInfo.getRemain() <= 0)
                    list.add(kabInfo);
            } catch (Exception e) {
            }
        }

        return list;
    }

    public int getOnlineCount() {
        return getOnlineKabs().size();
    }

    public int getAllCount() {
        return kabMap.size();
    }

    public Map<String, KabInfo> getAllKabInfo() {
        return kabMap;
    }
}

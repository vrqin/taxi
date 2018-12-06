package com.speedtalk.order.engine.threads;

import com.speedtalk.order.engine.OrderLogger;
import com.speedtalk.order.engine.kabs.KabInfo;
import com.speedtalk.order.engine.kabs.KabTeam;
import com.speedtalk.order.engine.setting.CompanySetting;
import com.speedtalk.order.engine.setting.Companys;
import com.speedtalk.utils.ExcepPrinter;
import com.speedtalk.utils.LoadXmlConfig;

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

/**
 * 当司机取消电召单到一定次数，将被系统禁止一段时间派单。
 * 该线程管理司机禁止派单的状态。
 * 所有禁止状态在每天0点解除。
 * <p>
 * 通过下面的配置来更改检测间隔，单位：分钟，默认值：3
 * <b><drop-order-check-interval>?</drop-order-check-interval></b>
 *
 * @author chen
 */
public class DropOrderChecker implements Runnable {
    private static final SimpleDateFormat DATE_SDF = new SimpleDateFormat("yyyyMMdd");
    private ThreadLocal<String> clearStatusDate = new ThreadLocal<String>();

    //	public DropOrderChecker()
    //	{
    //		clearStatusDate.set(DATE_SDF.format(System.currentTimeMillis()));
    //	}
    @Override
    public void run() {
        OrderLogger.getLogger().debug("DropOrderChecker is running...");
        clearStatusDate.set(DATE_SDF.format(System.currentTimeMillis()));
        int sleepMinute = 3;
        while (true) {
            try {
                sleepMinute = Integer.parseInt(LoadXmlConfig.getConfigHash().get("drop-order-check-interval"));
            } catch (Exception e) {
            }
            try {
                TimeUnit.MINUTES.sleep(sleepMinute);
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
            OrderLogger.getLogger().debug(">>>>>>>检测因取消电召单被禁止接单的司机!!!");
            if (isToClearStatus()) {
                clearAllStatus();
                clearStatusDate.set(DATE_SDF.format(System.currentTimeMillis()));
                OrderLogger.getLogger().debug(">>>>>>>所有司机因取消电召单被禁止接单的状态已经解除!!!");
                continue;
            }
            checkEveryKab();
        }
    }


    private void checkEveryKab() {
        try {
            CompanySetting setting = null;
            long currentTime = System.currentTimeMillis();
            for (KabInfo k : KabTeam.getInstance().getAllKabInfo().values()) {
                try {
                    if (!k.isCanAcceptOrder()) {
                        setting = Companys.getInstance().getSetting(k.getClientId());
                        if (currentTime - k.getStartwait() > setting.getWaitMinute() * 60000) {
                            k.clearWaitStatus();
                            OrderLogger.getLogger()
                                    .debug(">>>>>>>" + k.getAccount() + "因取消电召单被禁止接单超过" + setting.getWaitMinute() + "分钟,解除禁止派单!!!");
                            continue;
                        }
                        if (k.getDropcount() < setting.getDropOrder()) {
                            k.expandDropCount();
                            OrderLogger.getLogger()
                                    .debug(">>>>>>>" + k.getAccount() + "取消电召单" + k.getDropcount() + ",未达到禁止值,解除禁止派单!!!");
                            continue;
                        }
                    }
                } catch (Exception e) {
                    ExcepPrinter.print(e);
                }
            }
        } catch (Exception e) {
        }
    }

    private void clearAllStatus() {
        try {
            for (KabInfo k : KabTeam.getInstance().getAllKabInfo().values()) {
                try {
                    k.clearWaitStatus();
                } catch (Exception e) {
                    ExcepPrinter.print(e);
                }
            }
        } catch (Exception e) {
        }
    }

    private boolean isToClearStatus() {
        return DATE_SDF.format(System.currentTimeMillis()).compareTo(clearStatusDate.get()) > 0;
    }
}

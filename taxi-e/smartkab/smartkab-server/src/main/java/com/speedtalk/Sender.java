package com.speedtalk;

import com.speedtalk.kabs.KabInfo;
import com.speedtalk.kabs.KabTeam;
import com.speedtalk.protocol.tscobjs.SMS;
import com.speedtalk.utils.ExcepPrinter;

import java.text.SimpleDateFormat;

public class Sender {
    private static Sender instance = new Sender();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd hh:mm:ss");

    private Sender() {
    }

    public static Sender getInstance() {
        return instance;
    }

    /**
     * 发送短信
     *
     * @param orderNum
     * @param status
     * @param mobile
     * @param srcAddr
     * @param srcLg
     * @param srcLt
     * @param dstAddr
     * @param dstLg
     * @param dstLt
     * @throws NullPointerException
     */
    public int sendOrder(String orderNum, byte status, String mobile, String srcAddr, double srcLg, double srcLt, String dstAddr, double dstLg, double dstLt)
            throws NullPointerException {
        int count = 0;
        if (null == orderNum || orderNum.trim().equals(""))
            throw new NullPointerException("orderNum is null");
        if (null == srcAddr || srcAddr.trim().equals(""))
            throw new NullPointerException("srcAddr is null");
        if (null == dstAddr || dstAddr.trim().equals(""))
            throw new NullPointerException("dstAddr is null");
        String tempOrderNum = orderNum.replace("|", "-");
        String tempMobile = mobile.replace("|", "-");
        String tempSrcAddr = srcAddr.replace("|", "-");
        String tempDstAddr = dstAddr.replace("|", "-");
        StringBuilder contentBuf = new StringBuilder(KabConstants.ORDER_SMS_PRIFIX);
        contentBuf.append(KabConstants.ORDER_SMS_SEP)
                .append(tempOrderNum)
                .append(KabConstants.ORDER_SMS_SEP)
                .append(status)
                .append(KabConstants.ORDER_SMS_SEP)
                .append(tempMobile)
                .append(KabConstants.ORDER_SMS_SEP)
                .append(tempSrcAddr)
                .append(KabConstants.ORDER_SMS_SEP)
                .append(srcLg)
                .append(KabConstants.ORDER_SMS_SEP)
                .append(srcLt)
                .append(KabConstants.ORDER_SMS_SEP)
                .append(tempDstAddr)
                .append(KabConstants.ORDER_SMS_SEP)
                .append(dstLg)
                .append(KabConstants.ORDER_SMS_SEP)
                .append(dstLt);
        SMS sms = null;
        short i = 0;
        for (KabInfo info : KabTeam.getInstance().getOnlineKabs()) {
            sms = new SMS();
            sms.setMessNo(i++);
            sms.setSrcMsID(ClientInfo.getInstance().getMsId());
            sms.setDstMsID(info.getId());
            sms.setMsName("自动电召中心");
            sms.setTime(sdf.format(System.currentTimeMillis()));
            sms.setContent(contentBuf.toString());
            try {
                ClientInfo.getInstance().getSession().write(sms);
                count++;
                StartUp.LOG.debug(KabConstants.getPhoenixLogPrefix() + "send order sms:" + sms.toString());
            } catch (Exception e) {
                ExcepPrinter.print(e);
            }
        }
        return count;
    }

    /**
     * 发送取消订单短信
     *
     * @param mobile
     * @param srcAddr
     * @param msId
     * @return
     * @throws NullPointerException
     */
    public boolean sendSms(String mobile, String srcAddr, String msId) throws NullPointerException {
        boolean send = false;
        if (null == msId || msId.trim().equals(""))
            throw new NullPointerException("msId is null");
        StringBuilder contentBuf = new StringBuilder("客户：");
        contentBuf.append(mobile).append("。已取消电召！召车地址：").append(srcAddr);
        SMS sms = new SMS();
        sms.setMessNo((short) 1);
        sms.setSrcMsID(ClientInfo.getInstance().getMsId());
        sms.setDstMsID(msId);
        sms.setMsName("自动电召中心");
        sms.setTime(sdf.format(System.currentTimeMillis()));
        sms.setContent(contentBuf.toString());
        try {
            ClientInfo.getInstance().getSession().write(sms);
            send = true;
            StartUp.LOG.debug(KabConstants.getPhoenixLogPrefix() + "send order sms:" + sms.toString());
        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
        return send;
    }
}

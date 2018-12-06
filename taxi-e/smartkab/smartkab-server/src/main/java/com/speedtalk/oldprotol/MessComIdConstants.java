package com.speedtalk.oldprotol;

public class MessComIdConstants {
    /**
     * 请求连接
     */
    //	public static final int CONN = 0x00000002;
    public static final int CONN = 0x00000041;

    /**
     * 请求连接应答
     */
    //	public static final int CONN_RESP = 0x80000002;
    public static final int CONN_RESP = 0x80000041;

    /**
     * 拆除连接
     */
    public static final int TERM = 0x00000003;

    /**
     * 拆除连接应答
     */
    public static final int TERM_RESP = 0x80000003;

    /**
     * PTT呼叫
     */
    public static final int PTT = 0x00000004;

    /**
     * PTT呼叫应答
     */
    public static final int PTT_RESP = 0x80000004;

    /**
     * 呼入
     */
    public static final int PTT_IN = 0x00000006;

    /**
     * 呼入应答
     */
    public static final int PTT_IN_RESP = 0x80000006;

    /**
     * 释放PTT
     */
    public static final int HUP = 0x00000007;

    /**
     * 释放PTT应答
     */
    public static final int HUP_RESP = 0x80000007;

    /**
     * GRP方中止通话
     */
    public static final int HUPIN = 0x00000008;

    /**
     * GRP方中止通话应答
     */
    public static final int HUPIN_RESP = 0x80000008;

    /**
     * 状态更新通知
     */
    public static final int NOTIFY = 0x0000000B;

    /**
     * 状态更新通知应答
     */
    public static final int NOTIFY_RESP = 0x8000000B;

    /**
     * 查询请求
     */
    public static final int QUERY = 0x0000000C;

    /**
     * 查询请求应答
     */
    public static final int QUERY_RESP = 0x8000000C;

    /**
     * 心跳
     */
    public static final int HB = 0x0000000F;

    /**
     * 心跳应答
     */
    public static final int HB_RESP = 0x8000000F;

    /**
     * GPS消息起源
     */
    public static final int MO_GPS = 0x00000013;

    /**
     * GPS消息起源应答
     */
    public static final int MO_GPS_RESP = 0x80000013;

    /**
     * GPS消息终止
     */
    public static final int MT_GPS = 0x00000014;

    /**
     * GPS消息终止应答
     */
    public static final int MT_GPS_RESP = 0x80000014;

    /**
     * (SMS)请求群发短信
     */
    public static final int SMS = 0x00000017;

    /**
     * (SMS)请求群发短信应答
     */
    public static final int SMS_RESP = 0x80000017;

    /**
     * (SSMS)请求单/组发短信
     */
    public static final int SSMS = 0x00000018;

    /**
     * (SSMS) 请求单/组发短信应答
     */
    public static final int SSMS_RESP = 0x80000018;

    /**
     * 组建临时群组时，通知调度用户指令
     * 2011-02-15
     */
    public static final int DPTT_NOTIFY = 0x00000020;

    /**
     * 拆除临时群组成员
     */
    public static final int SPTT_TERM = 0x00000045;

    /**
     * 拆除临时群组成员应答
     */
    public static final int SPTT_TERM_RESP = 0x80000045;

    /**
     * 上行语音数据
     */
    public static final int MO_VOICE = 0x00000050;

    /**
     * 下行语音数据
     */
    public static final int MT_VOICE = 0x00000051;

    //*************电召群组********************
    /**
     * 调度用户拆除群组
     */
    public static final int HUP_EGRP = 0x00000051;

    /**
     * 调度用户拆除群组应答
     */
    public static final int HUP_EGRP_RESP = 0x80000051;

    /**
     * 临时群组呼叫
     */
    public static final int DPTT = 0x00000052;

    /**
     * 临时群组呼叫应答
     */
    public static final int DPTT_RESP = 0x80000052;

    /**
     * 调度用户群呼
     */
    public static final int PTT_ALL = 0x00000053;

    /**
     * 调度用户群呼应答
     */
    public static final int PTT_ALL_RESP = 0x80000053;

    /**
     * 调度用户强拆群组通话
     */
    public static final int FOR_HUP = 0x00000057;

    /**
     * 调度用户强拆群组通话应答
     */
    public static final int FOR_HUP_RESP = 0x80000057;
    /**
     * 强制挂断主叫通话
     */
    public static final int MS_HUP = 0x00000058;

    /**
     * 强制挂断主叫通话务应答
     */
    public static final int MS_HUP_RESP = 0x80000058;

    /**
     * 语音包
     */
    public static final int VOICE = 0x00000063;

    /**
     * 通知调度终端有复台
     */
    public static final int RES_CALL = 0x00000076;
}

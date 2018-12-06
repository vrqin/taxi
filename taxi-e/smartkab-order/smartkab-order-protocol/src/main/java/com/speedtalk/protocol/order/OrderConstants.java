package com.speedtalk.protocol.order;

/**
 * 电召单常量
 *
 * @author chen
 */
public class OrderConstants {
    /*=================订单状态==================*/
    /**
     * 新电召单
     */
    public static final Integer NEW_ORDER = 0;
    /**
     * 已派单
     */
    public static final Integer SENTED_ORDER = 1;
    /**
     * 已接单
     */
    public static final Integer ACCEPTED_ORDER = 2;
    /**
     * 已取消
     */
    public static final Integer DROPPED_ORDER = 3;
    /**
     * 已完成
     */
    public static final Integer FINISHED_ORDER = 4;
    /**
     * 无司机可派单
     */
    public static final Integer NO_DRIVER = 5;

    /*=================订单操作状态==================*/
    /**
     * 新电召单
     */
    public static final byte ORDER_TRACK_NEW = 1;
    /**
     * 下发电召单
     */
    public static final byte ORDER_TRACK_SEDT = 2;
    /**
     * 抢单
     */
    public static final byte ORDER_TRACK_ACCEPTED = 3;
    /**
     * 司机接到乘客
     */
    public static final byte ORDER_TRACK_FIND = 4;
    /**
     * 乘客上车
     */
    public static final byte ORDER_TRACK_GET_ON = 5;
    /**
     * 司机到达
     */
    public static final byte ORDER_TRACK_DRIVER_ARRIVED = 6;
    /**
     * 乘客到达
     */
    public static final byte ORDER_TRACK_PASSENGER_ARRIVED = 7;
    /**
     * 乘客取消电召单
     */
    public static final byte ORDER_TRACK_PASSENGER_CANCLE = 8;
    /**
     * 司机取消电召单
     */
    public static final byte ORDER_TRACK_DRIVER_CANCLE = 9;
    /**
     * 没有司机可派单
     */
    public static final byte ORDER_TRACK_NO_DRIVER = 10;

    /**
     * 订单已被抢
     */
    public static final byte ORDER_ACCEPTED = 20;

    /*=================订单类型==================*/
    /**
     * APP订单
     */
    public static final byte APP_ORDER = 0;
    /**
     * 微信订单
     */
    public static final byte WECHAT_ORDER = 1;
    /**
     * 电话订单
     */
    public static final byte PHONE_ORDER = 2;
    /**
     * 电话语音订单
     */
    public static final byte VOICE_ORDER = 3;

    /*=================支付结果==================*/
    /**
     * 支付成功
     */
    public static final String SUCCESS_PAY = "0";
    /**
     * 支付超时
     */
    public static final String TIMEOUT_PAY = "1";
}

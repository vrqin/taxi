package com.speedtalk.smartkab.ws;

public class Constants {
    public static final byte SUCCESS_RESP = 0;
    public static final String SUCCESS_DESC_RESP = "操作成功";

    public static final byte FAILURE_RESP = 1;
    public static final String FAILURE_DESC_RESP = "操作失败";

    public static final byte ACCOUNT_ERR_RESP = 2;
    public static final String ACCOUNT_ERR_DESC_RESP = "账号错误";

    public static final byte ACCOUNT_PWD_ERR_RESP = 3;
    public static final String ACCOUNT_PWD_ERR_DESC_RESP = "账号或密码错误";

    public static final byte ORDER_ERROR_RESP = 4;
    public static final String ORDER_ERROR_DESC_RESP = "电召单信息错误";

    public static final byte ORDER_FAILURE_RESP = 5;
    public static final String ORDER_FAILURE_DESC_RESP = "电召单提交失败";

    public static final byte REG_FAILURE_RESP = 6;
    public static final String REG_FAILURE_DESC_RESP = "注册用户失败";

    public static final byte O_PWD_FAILURE_RESP = 7;
    public static final String O_PWD_FAILURE_DESC_RESP = "旧密码错误";

    public static final byte N_PWD_FAILURE_RESP = 8;
    public static final String N_PWD_FAILURE_DESC_RESP = "非法的新密码";

    public static final byte U_PWD_FAILURE_RESP = 9;
    public static final String U_PWD_FAILURE_DESC_RESP = "修改密码失败";

    public static final byte MSID_ERR_RESP = 10;
    public static final String MSID_ERR_DESC_RESP = "终端ID错误";

    public static final byte ORDER_NUM_ERR_RESP = 11;
    public static final String ORDER_NUM_ERR_DESC_RESP = "电召单ID错误";

    public static final byte PARAM_ERR_RESP = 12;
    public static final String PARAM_ERR_DESC_RESP = "参数错误";

    public static final byte NO_DRIVER_RESP = 13;
    public static final String NO_DRIVER_DESC_RESP = "附近无空闲司机";

    public static final byte CODE_SENT_RESP = 14;
    public static final String CODE_SENT_DESC_RESP = "验证码已发送";

    public static final byte CODE_ERROR_RESP = 15;
    public static final String CODE_ERROR_DESC_RESP = "验证码错误";

    public static final byte CODE_TIMEOUT_RESP = 16;
    public static final String CODE_TIMEOUT_DESC_RESP = "验证码超时";

    public static final byte PHONE_ERROR_RESP = 17;
    public static final String PHOE_ERROR_DESC_RESP = "手机号码错误";

    public static final byte REGISTERED_RESP = 18;
    public static final String REGISTERED_DESC_RESP = "手机号码已注册";

    public static final byte NO_SET_PARAMTER = 19;
    public static final String NO_SET_PARAMTER_DESC = "没有设置参数";

    public static final Integer NEW_ORDER = 0;
    public static final Integer DROPPED_ORDER = 3;
    public static final Integer FINISHED_ORDER = 4;


    public static final byte BEST = 5;

    public static final byte PASSENGER = 0;
    public static final byte DRIVER = 1;

}

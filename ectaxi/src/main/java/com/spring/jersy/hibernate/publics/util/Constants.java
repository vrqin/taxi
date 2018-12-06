package com.spring.jersy.hibernate.publics.util;

public class Constants {
    public static final byte SUCCESS_RESP = 0;
    public static final String SUCCESS_DESC_RESP = "操作成功";

    public static final byte FAILURE_RESP = 1;
    public static final String FAILURE_DESC_RESP = "操作失败";
    public static final String FAILURE_MAX_NUM = "操作失败：超过最大数量";

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

    public static final byte EXISR_DRIVER_RESP = 14;
    public static final String EXISR_DRIVER_DESC_RESP = "用户存在";

    public static final byte DELDRIVER_RESP = 15;
    public static final String DELDRIVER_DESC_RESP = "该车辆有司机正在使用";


    public static final byte EXISR_CARINFO_KABNUM_RESP = 16;
    public static final String EXISR_CARINFO_KABNUM_DESC_RESP = "该车牌已存在";

    public static final byte DELDRIVERS_RESP = 17;
    public static final byte DELDRIVERS_ERROR = 18;
    public static final Integer NEW_ORDER = 0;
    public static final Integer DROPPED_ORDER = 3;
    public static final Integer FINISHED_ORDER = 4;
    public static final byte BEST = 5;
    public static final byte PASSENGER = 0;
    public static final byte DRIVER = 1;
    public static String DELDRIVERS_DESC_RESP = "车辆有司机正在使用";
    public static String DELDRIVERS_DESC_ERROR = "账号删除失败";

}

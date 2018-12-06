package com.speedtalk.protocol.order;

/**
 * 《司机APP和服务端通讯协议》常量
 *
 * @author chen
 */
public class OrderMessConstants {
    /**
     * 指令头
     */
    public static final String HEAD = "$order";
    /**
     * 分隔符
     */
    public static final String SPEPERATOR = "|";
    /**
     * 拆指令分隔符
     */
    public static final String SPLITTER = "\\|";

    /**
     * 回复结果：成功
     */
    public static final String SUCCESS = "0";
    /**
     * 回复结果：失败
     */
    public static final String FAILURE = "1";

    /**
     * 登录
     */
    public static final String LOGIN = "01";
    /**
     * 登录回复
     */
    public static final String LOGIN_RESP = "02";
    /**
     * 注销
     */
    public static final String LOGOUT = "03";
    /**
     * 注销回复
     */
    public static final String LOGOUT_RESP = "04";
    /**
     * 修改司机信息
     */
    public static final String UPDATE_DRIVER_INFO = "05";
    /**
     * 修改司机信息回复
     */
    public static final String UPDATE_DRIVER_INFO_RESP = "06";
    /**
     * 修改密码
     */
    public static final String UPDATE_PWD = "07";
    /**
     * 修改密码回复
     */
    public static final String UPDATE_PWD_RESP = "08";
    /**
     * 新订单
     */
    public static final String NEW_ORDER = "09";
    /**
     * 确认收到订单
     */
    public static final String NEW_ORDER_RESP = "10";
    /**
     * 接收订单
     */
    public static final String ACCEPT_ORDER = "11";
    /**
     * 确认接收订单
     */
    public static final String ACCEPT_ORDER_RESP = "12";
    /**
     * 取消订单
     */
    public static final String DROP_ORDER = "13";
    /**
     * 确认取消订单
     */
    public static final String DROP_ORDER_RESP = "14";
    /**
     * 接到乘客
     */
    public static final String GET_PASSENGER = "15";
    /**
     * 接到乘客回复
     */
    public static final String GET_PASSENGER_RESP = "16";
    /**
     * 到达
     */
    public static final String ARRIVED = "17";
    /**
     * 到达回复
     */
    public static final String ARRIVED_RESP = "18";
    /**
     * 强制下线
     */
    public static final String FORCE_LOGOUT = "19";
    /**
     * 订单交互通知
     */
    public static final String ORDER_INTERACTIVE = "21";
    /**
     * 通用确认
     */
    public static final String COMMOM_CONFIRM = "22";
    /**
     * 登录
     */
    public static final String LOGIN_EXT = "23";
    //	/**
    //	 * 登录回复
    //	 */
    //	public static final String LOGIN_RESP_EXT = "24";
    /**
     * 支付信息
     */
    public static final String PAY_INFO = "25";
    /**
     * 支付信息回复
     */
    public static final String PAY_INFO_RESP = "26";
    /**
     * 支付结果
     */
    public static final String PAY_RESULT = "27";
    /**
     * 通知信息
     */
    public static final String ORDER_SMS = "28";


    /**
     * 账号未登录
     */
    public static final String NOT_LOGIN_ERR = "E01";
    /**
     * 账号或密码错误
     */
    public static final String ACCOUNT_OR_PWD_ERR = "E02";
    /**
     * 旧密码错误
     */
    public static final String OLD_PWD_ERR = "E03";
    /**
     * 其它司机已接单
     */
    public static final String ORDER_ACCEPTED_ERR = "E04";
    /**
     * 司机信息错误
     */
    public static final String DRIVER_ERR = "E05";
    /**
     * 新密码错误
     */
    public static final String NEW_PWD_ERR = "E06";
    /**
     * 没抢单，不能取消
     */
    public static final String UNACCEPTED_DROP_ERR = "E07";
    /**
     * 订单已取消
     */
    public static final String ORDER_DROPPED_ERR = "E08";
    /**
     * 订单已完成
     */
    public static final String ORDER_FINISHED_ERR = "E09";
    /**
     * 订单不存在
     */
    public static final String ORDER_ERR = "E10";

    /**
     * 账号未登录
     */
    public static final String E01 = "账号未登录";
    /**
     * 账号或密码错误
     */
    public static final String E02 = "账号或密码错误";
    /**
     * 旧密码错误
     */
    public static final String E03 = "旧密码错误";
    /**
     * 其它司机已接单
     */
    public static final String E04 = "其它司机已接单";
    /**
     * 司机信息错误
     */
    public static final String E05 = "司机信息错误";
    /**
     * 新密码错误
     */
    public static final String E06 = "新密码错误";
    /**
     * 没抢单，不能取消
     */
    public static final String E07 = "没抢单，不能取消";
    /**
     * 订单已取消
     */
    public static final String E08 = "订单已取消";
    /**
     * 订单已完成
     */
    public static final String E09 = "订单已完成";
    /**
     * 订单不存在
     */
    public static final String E10 = "订单不存在";

    /**
     * 账号被停用
     */
    public static final String E11 = "账号被停用";

    /**
     * 没绑定司机卡
     */
    public static final String E12 = "没绑定司机卡";
    /**
     * 司机被限制抢单
     */
    public static final String E13 = "您被限制抢单";

    /**
     * 抢单失败提示模板
     */
    public static final String ACCEPT_ORDER_FAILURED_TIP = "? 已抢单";

    /**
     * 账号登录
     */
    public static final byte ACCOUNT_LOGIN_TYPE = 0;
    /**
     * 司机卡登录
     */
    public static final byte IC_CARD_LOGIN_TYPE = 1;

    /**
     * 现金支付
     */
    public static final byte CASH_PAY = 0;
    /**
     * 支付宝支付
     */
    public static final byte ALIPAY_PAY = 1;
    /**
     * 微信支付
     */
    public static final byte WECHAT_PAY = 2;

}

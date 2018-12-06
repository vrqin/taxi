package com.spring.jersy.hibernate.publics.util;


import com.spring.jersy.hibernate.model.entity.Callbuss;
import com.spring.jersy.hibernate.model.entity.Driver;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * <b>系统常量</b><br/>
 * 参数是可能会改变的全部去掉final<br/>
 * 属性值全部取自sysconfig.properties文件
 *
 * @author LuYun
 * @date 2013-10-10
 */
public class Constant {
    /**
     * 导出excel的记录数
     */
    public static int MAX_EXPORT_COUNT = 10000;
    /**
     * 总任务数
     */
    public static int MAX_TASKCOUNTS = 5;

    /**
     * 特殊任务数
     */
    public static int MAX_TASKCOUNT = 2;

    /**
     * 加急任务数
     */
    public static int P_MAX_TASKCOUNT = 3;

    /**
     * 48小时的长整型时间
     *
     * @date 2013-08-18 修改为24小时
     * @date 2013-10-16 修改为12小时
     */
    public static long MAX_TIME_LONG = 1000 * 60 * 60 * 12;//24小时的长整型时间

    /**
     * @date 2013-10-16 修改为24小时
     */
    public static long MAX_LAST_TIME_LONG = 1000 * 60 * 60 * 24;//48小时的长整型时间

    /**
     * 任务最大超时时间
     */
    public static int MAXTIMEOUT = 30;

    /**
     * 最大未办理完成数
     *
     * @date 2013-10-09 由50个修改为5个
     */
    public static int UNTASKCOUNT = 5;

    /**
     * 任务派发等待时间
     *
     * @date 2013-11-08
     */
    public static long TASK_WAIT_TIME = 1000 * 30;


    /**
     * 所有省份信息和城市信息
     */
    public static List<Driver> allDriverList = new CopyOnWriteArrayList<Driver>();


    public static List<Callbuss> allcallorer = new CopyOnWriteArrayList<Callbuss>();


    //    /**
    //     * 在线用户统计(用户id,users)
    //     */
    //    public static Map<Integer,Users> userOnlineInMap = new ConcurrentHashMap<Integer,Users>();


}

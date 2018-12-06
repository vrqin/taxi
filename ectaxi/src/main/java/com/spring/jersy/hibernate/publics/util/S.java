package com.spring.jersy.hibernate.publics.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 系统工具类
 */
public class S {
    public static final String STUDENT_S = "S";
    public static final String TEACHER_S = "T";
    public static final int STUDENT_I = 0;
    public static final int TEACHER_I = 1;
    //登录用户权限,9:管理员,8:用户,7:其他
    public static final int ROLE_SYSTEM_ADMIN = 9;
    public static final int ROLE_USER = 8;
    public static final int ROLE_TEMP = 7;
    //查询司机状态
    public static final int DRIVER_ONLINE = 1;
    public static final int DRIVER_OFFLINE = 2;
    public static final int DRIVER_ALL = 3;
    public static final String[] ICON_FORMAT = {"jpg", "jpge", "bmp"};
    public static final int MAX_SIZE = 5000 * 1024;
    public static final String FATHER = "1";
    public static final String MOTHER = "2";
    public static final int UNLOCK = 0;
    public static final int LOCK = 1;
    public static final int DELETE = 0;
    public static final int USEABLE = 1;
    //   接收者表 Recipient类的 成员类型
    public static final int REC_TYPE_HOMEWORKER = 1;
    public static final int REC_TYPE_SMSER = 2;
    public static final int REC_TYPE_ANNER = 3;
    //   接收者表 Recipient类的 是否被查看
    public static final int REC_ShOW_NO = 0;
    public static final int REC_ShOW_OK = 1;
    //性别
    public static final int BOY = 0;
    public static final int GIRL = 1;
    //是否锁定
    public static final int LOCK_NO = 0;
    public static final int LOCK_YES = 1;
    //是否被删除 0:被删除,1:存在
    public static final int ISDEL_NO = 1;
    public static final int ISDEL_YES = 0;
    public static final String TEACHER_ICON_PATH = "/file_stream/upload/teachers/";
    public static final String STUDENT_ICON_PATH = "/file_stream/upload/students/";
    public static final String PARENT_ICON_PATH = "/file_stream/upload/parents";
    public static final String HOMEWORK_ICON_PATH = "/file_stream/upload/homeworks";
    public static final String DRIVER_ICON_PATH = "/file_stream/upload/drivers/";
    public static final ConcurrentHashMap<String, Integer> EDUCATION_MAP = new ConcurrentHashMap<String, Integer>();
    public static final ConcurrentHashMap<String, Integer> SEX_MAP = new ConcurrentHashMap<String, Integer>();
    public static final ConcurrentHashMap<String, Integer> NATUER = new ConcurrentHashMap<String, Integer>();
    public static final ConcurrentHashMap<String, Integer> STUDYING_TYPE_MAP = new ConcurrentHashMap<String, Integer>();
    public static final ConcurrentHashMap<String, Integer> OPERTYPE = new ConcurrentHashMap<String, Integer>();
    public static final ConcurrentHashMap<String, Integer> CALLINGSTATUS = new ConcurrentHashMap<String, Integer>();
    public static String paths = S.class.getResource("").getPath();
    public static String charSet = "UTF-8";
    public static String fltModel = "/html/ftl";
    public static int CallingSS = 1;
    public static int EnterpriseBS = 2;
    public static int MonitoringSS = 3;
    public static int SeatsCC = 4;
    public static int ServiceES = 5;
    public static int ComprehensiveAS = 6;
    public static int DynamicIS = 7;
    public static int OperationSC = 8;
    public static String ADDSUCCESS = "添加成功！";
    public static String DELSUCCESS = "删除成功！";
    public static String DELERROR = "删除失败！";
    public static String UPASUCCESS = "修改成功！";

    static {
        EDUCATION_MAP.put("专科", 1);
        EDUCATION_MAP.put("本科", 2);
        EDUCATION_MAP.put("博士", 3);
        EDUCATION_MAP.put("硕士", 4);
        EDUCATION_MAP.put("高中", 5);
        EDUCATION_MAP.put("技师", 6);
        EDUCATION_MAP.put("其他", 7);

        SEX_MAP.put("男", 0);
        SEX_MAP.put("女", 1);

        NATUER.put("农村", 0);
        NATUER.put("城镇", 1);

        STUDYING_TYPE_MAP.put("住校生", 0);
        STUDYING_TYPE_MAP.put("通宿生", 1);
        //        0新业务 1:已下呼 2:已租车 3:已取消 4:已完成',5,附近没车
        OPERTYPE.put("新业务", 0);
        OPERTYPE.put("已下呼", 1);
        OPERTYPE.put("已租车", 2);
        OPERTYPE.put("已取消", 3);
        OPERTYPE.put("已完成", 4);
        OPERTYPE.put("附近没车", 5);

        CALLINGSTATUS.put("新电召单", 1);
        CALLINGSTATUS.put("下发电召单", 2);
        CALLINGSTATUS.put("抢单", 3);
        CALLINGSTATUS.put("接到乘客", 4);
        CALLINGSTATUS.put("乘客上车", 5);
        CALLINGSTATUS.put("司机到达", 6);
        CALLINGSTATUS.put("乘客到达", 7);
        CALLINGSTATUS.put("乘客取消电召单", 8);
        CALLINGSTATUS.put("司机取消电召单", 9);
        CALLINGSTATUS.put("没有司机可派单", 10);

    }


    public static String getKeyByValue(Integer value, Map<String, Integer> map) {
        try {
            Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
            Map.Entry<String, Integer> entry;
            for (Iterator<Map.Entry<String, Integer>> ite = entrySet.iterator(); ite.hasNext(); ) {
                entry = ite.next();
                if (entry.getValue() == value) {
                    return entry.getKey();
                }
            }
        } catch (NullPointerException npe) {

        }
        return "";
    }

    /**
     * 字符对象为空
     *
     * @param param
     * @return
     */
    public static boolean isNull(String param) {
        return (param == null || param.length() == 0 || param.trim().equals(""));
    }

    /**
     * 类对象为空
     *
     * @param param
     * @return
     */
    public static boolean isNull(Object param) {
        return (param == null || param.equals(""));
    }

    /**
     * 多个对象是否为空
     *
     * @param params
     * @return
     */
    public static boolean isNulls(Object... params) {
        boolean bool = true;
        for (Object o : params) {
            if (o == null || o.equals("")) {
                bool = false;
                break;
            }
        }
        return bool;
    }

    /**
     * Map 集合对象为空
     *
     * @param map
     * @return
     */
    public static boolean isMapNull(Map map) {
        return (map == null || map.size() <= 0);
    }

    /**
     * List 集合对象为空
     *
     * @param list
     * @return
     */
    public static boolean isListNull(List list) {
        return (list == null || list.size() <= 0);
    }

    public static String getPath() {
        int index = paths.indexOf("WEB-INF");
        return paths.substring(0, index - 1);
    }

    /**
     * 把string数组转成Long数组
     */
    public static Long[] converToLong(String[] strs) {    // 将String数组转换为Long类型数组
        Long[] longs = new Long[strs.length];             // 声明long类型的数组
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];                        // 将strs字符串数组中的第i个值赋值给str
            long thelong = Long.valueOf(str);            // 将str转换为long类型，并赋值给thelong
            longs[i] = thelong;                          // 将thelong赋值给 longs数组中对应的地方
        }
        return longs;
    }

    /**
     * 把string数组转成Integer数组
     */
    public static Integer[] converToInteger(String[] strs) {
        Integer[] ints = new Integer[strs.length];
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            int theint = Integer.valueOf(str);
            ints[i] = theint;
        }
        return ints;
    }


    /**
     * 判断字符串是否为整型
     *
     * @param s
     * @return
     */
    public static boolean isInteger(String s) {
        if (s != null && !"".equals(s))
            return s.matches("^[0-9]*$");
        else
            return false;
    }

    /**
     * 判断字符串是否为数字
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        int begin = 0;
        boolean once = true;
        if (str == null || "".equals(str.trim())) {
            return false;
        }
        str = str.trim();
        if (str.startsWith("+") || str.startsWith("-")) {
            if (str.length() == 1) {
                // "+" "-"
                return false;
            }
            begin = 1;
        }
        for (int i = begin; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                if (str.charAt(i) == '.' && once) {
                    // '.' can only once
                    once = false;
                } else {
                    return false;
                }
            }
        }
        if (str.length() == (begin + 1) && !once) {
            // "." "+." "-."
            return false;
        }
        return true;
    }

    /**
     * 判断字符串是否有汉字
     *
     * @param str 要验证的字符串
     * @return true:含有汉字,false:没有汉字
     */
    public static boolean isChineseChar(String str) {
        boolean temp = false;
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            temp = true;
        }
        return temp;
    }

    /**
     * 检测头像的格式
     *
     * @param fix 上传文件后缀名
     * @return true:文件格式正确;false:文件格式错误
     */
    public static boolean checkUploadIconFormat(String fix) {
        for (String str : ICON_FORMAT) {
            if (str.equals(fix))
                return true;
        }
        return false;
    }

    /**
     * 检测上传文件大小
     *
     * @param len
     * @return true:大小合适;false:文件太大
     */
    public static boolean checkUploadFileSize(long len) {
        return len < MAX_SIZE;
    }

    public static String randomStr(int count) {
        Random random = new Random();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < count; i++)
            buffer.append(random.nextInt(10));
        return buffer.toString();
    }


    //获取服务器当前时间
    public static String getNowServerDatetime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(System.currentTimeMillis());
    }

    //获取服务器当前时间
    public static String getNowDatetime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        return (df.format(new Date()));// new Date()为获取当前系统时间
    }

    //获取时间
    public static String getValidityDatetime(int data) {
        Calendar calendar = Calendar.getInstance();
        Date date = new Date(System.currentTimeMillis());
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, data);
        date = calendar.getTime();
        return date.toString();
    }

    /**
     * 将时间转换为时间戳
     */
    public static String dateToStamp(String s) throws ParseException {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
    }


    /**
     * 将时间戳转换为时间
     */
    public static String stampToDate(String s) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }


    public static boolean belongCalendar(Date time, Date from, Date to) {
        Calendar date = Calendar.getInstance();
        date.setTime(time);

        Calendar after = Calendar.getInstance();
        after.setTime(from);

        Calendar before = Calendar.getInstance();
        before.setTime(to);

        if (date.after(after) && date.before(before)) {
            return true;
        } else {
            return false;
        }
    }
}

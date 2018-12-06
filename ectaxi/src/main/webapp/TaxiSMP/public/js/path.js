/*
* JAVA接口域名路径
*/


//放到外网把这个删除
var picturepath = "http://192.168.1.107:8087/";
// var path = "http://192.168.1.107:8087/resource";
// var path = "http://ms.ectaxi.cn:8088/TaxiSMPWS";
// var outloginPath = "http://192.168.1.107:8087/TaxiSMP/index.jsp";
// var outloginPath = "http://ms.ectaxi.cn:8088/2.0";
var seatpath="http://192.168.1.231:9999";


var path = "http://localhost:8080/resource";
var outloginPath = "http://localhost:8080/TaxiSMP/index.jsp";




$(function () {

    $("#outlogin").click(function () {

        outlogin(sessionStorage.accountID);
        window.location.href = outloginPath;
        sessionStorage.seat = "";

    });
});

function outlogin(userid) {
    var requestURL = path + "/userinfo/logOut?userid=" + userid;
    $.ajax({
        type: "GET",
        url: requestURL,
        async: false,
        cache: false
    });
}

/*
 ** easyui 月份微调函数
 */
function formatter2(date) {
    if (!date) {
        return '';
    }
    var y = date.getFullYear();
    var m = date.getMonth() + 1;
    return y + '-' + (m < 10 ? ('0' + m) : m);
}

function parser2(s) {
    if (!s) {
        return null;
    }
    var ss = s.split('-');
    var y = parseInt(ss[0], 10);
    var m = parseInt(ss[1], 10);
    if (!isNaN(y) && !isNaN(m)) {
        return new Date(y, m - 1, 1);
    } else {
        return new Date();
    }
}

/*
 ** 时间戳转为可阅读时间格式
 */
function formattime(data) {
    function add0(m) {
        return m < 10 ? '0' + m : m
    }

    //shijianchuo是整数，否则要parseInt转换
    var time = new Date(data);
    var y = time.getFullYear();
    var m = time.getMonth() + 1;
    var d = time.getDate();
    var h = time.getHours();
    var mm = time.getMinutes();
    var s = time.getSeconds();
    var timeStr = y + '-' + add0(m) + '-' + add0(d) + ' ' + add0(h) + ':' + add0(mm) + ':' + add0(s);
    //删除闭包函数和清空局部变量
    add0 = time = y = m = d = h = mm = s = null;
    return timeStr;
}

/*
 ** 获取当天凌晨00:00和明天凌晨00:00时间，参数为"start"返回当天时间，参数为"end"返回明天时间
 */
function todayTime(argument) {
    var todayStartTime,		//今天开始时间，默认从凌晨00:00:00开始
        todayEndTime;		//今天结束时间，默认到第二天凌晨00:00:00结束
    todayStartTime = new Date();
    todayStartTime.setHours(0);
    todayStartTime.setMinutes(0);
    todayStartTime.setSeconds(0);
    todayStartTime.setMilliseconds(0);
    todayEndTime = new Date(todayStartTime);
    todayEndTime.setDate(todayStartTime.getDate() + 1);
    if (argument === "start") {
        return formattime(todayStartTime);
    } else if (argument === "end") {
        return formattime(todayEndTime);
    }
}

/**
 * 获取时间
 * 0为当前时间
 * 1为明天时间
 * -1为前天时间
 * @param AddDayCount
 * @returns {string}
 * @constructor
 */
function GetDateStr(AddDayCount) {
    var dd = new Date();
    dd.setDate(dd.getDate() + AddDayCount);//获取AddDayCount天后的日期
    var y = dd.getFullYear();
    var m = (dd.getMonth() + 1) < 10 ? "0" + (dd.getMonth() + 1) : (dd.getMonth() + 1);//获取当前月份的日期，不足10补0
    var d = dd.getDate() < 10 ? "0" + dd.getDate() : dd.getDate(); //获取当前几号，不足10补0
    return y + "-" + m + "-" + d + " 00:00:00";
}

/**
 * 获取时间
 * 0为当前时间
 * 1为明天时间
 * -1为前天时间
 * @param AddDayCount
 * @returns {string}
 * @constructor
 */
function GetDateStr2(AddDayCount) {
    var dd = new Date();
    dd.setDate(dd.getDate() + AddDayCount);//获取AddDayCount天后的日期
    var y = dd.getFullYear();
    var m = (dd.getMonth() + 1) < 10 ? "0" + (dd.getMonth() + 1) : (dd.getMonth() + 1);//获取当前月份的日期，不足10补0
    var d = dd.getDate() < 10 ? "0" + dd.getDate() : dd.getDate(); //获取当前几号，不足10补0
    return y + "-" + m + "-" + d;
}

/**
 * 当前月
 * 0为当前时间
 * 1为明天时间
 * -1为前天时间
 * @param AddDayCount
 * @returns {string}
 * @constructor
 */
function GetDateNowMonth(AddDayCount) {
    var dd = new Date();
    dd.setDate(dd.getDate() + AddDayCount);//获取AddDayCount天后的日期
    var y = dd.getFullYear();
    var m = (dd.getMonth() + 1 + AddDayCount) < 10 ? "0" + (dd.getMonth() + 1 + AddDayCount) : (dd.getMonth() + 1 + AddDayCount);//获取当前月份的日期，不足10补0
    var d = "01"; //获取当前几号，不足10补0
    return y + "-" + m + "-" + d + " 00:00:00";
}

/**
 * 当前月
 * 0为当前时间
 * 1为明天时间
 * -1为前天时间
 * @param AddDayCount
 * @returns {string}
 * @constructor
 */
function GetDateNowMonth2(AddDayCount) {
    var dd = new Date();
    dd.setDate(dd.getDate() + AddDayCount);//获取AddDayCount天后的日期
    var y = dd.getFullYear();
    var m = (dd.getMonth() + 1 + AddDayCount) < 10 ? "0" + (dd.getMonth() + 1 + AddDayCount) : (dd.getMonth() + 1 + AddDayCount);//获取当前月份的日期，不足10补0
    var d = "01"; //获取当前几号，不足10补0
    return y + "-" + m;
}

/*
 * JQUERY
 */
$(function () {

    /*
     * 注销
     */
    $("#outlogin").click(function () {
        window.location.href = outloginPath;
    });

    /*
     * 生成年份选项，从2015年开始，最大值为当前年份+1
     */
    var yearbegin = yearend = '', yearall = '<option value="">全部</option>';
    var date = new Date();
    var year = date.getFullYear();
    for (var i = 2015; i <= year; i++) {
        if (i === 2015) {
            yearbegin = '<option value="' + i + '" selected>' + i + '</option>' + yearbegin;
        } else if (i > 2015) {
            yearbegin = '<option value="' + i + '">' + i + '</option>' + yearbegin;
        }
    }
    for (var i = 2015; i <= year; i++) {
        yearend = '<option value="' + i + '">' + i + '</option>' + yearend;
    }
    for (var i = 2015; i <= year; i++) {
        yearall += '<option value="' + i + '">' + i + '</option>';
    }
    $("select.yearbegin").html(yearbegin);
    $("select.yearend").html(yearend);
    $("select.yearall").html(yearall);

});

/**
 * 判断json是否为空
 * @param obj
 * @returns {boolean}
 */
function isEmptyObj(obj) {
    if (obj == null) return true;
    return Object.keys(obj).length ? false : true;
}

function StringtoDate(str) {
    return new Date(Date.parse(str.replace(/-/g, "/")));
}

/**
 * 秒转时分秒
 * @param value
 * @returns {string}
 */
function formatSeconds(value) {
    var theTime = parseInt(value);// 秒
    var theTime1 = 0;// 分
    var theTime2 = 0;// 小时
    if (theTime > 60) {
        theTime1 = parseInt(theTime / 60);
        theTime = parseInt(theTime % 60);
        if (theTime1 > 60) {
            theTime2 = parseInt(theTime1 / 60);
            theTime1 = parseInt(theTime1 % 60);
        }
    }
    var result = "" + parseInt(theTime) + "秒";
    if (theTime1 > 0) {
        result = "" + parseInt(theTime1) + "分" + result;
    }
    if (theTime2 > 0) {
        result = "" + parseInt(theTime2) + "小时" + result;
    }
    return result;
}
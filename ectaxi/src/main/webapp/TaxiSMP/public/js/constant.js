function getValueFromArray(id, o) {
    for (var i = 0, l = o.length; i < l; i++) {
        var g = o[i];
        if (g.id == id) {
            return g.text;
        }
    }
}

function getidFromArray(text, o) {
    for (var i = 0, l = o.length; i < l; i++) {
        var g = o[i];
        if (g.text == text) {
            return g.id;
        }
    }
}

var weekvalue = [
    {id: 1, text: "星期一"},
    {id: 2, text: "星期二"},
    {id: 3, text: "星期三"},
    {id: 4, text: "星期四"},
    {id: 5, text: "星期五"},
    {id: 6, text: "星期六"},
    {id: 7, text: "星期日"}
];

var sexvalue = [
    {id: 0, text: "男"},
    {id: 1, text: "女"}
];

var onlineStatus = [
    {id: 0, text: "离线"},
    {id: 1, text: "在线"}
];

var eduvalue = [
    {id: 1, text: "专科"},
    {id: 2, text: "本科"},
    {id: 3, text: "博士"},
    {id: 4, text: "硕士"},
    {id: 5, text: "高中"},
    {id: 6, text: "技师"},
    {id: 7, text: "其他"}
];

var islockvalue = [
    {id: 0, text: "不锁定"},
    {id: 1, text: "锁定"}
];


var issendvalue = [
    {id: 0, text: "需要"},
    {id: 1, text: "不需要"}
];

var isaddsignaturevalue = [
    {id: 0, text: "需要"},
    {id: 1, text: "不需要"}
];

var isshowvalue = [
    {id: -1, text: "全部", "selected": true},
    {id: 0, text: "未查看"},
    {id: 1, text: "已查看"}
];

var accountnaturevalue = [
    {id: 1, text: "农村"},
    {id: 2, text: "城镇"}
];


var isteachvalue = [
    {id: 0, text: "是"},
    {id: 1, text: "否"}
];

var leavetypevalue = [
    {id: -1, text: "全部", "selected": true},
    {id: 0, text: "事假"},
    {id: 1, text: "病假"},
    {id: 2, text: "其他"}
];


var isvalue = [
    {id: 0, text: "否"},
    {id: 1, text: "是"}
];

var politicalStatus = [
    {id: 90012, text: " "},
    {id: 90001, text: "中共党员"},
    {id: 90002, text: "中共预备党员"},
    {id: 90003, text: "共青团员"},
    {id: 90013, text: "群众"}
];

var commonpointtype = [
    {id: 0, text: "景点"},
    {id: 1, text: "宾馆"},
    {id: 2, text: "其它"}
];


var driverapplystatus = [
    {id: 0, text: "审核中"},
    {id: 1, text: "审核通过"},
    {id: 1, text: "拒绝"}
];

var ordtype = [
    {id: 0, text: "app"},
    {id: 1, text: "微信"},
    {id: 2, text: "人工坐席"},
    {id: 3, text: "电话语音"}
];

var ordstartus = [
    {id: 0, text: "新业务"},
    {id: 1, text: "已下呼"},
    {id: 2, text: "已租车"},
    {id: 3, text: "已取消"},
    {id: 4, text: "已完成"},
    {id: 5, text: "附近没司机"}
];

var complaintsource = [
    {id: -1, text: "", "selected": true},
    {id: 0, text: "电话"},
    {id: 1, text: "网络"}
];
var complaintresults = [
    {id: -1, text: "", "selected": true},
    {id: 0, text: "情况不属，不予处理"},
    {id: 1, text: "情况属实，已处理相关人员"}
];

var complaintstate = [
    {id: -1, text: "", "selected": true},
    {id: 0, text: "受理"},
    {id: 1, text: "处理中"},
    {id: 2, text: "已处理完毕，并反馈给客户"}
];

var paytypecom = [
    {id: 0, text: "现金支付"},
    {id: 1, text: "支付宝支付"},
    {id: 2, text: "微信支付"}
];
var islowspeedwait = [
    {id: 0, text: "不启动"},
    {id: 1, text: "启动"}
];

var stutets = [
    {id: 0, text: "有效"},
    {id: 1, text: "无效"}
];

var viostutet = [
    {id: 1, text: "超速"},
    {id: 2, text: "驶出限区"},
    {id: 3, text: "区域超速"},
    {id: 4, text: "疲劳驾驶"},
    {id: 5, text: "紧急报警"},
    {id: 6, text: "驶入限区"},
    {id: 7, text: "防劫预警"},
    {id: 8, text: "终端超速报警"}
];

var restype = [
    {id: -1, text: "", "selected": true},
    {id: 0, text: "菜单"},
    {id: 1, text: "页面"}
];


var waytype = [
    {id: 0, text: "现金"},
    {id: 1, text: "支付宝"},
    {id: 2, text: "微信"},
    {id: 3, text: "信用卡"},
    {id: 4, text: "储蓄卡"}
    // {id: 4, text: "其它"}
];

var isnotifistutse = [
    {id: 0, text: "未发送"},
    {id: 1, text: "已发送"},
    {id: 2, text: "超时"}
];

var cacelremark = [
    {id: 0, text: "人工坐席派错单"},
    {id: 1, text: "乘客打电话取消单"},
    {id: 2, text: "投诉司机没来接我"},
    {id: 3, text: "与司机达成一致，取消订单"}
];

var systemtype = [
    {id: 1, text: "众城出行"},
    {id: 2, text: "打车易"}
];

var isreceive = [
    {id: 0, text: "未领取"},
    {id: 1, text: "已领取"}
];

var isusevalue = [
    {id: 0, text: "未使用"},
    {id: 1, text: "已使用"},
    {id: 2, text: "失效"}
];

var discountvalue = [
    {id: 1, text: "代金券"},
    {id: 2, text: "打折券"}
];

var isvalid = [
    {id: 0, text: "启动"},
    {id: 1, text: "停止"}
];





<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>实时监控</title>

    <!-- jquery easyui 插件 -->
    <link href="../../../public/jquery-easyui-1.5/themes/metro/easyui.css" rel="stylesheet"/>
    <link href="../../../public/jquery-easyui-1.5/themes/icon.css" rel="stylesheet"/>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.easyui.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/easyui-lang-zh_CN.js"></script>

    <!-- 数据接口路径、共用JS -->
    <script src="../../../public/js/path.js"></script>
    <script src="../../../public/js/constant.js"></script>
    <script src="../../../public/js/amrnb.js"></script>

    <!-- style -->
    <style>
        nav {
            width: auto;
            border: 1px solid #C8C8C8;
        }

        div#navStatus {
            width: auto;
            margin: 10px;
            padding: 10px;
            border: 1px solid #C8C8C8;
        }

        div#navStatus div {
            display: inline-block;
            padding-left: 20px;
        }

        div#navStatus div p {
            margin: 0;
            font-size: 12px;
            color: #444444;
            line-height: 18px;
        }

        ul#statistical {
            list-style: none;
            padding: 0;
            margin: 8px 0px;
            float: left;
        }

        ul#statistical li {
            font-family: "Microsoft YaHei";
            display: inline-block;
            min-width: 120px;
            height: 38px;
            font-size: 28px;
            text-align: center;
            line-height: 38px;
            color: white;
            margin-right: 20px;
            position: relative;
        }

        ul#statistical li::before {
            display: block;
            font-size: 14px;
            white-space: nowrap;
            line-height: 26px;
            color: #777777;
            position: absolute;
            top: 100%;
            left: 50%;
            transform: translateX(-50%);
        }

        ul#statistical li:nth-child(1)::before {
            content: "新订单";
        }

        ul#statistical li:nth-child(2)::before {
            content: "处理中";
        }

        ul#statistical li:nth-child(3)::before {
            content: "订单完成总数";
        }

        ul#statistical li:nth-child(4)::before {
            content: "订单取消总数";
        }

        ul#statistical li:nth-child(5)::before {
            content: "未接单总数";
        }

        ul#statistical li:nth-child(6)::before {
            content: "今天电召总数";
        }

        ul#statistical li:nth-child(1) {
            background: #0092DC;
        }

        ul#statistical li:nth-child(2) {
            background: #0092DC;
        }

        ul#statistical li:nth-child(3) {
            background: #5CB85C;
        }

        ul#statistical li:nth-child(4) {
            background: #202C38;
        }

        ul#statistical li:nth-child(5) {
            background: #C9302C;
        }

        ul#statistical li:nth-child(6) {
            background: #0092DC;
        }

        ul#statistical li::after {
            content: "";
            display: block;
            width: 20px;
            height: 2px;
            background: #c8c8c8;
            position: absolute;
            top: 20px;
            right: -25px;
        }

        ul#statistical li:last-child::after {
            background: none;
        }

        article {
            margin-top: 10px;
        }

        article > div {
            width: 33%;
            height: 100%;
            box-sizing: border-box;
            border: 1px solid #C8C8C8;
            overflow: hidden;
        }

        div#newcalling {
            float: left;
        }

        div#process {
            margin: auto;
        }

        div#historycalling {
            float: right;
        }

        article > div > h2 {
            width: auto;
            height: 24px;
            background: #00BFA5;
            margin: 0;
            font-size: 12px;
            color: white;
            font-weight: normal;
            line-height: 24px;
            text-indent: 8px;
        }

        ul.callingInfo {
            margin: 0;
            width: auto;
            padding: 2px;
            list-style: none;
        }

        ul.callingInfo li {
            width: auto;
            border: 1px solid #C8C8C8;
            border-radius: 4px;
            margin-bottom: 2px;
            padding: 5px 50px 5px 10px;
            position: relative;
        }

        ul.callingInfo li > div {
            width: 50px;
            height: 68px;
            /* float: right; */
            /* background: red; */
            cursor: pointer;
            position: absolute;
            right: 0;
        }

        li.imgWeixin {
            background: url(../public/image/mode-weixin.png) no-repeat right 10px center;
        }

        li.imgApp {
            background: url(../public/image/mode-app.png) no-repeat right 10px center;
        }

        li.imgMobile {
            background: url(../public/image/mode-mobile.png) no-repeat right 10px center;
        }

        li.imgSpeak {
            background: url(../public/image/mode-newspeak.png) no-repeat right 10px center;
        }

        li.imgSpeakSuccess {
            background: url(../public/image/mode-newspeak.png) no-repeat right 10px center, url(../public/image/order-finish.png) no-repeat right top;
        }

        li.imgSpeakOutTime {
            background: url(../public/image/mode-speak.png) no-repeat right 10px center, url(../public/image/order-outtime.png) no-repeat right top;
        }

        li.imgSpeakCancle {
            background: url(../public/image/mode-speak.png) no-repeat right 10px center, url(../public/image/order-cancel.png) no-repeat right top;
        }

        li.imgWeixinSuccess {
            background: url(../public/image/mode-weixin.png) no-repeat right 10px center, url(../public/image/order-finish.png) no-repeat right top;
        }

        li.imgWeixinOutTime {
            background: url(../public/image/mode-weixin.png) no-repeat right 10px center, url(../public/image/order-outtime.png) no-repeat right top;
        }

        li.imgWeixinCancle {
            background: url(../public/image/mode-weixin.png) no-repeat right 10px center, url(../public/image/order-cancel.png) no-repeat right top;
        }

        li.imgAppSuccess {
            background: url(../public/image/mode-app.png) no-repeat right 10px center, url(../public/image/order-finish.png) no-repeat right top;
        }

        li.imgAppOutTime {
            background: url(../public/image/mode-app.png) no-repeat right 10px center, url(../public/image/order-outtime.png) no-repeat right top;
        }

        li.imgAppCancle {
            background: url(../public/image/mode-app.png) no-repeat right 10px center, url(../public/image/order-cancel.png) no-repeat right top;
        }

        li.imgMobileSuccess {
            background: url(../public/image/mode-mobile.png) no-repeat right 10px center, url(../public/image/order-finish.png) no-repeat right top;
        }

        li.imgMobileOutTime {
            background: url(../public/image/mode-mobile.png) no-repeat right 10px center, url(../public/image/order-outtime.png) no-repeat right top;
        }

        li.imgMobileCancle {
            background: url(../public/image/mode-mobile.png) no-repeat right 10px center, url(../public/image/order-cancel.png) no-repeat right top;
        }

        ul.callingInfo li p {
            font-size: 12px;
            color: #464648;
            line-height: 1.5;
            margin: 0;
        }

        .timered {
            color: red;
        }
    </style>

</head>

<body class="easyui-layout" data-options="fit:true" style="padding:10px; box-sizing: border-box;">

<!-- 头部 -->
<nav>
    <div id="navStatus">
        <div>
            <p>车辆在线数：<span id="inlineCarNum">0</span>辆</p>
            <p>车辆离线数：<span id="offlineCarNum">0</span>辆</p>
            <p>成功接单率：<span id="succper">0</span>%</p>
            <p>更新时间：<span id="updatetime">0</span></p>
        </div>
        <ul id="statistical">
            <li id="neworder">0</li>
            <li id="processingorder">0</li>
            <li id="finishorder">0</li>
            <li id="cancelorder">0</li>
            <li id="outtimeorder">0</li>
            <li id="allorder">0</li>
        </ul>
    </div>
</nav>

<!-- 电召单信息 -->
<article id="allcalling">
    <div id="newcalling">
        <h2>新电召单</h2>
        <ul id="newcallingInfo" class="callingInfo">
            <%--<li class="imgWeixin">--%>
            <%--<div class="sample-amr" >--%>
            <%--&lt;%&ndash;onclick="playrecord()"&ndash;%&gt;--%>
            <%--<audio src="/amrfile/test.aac" >test.aac</audio>--%>
            <%--</div>--%>
            <%--<p>2016-07-25  12:10:25</p>--%>
            <%--<p>乘客：13800138000</p>--%>
            <%--<p>起点：广州市萝岗区科学大道中99号科汇金谷</p>--%>
            <%--<p>终点：广州市天河区大观路奥林匹克体育中心</p>--%>
            <%--</li>--%>
            <%--<li class="imgWeixin">--%>
            <%--<div class="sample-amr">--%>
            <%--&lt;%&ndash;onclick="playrecord()"&ndash;%&gt;--%>
            <%--<audio src="/amrfile/test02.aac" >test.aac</audio>--%>
            <%--</div>--%>
            <%--<p>2016-07-25  12:10:25</p>--%>
            <%--<p>乘客：13800138000</p>--%>
            <%--<p>起点：广州市萝岗区科学大道中99号科汇金谷</p>--%>
            <%--<p>终点：广州市天河区大观路奥林匹克体育中心</p>--%>
            <%--</li>--%>
            <%--<li class="imgWeixin">--%>
            <%--<div class="sample-amr">--%>
            <%--&lt;%&ndash;onclick="playrecord()"&ndash;%&gt;--%>
            <%--<audio src="/amrfile/test03.aac" >test.aac</audio>--%>
            <%--</div>--%>
            <%--<p>2016-07-25  12:10:25</p>--%>
            <%--<p>乘客：13800138000</p>--%>
            <%--<p>起点：广州市萝岗区科学大道中99号科汇金谷</p>--%>
            <%--<p>终点：广州市天河区大观路奥林匹克体育中心</p>--%>
            <%--</li>--%>
            <%--<li class="imgApp">--%>
            <%--<p>2016-07-25  12:10:25</p>--%>
            <%--<p>乘客：13800138000</p>--%>
            <%--<p>起点：广州市萝岗区科学大道中99号科汇金谷</p>--%>
            <%--<p>终点：广州市天河区大观路奥林匹克体育中心</p>--%>
            <%--</li>--%>
            <%--<li class="imgMobile">--%>
            <%--<p>2016-07-25  12:10:25</p>--%>
            <%--<p>乘客：13800138000</p>--%>
            <%--<p>起点：广州市萝岗区科学大道中99号科汇金谷</p>--%>
            <%--<p>终点：广州市天河区大观路奥林匹克体育中心</p>--%>
            <%--</li>--%>

        </ul>
    </div>
    <div id="historycalling">
        <h2>历史电召单</h2>
        <ul id="historycallingInfo" class="callingInfo">
            <%--<li class="imgWeixinSuccess">--%>
            <%--<p>2016-07-25  12:10:25</p>--%>
            <%--<p>乘客：13800138000</p>--%>
            <%--<p>起点：广州市萝岗区科学大道中99号科汇金谷</p>--%>
            <%--<p>终点：广州市天河区大观路奥林匹克体育中心</p>--%>
            <%--<p>司机：陈师傅 / 粤A12345 / 12345678910</p>--%>
            <%--</li>--%>
            <%--<li class="imgWeixinOutTime">--%>
            <%--<p>2016-07-25  12:10:25</p>--%>
            <%--<p>乘客：13800138000</p>--%>
            <%--<p>起点：广州市萝岗区科学大道中99号科汇金谷</p>--%>
            <%--<p>终点：广州市天河区大观路奥林匹克体育中心</p>--%>
            <%--<p>司机：粤A12345</p>--%>
            <%--</li>--%>
            <%--<li class="imgWeixinCancle">--%>
            <%--<p>2016-07-25  12:10:25</p>--%>
            <%--<p>乘客：13800138000</p>--%>
            <%--<p>起点：广州市萝岗区科学大道中99号科汇金谷</p>--%>
            <%--<p>终点：广州市天河区大观路奥林匹克体育中心</p>--%>
            <%--<p>司机：粤A12345</p>--%>
            <%--</li>--%>
            <%--<li class="imgAppSuccess">--%>
            <%--<p>2016-07-25  12:10:25</p>--%>
            <%--<p>乘客：13800138000</p>--%>
            <%--<p>起点：广州市萝岗区科学大道中99号科汇金谷</p>--%>
            <%--<p>终点：广州市天河区大观路奥林匹克体育中心</p>--%>
            <%--<p>司机：粤A12345</p>--%>
            <%--</li>--%>
            <%--<li class="imgAppOutTime">--%>
            <%--<p>2016-07-25  12:10:25</p>--%>
            <%--<p>乘客：13800138000</p>--%>
            <%--<p>起点：广州市萝岗区科学大道中99号科汇金谷</p>--%>
            <%--<p>终点：广州市天河区大观路奥林匹克体育中心</p>--%>
            <%--<p>司机：粤A12345</p>--%>
            <%--</li>--%>
            <%--<li class="imgAppCancle">--%>
            <%--<p>2016-07-25  12:10:25</p>--%>
            <%--<p>乘客：13800138000</p>--%>
            <%--<p>起点：广州市萝岗区科学大道中99号科汇金谷</p>--%>
            <%--<p>终点：广州市天河区大观路奥林匹克体育中心</p>--%>
            <%--<p>司机：粤A12345</p>--%>
            <%--</li>--%>
        </ul>
    </div>
    <div id="process">
        <h2>处理中电召单</h2>
        <ul id="processInfo" class="callingInfo">
            <%--<li class="imgWeixinSuccess">--%>
            <%--<p>2016-07-25  12:10:25</p>--%>
            <%--<p>乘客：13800138000</p>--%>
            <%--<p>起点：广州市萝岗区科学大道中99号科汇金谷</p>--%>
            <%--<p>终点：广州市天河区大观路奥林匹克体育中心</p>--%>
            <%--<p>司机：陈师傅 / 粤A12345 / 12345678910</p>--%>
            <%--</li>--%>
            <%--<li class="imgWeixinOutTime">--%>
            <%--<p>2016-07-25  12:10:25</p>--%>
            <%--<p>乘客：13800138000</p>--%>
            <%--<p>起点：广州市萝岗区科学大道中99号科汇金谷</p>--%>
            <%--<p>终点：广州市天河区大观路奥林匹克体育中心</p>--%>
            <%--<p>司机：粤A12345</p>--%>
            <%--</li>--%>
            <%--<li class="imgWeixinCancle">--%>
            <%--<p>2016-07-25  12:10:25</p>--%>
            <%--<p>乘客：13800138000</p>--%>
            <%--<p>起点：广州市萝岗区科学大道中99号科汇金谷</p>--%>
            <%--<p>终点：广州市天河区大观路奥林匹克体育中心</p>--%>
            <%--<p>司机：粤A12345</p>--%>
            <%--</li>--%>
            <%--<li class="imgAppSuccess">--%>
            <%--<p>2016-07-25  12:10:25</p>--%>
            <%--<p>乘客：13800138000</p>--%>
            <%--<p>起点：广州市萝岗区科学大道中99号科汇金谷</p>--%>
            <%--<p>终点：广州市天河区大观路奥林匹克体育中心</p>--%>
            <%--<p>司机：粤A12345</p>--%>
            <%--</li>--%>
            <%--<li class="imgAppOutTime">--%>
            <%--<p>2016-07-25  12:10:25</p>--%>
            <%--<p>乘客：13800138000</p>--%>
            <%--<p>起点：广州市萝岗区科学大道中99号科汇金谷</p>--%>
            <%--<p>终点：广州市天河区大观路奥林匹克体育中心</p>--%>
            <%--<p>司机：粤A12345</p>--%>
            <%--</li>--%>
            <%--<li class="imgAppCancle">--%>
            <%--<p>2016-07-25  12:10:25</p>--%>
            <%--<p>乘客：13800138000</p>--%>
            <%--<p>起点：广州市萝岗区科学大道中99号科汇金谷</p>--%>
            <%--<p>终点：广州市天河区大观路奥林匹克体育中心</p>--%>
            <%--<p>司机：粤A12345</p>--%>
            <%--</li>--%>
        </ul>
    </div>
</article>

</body>
</html>
<script>
    var validCode = true;
    var datatime = 60 * 60 * 24 * 7;
    var s;
    $("#allcalling").click(function (e) {
//		console.info("播放");
        var audio = $(this).find("audio");
        for (var i = 0; i < audio.length; i++) {
            audio.get(i).pause();
        }
//		console.info(e.target.tagName);
        if (e.target.tagName == "DIV" && e.target.children[0].tagName == "AUDIO") {
            e.target.children[0].play();
        }
        clearInterval(t);
        clearTimeout(s);
        s = setTimeout(function () {
//			console.info("s");
            validCode = true;
            funSetInterval(datatime, 5);
        }, 15000)

    });


    var onlinenum;
    var offlinenum;

    var newordertemp = 0;
    var newordernum = 0;
    var hisordernum = 0;
    var screenheight = window.screen.availHeight - 200;
    var screenwidth = window.screen.availWidth - 150;
    var globab_clientId = sessionStorage.clientId;
    var t;//定时器
    <%--////console.info('${sessionScope.userId}');--%>

    $(function () {

//		$(".Callinginfo").css({'height': $(window).outerHeight(true) - $(".RealtimeMonitoring").outerHeight(true)-15+'px'});
        /*
         ** 设置电召单信息框高度
         */
        $("article").eq(0).height($("body").eq(0).height() - $("nav").eq(0).outerHeight() - 10);


        CallBussStatuePosition();
        CallBussNewList();
        CallBussHisList();
        CallBussProList();

        funSetInterval(datatime, 5);
//


    });

    function playrecord(data) {
//		////console.info($(data).children("a")[0].href);
        fetchBlob($(data).children("a")[0].href, function (blob) {
            playAmrBlob(blob);
        });
    }

    function setHisOrderNum() {
        $.ajax({
            url: path + '/base/defpos/finddefPosbyUseid.do',
            data: {
                SSid: 1004,
                userid: '${sessionScope.userId}'
            },
            dataType: 'json',
            type: 'POST',
            async: false,
            success: function (data) {
//                    ////console.info(data);

                if (!isEmptyObj(data)) {
                    var data = data.rows;
                    if (data != 0) {
                        hisordernum = data.layer;
                    } else {
                        hisordernum = 5;
                    }
                } else {
                    hisordernum = 5;
                }

            }
        });
    }

    function setNewOrderNum() {
        $.ajax({
            url: '/base/defpos/finddefPosbyUseid.do',
            data: {
                SSid: 1003,
                userid: '${sessionScope.userId}'
            },
            dataType: 'json',
            type: 'POST',
            async: false,
            success: function (data) {
//                    ////console.info(data);

                if (!isEmptyObj(data)) {
                    var data = data.rows;
                    if (data != 0) {
                        newordernum = data.layer;
                    } else {
                        newordernum = 6;
                    }
                } else {
                    newordernum = 6;
                }

            }
        });
    }

    //历史电召单列表
    function CallBussHisList() {

        var length = 6;
        var dataUrl = "startTime=" + GetDateStr(0) + "&length=" + length + "&clientid=" + globab_clientId;
        $.ajax({
            url: path + '/callbuss/callbusshissta?' + dataUrl,
            dataType: 'json',
            type: "GET",
            async: true,
            success: function (data) {
//                    ////console.info(data);
                var listr = "";
                if (data != null) {
                    for (var i = 0; i < data.length; i++) {

                        var status = "";
                        if (data[i].orderType == 0) {
                            status = "imgApp"
                        } else if (data[i].orderType == 1) {
                            status = "imgWeixin"
                        } else if (data[i].orderType == 2) {
                            status = "imgMobile"
                        } else if (data[i].orderType == 3) {
                            status = "imgSpeak"
                        }

                        if (data[i].status == 3) {
                            status += "Cancle"
                        } else if (data[i].status == 4) {
                            status += "Success"
                        } else if (data[i].status == 5) {
                            status += "Cancle"
                        }

                        listr += '<li class="' + status + '">';

                        if (data[i].orderType == 3) {
                            listr += '<br />';
                            listr += '<div class="sample-amr" ><audio id="recordurl" src="' + data[i].remark + '" style="display: none">test.amr</audio> </div>';
                        }
                        listr += '<p>' + formattime(data[i].calltime.time) + '</p>';
                        listr += '<p>乘客：' + data[i].clientmobile + '</p>';
                        if (data[i].orderType != 3) {
                            listr += '<p>起点：' + data[i].srcaddr + '</p>';
                            listr += '<p>终点：' + data[i].address + '</p>';
                        }
                        if (data[i].status == 4) {
                            listr += '<p>司机：' + data[i].drivername + ' / ' + data[i].carbox + ' / ' + data[i].phone + '</p>';
                        }
                        if (data[i].orderType == 3) {
                            listr += '<br />';
                        }
                        listr += '</li>';
//						陈师傅 / 粤A12345 / 12345678910
                    }

                }
                $("#historycallingInfo").html(listr);

            }
        });

    }

    //正在处理电召单列表
    function CallBussProList() {

        var length = 6;
        var dataUrl = "startTime=" + GetDateStr(0) + "&length=" + length + "&clientid=" + globab_clientId;
        $.ajax({
            url: path + '/callbuss/callbussprosta?' + dataUrl,
            dataType: 'json',
            type: "GET",
            async: true,
            success: function (data) {
//				////console.info(data);
                var listr = "";
                if (data != null) {
                    for (var i = 0; i < data.length; i++) {

                        var status = "";
                        if (data[i].orderType == 0) {
                            status = "imgApp"
                        } else if (data[i].orderType == 1) {
                            status = "imgWeixin"
                        } else if (data[i].orderType == 2) {
                            status = "imgMobile"
                        } else if (data[i].orderType == 3) {
                            status = "imgSpeak"
                        }

                        if (data[i].status == 3) {
                            status += "Cancle"
                        } else if (data[i].status == 4) {
                            status += "Success"
                        } else if (data[i].status == 5) {
                            status += "Cancle"
                        }

                        listr += '<li class="' + status + '">';
                        if (data[i].orderType == 3) {
                            listr += '<br />';
                            listr += '<div class="sample-amr" ><audio id="recordurl" src="' + data[i].remark + '" style="display: none">test.amr</audio> </div>';
                        }
                        listr += '<p>' + formattime(data[i].calltime.time) + '</p>';
                        listr += '<p>乘客：' + data[i].clientmobile + '</p>';
                        if (data[i].orderType != 3) {
                            listr += '<p>起点：' + data[i].srcaddr + '</p>';
                            listr += '<p>终点：' + data[i].address + '</p>';
                        }

                        listr += '<p>司机：' + data[i].drivername + ' / ' + data[i].carbox + ' / ' + data[i].phone + '</p>';

                        if (data[i].orderType == 3) {
                            listr += '<br />';
                        }
                        listr += '</li>';

                    }

                }
                $("#processInfo").html(listr);

            }
        });

    }

    //新电召单列表
    function CallBussNewList() {

        var length = 6;
        var dataUrl = "startTime=" + GetDateStr(0) + "&length=" + length + "&clientid=" + globab_clientId;
        $.ajax({
            url: path + '/callbuss/callbussnewsta?' + dataUrl,
            dataType: 'json',
            type: "GET",
            async: true,
            success: function (data) {
//                    ////console.info(data);
                var list = "";
                if (data != null) {

                    for (var i = 0; i < data.length; i++) {

                        if (data[i].timedifference <= 30) {
                            var type = "";
                            if (data[i].orderType == 0) {
                                type = "imgApp"
                            } else if (data[i].orderType == 1) {
                                type = "imgWeixin"
                            } else if (data[i].orderType == 2) {
                                type = "imgMobile"
                            }
                            else if (data[i].orderType == 3) {
                                type = "imgSpeak"
                            }

                            list += '<li class=' + type + '>';
                            if (data[i].orderType == 3) {
                                list += '<br />';
                                list += '<div class="sample-amr" ><audio  src="' + data[i].remark + '" ></audio> </div>';
                            }
                            list += '<p> ' + formattime(data[i].calltime.time) + '<span class="timered">(订单已等待' + data[i].timedifference + '分钟)<span></p>';
                            list += '<p>乘客：' + data[i].clientmobile + '</p>';
                            if (data[i].orderType != 3) {
                                list += '<p>起点：' + data[i].srcaddr + '</p>';
                                list += '<p>终点：' + data[i].address + '</p>';
                            }
                            if (data[i].orderType == 3) {
                                list += '<br />';
                            }
                            list += '</li>';

//
                        }

                    }
                    $("#newcallingInfo").html(list);

                }
            }
        });

    }

    //电召单实时状态和出租车状态
    function CallBussStatuePosition() {

        $.ajax({
            url: path + '/callbuss/callrealtimereport?clientid=' + globab_clientId,
            dataType: 'json',
            type: "GET",
            async: true,
            success: function (data) {
                ////console.info(data);
                if (data != null) {

                    $("#inlineCarNum").html(data[0].onlinecar);
                    $("#offlineCarNum").html(data[0].offlinecar);
                    $("#allorder").html(data[0].allorder);
                    $("#cancelorder").html(data[0].cancelorder + data[0].neatnotcar);
                    $("#finishorder").html(data[0].finishorder);
                    $("#neworder").html(Math.abs(data[0].neworder - data[0].outtimeorder));
                    $("#processingorder").html(data[0].processingorder);
                    $("#outtimeorder").html(data[0].outtimeorder);
                    if (data[0].time != null) {
                        $("#updatetime").html(formattime(data[0].time.time));
                    }


                    var succper = data[0].cancelorder + data[0].neatnotcar + data[0].finishorder + data[0].processingorder;
                    var errper = data[0].neworder;
                    $("#succper").html(calculate(data[0].allorder, succper));
//                        $("#errper").html(100-calculate(data[0].allorder,succper));
                    ////console.info("clientid:"+globab_clientId);
                }
            }
        });

    }


    //定时器方法
    function funSetInterval(time, refreshnum) {
//		console.info("funSetInterval---被执行---");
//		console.info("validCode:"+validCode);

        if (validCode) {
            validCode = false;
            t = setInterval(function () {
//				 console.info("定时器方法");
                time--;
                //放入需要刷新的方法
                if (time % refreshnum == 0) {
                    CallBussStatuePosition();
                    CallBussNewList();
                    CallBussHisList();
                    CallBussProList();
                }
                if (time == 0) {
                    clearInterval(t);
                    validCode = true;
                }
            }, 1000)
        }
    }


    //电召单信息
    function callbussinfo(billid) {
        var dialog = parent.phm.modalDialog({
            title: '电召单信息',
            maximizable: true,
            resizable: true,
            width: 870,
            height: 650,
            closable: true,
            url: "${path}/page/information/monitoring_calling_list.jsp?billid=" + billid,
            buttons: [
                {
                    text: '关闭',
                    iconCls: 'icon-cancel',
                    handler: function () {
                        dialog.dialog("close");
                    }
                }
            ]

        });
    }


    function GetDateStr(AddDayCount) {
        var dd = new Date();
        dd.setDate(dd.getDate() + AddDayCount);//获取AddDayCount天后的日期
        var y = dd.getFullYear();
        var m = (dd.getMonth() + 1) < 10 ? "0" + (dd.getMonth() + 1) : (dd.getMonth() + 1);//获取当前月份的日期，不足10补0
        var d = dd.getDate() < 10 ? "0" + dd.getDate() : dd.getDate(); //获取当前几号，不足10补0
        return y + "-" + m + "-" + d + " 00:00:00";
    }

    function isEmptyObj(obj) {
        return Object.keys(obj).length ? false : true;
    }

    /**
     * 计算百分比
     * @param totle
     * @param num
     * @returns {number}
     */
    function calculate(totle, num) {
        var results = 0;
        if (totle != 0 && num != 0) {
            results = parseInt(num / totle * 100);
        }

        return results;
    }


    //-----------语音播放 方法--------------

    var gAudioContext = new AudioContext();

    function getAudioContext() {
        if (!gAudioContext) {
            gAudioContext = new AudioContext();
        }
        return gAudioContext;
    }

    function fetchBlob(url, callback) {
        var xhr = new XMLHttpRequest();
        xhr.open('GET', url);
        xhr.responseType = 'blob';
        xhr.onload = function () {
            callback(this.response);
        };
        xhr.onerror = function () {
            alert('Failed to fetch ' + url);
        };
        xhr.send();
    }

    function readBlob(blob, callback) {
        var reader = new FileReader();
        reader.onload = function (e) {
            var data = new Uint8Array(e.target.result);
            callback(data);
        };
        reader.readAsArrayBuffer(blob);
    }

    function fetchAndReadBlob(url, callback) {
        fetchBlob(url, function (blob) {
            readBlob(blob, callback);
        });
    }

    function playAmrBlob(blob, callback) {
        readBlob(blob, function (data) {
            playAmrArray(data);
        });
    }

    function convertAudioBlobToAmr(blob) {
        readBlob(blob, function (data) {
            var ctx = getAudioContext();
            ctx.decodeAudioData(data.buffer, function (audioBuffer) {
                var pcm;
                if (audioBuffer.copyFromChannel) {
                    pcm = new Float32Array(audioBuffer.length);
                    audioBuffer.copyFromChannel(pcm, 0, 0);
                } else {
                    pcm = audioBuffer.getChannelData(0);
                }
                var amr = AMR.encode(pcm, audioBuffer.sampleRate, 7);
                playAmrArray(amr);
            });
        });
    }

    function playAmrArray(array) {
        var samples = AMR.decode(array);
        if (!samples) {
            alert('Failed to decode!');
            return;
        }
        playPcm(samples);
    }

    function playPcm(samples) {
        var ctx = getAudioContext();
        var src = ctx.createBufferSource();
        var buffer = ctx.createBuffer(1, samples.length, 8000);
        if (buffer.copyToChannel) {
            buffer.copyToChannel(samples, 0, 0)
        } else {
            var channelBuffer = buffer.getChannelData(0);
            channelBuffer.set(samples);
        }

        src.buffer = buffer;
        src.connect(ctx.destination);
        src.start();
    }

    function convertAmrBlobToWav(blob) {
        readBlob(blob, function (data) {
            var buffer = AMR.toWAV(data);
            E('pre').textContent = toHex(buffer);
            var url = URL.createObjectURL(new Blob([buffer], {type: 'audio/x-wav'}));
            // Play wav buffer
            var audio = new Audio(url);
            audio.onloadedmetadata = audio.onerror = function () {
                URL.revokeObjectURL(url);
            };
            audio.play();
        });
    }

    function toHex(buffer) {
        var str = '';
        for (var i = 0; i < buffer.length; i++) {
            var s = buffer[i].toString(16);
            if (s.length == 1) {
                s = '0' + s;
            }
            str += s;
            if (i % 16 == 15) { // print 16 bytes per line
                str += '\n'
            } else if (i % 2 == 1) { // add a space seperator every two bytes.
                str += ' ';
            }
        }
        return str;
    }

    //-----------语音播放 方法--------------
</script>
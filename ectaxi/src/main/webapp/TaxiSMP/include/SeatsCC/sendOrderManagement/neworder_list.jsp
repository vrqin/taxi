<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no"
          name="viewport" id="viewport"/>
    <META HTTP-EQUIV="pragma" CONTENT="no-cache">
    <META HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate">
    <META HTTP-EQUIV="expires" CONTENT="0">
    <title>电召派单</title>

    <link href="../../../public/jquery-easyui-1.5/themes/metro/easyui.css" rel="stylesheet"/>
    <link href="../../../public/jquery-easyui-1.5/themes/icon.css" rel="stylesheet"/>

    <script src="../../../public/jquery-easyui-1.5/js/jquery.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.easyui.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/api?key=&v=1.1&services=true"></script>
    <!-- 数据接口路径 -->
    <script src="../../../public/js/path.js"></script>
    <script src="../../../public/js/constant.js"></script>
    <script src="../../../public/js/GPSUtil.js"></script>
    <script src="../../../public/js/decideBrowser.js"></script>
    <script src="../../../public/js/utiljavascript.js"></script>


    <style type="text/css">
        html, body {
            width: 100%;
            height: 100%;
            margin: 0px;
            padding: 0px;

        }

        .orderinfo {
            width: auto;
            /*background-color: #c8c8c8;*/
        }

        .ordergrid {
            width: auto;
            height: 30px;
            /*background-color: #3c8b3c;*/
        }

        .ordergrid table {
            width: 100%;
            font-size: 12px;
            text-align: center;
            line-height: 24px;
        }

        .ordergrid table button {
            width: 78px;
            height: 24px;
            background: #2EB561;
        }

        .order {
            float: left;
            width: 620px;
            height: 100%;
            box-sizing: border-box;
        }

        .orderform {
            box-sizing: border-box;
            width: auto;
            height: 300px;
        }

        .orderform form {
            width: auto;
            height: 100%;
            float: left;
        }

        .history {
            height: 500px;
            box-sizing: border-box;
            width: auto;
        }

        #baidumaps {
            width: auto;
            height: 100%;
            margin-left: 620px;
            box-sizing: border-box;

        }

        ul.neworder {
            width: 415px;
            height: 100%;
            font-size: 12px;
            margin: 0px;
            padding: 24px 0 0 10px;
            background-color: #EAEEED;
            position: relative;
            float: left;
            box-sizing: border-box;
        }

        .neworder li {
            list-style: none;
            margin: 0 7px 10px;
        }

        .neworder li:last-child {
            text-align: center;
            margin-top: 18px;
        }

        .findcar {
            margin-left: 415px;
            width: auto;
            height: 100%;
        }

        input {
            height: 22px;
            border: 1px solid #DDDDDD;
            width: 319px;
        }

        button {
            width: 90px;
            height: 32px;
            color: white;
            border-radius: 4px;
            border: none;
            margin: 0 14px;
            cursor: pointer;
        }

        #send {
            background: #2EB561;
        }

        #clear {
            background: #E6834E;
        }

        .staraddresslist {
            list-style: none;
            width: 322px;
            padding: 0px 1px;
            margin: 0;
            box-sizing: border-box;
            position: absolute;
            top: 93px;
            left: 70px;
            font-size: 12px;
            z-index: 999;
            background: rgba(255, 255, 255, 1);
        }

        .staraddresslist li {
            list-style: none;
            /*height: 22px;*/
            border-bottom: 1px solid #e9e9e9;
            padding: 6px 0 6px 10px;
        }

        .staraddresslist li:hover {
            background: #e9e9e9;
        }

        .endaddresslist {
            list-style: none;
            width: 322px;
            padding: 0px 1px;
            margin: 0;
            box-sizing: border-box;
            /* overflow: scroll; */
            position: absolute;
            top: 132px;
            left: 70px;
            font-size: 12px;
            z-index: 999;
            background: rgba(255, 255, 255, 1);
        }

        .endaddresslist li {
            list-style: none;
            /*height: 22px;*/
            border-bottom: 1px solid #e9e9e9;
            padding: 6px 0 6px 10px;
        }

        .endaddresslist li:hover {
            background: #e9e9e9;
        }

        .addresstitle {
            font-size: 12px;
            margin: 0;
            padding: 1px 19px 1px 0;
            font-weight: bold;
            display: inline;
        }

        .addressinfo {
            font-size: 13px;
            margin: 0;
            display: inline;

        }

        .inputtype {
            padding: 3px 0px;
            text-indent: 3px;
        }

        .phonetype {
            padding: 3px 0px;
            text-indent: 3px;
            width: 136px;
        }

        .phre {
            border: 1px solid red;
            outline: none;
        }

        li:hover {
            /*background:pink;*/
        }

        li.active {
            background: gray;
        }

        #maptip {
            /* width: 500px; */
            padding: 0px 10px;
            height: 24px;
            position: absolute;
            top: 10px;
            left: 635px;
            /* right: 50px; */
            background: white;
            color: #000000;
            font-size: 12px;
            z-index: 9999;
            border-radius: 5px;
            line-height: 24px;
            /* border: 1px solid #B7C7EB; */
            /* text-indent: 10px; */
            box-shadow: 1px 1px 4px rgba(49, 75, 134, 0.8);
        }

        #tipname {
            color: red;
        }

        .tipsuccess {
            color: green;
        }

        .tiperror {
            color: red;
        }

        input {
            background-color: #ffffff;
        }

        #loginseats {
            width: 100%;
            height: 100%;
            background: rgba(0, 0, 0, 0.5);
            position: absolute;
            top: 0px;
            left: 0px;
            z-index: 9999;
            display: none;
        }

        #form {
            position: absolute;
            width: 300px;
            height: 350px;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            margin: auto;
            padding: 31px 0 0 32px;
            border-radius: 9px;
            background: white;
        }

        #form h2 {
            margin: 0;
            height: 24px;
            font-size: 20px;
            color: #666666;
            text-indent: 85px;
        }

        #form p {
            height: 24px;
            font-size: 14px;
            color: #666666;
        }

        p#errorTips {
            width: 262px;
            height: auto;
            font-size: 12px;
            text-align: center;
            color: red;
            position: relative;
            top: 10px;
        }

        input.text {
            width: 262px;
            height: 32px;
            text-indent: 10px;
            border-radius: 8px;
            background: #f3f3f3;
            margin-bottom: 8px;
        }

        input.text:hover {
            box-shadow: 0 0 20px rgba(73, 164, 241, 0.50);
            background: white;
        }

        input#submit {
            width: 214px;
            height: 40px;
            font-size: 14px;
            border-radius: 20px;
            background: white;
            margin: 34px 0 0 24px;
            cursor: pointer;
            transition: box-shadow 0.5s linear 0s;
        }

        input#submit:hover {
            color: #ffffff;
            background: #FDB524;
        }

        .openrelation {

        }
    </style>


</head>
<body class="easyui-layout" data-options="border:false ,fit:true">
<div class="orderinfo">
    <div class="order">
        <div class="orderform">


            <ul class="neworder">
                <%--<li><span id="Phonic_usb"></span></li>--%>
                <li>来电号码 <input id="phone" class="phonetype"/>
                    乘客姓名 <input id="name" class="easyui-textbox" style="width: 120px"/></li>
                <li>出发地点 <input id="startaddress" class="inputtype" placeholder="不能为空" data-id="staraddresslist"/></li>
                <li>目的地点 <input id="endaddress" class="inputtype" data-id="endaddresslist"/></li>
                <li>预约时间 <input class="easyui-datetimebox" data-options="editable:false" prompt="需要预约请选择时间"/></li>
                <li>联系电话 <input id="clientphone" class="easyui-textbox"/></li>
                <li>
                    <button id="send">发单</button>
                    <button id="clear">清空</button>
                </li>
            </ul>
            <div class="findcar">
                <table id="findcar" data-options="fit:true"></table>
            </div>

            <ul class="staraddresslist" id="staraddresslist">
            </ul>
            <ul class="endaddresslist" id="endaddresslist">
            </ul>

        </div>

        <div class="history">
            <div class="easyui-tabs" id="griltabs" style="width:100%;height:100%">
                <div title="历史电召单" style="padding:5px">
                    <table id="history" data-options="fit:true"></table>
                </div>
                <div title="常约车点" style="padding:5px">
                    <table id="commonpoint" data-options="fit:true"></table>
                </div>
            </div>
        </div>
    </div>
    <div id="maptip">地址搜索在"<span id="tipname"></span>"范围内,如果需要搜索其他市请重新设置默认视野</div>
    <div id="baidumaps">地图</div>
</div>

<div class="ordergrid">
    <table>
        <tr>
            <%--<td>网络状态:已连接</td>--%>
            <td>电话盒状态: <span id="dailerstatus"></span></td>
            <td>电召员：<span id="orderpoeple"></span></td>
            <td>电话状态： <span id="phonestatus"></span></td>
            <td>获取电话状态： <span id="gainstatus"></span></td>
            <td>
                <button onclick="reupload()">点击刷新</button>
            </td>
            <td>
                <embed type="application/ubox-plugin" width=0 height=0>
            </td>

        </tr>
    </table>
    <%--<div id="loginseats">--%>
    <%--<form id="form" >--%>
    <%--<h2>电召员登录</h2>--%>
    <%--<p>电召帐号</p>--%>
    <%--<input type="text" name="username" placeholder="请输入您的用户名" class="text">--%>
    <%--<p>密码</p>--%>
    <%--<input type="password" name="password" placeholder="请输入您的密码" class="text">--%>
    <%--<input type="hidden" name="cgflag" value="4"/>--%>
    <%--<p id="errorTips"></p>--%>
    <%--<input type="button" id="submit" value="登录" onclick="seatsccToLogin()">--%>
    <%--</form>--%>
    <%--</div>--%>

</div>

</body>
</html>

<script>
    var validCode = true;
    var screenHeight = window.innerHeight;
    var globab_clientId = sessionStorage.clientId;
    var globab_status;
    var token = sessionStorage.account;
    var startitle = "";
    var starAddress = "";
    var drivername = "";
    screenHeight = window.innerHeight;
    $(".orderinfo").css({'height': screenHeight - $(".ordergrid").height()});
    $(".history").css({'height': screenHeight - $(".ordergrid").height() - $(".orderform").height()});


    window.onresize = function () {
        screenHeight = window.innerHeight;
        $(".orderinfo").css({'height': screenHeight - $(".ordergrid").height()});
        $(".history").css({'height': screenHeight - $(".ordergrid").height() - $(".orderform").height()});
//        //console.info($(".history").height);
    };

    //上keyCode=38,下keyCode=40,tab键keyCode=9,enter键keyCode=13
    //记录ID
    var recordId = null;
    //记录当前焦点在第几个位置
    var focusPos = -1;
    var recordname = "";


    $("#startaddress").on("focus", function () {
        recordId = $(this);
        recordname = recordId.get(0).id;
    });
    $("#endaddress").on("focus", function () {
        recordId = $(this);
        recordname = recordId.get(0).id;

    });
    $(document).on("keydown", function (e) {

        if (e.keyCode == 9) {
            focusPos = -1;
        }
        if (e.keyCode == 38) {
            focusPos = focusPos - 1;
            if (focusPos <= 0) {
                focusPos = 0;
            }
            $("#" + recordId.data("id")).children().eq(focusPos).addClass("active").siblings().removeClass("active");
        } else if (e.keyCode == 40) {
            focusPos = focusPos + 1;
            if (focusPos >= $("#" + recordId.data("id")).children().length) {
                focusPos = $("#" + recordId.data("id")).children().length - 1;
            }
            $("#" + recordId.data("id")).children().eq(focusPos).addClass("active").siblings().removeClass("active");
        }
        if (e.keyCode == 13) {
            if (focusPos != -1) {
                var returetitle = $("#" + recordId.data("id")).children().eq(focusPos).children("h3").html();
                var retureaddress = $("#" + recordId.data("id")).children().eq(focusPos).children("p").html();
                var returelt = $("#" + recordId.data("id")).children().eq(focusPos).children("span").html();
                var returelg = $("#" + recordId.data("id")).children().eq(focusPos).children("em").html();

                if (recordname == "startaddress") {
                    starlg = returelg;
                    starlt = returelt;
                    staradd = returetitle + "," + retureaddress;
                    startitle = returetitle;
                    starAddress = retureaddress;
                    $("#startaddress").val(retureaddress + "(" + returetitle + ")");
                    addMarker(starlg, starlt);
//                    console.info("startitle:"+startitle);
//                    console.info("starAddress:"+starAddress);
//                    //百度转火星
//                    var bdtogcj = bd09togcj02(starlg,starlt);
//                    //火星转84
//                    var gcjtowgs = gcj02towgs84(bdtogcj[0],bdtogcj[1]);
//                    starlgwsg84=gcjtowgs[0];
//                    starltwsg84 = gcjtowgs[1];
                    if (sessionStorage.assign == 0) {
                        findcarDate(overallAccount, starlg, starlt);
                    }


                    $(".staraddresslist li").remove();
                    focusPos = -1;
                } else if (recordname == "endaddress") {

                    endlg = returelg;
                    endlt = returelt;
                    endadd = returetitle + "," + retureaddress;
                    $("#endaddress").val(retureaddress + "(" + returetitle + ")");
                    addMarker(endlg, endlt);
//                    //百度转火星
//                    var bdtogcj = bd09togcj02(endlg,endlt);
//                    //火星转84
//                    var gcjtowgs = gcj02towgs84(bdtogcj[0],bdtogcj[1]);
//                    endlgwsg84=gcjtowgs[0];
//                    endltwsg84 = gcjtowgs[1];

                    $(".endaddresslist li").remove();

                    focusPos = -1;
                }

            } else {
                submitOrder();
            }

        }
    });

    var historygrid;
    var ordergridgrid;
    var findcargrid;
    var carFilePathOnline = picturepath + "/public/images/online.png";
    var Defaultlg = 113.281608;
    var Defaultlt = 23.094162;
    var starlg = "";
    var starlt = "";
    var starlgwsg84 = "";
    var starltwsg84 = "";
    var endlg = "";
    var endlt = "";
    var endlgwsg84 = "";
    var endltwsg84 = "";
    var staradd = "";
    var endadd = "";
    var overallAccount = "";
    var global_marker = "";
    var geoc = "";
    var AllCarInfomation = "";
    var wblg = "";
    var wblt = "";


    $(function () {

        overallAccount = sessionStorage.accountName;
        $('#orderpoeple').html(sessionStorage.accountName);


        if (getBrowserName() == "Firefox") {
            //加载电话盒
            Phonic_usb.OpenLogFile(0);
            ubox_CloseDevice();
            ubox_openDevice();
        } else {
            var test = "当前浏览器不支持自动获取";
            $('#dailerstatus').html(test).addClass("tiperror");
            $('#phonestatus').html(test).addClass("tiperror");
            $('#gainstatus').html(test).addClass("tiperror");
        }

        $('#phone').focus();

        historyDate(GetDateStr(0), GetDateStr(1), -1, -1, overallAccount);
//        commonpoint(12345678958);
        if (sessionStorage.assign == 0) {
            findcarDate(overallAccount, Defaultlg, Defaultlt);
        }

//        commonpoint("");

        var datatime = 60 * 60 * 24 * 7;
        //定时器
        funSetInterval(datatime, 10);

        //开始位置当输入框改变时改变

        $('#startaddress').bind('input', function () {

            var startaddress = $("#startaddress").val();
//            ////console.info(startaddress);
            $(".staraddresslist li").remove();

            addresslist(startaddress, "#staraddresslist");
        });

        $("#phone").on("input", function () {
            //console.info($(this).val());
            if ($(this).val() != "" && $(this).val() != null) {
                commonpoint($(this).val());
//                console.info($(this).val());
                var phone = $(this).val().indexOf(1);
                if ($(this).val().indexOf(1) == 0) {
                    //手机
                    if (!/^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})|(14[0-9]{1})|(16[0-9]{1})|(17[0-9]{1}))+\d{8})$/.test($(this).val())) {
                        $(this).addClass("phre");
                    } else {
                        $(this).removeClass("phre");
                    }
                } else {
                    //固话
                    if (!/^([0-9]{3,4}-)?[0-9]{7,8}$/.test($(this).val())) {
                        $(this).addClass("phre");
                    } else {
                        $(this).removeClass("phre");
                    }

                }

            }

        });

        function checkUser(str) {
            var re = /^[a-zA-z]\w{3,15}$/;
            if (re.test(str)) {
                console.info("正确");
            } else {
                console.info("错误");
            }
        }

        function checkMobile(str) {
            var re = /^[a-zA-z]\w{3,15}$/;
            if (re.test(str)) {
                console.info("正确");
            } else {
                console.info("错误");
            }
        }


        //开始位置
        $(".staraddresslist").on("click", 'li', function () {
            var returetitle = $(this).children("h3").html();
            var retureaddress = $(this).children("p").html();
            var returelt = $(this).children("span").html();
            var returelg = $(this).children("em").html();


            starlg = returelg;
            starlt = returelt;
            staradd = returetitle + "," + retureaddress;
            startitle = returetitle;
            starAddress = retureaddress;
//            console.info("startitle:"+startitle);
//            console.info("starAddress:"+starAddress);
            $("#startaddress").val(retureaddress + "(" + returetitle + ")");
            addMarker(starlg, starlt);
            //百度转火星
//            var bdtogcj = bd09togcj02(starlg,starlt);
//            //火星转84
//            var gcjtowgs = gcj02towgs84(bdtogcj[0],bdtogcj[1]);
//            starlgwsg84=gcjtowgs[0];
//            starltwsg84 = gcjtowgs[1];
            if (sessionStorage.assign == 0) {
                findcarDate(overallAccount, starlg, starlt);
            }
            $(".staraddresslist li").remove();

        });

        //目的位置当输入框改变时改变
        $('#endaddress').bind('input', function () {

            var endaddress = $("#endaddress").val();

            $(".endaddresslist li").remove();

            addresslist(endaddress, "#endaddresslist");
        });

        //目的地
        $(".endaddresslist").on("click", 'li', function () {
            var returetitle = $(this).children("h3").html();
            var retureaddress = $(this).children("p").html();
            var returelt = $(this).children("span").html();
            var returelg = $(this).children("em").html();


            endlg = returelg;
            endlt = returelt;
            endadd = returetitle + "," + retureaddress;
            $("#endaddress").val(retureaddress + "(" + returetitle + ")");
            addMarker(endlg, endlt);

//            $("#addresslist").hide();
//            //百度转火星
//            var bdtogcj = bd09togcj02(endlg,endlt);
//            //火星转84
//            var gcjtowgs = gcj02towgs84(bdtogcj[0],bdtogcj[1]);
//            endlgwsg84=gcjtowgs[0];
//            endltwsg84 = gcjtowgs[1];

            //清空搜索地址
//            $(".endaddressinput").val("");
            $(".endaddresslist li").remove();

        });

        $("#startaddress").blur(function () {
            setTimeout(function () {
                $(".staraddresslist li").remove();
            }, 500);

        });

        $("#endaddress").blur(function () {
            setTimeout(function () {
                $(".endaddresslist li").remove();
            }, 500);

        });

        //提交
        $("#send").click(function () {
            submitOrder();
//            if(sessionStorage.assign==0) {
//
//            }
// else{
//                //指定派单
//                submitOrder2();
//            }

        });

        $("#clear").on("click", function () {
            $('#phone').val("");
            $('#name').textbox("setValue", "");
            $('#startaddress').val("");
            $('#endaddress').val("");
            $('#clientphone').textbox("setValue", "");

            historyDate(GetDateStr(0), GetDateStr(1), -1, -1, overallAccount);
            if (sessionStorage.assign == 0) {
                findcarDate(overallAccount, 0, 0);
            }


        });


    });

    function refreshGrildata() {
        $("#history").datagrid('reload');
        $("#ordergrid").datagrid('reload');
        if (sessionStorage.assign == 1) {
            $("#findcar").datagrid('reload');
        }
    }

    function historyDate(startime, endtime, status, ordertype, key) {
        var DataUrl = "startime=" + startime + "&endtime=" + endtime + "&status=" + status + "&ordertype=" + ordertype + "&order=desc&sort=billid&key=" + key + "&clientid=" + globab_clientId;
        //console.info(DataUrl);
        historygrid = $("#history").datagrid({
            fit: true,
            url: path + "/callbuss/findCallBussForPageList?" + DataUrl,
            method: "get",
            fitColumns: true,
            striped: true,
            columns: [
                [
                    {field: 'billid', title: '历史订单号', width: 100, align: 'center'},
//                    {field: 'clientname', title: '乘客姓名', width: 100, align: 'center',sortable:true},
                    {field: 'clientmobile', title: '乘客电话', width: 100, align: 'center', sortable: true},
                    {field: 'calltime', title: '用车时间', width: 100, align: 'center'},
                    {field: 'srcaddr', title: '出发地', width: 100, align: 'center', sortable: true},
                    {field: 'address', title: '目的地', width: 100, align: 'center', sortable: true},
                    {
                        field: 'status', title: '订单状态', width: 100, align: 'center', sortable: true,
                        formatter: function (value) {
                            globab_status = value;
                            return getValueFromArray(value, ordstartus);
                        }
                    }
                    ,
                    {
                        field: 'operating', title: '操作', width: 100, align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            if (globab_status < 3) {
                                var codes = row["billid"];
                                return '<span class="openrelation" onclick="openrelation(id)" id=' + codes + '>可撤回订单</span>';
                            }

                        }
                    }
                ]
            ],
            onLoadSuccess: function (data) {
//                ////console.info(data);
            },
            idField: 'phone',
            sortName: 'phone',
            sortOrder: 'desc',
            singleSelect: true,
            pageSize: 20
        });
        grid = historygrid;
    }

    function commonpoint(phone) {


        var dataUrl = "order=desc&sort=id&geographical=&position=&type=-1&phone=" + phone + "&clientid=" + globab_clientId + "&token=" + token;
        //console.info("dataUrl:"+dataUrl);

        var commonpointgrid = $("#commonpoint").datagrid({
            fit: true,
            url: path + "/commonpoint/findCommonPointForPageList?" + dataUrl,
            fitColumns: true,
            striped: true,
            columns: [
                [
                    {field: 'position', title: '位置描述', width: 100, align: 'center', sortable: true},
                    {
                        field: 'type', title: '类型', width: 100, align: 'center', sortable: true,
                        formatter: function (value) {
                            switch (value) {
                                case 0 :
                                    return "景点";
                                    break;
                                case 1:
                                    return "宾馆";
                                    break;
                                case 2:
                                    return "其它";
                                    break;
                                default:
                                    return "";
                            }
                        }
                    },
                    {field: 'geographical', title: '地理位置', width: 100, align: 'center'}
                ]
            ],
            onLoadSuccess: function (data) {
//                console.info(data);
                if (data.total > 0) {
                    $('#griltabs').tabs('select', 1);
//                    console.info("111111111");
                }
//                else{
////                    console.info("222222222");
//                    commonpoint("");
//                    $('#griltabs').tabs('select', 1);
//                }
//                if(phone==""){
//                    $('#griltabs').tabs('select', 0);
//                }

            },
            onSelect: function (index, row) {
                //console.info(row);
                if (row != "") {
                    commonpointlglat(row);
                }
            },
            idField: 'phone',
            sortName: 'phone',
            sortOrder: 'desc',
            singleSelect: true,
            pageSize: 20
        });
    }

    function orderDate(startime, endtime, status, ordertype, key) {
        var DataUrl = "startime=" + startime + "&endtime=" + endtime + "&status=" + status + "&ordertype=" + ordertype + "&order=desc&sort=billid&key=" + key + "&clientid=" + globab_clientId;

        ordergridgrid = $("#ordergrid").datagrid({
            fit: true,
            url: path + "/callbuss/findCallBussForPageList?" + DataUrl,
            method: "get",
            fitColumns: true,
            striped: true,

            columns: [
                [
                    {field: 'billid', title: '最新接单订单号', width: 100, align: 'center'},
                    {field: 'clientname', title: '乘客姓名', width: 100, align: 'center', sortable: true},
                    {field: 'clientmobile', title: '乘客电话', width: 100, align: 'center', sortable: true},
                    {field: 'calltime', title: '用车时间', width: 100, align: 'center'},
                    {field: 'srcaddr', title: '出发地', width: 100, align: 'center', sortable: true},
                    {field: 'address', title: '目的地', width: 100, align: 'center', sortable: true},
                    {
                        field: 'carbox', title: '调派车辆', width: 100, align: 'center', sortable: true
                    },
                    {
                        field: 'driver', title: '司机名称', width: 100, align: 'center', sortable: true,
                        formatter: function (value) {
                            if (value != null || value != undefined) {
                                return value.name;
                            } else {
                                return "";
                            }

                        }
                    },
                    {
                        field: 'status', title: '订单状态', width: 100, align: 'center', sortable: true,
                        formatter: function (value) {
                            return getValueFromArray(value, ordstartus);
                        }
                    }
                ]
            ],
            onLoadSuccess: function (data) {
//                ////console.info(data);
            },
            idField: 'phone',
            sortName: 'phone',
            sortOrder: 'desc',
            singleSelect: true,
            pageSize: 1
        });
    }

    function findcarDate(account, lg, lt) {

        var dataurl = "account=" + account + "&lg=" + lg + "&lt=" + lt;
        $.ajax({
            url: seatpath + "/smartkab/position/list?" + dataurl,
            type: "GET",
            crossDomain: true,
            cache: false,
            dataType: "json", //后台返回值类型
            contentType: "application/json;charset=utf-8",
            success: function (data) {

                if (!jQuery.isEmptyObject(data)) {
                    nearbyCar(data);
                }
                findcargrid = $("#findcar").datagrid({
                    fit: true,
                    data: data,
                    fitColumns: true,
                    striped: true,
                    columns: [
                        [
                            {field: 'kabName', title: '车牌号', width: 100, align: 'center', sortable: true}
                        ]
                    ],
                    onLoadSuccess: function (data) {
//                        ////console.info(data);
                    },
                    idField: 'phone',
                    sortName: 'phone',
                    sortOrder: 'desc',
                    singleSelect: true,
                    pageSize: 1
                });
            }
        });


    }

    function findcaronline(account, lg, lt) {

        var dataurl = path + "/driver/findDriverOnOfflineCar?kabnum=&isonline=1" + "&clientid=" + globab_clientId + "&token=" + token;
        $.ajax({
            url: dataurl,
            type: "POST",
            crossDomain: true,
            cache: false,
            dataType: "json", //后台返回值类型
            contentType: "application/json;charset=utf-8",
            success: function (data) {
                console.info(data);
                if (!jQuery.isEmptyObject(data)) {
                    nearbyCar2(data);
                }
                findcargrid = $("#findcar").datagrid({
                    fit: true,
                    data: data,
                    fitColumns: true,
                    striped: true,
                    columns: [
                        [
                            {field: 'kabnum', title: '在线车牌号', width: 100, align: 'center', sortable: true}
                        ]
                    ],
                    onLoadSuccess: function (data) {
//                        ////console.info(data);
                    },
                    onClickRow: function (index, row) {
                        console.info(row);
                        drivername = row.account;
                    },
                    idField: 'phone',
                    sortName: 'phone',
                    sortOrder: 'desc',
                    singleSelect: true,
                    pageSize: 1
                });
            }
        });


    }


    function addresslist(data, list) {

        var options = {
            onSearchComplete: function (results) {
                if (local.getStatus() == BMAP_STATUS_SUCCESS) {
                    var s = [];
                    var addresslenght = results.getCurrentNumPois();
                    if (addresslenght > 10) {
                        addresslenght = 10;
                    }
                    for (var i = 0; i < addresslenght; i++) {
                        var listr = "";
                        listr += '<li>';
                        listr += '<h3 class="addresstitle" >' + results.getPoi(i).title + '</h3>';
                        listr += '<p class="addressinfo">' + results.getPoi(i).address + '</p>';
                        listr += '<span style="display: none">' + results.getPoi(i).point.lat + '</span>';
                        listr += '<em style="display: none">' + results.getPoi(i).point.lng + '</em>';
                        listr += '</li>';
                        $(listr).appendTo(list);
                    }
                }
            }
        };

        var local = new BMap.LocalSearch(map, options);
        local.search(data);

    }

    function nearbyCar(data) {
//        //console.info(data);
        for (var i = 0; i < data.length; i++) {
            var point = new BMap.Point(data[i].lg, data[i].lt);
            var msId = data[i].msId;
            var kabName = data[i].kabName;

            (function (point, msId, kabName, i) {
                var convertor = new BMap.Convertor();
                var pointArr = [];
                pointArr.push(point);
                convertor.translate(pointArr, 1, 5, function (p) {
                    if (p.status === 0) {
//                        //console.info("----"+i+"------");
                        AddCar(msId, kabName, msId, p.points[0].lng, p.points[0].lat);
                    }
                });
            })(point, msId, kabName, i);

        }
    }

    function nearbyCar2(data) {
//console.info(data);
        for (var i = 0; i < data.total; i++) {

            var point = new BMap.Point(data.rows[i].lastlg, data.rows[i].lastlt);
            var msId = data.rows[i].msid;
            var kabName = data.rows[i].kabnum;

            (function (point, msId, kabName, i) {
                var convertor = new BMap.Convertor();
                var pointArr = [];
                pointArr.push(point);
                convertor.translate(pointArr, 1, 5, function (p) {
                    if (p.status === 0) {
//                        //console.info("----"+i+"------");
                        AddCar(msId, kabName, msId, p.points[0].lng, p.points[0].lat);
                    }
                });
            })(point, msId, kabName, i);

        }
    }

    function submitOrder() {

        $('#griltabs').tabs('select', 0);

//        ////console.info("submitOrder");
        var account = overallAccount;
        var phone = $("#phone").val();
        var name = $("#name").textbox('getValue');

        if (phone == null || phone == "") {
            alert("来电号码不能为空！");
            return;
        }
//        if(!/^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/.test(phone)){
//            alert("手机格式错误");
//            return;
//        }
        if (phone.indexOf(1) == 0) {
            //手机
            if (!/^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})|(14[0-9]{1})|(16[0-9]{1})|(17[0-9]{1}))+\d{8})$/.test(phone)) {
                alert("手机格式错误");
                return;
            }
        } else {
            //固话
            if (!/^([0-9]{3,4}-)?[0-9]{7,8}$/.test(phone)) {
                alert("固话格式错误");
                return;
            }
        }

        if (staradd == null || staradd == "") {
            alert("出发地点不能为空或无法获取当前经纬度！");
            return;
        }

        //account坐席号码
        account = overallAccount;

        var data = {
            "account": account,
            "dstAddr": endadd,
            "dstLg": endlg,
            "dstLt": endlt,
            "srcAddr": staradd,
            "srcLg": starlg,
            "srcLt": starlt,
            "type": 0,
            "remark": "",
            "orderType": 2,
            "phone": phone,
            "name": name,
            "driver": drivername
        };
        //console.info(data);

        $.ajax({
            url: seatpath + "/smartkab/order/neworder ",
            type: "POST",
            crossDomain: true,
            data: JSON.stringify(data), //必须转成JSON进行传递，否则会报code 117错误
            cache: false,
            dataType: "json", //后台返回值类型
            contentType: "application/json;charset=utf-8",
            success: function (data) {
//                ////console.info(data);
                if (data.code == 0) {
                    $("#clear").click();
                }
                $.messager.show({
                    title: '提示',
                    msg: data.desc,
                    timeout: 3000,
                    showType: 'slide'
                });

                $('#phone').focus();
                clearcar(AllCarInfomation);
                $("#findcar").datagrid('clearSelections');
                drivername = "";
            }
        });


        //自动添加常用约车点
        commonpointAdd(phone);

    }

    function submitOrder2() {

        $('#griltabs').tabs('select', 0);

//        ////console.info("submitOrder");
        var account = overallAccount;
        var phone = $("#phone").val();
        var name = $("#name").textbox('getValue');

        if (phone == null || phone == "") {
            alert("来电号码不能为空！");
            return;
        }

        if (phone.indexOf(1) == 0) {
            //手机
            if (!/^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})|(14[0-9]{1})|(16[0-9]{1})|(17[0-9]{1}))+\d{8})$/.test(phone)) {
                alert("手机格式错误");
                return;
            }
        } else {
            //固话
            if (!/^([0-9]{3,4}-)?[0-9]{7,8}$/.test(phone)) {
                alert("固话格式错误");
                return;
            }
        }
        if (staradd == null || staradd == "") {
            alert("出发地点不能为空或无法获取当前经纬度！");
            return;
        }
        if (drivername == null || drivername == "") {
            alert("请指定派单车辆！");
            return;
        }
        //account坐席号码
        account = overallAccount;

        var data = {
            "account": account,
            "dstAddr": endadd,
            "dstLg": endlg,
            "dstLt": endlt,
            "srcAddr": staradd,
            "srcLg": starlg,
            "srcLt": starlt,
            "type": 0,
            "remark": "",
            "orderType": 2,
            "phone": phone,
            "name": name,
            "driver": drivername
        };
        //console.info(data);

        $.ajax({
            url: seatpath + "/smartkab/order/neworder ",
            type: "POST",
            crossDomain: true,
            data: JSON.stringify(data), //必须转成JSON进行传递，否则会报code 117错误
            cache: false,
            dataType: "json", //后台返回值类型
            contentType: "application/json;charset=utf-8",
            success: function (data) {
//                ////console.info(data);
                if (data.code == 0) {
                    $("#clear").click();
                }
                $.messager.show({
                    title: '提示',
                    msg: data.desc,
                    timeout: 3000,
                    showType: 'slide'
                });

                $('#phone').focus();
                clearcar(AllCarInfomation);
                $("#findcar").datagrid('clearSelections');
                drivername = "";
            }
        });


        //自动添加常用约车点
        commonpointAdd(phone);

    }

    function commonpointAdd(phone) {

        if (startitle == "") {
            startitle = "自动生成"
        }

        var data = {
            "position": startitle,
            "phone": phone,
            "geographical": starAddress,
            "type": 0,
            "lg": starlg,
            "lat": starlt,
            "clientid": globab_clientId,
            "token": token
        };

        var requestURL = path + "/commonpoint/saveorupdateCommonPoint";
        $.ajax({
            type: "POST",
            crossDomain: true,
            url: requestURL,
            data: JSON.stringify(data), //必须转成JSON进行传递，否则会报code 117错误
            cache: false,
            dataType: "json", //后台返回值类型
            contentType: "application/json",
            success: function (data) {
                console.info(data);
            }
        });
    }


    var map;
    var myCity;

    function loadJScript() {
        AllCarInfomation = new Array();
        var script = document.createElement("script");
        script.type = "text/javascript";
        script.src = "http://api.map.baidu.com/api?v=2.0&ak=78OhopFWz7wPFKlaFXA1DYPU&callback=init";
        document.body.appendChild(script);

    }

    function init() {


        // 初始化设置
        map = new BMap.Map("baidumaps");//在百度地图容器中创建一个地图
        var point = new BMap.Point(113.442087, 23.173325);//定义一个中心点坐标
        map.centerAndZoom(point, 16);//设定地图的中心点和坐标并将地图显示在地图容器中
        map.addControl(new BMap.MapTypeControl());   //添加地图类型控件
        map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
        var navigationControl = new BMap.NavigationControl({
            // 靠左上角位置
            anchor: BMAP_ANCHOR_BOTTOM_RIGHT,
            // LARGE类型
            type: BMAP_NAVIGATION_CONTROL_ZOOM,
            // 启用显示定位
            enableGeolocation: true
        });
        map.addControl(navigationControl);
        geoc = new BMap.Geocoder();

        MoveDefaultView();//默认位置
        if (sessionStorage.assign == 1) {
            findcaronline(0, 0, 0);
        }
        // 添加菜单 START
        var menu = new BMap.ContextMenu();
        var txtMenuItem =
            [
                {
                    text: '放大',
                    callback: function () {
                        map.zoomIn()
                    }
                },
                {
                    text: '缩小',
                    callback: function () {
                        map.zoomOut()
                    }
                },
                {
                    text: '移动默认视野',
                    callback: function () {
                        MoveDefaultView();
                    }
                },
                {
                    text: '设置默认视野',
                    callback: function () {
                        SetDefaultView();
                    }
                }
            ];

        for (var nIndex = 0; nIndex < txtMenuItem.length; nIndex++) {
            menu.addItem(new BMap.MenuItem(txtMenuItem[nIndex].text, txtMenuItem[nIndex].callback, 100));
        }

        map.addContextMenu(menu);
        // 添加菜单 END
        //////////////////////////////////////////////////////////////////////////
        // 鼠标移动事件
        map.addEventListener("mousemove", OnMapMouseMove);

    }

    window.onload = loadJScript;  //异步加载地图

    // 编写自定义函数,创建标注
    function addMarker(dLg, dLt) {
        map.removeOverlay(global_marker);
        var point = new BMap.Point(dLg, dLt);
        map.centerAndZoom(point, 17);
        global_marker = new BMap.Marker(point);  // 创建标注
        map.addOverlay(global_marker);               // 将标注添加到地图中
        global_marker.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画
    }


    //在地图上添加车
    function AddCar(MSID, strLabel, Phone, dLg, dLt) {

        var strFilePath = carFilePathOnline;

        var strTitle = "[车牌号码:" + strLabel + "][电话号码:" + Phone + "]";

        var myIcon = new BMap.Icon(strFilePath, new BMap.Size(64, 64),
            {
                offset: new BMap.Size(0, 0),
                imageOffset: new BMap.Size(0, 0)
            });

        var marker = new BMap.Marker(new BMap.Point(dLg, dLt), {icon: myIcon});  // 创建标注
        map.addOverlay(marker);                                                // 将标注添加到地图中
        var label = new BMap.Label(strLabel, {offset: new BMap.Size(-15, 40)});    // 添加标签
        label.setStyle({
            color: "#ffffff",
            fontSize: "12px",
            padding: "3px",
            height: "20px",
            lineHeight: "20px",
            fontFamily: "微软雅黑",
            border: "none",
            background: "#02A1DB",
            boxShadow: "1px 1px 2px rgba(0,0,0,0.4)"

        });
        marker.setLabel(label);
        marker.setTitle(strTitle);

        AllCarInfomation[MSID] = marker;
    }

    //在地图上添加车
    function AddCar2(dLg, dLt) {

        var strFilePath = carFilePathOnline;

        var myIcon = new BMap.Icon(strFilePath, new BMap.Size(64, 64),
            {
                offset: new BMap.Size(0, 0),
                imageOffset: new BMap.Size(0, 0)
            });

        var marker = new BMap.Marker(new BMap.Point(dLg, dLt), {icon: myIcon});  // 创建标注
        map.addOverlay(marker);
    }

    function clearcar(datas) {
        for (y in datas) {
//            //console.info(datas[y]);
            map.removeOverlay(datas[y]);
        }
    }

    function MoveToPoint(dLg, dLt) {
        var point = new BMap.Point(dLg, dLt);
        map.panTo(point);
    }

    //定时器方法
    function funSetInterval(time, refreshnum) {
        if (validCode) {
            validCode = false;
            var t = setInterval(function () {
                time--;
                //放入需要刷新的方法
                if (time % refreshnum == 0) {
                    refreshGrildata();
                }
                if (time == 0) {
                    clearInterval(t);
                    validCode = true;
                }
            }, 1000)
        }
    }

    //移动到默认视野
    function MoveDefaultView() {
        var dataUrl = "SSid=" + 1001 + "&userid=" + sessionStorage.accountID;
        //console.info(dataUrl);
        $.ajax({
            url: path + '/driver/finddefPosbyUseid?' + dataUrl,
            dataType: 'json',
            type: 'GET',
            async: false,
            success: function (data) {
                //console.info(data);
                var point = "";
                var defzoon = "";
                if (data != null) {
                    if (!isEmptyObj(data)) {
//                    var data = data.rows;
                        if (data.deflg != null || data.deflg != "" || data.deflg != undefined) {
                            point = new BMap.Point(data.deflg, data.deflt); // 创建点坐标
                        }

                        if (data.layer != null || data.layer != undefined) {
                            defzoon = data.layer;
                        } else {
                            defzoon = 8;
                        }
                        Defaultlg = data.deflg;
                        Defaultlt = data.deflt;
//                    //console.info("PointtoAddress");
                        //有经纬度跳转
                        PointtoAddress(Defaultlg, Defaultlt);

                    }
                    else {
                        //没有经纬度跳转
                        //ip定位
                        myCity = new BMap.LocalCity();
                        myCity.get(myFun);
//                    point = new BMap.Point(Defaultlg, Defaultlt); // 创建点坐标
//                    defzoon=8;
                    }
                    map.centerAndZoom(point, defzoon);
                } else {
                    myCity = new BMap.LocalCity();
                    myCity.get(myFun);
                }


            }
        });


    }

    //设置默认经纬度
    function SetDefaultView() {

        if (global_lg == "") {
            alert("设置默认经纬度失败，无法获取当前经纬度！");
            return;
        }

        var data = {
            "userId": sessionStorage.accountID,
            "ssid": 1001,
            "deflg": global_lg,
            "deflt": global_lt,
            "layer": global_layer
        };
        var requestURL = path + "/defaultPosition/saveorupdateDefaultPosition";
        $.ajax({
            type: "POST",
            crossDomain: true,
            url: requestURL,
            data: JSON.stringify(data), //必须转成JSON进行传递，否则会报code 117错误
            cache: false,
            dataType: "json", //后台返回值类型
            contentType: "application/json",
            success: function (data) {
//                ////console.info(data);
                PointtoAddress(global_lg, global_lt);
            }
        });
    }

    function PointtoAddress(lg, lt) {
        var pt = new BMap.Point(lg, lt);
        geoc.getLocation(pt, function (rs) {
            var addComp = rs.addressComponents;
            $("#tipname").html(addComp.province + "," + addComp.city);
        });
    }

    // 鼠标移动事件 START
    function OnMapMouseMove(e) {
        global_lg = e.point.lng;
        global_lt = e.point.lat;
        global_layer = map.getZoom();
//            ////console.info("[POCTALK]|OnMapMouseMove|"+e.point.lng+","+e.point.lat+",|");
    }

    //ip定位
    function myFun(result) {

        var cityName = result.name;
        map.setCenter(cityName);
        $("#tipname").html(cityName);
        Defaultlg = result.center.lng;
        Defaultlt = result.center.lat;

    }

    function reupload() {
        location.reload();
    }

    //电召员登录
    function seatsccToLogin() {
        var $name_username = $("input[name='username']");
        var $name_password = $("input[name='password']");
        var username = $name_username.val();
        var password = $name_password.val();
        //判断用户名或密码是否为空或错误
        if (username === '') {
            $id_errorTips.html("错误提示：用户名不能为空！");
            $name_username.focus();
            return false;
        } else if (password === '') {
            $id_errorTips.html("错误提示：密码不能为空！");
            $name_password.focus();
            return false;
        } else if (!/^[a-zA-Z0-9]+$/.test(username)) {
            $id_errorTips.html("错误提示：用户名只能为英文字母和数字！");
            $name_username.focus();
            return false;
        } else if (!/^\d+$/.test(password)) {
            $id_errorTips.html("错误提示：密码只能为数字！");
            $name_password.focus();
            return false;
        }

        var data = {
            "accountName": username,
            "passwd": password
        };


        var requestURL = path + "/userinfo/seatloginObject";
        $.ajax({
            type: "POST",
            crossDomain: true,
            url: requestURL,
            data: JSON.stringify(data), //必须转成JSON进行传递，否则会报code 117错误
            cache: false,
            dataType: "json", //后台返回值类型
            contentType: "application/json;charset=utf-8",
            success: function (data) {

                ////console.info(data);
                if (data.code === 0) {
//                    overallAccount=data.desc;
                    sessionStorage.seat = data.desc;
                    overallAccount = sessionStorage.seat;
                    $('#orderpoeple').html(sessionStorage.seat);
                    $("#loginseats").hide();
                    historyDate(GetDateStr(0), GetDateStr(1), -1, -1, overallAccount);
                } else if (data.code === 1) {
                    alert(data.desc);
                }
            }
        });
    }


    function clearall() {
        //console.info("clearall");
        map.clearOverlays();
    }

    function commonpointlglat(row) {
//        console.info(row);
        startitle = row.position;
        starAddress = row.geographical;

        $('#startaddress').val(row.geographical);
        starlg = row.lg;
        starlt = row.lat;
        addMarker(starlg, starlt);
        staradd = row.geographical;
//        //百度转火星
//        var bdtogcj = bd09togcj02(starlg,starlt);
//        //火星转84
//        var gcjtowgs = gcj02towgs84(bdtogcj[0],bdtogcj[1]);
//        starlgwsg84=gcjtowgs[0];
//        starltwsg84 = gcjtowgs[1];
        if (sessionStorage.assign == 0) {
            findcarDate(overallAccount, starlg, starlt);
        }
    }

    function cancelOrder(ordernum) {

        var data = {
            "account": account,
            "orderNum": ordernum,
            "remark": "取消订单"
        };

//       console.info(data);

        $.ajax({
            url: seatpath + "/smartkab/order/neworder ",
            type: "POST",
            crossDomain: true,
            data: JSON.stringify(data), //必须转成JSON进行传递，否则会报code 117错误
            cache: false,
            dataType: "json", //后台返回值类型
            contentType: "application/json;charset=utf-8",
            success: function (data) {
//                ////console.info(data);
                if (data.code == 0) {
                    $("#clear").click();
                }
                $.messager.show({
                    title: '提示',
                    msg: data.desc,
                    timeout: 3000,
                    showType: 'slide'
                });

                $('#phone').focus();
                clearcar(AllCarInfomation);

            }
        });
    }

    //取消电召单
    function openrelation(data) {
        //console.info(data);
        var dialog = phm.modalDialog({
            title: '取消电召单',
            closable: true,
            url: "neworder_cancel.jsp?orderid=" + data,
            buttons: [
                {
                    text: '提交',
                    iconCls: 'icon-save',
                    handler: function () {
                        dialog.find('iframe').get(0).contentWindow.completedForm(dialog, grid, parent.$);
                    }
                },
                {
                    text: '取消',
                    iconCls: 'icon-cancel',
                    handler: function () {
                        dialog.dialog("close");
                    }
                }
            ]
        });
    }

    function phoneformat(data) {
        console.info(data);
        if (data.indexOf(1) == 0) {
            //手机
            if (!/^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})|(14[0-9]{1})|(16[0-9]{1})|(17[0-9]{1}))+\d{8})$/.test(data)) {
                alert("手机格式错误");
                return;
            }
        } else {
            //固话
            if (!/^([0-9]{3,4}-)?[0-9]{7,8}$/.test(data)) {
                alert("固话格式错误");
                return;
            }

        }
    }

</script>

<script language="javascript" type="text/javascript" src="ubox_web_demo/js/uboxweb.js"></script>
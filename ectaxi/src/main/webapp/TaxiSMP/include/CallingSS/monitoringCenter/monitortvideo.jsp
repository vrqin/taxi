<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <%--<meta name="renderer" content="webkit|ie-comp|ie-stand">--%>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <%--<meta name="wap-font-scale" content="no">--%>
    <%--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />--%>
    <title>视频监控</title>

    <link href="../../../public/jquery-easyui-1.5/themes/metro/easyui.css" rel="stylesheet"/>
    <link href="../../../public/jquery-easyui-1.5/themes/icon.css" rel="stylesheet"/>

    <%--<link href="video.css" type="text/css" rel="stylesheet">--%>
    <%--<script  type="text/javascript"  src="jquery.min.js"></script>--%>

    <script src="../../../public/jquery-easyui-1.5/js/jquery.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.easyui.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/easyui-lang-zh_CN.js"></script>

    <%--视频控件--%>
    <%--<link href="button.css" type="text/css" rel="stylesheet">--%>
    <%--<link href="video.css" type="text/css" rel="stylesheet">--%>
    <script type="text/javascript" src="jquery.query-2.1.7.js"></script>
    <script src="http://120.26.98.110/808gps/open/player/swfobject.js"></script>

    <!-- 数据接口路径、共用JS -->
    <script src="../../../public/js/path.js"></script>
    <script src="../../../public/js/tree_extend.js"></script>
    <style type="text/css">
        html, body {
            width: 100%;
            height: 100%;
            margin: 0px;
            padding: 0px;

        }

        .menutree {
            background-color: #E5EEF0;
            width: 220px;
            height: 100%;
            float: left;
            padding: 5px;
            box-sizing: border-box;
            overflow: auto;
        }

        .baidumap {
            width: 100%;
            height: 100%;
            margin-left: 220px;
            background-color: #ffffff;

        }

        .toptip {
            background-color: #F3FAFC;
            width: 100%;
            height: 40px;
            box-shadow: 0 2px 2px rgba(0, 0, 0, 0.3);
            position: relative;
            z-index: 99;
        }

        .toptip ul {
            margin: 0px;
            float: right;
            margin-right: 245px;
            line-height: 40px;

        }

        .toptip ul li {
            list-style: none;
            float: left;
            padding: 0px 12px;
            font-size: 12px;
            cursor: pointer;
        }

        ul.bottomtip {
            margin: 0px;
            line-height: 30px;
        }

        .bottomtip {

            background-color: #F3FAFC;
            width: 100%;
            height: 30px;

        }

        .bottomtip li {
            list-style: none;
            float: left;
            width: 13%;
            font-size: 12px;

        }

        #baidumaps {
            width: 100%;

        }

        #maptip {
            position: absolute;
            left: 50%;
            top: 50%;
            font-size: 30px;

        }

        .menutree > div {
            padding: 4px 0px;
            margin: 0px;
        }

        #searchTree {
            width: 100px;
            border: 1px solid;
            border-color: #81AFE8;
            text-indent: 3px;
        }

        .menutree div > button {
            border: none;
            background: #81AFE8;
            color: #fff;
            padding: 3px 4px;
        }

        .treebgnum {
            color: red;
            font-size: 12px;
        }
    </style>


</head>
<body class="easyui-layout" data-options="border:false ,fit:true">
<div class="menutree">
    <div>
        <input class="span2" type="text" name="searchTree" id="searchTree"/>
        <button class="btn" type="button" onclick="serachTreeClick()">搜索</button>
        <button class="btn" type="button" onclick="ResetTreeClick()">重置</button>
    </div>
    <ul id="classlist" class="easyui-tree" data-options="animate:false,fit:true,border:false,lines:true">
    </ul>

</div>
<div class="baidumap">
    <div class="toptip">
        <ul>
            <%--<li id="setview" onclick="playLiveVideo()">设置默认视野</li>--%>
            <%--<li id="moveview">移动到默认视野</li>--%>
            <%--<li>清除车辆</li>--%>
            <%--<li onclick="treereload()">刷新</li>--%>
            <%--<li>地标</li>--%>
            <%--<li>线路</li>--%>
            <%--<li>区域</li>--%>
            <%--<li id="rangingtool">测距</li>--%>
            <%--<li>信息列表</li>--%>
            <%--<li>选择状态</li>--%>
            <%--<li id="fullscreen" onclick="launchFullscreen(document.documentElement)" title="点击全屏观看,按键盘ESC键退出全屏">全屏</li>--%>
        </ul>
    </div>
    <%--<span id="maptip">正在加载，请稍候...</span>--%>
    <%--<div id="baidumaps">--%>


    <%--</div>--%>
    <div id="cmsv6flash"></div>


    <ul class="bottomtip">
        <li>车辆总数: <span id="callnum">0</span></li>
        <li>车辆在线数: <span id="online">1(1.47%)</span></li>
        <li>车辆空驶数: <span id="empty">1(100.00%)</span></li>
        <li>车辆载客数: <span id="passenger">0(0.00%)</span></li>
        <li>电召单数: <span id="allbill">0(0.00%)</span></li>
        <li>故障: <span id="malfunction">0(0.00%)</span></li>

    </ul>

</div>

</body>
</html>
<script>
    var screenHeight = window.innerHeight;
    $(document).ready(function () {
        screenHeight = window.innerHeight;
        $("#cmsv6flash").css({'height': screenHeight - $(".toptip").height() - $(".bottomtip").height()});
    });
    window.onresize = function () {
        var screenHeight = window.innerHeight;
        var screenWidth = window.innerWidth;

        //视频插件宽度
        var width = screenWidth - $(".menutree").width();

        //视频插件高度
        var hieght = screenHeight - $(".toptip").height() - $(".bottomtip").height();
        $("#cmsv6flash").width(width);
        $("#cmsv6flash").height(hieght);
    };
    var globab_clientId = sessionStorage.clientId;

    $.extend($.fn.tree.methods, {
        getLevel: function (jq, target) {
            var l = $(target).parentsUntil("ul.tree", "ul");
            return l.length + 1;
        }
    });

    var validCode = true;
    var map;
    var AllCarInfomation;

    var AllUserPlace;
    var drivermarker = "";
    var carFilePathOnline;
    var carFilePathOffline;
    var GuidanceFilePath;
    var onlinenum = 0;
    var offlinenum = 0;
    var TempCar;
    var listr = "";
    var overalllasttime = "";
    var father;
    var global_lg = "";
    var global_lt = "";
    var global_layer = "";
    var token = sessionStorage.account;

    $(function () {

        //初始化视频插件


//        var datatime = 60*60*24*7;
//        funSetInterval(datatime,8);

        $("#contnet").hide();

        //下拉框改变事件
        $('input[name="selectShowStatus"]').click(function () {

            var checkValue = $(this).val();
//            alert(checkValue);
            if (TempCar != null) {
                for (var i = 0; i < TempCar.length; i++) {
                    ShowOrHidePoint(TempCar[i], 0);
                }
            }
            carstatus(checkValue);

        });

        //搜索功能
        $("#search-button").click(function () {

            $("#contnet").show();

            var key = $("#searchTaxi").val();

            if (key == null || key == "") {
                return;
            }
            //清空上次查询
            $("#ulList li").remove();

            $.ajax({
                url: '${path}/base/driver/findDriverListBykey.do',
                data: {
                    kabnum: key
                },
                dataType: 'json',
                type: "post",
                async: false,
                success: function (data) {
//                    ////console.info(data);
                    listr = "";
                    for (var i = 0; i < data.length; i++) {
                        showcar(data[i].kabnum, data[i].isonline, data[i].lastlg, data[i].lastlt);
                    }
                    $(listr).appendTo("#ulList");

                }
            });
        });

        //定位
        $("#ulList").on("click", 'li', function () {
            var key = $(this).children("em").html();

            $.ajax({
                url: '${path}/base/driver/findDriverListBykey.do',
                data: {
                    kabnum: key
                },
                dataType: 'json',
                type: "post",
                async: false,
                success: function (data) {
                    if (data != null) {
                        Zoom(data[0].lastlg, data[0].lastlt, 17, 1, GuidanceFilePath);
                    }
                }
            });
        });


        //司机树
        $('#classlist').tree({
            url: path + '/driver/findDrivertree?clientid=' + globab_clientId,
            animate: false,
//            checkbox:true,
            id: 'id',
            text: 'text',
            children: 'children',
            parent: 'pid',
            height: $("#paneleast").height(),
            loadFilter: function (data) {
                ////console.info(data);
                if (data.listTree) {
                    return data.listTree;
                } else {
                    return data;
                }
            },
            formatter: function (node) {
                var s = node.text;
                if (s == null || s == "") {
                    s = "(缺省值)";
                }
                if (node.children) {
                    if (node.children != 0) {
                        s += ' <span style=\"padding: 1px 4px 1px 4px\" class=\"treebgnum\">(' + node.children.length + ')</span>';
                    }
                }

                return s;
            },
            onSelect: function (node) {
                $(this).tree('expand', node.target);

            },
            onDblClick: function (node) {
                $(this).tree('collapse', node.target);

            },

            onClick: function (node) {

//                initFlash();

                console.info(node)
                var lv = $("#classlist").tree("getLevel", node.target);

                if (globab_clientId == 0) {
                    if (lv == 3) {
                        father = node;
                        $.ajax({
                            url: path + '/carinfo/findCarinfoByKabnum?kabnum=' + node.text,
                            dataType: "json",
                            type: "GET",
                            success: function (data) {

                                if (data != null) {
                                    console.info(data);
                                    playLiveVideo(data.kabnum, data.devIdno);
                                }

                            },
                            error: function (XMLHttpRequest, textStatus, errorThrown) {

                            }


                        });
                    }
                } else {
                    if (lv == 2) {
                        father = node;
                        $.ajax({
                            url: path + '/carinfo/findCarinfoByKabnum?kabnum=' + node.text,
                            dataType: "json",
                            type: "GET",
                            success: function (data) {
                                if (data != null) {
                                    console.info(data);
                                    playLiveVideo(data.kabnum, data.devIdno);
                                }
                            },
                            error: function (XMLHttpRequest, textStatus, errorThrown) {

                            }

                        });
                    }
                }

            },
            onBeforeLoad: function (param) {
//                $.messager.progress({
//                    text: '正在加载数据...'
//                });
            },
            onLoadSuccess: function (node, data) {
//                $('#classlist').tree("collapseAll");
//                $.messager.progress('close');

            }
        });


        $("#moveview").click(function () {
            MoveDefaultView();
        });

        $("#rangingtool").click(function () {
            rangingOpen();
        })


    });

    //刷新树
    function treereload() {
        $("#classlist").tree('reload');
    }

    function serachTreeClick() {
        var mess = $("#searchTree").val();

        $("#classlist").tree("search", mess);
    }

    function ResetTreeClick() {
        $("#searchTree").val("");
        $("#classlist").tree("search", "");
    }


    //定时器方法
    function funSetInterval(time, refreshnum) {
//        //console.info(time);
        if (validCode) {
            validCode = false;

            var t = setInterval(function () {
                time--;

                //放入需要刷新的方法
                if (time % refreshnum == 0) {
                    //console.info(refreshnum);

                    if (overalllasttime != null) {
                        //console.info(refreshnum);
                        MonitortStute();
//                        console.info(0)
                        if (time % (refreshnum * 21) == 0) {
//                            console.info(1)
                            if (sessionStorage.clientId > 0) {
                                treereload();
                            }
                        }

                    }


                }
                if (time == 0) {
                    clearInterval(t);
                    validCode = true;
                }
            }, 1000)
        }
    }

    //根据状态查车辆
    function carstatus(data) {
        $.ajax({
            url: path + '/driver/findDriverByStatus?isonline=' + data + "&clientid=" + globab_clientId + "&token=" + token,
            dataType: 'json',
            type: "GET",
            async: false,
            success: function (data) {
                TempCar = new Array();
                for (var i = 0; i < data.length; i++) {
                    ShowOrHidePoint(data[i].msid, 1);
                    TempCar.push(data[i].msid);
                }

            }
        });
    }


    //移动到默认视野
    function MoveDefaultView() {

        var dataUrl = "SSid=" + 1001 + "&userid=" + sessionStorage.accountID;
        $.ajax({
            url: path + '/driver/finddefPosbyUseid?' + dataUrl,
            dataType: 'json',
            type: 'GET',
            async: false,
            success: function (data) {
                ////console.info(data);
                var point = "";
                var defzoon = "";
                if (data != null) {
                    ////console.info(1);
//                    var data = data.rows;
                    if (data.deflg != null || data.deflg != "" || data.deflg != undefined) {
                        point = new BMap.Point(data.deflg, data.deflt); // 创建点坐标
                    }

                    if (data.layer != null || data.layer != undefined) {
                        defzoon = data.layer;
                    } else {
                        defzoon = 8;
                    }

                } else {
                    point = new BMap.Point(113.281608, 23.094162); // 创建点坐标
                    defzoon = 8;
                }
                map.centerAndZoom(point, defzoon);
            }
        });
    }


    /**
     * 判断json是否为空
     * @param obj
     * @returns {boolean}
     */
    function isEmptyObj(obj) {
        return Object.keys(obj).length ? false : true;
    }

    //电召单实时状态和出租车状态
    function MonitortStute() {

        $.ajax({
            url: path + '/callbuss/findMonitorByClientid?clientid=' + globab_clientId,
            dataType: 'json',
            type: "GET",
            async: true,
            success: function (data) {
                //console.info(data);
                var online;
                if (data != null) {
                    $("#allbill").html(data[0].allbill);
                    if (data[0].online > 0) {
                        online = data[0].online + "(" + parseInt(data[0].online * 100 / data[0].callnum) + ".00%)"
                    } else {
                        online = data[0].online + "(0.00%)"
                    }

                    $("#online").html(online);

                    $("#empty").html(data[0].empty);
                    $("#passenger").html(data[0].passenger);
                    $("#callnum").html(data[0].callnum);
                    $("#malfunction").html(data[0].malfunction);

                }
            }
        });

    }

    /*
    ** 获取选中项的信息，并显示在输入框
    */
    function loadClientSettinginfo(clientid) {
        $.ajax({
            url: path + '/clientSetting/findClientSettingByid?id=' + clientid,
            dataType: "json",
            type: "POST",
            success: function (data) {
                if (data != null && data != "") {

                    if (data.serverIp != "") {
                        serverIp = data.serverIp;
                    } else {
                        serverIp = "127.0.0.1"
                    }
                    if (data.serverPort != "") {
                        serverPort = data.serverPort;
                    } else {
                        serverPort = "6605"
                    }


                }

                //登录注册
                userLogin(sessionStorage.accountName, sessionStorage.passwd);

                //初始化视频插件
                initPlayerExample();

            }
        });
    }


</script>

<script>
    //设置服务器信息
    var videoaddress = "120.26.98.110";   //服务器
    var serverIp = "127.0.0.1";    //服务器
    var serverPort = 6605;             //服务器端口
    var liveChannel = 0;               // 通道
    var liveJsession = "";
    var monitorJsession = "";
    var talkbackJsession = "";
    var isInitFinished = false;//视频插件是否加载完成
    var lang = new langZhCn();

    function langZhCn() {
        this.videoExample = "视频用例";
        this.geSessionId = "获取会话号";
        this.userId = "用户名：";
        this.password = "密码：";
        this.login = "登陆";
        this.videoInit = "初始化";
        this.videoLang = "插件语言：";
        this.videoWidth = "插件宽度：";
        this.videoHeight = "插件高度：";
        this.serverIp = "服务器IP：";
        this.serverPort = "端口：";
        this.windowNumber = "窗口数目：";
        this.settings = "设置";
        this.videoLive = "实时视频";
        this.windowIndex = "窗口下标：";
        this.title = "标题：";
        this.jsession = "会话号：";
        this.stream = "码流：";
        this.devIdno = "设备号：";
        this.channel = "通道：";
        this.play = "播放";
        this.stop = "停止";
        this.reset = "重置";
        this.monitor = "监听";
        this.talkback = "对讲";
        this.url = "url链接：";
        this.playback = "远程回放";
        this.nullMic = "您的电脑上没有麦克风，无法启动对讲";
        this.micStop = "没有开启FLASH插件麦克风";
        this.loginError = "登陆失败";
        this.talkback_flashMicStep1 = "第一步，请在视频窗上右键菜单中选择设置";
        this.talkback_flashMicStep2 = "第二步在设置窗口中 选择 “允许”，并勾选“记住”";
        this.talkback_flashMicStep3 = "关闭设置，并重新启动对讲";
        this.bufferTimeDesc = "说明：主要用于调整视频延时，当缓存的数据达到了最小缓冲时长时（默认为2秒），则会进行播放，当到了最大缓冲时长（默认为6秒），则进行快放。";
        this.minBufferTime = "最小缓冲时长：";
        this.maxBufferTime = "最大缓冲时长：";
        this.vedioStatus = "选中窗口播放状态";
        this.vedioEventStart = '选中事件：选中第';
        this.vedioEventEnd = '个窗口';
        this.vedioPlay = "当前选中窗口正在进行视频播放";
        this.vedioNoPlay = "当前选中窗口未进行视频播放";


    }


    $(document).ready(function () {
        console.info("----登录注册-------初始化视频插件--------")

        //获取视频服务器id
        loadClientSettinginfo(sessionStorage.clientId);


    });

    /**
     * 初始化视频插件
     **/
    function initPlayerExample() {
        for (var i = 0; i < 101; i++) {
            playingStatusArray.push(false);
        }
        //视频参数
        var params = {
            allowFullscreen: "true",
            allowScriptAccess: "always",
            bgcolor: "#FFFFFF",
            wmode: "transparent"
        };
        //赋值初始化为未完成
        isInitFinished = false;


        var screenHeight = window.innerHeight;
        var screenWidth = window.innerWidth;

        //视频插件宽度
        var width = screenWidth - $(".menutree").width();

        //视频插件高度
        var hieght = screenHeight - $(".toptip").height() - $(".bottomtip").height();


        //初始化flash
        swfobject.embedSWF("player.swf", "cmsv6flash", width, hieght, "11.0.0", null, null, params, null);
        initFlash();
    }

    /**
     * 插件初始化完成后执行
     **/
    function initFlash() {
        if (swfobject.getObjectById("cmsv6flash") == null ||
            typeof swfobject.getObjectById("cmsv6flash").setWindowNum == "undefined") {
            setTimeout(initFlash, 50);
        } else {
            //初始化插件语言
            var language = "cn.xml";

            swfobject.getObjectById("cmsv6flash").setLanguage(language);
            //先将全部窗口创建好
            swfobject.getObjectById("cmsv6flash").setWindowNum(36);
            //再配置当前的窗口数目
            var windowNum = 4;

            swfobject.getObjectById("cmsv6flash").setWindowNum(windowNum);

            //设置服务器信息
            swfobject.getObjectById("cmsv6flash").setServerInfo(serverIp, serverPort);
            isInitFinished = true;
        }
    }

    /**
     * 设置服务器信息
     *
     * **/
    function setServerInfo(serverIp, serverPort) {
        swfobject.getObjectById("cmsv6flash").setServerInfo(serverIp, serverPort);
    }

    /**
     * 设置视频插件窗口数量
     **/
    function setVideoWindowNumber() {
        if (!isInitFinished) {
            return;
        } else {
            //窗口数目
            var windowNum = $.trim($('.windowNumber').val());
            if (windowNum == '') {
                $('.windowNumber').focus();
                return;
            }
            swfobject.getObjectById("cmsv6flash").setWindowNum(windowNum);
        }
    }

    /**
     * 设置视频插件服务器信息
     **/
    function setVideoServer() {
        if (!isInitFinished) {
            return;
        } else {
            //服务器信息
            var serverIp = $.trim($('#serverIp').val());
            if (!serverIp) {
                $('#serverIp').focus();
                return;
            }
            var serverPort = $.trim($('#serverPort').val());
            if (!serverPort) {
                $('#serverPort').focus();
                return;
            }
            swfobject.getObjectById("cmsv6flash").setServerInfo(serverIp, serverPort);
        }
    }

    /**
     * 设置视频插件语言
     **/
    function setVideoLanguage() {
        if (!isInitFinished) {
            return;
        } else {
            //语言文件
            var language = $.trim($('.languagePath').val());
            if (!language) {
                $('.languagePath').focus();
                return;
            }
            swfobject.getObjectById("cmsv6flash").setLanguage("file/" + language);
        }
    }

    /**
     * 设置窗口标题
     **/
    function setWindowTitle() {
        if (!isInitFinished) {
            return;
        } else {
            //窗口下标
            var index = 0;
            //标题
            var title = $.trim($('.liveWindowTitle').val());
            swfobject.getObjectById("cmsv6flash").setVideoInfo(index, title);
        }
    }

    //播放实时视频
    function playLiveVideo(carname, devIdno) {
        if (!isInitFinished) {
            return;
        }
        //窗口下标
        var index = 0;
        //jsession会话号
        var jsession = liveJsession;
        if (jsession == '') {
            alert("jsession会话号错误")
            return;
        }

        //设备号
        var devIdno = devIdno;

        //通道号
        var channel = liveChannel;

        //码流
        var stream = 1;

        //最小缓冲时长
        var minBufferTime = 2;
        if (minBufferTime != '') {
            swfobject.getObjectById("cmsv6flash").setBufferTime(index, minBufferTime);
        }
        //最大缓冲时长
        var maxBufferTime = 6;
        if (maxBufferTime != '') {
            swfobject.getObjectById("cmsv6flash").setBufferTimeMax(index, maxBufferTime);
        }

        //先停止视频窗口
        swfobject.getObjectById("cmsv6flash").stopVideo(index);

        //设置窗口标题
        var title = carname;

        swfobject.getObjectById("cmsv6flash").setVideoInfo(index, title);
        //播放视频
        swfobject.getObjectById("cmsv6flash").startVideo(index, jsession, devIdno, channel, stream, true);
    }

    /**
     * 停止视频窗口播放视频窗口
     **/
    function stopLiveVideo() {
        if (!isInitFinished) {
            return;
        } else {
            //窗口下标
            var index = $.trim($('.liveVideoIndex').val());
            if (index == '') {
                $('.liveVideoIndex').focus();
                return;
            }
            swfobject.getObjectById("cmsv6flash").stopVideo(index);
        }
    }

    /**
     * 重置实时视频窗口
     **/
    function reSetLiveVideo() {
        if (!isInitFinished) {
            return;
        } else {
            //窗口下标
            var index = $.trim($('.liveVideoIndex').val());
            if (index == '') {
                $('.liveVideoIndex').focus();
                return;
            }
            swfobject.getObjectById("cmsv6flash").reSetVideo(index);
        }
    }

    /**
     * 开始监听
     **/
    function startMonitor() {
        if (!isInitFinished) {
            return;
        } else {
            //会话号
            var jsession = $.trim($('.monitorJsession').val());
            if (jsession == '') {
                $('.monitorJsession').focus();
                return;
            }
            //设备号
            var devIdno = $.trim($('.monitorDevIdno').val());
            if (devIdno == '') {
                $('.monitorDevIdno').focus();
                return;
            }
            //通道号
            var channel = $.trim($('.monitorChannel').val());
            if (channel == '') {
                $('.monitorChannel').focus();
                return;
            }
            //服务器ip
            var ip = $.trim($('.monitorServerIp').val());
            if (ip == '') {
                $('.liveStream').focus();
                return;
            }
            //服务器端口
            var port = $.trim($('.monitorServerPort').val());
            if (port == '') {
                $('.monitorServerPort').focus();
                return;
            }

            swfobject.getObjectById("cmsv6flash").setListenParam(1);
            swfobject.getObjectById("cmsv6flash").startListen(jsession, devIdno, channel, ip, port);
        }
    }

    /**
     * 停止监听
     **/
    function stopMonitor() {
        if (!isInitFinished) {
            return;
        } else {
            swfobject.getObjectById("cmsv6flash").stopListen();
        }
    }

    /**
     * 开始对讲
     **/
    function startTalkback() {
        if (!isInitFinished) {
            return;
        } else {
            //会话号
            var jsession = $.trim($('.talkbackJsession').val());
            if (jsession == '') {
                $('.talkbackJsession').focus();
                return;
            }
            //设备号
            var devIdno = $.trim($('.talkbackDevIdno').val());
            if (devIdno == '') {
                $('.talkbackDevIdno').focus();
                return;
            }
            //服务器ip
            var ip = $.trim($('.talkbackServerIp').val());
            if (ip == '') {
                $('.talkbackStream').focus();
                return;
            }
            //服务器端口
            var port = $.trim($('.talkbackServerPort').val());
            if (port == '') {
                $('.talkbackServerPort').focus();
                return;
            }

            swfobject.getObjectById("cmsv6flash").setTalkParam(1);
            var ret = swfobject.getObjectById("cmsv6flash").startTalkback(jsession, devIdno, 0, ip, port);
            //返回 0成功，1表示正在对讲，2表示没有mic，3表示禁用了mic
            if (ret == 0) {
            } else if (ret == 1) {
            } else if (ret == 2) {
                alert(lang.nullMic);
            } else if (ret == 3) {
                //alert(lang.micStop);
                $.dialog({
                    id: 'talkbacktip',
                    title: lang.talkback_openMic,
                    content: 'url:talkbacktipSP.html',
                    min: false,
                    max: false,
                    lock: true
                    ,
                    autoSize: true
                });
            } else {
            }
        }
    }

    /**
     * 停止对讲
     **/
    function stopTalkback() {
        if (!isInitFinished) {
            return;
        } else {
            swfobject.getObjectById("cmsv6flash").stopTalkback();
        }
    }

    /**
     * 开始远程回放
     **/
    function startPlayback() {
        if (!isInitFinished) {
            return;
        } else {
            //窗口下标
            var index = $.trim($('.playbackVideoIndex').val());
            if (index == '') {
                $('.playbackVideoIndex').focus();
                return;
            }
            //回放url
            var url = $.trim($('.playbackUrl').val());
            if (url == '') {
                $('.playbackUrl').focus();
                return;
            }
            //回放之前先停止
            swfobject.getObjectById('cmsv6flash').stopVideo(index);
            //开始回放
            swfobject.getObjectById("cmsv6flash").startVod(index, url);
        }
    }

    /**
     * 停止远程回放
     **/
    function stopPlayback() {
        if (!isInitFinished) {
            return;
        } else {
            //窗口下标
            var index = $.trim($('.playbackVideoIndex').val());
            if (index == '') {
                $('.playbackVideoIndex').focus();
                return;
            }
            swfobject.getObjectById("cmsv6flash").stopVideo(index);
        }
    }

    /**
     * 用户登录
     **/
    function userLogin(account, password) {

        console.info("用户登录-------->" + serverIp)
        console.info("account-------->" + account)
        console.info("password-------->" + password)

        //用户名
        if (account == '') {
            alert("用户为空")
            return;
        }
        //密码
        if (password == '') {
            alert("密码为空")
            return;
        }
        var param = [];
        param.push({name: 'account', value: account});
        param.push({name: 'password', value: password});

        $.ajax({
            type: 'POST',
            url: 'http://' + serverIp + '/StandardApiAction_login.action',
            data: param,
            cache: false, /*禁用浏览器缓存*/
            dataType: 'json',
            success: function (data) {
                if (data.result == 0) {
                    liveJsession = data.jsession
                    monitorJsession = data.jsession
                    talkbackJsession = data.jsession

                } else {
                    alert(lang.loginError);
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                try {
                    if (p.onError) p.onError(XMLHttpRequest, textStatus, errorThrown);
                } catch (e) {
                }
                alert("视频监控" + lang.loginError);
            }
        });
    }

    /**
     * 设置缓冲时长
     **/
    function setBufferInfo() {
        if (!isInitFinished) {
            return;
        } else {
            //窗口下标
            var index = $.trim($('.liveVideoIndex').val());
            if (index == '') {
                $('.liveVideoIndex').focus();
                return;
            }
            //最小缓冲时长
            var minBufferTime = $.trim($('.minBufferTime').val());
            //最大缓冲时长
            var maxBufferTime = $.trim($('.maxBufferTime').val());
            if (minBufferTime == '' && maxBufferTime == '') {
                return;
            }
            if (maxBufferTime != '') {
                swfobject.getObjectById("cmsv6flash").setBufferTimeMax(index, maxBufferTime);
            }
            if (minBufferTime != '') {
                swfobject.getObjectById("cmsv6flash").setBufferTime(index, minBufferTime);
            }
        }
    }


    function onTtxVideoMsg(index, type) {
        if (index != null && index != "") {
            index = parseInt(index, 10);
        }
        //窗口事件
        //window message
        if (type == "select") {
            //选中窗口     		select window
            selectIndex = index;
            $('#eventTip').text(lang.vedioEventStart + (index + 1) + lang.vedioEventEnd);
        } else if (type == "full") {
            //全屏			Full screen
        } else if (type == "norm") {
            //退出全屏			Exit full screen
        }
        //视频播放事件
        //video play messsage
        else if (type == "stop") {
            //停止播放			stop playing
            playingStatusArray[index] = false;
        } else if (type == "start") {
            //开始播放			Start play
            playingStatusArray[index] = true;
        } else if (type == "sound") {
            //开启声音			Turn on the sound
        } else if (type == "silent") {
            //静音			Mute
        } else if (type == "play") {
            //暂停或停止后重新播放			Play again after pause or stop
        } else if (type == "PicSave") {
            //截图			screenshot
        }
        //对讲事件
        //Intercom messsage
        else if (type == "startRecive" || type == "uploadRecive" || type == "loadRecive") {
            //开启对讲			Open intercom
        } else if (type == "stopTalk") {
            //关闭对讲			Turn off intercom
        } else if (type == "playRecive") {
            //对讲中			Talkback
        } else if (type == "reciveStreamStop" || type == "reciveNetError" || type == "reciveStreamNotFound") {
            //对讲异常(网络异常等)			Talkback anomalies (network exceptions, etc.)

        } else if (type == "uploadNetClosed" || type == "uploadNetError") {
            //连接异常 			Connection exception
        } else if (type == "upload") {
            //对讲讲话			Talkback speech
        } else if (type == "uploadfull") {
            //对讲讲话结束		Talkback speech ends
        }
        //监听事件
        //Listen messsage
        else if (type == "startListen") {
            //开始监听      		Start listening
        } else if (type == "stopListen") {
            //主动停止监听 		Active stop monitoring

        } else if (type == "listenNetError") {
            //网络异常  			Network anomaly

        } else if (type == "playListen") {
            //监听中	  		In listening
        } else if (type == "loadListen" || type == "listenStreamNotFound" || type == "listenStreamStop") {
            //等待请求监听	   	Waiting request monitoring
        }
    }

    var selectIndex = 0;
    var playingStatusArray = [];

    //判断当前选择窗口是否播放状态
    function checkIsPlaying() {
        if (playingStatusArray[selectIndex]) {
            alert(lang.vedioPlay);
        } else {
            alert(lang.vedioNoPlay);
        }
    }

</script>

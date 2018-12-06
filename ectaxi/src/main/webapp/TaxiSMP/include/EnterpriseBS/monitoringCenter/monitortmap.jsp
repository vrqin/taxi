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
    <title>监控中心</title>

    <link href="../../../public/jquery-easyui-1.5/themes/metro/easyui.css" rel="stylesheet"/>
    <link href="../../../public/jquery-easyui-1.5/themes/icon.css" rel="stylesheet"/>

    <script src="../../../public/jquery-easyui-1.5/js/jquery.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.easyui.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/easyui-lang-zh_CN.js"></script>
    <%--地图控件--%>
    <script type="text/javascript"
            src="http://api.map.baidu.com/library/DistanceTool/1.2/src/DistanceTool_min.js"></script>
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
            <%--<li id="setview">设置默认视野</li>--%>
            <li id="moveview">移动到默认视野</li>
            <%--<li>清除车辆</li>--%>
            <li onclick="treereload()">刷新</li>
            <%--<li>地标</li>--%>
            <%--<li>线路</li>--%>
            <%--<li>区域</li>--%>
            <li id="rangingtool">测距</li>
            <%--<li>信息列表</li>--%>
            <%--<li>选择状态</li>--%>
            <%--<li id="fullscreen" onclick="launchFullscreen(document.documentElement)" title="点击全屏观看,按键盘ESC键退出全屏">全屏</li>--%>
        </ul>
    </div>
    <span id="maptip">正在加载，请稍候...</span>
    <div id="baidumaps"></div>

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
    var globab_clientId = sessionStorage.clientId;
    var screenHeight = window.innerHeight;
    $(document).ready(function () {
        screenHeight = window.innerHeight;
        $("#baidumaps").css({'height': screenHeight - $(".toptip").height() - $(".bottomtip").height()});
    });
    window.onresize = function () {
        screenHeight = window.innerHeight;
        $("#baidumaps").css({'height': screenHeight - $(".toptip").height() - $(".bottomtip").height()});
    };

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

        var datatime = 60 * 60 * 24 * 7;
        funSetInterval(datatime, 8);

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
            checkbox: true,
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
            onCheck: function (node, checked) {
//                ////console.info(node);
//                ////console.info(checked);
//                ////console.info(node.children.length);
                var lv = $("#classlist").tree("getLevel", node.target);
                if (globab_clientId == 0) {
                    if (lv == 1) {
                        var x;
                        var y;
                        if (node.children.length > 0) {
                            if (checked) {
                                for (x in node.children) {
//                           ////console.info(node.children[x].children);
                                    if (node.children[x].children.length) {
                                        for (y in node.children[x].children) {
                                            ShowOrHidePoint(node.children[x].children[y].msid, 1);
                                        }
                                    }

                                }
                            } else {
                                for (x in node.children) {
//                           ////console.info(node.children[x].children);
                                    if (node.children[x].children.length) {
                                        for (y in node.children[x].children) {
                                            ShowOrHidePoint(node.children[x].children[y].msid, 0);
                                        }
                                    }

                                }
                            }

                        }
                    }
                    else if (lv == 2) {
                        //当公司下面没有车辆不执行
                        if (node.children.length > 0) {
                            var x;
                            if (checked) {

                                for (x in node.children) {
                                    ShowOrHidePoint(node.children[x].msid, 1);
                                }
                            } else {
                                for (x in node.children) {
                                    ShowOrHidePoint(node.children[x].msid, 0);
                                }
                            }
                        }
                    }
                    else if (lv == 3) {
                        if (checked) {
                            ShowOrHidePoint(node.msid, 1);
                        } else {
                            ShowOrHidePoint(node.msid, 0);
                        }
                    }
                } else {

                    if (lv == 1) {
                        //当公司下面没有车辆不执行
                        if (node.children.length > 0) {
                            var x;
                            if (checked) {

                                for (x in node.children) {
                                    ShowOrHidePoint(node.children[x].msid, 1);
                                }
                            } else {
                                for (x in node.children) {
                                    ShowOrHidePoint(node.children[x].msid, 0);
                                }
                            }
                        }
                    }
                    else if (lv == 2) {
                        if (checked) {
                            ShowOrHidePoint(node.msid, 1);
                        } else {
                            ShowOrHidePoint(node.msid, 0);
                        }
                    }
                }

            },
            onClick: function (node) {
//                ////console.info(node);

                var lv = $("#classlist").tree("getLevel", node.target);

                if (globab_clientId == 0) {
                    if (lv == 3) {
//                    ////console.info(node);
                        father = node;
                        $.ajax({
                            url: path + '/driver/findListbyDriverName?kabnum=' + node.text,
                            dataType: "json",
                            type: "GET",
                            success: function (data) {
                                $.messager.progress('close');

                                if (data != null) {
//                                ////console.info("data.lastlg:"+data.lastlg+"data.lastlt:"+data.lastlt);
                                    Zoom(data.lastlg, data.lastlt, 17, 1, GuidanceFilePath);
                                }

                            },
                            error: function (XMLHttpRequest, textStatus, errorThrown) {

                            },
                            beforeSend: function (xhr) {
                                $.messager.progress({
                                    text: '正在加载数据...'
                                });
                            }

                        });
                    }
                } else {
                    if (lv == 2) {
//                    ////console.info(node);
                        father = node;
                        $.ajax({
                            url: path + '/driver/findListbyDriverName?kabnum=' + node.text,
                            dataType: "json",
                            type: "GET",
                            success: function (data) {
                                $.messager.progress('close');

                                if (data != null) {
//                                ////console.info("data.lastlg:"+data.lastlg+"data.lastlt:"+data.lastlt);
                                    Zoom(data.lastlg, data.lastlt, 17, 1, GuidanceFilePath);
                                }

                            },
                            error: function (XMLHttpRequest, textStatus, errorThrown) {

                            },
                            beforeSend: function (xhr) {
                                $.messager.progress({
                                    text: '正在加载数据...'
                                });
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

//            $("#classlist").tree('reload',1170);
        ////console.info("treereload");
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

    function loadJScript() {

        AllCarInfomation = new Array();
        AllUserPlace = new Array();
        TempCar = new Array();

        carFilePathOnline = picturepath + "/public/images/online.png";
        carFilePathOffline = picturepath + "/public/images/offline.png";
        GuidanceFilePath = picturepath + "/public/images/Guidance2.gif";

        var script = document.createElement("script");
        script.type = "text/javascript";
        script.src = "http://api.map.baidu.com/api?v=2.0&ak=78OhopFWz7wPFKlaFXA1DYPU&callback=init";
        document.body.appendChild(script);

    }

    function init() {
        // 初始化设置
        map = new BMap.Map("baidumaps");    // 创建Map实例
//        map.addControl(new BMap.MapTypeControl());   //添加地图类型控件
        map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放

        var point = new BMap.Point(116.404, 39.915); // 创建点坐标
        map.centerAndZoom(point, 15);
        map.enableScrollWheelZoom();
        myDis = new BMapLib.DistanceTool(map);
        addMapControl();

        MoveDefaultView();//默认位置
        DriverPosition();//司机位置
        carstatus(1);


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

        var script2 = document.createElement("script");
        script2.type = "text/javascript";
        script2.src = "http://developer.baidu.com/map/jsdemo/demo/convertor.js";
        document.body.appendChild(script2);

    }

    window.onload = loadJScript;  //异步加载地图

    //地图控件添加函数：
    function addMapControl() {
        //向地图中添加缩放控件
        var ctrl_nav = new BMap.NavigationControl({anchor: BMAP_ANCHOR_TOP_LEFT, type: BMAP_NAVIGATION_CONTROL_LARGE});
        map.addControl(ctrl_nav);
        //向地图中添加缩略图控件
        var ctrl_ove = new BMap.OverviewMapControl({anchor: BMAP_ANCHOR_BOTTOM_RIGHT, isOpen: 1});
        map.addControl(ctrl_ove);
        //向地图中添加比例尺控件
        var ctrl_sca = new BMap.ScaleControl({anchor: BMAP_ANCHOR_BOTTOM_LEFT});
        map.addControl(ctrl_sca);
    }

    // 编写自定义函数,创建标注
    function addMarker(lon, lat) {
        var point = new BMap.Point(lon, lat);
        var carFilePath = "/public/images/online.png";
        var myIcon = new BMap.Icon(carFilePath, new BMap.Size(64, 64));
        var marker = new BMap.Marker(point, {icon: myIcon});
        map.addOverlay(marker);

    }

    //位置移动
    function UpdateDriverMarker(dLg, dLt) {
        if (drivermarker != "") {
            drivermarker.setPosition(new BMap.Point(dLg, dLt));
        }
    }

    function MoveToPoint(dLg, dLt) {
        var point = new BMap.Point(dLg, dLt);
        map.panTo(point);

    }

    // 显示/隐藏一个点
    function ShowOrHidePoint(MSID, bIsShow) {

        if (AllCarInfomation[MSID] == null) {
            return;
        }

        if (bIsShow == 1) {
            AllCarInfomation[MSID].show();
        }
        else {
            AllCarInfomation[MSID].hide();
        }
    }

    //开启测距
    function rangingOpen() {
        myDis.open();
    }

    //关闭测距
    function rangingClose() {
        myDis.close();
    }


    // 移动地图到坐标
    function Zoom(dLg, dLt, nZoom, isShowGuidancePosition, GuidanceFilePath) {
        if (dLg != 0 && dLt != 0) {
            map.setCenter(new BMap.Point(dLg, dLt));
            if (isShowGuidancePosition == 1) {
                ShowGuidancePosition(dLg, dLt, GuidanceFilePath);
            }
        }

        if (nZoom != 0) {
            map.setZoom(nZoom);
        }
    }

    // 显示引导位置
    var varGuidanceMarker = null;
    var varGuidanceTimer = null;

    function ShowGuidancePositionTimer() {
        if (varGuidanceMarker != null) {
            map.clearOverlays();
            varGuidanceMarker = null;
        }
        if (varGuidanceTimer != null) {
            clearTimeout(varGuidanceTimer);
            varGuidanceTimer = null;
        }
    }

    function ShowGuidancePosition(dLg, dLt, GuidanceFilePath) {
        if (varGuidanceMarker != null) {
            map.clearOverlays();
            varGuidanceMarker = null;
        }
        if (varGuidanceTimer != null) {
            clearTimeout(varGuidanceTimer);
            varGuidanceTimer = null;
        }
        var pt = new BMap.Point(dLg, dLt);
        var myIcon = new BMap.Icon(GuidanceFilePath, new BMap.Size(128, 128), {
            anchor: new BMap.Size(80, 80),
            imageOffset: new BMap.Size(0, 0)
        });
        varGuidanceMarker = new BMap.Marker(pt, {icon: myIcon});     // 创建标注
        varGuidanceMarker.setTop();
        map.addOverlay(varGuidanceMarker);                         // 将标注添加到地图中
        varGuidanceMarker.enableMassClear();

        varGuidanceTimer = window.setTimeout(ShowGuidancePositionTimer, 900 * 3);
    }


    //在地图上添加车
    function AddCar(MSID, strLabel, carstatus, Phone, Company, Drivername, gpstime, dLg, dLt) {
        var strFilePath = "";
        if (carstatus == 0) {
            strFilePath = carFilePathOffline;
        } else {
            strFilePath = carFilePathOnline;
        }

        var strTitle = "[车牌号码:" + strLabel + "][电话号码:" + Phone + "]";
        var strInfoWindow = "<div class='baidustrInfoWindow'>车牌号码: " + strLabel + "<br/>司机名称: " + Drivername + "<br/>电话号码: " + Phone + "<br/>所属公司: " + Company + "<br/>最后定位: " + gpstime + "</div>";

        if (AllCarInfomation[MSID] == null) {
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
            marker.disableMassClear();
            marker.setTop(true);
            var infoWindow = new BMap.InfoWindow(strInfoWindow);
            marker.addEventListener("click", function () {
                this.openInfoWindow(infoWindow);
            });

            marker.hide();

            AllCarInfomation[MSID] = marker;
        }
    }

    // 更新车辆位置
    function UpdateCarPos(MSID, strLabel, carstatus, Phone, Company, Drivername, gpstime, dLg, dLt) {
        var strFilePath = "";
        if (carstatus == 0) {
            strFilePath = carFilePathOffline;
        } else {
            strFilePath = carFilePathOnline;
        }

        var strTitle = "[车牌号码:" + strLabel + "][电话号码:" + Phone + "]";
        var strInfoWindow = "<div class='baidustrInfoWindow'>车牌号码: " + strLabel + "<br/>司机名称: " + Drivername + "<br/>电话号码: " + Phone + "<br/>所属公司: " + Company + "<br/>最后定位: " + gpstime + "</div>";

        if (AllCarInfomation[MSID] != null) {
            if (AllCarInfomation[MSID].getIcon().imageUrl != strFilePath) {
                var myIcon = new BMap.Icon(strFilePath, new BMap.Size(64, 64),
                    {
                        offset: new BMap.Size(0, 0),
                        imageOffset: new BMap.Size(0, 0)
                    });
                AllCarInfomation[MSID].setIcon(myIcon);
            }
            if (AllCarInfomation[MSID].getTitle() != "[电话号码:" + Phone + "][车牌号码:" + strLabel + "]") {
                AllCarInfomation[MSID].getLabel().setContent(strLabel);
                AllCarInfomation[MSID].setTitle("[电话号码:" + Phone + "][车牌号码:" + strLabel + "]");
            }
            AllCarInfomation[MSID].setPosition(new BMap.Point(dLg, dLt));

            var infoWindow = new BMap.InfoWindow(strInfoWindow);
            AllCarInfomation[MSID].removeEventListener("click", function () {
                this.openInfoWindow(infoWindow);
            });
            AllCarInfomation[MSID].addEventListener("click", function () {
                this.openInfoWindow(infoWindow);
            });
        }
    }


    //司机当前位置
    function DriverPosition() {
        $("#contnetul li").remove();

        $.ajax({
            url: path + '/driver/loadDriverPosition',
            dataType: 'json',
            type: "GET",
            async: false,
            success: function (data) {
//                //console.info(data);
                onlinenum = 0;
                offlinenum = 0;
                if (data != null) {
                    if (data[0].gpstime != null) {
                        overalllasttime = data[0].gpstime;
                    }

                }

                for (var i = 0; i < data.length; i++) {
                    if (data[i].gpstime == undefined) {
                        data[i].gpstime = "";
                    }
                    if (data[i].company == undefined) {
                        data[i].company = "";
                    }
                    if (data[i].isonline == 1) {
                        onlinenum++;
                    } else {
                        offlinenum++;
                    }
                    AddCar(data[i].msid, data[i].kabnum, data[i].isonline, data[i].phone, data[i].company, data[i].name, formattime(data[i].gpstime), data[i].lastlg, data[i].lastlt);

                }
                listr = "";
                $("#inlineNum span").html(onlinenum);
                $("#offlineNum span").html(offlinenum);
//                $(".maptip").hide();
            },
            complete: function (data) {
                $(".maptip").hide();
            }
        });

    }

    //司机当前位置
    function UpdataDriverPosition(lasttime) {

        $.ajax({
            url: path + '/driver/updataDriverPosition?lasttime=' + lasttime,
            dataType: 'json',
            type: "GET",
            async: false,
            success: function (data) {
                //console.info(data);
                onlinenum = 0;
                offlinenum = 0;

                if (data != null) {
                    if (data[0].gpstime != null) {
                        overalllasttime = data[0].gpstime;
                    }

                }
                for (var i = 0; i < data.length; i++) {

                    if (data[i].gpstime == undefined) {
                        data[i].gpstime = "";
                    }
                    if (data[i].company == undefined) {
                        data[i].company = "";
                    }

                    UpdateCarPos(data[i].msid, data[i].kabnum, data[i].isonline, data[i].phone, data[i].company, data[i].name, formattime(data[i].gpstime), data[i].lastlg, data[i].lastlt);

                    if ($(".carstatu").val() == 1) {
                        //在地图实时更新车辆状态
                        ShowOrHidePoint(data[i].msid, data[i].isonline);
                    }

                    if (data[i].isonline == 1) {
                        onlinenum++;
                    } else {
                        offlinenum++;
                    }

                }

                $("#onlinenum").html(onlinenum);
                $("#offlinenum").html(offlinenum);
            }
        });

    }

    function showcar(kabnum, stutus, lg, lt) {

        if (stutus == 0) {
            stutus = "offlineMark";
        } else {
            stutus = "inlineMark";
        }

        listr += '<li title="点击查看车辆位置" >';
        listr += '<span  class="' + stutus + '"></span><em>' + kabnum + '</em>';
        listr += '</li>';


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
                        UpdataDriverPosition(overalllasttime);
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
//                    ////console.info(data);

            }
        });
    }

    // 鼠标移动事件 START
    function OnMapMouseMove(e) {
        global_lg = e.point.lng;
        global_lt = e.point.lat;
        global_layer = map.getZoom();
//            ////console.info("[POCTALK]|OnMapMouseMove|"+e.point.lng+","+e.point.lat+",|");
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


</script>
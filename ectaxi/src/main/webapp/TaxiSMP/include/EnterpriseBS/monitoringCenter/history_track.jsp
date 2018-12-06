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
    <title>历史轨迹</title>

    <link href="../../../public/jquery-easyui-1.5/themes/metro/easyui.css" rel="stylesheet"/>
    <link href="../../../public/jquery-easyui-1.5/themes/icon.css" rel="stylesheet"/>

    <script src="../../../public/jquery-easyui-1.5/js/jquery.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.easyui.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript"
            src="http://api.map.baidu.com/library/DistanceTool/1.2/src/DistanceTool_min.js"></script>
    <!-- 数据接口路径、共用JS -->
    <script src="../../../public/js/path.js"></script>

    <style type="text/css">
        html, body {
            width: 100%;
            height: 100%;
            margin: 0px;
            padding: 0px;

        }

        .baidumap {
            width: 100%;

        }

        .cararea {
            height: 220px;
            width: auto;
        }

        .toptip {

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

        .findcar {
            background-color: #F5F5F5;
            width: 260px;
            height: 350px;
            box-shadow: 0 2px 2px rgba(0, 0, 0, 0.3);
            position: absolute;
            top: 50px;
            right: 50px;
            z-index: 99;
            font-size: 14px;
            text-align: center;
            padding-top: 14px;
            box-sizing: border-box;
        }

        .findcar ul {
            margin: 0px;
            padding: 0px;
        }

        .findcar ul li {
            list-style: none;
            margin: 20px 0;
        }

        input[type=text] {
            width: 140px;
            text-indent: 5px;
        }
    </style>


</head>
<body class="easyui-layout" data-options="border:false ,fit:true">

<div class="baidumap">
    <div id="baidumaps"></div>
    <div class="findcar">
        <ul>
            <li>开始时间 <input id="startime" class="easyui-datetimebox" style="width:160px;"></li>
            <li>结束时间 <input id="endtime" class="easyui-datetimebox" style="width:160px;"></li>
            <li>车牌号码 <input id="kabnum" class="easyui-textbox" style="width:160px;"></li>
            <li>司机姓名 <input id="name" class="easyui-textbox" style="width:160px;"></li>
            <li>司机电话 <input id="phone" class="easyui-textbox" style="width:160px;"></li>
            <li>
                <button id="fuzzy" type="button" class="easyui-linkbutton" style="width:90px">1、搜索</button>
                <button id="search" type="button" class="easyui-linkbutton" style="width:90px">2、查询轨迹</button>
            </li>
            <li>

                <button id="play" type="button" class="easyui-linkbutton" style="width:80px">3、播放</button>
                <button id="reset" type="button" class="easyui-linkbutton" style="width:80px">4、清空</button>
                <button type="button" class="easyui-linkbutton" onclick="pause()" style="width:80px">5、停止</button>

            </li>
        </ul>
    </div>
</div>

<div class="cararea">
    <div class="easyui-tabs" id="griltabs" style="width:100%;height:100%">
        <div title="搜索结果" style="padding:5px">
            <table id="searchGril" data-options="fit:true"></table>
        </div>
        <div title="定位列表" style="padding:5px">
            <table id="positionGril" data-options="fit:true"></table>
        </div>
        <%--<div title="异常列表">--%>
        <%--<table id="abnormalGril" data-options="fit:true"></table>--%>
        <%--</div>--%>
        <%--<div title="停车列表">--%>
        <%--<table id="parkingGril" data-options="fit:true"></table>--%>
        <%--</div>--%>
    </div>
</div>
</body>
</html>
<script>
    var screenHeight = window.innerHeight;
    $(document).ready(function () {
        screenHeight = window.innerHeight;
        $("#baidumaps").css({'height': screenHeight - $(".cararea").height()});
    });
    window.onresize = function () {
        screenHeight = window.innerHeight;
        $("#baidumaps").css({'height': screenHeight - $(".cararea").height()});
    };

    var globab_clientId = sessionStorage.clientId;
    var grid;
    var data = [];
    $(function () {

        $("#fuzzy").click(function () {
            var startime = $('#startime').datetimebox("getValue");
            if (startime == "" || startime == null) {
                alert("请输入开始时间！");
                return;
            }
            var endtime = $('#endtime').datetimebox("getValue");
            var kabnum = $('#kabnum').textbox("getValue");
            var name = $('#name').textbox("getValue");
            var phone = $('#phone').textbox("getValue");

            searchGril(startime, endtime, kabnum, name, phone);
        });

        $("#search").click(function () {
            var startime = $('#startime').datetimebox("getValue");
            if (startime == "" || startime == null) {
                alert("请输入开始时间！");
                return;
            }
            var endtime = $('#endtime').datetimebox("getValue");
            var kabnum = $('#kabnum').textbox("getValue");
            var name = $('#name').textbox("getValue");
            var phone = $('#phone').textbox("getValue");
            query(startime, endtime, kabnum, name, phone);
        });

        $("#play").click(function () {
            play();
        });

        $("#reset").click(function () {
            $('#startime').datetimebox("setValue", "");
            $('#endtime').datetimebox("setValue", "");
            $('#kabnum').textbox("setValue", "");
            $('#name').textbox("setValue", "");
            $('#phone').textbox("setValue", "");

        });


    });


    var operation = false;
    var DefaultCenter;      // 默认视图经纬度
    var DefaultZoom;        // 默认视图层次

    var map;
    var myDis;
    // 所有点的坐标
    var points = new Array();
    var oldpoints = new Array();

    var carFilePathOnline = picturepath + "/public/images/online.png";
    var PersonPath = picturepath + "/public/images/person.png";
    var carFilePathcarrypasseng = picturepath + "/public/images/carrypasseng.png";
    var orderreceiving = picturepath + "/public/images/orderreceiving.png";
    var orderreceivCar = "";
    var stepW = 24;
    var drivermoile;
    var Abillid;
    var startTime;
    var endTime;


    function initialize() {
        map = new BMap.Map("baidumaps", {enableMapClick: false});                        // 创建Map实例
        map.centerAndZoom(new BMap.Point(113.263236, 23.140967), 14);                  // 初始化地图,设置中心点坐标和地图级别。
//        map.addControl(new BMap.MapTypeControl({anchor: BMAP_ANCHOR_TOP_RIGHT}));   // 右上角，默认地图控件
        map.highResolutionEnabled(false);                                           // 是否显示高分辨率地图
        map.enableScrollWheelZoom(true);
        myDis = new BMapLib.DistanceTool(map);


    }

    function loadScript() {
        var script = document.createElement("script");
        script.src = "http://api.map.baidu.com/api?v=2.0&ak=78OhopFWz7wPFKlaFXA1DYPU&callback=initialize";
        document.body.appendChild(script);
    }

    window.onload = loadScript;

    //////////////////////////////////////////////////////////////////////////
    // 放大或缩小地图
    function ZoomInOrOn(nType) {
        if (nType == 0) {
            map.zoomIn();
        }
        else {
            map.zoomOut();
        }
    }

    //////////////////////////////////////////////////////////////////////////
    // 移动到某个位置
    function MoveToPoint(dLg, dLt) {
        map.panTo(new BMap.Point(dLg, dLt));
    }

    var markerpoint;

    function addMarkerPoint(dLg, dLt) {
        map.removeOverlay(markerpoint);
        var point = new BMap.Point(dLg, dLt);
        map.centerAndZoom(point, 17);
        markerpoint = new BMap.Marker(point);  // 创建标注
        map.addOverlay(markerpoint);               // 将标注添加到地图中
        markerpoint.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画
    }

    // 车辆图标
    var marker = null;
    var timer; //定时器
    var flag = false;
    var childredFilePath = picturepath + "/public/images/child.png";
    //////////////////////////////////////////////////////////////////////////
    // 添加点
    function AddPoint(lg, lt) {
        points.push(new BMap.Point(lg, lt));
    }

    //////////////////////////////////////////////////////////////////////////
    // 生成轨迹
    function DrawTrack(carFilePath) {
        var polyline = new BMap.Polyline(points, {strokeColor: "blue", strokeWeight: 6, strokeOpacity: 0.5})
        polyline.setStrokeStyle("dashed"); //设置为虚线

        var myIcon = new BMap.Icon(carFilePath, new BMap.Size(32, 32),
            {
                offset: new BMap.Size(0, 0),
                imageOffset: new BMap.Size(0, 0)
            });
        marker = new BMap.Marker(points[0], {icon: myIcon});
        marker.setTop(true);
        map.addOverlay(marker);
        map.centerAndZoom(points[0], 14);
    }

    //////////////////////////////////////////////////////////////////////////
    // 控制车辆位置
    function ControlCarPosition(positionIndex, carFilePath, isPanToPosition) {
        if (positionIndex >= points.length || positionIndex < 0) {
            return;
        }

        if (positionIndex > 0) {
            map.addOverlay(new BMap.Polyline([points[positionIndex - 1], points[positionIndex]], {
                strokeColor: "red",
                strokeWeight: 1,
                strokeOpacity: 1
            }));
        }

        marker.setPosition(points[positionIndex]);
        if (marker.getIcon().imageUrl != carFilePath) {
            var myIcon = new BMap.Icon(carFilePath, new BMap.Size(32, 32),
                {
                    offset: new BMap.Size(0, 0),
                    imageOffset: new BMap.Size(0, 0)
                });
            marker.setIcon(myIcon);
        }

        if (isPanToPosition != 0) {
            map.panTo(points[positionIndex]);
        }
    }

    //////////////////////////////////////////////////////////////////////////
    // 编写自定义函数,创建标注
    function addMarker(point, txt) {
        var marker = new BMap.Marker(point);
        map.addOverlay(marker);
        var label = new BMap.Label(txt, {offset: new BMap.Size(20, -10)});
        marker.setLabel(label);
    }

    // 清空轨迹
    function ClearLayer() {
        pause();
        points.length = 0;
        marker = null;
        map.clearOverlays();
    }


    function pause() {
        if (timer) {
            window.clearTimeout(timer);
            operation = false;
        }
    }

    function passengerpos(slg, slt, elg, elt) {

        if (elg <= 1 || elt <= 1) {
            remove_overlay();
            AddPerson(PersonPath, slg, slt, "起点");
            map.centerAndZoom(new BMap.Point(slg, slt), 14);
        } else if (slg != null && slt != null && elg != null && elt != null) {
            remove_overlay();
            AddPerson(PersonPath, slg, slt, "起点");
            AddPerson(PersonPath, elg, elt, "终点");
            map.centerAndZoom(new BMap.Point(elg, elt), 14);
        }
    }

    //在地图上添加车
    function AddPerson(strFilePath, dLg, dLt, txt) {
        var myIcon = new BMap.Icon(strFilePath, new BMap.Size(64, 64),
            {
                offset: new BMap.Size(0, 0),
                imageOffset: new BMap.Size(0, 0)
            });
        var carmarker = new BMap.Marker(new BMap.Point(dLg, dLt), {icon: myIcon});  // 创建标注
        map.addOverlay(carmarker);                                                // 将标注添加到地图中
        var label = new BMap.Label(txt, {offset: new BMap.Size(0, 40)});    // 添加标签
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
        carmarker.setLabel(label);
//            carmarker.disableMassClear();
//            carmarker.setTop(true);

    }

    //在地图上添加车
    function AddCar(strFilePath, dLg, dLt, txt) {
        var myIcon = new BMap.Icon(strFilePath, new BMap.Size(64, 64),
            {
                offset: new BMap.Size(0, 0),
                imageOffset: new BMap.Size(0, 0)
            });
        var carmarker = new BMap.Marker(new BMap.Point(dLg, dLt), {icon: myIcon});  // 创建标注
        map.addOverlay(carmarker);                                                // 将标注添加到地图中
        var label = new BMap.Label(txt, {offset: new BMap.Size(-15, 40)});    // 添加标签
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
        carmarker.setLabel(label);
//            carmarker.disableMassClear();
//            carmarker.setTop(true);

    }

    //清除覆盖物
    function remove_overlay() {
        map.clearOverlays();
    }

    //开启测距
    function rangingOpen() {
        myDis.open();
    }

    //关闭测距
    function rangingClose() {
        myDis.close();
    }


    //查询
    function query(startime, endtime, kabnum, name, phone) {
        //清空上次运行的轨迹
        if (flag) {
//      ClearLayer();
        }

        $("#tips").show();

        oldpoints = new Array();
        points = new Array();

        var dataUrl = "begintime=" + startime +
            "&endtime=" + endtime +
            "&kabnum=" + kabnum +
            "&name=" + name +
            "&phone=" + phone;
        $.ajax({
            url: path + '/postrack/findPostrackListByKabnum?' + dataUrl,
            dataType: 'json',
            type: "GET",
            success: function (data) {
                ////console.info(data);
                //在列表上显示数据
                if (data.total == 0) {
                    $.messager.alert('警告', "在当前时间内没有运行轨迹！！！,可尝试点击'1、搜索'", 'info');
                } else {
                    positionGril(data);
                    oldpoints = data.rows;

//                    ////console.info("-----oldpoints-----");
//                    ////console.info(oldpoints);
                }

                $('#griltabs').tabs('select', 1);

                $("#tips").hide();
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                $.messager.alert('警告', "查询失败！当前终端没有轨迹数据！", 'info');

            }
        });

    }


    //播放
    function play() {
        if (oldpoints == 0 || oldpoints == null) {
            $.messager.alert('警告', "在当前时间内没有运行轨迹！！！", 'info');
            return;
        }

        //清空上次运行的轨迹
        if (flag == true) {
            pause();
//      ClearLayer();
        }
        remove_overlay();

        for (var i = 0; i < oldpoints.length; i++) {
            points.push(new BMap.Point((oldpoints[i].lg), (oldpoints[i].lt)));
        }

        //在地图上显示轨迹
        DrawTrack(childredFilePath);
        operation = true;
        var i = 0;
        var paths = points.length;    //获得有几个点
//    $("#tracknum").html(paths);
        //连续运行
        function resetMkPoint() {
            if (i < paths) {
                timer = setTimeout(function () {
                    i++;
                    ControlCarPosition(i, childredFilePath, i + 1);
                    resetMkPoint()
                }, 200);
            }
            else {
                $.messager.alert('警告', "轨迹回放完毕！！！", 'info');
            }
        }

        //在一秒后开始
        setTimeout(function () {
            resetMkPoint();
            flag = true;
        }, 500)


    }

    function searchGril(startime, endtime, kabnum, name, phone) {
        var dataUrl = "begintime=" + startime +
            "&endtime=" + endtime +
            "&kabnum=" + kabnum +
            "&name=" + name +
            "&phone=" + phone +
            "&clientid=" + globab_clientId;
        grid = $("#searchGril").datagrid({
            fit: true,
            url: path + "/postrack/findPostrackBeanForPageList?" + dataUrl,
            fitColumns: true,
            striped: true,
            columns: [
                [
                    {field: 'oper', title: '司机', width: fixWidth(0.1), align: 'center'},
                    {field: 'trackcount', title: '轨迹记录数', width: fixWidth(0.1), align: 'center', sortable: true},
                    {field: 'kabnum', title: '车牌号', width: fixWidth(0.1), align: 'center', sortable: true},
                    {field: 'name', title: '姓名', width: fixWidth(0.1), align: 'center'},
                    {field: 'phone', title: '电话', width: fixWidth(0.1), align: 'center', sortable: true},
                    {field: 'company', title: '所属公司', width: fixWidth(0.1), align: 'center', sortable: true}
                ]
            ],
            onLoadSuccess: function (data) {
                if (data.total == 0) {
                    alert("在你所查找的时间范围内没有轨迹信息");
                }
                $('#griltabs').tabs('select', 0);
//                ////console.info(data);
            },
            onClickRow: function (index, row) {
                ////console.info(row);
                $('#kabnum').textbox("setValue", row.kabnum);
                $('#name').textbox("setValue", row.name);
                $('#phone').textbox("setValue", row.phone);
            },
            idField: 'phone',
            sortName: 'phone',
            sortOrder: 'desc',
            singleSelect: true,
            pageSize: 20

        });
    }


    function positionGril(data) {
        grid = $("#positionGril").datagrid({
            fit: true,
            data: data,
            fitColumns: true,
            striped: true,
            columns: [
                [
                    {field: 'oper', title: '司机', width: 100, align: 'center'},
                    {field: 'kabnum', title: '车牌号', width: 100, align: 'center'},
                    {field: 'lg', title: '经度', width: 100, align: 'center', sortable: true},
                    {field: 'lt', title: '纬度', width: 100, align: 'center', sortable: true},
                    {
                        field: 'gpstime', title: 'GPS定位时间', width: 100, align: 'center'
                    },
                    {field: 'integral', title: '方向', width: 100, align: 'center', sortable: true},
                    {field: 'rating', title: '空重车', width: 100, align: 'center', sortable: true}
                ]
            ],
            onClickRow: function (index, row) {
//                ////console.info(row);
                addMarkerPoint(row.lg, row.lt);
            },
            idField: 'phone',
            sortName: 'phone',
            sortOrder: 'desc',
            singleSelect: true,
            pageSize: 20

        });
    }

    function abnormalGril(data) {
        grid = $("#abnormalGril").datagrid({
            fit: true,
            data: data,
            fitColumns: true,
            striped: true,
            columns: [
                [
                    {field: 'phone', title: '异常类型', width: fixWidth(0.1), align: 'center'},
                    {field: 'name', title: '开始时间', width: fixWidth(0.1), align: 'center', sortable: true},
                    {field: 'gender', title: '持续时间', width: fixWidth(0.1), align: 'center', sortable: true}
                ]
            ],
            onLoadSuccess: function (data) {

            },
            idField: 'phone',
            sortName: 'phone',
            sortOrder: 'desc',
            singleSelect: true,
            pageSize: 20
        });
    }

    function parkingGril(data) {
        grid = $("#parkingGril").datagrid({
            fit: true,
            data: data,
            fitColumns: true,
            striped: true,
            columns: [
                [
                    {field: 'phone', title: '开始时间', width: fixWidth(0.1), align: 'center'},
                    {field: 'name', title: '结束时间', width: fixWidth(0.1), align: 'center', sortable: true},
                    {field: 'gender', title: '持续时间', width: fixWidth(0.1), align: 'center', sortable: true}
                ]
            ],
            onLoadSuccess: function (data) {

            },
            idField: 'phone',
            sortName: 'phone',
            sortOrder: 'desc',
            singleSelect: true,
            pageSize: 20
        });
    }

    //datagril 列表宽度
    function fixWidth(percent) {
        return Math.floor(document.body.clientWidth * percent); //这里你可以自己做调整
    }


    function isEmptyObj(obj) {
        return Object.keys(obj).length ? false : true;
    }
</script>
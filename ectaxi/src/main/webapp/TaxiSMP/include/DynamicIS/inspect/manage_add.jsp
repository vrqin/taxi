<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>添加AuditTaskManagement</title>

    <!-- jquery easyui 插件 -->
    <link href="../../../public/jquery-easyui-1.5/themes/metro/easyui.css" rel="stylesheet"/>
    <link href="../../../public/jquery-easyui-1.5/themes/icon.css" rel="stylesheet"/>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.easyui.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/easyui-lang-zh_CN.js"></script>

    <%--地图控件--%>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=78OhopFWz7wPFKlaFXA1DYPU"></script>
    <script type="text/javascript"
            src="http://api.map.baidu.com/library/DistanceTool/1.2/src/DistanceTool_min.js"></script>

    <script type="text/javascript"
            src="http://api.map.baidu.com/library/DrawingManager/1.4/src/DrawingManager_min.js"></script>
    <link rel="stylesheet" href="http://api.map.baidu.com/library/DrawingManager/1.4/src/DrawingManager_min.css"/>
    <!-- 数据接口路径、共用JS -->
    <script src="../../../public/js/path.js"></script>
    <script src="../../../public/js/constant.js"></script>

    <style>
        .table {
            width: 100%;
            /*height: 100%;*/
            border-spacing: 10px;
            font-size: 12px;
            text-align: center;
        }

        .table tbody tr td {
            position: relative;
        }

        #defaultPhoto {
            width: 136px;
            border: 1px solid #DDDDDD;
            display: block;
            position: absolute;
            top: 0;
            left: 128px;
        }

        #sex {
            width: 164px;
        }

        #fileTd {
            text-align: left;
            padding-left: 34px;
        }

        .required {
            color: red;
        }

        #baidumaps {
            width: 675px;
            height: 330px;
            /*background-color: red;*/
            border: 1px solid #DDDDDD;
            margin: 0 auto;
        }
    </style>

</head>
<body class="easyui-layout" data-options="fit:true" style="padding:10px; box-sizing: border-box;">

<table class="table">
    <tbody>
    <tr>
        <input type="hidden" id="id" name="id" value="">

        <td><span class="required">*</span>任务名称：<input id="taskname" name="taskname" class="easyui-textbox"
                                                       data-options="validType:'length[1,20]'"/></td>
        <td><span class="required">*</span>任务状态：<input id="taskstatus" name="taskstatus" class="easyui-textbox"
                                                       data-options="validType:'length[1,20]'"/></td>
    </tr>
    <tr>

        <td><span class="required">*</span>开始时间：<input id="starttime" name="starttime" class="easyui-datetimebox"
                                                       data-options="validType:'length[1,20]'"/></td>
        <td><span class="required">*</span>结束时间：<input id="endtime" name="endtime" class="easyui-datetimebox"
                                                       data-options="validType:'length[1,20]'"/></td>
    </tr>
    <tr>
        <td><span class="required">*</span>更改状态：<input id="changestates" name="changestates" class="easyui-textbox"
                                                       data-options="validType:'length[1,20]'"/></td>

        <td></td>
    </tr>


    </tbody>
</table>
<div id="baidumaps">

</div>
</body>
</html>

<script>
    /*
     ** 全局变量声明
     */
    var oldname = "";
    var map;
    var oldphone = "";
    var token = sessionStorage.account;
    var globab_clientId = sessionStorage.clientId;
    var global_circle = "";
    var global_lg = "";
    var global_lt = "";
    var global_radio = "";
    var flag = true;
    var drawingManager = "";
    $(function () {

        ////console.info(globab_clientId);


        /*
         ** 判断当前状态是否为修改内容
         */
        if ("${param.id}" > 0) {
            loadvalue();
        }


    });

    /*
     ** 判断登录帐号是否已存在
     */
    function checkUserAccount(account) {
        if (account == null || account == "") {
            $.messager.alert('警告', "不能为空！", 'error');
            return;
        }
        if (oldname != account) {
            $.ajax({
                url: path + "/auditTaskManagement/checkAuditTaskManagementName?account=" + account,
                dataType: 'json',
                type: 'GET',
                async: false,
                success: function (data) {
                    if (data.code !== 0) {
                        $.messager.alert('警告', "用户已存在！", 'error');
//								$('#accountName').textbox("setValue","");
                    }
                }
            });
        }

    }

    /*
     ** 获取选中项的信息，并显示在输入框
     */
    function loadvalue() {

        $.ajax({
            url: path + '/auditTaskManagement/findAuditTaskManagementByid?id=' +${param.id},
            dataType: "json",
            type: "GET",
            success: function (data) {
                ////console.info(data);

                $('#id').val(data.id);

                $('#changestates').textbox("setValue", data.changestates);
                $('#endtime').datetimebox("setValue", formattime(data.endtime.time));
                $('#starttime').datetimebox("setValue", formattime(data.starttime.time));
                $('#taskname').textbox("setValue", data.taskname);
                $('#taskstatus').textbox("setValue", data.taskstatus);
                if (data.lg != 0) {
                    global_lg = data.lg;
                    global_lt = data.lat;
                    global_radio = data.radius;

                }

            }
        });
    }


    /*
     ** 判断传来的参数是否为空或null，是则弹出警告框
     */
    function errorAlert(value, msg) {
        if ((value === null) || (value === "")) {
            $.messager.alert('警告', msg, 'error');
            return false;
        }
        return true;
    }

    /*
     ** 判断必填内容不能为空；如果司机ID为空，则为添加数据；如果司机ID有值，则为修改数据
     */
    function completedForm(dialog, grid, p) {

        var id = $('#id').val();

        var changestates = $('#changestates').textbox("getValue");
        var endtime = $('#endtime').textbox("getValue");
        if (endtime != "") {
            endtime = StringtoDate(endtime)
        }
        var starttime = $('#starttime').textbox("getValue");
        if (starttime != "") {
            starttime = StringtoDate(starttime)
        }
        var taskname = $('#taskname').textbox("getValue");
        var taskstatus = $('#taskstatus').textbox("getValue");

        var data = {
            "id": id,
            "changestates": changestates,
            "endtime": endtime,
            "starttime": starttime,
            "taskname": taskname,
            "taskstatus": taskstatus,
            "lg": global_lg,
            "lat": global_lt,
            "radius": global_radio,
            "token": token

        };

        ////console.info(data);

        var requestURL = path + "/auditTaskManagement/saveorupdateAuditTaskManagement";

        $.ajax({
            type: "POST",
            crossDomain: true,
            url: requestURL,
            data: JSON.stringify(data), //必须转成JSON进行传递，否则会报code 117错误
            cache: false,
            dataType: "json", //后台返回值类型
            contentType: "application/json;charset=utf-8",
            success: function (data) {

                grid.datagrid('reload');
                window.parent.$.messager.show({
                    title: '提示',
                    msg: data.desc,
                    showType: 'slide'
                });
                dialog.dialog("destroy");
            }
        });


    }	//function completedForm()结束


    function loadJScript() {

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
        geoc = new BMap.Geocoder();

        addMapControl();

        //默认位置
        MoveDefaultView();

        if (global_lg != "") {
            addCircle(global_lg, global_lt, global_radio);
        }
        OpenDrawingManager();

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


    // 添加一个圆形
    function addCircle(dLg, dLt, radius) {
        if (global_circle != "") {
            map.removeOverlay(global_circle);
        }
        var point = new BMap.Point(dLg, dLt);
        map.centerAndZoom(point, 16);
        global_circle = new BMap.Circle(point, radius, {strokeColor: "blue", strokeWeight: 2, strokeOpacity: 0.5}); //创建圆
        map.addOverlay(global_circle);               // 将标注添加到地图中

    }

    function LatLgtoAddress(point) {
        var pt = point;
        geoc.getLocation(pt, function (rs) {
            var addComp = rs.addressComponents;
            selcetaddress = addComp.province + "" + addComp.city + "" + addComp.district + "" + addComp.street + "" + addComp.streetNumber;
            selcettitle = addComp.district + "" + addComp.street + "" + addComp.streetNumber;

//			////console.info(selcetaddress);
//			////console.info(selcettitle);

            $('#geographical').textbox('setValue', selcetaddress + "(" + selcettitle + ")");

        });
        map.clearOverlays();

    }

    function MoveToPoint(dLg, dLt) {
        var point = new BMap.Point(dLg, dLt);
        map.panTo(point);

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

                } else {
                    point = new BMap.Point(113.281608, 23.094162); // 创建点坐标
                    defzoon = 8;
                }
                map.centerAndZoom(point, defzoon);
            }
        });
    }

    //////////////////////////////////////////////////////////////////////////


    function OpenDrawingManager() {
        var styleOptions = {
            strokeColor: "red",    //边线颜色。
            fillColor: "red",      //填充颜色。当参数为空时，圆形将没有填充效果。
            strokeWeight: 3,       //边线的宽度，以像素为单位。
            strokeOpacity: 0.8,	   //边线透明度，取值范围0 - 1。
            fillOpacity: 0.6,      //填充的透明度，取值范围0 - 1。
            strokeStyle: 'solid' //边线的样式，solid或dashed。
        };
        //实例化鼠标绘制工具
        drawingManager = new BMapLib.DrawingManager(map, {
            isOpen: false, //是否开启绘制模式
            enableDrawingTool: true, //是否显示工具栏
            drawingToolOptions: {
                anchor: BMAP_ANCHOR_TOP_RIGHT, //位置
                offset: new BMap.Size(5, 5) //偏离值
            },
            circleOptions: styleOptions, //圆的样式
            polylineOptions: styleOptions, //线的样式
            polygonOptions: styleOptions, //多边形的样式
            rectangleOptions: styleOptions //矩形的样式
        });

        drawingManager.addEventListener('circlecomplete', OnCircleComplete);
        drawingManager.addEventListener('markercomplete', OnMarkerComplete);      // 点
        drawingManager.addEventListener('polygoncomplete', OnPolygonComplete);    // 多边形
        drawingManager.addEventListener('polylinecomplete', OnPolylineComplete);  // 线
        drawingManager.addEventListener('rectanglecomplete', OnRectangleComplete);// 矩形
    }


    function OnCircleComplete(e) {
//				////console.info(e.getRadius());
//				////console.info(e.getCenter().lng+","+e.getCenter().lat);
        global_lg = e.getCenter().lng;
        global_lt = e.getCenter().lat;
        global_radio = e.getRadius();
    }

    function OnMarkerComplete(e) {
        alert("目前只支持画圆");

    }

    function OnPolygonComplete(e) {
        alert("目前只支持画圆");
    }

    function OnPolylineComplete(e) {
        alert("目前只支持画圆");
    }

    function OnRectangleComplete(e) {
        alert("目前只支持画圆");
    }
</script>

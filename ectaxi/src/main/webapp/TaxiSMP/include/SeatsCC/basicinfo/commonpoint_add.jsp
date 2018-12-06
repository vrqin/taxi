<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>添加常用约车点</title>

    <!-- jquery easyui 插件 -->
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

    <script src="../../../public/js/constant.js"></script>

    <style>
        .table {
            width: 100%;
            /*height: 100%;*/
            font-size: 12px;
            text-align: center;
            border-spacing: 10px;
        }

        #type {
            width: 166px;
        }

        #baidumaps {
            width: 533px;
            height: 300px;
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
        <td>位置描述：<input id="position" class="easyui-textbox"/></td>
        <td>位置类型：
            <select id="type" class="easyui-combobox" data-options="editable:false">
                <option value="0">景点</option>
                <option value="1">宾馆</option>
                <option value="2">其它</option>
            </select>
        </td>
    </tr>
    <tr>
        <td>电话号码：<input id="phone" class="easyui-textbox"/></td>
        <td>地理位置：<input id="geographical" class="easyui-textbox"/></td>
    </tr>
    </tbody>
</table>
<div id="baidumaps">

</div>
</body>
</html>

<script>
    var map;
    var global_marker = "";
    var global_lg = "";
    var global_lat = "";
    var selcetaddress = "";
    var selcettitle = "";
    var geoc = "";
    var token = sessionStorage.account;
    var globab_clientId = sessionStorage.clientId;
    $(function () {

        /*
         ** 判断当前状态是否为修改内容
         */
        if ('${param.id}' > 0) {
            loadvalue();
        }

    });

    /*
     ** 获取选中项的信息，并显示在输入框
     */
    function loadvalue() {

        var requestURL = path + '/commonpoint/findCommonPointByid?id=' + '${param.id}' + "&clientid=" + globab_clientId;

        $.ajax({
            type: "POST",
            url: requestURL,
            async: false,
            dataType: "json", //后台返回值类型
            success: function (data) {
                ////console.info(data);
                $('#position').textbox('setValue', data.position);
                $('#type').textbox('setValue', getValueFromArray(data.type, commonpointtype));
                $('#phone').textbox('setValue', data.phone);
                $('#geographical').textbox('setValue', data.geographical);
                if (data.lg != "") {
                    global_lg = data.lg;
                    global_lat = data.lat;
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
    ** 判断必填内容不能为空；正常后提交添加
    */
    function completedForm(dialog, grid, p) {

        var position = $('#position').val();
        if (!errorAlert(position, "位置描述不能为空！！！")) {
            return false
        }

        var type = $("#type").combobox("getValue");

        var phone = $('#phone').val();
        if (!errorAlert(phone, "电话号码不能为空！！！")) {
            return false
        }

        var geographical = $('#geographical').val();
        if (!errorAlert(geographical, "地理位置不能为空！！！")) {
            return false
        }

        var data = {
            "id": '${param.id}',
            "position": position,
            "phone": phone,
            "geographical": geographical,
            "type": type,
            "lg": global_lg,
            "lat": global_lat,
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

                grid.datagrid('reload');
                window.parent.$.messager.show({
                    title: '提示',
                    msg: '操作成功!',
                    timeout: 3000,
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
            addMarker(global_lg, global_lat);
        }

        //点击事件
        map.addEventListener("click", function (e) {
            LatLgtoAddress(e.point);
            addMarker(e.point.lng, e.point.lat);
            global_lg = e.point.lng;
            global_lat = e.point.lat;
        });

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

    function addMarker(dLg, dLt) {
        if (global_marker != "") {
            map.removeOverlay(global_marker);
        }
        var point = new BMap.Point(dLg, dLt);
//		map.centerAndZoom(point, 17);
        global_marker = new BMap.Marker(point);  // 创建标注
        map.addOverlay(global_marker);               // 将标注添加到地图中
        global_marker.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画
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
//				console.info(data);
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

</script>
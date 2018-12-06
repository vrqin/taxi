<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>稽查任务管理</title>

    <!-- jquery easyui 插件 -->
    <link href="../../../public/jquery-easyui-1.5/themes/metro/easyui.css" rel="stylesheet"/>
    <link href="../../../public/jquery-easyui-1.5/themes/icon.css" rel="stylesheet"/>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.easyui.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/easyui-lang-zh_CN.js"></script>

    <script type="text/javascript" src="http://api.map.baidu.com/api?key=&v=1.1&services=true"></script>

    <!-- 数据接口路径、共用JS -->
    <script src="../../../public/js/path.js"></script>
    <script src="../../../public/js/utiljavascript.js"></script>
    <!-- childstyle -->
    <link rel="stylesheet" type="text/css" href="../../../public/css/childstyle.css"/>

    <style>
        body > div.datagrid {
            float: left;
        }

        #mappanel {
            width: auto;
            box-sizing: border-box;
            margin-left: 610px;
            border: 1px solid #dddddd;
            position: relative;
        }

        #mappanel::before {
            content: "稽查区域";
            display: block;
            width: 100%;
            height: 32px;
            background: #E57373;
            font-size: 12px;
            color: white;
            line-height: 32px;
            text-indent: 10px;
            position: absolute;
            top: 0;
            left: 0;
            z-index: 999;
        }

        #map {
            box-sizing: border-box;
            width: 100%;
            height: 100%;
            /*background: url(map.png) no-repeat left top;*/
        }
    </style>

</head>
<body id="body" class="easyui-layout" data-options="fit:true">

<!-- 数据表格 -->
<table id="redataGril"></table>

<!-- 工具栏 -->
<div id="toolbar">
    <div id="input">
        <label>任务名称:</label>
        <input id="key" class="easyui-textbox" data-options="width:160">
        <label>&nbsp;任务状态:</label>
        <select id="type" class="easyui-combobox" data-options="width:160">
            <option value="-1">全部</option>
            <option value="0">未开始</option>
            <option value="1">稽查中</option>
            <option value="2">稽查停止</option>
            <option value="3">已过期</option>
        </select>
        <p style="height: 10px; margin: 0;"></p>
        <label>开始时间:</label>
        <input id="begintime" class="easyui-datetimebox" data-options="width:160, editable:false">
        <label>&nbsp;结束时间:</label>
        <input id="endtime" class="easyui-datetimebox" data-options="width:160, editable:false">
    </div>
    <div id="button">
        <button class="easyui-linkbutton" id="search" iconCls="icon-search">查询</button>
        <button class="easyui-linkbutton" id="reset">重置</button>
        <button class="easyui-linkbutton" id="add">添加</button>
        <button class="easyui-linkbutton" id="modify">编缉</button>
        <button class="easyui-linkbutton" id="delete">删除</button>
    </div>
</div>

<!-- 地图 -->
<div id="mappanel">
    <div id="map"></div>
</div>

</body>
</html>

<script>
    /*
     ** 声明
     */
    var grid;
    var token = sessionStorage.account;
    var globab_clientId = sessionStorage.clientId;
    var global_circle = "";
    $(function () {

        if (globab_clientId == 0) {

        }


        /*
        ** 变量声明
        */
        var grid;
        var bodyHeight = $("body").eq(0).height();

        $("#mappanel").outerHeight(bodyHeight);

        /*
        ** 默认加载
        */
        acquireData('', '', '', -1);

        /*
        ** 查询
        */
        $("#search").click(function () {
            var key = $("#key").textbox("getValue");
            var type = $("#type").combobox("getValue");
            var begintime = $('#begintime').datetimebox("getValue");
            var endtime = $("#endtime").datetimebox("getValue");
            acquireData(begintime, endtime, key, type);
        });

        /*
         ** 重置
         */
        $("#reset").on("click", function () {
            $("#key").textbox("setValue", "");
            $("#type").combobox("setValue", '-1');
            $("#begintime").datetimebox('setValue', '');
            $("#endtime").datetimebox('setValue', '');
            acquireData('', '', '', -1);
        });


        /*
         ** 添加
         */
        $("#add").click(function () {
            var dialog = phm.modalDialog({
                title: '添加',
                width: 900,
                height: 560,
                closable: true,
                url: "manage_add.jsp?id=0",
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
        });

        /*
         ** 修改
         */
        $("#modify").click(function () {
            var row = grid.datagrid("getSelected");
            ////console.info(row);
            if (row == null) {
                $.messager.alert('警告', "请选择要修改的记录", 'info');
                return;
            }


            var dialog = phm.modalDialog({
                title: '修改',
                width: 900,
                height: 560,
                closable: true,
                url: "manage_add.jsp?id=" + row.id,
                buttons: [
                    {
                        text: '保存',
                        iconCls: 'icon-save',
                        handler: function () {
                            dialog.find('iframe').get(0).contentWindow.completedForm(dialog, grid, parent.$);
                        }
                    },
                    {
                        text: '关闭',
                        iconCls: 'icon-cancel',
                        handler: function () {
                            dialog.dialog("close");
                        }
                    }
                ]

            });
        });

        /*
         ** 删除
         */
        $("#delete").click(function () {
            var row = grid.datagrid("getSelected");
            ////console.info(row);
            if (row == null) {
                $.messager.alert('警告', "选择删除的记录", 'info');
                return;
            }

            $.messager.confirm('确认', '您确认想要删除记录吗？', function (r) {
                if (r) {

                    var requestURL = path + "/auditTaskManagement/delAuditTaskManagementByid?id=" + row.id + "&token=" + token;

                    $.ajax({
                        type: "DELETE",
                        url: requestURL,
                        async: false,
                        dataType: "json", //后台返回值类型
                        success: function (data) {
                            if (data.desc.indexOf("成功") > -1) {
                                grid.datagrid("reload");
                                grid.datagrid("clearSelections");
                                $.messager.show({
                                    title: '提示',
                                    msg: data.desc,
                                    timeout: 3000,
                                    showType: 'slide'
                                });
                            } else {
                                $.messager.alert("错误", data.desc, "error");
                            }
                        }
                    });

                }
            });
        });


        /*
        ** 获取数据
        */
        function acquireData(begintime, endtime, key, type) {
            var dataUrl = "sort=id&order=desc&begintime=" + begintime +
                "&endtime=" + endtime +
                "&key=" + key +
                "&taskstatus=" + type;
            grid = $("#redataGril").datagrid({
                width: 600,
                height: bodyHeight,
                url: path + "/auditTaskManagement/findAuditTaskManagementForPageList?" + dataUrl,
                fitColumns: true,
                striped: true,
                columns: [
                    [
                        {field: 'taskname', title: '任务名称', width: 100, align: 'center', sortable: true},
                        {field: 'starttime', title: '开始时间', width: 100, align: 'center', sortable: true},
                        {field: 'endtime', title: '结束时间', width: 100, align: 'center'},
                        {
                            field: 'taskstatus', title: '任务状态', width: 100, align: 'center',
                            formatter: function (value) {
                                switch (value) {
                                    case 0:
                                        return "未开始";
                                        break;
                                    case 1:
                                        return "稽查中";
                                        break;
                                    case 2:
                                        return "稽查停止";
                                        break;
                                    case 3:
                                        return "已过期";
                                        break;
                                }
                            }
                        },
                        {field: 'changestates', title: '更改状态', width: 100, align: 'center', sortable: true}
                    ]
                ],
//	          onLoadSuccess: function (data) {
//					////console.info(data);
//	          },
                onSelect: function (index, row) {
                    ////console.info(row);
                    if (row.lat != "" && row.lat != undefined) {
                        addCircle(row.lg, row.lat, row.radius)
                    }
                },
                idField: 'starttime',
                sortName: 'starttime',
                sortOrder: 'desc',
                singleSelect: true,
                pagination: true,
                pageSize: 20,
                pageList: [20, 40, 60, 80],
                rownumbers: true,
                toolbar: '#toolbar'
            });
        }

    });


    function loadJScript() {

        var script = document.createElement("script");
        script.type = "text/javascript";
        script.src = "http://api.map.baidu.com/api?v=2.0&ak=78OhopFWz7wPFKlaFXA1DYPU&callback=init";
        document.body.appendChild(script);

    }

    function init() {


        // 初始化设置
        map = new BMap.Map("map");//在百度地图容器中创建一个地图
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
        //ip定位
        myCity = new BMap.LocalCity();
        myCity.get(myFun);
//        MoveDefaultView();//默认位置
//		addCircle(113.4431590000,23.1694040000,500);

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
        if (global_circle != "") {
            map.removeOverlay(global_marker);
        }

        var point = new BMap.Point(dLg, dLt);
        map.centerAndZoom(point, 17);
        global_marker = new BMap.Marker(point);  // 创建标注
        map.addOverlay(global_marker);               // 将标注添加到地图中
        global_marker.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画
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
        $.ajax({
            url: path + '/driver/finddefPosbyUseid?' + dataUrl,
            dataType: 'json',
            type: 'GET',
            async: false,
            success: function (data) {
//                ////console.info(data);
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
                    Defaultlg = data.deflg;
                    Defaultlt = data.deflt;
                } else {
                    point = new BMap.Point(Defaultlg, Defaultlt); // 创建点坐标
                    defzoon = 8;
                }
                map.centerAndZoom(point, defzoon);
            }
        });
        PointtoAddress(Defaultlg, Defaultlt);

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
//        ////console.info(result);
        var cityName = result.name;
        map.setCenter(cityName);
        $("#tipname").html(cityName);
        Defaultlg = result.center.lng;
        Defaultlt = result.center.lat;
//        alert(Defaultlg);
    }

    function reupload() {
        location.reload();
    }

</script>
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
    <title>智能查找司机</title>

    <link href="../../../public/jquery-easyui-1.5/themes/metro/easyui.css" rel="stylesheet"/>
    <link href="../../../public/jquery-easyui-1.5/themes/icon.css" rel="stylesheet"/>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.easyui.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/easyui-lang-zh_CN.js"></script>

    <script type="text/javascript" src="http://api.map.baidu.com/api?key=&v=1.1&services=true"></script>

    <!-- childstyle -->
    <link rel="stylesheet" type="text/css" href="../../../public/css/childstyle.css"/>

    <style type="text/css">
        #baidumap {
            width: 800px;
            height: 380px;
            margin: 44px auto;
            border: 1px solid #000000;
        }

        #input {
            font-size: 12px;
        }
    </style>


</head>
<body id="body" class="easyui-layout" data-options="fit:true">

<div id="toolbar">
    <div id="input">
        <span>&nbsp;查找时间段</span>
        <input name="date" class="easyui-datetimebox " data-options="width:160,panelHeight:'auto',editable:false"/>
        <span>至</span>
        <input name="date" class="easyui-datetimebox" data-options="width:160,panelHeight:'auto',editable:false"/>
        <span>(2小时范围内)</span><br/><br/>
        <span>&nbsp;&nbsp;&nbsp;上车点</span>
        <input class="easyui-textbox" style="width:160px;">
        <span>&nbsp;&nbsp;查找范围</span>
        <input class="easyui-textbox" style="width:100px;">
        <span>(0~10000米)</span><br/><br/>
        <span>&nbsp;&nbsp;&nbsp;下车点</span>
        <input class="easyui-textbox" style="width:160px;">
        <button class="easyui-linkbutton" data-options="iconCls:'icon-search'"
                style="padding:0 10px;margin-left: 104px;">查询
        </button>
        <div id="baidumap">
        </div>
    </div>
</div>
</body>
</html>
<script>


    //创建和初始化地图函数：
    function initMap() {
        createMap();//创建地图
        setMapEvent();//设置地图事件
        addMapControl();//向地图添加控件
    }

    //创建地图函数：
    function createMap() {
        var map = new BMap.Map("baidumap");//在百度地图容器中创建一个地图
        var point = new BMap.Point(113.442087, 23.173325);//定义一个中心点坐标
        map.centerAndZoom(point, 18);//设定地图的中心点和坐标并将地图显示在地图容器中
        window.map = map;//将map变量存储在全局
    }

    //地图事件设置函数：
    function setMapEvent() {
        map.enableDragging();//启用地图拖拽事件，默认启用(可不写)
        map.enableScrollWheelZoom();//启用地图滚轮放大缩小
        map.enableDoubleClickZoom();//启用鼠标双击放大，默认启用(可不写)
        map.enableKeyboard();//启用键盘上下左右键移动地图
    }

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


    initMap();//创建和初始化地图


    var grid;

    $(function () {


    });

    //datagril 列表宽度
    function fixWidth(percent) {
        return Math.floor(document.body.clientWidth * percent); //这里你可以自己做调整
    }
</script>
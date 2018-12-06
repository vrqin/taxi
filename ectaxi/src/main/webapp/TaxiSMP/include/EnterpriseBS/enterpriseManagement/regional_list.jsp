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
    <title>区域管理</title>

    <link href="../../../public/jquery-easyui-1.5/themes/metro/easyui.css" rel="stylesheet"/>
    <link href="../../../public/jquery-easyui-1.5/themes/icon.css" rel="stylesheet"/>

    <script src="../../../public/jquery-easyui-1.5/js/jquery.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.easyui.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/api?key=&v=1.1&services=true"></script>
    <style type="text/css">
        html, body {
            width: 100%;
            height: 100%;
            margin: 0px;
            padding: 0px;

        }

        .arealist {
            float: left;
            width: 204px;
            height: 100%;
            background-color: #F9FCFF;
        }

        .arealist ul {
            margin: 0px;
            padding: 0px;
        }

        .arealist ul li {
            list-style: none;
            font-size: 12px;
            padding: 8px 0 8px 35px;
            border-bottom: 1px solid;
            border-color: #999999;

        }

        .arealist ul li:hover {
            background-color: #DFDFDF;
        }

        .areatab {
            margin-left: 204px;
            width: auto;
            height: 100%;
        }

        #baidumaps {
            width: auto;
            height: 100%;
        }

        .maptip {
            position: absolute;
            top: 43px;
            right: 18px;
            width: 200px;
            height: 25px;
            line-height: 25px;
            background-color: #ffffff;
            box-shadow: 0 2px 2px rgba(0, 0, 0, 0.3);
        }

        .maptip ul {
            margin: 0px;
            padding: 0px;
            text-align: center;

        }

        .maptip ul li {
            display: inline;
            list-style: none;
            font-size: 12px;
            text-align: center;
            padding: 0 5px;
            cursor: pointer;
        }
    </style>


</head>
<body class="easyui-layout" data-options="border:false ,fit:true">
<div class="arealist">
    <ul>
        <li>儿童公园</li>
        <li>吉山公园</li>
        <li>天河公园</li>
        <li>天河儿童公园</li>
        <li>区域1</li>
        <li>区域2</li>
        <li>区域3</li>
        <li>区域4</li>
    </ul>
</div>
<div class="areatab">
    <div class="easyui-tabs" style="width:100%;height:100%">
        <div title="地理信息" style="padding:5px">
            <div id="baidumaps">

            </div>
            <div class="maptip">
                <ul>
                    <li>地理搜索</li>
                    <li>多边形</li>
                    <li>圆形</li>
                    <li>矩形</li>
                </ul>
            </div>
        </div>
        <div title="规则设置">

        </div>
        <div title="车辆设置">

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
        var map = new BMap.Map("baidumaps");//在百度地图容器中创建一个地图
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
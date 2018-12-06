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
    <title>单位管理</title>

    <!-- jquery easyui 插件 -->
    <link href="../../../public/jquery-easyui-1.5/themes/metro/easyui.css" rel="stylesheet"/>
    <link href="../../../public/jquery-easyui-1.5/themes/icon.css" rel="stylesheet"/>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.easyui.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/easyui-lang-zh_CN.js"></script>

    <!-- 数据接口路径、共用JS -->
    <script src="../../../public/js/path.js"></script>

    <!-- childstyle -->
    <link rel="stylesheet" type="text/css" href="../../../public/css/childstyle.css"/>

</head>
<body style="margin: 10px; border: 1px solid #DDDDDD;" class="easyui-layout" data-options="fit:true">

<!-- 工具栏 -->
<div id="toolbar">
    <div id="input">
        <label>公司名称</label>
        <input id="key" class="easyui-textbox" style="width:160px;">
    </div>
    <div id="button">
        <button class="easyui-linkbutton" id="search" data-options="iconCls:'icon-search'">查询</button>
        <button class="easyui-linkbutton" id="reset">重置</button>
        <button class="easyui-linkbutton" id="add">添加</button>
        <button class="easyui-linkbutton" id="delete">删除</button>
    </div>
</div>

<!-- 数据树 -->
<ul id="datatree" style="padding-left: 10px;"></ul>

</body>
</html>

<script>

    $(function () {

        var data = [{
            "id": 1,
            "text": "广州出租车",
            "children": [{
                "text": "天河出租车公司",
                "checked": true
            }, {
                "text": "白云出租车公司",
                "checked": true
            }, {
                "text": "海珠出租车公司",
                "checked": true
            }]
        }, {
            "text": "梅州联通",
            "state": "closed",
            "children": [{
                "text": "五华出租车公司"
            }, {
                "text": "梅县出租车公司"
            }]
        }]


        $("#datatree").tree({
            data: data
        });

    });

</script>
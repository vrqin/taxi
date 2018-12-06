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
    <title>驾驶员电召情况</title>

    <link href="../../../public/jquery-easyui-1.5/themes/metro/easyui.css" rel="stylesheet"/>
    <link href="../../../public/jquery-easyui-1.5/themes/icon.css" rel="stylesheet"/>

    <script src="../../../public/jquery-easyui-1.5/js/jquery.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.easyui.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/easyui-lang-zh_CN.js"></script>

    <style type="text/css">

    </style>

    <script>
        var grid;
        var data = [
            {
                "name": "陈海军",
                "gender": "女",
                "kubnum": "粤A12345",
                "phone": "15998788757",
                "enterprise": "广州测试",
                "integral": "1203",
                "rating": "五星",
                "isblacklist": "否",
                "callnumber": "958",
                "successnumber": "503",
                "cancelnumber": "184",
                "promisenumber": "271"
            },
            {
                "name": "陈海军",
                "gender": "女",
                "kubnum": "粤A12345",
                "phone": "15998788757",
                "enterprise": "广州测试",
                "integral": "1203",
                "rating": "五星",
                "isblacklist": "否",
                "callnumber": "958",
                "successnumber": "503",
                "cancelnumber": "184",
                "promisenumber": "271"
            },
            {
                "name": "陈海军",
                "gender": "女",
                "kubnum": "粤A12345",
                "phone": "15998788757",
                "enterprise": "广州测试",
                "integral": "1203",
                "rating": "五星",
                "isblacklist": "否",
                "callnumber": "958",
                "successnumber": "503",
                "cancelnumber": "184",
                "promisenumber": "271"
            },
            {
                "name": "陈海军",
                "gender": "女",
                "kubnum": "粤A12345",
                "phone": "15998788757",
                "enterprise": "广州测试",
                "integral": "1203",
                "rating": "五星",
                "isblacklist": "否",
                "callnumber": "958",
                "successnumber": "503",
                "cancelnumber": "184",
                "promisenumber": "271"
            },
            {
                "name": "陈海军",
                "gender": "女",
                "kubnum": "粤A12345",
                "phone": "15998788757",
                "enterprise": "广州测试",
                "integral": "1203",
                "rating": "五星",
                "isblacklist": "否",
                "callnumber": "958",
                "successnumber": "503",
                "cancelnumber": "184",
                "promisenumber": "271"
            }
        ];
        $(function () {


            grid = $("#redataGril").datagrid({
                fit: true,
                data: data,
//                height: $("#dataview").height() -300+"px",
                fitColumns: true,
                striped: true,
                columns: [
                    [
                        {field: 'name', title: '乘客姓名', width: fixWidth(0.1), align: 'center', sortable: true},
                        {field: 'gender', title: '性别', width: fixWidth(0.1), align: 'center', sortable: true},
                        {field: 'kubnum', title: '车牌号', width: fixWidth(0.1), align: 'center'},
                        {field: 'phone', title: '联系电话', width: fixWidth(0.1), align: 'center'},
                        {field: 'enterprise', title: '企业', width: fixWidth(0.1), align: 'center'},
                        {field: 'integral', title: '召车积分', width: fixWidth(0.1), align: 'center', sortable: true},
                        {field: 'rating', title: '评级', width: fixWidth(0.1), align: 'center', sortable: true},
                        {field: 'isblacklist', title: '是否黑名单', width: fixWidth(0.1), align: 'center', sortable: true},
                        {field: 'callnumber', title: '总召车次数', width: fixWidth(0.1), align: 'center', sortable: true},
                        {field: 'successnumber', title: '电召成功数', width: fixWidth(0.1), align: 'center', sortable: true},
                        {field: 'cancelnumber', title: '取消次数', width: fixWidth(0.1), align: 'center', sortable: true},
                        {field: 'promisenumber', title: '爽约次数', width: fixWidth(0.1), align: 'center', sortable: true},

                    ]
                ],
                onLoadSuccess: function (data) {

                },
                detailFormatter: function (rowIndex, rowData) {
                },
                onDblClickRow: function (rowIndex, rowData) {

                },
                onClickRow: function (rowIndex, rowData) {

                },
                idField: 'phone',
                sortName: 'phone',
                sortOrder: 'desc',
                singleSelect: true,
                pagination: true,
                pageSize: 20,
                pageList: [20, 40, 60, 80],
                rownumbers: true,
                toolbar: '#toolbar'
            });

        });

        //datagril 列表宽度
        function fixWidth(percent) {
            return Math.floor(document.body.clientWidth * percent); //这里你可以自己做调整
        }
    </script>
</head>
<body class="easyui-layout" data-options="border:true ,fit:true" style="margin:10px;">
<div id="toolbar">

    <div style="margin: 10px;padding: 10px;border: 1px solid #c8c8c8;">

        <label>姓名:</label>
        <input class="easyui-textbox" style="width:160px;">
        <label>联系电话:</label>
        <input class="easyui-textbox" style="width:160px;">
        <span>是否黑名单</span>
        <select class="easyui-combobox" data-options="panelHeight:'auto',editable:false">
            <option value="ar">是</option>
            <option value="bg">否</option>

        </select>
        <label>企业名称:</label>
        <input class="easyui-textbox" style="width:160px;">
        <label>评级:</label>
        <select class="easyui-combobox" data-options="panelHeight:'auto',editable:false">
            <option value="ar">五星</option>
            <option value="bg">四星</option>
            <option value="bg">三星</option>
            <option value="bg">二星</option>
            <option value="bg">一星</option>

        </select>

    </div>
    <div>
        <button type="button" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="width:80px">添加
        </button>
        <button type="button" class="easyui-linkbutton">重置</button>
        <button type="button" class="easyui-linkbutton"> 重置密码</button>
        <button type="button" class="easyui-linkbutton"> 删除</button>
    </div>


</div>
<table id="redataGril" data-options="fit:true"></table>
</body>
</html>

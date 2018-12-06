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
    <title>驾驶员服务统计</title>

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
                "name": "陈师傅",
                "kabnum": "粤123456",
                "evaluationnum": "10",
                "5starnum": "0",
                "4starnum": "0",
                "3starnum": "0",
                "2starnum": "0",
                "1starnum": "0",
                "nostarnum": "0"
            },
            {
                "name": "陈师傅",
                "kabnum": "粤123456",
                "evaluationnum": "10",
                "5starnum": "0",
                "4starnum": "0",
                "3starnum": "0",
                "2starnum": "0",
                "1starnum": "0",
                "nostarnum": "0"
            },
            {
                "name": "陈师傅",
                "kabnum": "粤123456",
                "evaluationnum": "10",
                "5starnum": "0",
                "4starnum": "0",
                "3starnum": "0",
                "2starnum": "0",
                "1starnum": "0",
                "nostarnum": "0"
            },
            {
                "name": "陈师傅",
                "kabnum": "粤123456",
                "evaluationnum": "10",
                "5starnum": "0",
                "4starnum": "0",
                "3starnum": "0",
                "2starnum": "0",
                "1starnum": "0",
                "nostarnum": "0"
            },
            {
                "name": "陈师傅",
                "kabnum": "粤123456",
                "evaluationnum": "10",
                "5starnum": "0",
                "4starnum": "0",
                "3starnum": "0",
                "2starnum": "0",
                "1starnum": "0",
                "nostarnum": "0"
            },
            {
                "name": "陈师傅",
                "kabnum": "粤123456",
                "evaluationnum": "10",
                "5starnum": "0",
                "4starnum": "0",
                "3starnum": "0",
                "2starnum": "0",
                "1starnum": "0",
                "nostarnum": "0"
            },
            {
                "name": "陈师傅",
                "kabnum": "粤123456",
                "evaluationnum": "10",
                "5starnum": "0",
                "4starnum": "0",
                "3starnum": "0",
                "2starnum": "0",
                "1starnum": "0",
                "nostarnum": "0"
            },
            {
                "name": "陈师傅",
                "kabnum": "粤123456",
                "evaluationnum": "10",
                "5starnum": "0",
                "4starnum": "0",
                "3starnum": "0",
                "2starnum": "0",
                "1starnum": "0",
                "nostarnum": "0"
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
                        {field: 'name', title: '司机名称', width: fixWidth(0.1), align: 'center', sortable: true},
                        {field: 'kabnum', title: '车牌号', width: fixWidth(0.1), align: 'center'},
                        {field: 'evaluationnum', title: '评价次数', width: fixWidth(0.1), align: 'center'},
                        {field: '5starnum', title: '5星次数', width: fixWidth(0.1), align: 'center'},
                        {field: '4starnum', title: '4星次数', width: fixWidth(0.1), align: 'center', sortable: true},
                        {field: '3starnum', title: '3星次数', width: fixWidth(0.1), align: 'center', sortable: true},
                        {field: '2starnum', title: '2星次数', width: fixWidth(0.1), align: 'center', sortable: true},
                        {field: '1starnum', title: '1星次数', width: fixWidth(0.1), align: 'center', sortable: true},
                        {field: 'nostarnum', title: '未评价次数', width: fixWidth(0.1), align: 'center', sortable: true}

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

        <label>车牌号:</label>
        <input class="easyui-textbox" style="width:160px;">
        <label>驾驶员姓名:</label>
        <input class="easyui-textbox" style="width:160px;">


    </div>
    <div>
        <button type="button" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="width:80px">添加
        </button>
        <button type="button" class="easyui-linkbutton">重置</button>
        <button type="button" class="easyui-linkbutton"> 导出</button>
    </div>


</div>
<table id="redataGril" data-options="fit:true"></table>
</body>
</html>
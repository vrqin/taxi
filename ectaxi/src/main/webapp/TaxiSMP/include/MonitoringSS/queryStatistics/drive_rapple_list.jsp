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
    <title>司机申请信息</title>

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
                "phone": "59894564654",
                "identity": "844564646",
                "operationid": "16545643464 ",
                "kabnum": "粤568651",
                "applytime": " ",
                "audittime": " ",
                "applystatus": " "
            },
            {
                "name": "陈师傅",
                "phone": "59894564654",
                "identity": "844564646",
                "operationid": "16545643464 ",
                "kabnum": "粤568651",
                "applytime": " ",
                "audittime": " ",
                "applystatus": " "
            },
            {
                "name": "陈师傅",
                "phone": "59894564654",
                "identity": "844564646",
                "operationid": "16545643464 ",
                "kabnum": "粤568651",
                "applytime": " ",
                "audittime": " ",
                "applystatus": " "
            },
            {
                "name": "陈师傅",
                "phone": "59894564654",
                "identity": "844564646",
                "operationid": "16545643464 ",
                "kabnum": "粤568651",
                "applytime": " ",
                "audittime": " ",
                "applystatus": " "
            },
            {
                "name": "陈师傅",
                "phone": "59894564654",
                "identity": "844564646",
                "operationid": "16545643464 ",
                "kabnum": "粤568651",
                "applytime": " ",
                "audittime": " ",
                "applystatus": " "
            },
            {
                "name": "陈师傅",
                "phone": "59894564654",
                "identity": "844564646",
                "operationid": "16545643464 ",
                "kabnum": "粤568651",
                "applytime": " ",
                "audittime": " ",
                "applystatus": " "
            },
            {
                "name": "陈师傅",
                "phone": "59894564654",
                "identity": "844564646",
                "operationid": "16545643464 ",
                "kabnum": "粤568651",
                "applytime": " ",
                "audittime": " ",
                "applystatus": " "
            },
            {
                "name": "陈师傅",
                "phone": "59894564654",
                "identity": "844564646",
                "operationid": "16545643464 ",
                "kabnum": "粤568651",
                "applytime": " ",
                "audittime": " ",
                "applystatus": " "
            },
            {
                "name": "陈师傅",
                "phone": "59894564654",
                "identity": "844564646",
                "operationid": "16545643464 ",
                "kabnum": "粤568651",
                "applytime": " ",
                "audittime": " ",
                "applystatus": " "
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
                        {field: 'name', title: '姓名', width: fixWidth(0.1), align: 'center', sortable: true},
                        {field: 'phone', title: '手机号', width: fixWidth(0.1), align: 'center'},
                        {field: 'identity', title: '身份证号', width: fixWidth(0.1), align: 'center'},
                        {field: 'operationid', title: '运营证号', width: fixWidth(0.1), align: 'center', sortable: true},
                        {field: 'kabnum', title: '车牌号', width: fixWidth(0.1), align: 'center', sortable: true},
                        {field: 'applytime', title: '申请时间', width: fixWidth(0.1), align: 'center', sortable: true},
                        {field: 'audittime', title: '审核时间', width: fixWidth(0.1), align: 'center', sortable: true},
                        {field: 'applystatus', title: '申请状态', width: fixWidth(0.1), align: 'center', sortable: true}

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
        <label>手机号:</label>
        <input class="easyui-textbox" style="width:160px;">

    </div>
    <div>
        <button type="button" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="width:80px">添加
        </button>
        <button type="button" class="easyui-linkbutton">重置</button>
        <button type="button" class="easyui-linkbutton"> 删除</button>
    </div>


</div>
<table id="redataGril" data-options="fit:true"></table>
</body>
</html>

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
    <title>投诉处理</title>

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
                "describe": "态度恶劣",
                "acceptime": "2016/6/21 14:15:51",
                "source": "网络",
                "customername": "陈先生",
                "phone": "12345678901",
                "kebnum": "粤123456",
                "endtime": "2016/05/24 10:02:17",
                "results": " ",
                "state": "受理",
                "orderID": "21568621682"
            },
            {
                "describe": "态度恶劣",
                "acceptime": "2016/6/21 14:15:51",
                "source": "网络",
                "customername": "陈先生",
                "phone": "12345678901",
                "kebnum": "粤123456",
                "endtime": "2016/05/24 10:02:17",
                "results": " ",
                "state": "受理",
                "orderID": "21568621682"
            },
            {
                "describe": "态度恶劣",
                "acceptime": "2016/6/21 14:15:51",
                "source": "网络",
                "customername": "陈先生",
                "phone": "12345678901",
                "kebnum": "粤123456",
                "endtime": "2016/05/24 10:02:17",
                "results": " ",
                "state": "受理",
                "orderID": "21568621682"
            },
            {
                "describe": "态度恶劣",
                "acceptime": "2016/6/21 14:15:51",
                "source": "网络",
                "customername": "陈先生",
                "phone": "12345678901",
                "kebnum": "粤123456",
                "endtime": "2016/05/24 10:02:17",
                "results": " ",
                "state": "受理",
                "orderID": "21568621682"
            },
            {
                "describe": "态度恶劣",
                "acceptime": "2016/6/21 14:15:51",
                "source": "网络",
                "customername": "陈先生",
                "phone": "12345678901",
                "kebnum": "粤123456",
                "endtime": "2016/05/24 10:02:17",
                "results": " ",
                "state": "受理",
                "orderID": "21568621682"
            },
            {
                "describe": "态度恶劣",
                "acceptime": "2016/6/21 14:15:51",
                "source": "网络",
                "customername": "陈先生",
                "phone": "12345678901",
                "kebnum": "粤123456",
                "endtime": "2016/05/24 10:02:17",
                "results": " ",
                "state": "受理",
                "orderID": "21568621682"
            },
            {
                "describe": "态度恶劣",
                "acceptime": "2016/6/21 14:15:51",
                "source": "网络",
                "customername": "陈先生",
                "phone": "12345678901",
                "kebnum": "粤123456",
                "endtime": "2016/05/24 10:02:17",
                "results": " ",
                "state": "受理",
                "orderID": "21568621682"
            },
            {
                "describe": "态度恶劣",
                "acceptime": "2016/6/21 14:15:51",
                "source": "网络",
                "customername": "陈先生",
                "phone": "12345678901",
                "kebnum": "粤123456",
                "endtime": "2016/05/24 10:02:17",
                "results": " ",
                "state": "受理",
                "orderID": "21568621682"
            }
        ];
        $(function () {


            grid = $("#redataGril").datagrid({
                fit: true,
                data: data,
                height: $("#dataview").height() - 300 + "px",
                fitColumns: true,
                striped: true,
                columns: [
                    [
                        {field: 'describe', title: '投诉描述', width: fixWidth(0.1), align: 'center'},
                        {field: 'acceptime', title: '投诉受理时间', width: fixWidth(0.1), align: 'center', sortable: true},
                        {field: 'source', title: '投诉来源', width: fixWidth(0.1), align: 'center', sortable: true},
                        {field: 'customername', title: '客户名称', width: fixWidth(0.1), align: 'center'},
                        {field: 'phone', title: '客户联系号码', width: fixWidth(0.1), align: 'center', sortable: true},
                        {field: 'kebnum', title: '被投诉车辆', width: fixWidth(0.1), align: 'center', sortable: true},
                        {field: 'endtime', title: '处理结束时间', width: fixWidth(0.1), align: 'center', sortable: true},
                        {field: 'results', title: '处理结果', width: fixWidth(0.1), align: 'center', sortable: true},
                        {field: 'state', title: '处理状态', width: fixWidth(0.1), align: 'center', sortable: true},
                        {field: 'orderID', title: '订单ID', width: fixWidth(0.1), align: 'center', sortable: true}
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

        <label>关键字:</label>
        <input class="easyui-textbox" style="width:160px;">
        <label>车辆名称:</label>
        <input class="easyui-textbox" style="width:160px;">
        <span>投诉来源</span>
        <select class="easyui-combobox" data-options="panelHeight:'auto',editable:false">
            <option value="ar">电话</option>
            <option value="bg">网络</option>

        </select>
        <span>处理状态</span>
        <select class="easyui-combobox" data-options="panelHeight:'auto',editable:false">
            <option value="ar">受理</option>
            <option value="bg">处理中</option>

        </select>
    </div>
    <div>
        <button type="button" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="width:80px">添加
        </button>
        <button type="button" class="easyui-linkbutton">重置</button>
    </div>


</div>
<table id="redataGril" data-options="fit:true"></table>
</body>
</html>

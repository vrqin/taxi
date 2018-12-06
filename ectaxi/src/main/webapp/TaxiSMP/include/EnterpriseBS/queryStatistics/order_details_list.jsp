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
    <title>电召订单明细</title>

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
                "ordernum": "8245800325",
                "calltime": "2016/8/24 14:43:29",
                "passphone": "12345678910",
                "start": "河南省郑州市二七区太和路",
                "end": "河南省郑州市二七区太和路",
                "type": "即时订单",
                "state": "订单成功完成",
                "drivername": "李先森",
                "driverphone": "13589847985",
                "kabnum": "粤238493",
                "payment": "支付宝",
                "amount": "10.25",
                "evaluation": "未评价",
                "personnel": ""
            },
            {
                "ordernum": "8245800325",
                "calltime": "2016/8/24 14:43:29",
                "passphone": "12345678910",
                "start": "河南省郑州市二七区太和路",
                "end": "河南省郑州市二七区太和路",
                "type": "即时订单",
                "state": "订单成功完成",
                "drivername": "李先森",
                "driverphone": "13589847985",
                "kabnum": "粤238493",
                "payment": "支付宝",
                "amount": "10.25",
                "evaluation": "未评价",
                "personnel": ""
            },
            {
                "ordernum": "8245800325",
                "calltime": "2016/8/24 14:43:29",
                "passphone": "12345678910",
                "start": "河南省郑州市二七区太和路",
                "end": "河南省郑州市二七区太和路",
                "type": "即时订单",
                "state": "订单成功完成",
                "drivername": "李先森",
                "driverphone": "13589847985",
                "kabnum": "粤238493",
                "payment": "支付宝",
                "amount": "10.25",
                "evaluation": "未评价",
                "personnel": ""
            },
            {
                "ordernum": "8245800325",
                "calltime": "2016/8/24 14:43:29",
                "passphone": "12345678910",
                "start": "河南省郑州市二七区太和路",
                "end": "河南省郑州市二七区太和路",
                "type": "即时订单",
                "state": "订单成功完成",
                "drivername": "李先森",
                "driverphone": "13589847985",
                "kabnum": "粤238493",
                "payment": "支付宝",
                "amount": "10.25",
                "evaluation": "未评价",
                "personnel": ""
            },
            {
                "ordernum": "8245800325",
                "calltime": "2016/8/24 14:43:29",
                "passphone": "12345678910",
                "start": "河南省郑州市二七区太和路",
                "end": "河南省郑州市二七区太和路",
                "type": "即时订单",
                "state": "订单成功完成",
                "drivername": "李先森",
                "driverphone": "13589847985",
                "kabnum": "粤238493",
                "payment": "支付宝",
                "amount": "10.25",
                "evaluation": "未评价",
                "personnel": ""
            },
            {
                "ordernum": "8245800325",
                "calltime": "2016/8/24 14:43:29",
                "passphone": "12345678910",
                "start": "河南省郑州市二七区太和路",
                "end": "河南省郑州市二七区太和路",
                "type": "即时订单",
                "state": "订单成功完成",
                "drivername": "李先森",
                "driverphone": "13589847985",
                "kabnum": "粤238493",
                "payment": "支付宝",
                "amount": "10.25",
                "evaluation": "未评价",
                "personnel": ""
            },
            {
                "ordernum": "8245800325",
                "calltime": "2016/8/24 14:43:29",
                "passphone": "12345678910",
                "start": "河南省郑州市二七区太和路",
                "end": "河南省郑州市二七区太和路",
                "type": "即时订单",
                "state": "订单成功完成",
                "drivername": "李先森",
                "driverphone": "13589847985",
                "kabnum": "粤238493",
                "payment": "支付宝",
                "amount": "10.25",
                "evaluation": "未评价",
                "personnel": ""
            },
            {
                "ordernum": "8245800325",
                "calltime": "2016/8/24 14:43:29",
                "passphone": "12345678910",
                "start": "河南省郑州市二七区太和路",
                "end": "河南省郑州市二七区太和路",
                "type": "即时订单",
                "state": "订单成功完成",
                "drivername": "李先森",
                "driverphone": "13589847985",
                "kabnum": "粤238493",
                "payment": "支付宝",
                "amount": "10.25",
                "evaluation": "未评价",
                "personnel": ""
            },
            {
                "ordernum": "8245800325",
                "calltime": "2016/8/24 14:43:29",
                "passphone": "12345678910",
                "start": "河南省郑州市二七区太和路",
                "end": "河南省郑州市二七区太和路",
                "type": "即时订单",
                "state": "订单成功完成",
                "drivername": "李先森",
                "driverphone": "13589847985",
                "kabnum": "粤238493",
                "payment": "支付宝",
                "amount": "10.25",
                "evaluation": "未评价",
                "personnel": ""
            },
            {
                "ordernum": "8245800325",
                "calltime": "2016/8/24 14:43:29",
                "passphone": "12345678910",
                "start": "河南省郑州市二七区太和路",
                "end": "河南省郑州市二七区太和路",
                "type": "即时订单",
                "state": "订单成功完成",
                "drivername": "李先森",
                "driverphone": "13589847985",
                "kabnum": "粤238493",
                "payment": "支付宝",
                "amount": "10.25",
                "evaluation": "未评价",
                "personnel": ""
            },
            {
                "ordernum": "8245800325",
                "calltime": "2016/8/24 14:43:29",
                "passphone": "12345678910",
                "start": "河南省郑州市二七区太和路",
                "end": "河南省郑州市二七区太和路",
                "type": "即时订单",
                "state": "订单成功完成",
                "drivername": "李先森",
                "driverphone": "13589847985",
                "kabnum": "粤238493",
                "payment": "支付宝",
                "amount": "10.25",
                "evaluation": "未评价",
                "personnel": ""
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
                        {field: 'ordernum', title: '订单号', width: fixWidth(0.1), align: 'center'},
                        {field: 'calltime', title: '电召时间', width: fixWidth(0.1), align: 'center', sortable: true},
                        {field: 'passphone', title: '乘客电话', width: fixWidth(0.1), align: 'center', sortable: true},
                        {field: 'start', title: '起点', width: fixWidth(0.1), align: 'center'},
                        {field: 'end', title: '终点', width: fixWidth(0.1), align: 'center', sortable: true},
                        {field: 'type', title: '订单类型', width: fixWidth(0.1), align: 'center', sortable: true},
                        {field: 'state', title: '状态', width: fixWidth(0.1), align: 'center', sortable: true},
                        {field: 'drivername', title: '司机名称', width: fixWidth(0.1), align: 'center', sortable: true},
                        {field: 'driverphone', title: '司机号码', width: fixWidth(0.1), align: 'center', sortable: true},
                        {field: 'kabnum', title: '车牌号', width: fixWidth(0.1), align: 'center', sortable: true},
                        {field: 'payment', title: '支付方式', width: fixWidth(0.1), align: 'center', sortable: true},
                        {field: 'amount', title: '交易金额', width: fixWidth(0.1), align: 'center', sortable: true},
                        {field: 'evaluation', title: '评价', width: fixWidth(0.1), align: 'center', sortable: true},
                        {field: 'personnel', title: '调度人员', width: fixWidth(0.1), align: 'center', sortable: true}

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

        <label>车牌号码:</label>
        <input class="easyui-textbox" style="width:160px;">
        <label>司机姓名:</label>
        <input class="easyui-textbox" style="width:160px;">
        <label>乘客信息:</label>
        <input class="easyui-textbox" style="width:160px;">
        <span>调度人员</span>
        <select class="easyui-combobox" data-options="panelHeight:'auto',editable:false">
            <option value="ar">是</option>
            <option value="bg">否</option>
        </select>
        <span>开始时间</span>
        <select name="date" class="easyui-datetimebox " data-options="panelHeight:'auto',editable:false"
                style="width: 160px;">
        </select>
        <span>结束时间</span>
        <select name="date" class="easyui-datetimebox" data-options="panelHeight:'auto',editable:false"
                style="width: 160px;">
        </select>

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

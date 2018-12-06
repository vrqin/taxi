<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>服务评价明细</title>

    <!-- jquery easyui 插件 -->
    <link href="../../../public/jquery-easyui-1.5/themes/metro/easyui.css" rel="stylesheet"/>
    <link href="../../../public/jquery-easyui-1.5/themes/icon.css" rel="stylesheet"/>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.easyui.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/easyui-lang-zh_CN.js"></script>

    <!-- 数据接口路径 -->
    <script src="../../../public/js/path.js"></script>

</head>

<body class="easyui-layout" data-options="border:true ,fit:true" style="padding:10px; box-sizing: border-box;">

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
                style="width: 160px;"></select>
        <span>结束时间</span>
        <select name="date" class="easyui-datetimebox" data-options="panelHeight:'auto',editable:false"
                style="width: 160px;"></select>
    </div>

    <div style="margin: 0 0 10px 10px;">
        <button type="button" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="width:80px">查询
        </button>
        <button type="button" class="easyui-linkbutton">重置</button>
        <button type="button" class="easyui-linkbutton"> 导出</button>
    </div>

</div>

<table id="redataGril"></table>

</body>
</html>

<script>

    $(function () {

        /*
        ** 变量声明
        */
        var grid,
            todayStartTime,		//今天开始时间，默认从凌晨00:00:00开始
            todayEndTime;		//今天结束时间，默认到第二天凌晨00:00:00结束

        /*
        * 获取当天凌晨00:00:00到第二天凌晨00:00:00
        */
//  	todayStartTime = new Date();
//		todayStartTime.setHours(0);
//		todayStartTime.setMinutes(0);
//		todayStartTime.setSeconds(0);
//		todayStartTime.setMilliseconds(0);
//		todayEndTime = todayStartTime;
//		todayEndTime.setDate(todayStartTime.getDate()+1);

        /*
        * 获取数据
        * startTime : 开始时间
        * endTime : 结束时间
        * key : 搜索关键字
        */
        //function search(startTime,endTime,key){}	//search()函数结束
        grid = $("#redataGril").datagrid({
            fit: true,
            url: path + "/callbuss/findCallBussForPageList?startime=2016-09-06 00:00:00&endtime=2016-09-07 00:00:00&status=-1&ordertype=-1&order=desc&sort=billid&key=",
            fitColumns: true,
            striped: true,
            columns: [
                [
                    {field: 'billid', title: '订单号', width: 100, align: 'center'},
                    {
                        field: 'calltime', title: '电召时间', width: 100, align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            return formattime(value.time);
                        }
                    },
                    {field: 'clientmobile', title: '乘客电话', width: 100, align: 'center', sortable: true},
                    {field: 'srcaddr', title: '起点', width: 100, align: 'center'},
                    {field: 'address', title: '终点', width: 100, align: 'center', sortable: true},
                    {
                        field: 'orderType', title: '订单类型', width: 100, align: 'center', sortable: true,
                        formatter: function (value) {
                            switch (value) {
                                case 0 :
                                    return "app";
                                    break;
                                case 1 :
                                    return "微信";
                                    break;
                                case 2 :
                                    return "电话";
                                    break;
                                default :
                                    return "异常";
                            }
                        }
                    },
                    {
                        field: 'status', title: '状态', width: 100, align: 'center', sortable: true,
                        formatter: function (value) {
                            switch (value) {
                                case 0 :
                                    return "新业务";
                                    break;
                                case 1 :
                                    return "已下呼";
                                    break;
                                case 2 :
                                    return "已租车";
                                    break;
                                case 3 :
                                    return "已取消";
                                    break;
                                case 4 :
                                    return "已完成";
                                    break;
                                default :
                                    return "异常";
                            }
                        }
                    },
                    {field: 'driver', title: '司机名称', width: 100, align: 'center', sortable: true},
                    {field: 'driverphone', title: '司机号码', width: 100, align: 'center', sortable: true},
                    {field: 'carbox', title: '车牌号', width: 100, align: 'center', sortable: true},
                    {field: 'payment', title: '支付方式', width: 100, align: 'center', sortable: true},
                    {field: 'money', title: '交易金额', width: 100, align: 'center', sortable: true},
                    {
                        field: 'evaluate', title: '评价', width: 100, align: 'center', sortable: true,
                        formatter: function (value) {
                            return value + "星";
                        }
                    },
                    {field: 'personnel', title: '调度人员', width: 100, align: 'center', sortable: true}
                ]
            ],
            onLoadSuccess: function (data) {
                ////console.info(data);
            },
            idField: 'billid',
            sortName: 'billid',
            sortOrder: 'desc',
            singleSelect: true,
            pagination: true,
            pageSize: 20,
            pageList: [20, 40, 60, 80],
            rownumbers: true,
            toolbar: '#toolbar'
        });


        /*
        ** 页面打开默认加载当天数据
        */
        //search(todayStartTime,todayEndTime);


    });
</script>
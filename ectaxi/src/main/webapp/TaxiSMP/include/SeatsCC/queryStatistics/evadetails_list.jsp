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

    <!-- childstyle -->
    <link rel="stylesheet" type="text/css" href="../../../public/css/childstyle.css"/>

    <!-- 数据接口路径 -->
    <script src="../../../public/js/path.js"></script>

</head>

<body id="body" class="easyui-layout" data-options="fit:true">

<!-- 数据表格 -->
<table id="redataGril"></table>

<!-- 工具栏 -->
<div id="toolbar">
    <div id="input">
        <span>查询条件</span>
        <input id="key" class="easyui-textbox" prompt="订单号 | 司机姓名 | 车牌号 | 乘客信息" style="width:220px;">
        <span>&nbsp;电召时间</span>
        <input id="startime" class="easyui-datetimebox " data-options="width:160,panelHeight:'auto',editable:false"/>
        <span>至</span>
        <input id="endtime" class="easyui-datetimebox" data-options="width:160,panelHeight:'auto',editable:false"/>
        <span>&nbsp;订单状态</span>
        <select id="status" class="easyui-combobox" data-options="width:80,panelHeight:'auto',editable:false">
            <option value="-1">全部</option>
            <option value="1">已下呼</option>
            <option value="2">已租车</option>
            <option value="3">已取消</option>
            <option value="4">已完成</option>
            <option value="5">附近没车</option>
        </select>
        <span>&nbsp;订单类型</span>
        <select id="ordertype" class="easyui-combobox" data-options="width:80,panelHeight:'auto',editable:false">
            <option value="-1">全部</option>
            <option value="0">app</option>
            <option value="1">微信</option>
            <option value="2">电话</option>
        </select>
    </div>
    <div id="button">
        <button class="easyui-linkbutton" id="search" data-options="iconCls:'icon-search'">查询</button>
        <button class="easyui-linkbutton" id="reset">重置</button>
        <button class="easyui-linkbutton" id="export">导出</button>
    </div>
</div>

</body>
</html>

<script>
    $(function () {

        /*
         ** 变量声明
         */
        var globab_clientId = sessionStorage.clientId;
        var grid,
            todayStartTime = todayTime("start"),		//今天开始时间，默认从凌晨00:00:00开始
            todayEndTime = todayTime("end");		//今天结束时间，默认到第二天凌晨00:00:00结束

        /*
         ** 默认加载
         */
        acquireData(GetDateStr(0), GetDateStr(1), -1, -1, '');

        /*
         ** 查询
         */
        $("#search").on("click", function () {
            var startime = $('#startime').datetimebox("getValue");
            var endtime = $('#endtime').datetimebox("getValue");
            var status = $('#status').combobox("getValue");
            var ordertype = $('#ordertype').combobox("getValue");
            var key = $('#key').textbox("getValue");
            acquireData(startime, endtime, status, ordertype, key);
        });

        /*
         ** 重置
         */
        $("#reset").on("click", function () {
            $('#startime').datetimebox("setValue", "");
            $('#endtime').datetimebox("setValue", "");
            $('#status').combobox("setValue", -1);
            $('#ordertype').combobox("setValue", -1);
            $('#key').textbox("setValue", "");
            acquireData(GetDateStr(0), GetDateStr(1), -1, -1, '');
        });


        /*
         ** 获取数据
         */
        function acquireData(startime, endtime, status, ordertype, key) {

            var DataUrl = "startime=" + startime + "&endtime=" + endtime + "&status=" + status + "&ordertype=" + ordertype + "&order=desc&sort=billid&key=" + key + "&clientid=" + globab_clientId;

            grid = $("#redataGril").datagrid({
                fit: true,
                url: path + "/callbuss/findCallBussForPageList?" + DataUrl,
                method: "get",
                fitColumns: true,
                striped: true,
                columns: [
                    [
                        {field: 'billid', title: '订单号', width: 100, align: 'center'},
                        {
                            field: 'calltime', title: '电召时间', width: 100, align: 'center', sortable: true
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
                        {field: 'drivername', title: '司机名称', width: 100, align: 'center', sortable: true},
                        {field: 'driverphone', title: '司机号码', width: 100, align: 'center', sortable: true},
                        {field: 'carbox', title: '车牌号', width: 100, align: 'center', sortable: true},
                        {field: 'payment', title: '支付方式', width: 100, align: 'center', sortable: true},
                        {field: 'money', title: '交易金额', width: 100, align: 'center', sortable: true},
                        {
                            field: 'evaluate', title: '评价', width: 100, align: 'center', sortable: true,
                            formatter: function (value) {
                                if (value != undefined) {
                                    return value + "星";
                                } else {
                                    return " ";
                                }

                            }
                        },
                        {field: 'personnel', title: '调度人员', width: 100, align: 'center', sortable: true}
                    ]
                ],
//		        onLoadSuccess : function(data){
//		            	////console.info(data);
//		        },
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
        }//function acquireData();结束

    });

    function GetDateStr(AddDayCount) {
        var dd = new Date();
        dd.setDate(dd.getDate() + AddDayCount);//获取AddDayCount天后的日期
        var y = dd.getFullYear();
        var m = (dd.getMonth() + 1) < 10 ? "0" + (dd.getMonth() + 1) : (dd.getMonth() + 1);//获取当前月份的日期，不足10补0
        var d = dd.getDate() < 10 ? "0" + dd.getDate() : dd.getDate(); //获取当前几号，不足10补0
        return y + "-" + m + "-" + d + " 00:00:00";
    }
</script>
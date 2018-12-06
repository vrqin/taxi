<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>电召订单明细</title>

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
    <script src="../../../public/js/utiljavascript.js"></script>
    <script src="../../../public/js/constant.js"></script>


</head>

<body id="body" class="easyui-layout" data-options="fit:true">

<!-- 数据表格 -->
<table id="redataGril"></table>

<!-- 工具栏 -->
<div id="toolbar">
    <div id="input">
        <%--<span>查询条件</span>--%>
        <input id="key" type="hidden" prompt="订单号  | 车牌号 | 乘客电话" style="width:220px">
        <span>&nbsp;电召时间</span>
        <input id="startime" class="easyui-datetimebox " data-options="width:160,panelHeight:'auto',editable:false"/>
        <span>至</span>
        <input id="endtime" class="easyui-datetimebox" data-options="width:160,panelHeight:'auto',editable:false"/>
        <span>&nbsp;订单状态</span>
        <select id="status" class="easyui-combobox" data-options="width:80,panelHeight:'auto',editable:false">
            <option value="-1">全部</option>
            <option value="1">已下呼</option>
            <option value="2">已租车</option>
            <option value="3" selected>已取消</option>
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
        var globab_clientId = sessionStorage.clientId;
        var token = sessionStorage.account;
        var globab_value = "";
        var globab_flag = "";
        var key = '${param.kabnum}';
        /*
        ** 变量声明
        */
        var grid,
            todaystartime = todayTime("start"),		//今天开始时间，默认从凌晨00:00:00开始
            todayEndTime = todayTime("end");		//今天结束时间，默认到第二天凌晨00:00:00结束

        /*
         ** 默认加载
         */
        acquireData(key);
//		$('#startime').datetimebox("setValue",GetDateStr(0));

        /*
         ** 查询
         */
        $("#search").on("click", function () {
            var startime = $('#startime').datetimebox("getValue");
            var endtime = $('#endtime').datetimebox("getValue");
            var status = $('#status').combobox("getValue");
            var ordertype = $('#ordertype').combobox("getValue");
//			var key = $('#key').textbox("getValue");
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
//			$('#key').textbox("setValue","");
            acquireData(GetDateStr(0), GetDateStr(1), -1, -1, '');
        });

        //导出
        $("#export").click(function () {
//			var key = $('#key').textbox("getValue"),
            startime = $("#startime").datetimebox("getValue"),
                endtime = $("#endtime").datetimebox("getValue");
            var status = $('#status').combobox("getValue");
            var ordertype = $('#ordertype').combobox("getValue");
            var dataurl = "startime=" + startime + "&endtime=" + endtime + "&key=" + key + "&token=" + token + "&clientid=" + globab_clientId + "&status=" + status + "&ordertype=" + ordertype;

            window.location.href = path + "/files/exportOrderdetails?" + dataurl;
        });


        /*
         ** 获取数据
         */
        function acquireData(msid) {

            var DataUrl = "kabnum=" + msid;

            grid = $("#redataGril").datagrid({
                fit: true,
                url: path + "/punishmentlog/findPunishmentLogList?" + DataUrl,
                method: "get",
                fitColumns: true,
                striped: true,
                columns: [
                    [
                        {field: 'kabnum', title: '车牌号', width: 150, align: 'center'},
                        {field: 'msid', title: '电话号码', width: 150, align: 'center'},
                        {field: 'handleDatetime', title: '惩罚时间', width: 100, align: 'center'}

//
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
                rownumbers: true
//				toolbar: '#toolbar'
            });
        }//function acquireData();结束

    });

    //查看电召单信息
    function openrelation(data) {
//		////console.info(data);
        var dialog = phm.modalDialog({
            title: '查看电召单信息',
            //width: 可自己设置宽度,
            //height: 可自己设置高度,
            closable: true,
            url: "orderdetails_info.jsp?billid=" + data,
            buttons: [
                {
                    text: '取消',
                    iconCls: 'icon-cancel',
                    handler: function () {
                        dialog.dialog("close");
                    }
                }
            ]
        });
    }


    function GetDateStr(AddDayCount) {
        var dd = new Date();
        dd.setDate(dd.getDate() + AddDayCount);//获取AddDayCount天后的日期
        var y = dd.getFullYear();
        var m = (dd.getMonth() + 1) < 10 ? "0" + (dd.getMonth() + 1) : (dd.getMonth() + 1);//获取当前月份的日期，不足10补0
        var d = dd.getDate() < 10 ? "0" + dd.getDate() : dd.getDate(); //获取当前几号，不足10补0
        return y + "-" + m + "-" + d + " 00:00:00";
    }
</script>
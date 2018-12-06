<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>待处理提现</title>

    <!-- jquery easyui 插件 -->
    <link href="../../../public/jquery-easyui-1.5/themes/metro/easyui.css" rel="stylesheet"/>
    <link href="../../../public/jquery-easyui-1.5/themes/icon.css" rel="stylesheet"/>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.easyui.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/easyui-lang-zh_CN.js"></script>

    <!-- 数据接口路径、共用JS -->
    <script src="../../../public/js/path.js"></script>
    <script src="../../../public/js/constant.js"></script>

    <!-- childstyle -->
    <link rel="stylesheet" type="text/css" href="../../../public/css/childstyle.css"/>

</head>
<body id="body" class="easyui-layout" data-options="fit:true">

<!-- 数据表格 -->
<table id="redataGril"></table>

<!-- 工具栏 -->
<div id="toolbar">
    <div id="input">
        <label>关键字</label>
        <input id="key" class="easyui-textbox" data-options="width:160" prompt="企业名称 | 司机姓名"/>
        <label>&nbsp;提现方式:</label>
        <select id="way" class="easyui-combobox" data-options="width:80,panelHeight:'auto',editable:false">
            <option value="-1">全部</option>
            <option value="0">支付宝</option>
            <option value="1">微信</option>
            <option value="2">信用卡</option>
            <option value="3">储蓄卡</option>
            <option value="4">其它</option>
        </select>
        <!--<label>&nbsp;状态:</label>
        <select id="status" class="easyui-combobox" data-options="width:80,panelHeight:'auto',editable:false">
            <option value="-1">全部</option>
            <option value="0">未处理</option>
            <option value="1">已导出</option>
        </select>-->
        <label>&nbsp;提现时间:</label>
        <input id="begintime" class="easyui-datetimebox" data-options="width:160,editable:false">
        <label>至</label>
        <input id="endtime" class="easyui-datetimebox" data-options="width:160,editable:false">
    </div>
    <div id="button">
        <button class="easyui-linkbutton" id="search" iconCls="icon-search">查询</button>
        <button class="easyui-linkbutton" id="reset">重置</button>
        <button class="easyui-linkbutton" id="export">导出</button>
    </div>
</div>

</body>
</html>

<script>

    $(function () {

        /*
        ** 默认加载
        */
        acquireData('', -1, '', '');

        /*
        ** 查询
        */
        $("#search").on("click", function () {
            var key = $("#key").textbox("getValue");
            var way = $("#way").combobox("getValue");
            var begintime = $("#begintime").datetimebox("getValue");
            var endtime = $("#endtime").datetimebox("getValue");
            acquireData(key, way, begintime, endtime);
        });

        /*
        ** 重置
        */
        $("#reset").on("click", function () {
            $("#key").textbox("setValue", "");
            $("#way").combobox("setValue", "-1");
            $("#begintime").datetimebox("setValue", "");
            $("#endtime").datetimebox("setValue", "");
            acquireData('', -1, '', '');
        });

        /*
        ** 获取数据
        */
        function acquireData(key, way, begintime, endtime) {
            var dataUrl = 'sort=id&order=desc&begintime=' + begintime +
                '&endtime=' + endtime +
                '&key=' + key +
                '&way=' + way +
                '&state=0';
            $("#redataGril").datagrid({
                fit: true,
                url: path + "/withdraw/findWithdrawForPageList?" + dataUrl,
                fitColumns: true,
                striped: true,
                columns: [
                    [
                        {
                            field: 'extracttime', title: '提现时间', width: 100, align: 'center', sortable: true,
                            formatter: function (value) {
                                return formattime(value);
                            }
                        },
                        {field: 'name', title: '司机姓名', width: 100, align: 'center', sortable: true},
                        {field: 'phone', title: '司机电话', width: 100, align: 'center', sortable: true},
                        {field: 'amount', title: '提现金额', width: 100, align: 'center', sortable: true},
                        {
                            field: 'way', title: '提现方式', width: 100, align: 'center', sortable: true,
                            formatter: function (value) {
                                return getValueFromArray(value, waytype);
                            }
                        },
                        {field: 'cashaccount', title: '提现账户', width: 100, align: 'center', sortable: true},
                        {
                            field: 'state', title: '状态', width: 100, align: 'center', sortable: true,
                            formatter: function (value) {
                                if (value == 0) {
                                    return "未处理"
                                }
                            }
                        },
                        {field: 'operating', title: '操作', width: 100, align: 'center', sortable: true},
                    ]
                ],
//	        	onLoadSuccess: function (data) {
//					////console.info(data);
//	        	},
                idField: 'starttime',
                sortName: 'starttime',
                sortOrder: 'desc',
                singleSelect: true,
                pagination: true,
                pageSize: 20,
                pageList: [20, 40, 60, 80],
                rownumbers: true,
                toolbar: '#toolbar'
            });
        }

    });
</script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>乘客充值明细</title>

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
<body id="body" class="easyui-layout" data-options="fit:true">

<!-- 数据表格 -->
<table id="redataGril"></table>

<!-- 工具栏 -->
<div id="toolbar">
    <div id="input">
        <label>关键字</label>
        <input id="key" class="easyui-textbox" data-options="width:160" prompt="乘客姓名 | 手机号码"/>
        <label>&nbsp;充值时间</label>
        <input id="begintime" class="easyui-datetimebox" data-options="width:160, editable:false">
        <label>至</label>
        <input id="endtime" class="easyui-datetimebox" data-options="width:160, editable:false">
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
        acquireData('', '', '');

        /*
        ** 查询
        */
        $("#search").on("click", function () {
            var begintime = $("#begintime").datetimebox("getValue");
            var endtime = $("#endtime").datetimebox("getValue");
            var key = $("#key").textbox("getValue");
            acquireData(begintime, endtime, key);
        });

        /*
        ** 重置
        */
        $("#reset").on("click", function () {
            $("#begintime").datetimebox("setValue", "");
            $("#endtime").datetimebox("setValue", "");
            $("#key").textbox("setValue", "");
            acquireData('', '', '');
        });

        /*
        ** 获取数据
        */
        function acquireData(begintime, endtime, key) {
            var dataUrl = "sort=id&order=desc&begintime=" + begintime +
                "&endtime=" + endtime +
                "&key=" + key + "&type=-1";
            $("#redataGril").datagrid({
                fit: true,
                url: path + "/passengerTopupDetail/findPassengerTopupDetailForPageList?" + dataUrl,
                fitColumns: true,
                striped: true,
                columns: [
                    [
                        {field: 'phone', title: '手机号码', width: 100, align: 'center', sortable: true},
                        {field: 'name', title: '乘客姓名', width: 100, align: 'center', sortable: true},
                        {field: 'money', title: '充值金额', width: 100, align: 'center', sortable: true},
                        {
                            field: 'topuptime', title: '充值时间', width: 100, align: 'center', sortable: true,
                            formatter: function (value) {
                                return formattime(value);
                            }
                        },
                        {
                            field: 'stute', title: '支付状态', width: 100, align: 'center', sortable: true,
                            formatter: function (value) {
                                switch (value) {
                                    case 0:
                                        return "已支付";
                                        break;
                                }
                            }
                        },
                        {
                            field: 'type', title: '充值方式', width: 100, align: 'center', sortable: true,
                            formatter: function (value) {
                                switch (value) {
                                    case 0:
                                        return "微信";
                                        break;
                                    case 1:
                                        return "支付宝";
                                        break;
                                }
                            }
                        },
                    ]
                ],
                //          onLoadSuccess: function (data) {
                //				////console.info(data);
                //          },
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
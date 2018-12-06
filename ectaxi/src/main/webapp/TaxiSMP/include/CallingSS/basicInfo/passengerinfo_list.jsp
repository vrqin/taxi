<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>乘客信息</title>

    <!-- jquery easyui 插件 -->
    <link href="../../../public/jquery-easyui-1.5/themes/metro/easyui.css" rel="stylesheet"/>
    <link href="../../../public/jquery-easyui-1.5/themes/icon.css" rel="stylesheet"/>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.easyui.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/easyui-lang-zh_CN.js"></script>

    <!-- childstyle -->
    <link rel="stylesheet" type="text/css" href="../../../public/css/childstyle.css"/>

    <!-- 数据接口路径、共用JS -->
    <script src="../../../public/js/path.js"></script>
    <script src="../../../public/js/constant.js"></script>

</head>

<body id="body" class="easyui-layout" data-options="fit:true">

<!-- 数据表格 -->
<table id="redataGril"></table>

<!-- 工具栏 -->
<div id="toolbar">
    <div id="input">
        <span>关键字</span>
        <input id="key" class="easyui-textbox" data-options="width:160" prompt="乘客姓名 | 联系电话">
        <span>&nbsp;注册时间</span>
        <input id="starttime" class="easyui-datetimebox" data-options="width:160,panelHeight:'auto',editable:false"/>
        <span>至</span>
        <input id="endtime" class="easyui-datetimebox" data-options="width:160,panelHeight:'auto',editable:false"/>
    </div>
    <div id="button">
        <button class="easyui-linkbutton" id="search" iconCls='icon-search'>查询</button>
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
        var grid;
        var token = sessionStorage.account;
        var clientid = sessionStorage.clientId;
        /*
        ** 默认加载
        */
        acquireData('', '', '');

        /*
        ** 查询
        */
        $("#search").on("click", function () {
            var key = $('#key').textbox("getValue"),
                starttime = $("#starttime").datetimebox("getValue"),
                endtime = $("#endtime").datetimebox("getValue");
            acquireData(starttime, endtime, key);
        });

        /*
        ** 重置
        */
        $("#reset").on("click", function () {
            $("#key").textbox("setValue", "");
            $("#starttime").datetimebox("setValue", "");
            $("#endtime").datetimebox("setValue", "");
            acquireData('', '', '');
        });


        //导出
        $("#export").click(function () {
            var key = $('#key').textbox("getValue"),
                starttime = $("#starttime").datetimebox("getValue"),
                endtime = $("#endtime").datetimebox("getValue");
            var dataurl = "starttime=" + starttime + "&endtime=" + endtime + "&key=" + key + "&token=" + token + "&clientid=" + clientid;

            window.location.href = path + "/files/exportPassengerInfo?" + dataurl;
        });

        /*
        ** 获取数据
        */
        function acquireData(startime, endtime, key) {

            var dataUrl = "startime=" + startime +
                "&endtime=" + endtime +
                "&token=" + token +
                "&type=0&order=desc&sort=createdate&key=" + key;
            grid = $("#redataGril").datagrid({
                fit: true,
                url: path + "/passenger/findPassengerForPageList?" + dataUrl,
                fitColumns: true,
                method: "get",
                striped: true,
                columns: [
                    [
                        {field: 'name', title: '乘客姓名', width: 100, align: 'center'},
                        {field: 'mobile', title: '联系电话', width: 100, align: 'center'},
                        {field: 'opruser', title: '登录帐号', width: 100, align: 'center'},
                        {
                            field: 'sex', title: '性别', width: 100, align: 'center',
                            formatter: function (value) {
                                if (value !== "" && value !== null && value !== undefined) {
                                    return getValueFromArray(value, sexvalue);
                                } else {
                                    return "";
                                }

                            }
                        },
                        {field: 'createdate', title: '注册时间', width: 100, align: 'center', sortable: true},
                        {
                            field: 'islock', title: '是否锁定', width: 100, align: 'center', sortable: true,
                            formatter: function (value) {
                                if (value != "" || value != undefined) {
                                    return getValueFromArray(value, isvalue);
                                } else {
                                    return "";
                                }
                            },
                            styler: function (value) {
                                if (value == 1) {
                                    return "color:red;";
                                }
                            }
                        }
                    ]
                ],
                onLoadSuccess: function (data) {
//	          	////console.info(data);
                },
                idField: 'mobile',
                sortName: 'mobile',
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
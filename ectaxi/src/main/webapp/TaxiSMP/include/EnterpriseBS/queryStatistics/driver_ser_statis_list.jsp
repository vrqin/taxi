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

    <!-- jquery easyui 插件 -->
    <link href="../../../public/jquery-easyui-1.5/themes/metro/easyui.css" rel="stylesheet"/>
    <link href="../../../public/jquery-easyui-1.5/themes/icon.css" rel="stylesheet"/>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.easyui.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/easyui-lang-zh_CN.js"></script>

    <!-- 数据接口路径、共用JS -->
    <script src="../../../public/js/path.js"></script>
    <script src="../../../public/js/utiljavascript.js"></script>
    <!-- childstyle -->
    <link rel="stylesheet" type="text/css" href="../../../public/css/childstyle.css"/>
    <style>

    </style>
</head>
<body id="body" class="easyui-layout" data-options="fit:true">

<!-- 数据表格 -->
<table id="redataGril"></table>

<!-- 工具栏 -->
<div id="toolbar">
    <div id="input">
        <label>关键字</label>
        <input id="key" class="easyui-textbox" style="width:160px;" prompt="帐号 | 姓名">
    </div>
    <div id="button">
        <button id="search" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</button>
        <button id="reset" class="easyui-linkbutton">重置</button>
        <button class="easyui-linkbutton" id="add">添加</button>
        <button class="easyui-linkbutton" id="modify">修改</button>
        <button class="easyui-linkbutton" id="delete">删除</button>

    </div>
</div>

</body>
</html>

<script>
    /*
     ** 声明
     */
    var grid;
    var token = sessionStorage.account;
    var globab_clientId = sessionStorage.clientId;
    var globab_start;
    var globab_end;
    $(function () {

        if (globab_clientId == 0) {

        }

        /*
         ** 默认加载
         */
        acquireData('');

        /*
         ** 查询
         */
        $("#search").on("click", function () {
            var key = $("#key").textbox("getValue");
            acquireData(key);
        });

        /*
         ** 重置
         */
        $("#reset").on("click", function () {
            $("#key").textbox("setValue", "");
            acquireData('');
        });


        /*
         ** 获取数据
         */
        function acquireData(key) {
            var dataUrl = 'sort=evaluationnum&order=desc&begintime=&endtime=&key=' + key + "&clientid=" + globab_clientId;
            grid = $("#redataGril").datagrid({
                fit: true,
                url: path + "/driverSerStatis/findDriverSerStatisForPageList?" + dataUrl,
                fitColumns: true,
                striped: true,
                columns: [
                    [
                        {field: 'account', title: '司机名称', width: 100, align: 'center', sortable: true},
                        {field: 'company', title: '所属公司', width: 100, align: 'center', sortable: true},
                        {
                            field: 'evaluationnum', title: '总评价数', width: 100, align: 'center', sortable: true,
                            formatter: function (value, row, index) {

                                if (value > 0) {
                                    var codes = row["msid"];
                                    return '<span class="openrelation" onclick="openrelation(id)" id=' + codes + '>' + value + '</span>';
                                } else {
                                    return value;
                                }

                            }
                        },
                        {field: 'kabnum', title: '车牌号', width: 100, align: 'center', sortable: true},
                        {field: 'nostarnum', title: '未评价次数', width: 100, align: 'center', sortable: true},
                        {field: 'starnum_1', title: '1星次数', width: 100, align: 'center', sortable: true},
                        {field: 'starnum_2', title: '2星次数', width: 100, align: 'center', sortable: true},
                        {field: 'starnum_3', title: '3星次数', width: 100, align: 'center', sortable: true},
                        {field: 'starnum_4', title: '4星次数', width: 100, align: 'center', sortable: true},
                        {field: 'starnum_5', title: '5星次数', width: 100, align: 'center', sortable: true}


                    ]
                ],
                onLoadSuccess: function (data) {
//                    console.info(data);
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
        }

    });

    //查看电召单信息
    function openrelation(data) {
        console.info("data:" + data);
        var dialog = phm.modalDialog({
            title: '查看电召单信息',
            width: 900,
            height: 580,
            closable: true,
            url: "driver_ser_statis_info.jsp?msid=" + data + "&startime=" + globab_start + "&endtime=" + globab_end,
            buttons: [
                {
                    text: '关闭',
                    iconCls: 'icon-cancel',
                    handler: function () {
                        dialog.dialog("close");
                    }
                }
            ]
        });
    }

</script>
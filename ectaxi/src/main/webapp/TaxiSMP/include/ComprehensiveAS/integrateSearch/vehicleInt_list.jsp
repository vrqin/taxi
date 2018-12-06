<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>车辆综合查询</title>

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

</head>
<body id="body" class="easyui-layout" data-options="fit:true">

<!-- 数据表格 -->
<table id="redataGril"></table>

<!-- 工具栏 -->
<div id="toolbar">
    <div id="input">
        <label>关键字</label>
        <input id="key" class="easyui-textbox" data-options="width:160" prompt="企业名称 | 车牌号码">
        <!--<label>&nbsp;时间</label>
        <input id="begintime" class="easyui-datetimebox" data-options="width:160,editable:false"/>
        <label>至</label>
        <input id="endtime" class="easyui-datetimebox" data-options="width:160,editable:false"/>-->
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
        ** 变量声明
        */
        var grid;
        var globab_clientId = sessionStorage.clientId;

        /*
        ** 默认加载
        */
        acquireData('');

        /*
        ** 查询
        */
        $("#search").on("click", function () {
            var key = $("#key").textbox("getValue");
            //var begintime = $("#begintime").datetimebox("getValue");
            //var endtime = $("#endtime").datetimebox("getValue");
            acquireData(key);
        });

        /*
        ** 重置
        */
        $("#reset").on("click", function () {
            $("#key").textbox("setValue", "");
            //$("#begintime").datetimebox("setValue","");
            //$("#endtime").datetimebox("setValue","");
            acquireData('');
        });

        /*
        ** 获取数据
        */
        function acquireData(key) {
            var dataUrl = "sort=totalincome&order=desc&begintime=&endtime=&key=" + key + "&clientid=" + globab_clientId;
            grid = $("#redataGril").datagrid({
                fit: true,
                url: path + "/carIntegratedQuery/findCarIntegratedQueryForPageList?" + dataUrl,
                fitColumns: true,
                striped: true,
                columns: [
                    [
                        {field: 'kabnum', title: '车牌号码', width: 100, align: 'center', sortable: true},
                        {field: 'company', title: '所属企业', width: 100, align: 'center', sortable: true},
                        {field: 'totalincome', title: '总收入', width: 100, align: 'center'},
                        {field: 'dayincome', title: '日均收入', width: 100, align: 'center'},
                        {
                            field: 'totaltime', title: '总时长', width: 100, align: 'center',
                            formatter: function (value, row, index) {
                                if (value > 0) {
                                    return formatSeconds(value);
                                } else {
                                    return 0;
                                }
                            }
                        },
                        {
                            field: 'daytime', title: '日均时长', width: 100, align: 'center',
                            formatter: function (value, row, index) {
                                if (value > 0) {
                                    return formatSeconds(value);
                                } else {
                                    return 0;
                                }
                            }
                        },
                        {field: 'totalope', title: '总营运次数', width: 100, align: 'center', sortable: true},
                        {field: 'dayope', title: '日均营运次数', width: 100, align: 'center', sortable: true},
                        {field: 'totalcalling', title: '电召总数', width: 100, align: 'center', sortable: true},
                        {field: 'succalling', title: '电召成功数', width: 100, align: 'center', sortable: true},
                        {field: 'pascancalling', title: '电召乘客取消', width: 100, align: 'center', sortable: true},
                        {field: 'dricancalling', title: '电召司机取消', width: 100, align: 'center', sortable: true}
                    ]
                ],
                //          onLoadSuccess: function (data) {
                //				////console.info(data);
                //          },
                idField: 'enterpriseName',
                sortName: 'enterpriseName',
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
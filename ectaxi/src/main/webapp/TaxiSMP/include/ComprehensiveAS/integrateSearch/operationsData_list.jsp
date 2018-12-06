<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>运营数据查询</title>

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
        <input id="key" class="easyui-textbox" data-options="width:200" prompt="企业名称 | 车牌号码 | 驾驶员名称">
        <!--<label>&nbsp;时间:</label>
        <input class="easyui-datetimebox"/>
        <label>至</label>
        <input class="easyui-datetimebox"/>-->
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
            var dataUrl = "sort=id&order=desc&begintime=&endtime=&key=" + key;
            grid = $("#redataGril").datagrid({
                fit: true,
                url: path + "/operatDetails/findOperatDetailsForPageList?" + dataUrl,
                fitColumns: true,
                striped: true,
                columns: [
                    [
                        {field: 'account', title: '驾驶员', width: 100, align: 'center', sortable: true},
                        {field: 'kabnum', title: '车牌号码', width: 100, align: 'center', sortable: true},
                        {field: 'enterprise', title: '所属企业', width: 100, align: 'center', sortable: true},
                        {field: 'getontime', title: '上车时间', width: 100, align: 'center'},
                        {field: 'getofftime', title: '下车时间', width: 100, align: 'center'},
                        {
                            field: 'passmile', title: '运营里程', width: 100, align: 'center',
                            formatter: function (value) {
                                return value + "公里";
                            }
                        },
                        {
                            field: 'amount', title: '运营收入', width: 100, align: 'center', sortable: true,
                            formatter: function (value) {
                                return value + "元";
                            }
                        },
                        {
                            field: 'evaluation', title: '服务评价', width: 100, align: 'center', sortable: true,
                            formatter: function (value) {
                                switch (value) {
                                    case 1:
                                        return "一星";
                                        break;
                                    case 2:
                                        return "二星";
                                        break;
                                    case 3:
                                        return "三星";
                                        break;
                                    case 4:
                                        return "四星";
                                        break;
                                    case 5:
                                        return "五星";
                                        break;
                                }
                            }
                        }
                    ]
                ],
//	        	onLoadSuccess: function (data) {
//					////console.info(data);
//	        	},
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
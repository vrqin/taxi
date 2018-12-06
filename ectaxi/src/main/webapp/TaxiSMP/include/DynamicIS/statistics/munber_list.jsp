<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>违章数量统计</title>

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
        <label>违章日期</label>
        <input id="begintime" class="easyui-datebox" data-options="width:160, editable:false">
        <label>至</label>
        <input id="endtime" class="easyui-datebox" data-options="width:160, editable:false">
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
        acquireData('', '');

        /*
        ** 查询
        */
        $("#search").click(function () {
            var begintime = $("#begintime").datebox("getValue");
            var endtime = $("#endtime").datebox("getValue");
            acquireData(begintime, endtime);
        });

        /*
         ** 重置
         */
        $("#reset").on("click", function () {
            $("#begintime").datebox("setValue", "");
            $("#endtime").datebox("setValue", "");
            acquireData('', '');
        });

        /*
        ** 获取数据
        */
        function acquireData(begintime, endtime) {
            var dataUrl = "sort=id&order=desc&begintime=" + begintime +
                "&endtime=" + endtime +
                "&key=&illegaltype=-1";
            $("#redataGril").datagrid({
                fit: true,
                url: path + "/illegalNumStatistics/findIllegalNumStatisticsForPageList?" + dataUrl,
                fitColumns: true,
                striped: true,
                columns: [
                    [
                        {field: 'illtime', title: '违章时间', width: 100, align: 'center', sortable: true},
                        {
                            field: 'illegaltype', title: '违章类型', width: 100, align: 'center',
                            formatter: function (value) {
                                switch (value) {
                                    case 0:
                                        return "报废车辆";
                                        break;
                                    case 1:
                                        return "未年检车辆";
                                        break;
                                    case 2:
                                        return "未年审车辆";
                                        break;
                                    case 3:
                                        return "套牌车辆";
                                        break;
                                    case 4:
                                        return "黑的";
                                        break;
                                    case 5:
                                        return "其它";
                                        break;
                                }
                            }
                        },
                        {field: 'illegalnum', title: '违章次数', width: 100, align: 'center', sortable: true},
                    ]
                ],
	        	onLoadSuccess: function (data) {
					console.info(data);
	        	},
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
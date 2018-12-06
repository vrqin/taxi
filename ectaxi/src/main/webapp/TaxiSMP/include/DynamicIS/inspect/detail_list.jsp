<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>稽查异常明细</title>

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
        <input id="key" class="easyui-textbox" data-options="width:260" prompt="稽查区域 | 驾驶人姓名 | 所属公司 | 车牌号码">
        <label>&nbsp;稽查异常类型:</label>
        <select id="type" class="easyui-combobox" data-options="panelHeight:'auto'">
            <option value="-1">全部</option>
            <option value="0">报废车辆</option>
            <option value="1">未年检车辆</option>
            <option value="2">未年审车辆</option>
            <option value="3">套牌车辆</option>
            <option value="4">黑的</option>
            <option value="5">其它</option>
        </select>
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
        acquireData('', -1);

        /*
        ** 查询
        */
        $("#search").click(function () {
            var key = $("#key").textbox("getValue");
            var type = $("#type").combobox("getValue");
            acquireData(key, type);
        });

        /*
         ** 重置
         */
        $("#reset").on("click", function () {
            $("#key").textbox("setValue", "");
            $("#type").combobox("setValue", '-1');
            acquireData('', -1);
        });

        /*
        ** 获取数据
        */
        function acquireData(key, type) {
            var dataUrl = "sort=id&order=desc&begintime=&endtime=&key=" + key +
                "&type=" + type;
            $("#redataGril").datagrid({
                fit: true,
                url: path + "/auditExceptionDetails/findAuditExceptionDetailsForPageList?" + dataUrl,
                fitColumns: true,
                striped: true,
                columns: [
                    [
                        {field: 'name', title: '驾驶员姓名', width: 100, align: 'center'},
                        {field: 'licenseid', title: '驾驶证号', width: 100, align: 'center'},
                        {field: 'kabnum', title: '车牌号码', width: 100, align: 'center'},
                        {field: 'btime', title: '违章时间', width: 100, align: 'center'},
                        //                  {field: 'area', title: '轨迹查询', width: 100, align: 'center'},
                        {field: 'area', title: '稽查区域', width: 100, align: 'center'},
                        {field: 'starttime', title: '稽查开始时间', width: 100, align: 'center'},
                        {field: 'endtime', title: '稽查结束时间', width: 100, align: 'center'},
                        {field: 'peoper', title: '稽查人员', width: 100, align: 'center'},
                        {field: 'company', title: '所属公司', width: 100, align: 'center'},
                        {field: 'transcard', title: '运输证号', width: 100, align: 'center'},
                        {
                            field: 'type', title: '稽查异常类型', width: 100, align: 'center',
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
                        {field: 'remark', title: '处理备注', width: 100, align: 'center'},
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
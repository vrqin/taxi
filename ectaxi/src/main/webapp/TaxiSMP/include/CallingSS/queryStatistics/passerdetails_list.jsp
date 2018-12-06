<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>乘客电召统计</title>

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
        <%--<span>关键字</span>--%>
        <%--<input id="key" class="easyui-textbox"  style="width:160px;" prompt="姓名 | 联系电话">--%>
        <span>&nbsp;开始时间</span>
        <input id="startime" class="easyui-datetimebox " data-options="width:160,panelHeight:'auto',editable:false"/>
        <span>至</span>
        <input id="endtime" class="easyui-datetimebox" data-options="width:160,panelHeight:'auto',editable:false"/>
    </div>
    <div id="button">
        <button class="easyui-linkbutton" id="search" iconCls="icon-search">查询</button>
        <button class="easyui-linkbutton" id="reset">重置</button>
        <button class="easyui-linkbutton" id="export">导出</button>
        <%--<button class="easyui-linkbutton" id="isblack" >添加黑名单</button>--%>
    </div>
</div>

</body>
</html>

<script>
    var token = sessionStorage.account;
    var clientid = sessionStorage.clientId;
    $(function () {

        /*
        ** 变量声明
        */
        var grid;
        /*
         ** 默认加载
         */
        $('#startime').datetimebox("setValue", GetDateStr(0));
        $('#endtime').datetimebox("setValue", GetDateStr(1));
        acquireData(GetDateStr(0), GetDateStr(1), '');

        /*
         ** 查询
         */
        $("#search").on("click", function () {
//			var key = $('#key').textbox('getValue');
            var key = "";
            var startime = $('#startime').datetimebox('getValue');
            var endtime = $('#endtime').datetimebox('getValue');
            acquireData(startime, endtime, key);
        });

        /*
         ** 重置
         */
        $("#reset").on("click", function () {
            $('#key').textbox("setValue", "");
            $('#startime').datetimebox("setValue", GetDateStr(0));
            $('#endtime').datetimebox("setValue", GetDateStr(1));
            acquireData(GetDateStr(0), GetDateStr(1), '');
        });

        //导出
        $("#export").click(function () {
//			var key = $('#key').textbox("getValue");
            var key = "";
            var startime = $('#startime').datetimebox('getValue');
            var endtime = $('#endtime').datetimebox('getValue');
            var dataurl = "startime=" + startime + "&endtime=" + endtime + "&key=" + key + "&token=" + token + "&clientid=" + clientid;

            window.location.href = path + "/files/exportPasserInfo?" + dataurl;
        });

        /*
        ** 获取数据
        */
        function acquireData(startime, endtime, key) {
            if (startime == "" || endtime == "") {
                alert("查询开始时间和结束不能为空！");
                return;
            }
            var dataUrl = "startime=" + startime +
                "&endtime=" + endtime +
                "&order=desc&sort=opruser&key=" + key + "&token=" + token;
            grid = $("#redataGril").datagrid({
                fit: true,
                url: path + "/callbuss/passercallbussdetails?" + dataUrl,
                fitColumns: true,
                striped: true,
                columns: [
                    [
                        {field: 'opruser', title: '帐号', width: 100, align: 'center'},
//						{field: 'name', title: '坐席人员名称', width: 100, align: 'center', sortable: true},
                        {field: 'total', title: '总电召单数', width: 100, align: 'center', sortable: true},
                        {field: 'unfinish', title: '电召未完成', width: 100, align: 'center', sortable: true},
                        {field: 'cancellation', title: '取消次数', width: 100, align: 'center', sortable: true},
                        {field: 'finish', title: '电召成功数', width: 100, align: 'center', sortable: true}

                    ]
                ],
                onLoadSuccess: function (data) {
                    //console.info(data);
                },
                idField: 'opruser',
                sortName: 'opruser',
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
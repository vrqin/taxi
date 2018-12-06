<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>短信日志</title>

    <!-- jquery easyui 插件 -->
    <link href="../../../public/jquery-easyui-1.5/themes/metro/easyui.css" rel="stylesheet"/>
    <link href="../../../public/jquery-easyui-1.5/themes/icon.css" rel="stylesheet"/>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.easyui.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/easyui-lang-zh_CN.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/datagrid-scrollview.js"></script>
    <!-- childstyle -->
    <link rel="stylesheet" type="text/css" href="../../../public/css/childstyle.css"/>

    <!-- 数据接口路径、共用JS -->
    <script src="../../../public/js/path.js"></script>
    <style>
        #message {
            margin-left: 100px;
        }
    </style>
</head>
<body id="body" class="easyui-layout" data-options="fit:true">

<!-- 数据表格 -->
<table id="redataGril"></table>

<!-- 工具栏 -->
<div id="toolbar">
    <div id="input">
        <label>发送手机号码</label>
        <input id="key" class="easyui-textbox" style="width:160px;">
        <span>&nbsp;状态</span>
        <%--<select  id ="status" class="easyui-combobox" data-options="width:80,panelHeight:'auto',editable:false">--%>
        <%--<option value="-1">全部</option>--%>
        <%--<option value="1">已读</option>--%>
        <%--<option value="0">未读</option>--%>
        <%--</select>--%>
        <span>&nbsp;发送时间</span>
        <input id="startime" class="easyui-datetimebox " data-options="width:160,panelHeight:'auto',editable:false"/>
        <span>至</span>
        <input id="endtime" class="easyui-datetimebox" data-options="width:160,panelHeight:'auto',editable:false"/>
    </div>
    <div id="button">
        <button class="easyui-linkbutton" id="search" data-options="iconCls:'icon-search'">查询</button>
        <button class="easyui-linkbutton" id="reset">重置</button>
        <span id="message">剩余短信数：<strong id="messagenum">0 </strong> 条</span>
    </div>

</div>

</body>
</html>

<script>
    var token = sessionStorage.account;
    var globab_clientId = sessionStorage.clientId;
    $(function () {

        /*
        ** 变量声明
        */
        var grid;

        var clientid = sessionStorage.clientId;


        acquireData("", "", "");

        if (globab_clientId != 0) {
            smsmage();
        }

        /*
         ** 查询
         */
        $("#search").on("click", function () {
            var key = $("#key").textbox("getValue");
            var startime = $("#startime").datetimebox("getValue");
            var endtime = $("#endtime").datetimebox("getValue");
            //var status  = $("#status").combobox("getValue");
            alert(key);
            acquireData(startime, endtime, key)
        });

        /*
         ** 重置
         */
        $("#reset").on("click", function () {
            $("#key").textbox("setValue", "");
            $("#startime").textbox("setValue", "");
            $("#endtime").textbox("setValue", "");
            acquireData("", "", "")
        });

        /*
        ** 获取数据
        */
        function acquireData(startime, endtime, key) {

            grid = $("#redataGril").datagrid({
                fit: true,
                url: path + "/logsmsdiary/findLogSMSDiaryForPageList?startime=" + startime + "&endtime=" + endtime + "&status=&order=desc&sort=id&key=" + key + "&clientid=" + clientid,
                fitColumns: true,
                striped: true,
                columns: [
                    [
                        {field: 'phone', title: '发送手机号码', width: 100, align: 'center'},
                        {
                            field: 'sendtime', title: '发送时间', width: 150, align: 'center', sortable: true
                        },
                        {field: 'content', title: '短信内容', width: 600, align: 'center'}
                    ]
                ],
                onLoadSuccess: function (data) {
                    ////console.info(data);
                },
                detailFormatter: function (rowIndex, rowData) {
//          		console.info(rowData);
                    return '<table><tr>' +
                        '<td style="border:1px;padding-right:10px">' +
                        '<p>公告内容: ' + rowData.content + '</p>' +
                        '</td>' +
                        '</tr></table>';
                },
                view: scrollview,
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

        function smsmage() {
            $.ajax({
                url: path + '/clientSetting/findClientSettingByid?id=' + globab_clientId,
                dataType: 'json',
                type: "POST",
                async: false,
                success: function (data) {
//                    console.info(data);
                    if (data != "" && data != null) {
                        $("#messagenum").html(data.messagenum);

                    }
                }

            });
        }
    });
</script>
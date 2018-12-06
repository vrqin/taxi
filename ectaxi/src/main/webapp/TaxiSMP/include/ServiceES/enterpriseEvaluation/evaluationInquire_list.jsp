<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>考评查询</title>

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
    <script src="../../../public/js/utiljavascript.js"></script>


</head>
<body id="body" class="easyui-layout" data-options="fit:true">

<!-- 数据表格 -->
<table id="redataGril"></table>

<!-- 工具栏 -->
<div id="toolbar">
    <div id="input">
        <span>关键字</span>
        <input id="key" class="easyui-textbox" data-options="width:160" prompt="企业名称 | 考评版本">
        <span>&nbsp;考评等级</span>
        <input id="level" class="easyui-combobox"
               data-options="width:60,panelHeight:'auto',editable:false,valueField: 'value',textField: 'label',data: [{label: '全部',value: '-1',selected:true},{label: 'A',value: '0'},{label: 'B',value: '1'},{label: 'C',value: '2'},]"/>
        <span>&nbsp;考评时间</span>
        <input id="begintime" class="easyui-datetimebox" data-options="width:160,editable:false"/>
        <span>至</span>
        <input id="endtime" class="easyui-datetimebox" data-options="width:160,editable:false"/>
    </div>
    <div id="button">
        <button class="easyui-linkbutton" id="search" iconCls="icon-search">查询</button>
        <button class="easyui-linkbutton" id="reset">重置</button>
        <button class="easyui-linkbutton" id="export">导出</button>
        <button class="easyui-linkbutton" id="add">添加</button>
        <button class="easyui-linkbutton" id="modify">修改</button>
        <button class="easyui-linkbutton" id="delete">删除</button>
    </div>
</div>

</body>
</html>

<script>
    var token = sessionStorage.account;
    $(function () {

        /*
        ** 变量声明
        */
        var grid;

        /*
        ** 默认加载
        */
        acquireData('', '-1', '', '');

        /*
        ** 查询
        */
        $("#search").on("click", function () {
            var key = $("#key").textbox("getValue");
            var level = $("#level").combobox("getValue");
            var begintime = $("#begintime").datetimebox("getValue");
            var endtime = $("#endtime").datetimebox("getValue");
            acquireData(key, level, begintime, endtime);
        });

        /*
        ** 重置
        */
        $("#reset").on("click", function () {
            $("#key").textbox("setValue", "");
            $("#level").combobox("setValue", "-1");
            $("#begintime").datetimebox("setValue", "");
            $("#endtime").datetimebox("setValue", "");
            acquireData('', '', '', '');
        });

        /*
         ** 添加
         */
        $("#add").click(function () {

            var dialog = phm.modalDialog({
                title: '添加',
                width: 900,
                height: 450,
                closable: true,
                url: "evaluationInquire_add.jsp?id=0",
                buttons: [
                    {
                        text: '提交',
                        iconCls: 'icon-save',
                        handler: function () {
                            dialog.find('iframe').get(0).contentWindow.completedForm(dialog, grid, parent.$);
                        }
                    },
                    {
                        text: '取消',
                        iconCls: 'icon-cancel',
                        handler: function () {
                            dialog.dialog("close");
                        }
                    }
                ]
            });
        });

        /*
         ** 修改
         */
        $("#modify").click(function () {
            var row = grid.datagrid("getSelected");

            if (row == null) {
                $.messager.alert('警告', "请选择要修改的记录", 'info');
                return;
            }
            var dialog = phm.modalDialog({
                title: '修改',
                width: 900,
                height: 450,
                closable: true,
                url: "evaluationInquire_add.jsp?id=" + row.id + "&type=1",
                buttons: [
                    {
                        text: '保存',
                        iconCls: 'icon-save',
                        handler: function () {
                            dialog.find('iframe').get(0).contentWindow.completedForm(dialog, grid, parent.$);
                        }
                    },
                    {
                        text: '关闭',
                        iconCls: 'icon-cancel',
                        handler: function () {
                            dialog.dialog("close");
                        }
                    }
                ]

            });
        });

        /*
         ** 删除
         */
        $("#delete").click(function () {
            var row = grid.datagrid("getSelected");
            if (row == null) {
                $.messager.alert('警告', "选择删除的记录", 'info');
                return;
            }
            $.messager.confirm('确认', '您确认想要删除记录吗？', function (r) {
                if (r) {

                    var requestURL = path + "/enterpriseEvaluationQuery/delEnterpriseEvaluationQueryByid?id=" + row.id + "&token=" + token;

                    $.ajax({
                        type: "DELETE",
                        url: requestURL,
                        async: false,
                        dataType: "json", //后台返回值类型
                        success: function (data) {
                            if (data.desc.indexOf("成功") > -1) {
                                grid.datagrid("reload");
                                grid.datagrid("clearSelections");
                                $.messager.show({
                                    title: '提示',
                                    msg: "删除成功！",
                                    timeout: 3000,
                                    showType: 'slide'
                                });
                            } else {
                                $.messager.alert("错误", data.desc, "error");
                            }
                        }
                    });

                }
            });
        });


        /*
        ** 获取数据
        */
        function acquireData(key, level, begintime, endtime) {
            var dataUrl = "sort=id&order=desc&begintime=" + begintime +
                "&endtime=" + endtime +
                "&evaluationlevel=" + level +
                "&key=" + key;
            grid = $("#redataGril").datagrid({
                fit: true,
                url: path + "/enterpriseEvaluationQuery/findEnterpriseEvaluationQueryForPageList?" + dataUrl,
                fitColumns: true,
                striped: true,
                columns: [
                    [
                        {field: 'enterprisename', title: '企业名称', width: 100, align: 'center', sortable: true},
                        {field: 'evaluationyears', title: '考评年度', width: 100, align: 'center', sortable: true},
                        {field: 'evaluationversion', title: '考评版本', width: 100, align: 'center'},
                        {
                            field: 'evaluationlevel', title: '考评等级', width: 100, align: 'center',
                            formatter: function (value) {
                                switch (value) {
                                    case 0:
                                        return "A";
                                        break;
                                    case 1:
                                        return "B";
                                        break;
                                    case 2:
                                        return "C";
                                        break;
                                }
                            }
                        },
                        {field: 'achievement', title: '总得分', width: 100, align: 'center'},
                        {field: 'evaluationtime', title: '考评时间', width: 100, align: 'center', sortable: true},
                        {field: 'achievementdet', title: '得分详细', width: 100, align: 'center', sortable: true}
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
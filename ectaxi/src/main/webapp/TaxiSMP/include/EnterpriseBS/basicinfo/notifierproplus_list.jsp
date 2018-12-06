<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>消息通知</title>

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
    <script src="../../../public/js/utiljavascript.js"></script>
    <style>
        .openrelation {
            color: red;
        }
    </style>
</head>
<body id="body" class="easyui-layout" data-options="fit:true">

<!-- 数据表格 -->
<table id="redataGril"></table>

<!-- 工具栏 -->
<div id="toolbar">
    <div id="input">
        <label>消息查询:</label>
        <input id="key" class="easyui-textbox" data-options="width:180" prompt=" 班别名称 ">

    </div>
    <div id="button">
        <button class="easyui-linkbutton" id="search" iconCls="icon-search">查询</button>
        <button class="easyui-linkbutton" id="reset">重置</button>
        <button class="easyui-linkbutton" id="add">发布消息</button>
        <button class="easyui-linkbutton" id="modify">修改消息</button>
        <button class="easyui-linkbutton" id="delete">删除消息</button>
        <%--<button class="easyui-linkbutton" id="history" >发布记录</button>--%>

    </div>
</div>


</body>
</html>

<script>
    var grid;
    var token = sessionStorage.account;
    var globab_clientId = sessionStorage.clientId;
    var globab_account = sessionStorage.accountName;
    $(function () {
        if (globab_clientId == 0) {

        }


        /*
         ** 默认加载
         */
        acquireData("", "", "");

        /*
         ** 查询
         */
        $("#search").click(function () {
            var key = $("#key").textbox("getValue");
            acquireData("", "", key);
        });

        /*
         ** 重置
         */
        $("#reset").on("click", function () {
            $("#key").textbox("setValue", "");
            $("#isonline").combobox('setValue', '-1');
            $("#isstop").combobox('setValue', '-1');
            acquireData(-1, -1, '');
        });
    });

    /*
     ** 添加
     */
    $("#add").click(function () {
        var dialog = phm.modalDialog({
            title: '添加',
            width: 900,
            height: 560,
            closable: true,
            url: "notifierproplus_add.jsp?id=0",
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
        ////console.info(row);
        if (row == null) {
            $.messager.alert('警告', "请选择要修改的记录", 'info');
            return;
        }


        var dialog = phm.modalDialog({
            title: '修改',
//				width: 900,
//				height: 560,
            closable: true,
            url: "notifierproplus_add.jsp?id=" + row.id,
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
        ////console.info(row);
        if (row == null) {
            $.messager.alert('警告', "选择删除的记录", 'info');
            return;
        }

        $.messager.confirm('确认', '您确认想要删除记录吗？', function (r) {
            if (r) {

                var requestURL = path + "/notifierPlus/delNotifierPlusByid?id=" + row.id + "&token=" + token;

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
                                msg: data.desc,
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


    //查看司机信息
    function openrelation(data) {
        //console.info(data);
        var dialog = phm.modalDialog({
            title: '发布记录',
            width: 900,
            height: 560,
            closable: true,
            url: "notifierproplus_driver.jsp?id=" + data,
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

    /*
     ** 获取数据
     */
    function acquireData(key) {

        var dataUrl = 'sort=id&order=desc&begintime=&endtime=&key=' + key + "&clientid=" + globab_clientId;
        grid = $("#redataGril").datagrid({
            fit: true,
            url: path + "/notifierPlus/findNotifierPlusForPageList?" + dataUrl,
            fitColumns: true,
            striped: true,
            columns: [
                [
                    {field: 'accountName', title: '发布者', width: 100, align: 'center', sortable: true},
                    {field: 'content', title: '内容', width: 100, align: 'center', sortable: true},
                    {field: 'creattime', title: '发布时间', width: 100, align: 'center', sortable: true},
                    {field: 'expired', title: '有效时间', width: 100, align: 'center', sortable: true},
                    {
                        field: 'option', title: '操作', width: 50, align: 'center',
                        formatter: function (value, row, index) {
                            var codes = row["id"];
                            return '<span class="openrelation" onclick="openrelation(id)" id=' + codes + '>发布记录</span>';
                        }
                    }
                ]
            ],
            onLoadSuccess: function (data) {
                //console.info(data);
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

    //function acquireData();结束


</script>


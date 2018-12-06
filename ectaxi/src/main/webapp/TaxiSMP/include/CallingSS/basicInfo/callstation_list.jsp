<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>电召站管理</title>

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
        <span>位置描述</span>
        <input id="position" class="easyui-textbox" style="width:160px;">
        <span>&nbsp;电话号码</span>
        <input id="phone" class="easyui-textbox" style="width:160px;">
    </div>
    <div id="button">
        <button class="easyui-linkbutton" id="search" iconCls="icon-search">查询</button>
        <button class="easyui-linkbutton" id="reset">重置</button>
        <button class="easyui-linkbutton" id="add">添加</button>
        <button class="easyui-linkbutton" id="edit">修改</button>
        <button class="easyui-linkbutton" id="delete">删除</button>
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
        var globab_clientId = sessionStorage.clientId;
        /*
        ** 默认加载
        */
        acquireData('', '');

        /*
        ** 查询
        */
        $("#search").on("click", function () {
            var position = $("#position").val();
            var phone = $("#phone").val();
            acquireData(position, phone);
        });

        /*
        ** 重置
        */
        $("#reset").on("click", function () {
            $("#position").textbox("setValue", "");
            $("#phone").textbox("setValue", "");
            acquireData('', '');
        });

        /*
        ** 添加
        */
        $("#add").click(function () {
            var dialog = phm.modalDialog({
                title: '添加电召站',
                //width: 可自己设置宽度,
                //height: 可自己设置高度,
                closable: true,
                url: "callstation_add.jsp",
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
        $("#edit").click(function () {
            var row = grid.datagrid("getSelected");
            if (row == null) {
                $.messager.alert('警告', "选择修改的记录", 'info');
                return;
            }
//			////console.info(row);
            var dialog = phm.modalDialog({
                title: '修改电召站',
                //width: 可自己设置宽度,
                //height: 可自己设置高度,
                closable: true,
                url: "callstation_add.jsp?id=" + row.id,
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

                    var requestURL = path + '/callstation/delCallstationByid?id=' + row.id + "&token=" + token + "&clientid=" + globab_clientId;
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
         ** 根据id查找
         */
        $("#test").click(function () {
            var row = grid.datagrid("getSelected");
            if (row == null) {
                $.messager.alert('警告', "选择删除的记录", 'info');
                return;
            }
            var requestURL = path + '/callstation/findCallstationByid?id=' + row.id + "&clientid=" + globab_clientId;
            $.ajax({
                type: "POST",
                url: requestURL,
                async: false,
                dataType: "json", //后台返回值类型
                success: function (data) {
                    ////console.info(data);
                }
            });
        });

        /*
        ** 获取数据
        */
        function acquireData(position, phone) {
            var dataUrl = "order=desc&sort=id&position=" + position +
                "&phone=" + phone + "&token=" + token + "&clientid=" + globab_clientId;
            grid = $("#redataGril").datagrid({
                fit: true,
                url: path + "/callstation/findCallstationForPageList?" + dataUrl,
                fitColumns: true,
                striped: true,
                columns: [
                    [
                        {field: 'callstationId', title: '电召站编号', width: 100, align: 'center'},
                        {field: 'name', title: '电召站简称', width: 100, align: 'center'},
                        {field: 'phone', title: '电话号码', width: 100, align: 'center'},
                        {field: 'position', title: '位置描述', width: 100, align: 'center'},
                        {field: 'line', title: '电召站附近路线', width: 100, align: 'center'},
                        {field: 'geographical', title: '地理位置', width: 100, align: 'center'}
                    ]
                ],
                //          onLoadSuccess: function (data) {
                //
                //          },
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
</script>
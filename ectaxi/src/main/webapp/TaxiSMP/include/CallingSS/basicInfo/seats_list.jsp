<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>坐席人员</title>

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

</head>
<body id="body" class="easyui-layout" data-options="fit:true">

<!-- 数据表格 -->
<table id="redataGril"></table>

<!-- 工具栏 -->
<div id="toolbar">
    <div id="input">
        <span>关键字</span>
        <input id="key" class="easyui-textbox" data-options="width:180" prompt="坐席人员姓名 | 坐席号 | 分机号">
    </div>
    <div id="button">
        <button class="easyui-linkbutton" id="search" iconCls="icon-search">查询</button>
        <button class="easyui-linkbutton" id="reset">重置</button>
        <button class="easyui-linkbutton" id="add">添加</button>
        <button class="easyui-linkbutton" id="modify">修改</button>
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
        acquireData('');

        /*
        ** 查询
        */
        $("#search").on("click", function () {
            var key = $('#key').val();
            acquireData(key);
        });

        /*
        ** 添加
        */
        $("#add").click(function () {
            var dialog = phm.modalDialog({
                title: '添加座席',
                //width: 可自己设置宽度,
                //height: 可自己设置高度,
                closable: true,
                url: "seats_add.jsp?opruser=0",
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
//            //console.info(row);
//            return;
            var dialog = phm.modalDialog({
                title: '修改座席信息(无法修改坐席帐号)',
                closable: true,
                url: "seats_add.jsp?opruser=" + row.opruser,
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
                    $.ajax({
                        url: path + '/passenger/delPassByid?opruser=' + row.opruser + "&token=" + token,
                        dataType: "json",
                        type: "GET",
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
            grid = $("#redataGril").datagrid({
                fit: true,
                url: path + "/passenger/findSeatsForPageList?startime=&endtime=&type=1&order=desc&sort=id&key=" + key + "&token=" + token + "&clientid=" + globab_clientId,
                fitColumns: true,
                striped: true,
                columns: [
                    [
                        {field: 'account', title: '坐席登录帐号', width: 100, align: 'center', sortable: true},
                        {field: 'password', title: '登录密码', width: 100, align: 'center'},
                        {field: 'name', title: '坐席人员姓名', width: 100, align: 'center'},
                        {field: 'seatsnum', title: '坐席号', width: 100, align: 'center'},
                        {
                            field: 'assign', title: '是否指定派单', width: 100, align: 'center',
                            formatter: function (value) {
                                return getValueFromArray(value, isvalue);
                            },
                            styler: function (value) {
                                switch (value) {
                                    case 0 :
                                        return "color:gray;";
                                        break;
                                    case 1:
                                        return "color:red;";
                                        break;
                                }
                            }
                        },
                        {field: 'extensionnum', title: '分机号', width: 100, align: 'center'},
                        {field: 'unit', title: '单位名称', width: 100, align: 'center'}
                    ]
                ],
                onLoadSuccess: function (data) {
                    //console.info(data);
                },
                idField: 'mobile',
                sortName: 'mobile',
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
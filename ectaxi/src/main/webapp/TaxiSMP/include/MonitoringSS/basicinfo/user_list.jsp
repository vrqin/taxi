<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no"
          name="viewport" id="viewport"/>
    <title>用户管理</title>

    <!-- jquery easyui 插件 -->
    <link href="../../../public/jquery-easyui-1.5/themes/metro/easyui.css" rel="stylesheet"/>
    <link href="../../../public/jquery-easyui-1.5/themes/icon.css" rel="stylesheet"/>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.easyui.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/easyui-lang-zh_CN.js"></script>

    <!-- 数据接口路径、共用JS -->
    <script src="../../../public/js/path.js"></script>
    <script src="../../../public/js/utiljavascript.js"></script>
    <!-- childstyle -->
    <link rel="stylesheet" type="text/css" href="../../../public/css/childstyle.css"/>
    <style>
        .fg {
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
        <label>关键字</label>
        <input id="key" class="easyui-textbox" style="width:160px;" prompt="帐号 | 姓名">
    </div>
    <div id="button">
        <button id="search" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</button>
        <button id="reset" class="easyui-linkbutton">重置</button>
        <button class="easyui-linkbutton" id="add">添加</button>
        <button class="easyui-linkbutton" id="modify">修改</button>
        <button class="easyui-linkbutton" id="delete">删除</button>
        <button class="easyui-linkbutton" id="roleset" style="display: none">权限设置</button>
        <%--<button id="lock" class="easyui-linkbutton" >锁定</button>--%>
        <%--<button id="unlock" class="easyui-linkbutton" >解锁</button>--%>
        <%--<button class="easyui-linkbutton" >权限设置</button>--%>
        <%--<button class="easyui-linkbutton" >资料权限设置</button>--%>
        <%--<button class="easyui-linkbutton" >资料取消变更</button>--%>
        <%--<button id="export" class="easyui-linkbutton" >导出</button>--%>
        <%--<button id="resetpwd" class="easyui-linkbutton" >重置密码</button>--%>
    </div>
</div>

</body>
</html>

<script>
    /*
     ** 声明
     */
    var grid;
    var token = sessionStorage.account;
    var globab_clientId = sessionStorage.clientId;
    $(function () {

        if (globab_clientId == 0) {
            $("#roleset").show();
        }


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
         ** 添加
         */
        $("#add").click(function () {
            var dialog = phm.modalDialog({
                title: '添加',
//				width: 900,
//				height: 560,
                closable: true,
                url: "user_add.jsp?accountID=0",
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

            if (row.ClientId == 0) {
                $.messager.alert('警告', "当前为超级管理员权限不能修改或删除", 'info');
                return;
            }

            var dialog = phm.modalDialog({
                title: '修改',
//				width: 900,
//				height: 560,
                closable: true,
                url: "user_add.jsp?accountID=" + row.accountID,
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
            if (row.ClientId == globab_clientId) {
                $.messager.alert('警告', "当前为超级管理员权限不能修改或删除", 'info');
                return;
            }
            $.messager.confirm('确认', '您确认想要删除记录吗？', function (r) {
                if (r) {

                    var requestURL = path + "/userinfo/delUserByid?id=" + row.accountID + "&token=" + token;

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
         ** 设置权限
         */
        $("#roleset").click(function () {
            var row = grid.datagrid("getSelected");
            ////console.info(row);
            if (row == null) {
                $.messager.alert('警告', "请选择要修改的记录", 'info');
                return;
            }
            restudentinfo(row.accountID);

        });

        /*
        ** 获取数据
        */
        function acquireData(key) {
            var dataUrl = 'sort=id&order=desc&begintime=&endtime=&key=' + key + '&islock=-1' + "&clientid=" + globab_clientId;
            grid = $("#redataGril").datagrid({
                fit: true,
                url: path + "/userinfo/findUserForPageList?" + dataUrl,
                fitColumns: true,
                striped: true,
                columns: [
                    [
                        {field: 'accountName', title: '登录帐号', width: 100, align: 'center', sortable: true},
                        {field: 'userName', title: '用户名称', width: 100, align: 'center', sortable: true},
                        {field: 'passwd', title: '用户密码', width: 100, align: 'center'},
                        {field: 'onlineStatus', title: '在线状态', width: 100, align: 'center'},
                        {field: 'registerTime', title: '创建时间', width: 100, align: 'center'},
                        {field: 'remark', title: '备注', width: 100, align: 'center'}
//						{field: 'option', title: '操作', width: 140, align: 'center',
//							formatter: function (value, row, index) {
//								////console.info(row);
//								var codes = row["accountID"];
//								var strbutton = '<span class="fg" onclick="restudentinfo(id)" id=' + codes + '>权限设置</span>';
//								return strbutton;
//							}
//						}

                    ]
                ],
                onLoadSuccess: function (data) {
                    ////console.info(data);
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

    });

    function restudentinfo(id) {
        var dialog = phm.modalDialog({
            title: '权限',
//				width: 900,
//				height: 560,
            closable: true,
            url: "user_set_role.jsp?accountID=" + id,
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
    }
</script>
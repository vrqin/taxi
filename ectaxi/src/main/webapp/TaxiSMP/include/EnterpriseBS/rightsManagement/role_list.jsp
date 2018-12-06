<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>角色管理</title>

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

</head>
<body id="body" class="easyui-layout" data-options="fit:true">

<!-- 数据表格 -->
<table id="redataGril"></table>

<!-- 工具栏 -->
<div id="toolbar">
    <div id="input">
        <label>关键字</label>
        <input id="key" class="easyui-textbox" style="width:160px;" prompt=" 角色姓名 ">
    </div>
    <div id="button">
        <button id="search" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</button>
        <button id="reset" class="easyui-linkbutton">重置</button>
        <button class="easyui-linkbutton" id="add">添加</button>
        <button class="easyui-linkbutton" id="modify">修改</button>
        <button class="easyui-linkbutton" id="delete">删除</button>
        <button class="easyui-linkbutton" >生效</button>
        <button class="easyui-linkbutton" >失效</button>
        <button class="easyui-linkbutton" id="accredit">角色授权</button>
        <button class="easyui-linkbutton" >用户设置</button>
        <button class="easyui-linkbutton" >资料权限设置</button>
    </div>
</div>

</body>
</html>

<script>

    var grid;
    var token = sessionStorage.account;
    var globab_clientId = sessionStorage.clientId;
    $(function () {

        if (globab_clientId == 0) {

        }


        /*
        ** 默认加载
        */
        acquireData('', -1);

        /*
        ** 查询
        */
        $("#search").on("click", function () {
            var key = $("#key").textbox("getValue");
            var type = $("#type").combobox("getValue");
            acquireData(key, type);
        });

        /*
        ** 重置
        */
        $("#reset").on("click", function () {
            $("#key").textbox("setValue", "");
            $("#type").textbox("setValue", "-1");
            acquireData('', -1);
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
                url: "role_add.jsp?id=0",
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
                url: "role_add.jsp?id=" + row.roleId,
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
            if (row.roleId == 1) {
                $.messager.alert('警告', "管理员权限无法删除！", 'info');
                return;
            }
            $.messager.confirm('确认', '您确认想要删除记录吗？', function (r) {
                if (r) {

                    var requestURL = path + "/role/delRoleByid?id=" + row.roleId + "&token=" + token;

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
        /*
         ** 授权
         */
        $("#accredit").click(function () {
            var row = grid.datagrid("getSelected");
            ////console.info(row);
            if (row == null) {
                $.messager.alert('警告', "请选择要修改的记录", 'info');
                return;
            }


            var dialog = phm.modalDialog({
                title: '授权',
//				width: 900,
                height: 580,
                closable: true,
                url: "role_accredit.jsp?id=" + row.roleId,
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
        ** 获取数据
        */
        function acquireData(key, type) {
            var dataUrl = 'sort=id&order=asc&begintime=&endtime=&key=' + key + '&validity=' + type + "&clientid=" + globab_clientId;
            grid = $("#redataGril").datagrid({
                fit: true,
                url: path + "/role/findRoleForPageList?" + dataUrl,
                fitColumns: true,
                striped: true,
                columns: [
                    [
                        {field: 'name', title: '角色名称', width: 100, align: 'center', sortable: true},
//						{field: 'registerTime', title: '注册时间', width: 100, align: 'center',sortable:true},
                        {field: 'roleRemark', title: '备注', width: 100, align: 'center', sortable: true}
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

</script>
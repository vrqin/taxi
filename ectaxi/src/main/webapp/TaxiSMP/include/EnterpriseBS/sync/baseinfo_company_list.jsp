<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>网约车平台公司基本信息</title>

    <!-- jquery easyui 插件 -->
    <link href="../../../public/jquery-easyui-1.5/themes/metro/easyui.css" rel="stylesheet"/>
    <link href="../../../public/jquery-easyui-1.5/themes/icon.css" rel="stylesheet"/>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.easyui.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/easyui-lang-zh_CN.js"></script>

    <!-- childstyle -->
    <link rel="stylesheet" type="text/css" href="../../../public/css/childstyle.css"/>
    <script src="../../../public/js/utiljavascript.js"></script>

    <script src="../../../public/js/constant.js"></script>
    <!-- 数据接口路径、共用JS -->
    <script src="../../../public/js/path.js"></script>

</head>
<body id="body" class="easyui-layout" data-options="fit:true">

<!-- 数据表格 -->
<table id="redataGril"></table>

<!-- 工具栏 -->
<div id="toolbar">

    <div id="button">
        <button class="easyui-linkbutton" id="add">添加</button>
        <button class="easyui-linkbutton" id="modify">修改</button>
        <button class="easyui-linkbutton" id="delete">删除</button>
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
                url: "baseinfo_company_add.jsp?CompanyId=0",
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

            var idd = row.CompanyId;

            var lru = "baseinfo_company_add.jsp?CompanyId=" + idd + "";
            console.error(lru)
            var dialog = phm.modalDialog({
                title: '修改',
//				width: 900,
//				height: 560,
                closable: true,
                url: lru,
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

                    var requestURL = path + "/baseInfoCompany/delBaseInfoCompanyByid?id=" + row.CompanyId + "&token=" + token;

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
        function acquireData(key) {
            var dataUrl = 'sort=id&order=desc&begintime=&endtime=&key=' + key;
            grid = $("#redataGril").datagrid({
                fit: true,
                url: path + "/baseInfoCompany/findBaseInfoCompanyForPageList?" + dataUrl,
                fitColumns: true,
                striped: true,
                columns: [
                    [
                        {field: 'CompanyId', title: '公司标识', width: 100, align: 'center', sortable: true},
                        {field: 'CompanyName', title: '公司名称', width: 100, align: 'center', sortable: true},
                        {field: 'Identifier', title: '统一社会信用代码', width: 100, align: 'center', sortable: true},


                        {field: 'Address', title: '注册地行政区域代码', width: 100, align: 'center'},
                        {field: 'BusinessScope', title: '经营范围', width: 100, align: 'center'},

                        {field: 'ContactAddress', title: '通信地址', width: 100, align: 'center'},
                        {field: 'EconomicType', title: '经营业户经济类型', width: 100, align: 'center'},
                        {field: 'RegCapital', title: '注册资本', width: 100, align: 'center'},
                        {field: 'LegalName', title: '法人代表姓名', width: 100, align: 'center'},
                        {field: 'LegalID', title: '法人代表身份证号', width: 100, align: 'center'},
                        {field: 'LegalPhone', title: '法人代表电话', width: 100, align: 'center'},
                        {field: 'LegalPhoto', title: '法人代表身份证扫描文件编号', width: 100, align: 'center'},
                        {field: 'State', title: '状态', width: 100, align: 'center'},
                        // {field: 'Flag', title: '操作标识', width: 100, align: 'center'},
                        {field: 'UpdateTime', title: '更新时间', width: 100, align: 'center'},


                    ]
                ],
                onLoadSuccess: function (data) {
                    //console.info(data);
                },
                idField: 'CompanyId',
                sortName: 'CompanyId',
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
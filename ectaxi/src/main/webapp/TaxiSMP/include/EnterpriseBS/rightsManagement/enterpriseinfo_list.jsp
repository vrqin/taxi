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
    <title>企业信息</title>

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
    <style type="text/css">

    </style>

</head>
<body id="body" class="easyui-layout" data-options="fit:true">

<!-- 数据表格 -->
<table id="redataGril"></table>

<!-- 工具栏 -->
<div id="toolbar">
    <div id="input">
        <span>关键字</span>
        <input id="key" class="easyui-textbox" data-options="width:180" prompt="企业名称">

    </div>
    <div id="button">
        <button class="easyui-linkbutton" id="search" iconCls="icon-search">查询</button>
        <button class="easyui-linkbutton" id="reset">重置</button>
        <button class="easyui-linkbutton" id="add">添加</button>
        <button class="easyui-linkbutton" id="modify">修改</button>
        <button class="easyui-linkbutton" id="delete">删除</button>
        <button class="easyui-linkbutton" id="setting">参数设置</button>
        <button class="easyui-linkbutton" id="setdistance">派单距离</button>

    </div>
</div>

</body>
</html>

<script>

    var grid;

    $(function () {

        /*
         ** 全局变量声明
         */

        var token = sessionStorage.account;
        var globab_clientId = sessionStorage.clientId;

        //隐藏配置
        cgflag();

        /*
         ** 默认加载
         */
        acquireData(-1, '');

        /*
         ** 查询
         */
        $("#search").click(function () {
            var key = $("#key").textbox("getValue");
            acquireData(-1, key);
        });

        /*
         ** 重置
         */
        $("#reset").on("click", function () {
            $("#key").textbox("setValue", "");
            acquireData(-1, "");
        });


        /*
         ** 添加
         */
        $("#add").click(function () {
            var dialog = phm.modalDialog({
                title: '添加客户',
//                width: 900,
//                height: 560,
                closable: true,
                url: "enterpriseinfo_add.jsp?clientId=0",
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
            var row = grid.treegrid("getSelected");
            ////console.info(row);
            if (row == null) {
                $.messager.alert('警告', "请选择要修改的记录", 'info');
                return;
            }
            var dialog = phm.modalDialog({
                title: '修改客户信息',
//                width: 900,
//                height: 560,
                closable: true,
                url: "enterpriseinfo_add.jsp?clientId=" + row.clientId,
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
            var row = grid.treegrid("getSelected");
            ////console.info(row);
            if (row.clientId == globab_clientId) {
                $.messager.alert('警告', "当前为超级管理员权限不能修改或删除", 'info');
                return;
            }
            if (row == null) {
                $.messager.alert('警告', "选择删除的记录", 'info');
                return;
            }
            $.messager.confirm('确认', '您确认想要删除记录吗？', function (r) {
                if (r) {

                    var requestURL = path + "/client/delClientByid?id=" + row.clientId + "&token=" + token;

                    $.ajax({
                        type: "DELETE",
                        url: requestURL,
                        async: false,
                        dataType: "json", //后台返回值类型
                        success: function (data) {
                            if (data.desc.indexOf("成功") > -1) {
                                grid.treegrid("reload");
                                grid.treegrid("clearSelections");
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
         ** 设置参数
         */
        $("#setting").click(function () {
            var row = grid.treegrid("getSelected");
//            console.info(row);
            if (row == null) {
                $.messager.alert('警告', "请选择要设置参数的记录", 'info');
                return;
            }
            var dialog = phm.modalDialog({
                title: '设置参数',
                width: 900,
                height: 560,
                closable: true,
                url: "enterpriseinfo_setting.jsp?clientId=" + row.clientId,
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
        //设置派单距离
        $("#setdistance").click(function () {
            var row = grid.datagrid("getSelected");

            if (row == null) {
                $.messager.alert('警告', "请选择要修改的记录", 'info');
                return;
            }
            console.info(row);

            $.ajax({
                url: path + '/clientSetting/findClientSettingByid?id=' + row.clientId,
                dataType: "json",
                type: "POST",
                success: function (data) {
                    console.info(data);
                    if (data != null && data != "") {
                        $('.messager-input').val(data.distance);

                    }

                }
            });

            $.messager.prompt('提示信息', '请输入派单范围(米)：', function (r) {

                if (r) {

                    var distance = $('.messager-input').val();

                    if (distance < 0 || distance > 5000) {
                        alert("派单范围在5000以内");
                        return;
                    }

                    var data = {
                        "clientId": row.clientId,
                        "distance": distance,
                        "token": token
                    };
//		console.info(data);

                    var requestURL = path + "/clientSetting/saveorupdateClientSettingDistance";
                    $.ajax({
                        type: "POST",
                        crossDomain: true,
                        url: requestURL,
                        data: JSON.stringify(data), //必须转成JSON进行传递，否则会报code 117错误
                        cache: false,
                        dataType: "json", //后台返回值类型
                        contentType: "application/json;charset=utf-8",
                        success: function (data) {
                            if (data.desc.indexOf("成功") > -1) {
                                grid.datagrid("reload");
                                grid.datagrid("clearSelections");
                                $.messager.show({
                                    title: '提示',
                                    msg: "操作成功！",
                                    timeout: 3000,
                                    showType: 'slide'
                                });
                            } else {
                                $.messager.alert("错误", data, "error");
                            }
                        }
                    });

                }
            });


        });


        /*
         ** 获取数据
         */
        function acquireData(cityFlag, key) {
            var dataurl = path + "/client/findClienttreegril?id=" + key + "&clientid=" + globab_clientId;
            grid = $("#redataGril").treegrid({
                fit: true,
                url: dataurl,
                treeField: 'clientName',
                animate: true,
                frozenColumns: [
                    [
//                            {field: 'clientId', title: '客户Id', width: 50, sortable: true, align: 'center'},
                        {field: 'clientName', title: '客户名称', width: 150, align: 'left', sortable: true}
                    ]
                ],
                columns: [
                    [

                        {
                            field: 'cityFlag', title: '级别', width: 100, align: 'center', sortable: true,
                            formatter: function (value) {
                                if (value == 0) {
                                    return "总公司";
                                } else {
                                    return "子公司";
                                }
                            }
                        },
                        {field: 'contactperson', title: '联系人', width: 100, align: 'center', sortable: true},
                        {field: 'phone', title: '联系电话', width: 100, align: 'center'},
                        {field: 'address', title: '地址', width: 100, align: 'center'},
                        {field: 'company', title: '公司', width: 100, align: 'center'},
                        {field: 'email', title: '邮箱', width: 100, align: 'center'},
                        {field: 'remark', title: '备注', width: 100, align: 'center'}
                    ]
                ],
                onLoadSuccess: function (rows, data) {
                    ////console.info(rows);
                    ////console.info(data);
                },
                idField: 'clientId',
                sortName: 'clientId',
                sortOrder: 'desc',
                singleSelect: true,
                pagination: true,
                pageSize: 20,
                pageList: [20, 40, 60, 80],
                rownumbers: true,
                toolbar: '#toolbar'
            });

        }//function acquireData();结束

        function cgflag() {
            //管理员
            if (sessionStorage.cgFlag != 9) {
                $("#setting").hide();
            } else {
                //非管理员
                $("#setdistance").hide();


            }

        }
    });

</script>
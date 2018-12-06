<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>报警提醒设置</title>

    <!-- jquery easyui 插件 -->
    <link href="../../../public/jquery-easyui-1.5/themes/metro/easyui.css" rel="stylesheet"/>
    <link href="../../../public/jquery-easyui-1.5/themes/icon.css" rel="stylesheet"/>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.easyui.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/easyui-lang-zh_CN.js"></script>

    <!-- childstyle -->
    <link rel="stylesheet" type="text/css" href="../../../public/css/childstyle.css"/>

    <!-- 数据接口路径 -->
    <script src="../../../public/js/path.js"></script>
    <script src="../../../public/js/utiljavascript.js"></script>

</head>
<body id="body" class="easyui-layout" data-options="fit:true">

<!-- 数据表格 -->
<table id="redataGril"></table>

<!-- 工具栏 -->
<div id="toolbar">
    <div id="input">
        <span>公司名称</span>
        <input id="company" class="easyui-textbox" style="width:160px;">
    </div>
    <div id="button">
        <button class="easyui-linkbutton" id="search" iconCls="icon-search">查询</button>
        <button class="easyui-linkbutton" id="reset">重置</button>
        <button class="easyui-linkbutton" id="add">添加</button>
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
            var company = $("#company").val();
            acquireData(company);
        });

        /*
        ** 重置
        */
        $("#reset").on("click", function () {
            $("#company").textbox("setValue", "");
            acquireData('');
        });

        /*
        ** 添加
        */
        $("#add").click(function () {
            var dialog = phm.modalDialog({
                title: '添加报警提醒',
                //width: 可自己设置宽度,
                //height: 可自己设置高度,
                closable: true,
                url: "remindset_add.jsp",
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
                    $.ajax({
                        url: path + '/remindset/delRemindSetByid?id=' + row.id + "&token=" + token + "&client" + globab_clientId,
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
        ** 获取数据
        */
        function acquireData(key) {
            grid = $("#redataGril").datagrid({
                fit: true,
                url: path + "/remindset/findRemindSetForPageList?extypes=-1&type=-1&enable=-1&order=desc&sort=id&key=" + key + "&token=" + token + "&clientid=" + globab_clientId,
                fitColumns: true,
                striped: true,
                columns: [
                    [
                        {field: 'company', title: '报警公司', width: 100, align: 'center', sortable: true},
                        {
                            field: 'extypes', title: '异常类型', width: 100, align: 'center', sortable: true,
                            formatter: function (value) {
                                switch (value) {
                                    case 1:
                                        return "超速";
                                        break;
                                    case 2:
                                        return "驶出限区";
                                        break;
                                    case 3:
                                        return "区域超速";
                                        break;
                                    case 4:
                                        return "疲劳驾驶";
                                        break;
                                    case 5:
                                        return "紧急报警";
                                        break;
                                    case 6:
                                        return "驶入限区";
                                        break;
                                    case 7:
                                        return "防劫预警";
                                        break;
                                    case 8:
                                        return "终端超速报警";
                                        break;
                                    default:
                                        return "";
                                }
                            }
                        },
                        {field: 'remind', title: '提醒人员', width: 100, align: 'center'},
                        {
                            field: 'type', title: '通知方式', width: 100, align: 'center',
                            formatter: function (value) {
                                switch (value) {
                                    case 0 :
                                        return "短信通知";
                                        break;
                                    case 1:
                                        return "邮件通知";
                                        break;
                                    default:
                                        return "";
                                }
                            }
                        },
                        {
                            field: 'enable', title: '是否启用', width: 100, align: 'center',
                            formatter: function (value) {
                                switch (value) {
                                    case 0 :
                                        return "启用";
                                        break;
                                    case 1:
                                        return "没启用";
                                        break;
                                    default:
                                        return "";
                                }
                            }
                        }

                    ]
                ],
                //          onLoadSuccess: function (data) {
                //				////console.info(data);
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
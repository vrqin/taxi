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
    <title>运价信息</title>

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
        <input id="key" class="easyui-textbox" data-options="width:180" prompt="运价执行区域 | 运价类型描述">

        <span>运价状态</span>
        <select id="state" class="easyui-combobox" data-options="panelHeight:'auto',editable:false"
                style="width:80px;">
        </select>
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

    var grid;

    $(function () {

        /*
         ** 全局变量声明
         */

        var token = sessionStorage.account;
        /*
         ** 默认加载
         */
        acquireData(-1, '');

        $("#state").combobox({
            data: stutets,
            valueField: 'id',
            textField: 'text'
        });

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
                title: '添加运价',
                width: 800,
                height: 560,
                closable: true,
                url: "freight_add.jsp?freightid=0",
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
                title: '修改客户信息',
                width: 800,
                height: 560,
                closable: true,
                url: "freight_add.jsp?freightid=" + row.id,
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

                    var requestURL = path + "/freight/delFreightByid?id=" + row.id + "&token=" + token;

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
        function acquireData(type, key) {
            var dataurl = path + "/freight/findFreightForPageList?startime=&endtime=" +
                "&order=desc&sort=validitime&type=" + type + "&key=" + key + "&token=" + token;

            grid = $("#redataGril").datagrid({
                fit: true,
                url: dataurl,
                fitColumns: true,
                striped: true,
                columns: [
                    [
                        {field: 'regional', title: '执行区域', width: 100, align: 'center'},
                        {field: 'description', title: '运价类型描述', width: 100, align: 'center'},
                        {field: 'validitime', title: '有效期起始时间', width: 100, align: 'center'},
                        {field: 'startmileage', title: '运营起步里程数', width: 100, align: 'center'},
                        {field: 'diurnalstartfare', title: '昼间起步价', width: 100, align: 'center'},
                        {field: 'diurnalendfare', title: '夜间起步价', width: 100, align: 'center'},
                        {field: 'diurnalprice', title: '昼间单价', width: 100, align: 'center'},
                        {field: 'nightprice', title: '夜间单价', width: 100, align: 'center'},
                        {
                            field: 'islowspeedwait', title: '是否低速等候', width: 100, align: 'center',
                            formatter: function (value) {
                                return getValueFromArray(value, islowspeedwait);
                            }
                        },
                        {field: 'freightswitch', title: '运价切换速度', width: 100, align: 'center'},
                        {field: 'fuelsurcharge', title: '燃油附加费', width: 100, align: 'center'},
                        {
                            field: 'state', title: '运价状态', width: 100, halign: 'center',
                            formatter: function (value) {
                                return getValueFromArray(value, stutets);
                            }
                        }
                    ]
                ],
                onLoadSuccess: function (data) {
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

    });

</script>
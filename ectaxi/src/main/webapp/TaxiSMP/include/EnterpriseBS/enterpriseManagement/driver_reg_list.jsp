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
    <title>司机注册审核</title>

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
        <input id="key" class="easyui-textbox" data-options="width:180" prompt="手机号 | 姓名 ">
        <span>&nbsp;审核状态</span>
        <select id="status" class="easyui-combobox" data-options="width:80,panelHeight:'auto',editable:false">
            <option value="-1" selected>全部</option>
            <option value="1">审核中</option>
            <option value="0">审核通过</option>
        </select>
    </div>
    <div id="button">
        <button class="easyui-linkbutton" id="search" iconCls="icon-search">查询</button>
        <button class="easyui-linkbutton" id="reset">重置</button>
        <button class="easyui-linkbutton" id="delete">删除</button>
    </div>
</div>

</body>
</html>

<script>

    $(function () {

        /*
         ** 全局变量声明
         */
        var grid;
        var globab_clientId = sessionStorage.clientId;

        /*
         ** 默认加载
         */
        acquireData("", "", -1, "");

        /*
         ** 查询
         */
        $("#search").click(function () {
            var key = $("#key").textbox("getValue");
            var isonline = $('#isonline').combobox("getValue");
            var isstop = $("#isstop").combobox("getValue");
            acquireData(isonline, isstop, key);
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

//                    var requestURL = path + "/driver/delDriverByid?driverid="+row.driverid;
                    $.ajax({
                        type: "DELETE",
//                        url : requestURL,
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
         ** 重置密码
         */
        $("#resetPassword").click(function () {
            var row = grid.datagrid("getSelected");
            if (row == null) {
                $.messager.alert('警告', "选择修改选项", 'info');
                return;
            }
            $.messager.confirm('确认', '您确认想要重置当前帐号密码？默认密码为"123456"', function (r) {
                if (r) {
                    $.ajax({
                        url: path + "/driver/setPasswordbyDriverid?driverid=" + row.driverid + "&clientid=" + globab_clientId,
                        data: {driverid: row.driverid},
                        dataType: "json",
                        type: "GET",
                        success: function (data) {
                            ////console.info(data);
                            if (data.desc.indexOf("成功") > -1) {
                                grid.datagrid("reload");
                                grid.datagrid("clearSelections");
                                $.messager.show({
                                    title: '提示',
                                    msg: "密码重置成功！",
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
         ** 是否禁用
         */
        $("#setDisable").click(function () {
            var row = grid.datagrid("getSelected");
            if (row == null) {
                $.messager.alert('警告', "选择修改选项", 'info');
                return;
            }
            $.messager.confirm('确认', '您确认想要禁用或启用当前帐号？', function (r) {
                if (r) {
                    $.ajax({
                        url: path + "/driver/isStopbyDriverid?driverid=" + row.driverid + "&clientid=" + globab_clientId,
                        data: {driverid: row.driverid},
                        dataType: "json",
                        type: "GET",
                        success: function (data) {
                            ////console.info(data);
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
        function acquireData(startime, endtime, type, key) {
            var dataUrl = "startime=" + startime +
                "&endtime=" + endtime +
                "&type=" + type +
                "&order=desc&sort=id&key=" + key;

            grid = $("#redataGril").datagrid({
                fit: true,
                url: path + "/driverReg/findDriverRegForPageList?" + dataUrl,
                fitColumns: true,
                striped: true,
                columns: [
                    [
                        {field: 'name', title: '姓名', width: 100, align: 'center', sortable: true},
                        {field: 'phone', title: '手机号', width: 100, align: 'center', sortable: true},
                        {field: 'identity', title: '身份证号', width: 100, align: 'center'},
                        {field: 'operationid', title: '运营证号', width: 100, align: 'center'},
                        {field: 'kabnum', title: '车牌号', width: 100, align: 'center'},
                        {field: 'applytime', title: '申请时间', width: 100, align: 'center', sortable: true},
                        {field: 'audittime', title: '审核时间', width: 100, align: 'center', sortable: true},
                        {
                            field: 'applystatus', title: '申请状态', width: 100, align: 'center', sortable: true,
                            formatter: function (value) {
                                if (value != null) {
                                    return getValueFromArray(value, driverapplystatus);
                                } else {
                                    return " ";
                                }
                            }
                        }

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

        }//function acquireData();结束

    });

</script>
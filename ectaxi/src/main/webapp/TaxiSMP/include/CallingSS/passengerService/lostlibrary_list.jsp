<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>失物入库</title>

    <!-- jquery easyui 插件 -->
    <link href="../../../public/jquery-easyui-1.5/themes/metro/easyui.css" rel="stylesheet"/>
    <link href="../../../public/jquery-easyui-1.5/themes/icon.css" rel="stylesheet"/>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.easyui.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/easyui-lang-zh_CN.js"></script>

    <!-- 数据接口路径、共用JS -->
    <script src="../../../public/js/path.js"></script>
    <script src="../../../public/js/utiljavascript.js"></script>

</head>
<body class="easyui-layout" data-options="fit:true" style="padding:10px; box-sizing: border-box;">

<!-- 数据表格 -->
<table id="redataGril"></table>

<!-- 工具栏 -->
<div id="toolbar">
    <div style="margin: 10px;padding: 10px;border: 1px solid #c8c8c8;">
        <label>关键字</label>
        <input id="key" class="easyui-textbox" data-options="width:160" prompt="客户姓名 / 电话 / 乘坐车辆">
        <label>&nbsp;失物分类</label>
        <select id="classify" class="easyui-combobox" data-options="width:80,panelHeight:'auto',editable:false">
            <option value="-1">全部</option>
            <option value="1">钥匙</option>
            <option value="2">手机</option>
            <option value="3">电脑</option>
            <option value="4">钱包</option>
            <option value="5">背包</option>
            <option value="6">其它</option>
        </select>
        <span>&nbsp;上车时间</span>
        <select id="startime" class="easyui-datetimebox " data-options="width:160,panelHeight:'auto',editable:false">
        </select>
        <span>&nbsp;下车时间</span>
        <select id="endtime" class="easyui-datetimebox" data-options="width:160,panelHeight:'auto',editable:false">
        </select>
        <label>&nbsp;查找结果</label>
        <select id="state" class="easyui-combobox" data-options="width:80,panelHeight:'auto',editable:false">
            <option value="-1">全部</option>
            <option value="0">未处理</option>
            <option value="1">已退回客户</option>

        </select>

    </div>
    <div style="margin:  0 0 10px 10px;">
        <button id="search" type="button" class="easyui-linkbutton" iconCls="icon-search" style="padding:0 10px">查找
        </button>
        <button id="reset" type="button" class="easyui-linkbutton" style="padding:0 10px">重置</button>
        <button id="add" type="button" class="easyui-linkbutton" style="padding:0 10px">添加</button>
        <button id="modify" type="button" class="easyui-linkbutton" style="padding:0 10px">修改</button>
        <button id="delete" type="button" class="easyui-linkbutton" style="padding:0 10px">删除</button>
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
        acquireData('', '', -1, -1, '');

        /*
         ** 查询
         */
        $("#search").click(function () {
            var startime = $('#startime').datetimebox("getValue");
            var endtime = $("#endtime").datetimebox("getValue");
            var classify = $("#classify").combobox("getValue");
            var state = $("#state").combobox("getValue");
            var key = $("#key").textbox("getValue");
            acquireData(startime, endtime, classify, state, key);
        });

        /*
         ** 重置
         */
        $("#reset").on("click", function () {
            $('#startime').datetimebox("setValue", "");
            $("#endtime").datetimebox("setValue", "");
            $("#classify").combobox("setValue", -1);
            $("#results").combobox("setValue", -1);
            $("#key").textbox("setValue", "");
            acquireData('', '', -1, -1, '');
        });

        /*
         ** 添加
         */
        $("#add").click(function () {
            var dialog = phm.modalDialog({
                title: '失物添加',
                //width: 可自己设置宽度,
                //height: 可自己设置高度,
                closable: true,
                url: "lostlibrary_add.jsp?id=0",
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
                        url: path + "/lostlibrary/delLostLibraryByid?id=" + row.id + "&token=" + token + "&clientid=" + globab_clientId,
                        dataType: "json",
                        type: "GET",
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
         ** 修改
         */
        $("#modify").click(function () {
            var row = grid.datagrid("getSelected");
            if (row == null) {
                $.messager.alert('警告', "请选择要修改的记录", 'info');
                return;
            }
            var dialog = phm.modalDialog({
                title: '修改司机信息',
                closable: true,
                url: "lostlibrary_add.jsp?id=" + row.id,
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
        function acquireData(startime, endtime, classify, state, key) {
            var dataUrl = "startime=" + startime +
                "&endtime=" + endtime +
                "&getonstartime=&getonendtime=&classify=" + classify +
                "&state=" + state +
                "&clientid=" + globab_clientId +
                "&token=" + token +
                "&order=desc&sort=id&key=" + key;
            grid = $("#redataGril").datagrid({
                fit: true,
                url: path + "/lostlibrary/findLostLibraryForPageList?" + dataUrl,
                fitColumns: true,
                striped: true,
                columns: [
                    [
                        {field: 'name', title: '司机姓名', width: 100, align: 'center', sortable: true},
                        {field: 'phone', title: '联系电话', width: 100, align: 'center', sortable: true},
                        {
                            field: 'classify', title: '分类', width: 100, align: 'center',
                            formatter: function (value) {
                                switch (value) {
                                    case 1 :
                                        return "钥匙";
                                        break;
                                    case 2 :
                                        return "手机";
                                        break;
                                    case 3 :
                                        return "电脑";
                                        break;
                                    case 4 :
                                        return "钱包";
                                        break;
                                    case 5 :
                                        return "背包";
                                        break;
                                    case 6 :
                                        return "其他";
                                        break;
                                    default :
                                        return "";
                                }
                            }
                        },
                        {
                            field: 'createtime', title: '入库时间', width: 100, align: 'center'
                        },
                        {
                            field: 'geton', title: '客户上车时间', width: 100, align: 'center'
                        },
                        {
                            field: 'getoff', title: '客户下车时间', width: 100, align: 'center'
                        },
                        {field: 'kabnum', title: '所在车辆', width: 100, align: 'center'},
                        {
                            field: 'state', title: '查找结果', width: 100, align: 'center',
                            formatter: function (value) {
                                switch (value) {
                                    case 0 :
                                        return "未处理";
                                        break;
                                    case 1 :
                                        return "已退回客户";
                                        break;
                                    default :
                                        return "";
                                }
                            },
                            styler: function (value) {
                                if (value == 0) {
                                    return "color:red;";
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
        }
    });
</script>
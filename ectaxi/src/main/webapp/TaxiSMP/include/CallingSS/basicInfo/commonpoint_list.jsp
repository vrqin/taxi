<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>常用约车点</title>

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
<body id="body" class="easyui-layout" data-options="border:true ,fit:true">

<!-- 数据表格 -->
<table id="redataGril"></table>

<!-- 工具栏 -->
<div id="toolbar">
    <div id="input">
        <span>位置描述</span>
        <input id="position" class="easyui-textbox" style="width:160px;">
        <span>&nbsp;联系电话</span>
        <input id="phone" class="easyui-textbox" style="width:160px;">
        <span>&nbsp;类型</span>
        <select id="type" class="easyui-combobox" data-options="width:80,panelHeight:'auto',editable:false">
            <option value="-1">全部</option>
            <option value="0">景点</option>
            <option value="1">宾馆</option>
            <option value="2">其它</option>
        </select>
    </div>
    <div id="button">
        <button class="easyui-linkbutton" id="search" data-options="iconCls:'icon-search'">查询</button>
        <button class="easyui-linkbutton" id="reset">重置</button>
        <button class="easyui-linkbutton" id="add">添加</button>
        <button class="easyui-linkbutton" id="edit">修改</button>
        <button class="easyui-linkbutton" id="delete">删除</button>
    </div>
</div>

</body>
</html>

<script>
    var token = sessionStorage.account;
    var globab_clientId = sessionStorage.clientId;
    $(function () {

        /*
        ** 变量声明
        */
        var grid;
        /*
        ** 默认加载
        */
        acquireData(-1, '', '', '');

        /*
        ** 查询
        */
        $("#search").on("click", function () {
            var position = $("#position").textbox('getValue');
            var phone = $("#phone").textbox('getValue');
            var type = $("#type").combobox('getValue');
            acquireData(type, position, '', phone);
        });

        /*
        ** 重置
        */
        $("#reset").on("click", function () {
            $("#position").textbox("setValue", "");
            $("#phone").textbox("setValue", "");
            $("#type").combobox('setValue', '-1');
            acquireData(-1, '', '', '');
        });

        /*
        ** 添加
        */
        $("#add").click(function () {
            var dialog = phm.modalDialog({
                title: '添加常用约车点',
                //width: 可自己设置宽度,
                //height: 可自己设置高度,
                closable: true,
                url: "commonpoint_add.jsp",
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
                title: '添加常用约车点',
                //width: 可自己设置宽度,
                //height: 可自己设置高度,
                closable: true,
                url: "commonpoint_add.jsp?id=" + row.id,
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
                    var requestURL = path + '/commonpoint/delCommonPointByid?id=' + row.id + "&token=" + token + "&clientid=" + globab_clientId;
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
        function acquireData(type, position, geographical, phone) {
            var dataUrl = "type=" + type +
                "&order=desc&sort=id&geographical=" + geographical +
                "&position=" + position +
                "&phone=" + phone +
                "&clientid=" + globab_clientId +
                "&token=" + token;
//			////console.info(dataUrl);
            grid = $("#redataGril").datagrid({
                fit: true,
                url: path + "/commonpoint/findCommonPointForPageList?" + dataUrl,
                fitColumns: true,
                striped: true,
                columns: [
                    [
                        {field: 'position', title: '位置描述', width: 100, align: 'center', sortable: true},
                        {
                            field: 'type', title: '类型', width: 100, align: 'center', sortable: true,
                            formatter: function (value) {
                                switch (value) {
                                    case 0 :
                                        return "景点";
                                        break;
                                    case 1:
                                        return "宾馆";
                                        break;
                                    case 2:
                                        return "其它";
                                        break;
                                    default:
                                        return "";
                                }
                            }
                        },
                        {field: 'phone', title: '电话号码', width: 100, align: 'center'},
                        {field: 'geographical', title: '地理位置', width: 100, align: 'center'}
                    ]
                ],
                onLoadSuccess: function (data) {
                    ////console.info(data);
                },
                idField: 'id',
                sortName: 'id',
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
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>驾驶员信息</title>

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

</head>
<body id="body" class="easyui-layout" data-options="fit:true">

<!-- 数据表格 -->
<table id="redataGril"></table>

<!-- 工具栏 -->
<div id="toolbar">
    <div id="input">
        <span>关键字</span>
        <input id="key" class="easyui-textbox" data-options="width:180" prompt="司机名字 |司机帐号 | 联系电话 | 企业名称">
        <span>&nbsp;在线状态</span>
        <select id="isonline" class="easyui-combobox" data-options="width:80,panelHeight:'auto',editable:false">
            <option value="-1" selected>全部</option>
            <option value="1">在线</option>
            <option value="0">离线</option>
        </select>
        <span>&nbsp;是否禁用</span>
        <select id="isstop" class="easyui-combobox" data-options="width:80,panelHeight:'auto',editable:false">
            <option value="-1" selected>全部</option>
            <option value="1">是</option>
            <option value="0">否</option>
        </select>

        <span>所属公司</span>
        <input id="company" class="easyui-combobox" data-options="editable:false,required:true"/>
    </div>
    <div id="button">
        <button class="easyui-linkbutton" id="search" iconCls="icon-search">查询</button>
        <button class="easyui-linkbutton" id="reset">重置</button>
        <button class="easyui-linkbutton" id="add">添加</button>
        <button class="easyui-linkbutton" id="modify">修改</button>
        <button class="easyui-linkbutton" id="delete">删除</button>
        <button class="easyui-linkbutton" id="resetPassword">重置密码</button>
        <button class="easyui-linkbutton" id="setDisable">禁用/可用</button>
        <button class="easyui-linkbutton" id="export">导出</button>
        <button class="easyui-linkbutton" id="import">导入</button>
        <button class="easyui-linkbutton" id="download">导入模版</button>
        <button class="easyui-linkbutton" id="recharg">设置使用次数</button>
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
        var token = sessionStorage.account;
        var globab_clientId = sessionStorage.clientId;
        /*
        ** 默认加载
        */
        acquireData(-1, -1, '', globab_clientId);


        $("#company").combobox({
            url: path + '/client/findclienttree?clientid=' + globab_clientId,
            method: 'GET',
            valueField: 'id',
            textField: 'text',
            onLoadSuccess: function (data) {
                ////console.info(data);
                if (globab_clientId != 0) {
                    $(this).combobox("setValue", globab_clientId);

                }
            }
        });

        /*
        ** 查询
        */
        $("#search").click(function () {
            var key = $("#key").textbox("getValue");
            var isonline = $('#isonline').combobox("getValue");
            var isstop = $("#isstop").combobox("getValue");
            var clientid = $("#company").combobox('getValue');
            acquireData(isonline, isstop, key, clientid);
        });

        /*
         ** 重置
         */
        $("#reset").on("click", function () {
            $("#key").textbox("setValue", "");
            $("#isonline").combobox('setValue', '-1');
            $("#isstop").combobox('setValue', '-1');
            acquireData(-1, -1, '', globab_clientId);
        });


        /*
        ** 添加
        */
        $("#add").click(function () {
            var dialog = phm.modalDialog({
                title: '添加',
                width: 900,
                height: 560,
                closable: true,
                url: "driver_add.jsp?driverid=0",
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
            if (grid.datagrid("getSelections").length > 1) {
                $.messager.alert('警告', "一次只能修改一条记录", 'info');
                return;
            }
            var row = grid.datagrid("getSelected");
//          ////console.info(row);
            if (row == null) {
                $.messager.alert('警告', "请选择要修改的记录", 'info');
                return;
            }
            var dialog = phm.modalDialog({
                title: '修改',
                width: 900,
                height: 560,
                closable: true,
                url: "driver_add.jsp?driverid=" + row.driverid,
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
            var row = grid.datagrid("getSelections");
            if (row == null) {
                $.messager.alert('警告', "选择删除的记录", 'info');
                return;
            }
            $.messager.confirm('确认', '您确认想要删除记录吗？', function (r) {
                if (r) {
                    var tempID = row[0].driverid;
                    for (i = 1; i < row.length; i++) {
                        tempID += "," + row[i].driverid;

                    }

                    var requestURL = path + "/driver/delDriverByids?driverids=" + tempID + "&token=" + token + "&clientid=" + globab_clientId;

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
                        url: path + "/driver/setPasswordbyDriverid?driverid=" + row.driverid + "&token=" + token + "&clientid=" + globab_clientId,
                        data: {driverid: row.driverid},
                        dataType: "json",
                        type: "GET",
                        success: function (data) {
//                        	   ////console.info(data);
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
         ** 修改可以可使用次数
         */
        $("#recharg").click(function () {
            var row = grid.datagrid("getSelected");

            if (row == null) {
                $.messager.alert('警告', "请选择要修改的记录", 'info');
                return;
            }


            $.messager.prompt('提示信息', '请输入可抢单次数：', function (r) {

                if (r) {
                    var row = grid.datagrid("getSelections");
                    var tempID = row[0].driverid;
                    for (i = 1; i < row.length; i++) {
                        tempID += "," + row[i].driverid;
                    }
                    $.ajax({
                        url: path + "/driver/updateRemain?ids=" + tempID + "&remain=" + r,
                        data: {driverid: row.driverid},
                        dataType: "json",
                        type: "POST",
                        success: function (data) {
                            //console.info(data);
                            if (data[0].desc.indexOf("成功") > -1) {
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
                        url: path + "/driver/isStopbyDriverid?driverid=" + row.driverid + "&token=" + token + "&clientid=" + globab_clientId,
                        data: {driverid: row.driverid},
                        dataType: "json",
                        type: "GET",
                        success: function (data) {
//                        	   ////console.info(data);
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

        //导出模板
        $("#download").click(function () {
            window.location.href = path + "/files/driverTemplate";
        });

        //导出
        $("#export").click(function () {
            var key = $("#key").textbox("getValue");
            var isonline = $('#isonline').combobox("getValue");
            var isstop = $("#isstop").combobox("getValue");
            var clientid = $("#company").combobox("getValue");
            var dataurl = "isonline=" + isonline + "&isstop=" + isstop + "&key=" + key + "&token=" + token + "&clientid=" + clientid;

            window.location.href = path + "/files/exportDriverInfo?" + dataurl;
        });

        //导入
        $("#import").click(function () {
            var dialog = phm.modalDialog({
                title: '导入司机信息(只能使用office Excel)',
                maximizable: false,
//				width: screenwidth,
//				height: screenheight,
                closable: true,
                url: "driver_import.jsp",
                buttons: [
                    {
                        text: '关闭',
                        iconCls: 'icon-cancel',
                        handler: function () {
                            dialog.dialog("close");
                        }
                    }
                ],
                onDestroy: function () {
                    grid.datagrid('reload');
                }

            });
        });


        /*
        ** 获取数据
        */
        function acquireData(isonline, isstop, key, clientid) {
            var dataurl = path + "/driver/findDriverForPageList?startime=&endtime=&isonline=" + isonline +
                "&order=desc&sort=createtime&isstop=" + isstop + "&key=" + key + "&clientid=" + clientid + "&token=" + token;
//			////console.info(dataurl);
            grid = $("#redataGril").datagrid({
                fit: true,
                url: dataurl,
                fitColumns: true,
                method: "get",
                striped: true,
                columns: [
                    [
                        {field: 'ck', checkbox: true},
                        {field: 'name', title: '司机姓名', width: 100, align: 'center', sortable: true},
                        {
                            field: 'sex', title: '性别', width: 100, align: 'center', sortable: true,
                            formatter: function (value) {
                                switch (value) {
                                    case 0 :
                                        return "男";
                                        break;
                                    case 1:
                                        return "女";
                                        break;
                                    default:
                                        return "";
                                }
                            }
                        },
                        {field: 'account', title: '登录帐号', width: 100, align: 'center', sortable: true},
                        {field: 'kabnum', title: '车牌号码', width: 100, align: 'center'},
                        {field: 'phone', title: '联系电话', width: 100, align: 'center'},
                        {field: 'remain', title: '可使用次数', width: 100, align: 'center'},
                        {
                            field: 'isonline', title: '在线状态', width: 100, align: 'center',
                            formatter: function (value) {
                                switch (value) {
                                    case 0 :
                                        return "离线";
                                        break;
                                    case 1:
                                        return "在线";
                                        break;
                                    default:
                                        return "";
                                }
                            },
                            styler: function (value) {
                                switch (value) {
                                    case 0 :
                                        return "color:gray;";
                                        break;
                                    case 1:
                                        return "color:green;";
                                        break;
                                }
                            }
                        },
                        {
                            field: 'isstop', title: '是否禁用', width: 100, align: 'center',
                            formatter: function (value) {
                                switch (value) {
                                    case 0 :
                                        return "否";
                                        break;
                                    case 1:
                                        return "是";
                                        break;
                                    default:
                                        return "";
                                }
                            },
                            styler: function (value) {
                                switch (value) {
                                    case 1:
                                        return "color:red;";
                                        break;
                                }
                            }
                        },
                        {field: 'createtime', title: '创建时间', width: 100, align: 'center'},
                        {field: 'gpstime', title: '最后定位时间', width: 100, align: 'center'},
                        {field: 'company', title: '所属公司', width: 100, halign: 'center'}
                    ]
                ],
                onLoadSuccess: function (data) {
//					////console.info(data);
                },
                sortName: 'phone',
                sortOrder: 'desc',
                singleSelect: false,
                selectOnCheck: true,
                pagination: true,
                pageSize: 20,
                pageList: [20, 40, 60, 80],
                rownumbers: true,
                toolbar: '#toolbar'
            });

        }//function acquireData();结束

    });


</script>
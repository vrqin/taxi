<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>车辆管理</title>

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

    <style>
        .openrelation {
            color: red;
            font-size: 14px;
        }
    </style>
</head>
<body id="body" class="easyui-layout" data-options="fit:true">

<!-- 数据表格 -->
<table id="redataGril">

</table>

<!-- 工具栏 -->
<div id="toolbar">
    <div id="input">
        <span>关键字</span>
        <input id="key" class="easyui-textbox" data-options="width:180" prompt="所属公司 | 车牌号码 | SIM卡号">
        <span>所属公司</span>
        <input id="company" class="easyui-combobox" data-options="editable:false,required:true"/>

    </div>
    <div id="button">
        <button class="easyui-linkbutton" id="search" iconCls="icon-search">查询</button>
        <button class="easyui-linkbutton" id="reset">重置</button>
        <button class="easyui-linkbutton" id="add">添加</button>
        <button class="easyui-linkbutton" id="modify">修改</button>
        <button class="easyui-linkbutton" id="delete">删除</button>
        <button class="easyui-linkbutton" id="export">导出</button>
        <button class="easyui-linkbutton" id="import">导入</button>
        <button class="easyui-linkbutton" id="download">导入模版</button>

        <%--<button class="easyui-linkbutton"> 重置密码</button>--%>
        <%--<button class="easyui-linkbutton"> 导出</button>--%>
        <%--<button class="easyui-linkbutton"> 同步司机信息</button>--%>
    </div>
</div>

</body>
</html>
<script>//onChange: function ( a , b ) { test( a, b );}
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
    acquireData("", "", "", globab_clientId);

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
    $("#search").on("click", function () {
        var key = $("#key").textbox("getValue");
        var clientid = $("#company").combobox('getValue');
        acquireData(key, "", "", clientid)
    });

    /*
     ** 重置
     */
    $("#reset").on("click", function () {
        $("#key").textbox("setValue", "");
        acquireData("", "", "", globab_clientId)
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
            url: "carinfo_add.jsp?id=0",
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
            url: "carinfo_add.jsp?id=" + row.id,
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
                var tempID = row[0].id;
                for (i = 1; i < row.length; i++) {
                    tempID += "," + row[i].id;
                }
                console.log(tempID);

                var requestURL = path + "/carinfo/delCarinfoList?ids=" + tempID + "&token=" + token;

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


    //导出模板
    $("#download").click(function () {
        window.location.href = path + "/files/carinfoTemplate";
    });

    //导出
    $("#export").click(function () {
        var key = $("#key").textbox("getValue");
        var clientid = $("#company").combobox("getValue");
        var dataurl = "key=" + key + "&token=" + token + "&clientid=" + clientid;

        window.location.href = path + "/files/exportCarInfo?" + dataurl;
    });

    //导入
    $("#import").click(function () {
        var dialog = phm.modalDialog({
            title: '导入车辆信息(只能使用office Excel)',
            maximizable: false,
//				width: screenwidth,
//				height: screenheight,
            closable: true,
            url: "carinfo_import.jsp",
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
    function acquireData(key, begintime, endtime, clientId) {
        var dataUrl = "order=desc&sort=id&key=" + key +
            "&begintime=" + begintime +
            "&endtime=" + endtime +
            "&clientid=" + clientId;
        grid = $("#redataGril").datagrid({
            fit: true,
            url: path + "/carinfo/findCarinfoForPageList?" + dataUrl,
            fitColumns: true,
            striped: true,
            columns: [
                [
                    {field: 'ck', checkbox: true},
                    {field: 'kabnum', title: '车牌号码', width: 100, align: 'center', sortable: true},
                    {field: 'company', title: '所属公司', width: 100, align: 'center', sortable: true},
                    {field: 'vehicleid', title: '行驶证', width: 100, align: 'center'},
                    {
                        field: 'mileage', title: '里程', width: 100, align: 'center',
                        formatter: function (value, row, index) {
                            if (value == 20001) return "1万公里内";
                            if (value == 20002) return "2万公里内";
                            if (value == 20003) return "3万公里内";
                            return value;
                        }
                    },
                    {
                        field: 'models', title: '车型', width: 100, align: 'center',
                        formatter: function (value, row, index) {
                            if (value == 10001) return "两厢轿车";
                            if (value == 10002) return "三厢轿车";
                            if (value == 10003) return "跑车";
                            if (value == 10004) return "SUV";
                            if (value == 10005) return "MPV";
                            return value;
                        }
                    },
                    {field: 'yearcareful', title: '年审', width: 100, align: 'center', sortable: true},
                    {
                        field: 'displacement', title: '排量', width: 100, align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            if (value == 30001) return "1.0L以下";
                            if (value == 30002) return "1.0-1.6L";
                            if (value == 30003) return "1.6-2.0L";
                            if (value == 30004) return "2.0-3.0L";
                            if (value == 30005) return "3.0L以上";
                            return value;
                        }
                    },
                    {
                        field: 'carcount', title: '绑定司机数', width: 100, align: 'center', sortable: true,
                        formatter: function (value, row, index) {
                            var codes = row["id"];
                            ////console.info(codes);
                            if (value > 0) {
                                return '<span class="openrelation" onclick="openrelation(id)" id=' + codes + '>' + value + '</span>';
                            } else {
                                return value;
                            }

                        }
                    }

                ]
            ],
            onLoadSuccess: function (data) {
                ////console.info(data);
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
    }
});

//查看司机信息
function openrelation(data) {
//		////console.info(data);
    var dialog = phm.modalDialog({
        title: '查看司机信息',
        //width: 可自己设置宽度,
        //height: 可自己设置高度,
        closable: true,
        url: "carinfo_driverinfo_list.jsp?id=" + data,
        buttons: [
            {
                text: '取消',
                iconCls: 'icon-cancel',
                handler: function () {
                    dialog.dialog("close");
                }
            }
        ]
    });
}

Date.prototype.format = function (format) {
    var args = {
        "M+": this.getMonth() + 1,
        "d+": this.getDate(),
        "h+": this.getHours(),
        "m+": this.getMinutes(),
        "s+": this.getSeconds(),
        "q+": Math.floor((this.getMonth() + 3) / 3),  //quarter
        "S": this.getMilliseconds()
    };
    if (/(y+)/.test(format)) N
    format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var i in args) {
        var n = args[i];
        if (new RegExp("(" + i + ")").test(format))
            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? n : ("00" + n).substr(("" + n).length));
    }
    return format;
};


</script>
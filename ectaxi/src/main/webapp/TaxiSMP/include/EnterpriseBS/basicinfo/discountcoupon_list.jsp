<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>优惠券</title>

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
    <style>
        .openrelation {
            color: red;
        }
    </style>
</head>
<body id="body" class="easyui-layout" data-options="fit:true">

<!-- 数据表格 -->
<table id="redataGril"></table>

<!-- 工具栏 -->
<div id="toolbar">
    <div id="input">
        <label>查询:</label>
        <input id="key" class="easyui-textbox" data-options="width:180" prompt=" 名称 ">

    </div>
    <div id="button">
        <button class="easyui-linkbutton" id="search" iconCls="icon-search">查询</button>
        <button class="easyui-linkbutton" id="reset">重置</button>
        <button class="easyui-linkbutton" id="add">添加</button>
        <button class="easyui-linkbutton" id="modify">修改</button>
        <%--<button class="easyui-linkbutton" id="delete" >删除</button>--%>
        <%--<button class="easyui-linkbutton" id="history" >发布记录</button>--%>

    </div>
</div>


</body>
</html>

<script>
    var grid;
    var token = sessionStorage.account;
    var globab_clientId = sessionStorage.clientId;
    var globab_account = sessionStorage.accountName;
    $(function () {
        if (globab_clientId == 0) {

        }


        /*
         ** 默认加载
         */
        acquireData("", "", "");

        /*
         ** 查询
         */
        $("#search").click(function () {
            var key = $("#key").textbox("getValue");
            acquireData(key);
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
            url: "discountcoupon_add.jsp?id=0",
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
            width: 900,
            height: 560,
            closable: true,
            url: "discountcoupon_add.jsp?id=" + row.id,
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

        $.messager.confirm('确认', '您确认想要删除记录吗？', function (r) {
            if (r) {

                var requestURL = path + "/notifierPlus/delNotifierPlusByid?id=" + row.id + "&token=" + token;

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


    //查看司机信息
    function openrelation(data) {
        //console.info(data);
        var dialog = phm.modalDialog({
            title: '发券记录',
            width: 900,
            height: 560,
            closable: true,
            url: "discountPassenger_list.jsp?id=" + data,
            buttons: [
                {
                    text: '关闭',
                    iconCls: 'icon-cancel',
                    handler: function () {
                        dialog.dialog("close");
                    }
                }
            ]

        });
    }

    /*
     ** 获取数据
     */
    function acquireData(key) {

        var dataUrl = 'sort=creattime&order=desc&begintime=&endtime=&key=' + key + "&clientid=" + globab_clientId;
        grid = $("#redataGril").datagrid({
            fit: true,
            url: path + "/discountCoupon/findDiscountCouponForPageList?" + dataUrl,
            fitColumns: true,
            striped: true,
            columns: [
                [
                    {field: 'clientName', title: '所属公司', width: 100, align: 'center', sortable: true},
                    {field: 'name', title: '名称', width: 100, align: 'center', sortable: true},
                    {
                        field: 'type', title: '类型', width: 100, align: 'center', sortable: true,
                        formatter: function (value) {
                            return getValueFromArray(value, discountvalue);
                        },
                        styler: function (value, row, index) {
                            if (value == 1) {
                                return 'color:red;';
                            } else {
                                return 'color:green;';
                            }
                        }

                    },
                    {
                        field: 'isvalid', title: '是否启动', width: 100, align: 'center', sortable: true,
                        formatter: function (value) {
                            return getValueFromArray(value, isvalid);
                        },
                        styler: function (value, row, index) {
                            if (value == 0) {
                                return 'color:red;';
                            } else {
                                return 'color:#c8c8c8;';
                            }
                        }


                    },
                    {
                        field: 'money', title: '金额或折扣', width: 100, align: 'center', sortable: true
//                        formatter: function (value, row, index) {
//                            var type = row["type"];
//                            if (type==1){
//                                return value
//                            }else if (type==2){
//                                return (value*100) +"%";
//                            }
//                        }
                    },
//                    {field: 'discNum', title: '券数目', width: 100, align: 'center',sortable:true,
//                        formatter : function(value){
//                            if(value==(-1)){
//                                return "不限制";
//                            }else {
//                                return value;
//                            }
//
//                        }
//                    },
                    {field: 'serviceConditions', title: '消费金额', width: 100, align: 'center', sortable: true},
                    {field: 'maxDeduction', title: '最大抵扣金额', width: 100, align: 'center', sortable: true},
                    {field: 'valid', title: '有效天数', width: 100, align: 'center', sortable: true},
                    {field: 'creattime', title: '创建时间', width: 100, align: 'center', sortable: true},
                    {field: 'starttime', title: '打车劵活动开始时间', width: 100, align: 'center', sortable: true},
                    {field: 'endtime', title: '打车劵活动结束时间', width: 100, align: 'center', sortable: true},
                    {
                        field: 'option', title: '操作', width: 50, align: 'center',
                        formatter: function (value, row, index) {
                            var codes = row["id"];
                            return '<span class="openrelation" onclick="openrelation(id)" id=' + codes + '>发券记录</span>';
                        }
                    }
                ]
            ],
            onLoadSuccess: function (data) {
                console.info(data);
            },
            idField: 'creattime',
            sortName: 'creattime',
            sortOrder: 'desc',
            singleSelect: true,
            pagination: true,
            pageSize: 20,
            pageList: [20, 40, 60, 80],
            rownumbers: true,
            toolbar: '#toolbar'
        });

    }

    //function acquireData();结束


</script>


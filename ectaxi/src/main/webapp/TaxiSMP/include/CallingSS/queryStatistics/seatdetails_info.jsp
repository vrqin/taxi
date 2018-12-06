<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>坐席统计</title>

    <!-- jquery easyui 插件 -->
    <link href="../../../public/jquery-easyui-1.5/themes/metro/easyui.css" rel="stylesheet"/>
    <link href="../../../public/jquery-easyui-1.5/themes/icon.css" rel="stylesheet"/>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.easyui.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/easyui-lang-zh_CN.js"></script>

    <!-- childstyle -->
    <link rel="stylesheet" type="text/css" href="../../../public/css/childstyle.css"/>
    <script src="../../../public/js/utiljavascript.js"></script>

    <!-- 数据接口路径、共用JS -->
    <script src="../../../public/js/path.js"></script>
    <script src="../../../public/js/constant.js"></script>

</head>
<body id="body" class="easyui-layout" data-options="fit:true">

<!-- 数据表格 -->
<table id="redataGril"></table>

<!-- 工具栏 -->
<%--<div id="toolbar" >--%>
<%--&lt;%&ndash;<div id="input">&ndash;%&gt;--%>
<%--&lt;%&ndash;&ndash;%&gt;--%>
<%--&lt;%&ndash;<span >&nbsp;开始时间</span>&ndash;%&gt;--%>
<%--&lt;%&ndash;<input id="startime" class="easyui-datetimebox " data-options="width:160,panelHeight:'auto',editable:false" />&ndash;%&gt;--%>
<%--&lt;%&ndash;<span >至</span>&ndash;%&gt;--%>
<%--&lt;%&ndash;<input id="endtime" class="easyui-datetimebox" data-options="width:160,panelHeight:'auto',editable:false" />&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>
<%--<div id="button">--%>
<%--<button class="easyui-linkbutton" id="search" iconCls="icon-search">查询</button>--%>
<%--<button class="easyui-linkbutton" id="reset" >重置</button>--%>
<%--<button class="easyui-linkbutton" id="export">导出</button>--%>
<%--&lt;%&ndash;<button class="easyui-linkbutton" id="isblack" >添加黑名单</button>&ndash;%&gt;--%>
<%--</div>--%>
<%--</div>--%>

</body>
</html>

<script>
    var token = sessionStorage.account;
    var globab_clientId = sessionStorage.clientId;
    var globab_value = "";
    var globab_flag = "";
    var startime = "${param.startime}";
    var endtime = "${param.endtime}";
    var key = "${param.opruser}";
    var status = -1;
    var ordertype = -1;
    console.info("${param.startime}");
    console.info("${param.endtime}");
    console.info("${param.opruser}");
    $(function () {

        /*
        ** 变量声明
        */
        var grid;
        /*
         ** 默认加载
         */

        acquireData(startime, endtime, -1, -1, key);


        /*
        ** 获取数据
        */
        function acquireData(startime, endtime, status, ordertype, key) {

            var DataUrl = "startime=" + startime + "&endtime=" + endtime + "&status=" + status + "&ordertype=" + ordertype + "&order=desc&sort=billid&key=" + key + "&clientid=" + globab_clientId;

            grid = $("#redataGril").datagrid({
                fit: true,
                url: path + "/callbuss/findCallBussForPageListByOpruser?" + DataUrl,
                fitColumns: true,
                striped: true,
                columns: [
                    [
                        {field: 'billid', title: '订单号', width: 150, align: 'center'},
                        {
                            field: 'calltime', title: '电召时间', width: 150, align: 'center'
                        },
                        {field: 'clientmobile', title: '乘客电话', width: 100, align: 'center'},
                        {field: 'srcaddr', title: '起点', width: 100, align: 'center'},
                        {field: 'address', title: '终点', width: 100, align: 'center'},
                        {
                            field: 'orderType', title: '订单类型', width: 100, align: 'center', sortable: true,
                            formatter: function (value) {
                                if (value != null || value != undefined) {
                                    globab_flag = value;
                                    return getValueFromArray(value, ordtype);
                                } else {
                                    return "";
                                }
                            }
                        },
                        {
                            field: 'status', title: '状态', width: 100, align: 'center', sortable: true,
                            formatter: function (value) {
                                if (value != null || value != undefined) {
                                    globab_value = value;
                                    return getValueFromArray(value, ordstartus);
                                } else {
                                    return "";
                                }
                            }
                        },
                        {
                            field: 'driver', title: '司机名称', width: 100, align: 'center', sortable: true,
                            formatter: function (value) {
                                if (value != null || value != undefined) {
                                    return value.name;
                                } else {
                                    return "";
                                }
                            }
                        },
                        {field: 'driverphone', title: '司机号码', width: 100, align: 'center', sortable: true},
                        {field: 'carbox', title: '车牌号', width: 100, align: 'center', sortable: true},
                        {
                            field: 'paytype', title: '支付方式', width: 100, align: 'center', sortable: true,
                            formatter: function (value) {
                                //console.info(globab_value);
                                if (value != null || value != undefined) {
                                    if (globab_value != 3) {

                                        return getValueFromArray(value, paytypecom);
                                    } else {
                                        return "";
                                    }

                                } else {
                                    return "";
                                }
                            }
                        },
                        {field: 'money', title: '交易金额', width: 50, align: 'center', sortable: true},
                        {
                            field: 'evaluate', title: '评价', width: 50, align: 'center', sortable: true,
                            formatter: function (value) {
                                if (value != undefined) {
                                    return value + "星";
                                } else {
                                    return " ";
                                }

                            }
                        },
                        {
                            field: 'opruser', title: '调度人员', width: 100, align: 'center', sortable: true,
                            formatter: function (value) {

                                if (globab_flag == 2) {
                                    return value;
                                } else {
                                    return "";
                                }
                            }
                        }
//						,
//						{field: 'option', title: '操作', width: 50, align: 'center',
//							formatter: function (value, row, index) {
//								var codes = row["billid"];
//								return'<span class="openrelation" onclick="openrelation(id)" id=' + codes + '>查看</span>';
//							}
//						}
                    ]
                ],
                onLoadSuccess: function (data) {
                    ////console.info(data);
                },
                idField: 'billid',
                sortName: 'billid',
                sortOrder: 'desc',
                singleSelect: true,
                pagination: true,
                pageSize: 20,
                pageList: [20, 40, 60, 80],
                rownumbers: true
//				toolbar: '#toolbar'
            });
        }//function acquireData();结束


    });

    function completedForm() {

        var dataurl = "startime=" + startime + "&endtime=" + endtime + "&key=" + key + "&token=" + token + "&clientid=" + globab_clientId + "&status=" + status + "&ordertype=" + ordertype;
        console.info(dataurl);
        window.location.href = path + "/files/exportOrderdetails?" + dataurl;

    }	//function completedForm()结束
</script>
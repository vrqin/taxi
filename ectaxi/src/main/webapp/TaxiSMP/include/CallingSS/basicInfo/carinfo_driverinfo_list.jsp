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

    <div id="button">

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
        var kabnumid = '${param.id}';

        /*
        ** 默认加载
        */
        acquireData(kabnumid);

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
        ** 获取数据
        */
        function acquireData(id) {
            var dataurl = path + "/driver/findDriverForPageList?startime=&endtime=&isonline=-1" +
                "&order=desc&sort=createtime&isstop=-1&key=&token=" + token + "&kabnumid=" + id + "&clientid=" + globab_clientId;
//			////console.info(dataurl);
            grid = $("#redataGril").datagrid({
                fit: true,
                url: dataurl,
                method: "get",
                fitColumns: true,
                striped: true,
                columns: [
                    [
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
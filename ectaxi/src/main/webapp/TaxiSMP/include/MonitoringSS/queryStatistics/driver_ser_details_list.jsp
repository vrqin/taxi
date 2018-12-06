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
    <title>驾驶员服务明细</title>

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

</head>
<body id="body" class="easyui-layout" data-options="fit:true">

<!-- 数据表格 -->
<table id="redataGril"></table>

<!-- 工具栏 -->
<div id="toolbar">
    <div id="input">
        <span>关键字</span>
        <input id="key" class="easyui-textbox" style="width:240px;" prompt="司机名称 | 车牌号 | 电话号码 | 企业名称">
        <span>&nbsp;评级</span>
        <select id="rating" class="easyui-combobox" data-options="width:80,panelHeight:'auto',editable:false">
            <option value="" selected>全部</option>
            <option value="5">五星</option>
            <option value="4">四星</option>
            <option value="3">三星</option>
            <option value="2">二星</option>
            <option value="1">一星</option>
        </select>
    </div>
    <div id="button">
        <button class="easyui-linkbutton" id="search" data-options="iconCls:'icon-search'">查询</button>
        <button class="easyui-linkbutton" id="reset">重置</button>
        <button class="easyui-linkbutton" id="isblack">添加黑名单</button>
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
        acquireData('', '');

        /*
         ** 查询
         */
        $("#search").on("click", function () {
            var key = $('#key').textbox('getValue');
            var rating = $('#rating').textbox('getValue');
            acquireData(rating, key);
        });

        /*
         ** 重置
         */
        $("#reset").on("click", function () {
            $('#key').textbox('setValue', "");
            $('#rating').textbox('setValue', "");
            acquireData('', '');
        });

        /*
         ** 设置黑名单
         */
        $("#isblack").click(function () {
            var row = grid.datagrid("getSelected");
            if (row == null) {
                $.messager.alert('警告', "选择修改选项", 'info');
                return;
            }

            $.messager.confirm('确认', '您确认想要设置当前用户为黑名单？', function (r) {
                if (r) {
                    $.ajax({
                        url: path + "/driverintegrity/driverSetIsblack?phone=" + row.phone + "&isblack=1",
                        dataType: "json",
                        type: "GET",
                        success: function (data) {

                            if (data.desc.indexOf("成功") > -1) {
                                grid.datagrid("reload");
                                grid.datagrid("clearSelections");
                                $.messager.show({
                                    title: '提示',
                                    msg: "设置成功！",
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
        function acquireData(rating, key) {
            var dataUrl = "rating=" + rating + "&order=desc&sort=callnumber&key=" + key + "&clientid=" + globab_clientId;
            grid = $("#redataGril").datagrid({
                fit: true,
                url: path + "/driverintegrity/findDriverIntegrityForPageList?" + dataUrl,
                fitColumns: true,
                method: "get",
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
                                    case 1 :
                                        return "女";
                                        break;
                                    default:
                                        return "";
                                }
                            }
                        },
                        {field: 'kabnum', title: '车牌号', width: 100, align: 'center'},
                        {field: 'phone', title: '联系电话', width: 100, align: 'center'},
                        {field: 'enterprise', title: '所属公司', width: 100, align: 'center'},
//                  {field: 'integral', title: '召车积分', width: 100, align: 'center',sortable:true},
                        {
                            field: 'rating', title: '星级评价', width: 100, align: 'center', sortable: true,
                            formatter: function (value) {
                                if (value = "") {
                                    return "";
                                } else {
                                    return "";
                                }

                            }
                        },
                        {
                            field: 'isblacklist', title: '是否黑名单', width: 100, align: 'center', sortable: true,
                            formatter: function (value) {
                                switch (value) {
                                    case 0 :
                                        return "否";
                                        break;
                                    case 1 :
                                        return "是";
                                        break;
                                    default:
                                        return "否";
                                }
                            }
                        },
                        {field: 'callnumber', title: '总接单次数', width: 100, align: 'center', sortable: true},
                        {field: 'successnumber', title: '成功次数', width: 100, align: 'center', sortable: true},
                        {field: 'cancelnumber', title: '取消次数', width: 100, align: 'center', sortable: true},
                        {field: 'promisenumber', title: '爽约次数', width: 100, align: 'center', sortable: true},
                        {field: 'tomileage', title: '总里程(公里)', width: 100, align: 'center', sortable: true},
                        {field: 'tovainmileage', title: '总空驶里程(公里)', width: 100, align: 'center', sortable: true},
                        {field: 'toaccount', title: '支付记录', width: 100, align: 'center', sortable: true},
                        {field: 'tomoney', title: '总金额(元)', width: 100, align: 'center', sortable: true}
//						{field: 'c', title: '总附加费(元)', width: 100, align: 'center', sortable: true},
//                        {field: 'recoder', title: '接单记录', width: 100, align: 'center', sortable: true}

                    ]
                ],
                onLoadSuccess: function (data) {
                    ////console.info(data);
                },
                idField: 'callnumber',
                sortName: 'callnumber',
                sortOrder: 'desc',
                remoteSort: false,
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
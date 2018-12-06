<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>乘客黑名单</title>

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
        <input id="key" class="easyui-textbox" style="width:160px;" prompt="姓名 | 联系电话">
    </div>
    <div id="button">
        <button class="easyui-linkbutton" id="search" iconCls="icon-search">查询</button>
        <button class="easyui-linkbutton" id="reset">重置</button>
        <button class="easyui-linkbutton" id="isblack">取消黑名单</button>
    </div>
</div>

</body>
</html>

<script>
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

            acquireData(key);
        });

        /*
         ** 重置
         */
        $("#reset").on("click", function () {
            $('#key').textbox("setValue", "");
            acquireData('');
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

            $.messager.confirm('确认', '您确认想要取消黑名单？', function (r) {
                if (r) {
                    $.ajax({
                        url: path + "/passentegrity/passSetIsblack?phone=" + row.phone + "&isblack=0",
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
        function acquireData(key) {
            var dataUrl = "startime=&endtime=&key=" + key + "&order=desc&sort=callnumber&isblacklist=1&clientid=" + globab_clientId;
            grid = $("#redataGril").datagrid({
                fit: true,
                url: path + "/passentegrity/findPassenIntegrityForPageList?" + dataUrl,
                fitColumns: true,
                striped: true,
                columns: [
                    [
                        {field: 'phone', title: '联系电话', width: 100, align: 'center'},
                        {field: 'name', title: '乘客姓名', width: 100, align: 'center', sortable: true},
                        {field: 'integral', title: '叫车积分', width: 100, align: 'center', sortable: true},
//                  {field: 'rating', title: '评级', width: 100, align: 'center',sortable:true},
                        {field: 'callnumber', title: '总叫车次数', width: 100, align: 'center', sortable: true},
                        {field: 'successnumber', title: '电召成功数', width: 100, align: 'center', sortable: true},
                        {field: 'cancelnumber', title: '取消次数', width: 100, align: 'center', sortable: true},
                        {field: 'promisenumber', title: '爽约次数', width: 100, align: 'center', sortable: true},
                        {field: 'recode', title: '电召记录', width: 100, align: 'center', sortable: true}

                    ]
                ],
//          onLoadSuccess: function (data) {
//				
//          },
//          detailFormatter: function(rowIndex, rowData){
//          },
//          onDblClickRow: function(rowIndex, rowData){
//
//          },
//          onClickRow: function(rowIndex, rowData){
//
//          },
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
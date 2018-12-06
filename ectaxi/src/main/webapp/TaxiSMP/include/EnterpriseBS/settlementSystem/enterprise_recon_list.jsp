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
    <title>企业对账信息</title>

    <link href="../../../public/jquery-easyui-1.5/themes/metro/easyui.css" rel="stylesheet"/>
    <link href="../../../public/jquery-easyui-1.5/themes/icon.css" rel="stylesheet"/>

    <script src="../../../public/jquery-easyui-1.5/js/jquery.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.easyui.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/easyui-lang-zh_CN.js"></script>

    <style type="text/css">

    </style>

    <script>
        var grid;
        var data = [
            {
                "enterprise": "测试公司",
                "companyaccount": "testcs",
                "contact": "12345678910 ",
                "phone": "147852369874",
                "email": "test@qq.com",
                "area": "广州市"
            },
            {
                "enterprise": "测试公司",
                "companyaccount": "testcs",
                "contact": "12345678910 ",
                "phone": "147852369874",
                "email": "test@qq.com",
                "area": "广州市"
            },
            {
                "enterprise": "测试公司",
                "companyaccount": "testcs",
                "contact": "12345678910 ",
                "phone": "147852369874",
                "email": "test@qq.com",
                "area": "广州市"
            },
            {
                "enterprise": "测试公司",
                "companyaccount": "testcs",
                "contact": "12345678910 ",
                "phone": "147852369874",
                "email": "test@qq.com",
                "area": "广州市"
            },
            {
                "enterprise": "测试公司",
                "companyaccount": "testcs",
                "contact": "12345678910 ",
                "phone": "147852369874",
                "email": "test@qq.com",
                "area": "广州市"
            },
            {
                "enterprise": "测试公司",
                "companyaccount": "testcs",
                "contact": "12345678910 ",
                "phone": "147852369874",
                "email": "test@qq.com",
                "area": "广州市"
            },
            {
                "enterprise": "测试公司",
                "companyaccount": "testcs",
                "contact": "12345678910 ",
                "phone": "147852369874",
                "email": "test@qq.com",
                "area": "广州市"
            }
        ];
        $(function () {


            grid = $("#redataGril").datagrid({
                fit: true,
                data: data,
//                height: $("#dataview").height() -300+"px",
                fitColumns: true,
                striped: true,
                columns: [
                    [
                        {field: 'enterprise', title: '企业名称', width: fixWidth(0.1), align: 'center', sortable: true},
                        {field: 'companyaccount', title: '公司账户', width: fixWidth(0.1), align: 'center', sortable: true},
                        {field: 'contact', title: '联系人', width: fixWidth(0.1), align: 'center'},
                        {field: 'phone', title: '手机号码', width: fixWidth(0.1), align: 'center'},
                        {field: 'email', title: '电子邮箱', width: fixWidth(0.1), align: 'center'},
                        {field: 'area', title: '所在地区', width: fixWidth(0.1), align: 'center', sortable: true}

                    ]
                ],
                onLoadSuccess: function (data) {

                },
                detailFormatter: function (rowIndex, rowData) {
                },
                onDblClickRow: function (rowIndex, rowData) {

                },
                onClickRow: function (rowIndex, rowData) {

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

        });

        //datagril 列表宽度
        function fixWidth(percent) {
            return Math.floor(document.body.clientWidth * percent); //这里你可以自己做调整
        }
    </script>
</head>
<body class="easyui-layout" data-options="border:true ,fit:true" style="margin:10px;">
<div id="toolbar">

    <div style="margin: 10px;padding: 10px;border: 1px solid #c8c8c8;">

        <label>企业名称:</label>
        <input class="easyui-textbox" style="width:160px;">
        <label>联系人:</label>
        <input class="easyui-textbox" style="width:160px;">


    </div>
    <div>
        <button type="button" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="width:80px">添加
        </button>
        <button type="button" class="easyui-linkbutton">重置</button>
    </div>


</div>
<table id="redataGril" data-options="fit:true"></table>
</body>
</html>

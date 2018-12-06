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
    <title>角色管理</title>

    <!-- jquery easyui 插件 -->
    <link href="../../../public/jquery-easyui-1.5/themes/metro/easyui.css" rel="stylesheet"/>
    <link href="../../../public/jquery-easyui-1.5/themes/icon.css" rel="stylesheet"/>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.easyui.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/easyui-lang-zh_CN.js"></script>

    <!-- 数据接口路径、共用JS -->
    <script src="../../../public/js/path.js"></script>


</head>
<body class="easyui-layout" data-options="fit:true" style="padding:10px; box-sizing: border-box;">

<!-- 数据表格 -->
<table id="redataGril"></table>

<!-- 工具栏 -->
<div id="toolbar">
    <div style="margin: 10px;padding: 10px;border: 1px solid #c8c8c8;">
        <label>角色名称:</label>
        <input class="easyui-textbox" style="width:160px;">
        <span>&nbsp;是否有效</span>
        <select class="easyui-combobox" data-options="width:60,panelHeight:'auto',editable:false">
            <option value="ar">有效</option>
            <option value="bg">无效</option>
        </select>
    </div>
    <div style="margin: 0 0 10px 10px;">
        <button type="button" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="padding:0 10px;">
            查询
        </button>
        <button type="button" class="easyui-linkbutton" style="padding:0 10px;">重置</button>
        <button type="button" class="easyui-linkbutton" style="padding:0 10px;">添加</button>
        <button type="button" class="easyui-linkbutton" style="padding:0 10px;">删除</button>
        <button type="button" class="easyui-linkbutton" style="padding:0 10px;">生效</button>
        <button type="button" class="easyui-linkbutton" style="padding:0 10px;">失效</button>
        <button type="button" class="easyui-linkbutton" style="padding:0 10px;">权限设置</button>
        <button type="button" class="easyui-linkbutton" style="padding:0 10px;">用户设置</button>
        <button type="button" class="easyui-linkbutton" style="padding:0 10px;">资料权限设置</button>
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

        /*
        ** 假数据
        */
        var data = [
            {"rolename": "客服代表", "membership": "1", "company": "测试公司", "validity": "Y", "remark": "测试"},
            {"rolename": "客服代表", "membership": "1", "company": "测试公司", "validity": "Y", "remark": "测试"},
            {"rolename": "客服代表", "membership": "1", "company": "测试公司", "validity": "Y", "remark": "测试"},
            {"rolename": "客服代表", "membership": "1", "company": "测试公司", "validity": "Y", "remark": "测试"},
            {"rolename": "客服代表", "membership": "1", "company": "测试公司", "validity": "Y", "remark": "测试"},
            {"rolename": "客服代表", "membership": "1", "company": "测试公司", "validity": "Y", "remark": "测试"},
            {"rolename": "客服代表", "membership": "1", "company": "测试公司", "validity": "Y", "remark": "测试"}
        ];

        /*
        ** 获取数据
        */
        grid = $("#redataGril").datagrid({
            fit: true,
            data: data,
            fitColumns: true,
            striped: true,
            columns: [
                [
                    {field: 'rolename', title: '角色名称', width: 100, align: 'center', sortable: true},
                    {field: 'membership', title: '成员数', width: 100, align: 'center', sortable: true},
                    {field: 'company', title: '所属公司', width: 100, align: 'center'},
                    {field: 'validity', title: '是否有效', width: 100, align: 'center'},
                    {field: 'remark', title: '备注', width: 100, align: 'center'}
                ]
            ],
//          onLoadSuccess: function (data) {
//				////console.info(data);
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

    });

</script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>驾驶员考评系统</title>

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
        <span>考评等级</span>
        <input id="key" class="easyui-textbox" data-options="width:160">
    </div>
    <div id="button">
        <button class="easyui-linkbutton" id="search" iconCls="icon-search">查询</button>
        <button class="easyui-linkbutton" id="reset">重置</button>
        <button class="easyui-linkbutton" id="add">添加</button>
        <button class="easyui-linkbutton" id="modify">修改</button>
        <button class="easyui-linkbutton" id="delete">删除</button>
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
        ** 默认加载
        */
        acquireData('');

        /*
        ** 查询
        */
        $("#search").on("click", function () {
            var key = $("#key").textbox("getValue");
            acquireData(key);
        });

        /*
        ** 重置
        */
        $("#reset").on("click", function () {
            $("#key").textbox("setValue", "");
            acquireData('');
        });


        /*
         ** 添加
         */
        $("#add").click(function () {

            var dialog = phm.modalDialog({
                title: '添加',
                width: 900,
                height: 450,
                closable: true,
                url: "System_add.jsp?id=0&subtype=1",
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
            //console.info(row);

            if (row == null) {
                $.messager.alert('警告', "请选择要修改的记录", 'info');
                return;
            }
            var dialog = phm.modalDialog({
                title: '修改',
                width: 900,
                height: 450,
                closable: true,
                url: "System_add.jsp?id=" + row.id + "&subtype=1",
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
            if (row == null) {
                $.messager.alert('警告', "选择删除的记录", 'info');
                return;
            }
            $.messager.confirm('确认', '您确认想要删除记录吗？', function (r) {
                if (r) {

                    var requestURL = path + "/assessManage/delAssessManageByid?id=" + row.id;

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
        ** 假数据
        */
        var data = [
            {
                "evaluationLevel": "A",
                "fractionOne": "100",
                "fractionTwo": "98",
                "type": "大于",
                "levelExplanation": "优秀",
                "createTime": "2016-01-08 10:20:35"
            },
            {
                "evaluationLevel": "A",
                "fractionOne": "100",
                "fractionTwo": "98",
                "type": "大于",
                "levelExplanation": "优秀",
                "createTime": "2016-01-08 10:20:35"
            },
            {
                "evaluationLevel": "A",
                "fractionOne": "100",
                "fractionTwo": "98",
                "type": "大于",
                "levelExplanation": "优秀",
                "createTime": "2016-01-08 10:20:35"
            },
            {
                "evaluationLevel": "A",
                "fractionOne": "100",
                "fractionTwo": "98",
                "type": "大于",
                "levelExplanation": "优秀",
                "createTime": "2016-01-08 10:20:35"
            },
            {
                "evaluationLevel": "A",
                "fractionOne": "100",
                "fractionTwo": "98",
                "type": "大于",
                "levelExplanation": "优秀",
                "createTime": "2016-01-08 10:20:35"
            }
        ];

        /*
        ** 获取数据
        */
        function acquireData(key) {
            var dataUrl = "sort=id&order=desc&begintime=&endtime=&versiontype=1&key=" + key;
            grid = $("#redataGril").datagrid({
                fit: true,
                url: path + "/assessManage/findAssessManageForPageList?" + dataUrl,
                fitColumns: true,
                striped: true,
                columns: [
                    [
                        {field: 'evaluationlevel', title: '考评等级', width: 100, align: 'center', sortable: true},
                        {field: 'fractionone', title: '分值1', width: 100, align: 'center', sortable: true},
                        {field: 'fractiontwo', title: '分值2', width: 100, align: 'center'},
                        {
                            field: 'type', title: '类型', width: 100, align: 'center',
                            formatter: function (value) {
                                switch (value) {
                                    case 0:
                                        return "大于";
                                        break;
                                    case 1:
                                        return "介于";
                                        break;
                                    case 2:
                                        return "小于";
                                        break;
                                }
                            }
                        },
                        {
                            field: 'levelexplanation', title: '等级说明', width: 100, align: 'center',
                            formatter: function (value) {
                                switch (value) {
                                    case 0:
                                        return "优秀";
                                        break;
                                    case 1:
                                        return "良好";
                                        break;
                                    case 2:
                                        return "中等";
                                        break;
                                    case 3:
                                        return "不及格";
                                        break;
                                }
                            }
                        },
                        {field: 'createtime', title: '创建时间', width: 100, align: 'center', sortable: true}
                    ]
                ],
//	          onLoadSuccess: function (data) {
//					////console.info(data);
//	          },
                idField: 'evaluationLevel',
                sortName: 'evaluationLevel',
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
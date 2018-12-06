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
    <title>终端信息</title>

    <link href="../../../public/jquery-easyui-1.5/themes/metro/easyui.css" rel="stylesheet"/>
    <link href="../../../public/jquery-easyui-1.5/themes/icon.css" rel="stylesheet"/>

    <script src="../../../public/jquery-easyui-1.5/js/jquery.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.easyui.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/easyui-lang-zh_CN.js"></script>

    <!-- childstyle -->
    <link rel="stylesheet" type="text/css" href="../../../public/css/childstyle.css"/>

    <!-- 数据接口路径、共用JS -->
    <script src="../../../public/js/path.js"></script>

    <style type="text/css">

    </style>

    <script>

        $(function () {

            /*
             ** 变量声明
             */
            var grid;

            /*
             ** 默认加载
             */
            acquireData("", "", "");

            /*
             ** 查询
             */
            $("#search").on("click", function () {
                var position = $("#position").val();
                var phone = $("#phone").val();
                acquireData(key, begintime, endtime)
            });

            /*
             ** 重置
             */
            $("#reset").on("click", function () {
                $("#position").textbox("setValue", "");
                $("#phone").textbox("setValue", "");
                acquireData(key, begintime, endtime)
            });


            /*
             ** 获取数据
             */
            function acquireData(key, begintime, endtime) {
                var dataUrl = "order=desc&sort=id&key=" + key +
                    "&begintime=" + begintime +
                    "&endtime=" + endtime;
                grid = $("#redataGril").datagrid({
                    fit: true,
                    url: path + "/terminal/findTerminalForPageList?" + dataUrl,
                    fitColumns: true,
                    striped: true,
                    columns: [
                        [
                            {field: 'terminalid', title: '终端编号', width: fixWidth(0.1), align: 'center', sortable: true},
                            {field: 'simcard', title: 'SIM卡号', width: fixWidth(0.1), align: 'center', sortable: true},
                            {field: 'type', title: '设备类型', width: fixWidth(0.1), align: 'center'},
                            {field: 'company', title: '所属公司', width: fixWidth(0.1), align: 'center'},
                            {field: 'unit', title: '所属单位', width: fixWidth(0.1), align: 'center'},
                            {field: 'state', title: '终端状态', width: fixWidth(0.1), align: 'center', sortable: true},
                            {
                                field: 'installtime',
                                title: '安装日期',
                                width: fixWidth(0.1),
                                align: 'center',
                                sortable: true
                            },
                            {field: 'history', title: '绑定历史', width: fixWidth(0.1), align: 'center', sortable: true},
                            {field: 'validity', title: '是否有效', width: fixWidth(0.1), align: 'center', sortable: true}

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
            }

        });

        //datagril 列表宽度
        function fixWidth(percent) {
            return Math.floor(document.body.clientWidth * percent); //这里你可以自己做调整
        }
    </script>
</head>
<body id="body" class="easyui-layout" data-options="fit:true">


<table id="redataGril" data-options="fit:true"></table>
<div id="toolbar">

    <div id="input">
        <span>关键字</span>
        <input id="key" class="easyui-textbox" data-options="width:220" prompt="所属公司 | 终端编号 | SIM卡号 | 车牌号">

        <span>终端状态</span>
        <select id="usetype" class="easyui-combobox" data-options="panelHeight:'auto',editable:false">
            <option value="0">已使用</option>
            <option value="1">未使用</option>
        </select>


    </div>
    <div id="button">
        <button type="button" class="easyui-linkbutton" data-options="iconCls:'icon-search'">添加</button>
        <button type="button" class="easyui-linkbutton">重置</button>
        <button type="button" class="easyui-linkbutton"> 添加</button>
        <button type="button" class="easyui-linkbutton"> 删除</button>
        <button type="button" class="easyui-linkbutton"> 资料导入</button>
        <button type="button" class="easyui-linkbutton"> 导出</button>
    </div>


</div>
</body>
</html>

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
    <title>惩罚列表</title>

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
        <span>关键字</span>
        <input id="key" class="easyui-textbox" style="width:240px;" prompt="司机名称 | 车牌号 | 电话号码 | 企业名称">
        <%--<span>&nbsp;评级</span>--%>
        <%--<select id="rating" class="easyui-combobox" data-options="width:80,panelHeight:'auto',editable:false">--%>
        <%--<option value="" selected>全部</option>--%>
        <%--<option value="5">五星</option>--%>
        <%--<option value="4">四星</option>--%>
        <%--<option value="3">三星</option>--%>
        <%--<option value="2">二星</option>--%>
        <%--<option value="1">一星</option>--%>
        <%--</select>--%>
    </div>
    <div id="button">
        <button class="easyui-linkbutton" id="search" data-options="iconCls:'icon-search'">查询</button>
        <button class="easyui-linkbutton" id="reset">重置</button>
        <span style="color: red">注意：默认取消次数的司机"40分钟内"无法接单,个别企业可在"权限管理">"权限管理">"参数设置"下修改参数</span>
        <%--<button class="easyui-linkbutton" id="setDisable">禁止接单/开启接单</button>--%>
        <%--<button class="easyui-linkbutton" id="isblack" >添加黑名单</button>--%>
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
        var globab_clientId = sessionStorage.clientId;
        var token = sessionStorage.account;
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
         ** 获取数据
         */
        function acquireData(rating, key) {
            var dataUrl = "key=" + key + "&clientid=" + globab_clientId;
            grid = $("#redataGril").datagrid({
                fit: true,
                url: path + "/driverintegrity/findDriverIntegrityPunishmentForPageList?" + dataUrl,
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
                        {field: 'callnumber', title: '总接单次数', width: 100, align: 'center', sortable: true},
                        {
                            field: 'cancelnumber', title: '取消次数', width: 100, align: 'center', sortable: true,
                            formatter: function (value, row, index) {
                                var codes = row["kabnum"];
                                ////console.info(codes);
                                if (value > 0) {
                                    return '<span class="openrelation" onclick="openrelation(id)" id=' + codes + '>' + value + '</span>';
                                } else {
                                    return value;
                                }

                            }
                        },
                        {
                            field: 'pubishment', title: '惩罚记录', width: 100, align: 'center', sortable: true,
                            formatter: function (value, row, index) {
                                var codes = row["kabnum"];
                                ////console.info(codes);
                                if (value > 0) {
                                    return '<span class="openrelation" onclick="openrelationp(id)" id=' + codes + '>' + value + '</span>';
                                } else {
                                    return value;
                                }

                            }

                        },

                        {
                            field: 'isstop', title: '禁止接单', width: 100, align: 'center', sortable: true,
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
                        }

                    ]
                ],
                onLoadSuccess: function (data) {
                    console.info(data);
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

        /*
    	** 是否禁用
    	*/
        $("#setDisable").click(function () {
            var row = grid.datagrid("getSelected");
            if (row == null) {
                $.messager.alert('警告', "选择修改选项", 'info');
                return;
            }
            var message = "";
            if (row.isstop == 0) {
                message = "您确认想要帐号禁止接单?";
            } else {
                message = "您确认想要帐号开启接单?";
            }
            $.messager.confirm('确认', message, function (r) {
                if (r) {
                    $.ajax({
                        url: path + "/driver/isStopbyDriverPhone?phone=" + row.phone + "&token=" + token + "&clientid=" + globab_clientId,
                        data: {phone: row.phone},
                        dataType: "json",
                        type: "GET",
                        success: function (data) {
//                        	   ////console.info(data);
                            if (data.desc.indexOf("成功") > -1) {
                                grid.datagrid("reload");
                                grid.datagrid("clearSelections");
                                $.messager.show({
                                    title: '提示',
                                    msg: "操作成功！",
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
    });

    //查看司机信息
    function openrelationp(data) {
        console.info(data);
        var dialog = phm.modalDialog({
            title: '查看司机信息',
            width: 900,
            height: 560,
            closable: true,
            url: "punishment_orderdetails_log.jsp?kabnum=" + data,
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

    //查看司机信息
    function openrelation(data) {
        console.info(data);
        var dialog = phm.modalDialog({
            title: '查看司机信息',
            width: 900,
            height: 560,
            closable: true,
            url: "punishment_orderdetails_list.jsp?kabnum=" + data,
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
</script>
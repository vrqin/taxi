<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>授权</title>

    <!-- jquery easyui 插件 -->
    <link href="../../../public/jquery-easyui-1.5/themes/metro/easyui.css" rel="stylesheet"/>
    <link href="../../../public/jquery-easyui-1.5/themes/icon.css" rel="stylesheet"/>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.easyui.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/easyui-lang-zh_CN.js"></script>

    <!-- 数据接口路径、共用JS -->
    <script src="../../../public/js/path.js"></script>
    <script src="../../../public/js/constant.js"></script>

    <style>
        /*html,body {*/
        /*margin: 0px;*/
        /*padding: 0px;*/
        /*width: 100%;*/
        /*height: 100%;*/
        /*}*/
        /*#roletitle{*/
        /*position: absolute;*/
        /*top: 0px;*/
        /*left: 0px;*/
        /*background: white;*/
        /*width: 100%;*/
        /*height: 50px;*/
        /*padding: 0px;*/
        /*margin: 0px;*/
        /*line-height: 50px;*/
        /*text-indent: 10px;*/
        /*}*/
        /*#roletitle:after{*/
        /*content: "";*/
        /*display: block;*/
        /*width: 98%;*/
        /*height: 1px;*/
        /*background: grey;*/
        /*position: absolute;*/
        /*left: 1%;*/
        /*bottom: 0px;*/
        /*}*/
        #roletitle {
            background: white;
            width: 100%;
            height: 50px;
            padding: 0px;
            margin: 0px 0px 10px 0px;
            line-height: 50px;
            text-indent: 10px;
        }

        #roletitle:after {
            content: "";
            display: block;
            width: 98%;
            height: 1px;
            background: grey;
            position: absolute;
            left: 1%;
            /*bottom: 0px;*/
        }

        .menutree {
            box-sizing: border-box;
            /* width: auto; */
            height: 412px;
            background: white;
            overflow-y: auto;
        }
    </style>

</head>
<body>

<h2 id="roletitle">角色授权</h2>
<div class="menutree">

    <ul id="classlist" class="easyui-tree" data-options="animate:false,fit:true,border:false,lines:true">
    </ul>

</div>
</body>
</html>

<script>
    /*
     ** 全局变量声明
     */
    var oldname = "";

    var oldphone = "";
    var token = sessionStorage.account;
    var globab_clientId = sessionStorage.clientId;
    var flag = true;
    var globab_roleId = 0;
    $(function () {

//				////console.info(globab_clientId);


        /*
         ** 判断当前状态是否为修改内容
         */
        if ("${param.id}" > 0) {
            globab_roleId = "${param.id}";
        }

        //司机树
        $('#classlist').tree({
            url: path + '/resource/findResourcetree?roleid=' + globab_roleId,
            animate: false,
            checkbox: true,
            id: 'id',
            text: 'text',
            children: 'children',
            parent: 'pid',
            height: $("#paneleast").height(),
            loadFilter: function (data) {
//						////console.info(data);
                if (data.listTree) {
                    return data.listTree;
                } else {
                    return data;
                }
            },
            formatter: function (node) {
                var s = node.text;
                if (s == null || s == "") {
                    s = "(缺省值)";
                }
                if (node.children) {
                    if (node.children != 0) {
                        s += ' <span style=\"padding: 1px 4px 1px 4px\" class=\"treebgnum\">(' + node.children.length + ')</span>';
                    }
                }

                return s;
            },
            onSelect: function (node) {
                $(this).tree('expand', node.target);

            },
            onDblClick: function (node) {
                $(this).tree('collapse', node.target);

            },

            onBeforeLoad: function (param) {
//                $.messager.progress({
//                    text: '正在加载数据...'
//                });
            },
            onLoadSuccess: function (node, data) {
                $('#classlist').tree("collapseAll");
//                $.messager.progress('close');

            }
        });


    });


    /*
     ** 获取选中项的信息，并显示在输入框
     */
    function loadvalue() {

        $.ajax({
            url: path + '/role/findRoleByid?id=' +${param.id},
            dataType: "json",
            type: "GET",
            success: function (data) {
//						////console.info(data);


            }
        });
    }


    /*
     ** 判断必填内容不能为空；如果司机ID为空，则为添加数据；如果司机ID有值，则为修改数据
     */
    function completedForm(dialog, grid, p) {


        var nodes = $('#classlist').tree("getChecked", ['checked', 'indeterminate']);
        var resourceId = [];

        if (nodes != null && nodes.length > 0) {
            $.each(nodes, function (index, item) {
                resourceId.push(item.id);
            })
        }
        var resourceIds = resourceId.join(',');


        var data = {
            "roleid": globab_roleId,
            "resourcelist": resourceIds,
            "token": token
        };

//				////console.info(data);

        var requestURL = path + "/resource/saveorupdateResourceToRol";

        $.ajax({
            type: "POST",
            crossDomain: true,
            url: requestURL,
            data: JSON.stringify(data), //必须转成JSON进行传递，否则会报code 117错误
            cache: false,
            dataType: "json", //后台返回值类型
            contentType: "application/json;charset=utf-8",
            success: function (data) {

                grid.datagrid('reload');
                window.parent.$.messager.show({
                    title: '提示',
                    msg: data.desc,
                    showType: 'slide'
                });
                dialog.dialog("destroy");
            }
        });


    }	//function completedForm()结束


</script>

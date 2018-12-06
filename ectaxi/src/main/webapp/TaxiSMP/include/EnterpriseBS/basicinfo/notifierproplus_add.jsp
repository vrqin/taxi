<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>添加NotifierPlus</title>

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
        html, body {
            margin: 0px;
            padding: 0px;
            width: 100%;
            height: 100%;
        }

        .menutree {
            box-sizing: border-box;
            /* width: auto; */
            height: 399px;
            background: white;
            overflow-y: auto;
        }

        #notiyt {
            width: 50%;
            height: 100%;
            float: left;
            box-sizing: border-box;
            padding: 36px;
        }

        #notiyt textarea {
            width: 80%;
        }

        #notiyt span {
            font-weight: bold;
        }
    </style>

</head>
<body class="easyui-layout" data-options="fit:true" style="padding:10px; box-sizing: border-box;">

<div id="notiyt">
    <input type="hidden" id="id" name="id" value="">

    <textarea rows="10" class="textarea-full" id="content" name="content" placeholder="发布内容"></textarea>
    <p>已输入 <input id="textnum" type="text" value="0" style="width: 50px;" disabled="disabled"/>个字符，剩余字符( <span
            id="surnum">100</span> )</p>

    <span>有效时间到</span>
    <input id="validity" class="easyui-datetimebox" data-options="editable:false,required:true"/>
</div>

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
    var token = sessionStorage.account;
    var globab_clientId = sessionStorage.clientId;
    var globab_account = sessionStorage.accountName;
    var flag = true;
    $(function () {



        /*
         ** 判断当前状态是否为修改内容
         */
        $('#id').val(${param.id});
        if ("${param.id}" > 0) {
            loadvalue();
        }


        $('#content').keyup(function () {
            var total = 100;
            var client = $('#content').val().length;
            var surnum = total - client;
            $('#textnum').val(client);
            $('#surnum').html(surnum);
            if (client > total) {
                alert("超出数字限制！！！");
                return;
            }
        });

        //司机树
        $('#classlist').tree({
            url: path + '/driver/findDriverAccountree?clientid=' + globab_clientId,
            animate: false,
            checkbox: true,
            id: 'id',
            text: 'text',
            children: 'children',
            parent: 'pid',
            height: $("#paneleast").height(),
            loadFilter: function (data) {
                ////console.info(data);
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
//                $('#classlist').tree("collapseAll");
//                $.messager.progress('close');

            }
        });


    });


    /*
     ** 获取选中项的信息，并显示在输入框
     */
    function loadvalue() {

        $.ajax({
            url: path + '/notifierPlus/findNotifierPlusByid?id=' + '${param.id}',
            dataType: "json",
            type: "POST",
            success: function (data) {
                //console.info(data);
                $('#id').val(data.id);
                $('#content').val(data.content);


            }
        });
    }


    /*
     ** 判断传来的参数是否为空或null，是则弹出警告框
     */
    function errorAlert(value, msg) {
        if ((value === null) || (value === "")) {
            $.messager.alert('警告', msg, 'error');
            return false;
        }
        return true;
    }

    /*
     ** 判断必填内容不能为空；如果司机ID为空，则为添加数据；如果司机ID有值，则为修改数据
     */
    function completedForm(dialog, grid, p) {

        var validity = $("#validity").datetimebox("getValue");
        if (validity == null || validity == "") {
            alert("有效时间不能为空！");
            return;
        }
        var nodes = $('#classlist').tree("getChecked", ['checked', 'indeterminate']);
        var resourceId = [];
        //console.info(nodes);
        if (nodes != null && nodes.length > 0) {
            $.each(nodes, function (index, item) {
                if (item.msid != "") {
                    resourceId.push(item.msid);
                }
            })
        }
        var resourceIds = resourceId.join(',');

        var id = $('#id').val();
        var content = $('#content').val();

        var data = {
            "id": id,
            "content": content,
            "dirverIds": resourceIds,
            "clientid": globab_clientId,
            "accountName": globab_account,
            "validity": validity
        };

        //console.info(data);

        var requestURL = path + "/notifierPlus/sendNotifier";

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

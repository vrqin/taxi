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
    <title>车辆分组</title>

    <link href="../../../public/jquery-easyui-1.5/themes/metro/easyui.css" rel="stylesheet"/>
    <link href="../../../public/jquery-easyui-1.5/themes/icon.css" rel="stylesheet"/>

    <script src="../../../public/jquery-easyui-1.5/js/jquery.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.easyui.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/easyui-lang-zh_CN.js"></script>
    <!-- common.css -->
    <link rel="stylesheet" href="../../../public/css/common.css">
    <!-- 数据接口路径、共用JS -->
    <script src="../../../public/js/path.js"></script>
    <script src="../../../public/js/tree_extend.js"></script>
    <style type="text/css">
        html, body {
            width: 100%;
            height: 100%;
            margin: 0px;
            padding: 0px;

        }

        .arealist {
            float: left;
            width: 204px;
            height: 100%;
            background-color: #F9FCFF;
            overflow: auto;
        }

        /*.arealist>ul{*/
        /*margin: 0px;*/
        /*padding: 0px;*/
        /*}*/
        /*.arealist>ul li{*/
        /*list-style: none;*/
        /*font-size: 12px;*/
        /*padding: 8px 0 8px 35px;*/
        /*border: 1px solid;*/
        /*border-color: #999999;*/
        /*margin: 5px;*/

        /*}*/
        /*.arealist>ul li:hover{*/
        /*background-color: #DFDFDF;*/
        /*}*/

        .areatab {
            margin-left: 204px;
            width: auto;
            height: 100%;
        }

        #baidumaps {
            width: auto;
            height: 100%;
        }

        .maptip {
            position: absolute;
            top: 43px;
            right: 18px;
            width: 200px;
            height: 25px;
            line-height: 25px;
            background-color: #ffffff;
            box-shadow: 0 2px 2px rgba(0, 0, 0, 0.3);
        }

        .maptip ul {
            margin: 0px;
            padding: 0px;
            text-align: center;

        }

        .maptip ul li {
            display: inline;
            list-style: none;
            font-size: 12px;
            text-align: center;
            padding: 0 5px;
            cursor: pointer;
        }

        #carlist {
            /*background: green;*/
            width: 100%;
            height: 100%;
        }

        #carlist > ul {
            margin: 0px;
            padding: 0px;
        }

        #carlist > ul li {
            list-style: none;
            float: left;
            margin: 5px 10px;
            border: 1px solid #B0B0B0;
            box-sizing: border-box;
            border-radius: 5px;
            padding: 6px;
            color: #B0B0B0;
            width: 94px;
            overflow: hidden;
            white-space: nowrap;
        }

        .icon {
            font-size: 16px;
            color: #B0B0B0;
        }
    </style>


</head>
<body class="easyui-layout" data-options="border:false ,fit:true">
<div class="arealist">

    <ul id="classlist" class="easyui-tree" data-options="animate:false,fit:true,border:false,lines:true">
    </ul>
</div>
<div class="areatab">
    <div class="easyui-tabs" style="width:100%;height:100%">
        <div title="车辆分组" style="padding:5px">
            <div id="carlist">
                <ul>

                </ul>
            </div>

        </div>

    </div>
</div>
</body>
</html>
<script>
    $.extend($.fn.tree.methods, {
        getLevel: function (jq, target) {
            var l = $(target).parentsUntil("ul.tree", "ul");
            return l.length + 1;
        }
    });


    var grid;
    var globab_clientId = sessionStorage.clientId;
    $(function () {
        //司机树
        $('#classlist').tree({
            url: path + '/client/findClienttree?clientid=' + globab_clientId,
            animate: false,
            id: 'id',
            text: 'text',
            children: 'children',
            parent: 'pid',
            height: $("#paneleast").height(),
            loadFilter: function (data) {
//                ////console.info(data);
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
                    else {
                        s += ' <span style=\"padding: 1px 4px 1px 4px\"  class=\"treebgnum\">(' + node.msid + ')</span>';
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
            onClick: function (node) {
                ////console.info(node);

                var lv = $("#classlist").tree("getLevel", node.target);
                if (globab_clientId == 0) {
                    if (lv == 2) {
                        ////console.info(node);

                        $.ajax({
                            url: path + '/driver/findListclientId?clientid=' + node.id,
                            dataType: "json",
                            type: "GET",
                            success: function (data) {
                                cariteration(data);
//                            ////console.info(data);
                            }

                        });
                    } else {
                        $.ajax({
                            url: path + '/driver/findListclientId?clientid=' + node.id,
                            dataType: "json",
                            type: "GET",
                            success: function (data) {
                                cariteration(data);
//                            ////console.info(data);
                            }

                        });
                    }
                }

            },
            onBeforeLoad: function (param) {
//                $.messager.progress({
//                    text: '正在加载数据...'
//                });
            },
            onLoadSuccess: function (node, data) {
//                $('#classlist').tree("collapseAll");
//                $.messager.progress('close');
                ////console.info(data);
                if (globab_clientId != 0) {
                    $.ajax({
                        url: path + '/driver/findListclientId?clientid=' + data[0].id,
                        dataType: "json",
                        type: "GET",
                        success: function (data) {
                            cariteration(data);
//                            ////console.info(data);
                            $(".treebgnum").html("(" + data.length + ")");
                        }

                    });

                }
            }
        });


    });

    function cariteration(data) {
        var listr = "";
        if (data != null) {
            for (var i = 0; i < data.length; i++) {

                listr += '<li> <span class="icon icon-E90A"></span> ' + data[i].kabnum + '</li>';

            }

        }
        $("#carlist ul").html(listr);
    }

</script>
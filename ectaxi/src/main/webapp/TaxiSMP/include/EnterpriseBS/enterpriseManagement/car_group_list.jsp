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
    <!--工具类-->
    <script src="../../../public/js/myutil.js"></script>
    <script src="../../../public/js/utiljavascript.js"></script>


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

        .car_details_information {
            cursor: pointer;
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
<%--<div id="car_details_information_window">--%>
<%--<table id="car_details_information_table"></table>--%>
<%--</div>--%>


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

                listr += '<li class="car_details_information" onclick="car_li_click(' + i + ');"> <span class="icon icon-E90A"></span> ' + data[i].kabnum + '</li>';

            }

        }
        $("#carlist ul").html(listr);
    }

    //创建弹窗
    function car_li_click(i) {
        var kabnum = $(".car_details_information").eq(i).text();
        var dialog = phm.modalDialog({
            title: '车辆信息',
            width: fixWidth(0.9),
            height: 500,
            closable: true,
            url: "car_info.jsp?kabnum=" + kabnum,
            buttons:
                [{
                    text: '关闭',
                    iconCls: 'icon-cancel',
                    handler: function () {
                        dialog.dialog("close");
                    }
                }]


        });
//            $("#car_details_information_window").dialog({
//                                title: '查看车辆信息',
//                                closable: true,
//                                width :fixWidth(0.9),
//                                height :500,
//                                top:100,
//                                left:40,
//                                url: "car_info.jsp?kabnum="+kabnum,
//                                buttons: [
//                                    {
//                                        text: '取消',
//                                        iconCls: 'icon-cancel',
//                                        handler: function () {
//                                            $("#car_details_information_window").dialog("close");
//                                        }
//                                    }
//                                ]
//                            })
//             var kabnum = $(".car_details_information").eq(i).text();
//                    $.ajax({
//                        //url: path+'/carinfo/findCarinfoByKabnum?kabnum='+kabnum,
//                        url: "car_info.jsp",
//                        dataType: "json",
//                        type: "GET",
//                        success: function (data) {
//                            $("#car_details_information_window").dialog({
//                                title: '查看车辆信息',
//                                closable: true,
//                                width :fixWidth(0.9),
//                                height :500,
//                                top:100,
//                                left:40,
//
//                                buttons: [
//                                    {
//                                        text: '取消',
//                                        iconCls: 'icon-cancel',
//                                        handler: function () {
//                                            $("#car_details_information_window").dialog("close");
//                                        }
//                                    }
//                                ]
//                            })
//
////        //创建弹窗表格
////        $('#car_details_information_table').datagrid({
////            fit:true,
////            columns:[[
////                {field:'kabnum',title:'车牌号',width:100,align:'center'},
////                {field:'company',title:'所属公司',width:100,align:'center'},
////                {field:'unit',title:'所属单位',width:100,align:'center'},
////                {field:'terminalid',title:'终端编号',width:100,align:'center'},
////                {field:'simcard',title:'SIM卡号',width:100,align:'center'},
////                {field:'installtime',title:'安装日期',width:100,align:'center'},
////                {field:'transportid',title:'运输证号',width:100,align:'center'},
////                {field:'transporttime',title:'运输证有效期',width:100,align:'center'},
////                {field:'mileage',title:'里程',width:100,align:'center'},
////                {field:'models',title:'车型',width:100,align:'center'},
////                {field:'displacement',title:'排量',width:100,align:'center'},
////                {field:'yearcareful',title:'年审',width:150,align:'center'},
////                {field:'type',title:'类型',width:100,align:'center'},
////                {field:'vehicleid',title:'行驶证',width:100,align:'center'},
////            ]],
////
////        });
//
//
//        if(data==null||data==""){
//         //获取不到就不显示
//
////            var item = $('#car_details_information_table').datagrid('getRows');
////            if (item) {
////                for (var i = item.length - 1; i >= 0; i--) {
////                    var index = $('#car_details_information_table').datagrid('getRowIndex', item[i]);
////                    $('#car_details_information_table').datagrid('deleteRow', index);
////                }
////            }
//            $.messager.alert('提示',"车辆信息不存在",'info');
//        }else{
//
//            //加载数据
////            $('#car_details_information_table').datagrid('loadData',{"total":1, "rows":[{
////                "kabnum":data.kabnum,"company":data.company,"unit":data.unit,
////                "terminalid":data.terminalid,"transporttime":data.transporttime,
////                "mileage":mileageFormat(data.mileage),"models":modelsFormat(data.models),"displacement":displacementFormat(data.displacement),
////                "type":data.type,"vehicleid":data.vehicleid,"yearcareful":new Date(parseInt(data.yearcareful)).format("yyyy-MM-dd hh:mm:ss")
////            }]});
//        }}
//        });

    }


    function fixWidth(percent) {
        return document.body.clientWidth * percent; //这里你可以自己做调整
    }


</script>
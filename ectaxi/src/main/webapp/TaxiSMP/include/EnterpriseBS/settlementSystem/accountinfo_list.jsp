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
    <title>账户概览</title>

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

    <style type="text/css">
        html, body {
            width: 100%;
            height: 100%;
            margin: 0px;
            padding: 0px;

        }

        .accountinfo {
            font-size: 14px;
            line-height: 22px;
        }

        .accountinfo dl {
            padding-left: 10px;
        }

        .accountinfo dl dt {
            border-left: 3px solid green;
            padding-left: 10px;
        }

        .accountinfo dl dd {

        }

        .zhifbtn {
            margin: 10px 10px 10px 45px;
        }
    </style>


</head>
<body id="body" class="easyui-layout" data-options="fit:true">

<!-- 工具栏 -->
<div id="toolbar">
    <div id="input">

        <label>企业名称:</label>
        <input class="easyui-textbox" id="company" style="width:160px;">

        <span>开始时间</span>
        <select name="date" class="easyui-datetimebox " data-options="panelHeight:'auto',editable:false"
                style="width: 160px;">
        </select>
        <span>结束时间</span>
        <select name="date" class="easyui-datetimebox" data-options="panelHeight:'auto',editable:false"
                style="width: 160px;">
        </select>
    </div>
    <div id="button">
        <button class="easyui-linkbutton" id="search" iconCls="icon-search">查询</button>
        <button class="easyui-linkbutton" id="reset">重置</button>

    </div>
</div>
<div class="accountinfo">
    <dl>
        <dt>提现信息</dt>
        <dd>待处理提现 0 条</dd>
        <dd>司机余额 0.01 元</dd>
        <dd>司机提现总额 0 元 &nbsp;&nbsp;
            待处理提现总额 0 元 &nbsp;&nbsp;
            已处理提现总额 0 元
        </dd>

    </dl>
    <div class="zhifbtn">
        <button type="button" class="easyui-linkbutton" style="width:80px">登录支付宝</button>
        <button type="button" class="easyui-linkbutton" style="width:80px">登录微信</button>
    </div>
    <dl>
        <dt>乘客支付信息</dt>
        <dd>乘客支付总额 0 元 &nbsp;&nbsp;
            含小费 0 元
        </dd>
        <dd>打车券支付 0 元&nbsp;&nbsp;
            支付宝支付 0 元&nbsp;&nbsp;
            微信支付 0 元&nbsp;&nbsp;
            钱包支付 0 元
        </dd>

    </dl>
    <dl>
        <dt>收入信息</dt>
        <dd>司机收入总额 0 元</dd>
        <dd>司机打车收入 0 元&nbsp;&nbsp;
            司机小费收入 0 元
        </dd>
        <dd>企业小费收入 0 元</dd>
    </dl>
</div>

</body>
</html>
<script>
    var token = sessionStorage.account;
    var globab_clientId = sessionStorage.clientId;
    $(function () {

        $("#company").combobox({
            url: path + '/client/findclienttree?clientid=' + globab_clientId,
            method: 'GET',
            valueField: 'id',
            textField: 'text',
            onLoadSuccess: function (data) {
//				////console.info(data);
                if (globab_clientId != 0) {
                    $(this).combobox("setValue", globab_clientId);

                }
            }
        });


    });


</script>
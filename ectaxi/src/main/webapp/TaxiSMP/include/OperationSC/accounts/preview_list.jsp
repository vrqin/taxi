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

    <link href="../../../public/jquery-easyui-1.5/themes/metro/easyui.css" rel="stylesheet"/>
    <link href="../../../public/jquery-easyui-1.5/themes/icon.css" rel="stylesheet"/>

    <script src="../../../public/jquery-easyui-1.5/js/jquery.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.easyui.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/easyui-lang-zh_CN.js"></script>

    <style type="text/css">
        /*html ,body{
            width: 100%;
            height: 100%;
            margin: 0px;
            padding: 0px;

        }*/
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
    </style>

    <script>
        var grid;

        $(function () {


        });

        //datagril 列表宽度
        function fixWidth(percent) {
            return Math.floor(document.body.clientWidth * percent); //这里你可以自己做调整
        }
    </script>
</head>
<body class="easyui-layout" data-options="border:false ,fit:true" style="padding:10px;box-sizing: border-box;">

<div id="toolbar">
    <div style="margin:10px;padding:10px;border:1px solid #dddddd;font-size:12px;">
        <label>企业名称:</label>
        <input class="easyui-textbox" style="width:160px;">
        <span>&nbsp;开始时间</span>
        <select name="date" class="easyui-datetimebox " data-options="panelHeight:'auto',editable:false"
                style="width: 160px;">
        </select>
        <span>结束时间</span>
        <select name="date" class="easyui-datetimebox" data-options="panelHeight:'auto',editable:false"
                style="width: 160px;">
        </select>
    </div>
    <div style="margin: 0 0 10px 10px;">
        <button type="button" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="padding: 0 10px;">
            添加
        </button>
        <button type="button" class="easyui-linkbutton" style="padding: 0 10px;">重置</button>
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
    <div style="margin: 0 0 10px 10px;">
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

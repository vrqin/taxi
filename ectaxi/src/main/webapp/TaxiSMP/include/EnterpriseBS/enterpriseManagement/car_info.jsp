<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>车辆信息</title>

    <!-- jquery easyui 插件 -->
    <link href="../../../public/jquery-easyui-1.5/themes/metro/easyui.css" rel="stylesheet"/>
    <link href="../../../public/jquery-easyui-1.5/themes/icon.css" rel="stylesheet"/>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.easyui.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/easyui-lang-zh_CN.js"></script>


    <!-- 数据接口路径、共用JS -->
    <script src="../../../public/js/path.js"></script>
    <!-- 自定义校验-->
    <script src="../../../public/js/my_validatebox.js"></script>
    <!--工具类-->
    <script src="../../../public/js/myutil.js"></script>
    <!--公共样式-->
    <link href="../../../public/css/input.css" rel="stylesheet"/>

</head>
<body class="easyui-layout" data-options="fit:true" style="padding:10px; box-sizing: border-box;">
<form id="vaildataform">
    <table class="table" style="display: none">
        <tbody>

        <tr>
            <td><label>车牌号：</label><input id="kabnum" class="easyui-textbox" readonly/></td>
            <td><label>所属公司：</label><input id="company" name="account" class="easyui-textbox" readonly/></td>
            <td><label>unit：</label><input id="unit" class="easyui-textbox" readonly/></td>
        </tr>

        <tr>
            <td><label>终端编号：</label><input id="terminalid" class="easyui-textbox" readonly/></td>
            <td><label>SIM卡号：</label><input id="simcard" class="easyui-textbox" readonly></td>
            <td><label>安装日期：</label><input id="installtime" class="easyui-datetimebox" readonly/></td>
        </tr>

        <tr>
            <td><label>运输证号：</label><input id="transportid" class="easyui-textbox" readonly/></td>
            <td><label>行驶证：</label><input id="vehicleid" class="easyui-textbox" readonly/></td>
            <td><label>类型：</label><input id="type" class="easyui-textbox" readonly/></td>
        </tr>
        <tr>
            <td><label>运输证有效期：</label><input id="transporttime" class="easyui-textbox" readonly/></td>
            <td><label>里程：</label><input id="mileage" name="account" class="easyui-textbox" readonly/></td>
            <td><label>车型：</label><input id="models" class="easyui-textbox" readonly/></td>
        </tr>
        <tr>
            <td><label>排量：</label><input id="displacement" class="easyui-textbox" readonly/></td>
            <td><label>年审：</label><input id="yearcareful" name="account" class="easyui-datetimebox" readonly/></td>
        </tr>

        </tbody>
    </table>
</form>
</body>
</html>

<script>
    /*
     ** 全局变量声明
     */
    var oldkabnum = "";

    var oldvehicleid = "";
    var token = sessionStorage.account;
    var globab_clientId = sessionStorage.clientId;
    $(function () {
        loadvalue();
    })

    /*
     ** 获取选中项的信息，并显示在输入框
     */
    function loadvalue() {

        $.ajax({
            url: path + '/carinfo/findCarinfoByKabnum?kabnum=' + '${param.kabnum}',
            dataType: "json",
            type: "GET",
            success: function (data) {
                if (data == null || data == "" || data == undefined) {
                    $.messager.alert("提示", "该车辆信息不存在", "info");
                    return;
                }
                $(".table").css("display", "table");
                $('#installtime').textbox(data.installtime);
                $('#kabnum').textbox("setValue", data.kabnum);
                $('#vehicleid').textbox("setValue", data.vehicleid);
                $('#mileage').textbox("setValue", intTypeConversions(data.mileage, mileageConetent));
                $('#models').textbox("setValue", intTypeConversions(data.models, modelsContent));
                $('#displacement').textbox("setValue", intTypeConversions(data.displacement, displacementContent));
                $("#yearcareful").datetimebox("setValue", formattime(data.yearcareful.time));
                $('#company').textbox("setValue", data.clientid);
                $('#terminalid').textbox("setValue", data.terminalid);
                $('#vehicleid').textbox("setValue", data.vehicleid);
                $('#transporttime').textbox("setValue", data.transporttime);
                $('#unit').textbox("setValue", data.unit);
                $('#type').textbox("setValue", data.type);
                $('#simcard').textbox("setValue", data.simcard);

            }
        });
    }

    /**
     * 获取时间
     * 0为当前时间
     * 1为明天时间
     * -1为前天时间
     * @param AddDayCount
     * @returns {string}
     * @constructor
     */
    function GetDateStr(AddDayCount) {
        var dd = new Date();
        dd.setDate(dd.getDate() + AddDayCount);//获取AddDayCount天后的日期
        var y = dd.getFullYear();
        var m = (dd.getMonth() + 1) < 10 ? "0" + (dd.getMonth() + 1) : (dd.getMonth() + 1);//获取当前月份的日期，不足10补0
        var d = dd.getDate() < 10 ? "0" + dd.getDate() : dd.getDate(); //获取当前几号，不足10补0
        return y + "-" + m + "-" + d + " 00:00:00";
    }
</script>
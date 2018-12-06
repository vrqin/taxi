<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>添加投诉</title>

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
        .table {
            width: 100%;
            /*height: 100%;*/
            font-size: 12px;
            text-align: center;
            border-spacing: 10px;
        }

    </style>

</head>
<body class="easyui-layout" data-options="fit:true" style="padding:10px; box-sizing: border-box;">

<table class="table">
    <tbody>
    <tr>
        <td>客户姓名：<input id="customername" class="easyui-textbox"/></td>
        <td>联系电话：<input id="phone" class="easyui-textbox"/></td>
        <input type="hidden" id="id" name="id">
    </tr>
    <tr>
        <td>所在车辆：<input id="kabnum" class="easyui-combobox"/></td>
        <td>投诉来源：
            <select id="source" class="easyui-combobox" data-options="width:168,panelHeight:'auto',editable:false">
            </select>
        </td>
    </tr>
    <tr>
        <td colspan="2">投诉描述：<input id="name" style="width:480px" class="easyui-textbox"/></td>


    </tr>
    <tr>
        <td>处理状态：
            <select id="state" class="easyui-combobox" data-options="width:168,panelHeight:'auto',editable:false">
            </select>
        </td>
        <td>处理结果：
            <select id="results" class="easyui-combobox" data-options="width:168,panelHeight:'auto',editable:false">
            </select>
        </td>

    </tr>
    <tr class="hidearea">
        <td>投诉时间：<input id="calltime" class="easyui-datetimebox" data-options="width:168,editable:false" readonly/></td>
        <%--<td>处理时间：--%>
        <%--<input id="endtime" class="easyui-datetimebox" data-options="width:168,editable:false"/></td>--%>
        <%--</td>--%>

    </tr>
    <tr class="hidearea">
        <td>电召单ID：<input id="ordernum" width="171" class="easyui-textbox" readonly/></td>
        <td></td>
    </tr>
    </tbody>
</table>

</body>
</html>

<script>
    var token = sessionStorage.account;
    var globab_clientId = sessionStorage.clientId;
    $(function () {

        /*
        ** 判断当前状态是否为修改内容
        */
        $(".hidearea").hide();
        if ('${param.id}' > 0) {
            loadvalue();
            $(".hidearea").show();
        }

        //加载下拉框数据
        $("#source").combobox({
            data: complaintsource,
            valueField: 'id',
            textField: 'text'
        });

        $("#results").combobox({
            data: complaintresults,
            valueField: 'id',
            textField: 'text'
        });

        $("#state").combobox({
            data: complaintstate,
            valueField: 'id',
            textField: 'text'
        });

        $("#kabnum").combobox({
            url: path + '/carinfo/findcarinfotree?clientid=' + globab_clientId,
            method: 'GET',
            valueField: 'id',
            textField: 'text',
            onLoadSuccess: function (data) {
//						console.info(data);
            }
        });

        /*
        ** 获取选中项的信息，并显示在输入框
        */
        function loadvalue() {
            $.ajax({
                url: path + '/complaint/findNameByid?id=' +${param.id},
                dataType: "json",
                type: "GET",
                success: function (data) {
//	          	console.info(data);
                    $('#id').val(data.id);
                    $('#customername').textbox("setValue", data.customername);
                    $('#name').textbox("setValue", data.name);
                    $('#phone').textbox("setValue", data.phone);
                    $('#state').combobox("setValue", data.state);
                    $('#source').combobox("setValue", data.source);
                    $('#calltime').datetimebox("setValue", formattime(data.acceptime.time));
                    var comendtime = "";
                    if (data.endtime != "" && data.endtime != null) {
                        comendtime = formattime(data.endtime.time);
                    }
                    $('#endtime').datetimebox("setValue", comendtime);

                    $('#results').combobox("setValue", data.results);
                    $('#kabnum').textbox("setValue", data.kabnum);
                    $('#ordernum').textbox("setValue", data.ordernum);
                }
            });
        }

    });

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
    ** 判断必填内容不能为空；正常后提交添加
    */
    function completedForm(dialog, grid, p) {


        var id = $("#id").val();

        var customername = $('#customername').textbox("getValue");
        if (!errorAlert(name, "客户姓名不能为空！！！")) {
            return false
        }

        var name = $('#name').textbox("getValue");
        if (!errorAlert(name, "投诉描述不能为空！！！")) {
            return false
        }

        var phone = $('#phone').textbox("getValue");
        if (!errorAlert(phone, "手机号码不能为空！！！")) {
            return false
        }

        var source = $('#source').combobox("getValue");

        var results = $('#results').combobox("getValue");
        var state = $('#state').combobox("getValue");
        var calltime = $('#calltime').datetimebox("getValue");
        var kabnum = $('#kabnum').combobox("getText");
        var acceptime = $('#calltime').datetimebox("getValue");

        var dataUrl = "id=" + id +
            "&name=" + name +
            //						"&acceptime="+ acceptime +
            "&source=" + source +
            "&customername=" + customername +
            "&phone=" + phone +
            "&kabnum=" + kabnum +
            "&results=" + results +
            "&state=" + state +
            "&clientid=" + globab_clientId +
            "&token=" + token;
//						"&ordernum="+ ordernum;


        $.ajax({
            url: path + '/complaint/saveorupdateComplaint?' + dataUrl,
            dataType: "json",
            type: "POST",
            success: function (data) {

                grid.datagrid('reload');
                window.parent.$.messager.show({
                    title: '提示',
                    msg: data.desc,
                    timeout: 3000,
                    showType: 'slide'
                });
                dialog.dialog("destroy");
            }
        });
    }	//function completedForm()结束
</script>
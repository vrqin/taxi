<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>添加优惠券</title>

    <!-- jquery easyui 插件 -->
    <link href="../../../public/jquery-easyui-1.5/themes/metro/easyui.css" rel="stylesheet"/>
    <link href="../../../public/jquery-easyui-1.5/themes/icon.css" rel="stylesheet"/>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.easyui.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/easyui-lang-zh_CN.js"></script>

    <!-- 数据接口路径、共用JS -->
    <script src="../../../public/js/path.js"></script>

    <style>
        .table {
            width: 100%;
            /*height: 100%;*/
            font-size: 12px;
            text-align: center;
            border-spacing: 10px;
        }

        #extypes, #type, #enable {
            width: 166px;
        }
    </style>

</head>
<body class="easyui-layout" data-options="fit:true" style="padding:10px; box-sizing: border-box;">

<table class="table">
    <tbody>
    <input type="hidden" id="id" class="easyui-textbox"/>
    <input type="hidden" id="carstatus" name="carstatus">
    <tr>
        <td>所属公司：<input id="company" class="easyui-combobox" data-options="editable:false,required:true"/></td>
        <td>优惠券名称：<input id="name" class="easyui-textbox"/></td>
        <td>优惠券类型：
            <select id="type" class="easyui-combobox" data-options="editable:false">
                <option value="1" selected>代金券</option>
                <option value="2">打折券</option>
            </select>
        </td>
    </tr>
    <tr>
        <td>数额或折扣：<input id="money" class="easyui-textbox" maxlength="1"/></td>
        <td>有效天数：<input id="valid" class="easyui-textbox"/></td>
        <td>消费金额：<input id="serviceConditions" class="easyui-textbox"/></td>

    </tr>

    <tr>
        <td>最大代扣：<input id="maxDeduction" class="easyui-textbox"/></td>
        <td>开始时间：<input id="starttime" class="easyui-datetimebox" data-options="editable:false"/></td>
        <td>结束时间：<input id="endtime" class="easyui-datetimebox" data-options="editable:false"/></td>

    </tr>
    <%--<tr>--%>
    <%--<td></td>--%>

    <%--</tr>--%>
    <%--<tr>--%>
    <%--<td></td>--%>
    <%--</tr>--%>
    <tr>
        <td colspan="3"><img id="pic_face" src="../public/image/dispic.png" alt="" height="210" width="360"/>
        </td>

    </tr>
    <tr>
        <td colspan="3">注意：图片 宽度（200）*高度（270）</td>
    </tr>
    <tr>
        <td colspan="3">
            <iframe src="discountcoupon_uploadfile.jsp" frameborder="0" name="iframe2" id="iframe2"
                    style="width: 246px;height: 67px">

            </iframe>
        </td>
    </tr>

    </tbody>
</table>

</body>
</html>

<script>
    var globab_clientId = sessionStorage.clientId;
    var token = sessionStorage.account;
    var globab_id =${param.id};
    if ('${param.id}' == 0) {
//        console.info(globab_id)
        globab_id = Date.parse(new Date());
//		console.info("globab_id--->"+globab_id)
        globab_id = (globab_id + "").substr(0, 10);
//		globab_id=(globab_id+"").slice(0, 10);
        console.info("globab_id--->" + globab_id)
    }

    $(function () {
        $('#id').textbox("setValue", globab_id);
        $("#company").combobox({
            url: path + '/client/findclienttree?clientid=' + globab_clientId,
            method: 'GET',
            valueField: 'id',
            textField: 'text',
            onLoadSuccess: function (data) {
                ////console.info(data);
                if (globab_clientId != 0) {
                    $(this).combobox("setValue", globab_clientId);

                }
            }
        });

        /*
         ** 判断当前状态是否为修改内容
         */
        if ('${param.id}' > 0) {
            loadvalue();
        }


    })

    /*
     ** 获取选中项的信息，并显示在输入框
     */
    function loadvalue() {
        $.ajax({
            url: path + '/discountCoupon/findDiscountCouponByid?id=' + '${param.id}' + "&token=" + token,
            dataType: "json",
            type: "GET",
            success: function (data) {
                console.info(data);
                $('#company').textbox("setValue", data.clientId);
                $('#name').textbox("setValue", data.name);
                $('#starttime').datetimebox("setValue", formattime(data.starttime));
                $('#endtime').datetimebox("setValue", formattime(data.endtime));
                $('#money').textbox("setValue", data.money);
                $('#valid').textbox("setValue", data.valid);
//				$('#discountAddr').textbox("setValue",data.discountAddr);
                $('#type').combobox("setValue", data.type);
                $('#serviceConditions').textbox("setValue", data.serviceConditions);
                $('#maxDeduction').textbox("setValue", data.maxDeduction);

                if (data.discountPic != null && data.discountPic != "") {
                    $("#pic_face").attr("src", data.discountPic);
                }

            }
        });
    }

    /*
    ** 判断必填内容不能为空；正常后提交添加
    */
    function completedForm(dialog, grid, p) {

        var clientId = $('#company').textbox("getValue");
        if (clientId == "") {
            alert("请选择所属企业");
            return;
        }
        var name = $('#name').textbox("getValue");
        if (name == "") {
            alert("输入优惠券名称");
            return;
        }
        var starttime = $('#starttime').datetimebox("getValue");
        if (starttime == "") {
            alert("输入打车劵活动开始时间");
            return;
        }
        var endtime = $('#endtime').datetimebox("getValue");
        if (endtime == "") {
            alert("输入打车劵活动结束时间");
            return;
        }
        var valid = $('#valid').textbox("getValue");
        if (valid < 1) {
            alert("有效期不能小于1");
            return;
        }
//		var discNum=$('#discNum').textbox("getValue");
        var type = $('#type').combobox("getValue");
        var money = $('#money').textbox("getValue");


        if (type == 1) {
            if (money < 1) {
                alert("金额不能小于1");
                return;
            }
        } else if (type == 2) {
            var reg = /^0\.[1-9]{0,2}$/;
            if (!reg.test(money)) {
                alert("折扣范围在0-1之间");
                return;
            }


        }
        var serviceConditions = $('#serviceConditions').textbox("getValue");
        var maxDeduction = $('#maxDeduction').textbox("getValue");

        var carstatus = $("#carstatus").val();
//		var discountAddr=$('#discountAddr').textbox("getValue");

        var data = {
            "id": globab_id,
            "name": name,
            "type": type,
            "money": money,
            "valid": valid,
//			"discNum":discNum,
            "carstatus": carstatus,
//			"discNum":discNum,
//			"discountAddr":discountAddr,
            "clientId": clientId,
            "starttime": starttime,
            "endtime": endtime,
            "maxDeduction": maxDeduction,
            "serviceConditions": serviceConditions

        };

        console.info(data);
//		return;
        var requestURL = path + "/discountCoupon/saveorupdateDiscountCoupon";

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

    function getNowFormatDate() {
        var date = new Date();
        var seperator1 = "";
        var seperator2 = "";
        var month = date.getMonth() + 1;
        var strDate = date.getDate();
        if (month >= 1 && month <= 9) {
            month = "0" + month;
        }
        if (strDate >= 0 && strDate <= 9) {
            strDate = "0" + strDate;
        }
        var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
            + date.getHours() + seperator2 + date.getMinutes()
            + seperator2 + date.getSeconds();
        return currentdate;
    }
</script>
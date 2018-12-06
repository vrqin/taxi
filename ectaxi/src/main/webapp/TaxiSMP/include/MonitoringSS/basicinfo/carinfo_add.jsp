<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>车辆添加</title>

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
            height: 100%;
            font-size: 12px;
            text-align: center;
        }

        .table tbody tr td {
            position: relative;
        }

        #defaultPhoto {
            width: 136px;
            border: 1px solid #DDDDDD;
            display: block;
            position: absolute;
            top: 0;
            left: 128px;
        }

        #sex {
            width: 164px;
        }

        #fileTd {
            text-align: left;
            padding-left: 34px;
        }

        .required {
            color: red;
        }
    </style>

</head>
<body class="easyui-layout" data-options="fit:true" style="padding:10px; box-sizing: border-box;">

<table class="table">
    <tbody>
    <tr>
        <input type="hidden" id="carinfid" name="carinfid">
        <input type="hidden" id="carstatus" name="carstatus">
        <input type="hidden" id="vehtatus" name="vehtatus">
        <td><span class="required">*</span>车牌号码：<input id="kabnum" class="easyui-textbox"
                                                       data-options="validType:'length[1,10]'"/></td>
        <td><span class="required">*</span>行驶证号：<input id="vehicleid" name="account" class="easyui-textbox"
                                                       prompt="只能是字母和数字组成(必填)" data-options="validType:'length[1,18]'"/>
        </td>
        <td><span class="required">*</span>里程：<input id="mileage" class="easyui-textbox"
                                                     data-options="validType:'length[1,10]'"/></td>
    </tr>

    <tr>
        <td><span class="required">*</span>车型：<input id="models" class="easyui-textbox"
                                                     data-options="validType:'length[1,10]'"/></td>
        <td><span class="required">*</span>排量：<input id="displacement" class="easyui-textbox"
                                                     data-options="validType:'length[1,10]'"/></td>
        <td><span class="required">*</span>年审：<input id="yearcareful" class="easyui-datetimebox"
                                                     data-options="editable:false"/></td>
    </tr>

    <tr>

        <td><span class="required">*</span>所属公司：
            <select id="company" class="easyui-combobox" data-options="editable:false" style="width:176px;">

            </select>
        </td>
        <td></td>
        <td></td>
    </tr>

    <tr>
        <td colspan="2"><img id="pic_face" src="../public/image/carpic.png" alt="" height="210" width="360"/></td>
        <td><img id="pic_face2" src="../public/image/vehicleid.png" alt="" height="210" width="360"/></td>
        <%--<td ><img id="pic_face2" src="../public/image/identity.png" alt="" height="160" width="240"/></td>--%>
        <%--<td ><img id="pic_face3" src="../public/image/diving.png" alt="" height="160" width="240"/></td>--%>

    </tr>
    <tr>
        <td colspan="2">
            <iframe src="carinfo_uploadfile.jsp" frameborder="0" name="iframe2" id="iframe2"
                    style="width: 246px;height: 67px">

            </iframe>
        </td>
        <td>
            <iframe src="carinfo_uploadvehi.jsp" frameborder="0" name="iframe3" id="iframe3"
                    style="width: 246px;height: 67px">

            </iframe>
        </td>
    </tr>


    </tbody>
</table>

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
        var validityDatetime = "";

        /*
        ** 判断当前状态是否为修改内容
        */
        if ('${param.id}' > 0) {
            loadvalue();
        }

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
    	** 判断登录帐号是否已存在
    	*/
//        $("#account").next("span").children("input").eq(0).blur(function(){
//
//            var account = $('#account').val();
//			checkDriverAccount(account);
//			$("#iframe2")[0].contentWindow.document.getElementById('account').value= account;
//        });
        /*
         ** 离开执行判断电话号码是否已存在
         */
//		$("#phone").next("span").children("input").eq(0).blur(function(){
//			var phone = $('#phone').val();
//			checkDriverPhone(phone);
//		});
    });

    /*
     ** 判断登录帐号是否已存在
     */
    function checkDriverAccount(account) {
        if (account == null || account == "") {
            $.messager.alert('警告', "不能为空！", 'error');
            return;
        }
        if (oldname != account) {
            $.ajax({
                url: path + "/driver/checkDriverName?account=" + account,
                dataType: 'json',
                type: 'GET',
                async: false,
                success: function (data) {
                    if (data.code !== 0) {
                        $.messager.alert('警告', "用户已存在！", 'error');
                    }
                }
            });
        }

    }

    /*
     ** 判断电话号码是否已存在
     */
    function checkDriverPhone(phone) {
        if (phone == null || phone == "") {
            $.messager.alert('警告', "不能为空！", 'error');
            return;
        }
        if (oldphone != phone) {
            $.ajax({
                url: path + "/driver/checkDriverPhone?phone=" + phone,
                dataType: 'json',
                type: 'GET',
                async: false,
                success: function (data) {

                    if (data.code !== 0) {
                        $.messager.alert('警告', "电话号码存在！", 'error');
                    }
                }
            });
        }
    }

    /*
    ** 获取选中项的信息，并显示在输入框
    */
    function loadvalue() {
        $.ajax({
            url: path + '/carinfo/findCarinfoByid?id=' +${param.id},
            dataType: "json",
            type: "GET",
            success: function (data) {
                ////console.info(data);
                $('#carinfid').val(data.id);
                $('#kabnum').textbox("setValue", data.kabnum);
                $('#vehicleid').textbox("setValue", data.vehicleid);
                $('#mileage').textbox("setValue", data.mileage);
                $('#models').textbox("setValue", data.models);
                $('#displacement').textbox("setValue", data.displacement);
                $("#yearcareful").datetimebox("setValue", formattime(data.yearcareful.time));
                $('#company').combobox("setValue", data.clientid);


                if (data.carPic != "") {
                    $("#pic_face").attr("src", data.carPic);
                }
                if (data.vehPic != "") {
                    $("#pic_face2").attr("src", data.vehPic);
                }
                oldkabnum = data.kabnum;
                oldvehicleid = data.vehicleid;

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
        var carinfid = $('#carinfid').val();

        var kabnum = $('#kabnum').textbox("getValue");
        if (!errorAlert(kabnum, "车牌不能为空！！！")) {
            return false
        }
        var vehicleid = $('#vehicleid').textbox("getValue");
        if (!errorAlert(vehicleid, "行驶证不能为空！！！")) {
            return false
        }
        var mileage = $('#mileage').textbox("getValue");
        if (!errorAlert(mileage, "里程不能为空！！！")) {
            return false
        }
        var models = $('#models').textbox("getValue");
        if (!errorAlert(models, "车型不能为空！！！")) {
            return false
        }
        var displacement = $('#displacement').textbox("getValue");
        if (!errorAlert(displacement, "排量不能为空！！！")) {
            return false
        }
        var yearcareful = $("#yearcareful").datetimebox('getValue');
        if (!errorAlert(yearcareful, "年审不能为空！！！")) {
            return false
        }
        var company = $('#company').combobox("getValue");
        if (!errorAlert(company, "公司不能为空！！！")) {
            return false
        }

        var carstatus = $("#carstatus").val();
        var vehtatus = $("#vehtatus").val();


        var dataUrl = "carinfid=" + carinfid +
            "&kabnum=" + kabnum +
            "&vehicleid=" + vehicleid +
            "&kabnum=" + kabnum +
            "&mileage=" + mileage +
            "&models=" + models +
            "&displacement=" + displacement +
            "&yearcareful=" + yearcareful +
            "&carstatus=" + carstatus +
            "&vehtatus=" + vehtatus +
            "&company=" + company +
            "&token=" + token;
//		////console.info(dataUrl);
//return;
        $.ajax({
            url: path + '/carinfo/saveorupdateCarinfo?' + dataUrl,
            dataType: "json",
            type: "POST",
            success: function (data) {
//				////console.info(data);
                grid.datagrid('reload');
                window.parent.$.messager.show({
                    title: '提示',
                    msg: data.desc,
//                    timeout: 3000,
                    showType: 'slide'
                });
                dialog.dialog("destroy");
            }
        });

    }	//function completedForm()结束


</script>
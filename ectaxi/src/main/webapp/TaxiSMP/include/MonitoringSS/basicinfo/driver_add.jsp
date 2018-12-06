<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>驾驶员添加</title>

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
        <td><span class="required">*</span>登录帐号：<input id="account" name="account" class="easyui-textbox"
                                                       prompt="只能是字母和数字组成(必填)" data-options="validType:'length[1,15]'"/>
        </td>
        <td><span class="required">*</span> 登录密码：<input id="pwd" class="easyui-textbox" value="123456"
                                                        data-options="validType:'length[1,10]'"/></td>
        <td>司机性别：
            <select id="sex" class="easyui-combobox" data-options="editable:false">
                <option value="0">男</option>
                <option value="1">女</option>
            </select>
        </td>
        <input type="hidden" id="filestute" name="filestute" value="">
        <input type="hidden" id="idstute" name="idstute" value="">
        <input type="hidden" id="drivingstute" name="drivingstute" value="">
        <input type="hidden" id="driverid" name="driverid">
    </tr>
    <tr>
        <td><span class="required">*</span>司机姓名：<input id="name" class="easyui-textbox"
                                                       data-options="validType:'length[1,10]'"/></td>
        <td><span class="required">*</span>联系电话：<input id="phone" class="easyui-textbox"
                                                       data-options="validType:'length[1,15]'"/></td>
        <td><span class="required">*</span>身份证号：<input id="identity" class="easyui-textbox"/></td>

    </tr>
    <tr>
        <td><span class="required">*</span>所属公司：
            <select id="company" class="easyui-combobox" data-options="editable:false" style="width:176px;">

            </select>
        </td>
        <td><span class="required">*</span>车牌号码：

            <select id="kabnum" class="easyui-combobox" data-options="editable:false" style="width:176px;">

            </select>
        </td>
        <td>运营证号：<input id="operationid" class="easyui-textbox"/></td>

    </tr>

    <tr>
        <td>司机卡ID：<input id="drivercardid" class="easyui-textbox"/></td>
        <td>员工编号：<input id="serialnum" class="easyui-textbox"/></td>
        <td>默认星级：<input id="starlevel" class="easyui-textbox" value="3"/></td>
    </tr>
    <tr>
        <td>驾驶证号：<input id="licenseid" class="easyui-textbox"/></td>
        <td>有效期至：<input id="validityDatetime" class="easyui-datetimebox" data-options="editable:false"/></td>
        <td></td>
    </tr>
    <tr>
        <td><img id="pic_face" src="../public/image/default_photo.png" alt="" height="160" width="120"/></td>
        <td><img id="pic_face2" src="../public/image/identity.png" alt="" height="160" width="240"/></td>
        <td><img id="pic_face3" src="../public/image/diving.png" alt="" height="160" width="240"/></td>
    </tr>
    <tr>
        <td>
            <iframe src="driver_uploadfile.jsp" frameborder="0" name="iframe2" id="iframe2"
                    style="width: 246px;height: 67px">

            </iframe>
        </td>

        <td>
            <iframe src="driver_uploadidentity.jsp" frameborder="0" name="iframe2" id="iframe3"
                    style="width: 246px;height: 67px">

            </iframe>
        </td>
        <td>
            <iframe src="driver_uploaddriving.jsp" frameborder="0" name="iframe2" id="iframe4"
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
    var oldname = "";

    var oldphone = "";
    var token = sessionStorage.account;
    var globab_clientId = sessionStorage.clientId;
    $(function () {
        var validityDatetime = "";

        /*
        ** 判断当前状态是否为修改内容
        */
        if ('${param.driverid}' > 0) {
            loadvalue();
        }

        /*
        ** 判断当前时间值是否为空，如果为空则设置值为明年今天时间
        */
        validityDatetime = $("#validityDatetime").datetimebox('getValue');
        if (validityDatetime == null || validityDatetime == "") {
            $("#validityDatetime").datetimebox('setValue', GetDateStr(365));
        }

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
            },
            onChange: function (newValue, oldValue) {

                $("#kabnum").combobox({
                    url: path + '/carinfo/findcarinfotree?clientid=' + newValue,
                    method: 'GET',
                    valueField: 'id',
                    textField: 'text',
                    onLoadSuccess: function (data) {
                        ////console.info(data);
                    }
                });
            }
        });
        if (globab_clientId > 0) {

            $('#company').combobox("setValue", globab_clientId);
        }
        /*
    	** 判断登录帐号是否已存在
    	*/
        $("#account").next("span").children("input").eq(0).blur(function () {

            var account = $('#account').val();
            checkDriverAccount(account);
            $("#iframe2")[0].contentWindow.document.getElementById('account').value = account;
        });
        /*
         ** 离开执行判断电话号码是否已存在
         */
        $("#phone").next("span").children("input").eq(0).blur(function () {
            var phone = $('#phone').val();
            checkDriverPhone(phone);
        });
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
            url: path + '/driver/findDriverByid?driverid=' + '${param.driverid}' + "&clientid=" + globab_clientId + "&token=" + token,
            dataType: "json",
            type: "GET",
            success: function (data) {
                ////console.info(data);

                $('#driverid').val(data.driverid);
                $('#name').textbox("setValue", data.name);
                $('#sex').combobox("setValue", data.sex);
                $('#phone').textbox("setValue", data.phone);

                $('#account').textbox("setValue", data.account);
                $('#pwd').textbox("setValue", data.pwd);
                $('#company').combobox("setValue", data.clientid);
                $('#kabnum').combobox("setValue", data.kabnumid);
                if (data.driverPic != "" && data.driverPic != null) {
                    $("#pic_face").attr("src", data.driverPic);
                }
                if (data.driveridentityPic != "" && data.driveridentityPic != null) {
                    $("#pic_face2").attr("src", data.driveridentityPic);
                }
                if (data.drivingPic != "" && data.drivingPic != null) {
                    $("#pic_face3").attr("src", data.drivingPic);
                }

                $('#operationid').textbox("setValue", data.operationID);
                $('#licenseid').textbox("setValue", data.licenseID);
                $('#starlevel').textbox("setValue", data.starLevel);
                $('#drivercardid').textbox("setValue", data.driverCardID);
                $('#serialnum').textbox("setValue", data.serialNum);
                var datav = data.validityDatetime;
                if (datav == null || datav == "") {
                    $("#validityDatetime").datetimebox('setValue', GetDateStr(365));
                } else {
                    $("#validityDatetime").datetimebox('setValue', formattime(data.validityDatetime));
                }

                oldname = data.account;
                oldphone = data.phone;

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
        var driverid = $('#driverid').val();
        var account = $('#account').val();
        if (!errorAlert(account, "帐号不能为空！！！")) {
            return false
        }
        checkDriverAccount(account);
        var pwd = $('#pwd').val();
        if (!errorAlert(pwd, "密码不能为空！！！")) {
            return false
        }
        var kabnum = $('#kabnum').combobox("getValue");
        if (!errorAlert(kabnum, "车牌不能为空！！！")) {
            return false
        }
        var name = $('#name').val();
        if (!errorAlert(name, "名称不能为空！！！")) {
            return false
        }
        var sex = $("#sex").combobox("getValue");
        var phone = $('#phone').val();
        if (!errorAlert(phone, "电话不能为空！！！")) {
            return false
        }
        checkDriverPhone(phone);
        var company = $('#company').combobox("getValue");

        if (!errorAlert(company, "公司不能为空！！！")) {
            return false
        }

        var drivercardid = $("#drivercardid").val();
        var licenseid = $("#licenseid").val();
        var operationid = $("#operationid").val();
        var serialnum = $("#serialnum").val();
        var starlevel = $("#starlevel").val();
        var filestute = $("#filestute").val();
        var idstute = $("#idstute").val();
        var drivingstute = $("#drivingstute").val();
        var companyText = $("#company").combobox('getText');
        var validitydatetime = $("#validityDatetime").datetimebox('getValue');
        if (!errorAlert(validityDatetime, "有效期不能为空！！！")) {
            return false
        }
        var file = $("#file").val();
        var dataUrl = "driverid=" + driverid +
            "&account=" + account +
            "&pwd=" + pwd +
            "&kabnum=" + kabnum +
            "&name=" + name +
            "&sex=" + sex +
            "&phone=" + phone +
            "&companyid=" + company +
            "&clientid=" + globab_clientId +

            //        				"&driverpic="+imgPath+
            "&drivercardid=" + drivercardid +
            "&licenseid=" + licenseid +
            "&operationid=" + operationid +
            "&serialnum=" + serialnum +
            "&starlevel=" + starlevel +
            "&filestute=" + filestute +
            "&idstute=" + idstute +
            "&drivingstute=" + drivingstute +
            "&token=" + token +
            "&company=" + companyText +
            "&validitydatetime=" + validitydatetime;

        $.ajax({
            url: path + '/driver/saveorupdateDriver?' + dataUrl,
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
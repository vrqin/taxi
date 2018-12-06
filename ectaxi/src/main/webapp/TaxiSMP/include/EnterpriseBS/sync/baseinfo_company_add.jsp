<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>添加网约车平台公司</title>

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
            border-spacing: 10px;
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

        <input id="cnm" type="hidden" value="${param.CompanyId}"/>

        <td><span class="required">*</span>公司标识：<input id="CompanyId" class="easyui-textbox"/></td>
        <td><span class="required">*</span> 公司名称：<input id="CompanyName" class="easyui-textbox"
                                                        data-options="validType:'length[1,15]'"/></td>

        <td><span class="required">*</span>统一社会信用代码：<input id="Identifier" class="easyui-textbox"/></td>

    </tr>
    <tr>
        <td><span class="required">*</span> 注册地行政区域代码：<input id="Address" class="easyui-numberbox"
                                                             data-options="prompt:'6位数',validType:['integer','length[0,6]']"/>
        </td>


        <td><span class="required">*</span>经营范围：<input id="BusinessScope" class="easyui-textbox"/></td>
        <td><span class="required">*</span> 通信地址：<input id="ContactAddress" class="easyui-textbox"
                                                        data-options="validType:'length[1,15]'"/></td>
    </tr>
    <tr>
        <td><span class="required">*</span>经营业户经济类型：<input id="EconomicType" class="easyui-textbox"/></td>


        <td><span class="required">*</span> 注册资本：<input id="RegCapital" class="easyui-textbox"
                                                        data-options="validType:'length[1,15]'"/></td>


        <td><span class="required">*</span>法人代表姓名：<input id="LegalName" class="easyui-textbox"/></td>
    </tr>
    <tr>
        <td><span class="required">*</span> 法人代表身份证号：<input id="LegalID" class="easyui-textbox"
                                                            data-options="validType:'length[1,15]'"/></td>

        <td><span class="required">*</span>法人代表电话：<input id="LegalPhone" class="easyui-textbox"/></td>
        <td><span class="required">*</span> 法人代表身份证扫描文件编号：<input id="LegalPhoto" class="easyui-textbox"
                                                                 data-options="validType:'length[1,15]'"/></td>

    </tr>
    <tr>
        <td><span class="required">*</span>状态：<input id="State" class="easyui-numberbox"
                                                     data-options="prompt:'0：有效 1：失效',validType:['integer','length[0,1]']"/>
        </td>


        <%--<td><span class="required">*</span> 操作标识：<input id="Flag" class="easyui-numberbox"--%>
                                                        <%--data-options="prompt:'1：新增 2：更新 3：删除',validType:['integer','length[0,1]']"/>--%>
        <%--</td>--%>
        <td><span class="required">*</span> 更新时间：<input id="UpdateTime" class="easyui-numberbox"
                                                        data-options="validType:'length[1,15]'" disabled/></td>
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
    var flag = true;
    $(function () {


        var d = $("#cnm").val();

        <%--console.log(${param.CompanyId})--%>
        /*
        ** 判断当前状态是否为修改内容
        */
        if (d != 0) {
            <%--console.error(${param.CompanyId}+"")--%>
            var ddd = d;
            var ccc = d;
            console.error(ddd)
            console.error(ccc)
            loadvalue(ddd);
        }


    });

    function loadvalue(ddd) {

        $.ajax({
            url: path + '/baseInfoCompany/findBaseInfoCompanyByid?id=' +ddd,
            dataType: "json",
            type: "POST",
            success: function (data) {
                ////console.info(data);

                $('#CompanyId').textbox("setValue", data.companyId);
                $('#CompanyName').textbox("setValue", data.companyName);
                $('#Identifier').textbox("setValue", data.identifier);
                $('#Address').textbox("setValue", data.address);
                $('#BusinessScope').textbox("setValue", data.businessScope);
                $('#ContactAddress').textbox("setValue", data.contactAddress);
                $('#EconomicType').textbox("setValue", data.economicType);
                $('#RegCapital').textbox("setValue", data.regCapital);
                $('#LegalName').textbox("setValue", data.legalName);
                $('#LegalID').textbox("setValue", data.legalID);
                $('#LegalPhone').textbox("setValue", data.legalPhone);
                $('#LegalPhoto').textbox("setValue", data.legalPhoto);
                $('#State').textbox("setValue", data.state);
                // $('#Flag').textbox("setValue", data.flag);
                $('#UpdateTime').textbox("setValue", data.updateTime);

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


        var CompanyId = $('#CompanyId').textbox("getValue");
        var CompanyName = $('#CompanyName').textbox("getValue");
        var Identifier = $('#Identifier').textbox("getValue");
        var Address = $('#Address').textbox("getValue");
        var BusinessScope = $('#BusinessScope').textbox("getValue");
        var ContactAddress = $('#ContactAddress').textbox("getValue");
        var EconomicType = $('#EconomicType').textbox("getValue");
        var RegCapital = $('#RegCapital').textbox("getValue");
        var LegalName = $('#LegalName').textbox("getValue");
        var LegalID = $('#LegalID').textbox("getValue");
        var LegalPhone = $('#LegalPhone').textbox("getValue");
        var LegalPhoto = $('#LegalPhoto').textbox("getValue");
        var State = $('#State').textbox("getValue");
        // var Flag = $('#Flag').textbox("getValue");
        var UpdateTime = $('#UpdateTime').textbox("getValue");


        var data = {
            "companyId": CompanyId,
            "companyName": CompanyName,
            "identifier": Identifier,
            "address": Address,
            "businessScope": BusinessScope,
            "contactAddress": ContactAddress,
            "economicType": EconomicType,
            "regCapital": RegCapital,
            "legalName": LegalName,
            "legalID": LegalID,
            "legalPhone": LegalPhone,
            "legalPhoto": LegalPhoto,
            "state": State,
            // "flag": Flag,
            // "updateTime": UpdateTime

        };
////console.info(data);

        var requestURL = path + "/baseInfoCompany/saveorupdateBaseInfoCompany";

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
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>添加网约车平台公司营运规模信息</title>

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

        <td><span class="required">*</span>平台注册网约车数：<input id="VehicleNum" class="easyui-numberbox"/></td>
        <td><span class="required">*</span> 平台注册驾驶员数：<input id="DriverNum" class="easyui-numberbox"/></td>

    </tr>
    <tr>

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
        } else {


            $.ajax({
                url: path + '/baseInfoCompany/getCompanyId',
                dataType: "json",
                type: "GET",
                success: function (data) {
                    ////console.info(data);

                    if (data.total = 1) {
                        $('#CompanyId').textbox("setValue", data.rows[0].CompanyId);

                        // $('#VehicleNum').textbox("setValue", data.vehicleNum);
                        // $('#DriverNum').textbox("setValue", data.driverNum);
                        // // $('#State').textbox("setValue", data.state);
                        // // $('#Flag').textbox("setValue", data.flag);
                        // $('#UpdateTime').textbox("setValue", data.updateTime);
                    }


                }
            });
            $.ajax({
                url: path + '/baseInfoCompanyStat/getStat',
                dataType: "json",
                type: "GET",
                success: function (data) {
                    ////console.info(data);

                    // if(data.total=1){
                    //     $('#CompanyId').textbox("setValue", data.rows[0].companyId);

                    $('#VehicleNum').textbox("setValue", data.VehicleNum);
                    $('#DriverNum').textbox("setValue", data.DriverNum);
                    // $('#State').textbox("setValue", data.state);
                    // // $('#Flag').textbox("setValue", data.flag);
                    // $('#UpdateTime').textbox("setValue", data.updateTime);
                    // }


                }
            });

        }


    });

    function loadvalue(ddd) {

        $.ajax({
            url: path + '/baseInfoCompanyStat/findBaseInfoCompanyStatByid?id=' + ddd,
            dataType: "json",
            type: "POST",
            success: function (data) {
                ////console.info(data);

                $('#CompanyId').textbox("setValue", data.companyId);

                $('#VehicleNum').textbox("setValue", data.vehicleNum);
                $('#DriverNum').textbox("setValue", data.driverNum);
                // $('#State').textbox("setValue", data.state);
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
        // var CompanyName = $('#CompanyName').textbox("getValue");
        // var Identifier = $('#Identifier').textbox("getValue");
        // var Address = $('#Address').textbox("getValue");
        // var BusinessScope = $('#BusinessScope').textbox("getValue");
        // var ContactAddress = $('#ContactAddress').textbox("getValue");
        // var EconomicType = $('#EconomicType').textbox("getValue");
        // var RegCapital = $('#RegCapital').textbox("getValue");
        // var LegalName = $('#LegalName').textbox("getValue");
        // var LegalID = $('#LegalID').textbox("getValue");
        var VehicleNum = $('#VehicleNum').textbox("getValue");
        var DriverNum = $('#DriverNum').textbox("getValue");
        // var State = $('#State').textbox("getValue");
        // var Flag = $('#Flag').textbox("getValue");
        var UpdateTime = $('#UpdateTime').textbox("getValue");


        var data = {
            "companyId": CompanyId,
            // "companyName": CompanyName,
            // "identifier": Identifier,
            // "address": Address,
            // "businessScope": BusinessScope,
            // "contactAddress": ContactAddress,
            // "economicType": EconomicType,
            // "regCapital": RegCapital,
            // "legalName": LegalName,
            // "legalID": LegalID,
            "vehicleNum": VehicleNum,
            "driverNum": DriverNum,
            // "state": State,
            // "flag": Flag,
            // "updateTime": UpdateTime

        };
////console.info(data);

        var requestURL = path + "/baseInfoCompanyStat/saveorupdateBaseInfoCompanyStat";

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
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>添加运价</title>

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

        <td><span class="required">*</span>执行区域：<input id="regional" name="clientName" class="easyui-textbox"
                                                       data-options="validType:'length[1,15]'"/></td>
        <td><span class="required">*</span> 运价类型描述：<input id="description" class="easyui-textbox"
                                                          data-options="validType:'length[1,15]'"/></td>
        <input type="hidden" id="freightId" name="freightId" value="">
    </tr>
    <tr>
        <td><span class="required">*</span>有效期起始时间：<input id="validitime" class="easyui-datebox"/></td>
        <td><span class="required">*</span>运营起步里程数：<input id="startmileage" class="easyui-textbox"/></td>
    </tr>
    <tr>
        <td><span class="required">*</span>燃油附加费：<input id="fuelsurcharge" class="easyui-textbox"/></td>
        <td><span class="required">*</span>停车计费：<input id="parking" class="easyui-textbox"/></td>
    </tr>
    <tr>
        <td><span class="required">*</span>夜间运营起始时间：<input id="diurnalstartfare" class="easyui-timespinner"
                                                           data-options="validType:'length[1,18]'"/></td>
        <td><span class="required">*</span>夜间运营结束时间：<input id="diurnalendfare" class="easyui-timespinner"
                                                           data-options="validType:'length[1,18]'"/></td>

    </tr>
    <tr>
        <td><span class="required">*</span>昼间起步价：<input id="diurnalstar" class="easyui-textbox"
                                                        data-options="validType:'length[1,18]'"/></td>
        <td><span class="required">*</span>夜间起步价：<input id="nightstar" class="easyui-textbox"/></td>
    </tr>
    <tr>
        <td><span class="required">*</span>昼间单价：<input id="diurnalprice" class="easyui-textbox"/></td>
        <td><span class="required">*</span>夜间单价：<input id="nightprice" class="easyui-textbox"
                                                       data-options="validType:'length[1,18]'"/></td>
    </tr>
    <tr>
        <td><span class="required">*</span>单程加价公里：<input id="singlepremium" class="easyui-textbox"
                                                         data-options="validType:'length[1,18]'"/></td>
        <td><span class="required">*</span>昼间单程单价：<input id="diurnalsingle" class="easyui-textbox"
                                                         data-options="validType:'length[1,18]'"/></td>
    </tr>
    <tr>
        <td><span class="required">*</span>夜间单程单价：<input id="nightsingle" class="easyui-textbox"
                                                         data-options="validType:'length[1,18]'"/></td>
        <td><span class="required">*</span>运价切换速度：<input id="freightswitch" class="easyui-textbox"/></td>
    </tr>
    <tr>
        <td><span class="required">*</span>是否低速等待：
            <select id="islowspeedwait" class="easyui-combobox" data-options="panelHeight:'auto',editable:false"
                    style="width:80px;">
            </select>
        </td>
        <td><span class="required">*</span>运价状态：
            <select id="state" class="easyui-combobox" data-options="panelHeight:'auto',editable:false"
                    style="width:80px;">
            </select>
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
    $(function () {


        //本地
        $("#islowspeedwait").combobox({
            data: islowspeedwait,
            valueField: 'id',
            textField: 'text'
        });
        $("#state").combobox({
            data: stutets,
            valueField: 'id',
            textField: 'text'
        });
        //服务器
//		$("#pid").combobox({
//			url: path+'/client/findClienttree',
//			valueField: 'id',
//			textField: 'text',
//			onLoadSuccess: function (data) {
////                    ////console.info(data);
//			}
//		});

        /*
        ** 判断当前状态是否为修改内容
        */
        if ('${param.freightid}' > 0) {
            loadvalue();
        }

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
    ** 获取选中项的信息，并显示在输入框
    */
    function loadvalue() {

        $.ajax({
            url: path + '/freight/findFreightByid?id=' +${param.freightid},
            dataType: "json",
            type: "POST",
            success: function (data) {
                ////console.info(data);

                $('#freightId').val(data.id);
                $('#regional').textbox("setValue", data.regional);
                $('#description').textbox("setValue", data.description);
                $('#validitime').datebox("setValue", data.validitime);
                $('#startmileage').textbox("setValue", data.startmileage);
                $('#fuelsurcharge').textbox("setValue", data.fuelsurcharge);
                $('#parking').textbox("setValue", data.parking);
                $('#diurnalstartfare').timespinner("setValue", data.diurnalstartfare);
                $('#diurnalendfare').timespinner("setValue", data.diurnalendfare);
                $('#diurnalstar').textbox("setValue", data.diurnalstar);
                $('#nightstar').textbox("setValue", data.nightstar);
                $('#diurnalprice').textbox("setValue", data.diurnalprice);
                $('#nightprice').textbox("setValue", data.nightprice);
                $('#singlepremium').textbox("setValue", data.singlepremium);
                $('#diurnalsingle').textbox("setValue", data.diurnalsingle);
                $('#nightsingle').textbox("setValue", data.nightsingle);
                $('#freightswitch').textbox("setValue", data.freightswitch);
                $('#islowspeedwait').combobox("setValue", data.islowspeedwait);
                $('#state').combobox("setValue", data.state);

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

        var freightId = $('#freightId').val();
        var regional = $('#regional').textbox("getValue");
        var description = $('#description').textbox("getValue");
        var validitime = $('#validitime').datebox("getValue");
        var startmileage = $('#startmileage').textbox("getValue");
        var fuelsurcharge = $('#fuelsurcharge').textbox("getValue");
        var parking = $('#parking').textbox("getValue");
        var diurnalstartfare = $('#diurnalstartfare').textbox("getValue");
        var diurnalstar = $('#diurnalstar').textbox("getValue");
        var nightstar = $('#nightstar').textbox("getValue");
        var diurnalendfare = $('#diurnalendfare').timespinner("getValue");
        var diurnalprice = $('#diurnalprice').timespinner("getValue");
        var nightprice = $('#nightprice').textbox("getValue");
        var singlepremium = $('#singlepremium').textbox("getValue");
        var diurnalsingle = $('#diurnalsingle').textbox("getValue");
        var nightsingle = $('#nightsingle').textbox("getValue");
        var freightswitch = $('#freightswitch').textbox("getValue");
        var islowspeedwait = $('#islowspeedwait').combobox("getValue");
        var state = $('#state').combobox("getValue");

//		if(!errorAlert(company,"公司不能为空！！！")){return false}

        var data = {
            "id": freightId,
            "regional": regional,
            "description": description,
            "validitime": validitime,
            "startmileage": startmileage,
            "fuelsurcharge": fuelsurcharge,
            "parking": parking,
            "diurnalstartfare": diurnalstartfare,
            "diurnalstar": diurnalstar,
            "nightstar": nightstar,
            "diurnalendfare": diurnalendfare,
            "diurnalprice": diurnalprice,
            "nightprice": nightprice,
            "singlepremium": singlepremium,
            "diurnalsingle": diurnalsingle,
            "nightsingle": nightsingle,
            "freightswitch": freightswitch,
            "islowspeedwait": islowspeedwait,
            "state": state,
            "token": token
        };
        ////console.info(data);

        var requestURL = path + "/freight/saveorupdateFreight";
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
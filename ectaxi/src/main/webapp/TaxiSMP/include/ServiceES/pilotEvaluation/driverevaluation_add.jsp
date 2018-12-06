<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>版本添加</title>

    <!-- jquery easyui 插件 -->
    <link href="../../../public/jquery-easyui-1.5/themes/metro/easyui.css" rel="stylesheet"/>
    <link href="../../../public/jquery-easyui-1.5/themes/icon.css" rel="stylesheet"/>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.easyui.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/easyui-lang-zh_CN.js"></script>

    <!-- 数据接口路径、共用JS -->
    <script src="../../../public/js/path.js"></script>
    <!-- 自定义校验 -->
    <script src="../../../public/js/my_validatebox.js"></script>
    <!--工具类-->
    <script src="../../../public/js/myutil.js"></script>
    <!--公共样式-->
    <link href="../../../public/css/input.css" rel="stylesheet"/>


</head>
<body class="easyui-layout" data-options="fit:true" style="padding:10px; box-sizing: border-box;">
<form id="vaildateform" method="post">
    <table class="table">
        <tbody>
        <tr>
            <input type="hidden" id="id" name="id">
            <input type="hidden" id="type" name="type">
            <td><label><span class="required">*</span> 考评：</label><input id="evaluation" class="easyui-textbox"
                                                                         data-options="required:true"
                                                                         name="reversionManage"/></td>
            <td><label><span class="required">*</span> 驾驶员姓名：</label><input id="account" name="reversionManage"
                                                                            class="easyui-textbox"
                                                                            name="reversionManage"
                                                                            data-options="required:true"/></td>
            <td><label><span class="required">*</span> 从业资格证号：</label><input id="seniority" class="easyui-textbox"
                                                                             data-options="required:true"/></td>
        </tr>

        <tr>
            <td><label><span class="required">*</span> 车牌号：</label><input id="kabnum" name="account"
                                                                          class="easyui-textbox"
                                                                          data-options="required:true"/></td>
            <td><label><span class="required">*</span> 企业名称：</label><input id="enterprisename" name="account"
                                                                           class="easyui-textbox"
                                                                           data-options="required:true"/></td>
            <td><label><span class="required">*</span> 考评版本：</label><input id="evaluationversion" name="account"
                                                                           class="easyui-textbox"
                                                                           data-options="required:true"/></td>

        </tr>
        <tr>

        </tr>

        <tr>
            <td><label><span class="required">*</span> 考评年度：</label><input id="evaluationyears" name="reversionManage"
                                                                           class="easyui-textbox"
                                                                           data-options="required:true"/></td>
            <td><label><span class="required">*</span> 考评状态：</label><input id="evaluationtype" name="account"
                                                                           class="easyui-combobox"
                                                                           data-options="required:true"/></td>
            <td><label><span class="required">*</span> 考评时间：</label><input id="evaluationtime" name="reversionManage"
                                                                           class="easyui-datetimebox"
                                                                           data-options="required:true,editable:false"/>
            </td>

        </tr>
        <tr>


            <td></td>
            <td></td>
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
    var token = sessionStorage.account;
    var globab_clientId = sessionStorage.clientId;


    $(function () {
        var validityDatetime = "";

        if ('${param.type}' > 0) {
            document.getElementById("type").value = "1";
        } else {
            document.getElementById("type").value = "0";
        }
        /*
         ** 判断当前状态是否为修改内容
         */
        if ('${param.id}' > 0) {
            loadvalue();

        }

        mycombobox($("#evaluationtype"), "70");

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


    //		/*
    //		 ** 判断登录帐号是否已存在
    //		 */
    //		function checkDriverAccount(kabnum) {
    //
    //			if (oldkabnum!=kabnum){
    //				$.ajax({
    //					url: path + "/carinfo/checkKabnum?kabnum="+kabnum,
    //					dataType: 'json',
    //					type: 'GET',
    //					async: false,
    //					success: function (data) {
    //						if(data.code !== 0){
    //							$.messager.alert('警告',"用户已存在！",'error');
    //						}
    //					}
    //				});
    //			}
    //
    //		}

    //		/*
    //		 ** 判断电话号码是否已存在
    //		 */
    //		function checkDriverPhone(phone) {
    //			if(phone==null||phone==""){
    //				$.messager.alert('警告',"不能为空！",'error');
    //				return;
    //			}
    //			if (oldphone!=phone){
    //				$.ajax({
    //					url: path + "/driver/checkDriverPhone?phone="+phone,
    //					dataType: 'json',
    //					type: 'GET',
    //					async: false,
    //					success: function (data) {
    //
    //						if(data.code !== 0){
    //							$.messager.alert('警告',"电话号码存在！",'error');
    //						}
    //					}
    //				});
    //			}
    //		}
    /*
     ** 获取选中项的信息，并显示在输入框
     */
    function loadvalue() {
        $.ajax({
            url: path + '/driverEvaluation/findDriverEvaluationByid?id=' +${param.id},
            dataType: "json",
            type: "GET",
            success: function (data) {
                //console.info(data);
                $("#id").val(data.id);
                $('#evaluation').textbox("setValue", data.evaluation);
                $('#account').textbox("setValue", data.account);
                $('#seniority').textbox("setValue", data.seniority);
                $('#evaluationtime').datetimebox("setValue", formattime(data.evaluationtime.time));
                $("#kabnum").textbox('setValue', data.kabnum);
                $("#enterprisename").textbox('setValue', data.enterprisename);
                $("#evaluationversion").textbox('setValue', data.evaluationversion);
                $("#evaluationyears").textbox('setValue', data.evaluationyears);
                $("#evaluationtype").combobox('setValue', evaluationtypeFormat(data.evaluationtype));

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
     ** 判断必填内容不能为空；如果司机ID为空，则为添加数据；如果司机ID有值，则为修改数据
     */
    function completedForm(dialog, grid, p) {
        var id = $("#id").val();

        var evaluation = $('#evaluation').textbox("getValue");
        var account = $('#account').textbox("getValue");
        var seniority = $('#seniority').textbox("getValue");
        var kabnum = $("#kabnum").textbox('getValue');
        var enterprisename = $("#enterprisename").textbox('getValue');
        var evaluationversion = $("#evaluationversion").textbox('getValue');
        var evaluationyears = $("#evaluationyears").textbox('getValue');
        var evaluationtype = formatEvaluationtype($("#evaluationtype").combobox('getValue'));
        var evaluationtime = $('#evaluationtime').datetimebox("getValue");


        if (!isValidate($("#vaildateform"))) return false;


        var data = {
            "id": id,
            "evaluation": evaluation,
            "account": account,
            "seniority": seniority,
            "evaluationtime": StringtoDate(evaluationtime),
            "kabnum": kabnum,
            "enterprisename": enterprisename,
            "evaluationversion": evaluationversion,
            "evaluationyears": evaluationyears,
            "evaluationtype": evaluationtype,
            "clientid": globab_clientId,
            "token": token

        };
        //console.info(data);

        var requestURL = path + "/driverEvaluation/saveorupdateDriverEvaluation";

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
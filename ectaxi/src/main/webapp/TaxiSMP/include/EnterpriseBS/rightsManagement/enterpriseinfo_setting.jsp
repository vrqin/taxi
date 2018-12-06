<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>企业参数设置</title>

    <!-- jquery easyui 插件 -->
    <link href="../../../public/jquery-easyui-1.5/themes/metro/easyui.css" rel="stylesheet"/>
    <link href="../../../public/jquery-easyui-1.5/themes/icon.css" rel="stylesheet"/>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.easyui.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/easyui-lang-zh_CN.js"></script>

    <!-- 数据接口路径、共用JS -->
    <script src="../../../public/js/path.js"></script>
    <script src="../../../public/js/constant.js"></script>
    <script src="../../../public/js/placesMap.js"></script>


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
        <input type="hidden" id="clientId" name="clientId">

        <td><span class="required">*</span>短信次数：<input id="Messagenum" name="Messagenum" class="easyui-textbox"
                                                       value="0"/></td>
        <td><span class="required">*</span>电召单超时(分钟)：<input id="orderovertime" name="orderovertime"
                                                            class="easyui-textbox" value="30"/></td>
    </tr>
    <tr>
        <td><span class="required">*</span>取消单次数：<input id="droporder" name="droporder" class="easyui-textbox"
                                                        value="0"/></td>
        <td><span class="required">*</span>暂停接单(分钟)：<input id="waitminute" name="waitminute" class="easyui-textbox"
                                                           value="30"/></td>
    </tr>
    <tr>
        <td><span class="required">*</span>成功接单短信接口ID：<input id="smsid" name="smsid" class="easyui-textbox" value=""/>
        </td>
        <td><span class="required">*</span>短信接口KEY：<input id="smskey" name="smskey" class="easyui-textbox" value=""/>
        </td>
    </tr>
    <tr>
        <td><span class="required">*</span>取消接单短信接口ID：<input id="smscancelid" name="smscancelid" class="easyui-textbox"
                                                             value=""/></td>
        <td></td>
    </tr>
    <tr>
        <td><span class="required">*</span>派单距离(米)：<input id="distance" name="distance" class="easyui-textbox"
                                                          value="2000"/></td>
        <td></td>
    </tr>


    <tr>
        <td><span class="required">*</span>添加司机上限数<input id="maxdrivernum" name="maxdrivernum" class="easyui-textbox"
                                                          value="2000"/></td>
        <td></td>
    </tr>
    <tr>
        <%--<td colspan="2"><span class="required">*</span>派单区域：<input id="areaname" name="areaname" class="easyui-textbox"  value="广州市" /></td>--%>
        <td><span class="required">*</span>派单区域：
            <select id="province" onchange="changeSelect(this);">
                <option value="000000" style="color:#999;" disabled="disabled">-请选择省-</option>
            </select>
            <select id="city" onchange="changeSelect(this);">
                <option value="000000" style="color:#999;" disabled="disabled">-请选择市-</option>
            </select>
            <select id="district">
                <option value="000000" style="color:#999;" disabled="disabled">-请选区-</option>
            </select>
        </td>
        <td></td>
    </tr>

    <%--<tr>--%>
    <%--<td><span class="required">*</span>所属系统：<input id="sysname" name="sysname" class="easyui-combobox" value="" /></td>--%>
    <%--<td><span class="required">*</span>微信公众号名称：<input id="weixinname" name="weixinname" class="easyui-textbox"  value="" /></td>--%>
    <%--</tr>--%>

    <tr>
        <td><span class="required">*</span>视频监控服务器IP：<input id="serverIp" name="serverIp" class="easyui-textbox"
                                                            value=""/></td>
        <td><span class="required">*</span>视频监控服务器端口：<input id="serverPort" name="serverPort" class="easyui-textbox"
                                                            value=""/></td>
    </tr>
    </tbody>
</table>
<div>

</div>
</body>
</html>

<script>


    /*地区类*/
    function place(AreaCode, Name) {
        this.AreaCode = AreaCode;//地区编码
        this.Name = Name;//地名
        /*地区类的PlaceType方法，返回值：String类型，表示地区类别，"p"代表省/直辖市、特别行政区，"c"代表市，"d"代表区/县。*/
        place.prototype.PlaceType = function () {
            var ac = parseInt(this.AreaCode);
            if (ac % 100 != 0) {
                return "d";
            } else if (ac % 10000 != 0) {
                return "c";
            } else {
                return "p";
            }
        }
        /*返回地点所属省编码*/
        place.prototype.ProvinceCode = function () {
            //整除10000得到省级编码（前2位数字）
            var ac = parseInt(this.AreaCode);
            return Math.floor(ac / 10000);
        }
        /*返回地点所属市编码*/
        place.prototype.CityCode = function () {
            //整除100得到市级编码（前4位数字）
            var ac = parseInt(this.AreaCode);
            return Math.floor(ac / 100);
        }
    }

    var provinces = new Array();//省数组
    var cities = new Array();//市数组
    var districts = new Array();//区数组
    /*initSeletList()这个函数初始化上面这三个数组，还有省下拉列表*/
    function initSeletList() {
        //遍历placesMap这个Json对象,根据key：value对创建place对象，并根据地区类型分类
        for (var key in placesMap) {
            var pl = new place(key, placesMap[key]);
            var ty = pl.PlaceType();
            if (ty == "p") {
                provinces.push(pl);
            }
            if (ty == "c") {
                cities.push(pl);
            }
            if (ty == "d") {
                districts.push(pl);

            }
        }
        //初始化省下拉选择列表
        for (var i = 0; i < provinces.length; i++) {
            var op = document.createElement("option");
            op.text = provinces[i].Name;
            op.value = provinces[i].ProvinceCode();
            document.getElementById("province").appendChild(op);
        }
    }


    function changeSelect2(element, pCode, cCode) {
        console.info(element)
        console.info(pCode)

//		var id=element.getAttribute("id");
        var province = $("#province").val();
        /*省下拉列表改变时更新市下拉列表和区下拉列表*/
        if (element == "province" && province != "000000") {
            document.getElementById("city").options.length = 1;//清除市下拉列表旧选项
//			var pCode=parseInt(element.value);//获取省下拉列表被选取项的省编码

            /*根据省编码更新市下拉列表*/
            if (pCode != 0) {
                for (var i = 0; i < cities.length; i++) {
                    if (cities[i].ProvinceCode() == pCode) {
                        var op = document.createElement("option");
                        op.text = cities[i].Name;
                        op.value = cities[i].CityCode();
                        document.getElementById("city").appendChild(op);
                    }
                }
            }
            document.getElementById("district").options.length = 1;//清除区下拉列表旧选项
//			var cCode=parseInt(document.getElementById("city").value);//获取市下拉列表被选中项的市编码
            /*根据市编码更新区下拉列表*/
            if (cCode != 0) {
                for (var i = 0; i < districts.length; i++) {
                    if (districts[i].CityCode() == cCode) {
                        var op = document.createElement("option");
                        op.text = districts[i].Name;
                        op.value = districts[i].AreaCode;
                        document.getElementById("district").appendChild(op);
                    }
                }
            }
        }
        /*市下拉列表改变时更新区下拉列表的选项*/
        if (element == "city" && province != "000000") {
            document.getElementById("district").options.length = 1;//清除区下拉列表旧选项
//			var cCode=parseInt(element.value);//获取市下拉列表被选中项的市编码
            /*根据市编码更新区下拉列表*/
            for (var i = 0; i < districts.length; i++) {
                if (districts[i].CityCode() == cCode) {
                    var op = document.createElement("option");
                    op.text = districts[i].Name;
                    op.value = districts[i].AreaCode;
                    document.getElementById("district").appendChild(op);
                }
            }

        }
    }


    //
    function changeSelect(element) {
        console.info(element)

        var id = element.getAttribute("id");
        /*省下拉列表改变时更新市下拉列表和区下拉列表*/
        if (id == "province" && element.value != "000000") {
            document.getElementById("city").options.length = 1;//清除市下拉列表旧选项
            var pCode = parseInt(element.value);//获取省下拉列表被选取项的省编码

            /*根据省编码更新市下拉列表*/
            if (pCode != 0) {
                for (var i = 0; i < cities.length; i++) {
                    if (cities[i].ProvinceCode() == pCode) {
                        var op = document.createElement("option");
                        op.text = cities[i].Name;
                        op.value = cities[i].CityCode();
                        document.getElementById("city").appendChild(op);
                    }
                }
            }
            document.getElementById("district").options.length = 1;//清除区下拉列表旧选项
            var cCode = parseInt(document.getElementById("city").value);//获取市下拉列表被选中项的市编码
            /*根据市编码更新区下拉列表*/
            if (cCode != 0) {
                for (var i = 0; i < districts.length; i++) {
                    if (districts[i].CityCode() == cCode) {
                        var op = document.createElement("option");
                        op.text = districts[i].Name;
                        op.value = districts[i].AreaCode;
                        document.getElementById("district").appendChild(op);
                    }
                }
            }
        }
        /*市下拉列表改变时更新区下拉列表的选项*/
        if (id == "city" && element.value != "000000") {
            document.getElementById("district").options.length = 1;//清除区下拉列表旧选项
            var cCode = parseInt(element.value);//获取市下拉列表被选中项的市编码
            /*根据市编码更新区下拉列表*/
            for (var i = 0; i < districts.length; i++) {
                if (districts[i].CityCode() == cCode) {
                    var op = document.createElement("option");
                    op.text = districts[i].Name;
                    op.value = districts[i].AreaCode;
                    document.getElementById("district").appendChild(op);
                }
            }

        }
    }


    /*
     ** 全局变量声明
     */
    var oldname = "";

    var oldphone = "";
    var token = sessionStorage.account;
    var globab_clientId = sessionStorage.clientId;
    $(function () {
        initSeletList();

        /*
        ** 判断当前状态是否为修改内容
        */

        $("#sysname").combobox({
            data: systemtype,
            valueField: 'id',
            textField: 'text'
        });

        if ('${param.clientId}' > 0) {
            loadvalue();
            $('#clientId').val('${param.clientId}');
        }


//		if (sessionStorage.cgFlag!=9){
//			$('#Messagenum').textbox('textbox').attr('readonly',true);
//			$('#orderovertime').textbox('textbox').attr('readonly',true);
//			$('#droporder').textbox('textbox').attr('readonly',true);
//			$('#waitminute').textbox('textbox').attr('readonly',true);
//			$('#smsid').textbox('textbox').attr('readonly',true);
//			$('#smskey').textbox('textbox').attr('readonly',true);
//			$('#areaname').textbox('textbox').attr('readonly',true);
//			$('#sysname').combobox({disabled: true});
//			$('#weixinname').textbox('textbox').attr('readonly',true);
//		}


    });


    /*
    ** 获取选中项的信息，并显示在输入框
    */
    function loadvalue() {
        $.ajax({
            url: path + '/clientSetting/findClientSettingByid?id=' +${param.clientId},
            dataType: "json",
            type: "POST",
            success: function (data) {
//	                console.info("loadvalue")
//	         	 	console.info(data);
                if (data != null && data != "") {

                    $('#Messagenum').textbox("setValue", data.messagenum);
                    $('#orderovertime').textbox("setValue", data.orderovertime);
                    $('#droporder').textbox("setValue", data.droporder);
                    $('#waitminute').textbox("setValue", data.waitminute);
                    $('#smsid').textbox("setValue", data.smsid);
                    $('#smscancelid').textbox("setValue", data.smscancelid);
                    $('#smskey').textbox("setValue", data.smskey);
                    $('#distance').textbox("setValue", data.distance);
                    $('#maxdrivernum').textbox("setValue", data.maxdrivernum);

                    var serverIp = "";
                    if (data.serverIp != "") {
                        serverIp = data.serverIp;
                    } else {
                        serverIp = "127.0.0.1"
                    }

                    var serverPort = "";
                    if (data.serverPort != "") {
                        serverPort = data.serverPort;
                    } else {
                        serverPort = "6605"
                    }

                    $('#serverIp').textbox("setValue", serverIp);
                    $('#serverPort').textbox("setValue", serverPort);

                    if (data.areaname != "") {
                        console.info()
                        var t = data.areaname;
                        var p = t.substring(0, 2);
                        var c = t.substring(0, 4);

                        changeSelect2('province', p, c);
                        $("#province option[value='" + p + "']").attr("selected", true);
                        $("#district option[value='" + data.areaname + "']").attr("selected", true);
                    }

//						$("#city option[value='4401']").attr("selected", true);
//						$('#province').val("44");
//						$('#city').val("4401");
//						$('#city').val("4401");
//						$('#city').find("option[text='4401']").attr("selected",true);
//						$("#province").attr("value","44");
//						$('#city').attr("value","4401");
//						$('#district').val(data.areaname);
//						$('#sysname').combobox("setValue",data.sysname);
//						$('#weixinname').textbox("setValue",data.weixinname);
                }

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

        var clientId = $('#clientId').val();
        var Messagenum = $('#Messagenum').textbox("getValue");
        var orderovertime = $('#orderovertime').textbox("getValue");
        var droporder = $('#droporder').textbox("getValue");
        var waitminute = $('#waitminute').textbox("getValue");
        var smscancelid = $('#smscancelid').textbox("getValue");
        var smsid = $('#smsid').textbox("getValue");
        var smskey = $('#smskey').textbox("getValue");
        var distance = $('#distance').textbox("getValue");

        var serverIp = $('#serverIp').textbox("getValue");
        var serverPort = $('#serverPort').textbox("getValue");
        var maxdrivernum = $('#maxdrivernum').textbox("getValue");


        var areaname = $("#district").val();
        if (areaname != null) {
            var test = areaname.substring(areaname.length - 2, areaname.length);
            if (test == 01) {
                areaname = "";
            }
        }

//		var sysname=  $('#sysname').combobox("getText");
//		var weixinname=  $('#weixinname').textbox("getValue");

        var data = {
            "clientId": clientId,
            "messagenum": Messagenum,
            "orderovertime": orderovertime,
            "droporder": droporder,
            "waitminute": waitminute,
            "smsid": smsid,
            "smscancelid": smscancelid,
            "smskey": smskey,
            "distance": distance,
            "areaname": areaname,
            "serverIp": serverIp,
            "serverPort": serverPort,
            "sysname": "1",
            "weixinname": "1",
            "token": token,
            "maxdrivernum": maxdrivernum,

        };
        console.info(data);

        var requestURL = path + "/clientSetting/saveorupdateClientSetting";
        $.ajax({
            type: "POST",
            crossDomain: true,
            url: requestURL,
            data: JSON.stringify(data), //必须转成JSON进行传递，否则会报code 117错误
            cache: false,
            dataType: "json", //后台返回值类型
            contentType: "application/json;charset=utf-8",
            success: function (data) {

                grid.treegrid('reload');
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
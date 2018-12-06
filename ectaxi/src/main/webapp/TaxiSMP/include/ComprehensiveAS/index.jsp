<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta name="wap-font-scale" content="no"/>
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>综合分析系统</title>

    <!-- favicon -->
    <link rel="shortcut icon" href="favicon.png">

    <!-- common.css -->
    <link rel="stylesheet" href="../../public/css/common.css">

    <!-- login.css -->
    <link rel="stylesheet" href="public/css/index.css">

    <!-- jquery -->
    <script src="../../public/js/jquery-2.2.4.min.js"></script>

    <!-- index.js -->
    <%--<script src="../../public/js/childindex.js"></script>--%>

    <script src="../../public/js/path.js"></script>
</head>

<body>

<!-- 头部 -->
<header>
    <ul id="firstMenu">
        <%--<li class="firstMenuLi firstMenuLiActive" data-menu="secondMenu01"><span class="icon icon-E919"></span><p>综合查询</p></li>--%>
        <%--<li class="firstMenuLi" data-menu="secondMenu02"><span class="icon icon-E93A"></span><p>行业情况</p></li>--%>
        <%--<li class="firstMenuLi" data-menu="secondMenu03"><span class="icon icon-E916"></span><p>运营收入</p></li>--%>
        <%--<li class="firstMenuLi" data-menu="secondMenu04"><span class="icon icon-E94F"></span><p>电召服务</p></li>--%>
        <%--<li class="firstMenuLi" data-menu="secondMenu05"><span class="icon icon-E934"></span><p>运营效率</p></li>--%>
        <%--<li class="firstMenuLi" data-menu="secondMenu06"><span class="icon icon-E910"></span><p>服务质量</p></li>--%>
        <%--<li class="firstMenuLi" data-menu="secondMenu07"><span class="icon icon-E905"></span><p>劳动强度</p></li>--%>
    </ul>
    <div id="setAndOut">
        <p>欢迎您，<span id="name">超级管理员</span></p>
        <dl id="setAndOutDl">
            <dd id="outlogin" title="点击注销退出"><img src="public/image/outlogin.svg" alt="">注销</dd>
            <dd id="setting"><img src="public/image/setting.svg" alt="">设置</dd>
        </dl>
    </div>
</header>

<!-- 导航 vertical -->
<nav class="horizontal">
    <%--<ul id="secondMenu01" class="secondMenu">--%>
    <%--<li class="secondMenuLi secondMenuLiActive"><a href="integrateSearch/enterpriseInt_list.jsp" target="iframe"><span class="icon icon-E90D"></span><p>企业综合查询</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="integrateSearch/vehicleInt_list.jsp" target="iframe"><span class="icon icon-E925"></span><p>车辆综合查询</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="integrateSearch/pilotInt_list.jsp" target="iframe"><span class="icon icon-E91D"></span><p>驾驶员综合查询</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="integrateSearch/operat_details_list.jsp" target="iframe"><span class="icon icon-E919"></span><p>运营数据查询</p></a></li>--%>
    <%--</ul>--%>
    <%--<ul id="secondMenu02" class="secondMenu">--%>
    <%--<li class="secondMenuLi"><a href="industry/company_list.jsp" target="iframe"><span class="icon icon-E90D"></span><p>企业信息分析</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="industry/vehicle_list.jsp" target="iframe"><span class="icon icon-E939"></span><p>车辆信息分析</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="industry/driver_list.jsp" target="iframe"><span class="icon icon-E91D"></span><p>驾驶员信息分析</p></a></li>--%>
    <%--</ul>--%>
    <%--<ul id="secondMenu03" class="secondMenu">--%>
    <%--<li class="secondMenuLi"><a href="income/vehicleMonth_list.jsp" target="iframe"><span class="icon icon-E90C"></span><p>车辆月收入分析</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="income/peak_list.jsp" target="iframe"><span class="icon icon-E911"></span><p>高峰时段收入分析</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="income/company_list.jsp" target="iframe"><span class="icon icon-E90D"></span><p>企业收入排行</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="income/vehicle_list.jsp" target="iframe"><span class="icon icon-E939"></span><p>车辆收入排行</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="income/driver_list.jsp" target="iframe"><span class="icon icon-E91D"></span><p>驾驶员收入排行</p></a></li>--%>
    <%--</ul>--%>
    <%--<ul id="secondMenu04" class="secondMenu">--%>
    <%--<li class="secondMenuLi"><a href="calling/period_list.jsp" target="iframe"><span class="icon icon-E950"></span><p>电召时段分析</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="calling/peak_list.jsp" target="iframe"><span class="icon icon-E911"></span><p>电召高峰分析</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="calling/breach_list.jsp" target="iframe"><span class="icon icon-E933"></span><p>电召违约分析</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="calling/mileage_list.jsp" target="iframe"><span class="icon icon-E944"></span><p>里程收入分析</p></a></li>--%>
    <%--</ul>--%>
    <%--<ul id="secondMenu05" class="secondMenu">--%>
    <%--<li class="secondMenuLi"><a href="efficiency/dayByCar_list.jsp" target="iframe"><span class="icon icon-E904"></span><p>日均出车统计</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="efficiency/mileageTime_list.jsp" target="iframe"><span class="icon icon-E944"></span><p>运营里程-按时段</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="efficiency/mileagePeak_list.jsp" target="iframe"><span class="icon icon-E944"></span><p>运营里程-按高峰</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="efficiency/eachTime_list.jsp" target="iframe"><span class="icon icon-E944"></span><p>运营次数-按时段</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="efficiency/eachPeak_list.jsp" target="iframe"><span class="icon icon-E944"></span><p>运营次数-按高峰</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="efficiency/companyByCar_list.jsp" target="iframe"><span class="icon icon-E90D"></span><p>企业出车统计</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="efficiency/passengerTime_list.jsp" target="iframe"><span class="icon icon-E951"></span><p>载客时长分析</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="efficiency/lowSpeedTime_list.jsp" target="iframe"><span class="icon icon-E951"></span><p>低速候时分析</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="efficiency/averageTime_list.jsp" target="iframe"><span class="icon icon-E951"></span><p>平均时间间隔分析</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="efficiency/averageSpeed_list.jsp" target="iframe"><span class="icon icon-E911"></span><p>平均速度分析</p></a></li>--%>
    <%--</ul>--%>
    <%--<ul id="secondMenu06" class="secondMenu">--%>
    <%--<li class="secondMenuLi"><a href="service/overallSatAna_list.jsp" target="iframe"><span class="icon icon-E934"></span><p>总体满意度分析</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="service/companySatRan_list.jsp" target="iframe"><span class="icon icon-E918"></span><p>企业满意度排名</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="service/companySat_list.jsp" target="iframe"><span class="icon icon-E916"></span><p>企业满意度</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="service/driverSatRan_list.jsp" target="iframe"><span class="icon icon-E916"></span><p>驾驶员满意度排名</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="service/driverSat_list.jsp" target="iframe"><span class="icon icon-E916"></span><p>驾驶员满意度</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="service/overallComAna_list.jsp" target="iframe"><span class="icon icon-E926"></span><p>总体投诉率分析</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="service/companyCom_list.jsp" target="iframe"><span class="icon icon-E926"></span><p>企业投诉率</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="service/driverCom_list.jsp" target="iframe"><span class="icon icon-E926"></span><p>驾驶员投诉率</p></a></li>--%>
    <%--</ul>--%>
    <%--<ul id="secondMenu07" class="secondMenu">--%>
    <%--<li class="secondMenuLi"><a href="labor/totalTime_list.jsp" target="iframe"><span class="icon icon-E951"></span><p>总时长分析</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="labor/companyTime_list.jsp" target="iframe"><span class="icon icon-E90D"></span><p>企业时长分析</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="labor/driverTime_list.jsp" target="iframe"><span class="icon icon-E91D"></span><p>驾驶员时长分析</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="labor/totalIncome_list.jsp" target="iframe"><span class="icon icon-E916"></span><p>总营收分析</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="labor/companyIncome_list.jsp" target="iframe"><span class="icon icon-E911"></span><p>企业营收分析</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="labor/driverIncome_list.jsp" target="iframe"><span class="icon icon-E912"></span><p>驾驶员营收分析</p></a></li>--%>
    <%--</ul>--%>
</nav>

<!-- 嵌入网页iframe -->
<article>
    <iframe src="" frameborder="0" name="iframe" id="iframe"></iframe>
</article>

<!-- 设置 -->
<section id="setSelect">
    <ul>
        <li><label for="auto"><input type="radio" name="SMPosition" id="auto" checked>二级菜单自动隐藏</label></li>
        <li><label for="left"><input type="radio" name="SMPosition" id="left">二级菜单固定在左边</label></li>
        <li><label for="right"><input type="radio" name="SMPosition" id="right">二级菜单固定在右边</label></li>
        <li><label for="top"><input type="radio" name="SMPosition" id="top">二级菜单固定在上面</label></li>
        <li><label for="bottom"><input type="radio" name="SMPosition" id="bottom">二级菜单固定在底部</label></li>
    </ul>
</section>


</body>
</html>
<script>
    var glole_roleid = "";
    $(function () {
        findtokenByUserinfo(sessionStorage.account);

    });

    //根据token查找登录用户信息
    function findtokenByUserinfo(data) {
        $.ajax({
            url: path + '/userinfo/findUserinfoByToken?token=' + data,
            dataType: 'json',
            type: "POST",
            async: false,
            success: function (data) {
                ////console.info(data);
                sessionStorage.accountID = data.accountID;
                sessionStorage.accountName = data.accountName;
                sessionStorage.userName = data.userName;
                sessionStorage.company = data.company;
                sessionStorage.islock = data.islock;
                sessionStorage.cgFlag = data.cgFlag;
                sessionStorage.clientId = data.clientId;
                glole_roleid = data.roleid;

                $("#name").html(sessionStorage.userName);

                navigation(0, 6, glole_roleid);
                loadmemu(6, glole_roleid);


            }

        });
    }

    //加载导航和菜单
    function navigation(pid, ppid, roleid) {

        $.ajax({
            url: path + '/resource/findResourceByPPidtoPid?pid=' + pid + "&ppid=" + ppid + "&roleid=" + roleid,
            dataType: 'json',
            type: "POST",
            async: false,
            success: function (data) {

                var listnav = "";
                var ac = "";
                if (data != "") {
                    for (var i = 0; i < data.length; i++) {
                        if (i == 0) {
                            ac = "firstMenuLiActive";
                        } else {
                            ac = "";
                        }
                        listnav += '<li class="firstMenuLi ' + ac + '" data-menu="' + data[i].powerUrl + '"><span class="icon ' + data[i].iconCls + '"></span><p>' + data[i].powerName + '</p></li>' + "\n";
                    }

                    $("#firstMenu").html(listnav);
                } else {
                    alert("当前用户没有权限！");
                }


            }

        });
    }

    //加载导航和菜单
    function loadmemu(data, roleid) {
//        ////console.info("glole_roleid:"+roleid);
        $.ajax({
            url: path + '/resource/findResourceByPPid?ppid=' + data + "&roleid=" + roleid,
            dataType: 'json',
            type: "POST",
            async: false,
            success: function (data) {
//                ////console.info(data);
                var listmemu = "";
                var memuflag = false;
                var iframe = true;
                var ac = "";
                if (data != "") {
                    for (var i = 0; i < data.length; i++) {
                        if (i == 1) {
                            ac = "secondMenuLiActive";
                        } else {
                            ac = "";
                        }
//                        ////console.info(data[i].pid);
                        if (data[i].pid == 0) {
                            if (memuflag) {
                                listmemu += '</ul>' + "\n";
                            }
                            listmemu += '<ul id="' + data[i].powerUrl + '" class="secondMenu">' + "\n";
                            memuflag = true;
                        }
                        else {
                            if (iframe) {
                                $("#iframe").attr("src", data[i].powerUrl);
                                iframe = false;
                            }
                            listmemu += '<li class="secondMenuLi ' + ac + '"><a href="' + data[i].powerUrl + '" target="iframe"><span class="icon ' + data[i].iconCls + '"></span><p>' + data[i].powerName + '</p></a></li>' + "\n";
                        }

                    }
                    listmemu += '</ul>';

//                    ////console.info(listmemu);
                    $(".horizontal").html(listmemu);


                }


                asyncLoading();


            }

        });
    }

    //异步加载js
    function asyncLoading() {
        var script = document.createElement("script");
        script.src = "../../public/js/childindex.js";

        var body = document.body;
        body.insertBefore(script, body.firstChild);
    }

</script>
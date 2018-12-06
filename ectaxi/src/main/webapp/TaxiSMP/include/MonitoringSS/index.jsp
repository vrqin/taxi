<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta name="wap-font-scale" content="no"/>
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>监控调度系统</title>

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
        <%--<li class="firstMenuLi firstMenuLiActive" data-menu="secondMenu01"><span class="icon icon-E90C"></span><p>基础信息</p></li>--%>
        <%--<li class="firstMenuLi" data-menu="secondMenu02"><span class="icon icon-E934"></span><p>行业监控</p></li>--%>
        <%--<li class="firstMenuLi" data-menu="secondMenu03"><span class="icon icon-E926"></span><p>查询统计</p></li>--%>
        <%--<li class="firstMenuLi" data-menu="secondMenu04"><span class="icon icon-E916"></span><p>报警统计</p></li>--%>
        <%--<li class="firstMenuLi" data-menu="secondMenu05"><span class="icon icon-E918"></span><p>系统信息</p></li>--%>
        <%--<li class="firstMenuLi" data-menu="secondMenu06"><span class="icon icon-E919"></span><p>监控中心</p></li>--%>
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
    <%--<li class="secondMenuLi secondMenuLiActive">--%>
    <%--<a href="basicinfo/enterpriseinfo_list.jsp" target="iframe"><span class="icon icon-E90A"></span><p>企业信息</p></a>--%>
    <%--</li>--%>
    <%--<li class="secondMenuLi"><a href="basicinfo/user_list.jsp" target="iframe"><span class="icon icon-E91C"></span><p>用户管理</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="basicinfo/carinfo_list.jsp" target="iframe"><span class="icon icon-E91D"></span><p>车辆信息</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="basicinfo/car_group_list.jsp" target="iframe"><span class="icon icon-E938"></span><p>车辆分组</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="basicinfo/driverinfo_list.jsp" target="iframe"><span class="icon icon-E939"></span><p>驾驶员信息</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="basicinfo/succession_set_list.jsp" target="iframe"><span class="icon icon-E93A"></span><p>交接班设置</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="basicinfo/freight_info_list.jsp" target="iframe"><span class="icon icon-E93B"></span><p>运价信息</p></a></li>--%>
    <%--</ul>--%>
    <%--<ul id="secondMenu02" class="secondMenu">--%>
    <%--<li class="secondMenuLi"><a href="industryManagement/usage_platform_list.jsp" target="iframe"><span class="icon icon-E91F"></span><p>平台使用情况</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="industryManagement/caronline_list.jsp" target="iframe"><span class="icon icon-E90A"></span><p>车辆在线情况</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="industryManagement/operating_situation_list.jsp" target="iframe"><span class="icon icon-E934"></span><p>运营的情况</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="industryManagement/query_presented_list.jsp" target="iframe"><span class="icon icon-E934"></span><p>交接班查询</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="industryManagement/mistake_monitoring_list.jsp" target="iframe"><span class="icon icon-E934"></span><p>错时交班监控</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="industryManagement/complaint_list.jsp" target="iframe"><span class="icon icon-E934"></span><p>投诉处理</p></a></li>--%>
    <%--</ul>--%>
    <%--<ul id="secondMenu03" class="secondMenu">--%>
    <%--<li class="secondMenuLi"><a href="queryStatistics/orderdetails_list.jsp" target="iframe"><span class="icon icon-E92C"></span><p>电召订单明细</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="queryStatistics/operat_details_list.jsp" target="iframe"><span class="icon icon-E92B"></span><p>运营收入明细</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="queryStatistics/operat_statis_list.jsp" target="iframe"><span class="icon icon-E92B"></span><p>运营收入统计</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="queryStatistics/driver_ser_details_list.jsp" target="iframe"><span class="icon icon-E92B"></span><p>驾驶员服务统计</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="queryStatistics/driver_vio_deltails_list.jsp" target="iframe"><span class="icon icon-E93A"></span><p>驾驶员违规明细</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="queryStatistics/driver_vio_statis_list.jsp" target="iframe"><span class="icon icon-E934"></span><p>驾驶员违规统计</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="queryStatistics/drive_rapple_list.jsp" target="iframe"><span class="icon icon-E934"></span><p>司机申请信息</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="queryStatistics/caronline_list.jsp" target="iframe"><span class="icon icon-E925"></span><p>车辆在线查询</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="queryStatistics/termonline_list.jsp" target="iframe"><span class="icon icon-E92D"></span><p>终端在线查询</p></a></li>--%>
    <%--</ul>--%>
    <%--<ul id="secondMenu04" class="secondMenu">--%>
    <%--<li class="secondMenuLi"><a href="policeStatistics/emergency_alarm_details.jsp" target="iframe"><span class="icon icon-E93C"></span><p>紧急报警明细</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="policeStatistics/emergency_alarm_statis.jsp" target="iframe"><span class="icon icon-E93D"></span><p>紧急报警统计</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="policeStatistics/overspeed_alarm_details.jsp" target="iframe"><span class="icon icon-E93E"></span><p>超速报警明细</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="policeStatistics/overspeed_alarm_statis.jsp" target="iframe"><span class="icon icon-E93F"></span><p>超速报警统计</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="policeStatistics/fatigue_driving_details.jsp" target="iframe"><span class="icon icon-E940"></span><p>疲劳驾驶明细</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="policeStatistics/fatigue_driving_statis.jsp" target="iframe"><span class="icon icon-E941"></span><p>疲劳驾驶统计</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="policeStatistics/regional_police_details.jsp" target="iframe"><span class="icon icon-E942"></span><p>区域报警明细</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="policeStatistics/regional_police_statis.jsp" target="iframe"><span class="icon icon-E943"></span><p>区域报警统计</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="policeStatistics/route_alarm_detail.jsp" target="iframe"><span class="icon icon-E944"></span><p>线路报警明细</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="policeStatistics/route_alarm_statis.jsp" target="iframe"><span class="icon icon-E945"></span><p>线路报警统计</p></a></li>--%>
    <%--</ul>--%>
    <%--<ul id="secondMenu05" class="secondMenu">--%>
    <%--<li class="secondMenuLi"><a href="systeminfo/change_password.jsp" target="iframe"><span class="icon icon-E92F"></span><p>修改密码</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="systeminfo/log_list.jsp" target="iframe"><span class="icon icon-E930"></span><p>登录日志</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="systeminfo/operation_list.jsp" target="iframe"><span class="icon icon-E931"></span><p>操作日志</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="systeminfo/message_list.jsp" target="iframe"><span class="icon icon-E932"></span><p>短信日志</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="systeminfo/abnormal_list.jsp" target="iframe"><span class="icon icon-E933"></span><p>异常日志</p></a></li>--%>
    <%--</ul>--%>
    <%--<ul id="secondMenu06" class="secondMenu">--%>
    <%--<li class="secondMenuLi"><a href="monitoringCenter/monitoring.jsp" target="iframe"><span class="icon icon-E953"></span><p>实时监控</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="monitoringCenter/monitortmap.jsp" target="iframe"><span class="icon icon-E954"></span><p>车辆监控</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="monitoringCenter/history_track.jsp" target="iframe"><span class="icon icon-E944"></span><p>历史轨迹</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="" target="iframe"><span class="icon icon-E931"></span><p>远程控制</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="" target="iframe"><span class="icon icon-E932"></span><p>视频监控</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="" target="iframe"><span class="icon icon-E933"></span><p>多媒体管理</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="" target="iframe"><span class="icon icon-E933"></span><p>预警设置</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="" target="iframe"><span class="icon icon-E933"></span><p>应急调度</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="" target="iframe"><span class="icon icon-E933"></span><p>热力图</p></a></li>--%>
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

                navigation(0, 3, glole_roleid);
                loadmemu(3, glole_roleid);


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
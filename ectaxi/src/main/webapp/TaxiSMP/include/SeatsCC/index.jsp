<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta name="wap-font-scale" content="no"/>
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>坐席调度中心</title>

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
        <%--<li class="firstMenuLi firstMenuLiActive" data-menu="secondMenu01"><span class="icon icon-E90C"></span><p>派单管理</p></li>--%>
        <%--<li class="firstMenuLi" data-menu="secondMenu02"><span class="icon icon-E923"></span><p>失物管理</p></li>--%>
        <%--<li class="firstMenuLi" data-menu="secondMenu03"><span class="icon icon-E926"></span><p>投诉管理</p></li>--%>
        <%--<li class="firstMenuLi" data-menu="secondMenu04"><span class="icon icon-E916"></span><p>基础数据</p></li>--%>
        <%--<li class="firstMenuLi" data-menu="secondMenu05"><span class="icon icon-E918"></span><p>电召诚信</p></li>--%>
        <%--<li class="firstMenuLi" data-menu="secondMenu06"><span class="icon icon-E919"></span><p>查询统计</p></li>--%>
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
    <%--<a href="sendOrderManagement/neworder_list.jsp" target="iframe"><span class="icon icon-E94F"></span><p>电召派单</p></a>--%>
    <%--</li>--%>
    <%--<li class="secondMenuLi"><a href="sendOrderManagement/sendorder_list.jsp" target="iframe"><span class="icon icon-E950"></span><p>已派单</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="sendOrderManagement/reservations_list.jsp" target="iframe"><span class="icon icon-E951"></span><p>预约单</p></a></li>--%>
    <%--</ul>--%>
    <%--<ul id="secondMenu02" class="secondMenu">--%>
    <%--<li class="secondMenuLi"><a href="lostPropertyManagement/lostaccept_list.jsp" target="iframe"><span class="icon icon-E923"></span><p>失物受理</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="lostPropertyManagement/lostlibrary_list.jsp" target="iframe"><span class="icon icon-E924"></span><p>失物入库</p></a></li>--%>
    <%--</ul>--%>
    <%--<ul id="secondMenu03" class="secondMenu">--%>
    <%--<li class="secondMenuLi"><a href="complaintManagement/complaint_list.jsp" target="iframe"><span class="icon icon-E926"></span><p>投诉管理</p></a></li>--%>
    <%--</ul>--%>
    <%--<ul id="secondMenu04" class="secondMenu">--%>
    <%--<li class="secondMenuLi"><a href="basicinfo/passengerinfo_list.jsp" target="iframe"><span class="icon icon-E91C"></span><p>乘客信息</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="basicinfo/driverinfo_list.jsp" target="iframe"><span class="icon icon-E91D"></span><p>驾驶员信息</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="basicinfo/seats_list.jsp" target="iframe"><span class="icon icon-E90F"></span><p>座席人员</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="basicinfo/commonpoint_list.jsp" target="iframe"><span class="icon icon-E91E"></span><p>常用约车点</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="basicinfo/callstation_list.jsp" target="iframe"><span class="icon icon-E920"></span><p>电召站管理</p></a></li>--%>
    <%--</ul>--%>
    <%--<ul id="secondMenu05" class="secondMenu">--%>
    <%--<li class="secondMenuLi"><a href="callingIntegrity/passcredit_list.jsp" target="iframe"><span class="icon icon-E927"></span><p>乘客诚信</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="callingIntegrity/drivercredit_list.jsp" target="iframe"><span class="icon icon-E928"></span><p>驾驶员诚信</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="callingIntegrity/passblack_list.jsp" target="iframe"><span class="icon icon-E929"></span><p>乘客黑名单</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="callingIntegrity/driverblack_list.jsp" target="iframe"><span class="icon icon-E92A"></span><p>驾驶员黑名单</p></a></li>--%>
    <%--</ul>--%>
    <%--<ul id="secondMenu06" class="secondMenu">--%>
    <%--<li class="secondMenuLi"><a href="queryStatistics/orderdetails_list.jsp" target="iframe"><span class="icon icon-E94F"></span><p>电召业务</p></a></li>--%>
    <%--<li class="secondMenuLi"><a href="queryStatistics/evadetails_list.jsp" target="iframe"><span class="icon icon-E952"></span><p>服务评价</p></a></li>--%>
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
        if (sessionStorage.sys == 4) {
            findtokenBySeatinfo(sessionStorage.account);
        } else {
            findtokenByUserinfo(sessionStorage.account);
        }

    });

    function findtokenBySeatinfo(data) {
        $.ajax({
            url: path + '/passenger/findPassByid?opruser=' + data,
            dataType: 'json',
            type: "GET",
            async: false,
            success: function (data) {
//                console.info(data);

                sessionStorage.accountID = data.id;
                sessionStorage.accountName = data.opruser;
                sessionStorage.userName = data.name;
                sessionStorage.cgFlag = 4;
                sessionStorage.clientId = data.clientid;
                sessionStorage.assign = data.assign;
                glole_roleid = data.roleid;

                $("#name").html(sessionStorage.userName);

                navigation(0, 4, glole_roleid);
                loadmemu(4, glole_roleid);


            }

        });
    }


    //根据token查找登录用户信息
    function findtokenByUserinfo(data) {
        $.ajax({
            url: path + '/userinfo/findUserinfoByToken?token=' + data,
            dataType: 'json',
            type: "POST",
            async: false,
            success: function (data) {
                //console.info(data);
                sessionStorage.accountID = data.accountID;
                sessionStorage.accountName = data.accountName;
                sessionStorage.userName = data.userName;
                sessionStorage.company = data.company;
                sessionStorage.islock = data.islock;
                sessionStorage.cgFlag = data.cgFlag;
                sessionStorage.clientId = data.clientId;
                glole_roleid = data.roleid;

                $("#name").html(sessionStorage.userName);

                navigation(0, 4, glole_roleid);
                loadmemu(4, glole_roleid);


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
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no"
          name="viewport" id="viewport"/>
    <title>出租车、网约车服务管理平台</title>

    <!-- 注：HTML、CSS以1200px为最小尺寸 -->

    <!--[if lt IE 10]>
    <script type="text/javascript">
        document.createElement("header");
        document.createElement("section");
        document.createElement("nav");
        document.createElement("footer");
    </script>
    <link rel="stylesheet" href="public/css/tips.css">
    <script type="text/javascript" src="public/js/tips.js"></script>
    <![endif]-->

    <!-- favicon -->
    <link rel="shortcut icon" href="favicon.png">

    <!-- common.css -->
    <link rel="stylesheet" href="public/css/common.css">

    <!-- index.css -->
    <link rel="stylesheet" href="public/css/index2.css">

</head>

<body>

<!-- 头部 -->
<header>出租车、网约车服务管理平台</header>

<!-- 内容 -->
<article>
    <ul>
        <li class="selectLi"><a href="include/SeatsCC/login.jsp"><p><span class="icon icon-E90F"></span></p>
            <h2>座席调度中心</h2></a></li>
        <li class="selectLi"><a href="include/MonitoringSS/login.jsp"><p><span class="icon icon-E90E"></span></p>
            <h2>监控调度系统</h2></a></li>
        <li class="selectLi"><a href="include/EnterpriseBS/login.jsp"><p><span class="icon icon-E90D"></span></p>
            <h2>企业业务系统</h2></a></li>
        <li class="selectLi"><a href="include/CallingSS/login.jsp"><p><span class="icon icon-E90C"></span></p>
            <h2>电召服务系统</h2></a></li>
        <li class="selectLi"><a href="include/OperationSC/login.jsp"><p><span class="icon icon-E913"></span></p>
            <h2>运营服务中心</h2></a></li>
        <li class="selectLi"><a href="include/DynamicIS/login.jsp"><p><span class="icon icon-E912"></span></p>
            <h2>动态稽查系统</h2></a></li>
        <li class="selectLi"><a href="include/ComprehensiveAS/login.jsp"><p><span class="icon icon-E911"></span></p>
            <h2>综合分析系统</h2></a></li>
        <li class="selectLi"><a href="include/ServiceES/login.jsp"><p><span class="icon icon-E910"></span></p>
            <h2>服务考评系统</h2></a></li>
    </ul>
</article>

<!-- 尾部 -->
<footer>版权所有 翻版必究</footer>

<!-- 浏览器不支持提示 -->

</body>
</html>
<script>

    function htmlFont() {
        var innerWidth = window.innerWidth;
        document.querySelector("html").style.fontSize = (innerWidth / 12.8) + "px";
    }

    htmlFont();
    window.onresize = htmlFont;

</script>
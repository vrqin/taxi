<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>添加NotifierPlus</title>

    <!-- jquery easyui 插件 -->
    <link href="../../public/jquery-easyui-1.5/themes/metro/easyui.css" rel="stylesheet"/>
    <link href="../../public/jquery-easyui-1.5/themes/icon.css" rel="stylesheet"/>
    <script src="../../public/jquery-easyui-1.5/js/jquery.min.js"></script>
    <script src="../../public/jquery-easyui-1.5/js/jquery.easyui.min.js"></script>
    <script src="../../public/jquery-easyui-1.5/js/easyui-lang-zh_CN.js"></script>

    <!-- 数据接口路径、共用JS -->
    <script src="../../public/js/path.js"></script>
    <script src="../../public/js/constant.js"></script>

    <style>
        html, body {
            margin: 0px;
            padding: 0px;
            width: 100%;
            height: 100%;
        }

        .menutree {
            box-sizing: border-box;
            /* width: auto; */
            height: 399px;
            background: white;
            overflow-y: auto;
        }

        #notiyt {
            width: 50%;
            height: 100%;
            float: left;
            box-sizing: border-box;
            padding: 36px;
        }

        #notiyt textarea {
            width: 80%;
        }

        #notiyt span {
            font-weight: bold;
        }

        #tip {

        }

        ul li {
            margin: 28px 0;
        }

        ul li span {
            color: red;
            font-weight: bold;
        }
    </style>
    <script>


        $(function () {

            limitTip(sessionStorage.clientId);

        });

        function limitTip(clientId) {
            var tip = "";
//        <li></li>
            $.ajax({
                url: path + '/driver/findListremainByZero?clientid=' + clientId,
                dataType: 'json',
                type: "GET",
                async: false,
                success: function (data) {
//                    console.info(data);
                    if (data != "" && data != null) {
                        if (data.code > 0) {
                            tip += "<li>有 <span >" + data.code + "</span> 个司机的可以使用次数以为 0 ,司机帐号分别为" + data.desc + "</li>";

                        }

                    }
                }

            });


            $.ajax({
                url: path + '/clientSetting/findListMessagesByZero?clientid=' + clientId,
                dataType: 'json',
                type: "GET",
                async: false,
                success: function (data) {

//                    console.info(data);
                    if (data != "" && data != null) {
                        if (data.code > 0) {
                            tip += " <li>有 <span >" + data.code + "</span> 个公司短信数为 0 ,公司名称分别为" + data.desc + "</li>";

                        }

                    }
                }

            });

//            console.info(tip);
            if (tip != null && tip != "") {
                $("#alltip").html(tip);
            }

        }


    </script>
</head>
<body class="easyui-layout" data-options="fit:true">


<ul id="alltip">
    <%--<li id="drivertip"></li>--%>
    <%--<li id="cleinttip"></li>--%>
</ul>

</body>
</html>



<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>上传文件</title>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.min.js"></script>
    <!-- 数据接口路径、共用JS -->
    <script src="../../../public/js/path.js"></script>

    <style>
        html, body, p {
            padding: 0px;
            margin: 0px;
            font-size: 12px;
        }

        p {
            padding: 0px;
            margin: 0px;
            font-size: 12px;
        }

    </style>

</head>
<body style="box-sizing: border-box;">


<form id="form" action="" method="post" enctype="multipart/form-data">
    <%--头像 身份证 驾驶证--%>
    <p>
        <input type="file" name="file" id="file" size="45" accept="image/png" style="width: 167px;"/>
        <input id="iffsubmit" type="button" value="上传图片"/>
        <input id="id" name="id" value="" type="hidden">
    </p>

</form>


</body>
</html>

<script>
    $(function () {

        $("#form").attr("action", path + "/file/uploaddiscountpon");
//		alert(window.parent.$("#account").textbox('getValue'));

        $("#iffsubmit").on('click', function () {
            var file = $("#file").val();
            if (file == "" || file == null) {
                alert(" 请选择上传图片！");
                return;
            }

            var account = window.parent.$("#id").textbox('getValue');
            if (account == "") {
                alert("无法获取用户名,请关闭对话框重新点击修改");
                return;
            }
            $("#id").val(window.parent.$("#id").textbox('getValue'));
            window.parent.$("#id").textbox('textbox').attr('readonly', true);

            window.parent.$("#carstatus").val(1);
            $("#form").submit();
        });
    });

</script>
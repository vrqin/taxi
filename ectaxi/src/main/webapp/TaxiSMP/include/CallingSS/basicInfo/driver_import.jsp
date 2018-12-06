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
<body class="easyui-layout" data-options="fit:true" style="box-sizing: border-box;">


<form id="form" action="" method="post" enctype="multipart/form-data">

    <p>
        选择文件 : <input type="file" name="file" id="file" size="45" accept="application/vnd.ms-excel"/>
        <input id="iffsubmit" type="button" value="上传"/>
        <input id="account" name="account" value="" type="hidden">
    </p>

</form>


</body>
</html>

<script>
    $(function () {

        $("#form").attr("action", path + "/file/importDriver");
        $("#iffsubmit").on('click', function () {
            var file = $("#file").val();
            if (file == "" || file == null) {
                alert(" 请选择导入文件！");
                return;
            }
            $("#account").val(sessionStorage.accountName);

            $("#form").submit();
        });
    });

</script>
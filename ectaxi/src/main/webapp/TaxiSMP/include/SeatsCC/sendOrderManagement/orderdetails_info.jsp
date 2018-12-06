<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>添加电召站</title>

    <!-- jquery easyui 插件 -->
    <link href="../../../public/jquery-easyui-1.5/themes/metro/easyui.css" rel="stylesheet"/>
    <link href="../../../public/jquery-easyui-1.5/themes/icon.css" rel="stylesheet"/>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.easyui.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/easyui-lang-zh_CN.js"></script>

    <!-- 数据接口路径、共用JS -->
    <script src="../../../public/js/path.js"></script>
    <script src="../../../public/js/constant.js"></script>
    <script src="../../../public/js/amrnb.js"></script>


    <style>
        .table {
            width: 100%;
            /*height: 100%;*/
            font-size: 12px;
            text-align: center;
            border-spacing: 10px;
        }
    </style>

</head>
<body class="easyui-layout" data-options="fit:true" style="padding:10px; box-sizing: border-box;">

<table class="table">
    <tbody>

    <tr>
        <td>电召单号：<input id="billid" class="easyui-textbox"/></td>
        <td>电召时间：<input id="calltime" class="easyui-textbox"/></td>
    </tr>
    <tr>
        <td>电召状态：<input id="orderstatus" class="easyui-textbox"/></td>
        <td>乘客姓名：<input id="clientname" class="easyui-textbox"/></td>
    </tr>
    <tr>
        <td>乘客电话：<input id="callnumber" class="easyui-textbox"/></td>
        <td>服务评分：<input id="evaluate" class="easyui-textbox"/></td>
    </tr>
    <tr>
        <td>司机姓名：<input id="msid" class="easyui-textbox"/></td>
        <td>司机电话：<input id="drivermoli" class="easyui-textbox"/></td>
    </tr>
    <tr>
        <td>车牌号：<input id="carbox" class="easyui-textbox"/></td>
        <td>订单类型：<input id="orderType" class="easyui-textbox"/></td>
    </tr>

    <tr>
        <td colspan="2" style="text-align: left">&nbsp;&nbsp;&nbsp; 起点：<input id="srcaddr" class="easyui-textbox"
                                                                              style="width: 350px"/></td>
    </tr>
    <tr>
        <td colspan="2" style="text-align: left">&nbsp;&nbsp;&nbsp; 终点：<input id="address" class="easyui-textbox"
                                                                              style="width: 350px"/></td>
    </tr>
    <tr id="recording" style="text-align: left;display: none">
        <td colspan="2">&nbsp;&nbsp;&nbsp;电话录音：
            <span id="sample-amr">

                <%--<button>播放</button> <a id="recordurl" href="" style="display: none">test.amr</a>--%>
                <audio controls src="" id="recordurl">


                </audio>
            </span>

        </td>
    </tr>
    </tbody>
</table>

</body>
</html>

<script>

    $(function () {

        /*
         ** 判断当前状态是否为修改内容
         */
        if ('${param.billid}' > 0) {
            loadvalue();
        }
    });

    /*
     ** 获取选中项的信息，并显示在输入框
     */
    function loadvalue() {

        var requestURL = path + '/callbuss/callbussByid?billid=' + '${param.billid}';

        $.ajax({
            type: "GET",
            url: requestURL,
            async: false,
            dataType: "json", //后台返回值类型
            success: function (data) {
//                console.info(data);

                if (data != null) {
                    $('#billid').textbox('setValue', data.billid);
                    $('#callnumber').textbox('setValue', data.callnumber);

                    $('#calltime').textbox('setValue', formattime(data.calltime));
                    if (data.clientname == "" || data.clientname == null) {
                        $('#clientname').textbox('setValue', data.callnumber);
                    } else {
                        $('#clientname').textbox('setValue', data.clientname);
                    }

                    var clientsex = data.clientsex;
                    if (clientsex == 0) {
                        clientsex = "男";
                    } else {
                        clientsex = "女";
                    }
                    $('#clientsex').textbox('setValue', clientsex);

                    var address = data.address;
                    if (address.length > 50) {
                        address = address.substring(0, 52);
                    }
                    $('#address').html(address);
                    var srcaddr = data.srcaddr;
                    if (srcaddr.length > 50) {
                        srcaddr = srcaddr.substring(0, 52);
                    }
                    $('#srcaddr').textbox('setValue', srcaddr);
                    $('#clientmobile').textbox('setValue', data.clientmobile);
                    $('#usecarde').textbox('setValue', data.usecarde);
                    $('#carbox').textbox('setValue', data.carbox);

                    if (data.carbox != undefined) {
                        orderreceivCar = data.carbox;
                    }

                    if (data.driver != undefined) {
                        $('#msid').textbox('setValue', data.driver.name);
                        drivermoile = data.driver.phone;
                        $('#drivermoli').textbox('setValue', data.driver.phone);
                        $('#company').textbox('setValue', data.driver.company);
                    }

                    $('#answerde').textbox('setValue', data.answerde);

                    $('#remark').textbox('setValue', data.remark);


                    var type = data.type;
                    if (type == 0) {
                        type = "实时";
                    } else {
                        type = "预约";
                    }
                    $('#type').textbox('setValue', type);

                    $('#evaluate').textbox('setValue', data.evaluate);

                    var status = data.status;
                    var evaluate = data.evaluate;
                    if (status != 4) {
                        evaluate = 0;
                    }

                    if (status == 4) {
                        $("#orderstatus").addClass("status-success");
                    } else {
                        $("#orderstatus").removeClass("status-success");
                    }
                    if (status >= 0 && status <= 5) {
                        status = getValueFromArray(status, ordstartus);
                    } else {
                        status = "";
                    }
                    $('#orderstatus').textbox('setValue', status);


                    $('#orderType').textbox('setValue', getValueFromArray(data.orderType, ordtype));

                    var list = "";
                    if (data.orderType == 3) {
                        ////console.info(data.remark);
                        $("#recordurl").attr("src", data.remark);
                        $("#recording").show();

                    }

                }

            }
        });
    }

    function E(selector) {
        return document.querySelector(selector);
    }


    //    E('#sample-amr > button').onclick = function () {
    //        fetchBlob(E('#sample-amr > a').href, function (blob) {
    //            playAmrBlob(blob);
    //        });
    //    };


    var gAudioContext = new AudioContext();

    function getAudioContext() {
        if (!gAudioContext) {
            gAudioContext = new AudioContext();
        }
        return gAudioContext;
    }

    function fetchBlob(url, callback) {
        var xhr = new XMLHttpRequest();
        xhr.open('GET', url);
        xhr.responseType = 'blob';
        xhr.onload = function () {
            callback(this.response);
        };
        xhr.onerror = function () {
            alert('Failed to fetch ' + url);
        };
        xhr.send();
    }

    function readBlob(blob, callback) {
        var reader = new FileReader();
        reader.onload = function (e) {
            var data = new Uint8Array(e.target.result);
            callback(data);
        };
        reader.readAsArrayBuffer(blob);
    }

    function fetchAndReadBlob(url, callback) {
        fetchBlob(url, function (blob) {
            readBlob(blob, callback);
        });
    }

    function playAmrBlob(blob, callback) {
        readBlob(blob, function (data) {
            playAmrArray(data);
        });
    }

    function convertAudioBlobToAmr(blob) {
        readBlob(blob, function (data) {
            var ctx = getAudioContext();
            ctx.decodeAudioData(data.buffer, function (audioBuffer) {
                var pcm;
                if (audioBuffer.copyFromChannel) {
                    pcm = new Float32Array(audioBuffer.length);
                    audioBuffer.copyFromChannel(pcm, 0, 0);
                } else {
                    pcm = audioBuffer.getChannelData(0);
                }
                var amr = AMR.encode(pcm, audioBuffer.sampleRate, 7);
                playAmrArray(amr);
            });
        });
    }

    function playAmrArray(array) {
        var samples = AMR.decode(array);
        if (!samples) {
            alert('Failed to decode!');
            return;
        }
        playPcm(samples);
    }

    function playPcm(samples) {
        var ctx = getAudioContext();
        var src = ctx.createBufferSource();
        var buffer = ctx.createBuffer(1, samples.length, 8000);
        if (buffer.copyToChannel) {
            buffer.copyToChannel(samples, 0, 0)
        } else {
            var channelBuffer = buffer.getChannelData(0);
            channelBuffer.set(samples);
        }

        src.buffer = buffer;
        src.connect(ctx.destination);
        src.start();
    }

    function convertAmrBlobToWav(blob) {
        readBlob(blob, function (data) {
            var buffer = AMR.toWAV(data);
            E('pre').textContent = toHex(buffer);
            var url = URL.createObjectURL(new Blob([buffer], {type: 'audio/x-wav'}));
            // Play wav buffer
            var audio = new Audio(url);
            audio.onloadedmetadata = audio.onerror = function () {
                URL.revokeObjectURL(url);
            };
            audio.play();
        });
    }

    function toHex(buffer) {
        var str = '';
        for (var i = 0; i < buffer.length; i++) {
            var s = buffer[i].toString(16);
            if (s.length == 1) {
                s = '0' + s;
            }
            str += s;
            if (i % 16 == 15) { // print 16 bytes per line
                str += '\n'
            } else if (i % 2 == 1) { // add a space seperator every two bytes.
                str += ' ';
            }
        }
        return str;
    }
</script>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>视频用例</title>
    <link href="button.css" type="text/css" rel="stylesheet">
    <link href="video.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="jquery.min.js"></script>
    <script type="text/javascript" src="jquery.query-2.1.7.js"></script>
    <%--<script type="text/javascript" src="http://120.26.98.110/js/lhgdialog.min.js"></script>--%>
    <script src="http://120.26.98.110/808gps/open/player/swfobject.js"></script>

    <script>
        //设置服务器信息
        var videoaddress = "120.26.98.110";   //服务器
        var serverIp = "120.26.98.110";    //服务器
        var serverPort = 6605;             //服务器端口
        var liveChannel = 0;               // 通道
        var liveJsession = "";
        var monitorJsession = "";
        var talkbackJsession = "";
        var isInitFinished = false;//视频插件是否加载完成
        var lang = new langZhCn();

        function langZhCn() {
            this.videoExample = "视频用例";
            this.geSessionId = "获取会话号";
            this.userId = "用户名：";
            this.password = "密码：";
            this.login = "登陆";
            this.videoInit = "初始化";
            this.videoLang = "插件语言：";
            this.videoWidth = "插件宽度：";
            this.videoHeight = "插件高度：";
            this.serverIp = "服务器IP：";
            this.serverPort = "端口：";
            this.windowNumber = "窗口数目：";
            this.settings = "设置";
            this.videoLive = "实时视频";
            this.windowIndex = "窗口下标：";
            this.title = "标题：";
            this.jsession = "会话号：";
            this.stream = "码流：";
            this.devIdno = "设备号：";
            this.channel = "通道：";
            this.play = "播放";
            this.stop = "停止";
            this.reset = "重置";
            this.monitor = "监听";
            this.talkback = "对讲";
            this.url = "url链接：";
            this.playback = "远程回放";
            this.nullMic = "您的电脑上没有麦克风，无法启动对讲";
            this.micStop = "没有开启FLASH插件麦克风";
            this.loginError = "登陆失败";
            this.talkback_flashMicStep1 = "第一步，请在视频窗上右键菜单中选择设置";
            this.talkback_flashMicStep2 = "第二步在设置窗口中 选择 “允许”，并勾选“记住”";
            this.talkback_flashMicStep3 = "关闭设置，并重新启动对讲";
            this.bufferTimeDesc = "说明：主要用于调整视频延时，当缓存的数据达到了最小缓冲时长时（默认为2秒），则会进行播放，当到了最大缓冲时长（默认为6秒），则进行快放。";
            this.minBufferTime = "最小缓冲时长：";
            this.maxBufferTime = "最大缓冲时长：";
            this.vedioStatus = "选中窗口播放状态";
            this.vedioEventStart = '选中事件：选中第';
            this.vedioEventEnd = '个窗口';
            this.vedioPlay = "当前选中窗口正在进行视频播放";
            this.vedioNoPlay = "当前选中窗口未进行视频播放";


        }


        $(document).ready(function () {

            //登录注册
            userLogin('dq', '000000');

            //初始化视频插件
            initPlayerExample();
        });

        /**
         * 初始化视频插件
         **/
        function initPlayerExample() {
            for (var i = 0; i < 101; i++) {
                playingStatusArray.push(false);
            }
            //视频参数
            var params = {
                allowFullscreen: "true",
                allowScriptAccess: "always",
                bgcolor: "#FFFFFF",
                wmode: "transparent"
            };
            //赋值初始化为未完成
            isInitFinished = false;
            //视频插件宽度
            var width = 400;

            //视频插件高度
            var hieght = 400;

            //初始化flash
            swfobject.embedSWF("player.swf", "cmsv6flash", width, hieght, "11.0.0", null, null, params, null);
            initFlash();
        }

        /**
         * 插件初始化完成后执行
         **/
        function initFlash() {
            if (swfobject.getObjectById("cmsv6flash") == null ||
                typeof swfobject.getObjectById("cmsv6flash").setWindowNum == "undefined") {
                setTimeout(initFlash, 50);
            } else {
                //初始化插件语言
                var language = "cn";

                swfobject.getObjectById("cmsv6flash").setLanguage(language);
                //先将全部窗口创建好
                swfobject.getObjectById("cmsv6flash").setWindowNum(36);
                //再配置当前的窗口数目
                var windowNum = 1;

                swfobject.getObjectById("cmsv6flash").setWindowNum(windowNum);
                //设置服务器信息
//              var serverIp = $.trim($('#serverIp').val());
//
//              var serverPort = $.trim($('#serverPort').val());

                swfobject.getObjectById("cmsv6flash").setServerInfo(serverIp, serverPort);
                isInitFinished = true;
            }
        }

        /**
         * 设置视频插件窗口数量
         **/
        function setVideoWindowNumber() {
            if (!isInitFinished) {
                return;
            } else {
                //窗口数目
                var windowNum = $.trim($('.windowNumber').val());
                if (windowNum == '') {
                    $('.windowNumber').focus();
                    return;
                }
                swfobject.getObjectById("cmsv6flash").setWindowNum(windowNum);
            }
        }

        /**
         * 设置视频插件服务器信息
         **/
        function setVideoServer() {
            if (!isInitFinished) {
                return;
            } else {
                //服务器信息
                var serverIp = $.trim($('#serverIp').val());
                if (!serverIp) {
                    $('#serverIp').focus();
                    return;
                }
                var serverPort = $.trim($('#serverPort').val());
                if (!serverPort) {
                    $('#serverPort').focus();
                    return;
                }
                swfobject.getObjectById("cmsv6flash").setServerInfo(serverIp, serverPort);
            }
        }

        /**
         * 设置视频插件语言
         **/
        function setVideoLanguage() {
            if (!isInitFinished) {
                return;
            } else {
                //语言文件
                var language = $.trim($('.languagePath').val());
                if (!language) {
                    $('.languagePath').focus();
                    return;
                }
                swfobject.getObjectById("cmsv6flash").setLanguage("file/" + language);
            }
        }

        /**
         * 设置窗口标题
         **/
        function setWindowTitle() {
            if (!isInitFinished) {
                return;
            } else {
                //窗口下标
                var index = 0;
                //标题
                var title = $.trim($('.liveWindowTitle').val());
                swfobject.getObjectById("cmsv6flash").setVideoInfo(index, title);
            }
        }

        //播放实时视频
        function playLiveVideo() {
            if (!isInitFinished) {
                return;
            }
            //窗口下标
            var index = 0;
            //jsession会话号
            var jsession = liveJsession;
            if (jsession == '') {
                alert("jsession会话号错误")
                return;
            }

            //设备号
            var devIdno = "111001";

            //通道号
            var channel = liveChannel;

            //码流
            var stream = 1;

            //最小缓冲时长
            var minBufferTime = 2;
            if (minBufferTime != '') {
                swfobject.getObjectById("cmsv6flash").setBufferTime(index, minBufferTime);
            }
            //最大缓冲时长
            var maxBufferTime = 6;
            if (maxBufferTime != '') {
                swfobject.getObjectById("cmsv6flash").setBufferTimeMax(index, maxBufferTime);
            }

            //先停止视频窗口
            swfobject.getObjectById("cmsv6flash").stopVideo(index);

            //设置窗口标题
            var title = "cbx-test";

            swfobject.getObjectById("cmsv6flash").setVideoInfo(index, title);
            //播放视频
            swfobject.getObjectById("cmsv6flash").startVideo(index, jsession, devIdno, channel, stream, true);
        }

        /**
         * 停止视频窗口播放视频窗口
         **/
        function stopLiveVideo() {
            if (!isInitFinished) {
                return;
            } else {
                //窗口下标
                var index = $.trim($('.liveVideoIndex').val());
                if (index == '') {
                    $('.liveVideoIndex').focus();
                    return;
                }
                swfobject.getObjectById("cmsv6flash").stopVideo(index);
            }
        }

        /**
         * 重置实时视频窗口
         **/
        function reSetLiveVideo() {
            if (!isInitFinished) {
                return;
            } else {
                //窗口下标
                var index = $.trim($('.liveVideoIndex').val());
                if (index == '') {
                    $('.liveVideoIndex').focus();
                    return;
                }
                swfobject.getObjectById("cmsv6flash").reSetVideo(index);
            }
        }

        /**
         * 开始监听
         **/
        function startMonitor() {
            if (!isInitFinished) {
                return;
            } else {
                //会话号
                var jsession = $.trim($('.monitorJsession').val());
                if (jsession == '') {
                    $('.monitorJsession').focus();
                    return;
                }
                //设备号
                var devIdno = $.trim($('.monitorDevIdno').val());
                if (devIdno == '') {
                    $('.monitorDevIdno').focus();
                    return;
                }
                //通道号
                var channel = $.trim($('.monitorChannel').val());
                if (channel == '') {
                    $('.monitorChannel').focus();
                    return;
                }
                //服务器ip
                var ip = $.trim($('.monitorServerIp').val());
                if (ip == '') {
                    $('.liveStream').focus();
                    return;
                }
                //服务器端口
                var port = $.trim($('.monitorServerPort').val());
                if (port == '') {
                    $('.monitorServerPort').focus();
                    return;
                }

                swfobject.getObjectById("cmsv6flash").setListenParam(1);
                swfobject.getObjectById("cmsv6flash").startListen(jsession, devIdno, channel, ip, port);
            }
        }

        /**
         * 停止监听
         **/
        function stopMonitor() {
            if (!isInitFinished) {
                return;
            } else {
                swfobject.getObjectById("cmsv6flash").stopListen();
            }
        }

        /**
         * 开始对讲
         **/
        function startTalkback() {
            if (!isInitFinished) {
                return;
            } else {
                //会话号
                var jsession = $.trim($('.talkbackJsession').val());
                if (jsession == '') {
                    $('.talkbackJsession').focus();
                    return;
                }
                //设备号
                var devIdno = $.trim($('.talkbackDevIdno').val());
                if (devIdno == '') {
                    $('.talkbackDevIdno').focus();
                    return;
                }
                //服务器ip
                var ip = $.trim($('.talkbackServerIp').val());
                if (ip == '') {
                    $('.talkbackStream').focus();
                    return;
                }
                //服务器端口
                var port = $.trim($('.talkbackServerPort').val());
                if (port == '') {
                    $('.talkbackServerPort').focus();
                    return;
                }

                swfobject.getObjectById("cmsv6flash").setTalkParam(1);
                var ret = swfobject.getObjectById("cmsv6flash").startTalkback(jsession, devIdno, 0, ip, port);
                //返回 0成功，1表示正在对讲，2表示没有mic，3表示禁用了mic
                if (ret == 0) {
                } else if (ret == 1) {
                } else if (ret == 2) {
                    alert(lang.nullMic);
                } else if (ret == 3) {
                    //alert(lang.micStop);
                    $.dialog({
                        id: 'talkbacktip',
                        title: lang.talkback_openMic,
                        content: 'url:talkbacktipSP.html',
                        min: false,
                        max: false,
                        lock: true
                        ,
                        autoSize: true
                    });
                } else {
                }
            }
        }

        /**
         * 停止对讲
         **/
        function stopTalkback() {
            if (!isInitFinished) {
                return;
            } else {
                swfobject.getObjectById("cmsv6flash").stopTalkback();
            }
        }

        /**
         * 开始远程回放
         **/
        function startPlayback() {
            if (!isInitFinished) {
                return;
            } else {
                //窗口下标
                var index = $.trim($('.playbackVideoIndex').val());
                if (index == '') {
                    $('.playbackVideoIndex').focus();
                    return;
                }
                //回放url
                var url = $.trim($('.playbackUrl').val());
                if (url == '') {
                    $('.playbackUrl').focus();
                    return;
                }
                //回放之前先停止
                swfobject.getObjectById('cmsv6flash').stopVideo(index);
                //开始回放
                swfobject.getObjectById("cmsv6flash").startVod(index, url);
            }
        }

        /**
         * 停止远程回放
         **/
        function stopPlayback() {
            if (!isInitFinished) {
                return;
            } else {
                //窗口下标
                var index = $.trim($('.playbackVideoIndex').val());
                if (index == '') {
                    $('.playbackVideoIndex').focus();
                    return;
                }
                swfobject.getObjectById("cmsv6flash").stopVideo(index);
            }
        }

        /**
         * 用户登录
         **/
        function userLogin(account, password) {
            //用户名
            if (account == '') {
                alert("用户为空")
                return;
            }
            //密码
            if (password == '') {
                alert("密码为空")
                return;
            }
            var param = [];
            param.push({name: 'account', value: account});
            param.push({name: 'password', value: password});

            $.ajax({
                type: 'POST',
                url: 'http://' + videoaddress + '/StandardApiAction_login.action',
                data: param,
                cache: false, /*禁用浏览器缓存*/
                dataType: 'json',
                success: function (data) {
                    if (data.result == 0) {
                        liveJsession = data.jsession
                        monitorJsession = data.jsession
                        talkbackJsession = data.jsession

                    } else {
                        alert(lang.loginError);
                    }
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    try {
                        if (p.onError) p.onError(XMLHttpRequest, textStatus, errorThrown);
                    } catch (e) {
                    }
                    alert(lang.loginError);
                }
            });
        }

        /**
         * 设置缓冲时长
         **/
        function setBufferInfo() {
            if (!isInitFinished) {
                return;
            } else {
                //窗口下标
                var index = $.trim($('.liveVideoIndex').val());
                if (index == '') {
                    $('.liveVideoIndex').focus();
                    return;
                }
                //最小缓冲时长
                var minBufferTime = $.trim($('.minBufferTime').val());
                //最大缓冲时长
                var maxBufferTime = $.trim($('.maxBufferTime').val());
                if (minBufferTime == '' && maxBufferTime == '') {
                    return;
                }
                if (maxBufferTime != '') {
                    swfobject.getObjectById("cmsv6flash").setBufferTimeMax(index, maxBufferTime);
                }
                if (minBufferTime != '') {
                    swfobject.getObjectById("cmsv6flash").setBufferTime(index, minBufferTime);
                }
            }
        }


        function onTtxVideoMsg(index, type) {
            if (index != null && index != "") {
                index = parseInt(index, 10);
            }
            //窗口事件
            //window message
            if (type == "select") {
                //选中窗口     		select window
                selectIndex = index;
                $('#eventTip').text(lang.vedioEventStart + (index + 1) + lang.vedioEventEnd);
            } else if (type == "full") {
                //全屏			Full screen
            } else if (type == "norm") {
                //退出全屏			Exit full screen
            }
            //视频播放事件
            //video play messsage
            else if (type == "stop") {
                //停止播放			stop playing
                playingStatusArray[index] = false;
            } else if (type == "start") {
                //开始播放			Start play
                playingStatusArray[index] = true;
            } else if (type == "sound") {
                //开启声音			Turn on the sound
            } else if (type == "silent") {
                //静音			Mute
            } else if (type == "play") {
                //暂停或停止后重新播放			Play again after pause or stop
            } else if (type == "PicSave") {
                //截图			screenshot
            }
            //对讲事件
            //Intercom messsage
            else if (type == "startRecive" || type == "uploadRecive" || type == "loadRecive") {
                //开启对讲			Open intercom
            } else if (type == "stopTalk") {
                //关闭对讲			Turn off intercom
            } else if (type == "playRecive") {
                //对讲中			Talkback
            } else if (type == "reciveStreamStop" || type == "reciveNetError" || type == "reciveStreamNotFound") {
                //对讲异常(网络异常等)			Talkback anomalies (network exceptions, etc.)

            } else if (type == "uploadNetClosed" || type == "uploadNetError") {
                //连接异常 			Connection exception
            } else if (type == "upload") {
                //对讲讲话			Talkback speech
            } else if (type == "uploadfull") {
                //对讲讲话结束		Talkback speech ends
            }
            //监听事件
            //Listen messsage
            else if (type == "startListen") {
                //开始监听      		Start listening
            } else if (type == "stopListen") {
                //主动停止监听 		Active stop monitoring

            } else if (type == "listenNetError") {
                //网络异常  			Network anomaly

            } else if (type == "playListen") {
                //监听中	  		In listening
            } else if (type == "loadListen" || type == "listenStreamNotFound" || type == "listenStreamStop") {
                //等待请求监听	   	Waiting request monitoring
            }
        }


        var selectIndex = 0;
        var playingStatusArray = [];

        //判断当前选择窗口是否播放状态
        function checkIsPlaying() {
            if (playingStatusArray[selectIndex]) {
                alert(lang.vedioPlay);
            } else {
                alert(lang.vedioNoPlay);
            }
        }

    </script>
</head>
<body>
<div id="flashExample">
    <div id="cmsv6flash"></div>

</div>

</body>
</html>
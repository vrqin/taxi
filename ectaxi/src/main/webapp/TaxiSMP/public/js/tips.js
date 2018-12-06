// JavaScript Document 当浏览器是IE6、7、8、9出现提示
window.attachEvent("onload", function () {
    var bodyElement = document.getElementsByTagName("body")[0];
    var div = document.createElement("div");
    var p = document.createElement("p");
    var documentElement = document.documentElement;
    bodyElement.appendChild(div);
    div.id = "tips";
    div.appendChild(p);
    p.innerHTML =
        '<button id="close" title="点击关闭">x</button>' +
        '<a href="http://rj.baidu.com/soft/detail/14744.html?ald">前往下载</a>' +
        '<a href="http://rj.baidu.com/soft/detail/11843.html?ald">前往下载</a>' +
        '<a href="http://rj.baidu.com/soft/detail/14754.html?ald">前往下载</a>' +
        '<a href="http://rj.baidu.com/soft/detail/17451.html">前往下载</a>';
    var windowWidth = documentElement.clientWidth;
    var windowHeight = documentElement.clientHeight;
    div.style.display = "block";
    div.style.height = windowHeight;
    p.style.top = (windowHeight - 338) / 2 + 'px';
    p.style.left = (windowWidth - 408) / 2 + 'px';
    documentElement.style.overflow = "hidden";
    document.getElementById("close").onclick = function () {
        div.style.display = "none";
        documentElement.style.overflow = "auto";
    };
});
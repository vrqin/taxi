/**
 * Created by Administrator on 2016/11/12.
 */
var ua = navigator.userAgent.toLowerCase();

function check(r) {
    return r.test(ua);
}

/**
  * return IE,IE6,IE7,IE8,IE9,Chrome,Firefox,Opera,WebKit,Safari,Others
 */
function getBrowserName() {
    var browserName;
    var isOpera = check(/opera/);
    var isChrome = check(/chrome/);
    var isFirefox = check(/firefox/);
    var isWebKit = check(/webkit/);
    var isSafari = !isChrome && check(/safari/);
    var isIE = !isOpera && check(/msie/);
    var isIE7 = isIE && check(/msie 7/);
    var isIE8 = isIE && check(/msie 8/);
    if (isIE8) {
        browserName = "IE8";
    } else if (isIE7) {
        browserName = "IE7";
    } else if (isIE) {
        browserName = "IE";
    } else if (isChrome) {
        browserName = "Chrome";
    } else if (isFirefox) {
        browserName = "Firefox";
    } else if (isOpera) {
        browserName = "Opera";
    } else if (isWebKit) {
        browserName = "WebKit";
    } else if (isSafari) {
        browserName = "Safari";
    } else {
        browserName = "Others";
    }
    return browserName;
}
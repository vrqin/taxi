/**
 * Created by CLOUD on 2014/4/14.
 */
var phm = phm || {};

/**
 * 去字符串空格
 *
 */
phm.trim = function (str) {
    return str.replace(/(^\s*)|(\s*$)/g, '');
};
phm.ltrim = function (str) {
    return str.replace(/(^\s*)/g, '');
};
phm.rtrim = function (str) {
    return str.replace(/(\s*$)/g, '');
};

/**
 * 判断开始字符是否是XX
 *
 */
phm.startWith = function (source, str) {
    var reg = new RegExp("^" + str);
    return reg.test(source);
};
/**
 * 判断结束字符是否是XX
 *
 */
phm.endWith = function (source, str) {
    var reg = new RegExp(str + "$");
    return reg.test(source);
};

/**
 * iframe自适应高度
 * @param iframe
 */
phm.autoIframeHeight = function (iframe) {
    iframe.style.height = iframe.contentWindow.document.body.scrollHeight + "px";
};

/**
 * 设置iframe高度
 * @param iframe
 */
phm.setIframeHeight = function (iframe, height) {
    iframe.height = height;
};
phm.formatString = function (str) {
    for (var i = 0; i < arguments.length - 1; i++) {
        str = str.replace("{" + i + "}", arguments[i + 1]);
    }
    return str;
};
/**
 * 创建一个模式化的dialog
 *
 * @requires jQuery,EasyUI
 *
 */
phm.modalDialog = function (options) {
    var opts = $.extend({
        title: '&nbsp;',
        width: 640,
        height: 480,
        modal: true,
        onClose: function () {
            $(this).dialog('destroy');
        }
    }, options);
    opts.modal = true;// 强制此dialog为模式化，无视传递过来的modal参数
    if (options.url) {
        opts.content = '<iframe id="" src="' +  options.url + '" allowTransparency="true" scrolling="auto" width="100%" height="98%" frameBorder="0" name=""></iframe>';
    }
    return $('<div/>').dialog(opts);
};

/**
 * 将form表单元素的值序列化成对象
 *
 * @example phm.serializeObject($('#formId'))
 *
 * @requires jQuery
 *
 * @returns object
 */
phm.serializeObject = function (form) {
    var o = {};
    $.each(form.serializeArray(), function (index) {
        if (this['value'] != undefined && this['value'].length > 0) {// 如果表单项的值非空，才进行序列化操作
            if (o[this['name']]) {
                o[this['name']] = o[this['name']] + "," + this['value'];
            } else {
                o[this['name']] = this['value'];
            }
        }
    });
    return o;
};
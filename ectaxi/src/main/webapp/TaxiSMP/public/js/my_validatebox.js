// JavaScript Document 当浏览器是IE6、7、8、9出现提示
//textbox 校验

$.extend($.fn.textbox.defaults.rules, {

    //车牌号码的校验
    carNameCheck: {
        validator: function (value, param) {
            var reg = /^[\u4e00-\u9fa5]{1}[A-Z]{1}[A-Z0-9]{3,5}$/;
            return reg.test(value);
        },
        message: "车牌格式不正确"
    },
    NumberorChar: {
        validator: function (value, param) {
            var reg = /^(\w)+$/;
            return reg.test(value);
        },
        message: "只能输入数字或字母"
    },
    specialCharacter: {
        validator: function (value, param) {
            var reg = new RegExp("[`~!@#$^&*()=|{}':;'\\[\\]<>~！@#￥……&*（）——|{}【】‘；：”“'、？]");
            return !reg.test(value);
        },
        message: '不允许输入特殊字符'
    },
    checkKabnum: {
        validator: function (value, param) {

            var flag = false;
            if (value != null && value != "") {
                $.ajax({
                    url: path + "/carinfo/checkKabnum?kabnum=" + value,
                    dataType: 'json',
                    type: 'POST',
                    async: false,
                    success: function (data) {
                        data.code == 0 ? flag = true : flag;
                    }
                });
                return flag;
            }

        },
        message: "车牌已存在"
    },

    checkIDCard: {
        validator: function (value, param) {

            console.log(value);
            var Validator = new IDValidator();
            var flag = Validator.isValid(value);
            return flag;

        },
        message: "身份号码格式错误"
    },

    checkPhoneNum: {
        validator: function (value, param) {
            var reg = /(^0{0,1}1[3|4|5|6|7|8|9][0-9]{9}$)/;
            console.log(value)
            return reg.test(value);

        },
        message: "手机格式错误"
    },
//司机用户是否存在
    checkDriverAccount: {
        validator: function (value, param) {
            var flag = false;
            if (value != null && value != "") {
                $.ajax({
                    url: path + "/driver/checkDriverName?account=" + value,
                    dataType: 'json',
                    type: 'POST',
                    async: false,
                    success: function (data) {
                        data.code == 0 ? flag = true : flag;
                    }
                });
                return flag;
            }

        },
        message: "用户已存在"
    },
    //司机电话号码是否存在
    checkDriverAccountPhone: {
        validator: function (value, param) {
            var flag = false;
            if (value != null && value != "") {
                $.ajax({
                    url: path + "/driver/checkDriverPhone?phone=" + value,
                    dataType: 'json',
                    type: 'POST',
                    async: false,
                    success: function (data) {
                        data.code == 0 ? flag = true : flag;
                    }
                });
                return flag;
            }

        },
        message: "电话号码已经存在"
    },

    //YYYY 年份校验
    checkYYYY: {
        validator: function (value, param) {
            var reg = /^(\d{4})$/;
            return reg.test(value);

        },
        message: "年份格式不正确 例：2016"
    },


});

//传入一个 获取表单的值

//传入一个 easyui form 表单 对象 自动校验
function isValidate(obj) {
    return obj.form('validate')
}



function mycombobox(obj, code) {
    obj.combobox({
        url: path + '/typevalue/findTypevalueBykey?code=' + code,
        method: 'GET',
        valueField: 'id',
        textField: 'text',
        onLoadSuccess: function (data) {
            //console.info(data);
        }
    });
}

//日期格式
Date.prototype.format = function (f) {
    var o = {
        "M+": this.getMonth() + 1, //month
        "d+": this.getDate(),    //day
        "h+": this.getHours(),   //hour
        "m+": this.getMinutes(), //minute
        "s+": this.getSeconds(), //second
        "q+": Math.floor((this.getMonth() + 3) / 3),  //quarter
        "S": this.getMilliseconds() //millisecond
    }
    if (/(y+)/.test(f)) f = f.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(f)) f = f.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
    return f
}

// //转换类型 array不能超过10个
// function typeFomart(i,array){
//
// 	return array[i%10];
// }
var mileageConetent = ["1万公里内", "2万公里内", "3万公里内"];
var displacementContent = ["1.0L以下", "1.0-1.6L", "1.6-2.0L", "2.0-3.0L", "3.0L以上"];
var modelsContent = ["两厢轿车", "三厢轿车", "跑车", "SUV", "MPV"];

function intTypeConversions(i, array) {
    if (i.toString().substring(3, 4) != 0) {
        return array[parseInt(i.toString().substring(3, 5))];
    }
    return array[parseInt(i.toString().substring(4, 5)) - 1];
}

function StringTypeConversions(code, array, value) {
    for (var i = 0; i < array.length; i++) {
        if (value == array[i]) {
            return code + i + 1;
        }
    }
    return value;
}


//里程转换
// function mileageFormat(value){
// 	var i = value;
// 	alert(i.toString().substring(4,5));
// 	return i==20001?'1万公里内':i==20002?'2万公里内':i==20003?'3万公里内':value;
// }


// function formatMileage(value){
// 	return value=="1万公里内"?20001:value=="2万公里内"?20002:value=="3万公里内"?20003:value;
// }
//排量转换
// function displacementFormat(value){
// 	var i = value;
// 	return i==30001?'1.0L以下':i==30002?'1.0-1.6L':i==30003?'1.6-2.0L':i==30004?'2.0-3.0L':i==30005?'3.0L以上':value;
// }
// function formatDisplacement(value){
// 	var i =value;
// 	return i=="1.0L以下"?30001:i=="1.0-1.6L"?30002:i=="1.6-2.0L"?30003:i=="2.0-3.0L"?30004:i=="3.0L以上"?30005:value;
// }
// //车型转换
// function modelsFormat(value){
// 	var i = value;
// 	return i==10001?'两厢轿车':i==10002?'三厢轿车':i==10003?'跑车':i==10004?'SUV':i==10005?'MPV':value;
// }
// function formatModels(value){
// 	return value=="两厢轿车"?10001:value=="三厢轿车"?10002:value=="跑车"?10003:value=="SUV"?10004:value=="MPV"?10005:value;
// }
//考评验证 0已 1未
function evaluationtypeFormat(value) {
    return value ? "未考评" : "已考评";
}

function formatEvaluationtype(value) {
    return value == "已考评" || value == 70002 ? 0 : 1;
}

//等级验证 0A 1B 2C
function evaluationlevelFormat(value) {
    return value == 2 || value == 60003 ? "C" : value || value == 60002 ? "B" : !value || value == 60001 ? "A" : value;
}

function formatEvaluationlevel(value) {
    return value == "C" || value == 60003 ? 2 : value == "B" || value == 60002 ? 1 : value == "A" || value == 60001 ? 0 : value;
}
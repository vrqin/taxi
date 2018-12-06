// JavaScript Document
$(document).ready(function () {

    (function () {
        var control = navigator.control || {};
        if (control.gesture) {
            control.gesture(false);
        }
    })();

    if ('ontouchstart' in window) {

        //移动端导航栏点击事件
        $("nav a").on('touchend', function () {
            if (!window.eventStatus) {
                $(this).addClass("active").siblings().removeClass("active");
            } else {
                window.eventStatus = false;
            }
        });

        //移动端导航栏滑动
        $("nav").on('touchstart', function (event) {
            var navPositionLeft = $(this).position().left;
            var navTouchStartLeft = event.originalEvent.targetTouches[0].pageX;
            var touchDistance = navTouchStartLeft - navPositionLeft;
            var navMovePositionLeft;
            $(this).on('touchmove', function (event) {
                window.eventStatus = true;
                var navTouchMoveLeft = event.originalEvent.targetTouches[0].pageX;
                navMovePositionLeft = navTouchMoveLeft - touchDistance;
                $(this).css("left", navMovePositionLeft);
            });
            $(this).on('touchend', function () {
                if (navMovePositionLeft > 0 || window.innerWidth >= 840) {
                    $(this).css("left", 0);
                } else if (navMovePositionLeft < (window.innerWidth - 840)) {
                    $(this).css("left", (window.innerWidth - 840));
                }
                $(this).off('touchmove').off('touchend');
            });
        });

    } else {

        //PC端导航栏点击事件
        $("nav a").on('click', function () {
            $(this).addClass("active").siblings().removeClass("active");
        });

        //PC端导航栏鼠标移入移出事件
        function navMouse() {
            if (window.innerWidth > 1024) {
                $("nav").off("mouseover").off("mouseout");
                $("nav").children('a').css("width", "100%");
                $("nav").on('mouseover', function () {
                    $(this).css("overflow", "auto").children('a').css("width", "auto");
                });
                $("nav").on('mouseout', function () {
                    $(this).css("overflow", "hidden").children('a').css("width", "100%");
                });
            } else {
                $("nav").off("mouseover").off("mouseout");
                $("nav").children('a').css("width", 120);
            }
        }

        navMouse();
        $(window).resize(navMouse);

    }
    /* if('ontouchstart' in window){}else{} 结束 */

    //设置article标签高度
    setArticleHeight();

    function setArticleHeight() {
        if (window.innerWidth > 1024) {
            window.subtractArticleTop = $('header').outerHeight();
        } else {
            window.subtractArticleTop = $('header').outerHeight() + $('nav').outerHeight();
        }
        $('article').css("height", window.innerHeight - window.subtractArticleTop);
    }

    $(window).resize(setArticleHeight);

});
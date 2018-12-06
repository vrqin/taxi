// JavaScript Document index页面设置二级菜单代码
// 如果想看懂这里的代码，请将最后面的一段代码注释恢复原来状态
$(document).ready(function () {

    /*
    **获取导航栏在左边时的高度
    */
    var NavLeftHeight = window.innerHeight - $('header').height();

    /*
    **设置嵌入网页的高度
    */
    $('article')[0].style.height = NavLeftHeight + 'px';

    /*
    **声明
    */
    var navPosition = 'auto',	//用于断判当前位置，auto为自动隐藏，left为左边，right为右边，top为顶部，bottom为底部
        status = true, 			//用于点击label时禁止执行2次代码
        selectMenu,				//储存一级菜单点击时记录data-menu的值，也就是对应二级菜单的ID
        menuId,					//储存二级菜单ID
        iframeSrc;				//储存当前点击的网页名称

    /*
    **设置指定ID的区块为显示，同级兄弟区块为隐藏
    */
    function secondMenuShow(selectMenu) {
        $('#' + selectMenu).css('display', 'block').siblings().css('display', 'none');
    }

    /*
    **设置导航栏CSS样式
    */
    function navClass(addClass, addClass2, display, height) {
        if (arguments[1] === null && arguments.length === 3) {
            $('nav').removeClass().addClass(addClass).css({'display': display, 'height': height});
        } else if (arguments.length === 4) {
            $('nav').removeClass().addClass(addClass).addClass(addClass2).css({'display': display, 'height': height});
        }
    }

    /*
    **判断二级菜单ID是否为null；设置导航栏，嵌入网页CSS样式
    */
    function setArticle(subHeight, marginLeft, marginRight) {
        if (menuId === null) {
            $('nav').css('display', 'none');
            $('article').css({'height': NavLeftHeight, 'margin': 0});
        } else {
            $('article').css({
                'height': NavLeftHeight - subHeight,
                'margin-left': marginLeft,
                'margin-right': marginRight
            });
            secondMenuShow(selectMenu);
        }
    }

    /*
    **设置嵌入网页CSS样式
    */
    function articleCss(subHeight, marginLeft, marginRight) {
        $('article').css({'height': NavLeftHeight - subHeight, 'margin-left': marginLeft, 'margin-right': marginRight});
    }

    /*
    **点击“设置”选项，设置导航栏的位置，嵌入网页大小
    */
    $('#setSelect ul li label').on('click', function () {
        if (status) {
            selectMenu = $('li.firstMenuLiActive').data('menu');
            navPosition = $(this).children('input')[0].id;
            if (navPosition === 'auto') {
                navClass('horizontal', null, 'none', 90);
                $('article').css({'height': NavLeftHeight, 'margin': 0});
            } else if (navPosition === 'left') {
                navClass('vertical', null, 'block', NavLeftHeight);
                setArticle(0, 120, 0);
            } else if (navPosition === 'right') {
                navClass('vertical', 'floatRight', 'block', NavLeftHeight);
                setArticle(0, 0, 120);
            } else if (navPosition === 'top') {
                navClass('horizontal', 'removePosition', 'block', 90);
                setArticle(90, 0, 0);
            } else if (navPosition === 'bottom') {
                navClass('horizontal', 'positionBottom', 'block', 90);
                setArticle(90, 0, 0);
            }
            status = false;
        } else {
            status = true;
        }
    });

    /*
    **头部点击事件(一级菜单)
    */
    $('li.firstMenuLi').on('click', function () {
        $(this).addClass('firstMenuLiActive').siblings().removeClass('firstMenuLiActive');
        $('li.secondMenuLi').removeClass('secondMenuLiActive');
        menuId = $(this).data('menu');
        if (menuId !== null) {
            secondMenuShow(menuId);
            iframeSrc = $('#' + menuId).children('li').eq(0).addClass('secondMenuLiActive').children('a')[0].href;
            $('#iframe')[0].src = iframeSrc;
            if (navPosition !== 'auto') {
                $('nav').css('display', 'block');
            }
            if (navPosition === 'left') {
                articleCss(0, 120, 0);
            } else if (navPosition === 'right') {
                articleCss(0, 0, 120);
            } else if (navPosition === 'top') {
                articleCss(90, 0, 0);
            } else if (navPosition === 'bottom') {
                articleCss(90, 0, 0);
            }
        } else {
            $('nav').css('display', 'none');
            articleCss(0, 0, 0);
        }
    });

    /*
    **导航栏点击事件(二级菜单)
    */
    $('li.secondMenuLi').on('click', function () {
        $('li.secondMenuLi').removeClass('secondMenuLiActive');
        $(this).addClass('secondMenuLiActive');
        if (navPosition === 'auto') {
            menuId = $(this).parent()[0].id;
            for (var i = 0; i < $('li.firstMenuLi').length; i++) {
                if ($('li.firstMenuLi').eq(i).data('menu') === menuId) {
                    $('li.firstMenuLi').eq(i).addClass('firstMenuLiActive');
                } else {
                    $('li.firstMenuLi').eq(i).removeClass('firstMenuLiActive');
                }
            }
        }
    });

    /*
    **头部鼠标移入移出事件 并且 鼠标进入导航菜单
    */
    var navStop;
    $('li.firstMenuLi').on('mouseover', function () {
        menuId = $(this).data('menu');
        if (menuId !== null && navPosition === 'auto') {
            $(this).addClass('firstMenuLiHover').siblings().removeClass('firstMenuLiHover');
            window.clearTimeout(navStop);
            $('#' + menuId).css('display', 'block').siblings().css('display', 'none');
            if (navPosition === 'auto') {
                $('nav').slideDown(200);
            }
        }
    });

    $('li.firstMenuLi').on('mouseout', function () {
        navStop = window.setTimeout(function () {
            if (navPosition === 'auto') {
                $('nav').slideUp(200);
            }
            $('li.firstMenuLi').removeClass('firstMenuLiHover');
        }, 200);
    });

    $('ul.secondMenu').on('mouseover', function () {
        window.clearTimeout(navStop);
    });

    $('ul.secondMenu').on('mouseout', function () {
        navStop = window.setTimeout(function () {
            if (navPosition === 'auto') {
                $('nav').slideUp(200);
            }
            $('li.firstMenuLi').removeClass('firstMenuLiHover');
        }, 200);
    });

    /*
    **设置按钮hover事件
    */
    var setStop;
    $('#setting').on('mouseover', function () {
        window.clearTimeout(setStop);
        $('#setSelect').slideDown(200);
    });
    $('#setting').on('mouseout', function () {
        setStop = window.setTimeout(function () {
            $('#setSelect').slideUp(200);
        }, 300);
    });
    $('#setSelect').on('mouseover', function () {
        window.clearTimeout(setStop);
    });
    $('#setSelect').on('mouseout', function () {
        setStop = window.setTimeout(function () {
            $('#setSelect').slideUp(200);
        }, 300);
    });

    /*
    **删除这里恢复默认状态
    */
    navPosition = 'left';
    navClass('vertical', null, 'block', NavLeftHeight);
    setArticle(0, 120, 0);
    $("#left").prop("checked", true);

    /*
    **当页面改变大小时
    */
    window.onresize = function () {
        NavLeftHeight = window.innerHeight - $('header').height();
        $('article')[0].style.height = NavLeftHeight + 'px';
        if (navPosition === 'auto') {
            navClass('horizontal', null, 'none', 90);
            $('article').css({'height': NavLeftHeight, 'margin': 0});
        } else if (navPosition === 'left') {
            navClass('vertical', null, 'block', NavLeftHeight);
            setArticle(0, 120, 0);
        } else if (navPosition === 'right') {
            navClass('vertical', 'floatRight', 'block', NavLeftHeight);
            setArticle(0, 0, 120);
        } else if (navPosition === 'top') {
            navClass('horizontal', 'removePosition', 'block', 90);
            setArticle(90, 0, 0);
        } else if (navPosition === 'bottom') {
            navClass('horizontal', 'positionBottom', 'block', 90);
            setArticle(90, 0, 0);
        }
    };

});
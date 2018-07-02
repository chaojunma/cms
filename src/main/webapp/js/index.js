layui.config({
    base: '/js/'
}).use([ 'jquery','layer','navbar','tab'], function() {
	
	var $ = layui.$,
		layer =	layui.layer,
		navbar = layui.navbar();
	
		var tab = layui.tab({
	        elem: '.admin-nav-card', //设置选项卡容器
	        contextMenu: true,
	        onSwitch: function (data) {
	            console.log(data.id); //当前Tab的Id
	            console.log(data.index); //得到当前Tab的所在下标
	            console.log(data.elem); //得到当前的Tab大容器
	            console.log(tab.getCurrentTabId())
	        },
	        closeBefore: function (obj) { //tab 关闭之前触发的事件
	            console.log(obj);
	            //obj.title  -- 标题
	            //obj.url    -- 链接地址
	            //obj.id     -- id
	            //obj.tabId  -- lay-id
	            return true;
	        }
	    });
	
	
	
	
	//清除缓存
	$(".clearCache").click(function(){
		window.sessionStorage.clear();
	    window.localStorage.clear();
	    var index = layer.msg('清除缓存中，请稍候',{icon: 16,time:false,shade:0.8});
	    setTimeout(function(){
	        layer.close(index);
	        layer.msg("缓存清除成功！");
	    },1000);
	})
	
	//iframe自适应
	$(window).on('resize', function() {
		var $content = $('.admin-nav-card .layui-tab-content');
		$content.height($(this).height() - 147);
		$content.find('iframe').each(function() {
			$(this).height($content.height());
		});
	}).resize();
	
	// 显示或隐藏左侧菜单
	$('.admin-side-toggle').on('click', function () {
        var sideWidth = $('#admin-side').width();
        if (sideWidth === 200) {
            $('#admin-body').animate({
                left: '0'
            }); 
            $('#admin-footer').animate({
                left: '0'
            });
            $('#admin-side').animate({
                width: '0'
            });
        } else {
            $('#admin-body').animate({
                left: '200px'
            });
            $('#admin-footer').animate({
                left: '200px'
            });
            $('#admin-side').animate({
                width: '200px'
            });
        }
    });
	
	
	// 全屏展示
	$('.admin-side-full').on('click', function () {
        var docElm = document.documentElement;
        //W3C  
        if (docElm.requestFullscreen) {
            docElm.requestFullscreen();
        }
        //FireFox  
        else if (docElm.mozRequestFullScreen) {
            docElm.mozRequestFullScreen();
        }
        //Chrome等  
        else if (docElm.webkitRequestFullScreen) {
            docElm.webkitRequestFullScreen();
        }
        //IE11
        else if (elem.msRequestFullscreen) {
            elem.msRequestFullscreen();
        }
        layer.msg('按Esc即可退出全屏');
    });
	
	
	//设置navbar(初始化菜单)
    navbar.set({
        elem: '#admin-navbar-side',
		url: 'datas/nav.json'
    });
    //渲染navbar
    navbar.render();
    //监听点击事件
    navbar.on('click(side)', function (data) {
    	 tab.tabAdd(data.field);
    });

});

function Tab(oli,obj,iclass,type){
		var li_list = oli;
		var olr = obj;
		li_list.on(type,function(){
		$(this).addClass(iclass).siblings().removeClass(iclass)
		var index = li_list.index(this);
		olr.eq(index).show().siblings().hide()
		})
	}

$(function(){
	Tab($('.sy_title li'),$('.sy_tab .sy_m'),'current','click');
});

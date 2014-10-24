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
	Tab($('.speed_title li'),$('.spend_tab .spend_mb'),'current','click');
});

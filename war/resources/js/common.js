$(document).ready(function(){
//로그인버튼
$('.login .borderBtn').on('click', function(){
	var login_status = $('.login').hasClass('out');

	if(login_status == false){
	$('.login').addClass('out');
	$(this).text('로그아웃');
		$(location).attr("href", "./member/logout");
	}else{
	$('.login').removeClass('out');
	$(this).text('로그인');
	}
});

//left menu - gnb
$(document).on('click','.depth01>li>a', function(){
var open = $(this).parents('li').hasClass('open');
var now = $(this).parents('li').hasClass('now');

//Add
$('.depth02>li>a').next('ul').stop().slideUp();
$('.depth02>li>a').parents('li').removeClass('open');

if(open == false){
$('.depth01>li').removeClass('open');
$('.depth02').stop().slideUp(); //close all depth02
$(this).next('ul').stop().slideDown(); //close depth02 menu

$('.depth02>li').removeClass('open');
$('.depth03').stop().slideUp();

$(this).parents('li').addClass('open');

if(now == false){
$('.depth01>li.now').addClass('leave');
}else{
$('.depth01>li.now').removeClass('leave');
}
}else{
$(this).next('ul').stop().slideUp(); //depth02
$(this).parents('li').removeClass('open'); //depth01
$('.depth01>li.now').addClass('leave');

$('.depth03').stop().slideUp();
}
});


//Add gnb
$(document).on('click','.depth02>li>a', function(){
var open = $(this).parent('li').hasClass('open');
var now = $(this).parent('li').hasClass('now');

if(open == false){
$('.depth02>li').removeClass('open');
$('.depth03').stop().slideUp();
$(this).next('ul').stop().slideDown();

//added 201125
$('.depth03>li').removeClass('open');


$(this).parent('li').addClass('open');
if(now == false){
$('.depth02>li.now').addClass('leave'); 
}else{
$('.depth02>li.now').removeClass('leave'); 
}
}else{
$(this).next('ul').stop().slideUp();
$(this).parent('li').removeClass('open');
}
});


//모바일 gnb
var scrollHeight = 0; //초기화

$('.mobile_btn').on('click', function(){
var menu_status = $(this).hasClass('menu_open');

if(menu_status == true){
$(this).removeClass('menu_open');
$('#nav').animate({
right: '-200%'
},750);
$('.shadow').fadeOut();
setTimeout(function() {
$('.depth01>li').removeClass('open');
$('.depth02').hide();
$('.depth01>li.now .depth02').show();
}, 310);

scrollHeight = $('body').scrollTop(); //현재 스크롤 위치
$('body').removeClass('layer-open'); //해제는 클래스 제거

}else{
$(this).addClass('menu_open');
$('#nav').animate({
right: '0'
},300);
$('.shadow').fadeIn();
$('.depth01>li.now').addClass('open');
$('.depth01>li.now').removeClass('leave');

scrollHeight = $('body').scrollTop(); //현재 스크롤 위치
$('body').addClass('layer-open'); //해제는 클래스 제거 
} 
});
});
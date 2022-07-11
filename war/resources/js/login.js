$(document).ready(function(){
//로그인버튼
$('.login .borderBtn').on('click', function(){
var login_status = $('.login').hasClass('out');

if(login_status == false){
$('.login').addClass('out');
$(this).text('로그아웃');
	//onclick="location.href='./member/logout
	$(location).attr("href", "./member/logout");
}else{
$('.login').removeClass('out');
$(this).text('로그인');
}

});

//gnb
$('.depth01>li>a').on('click', function(){
var open = $(this).parents('li').hasClass('open');
var now = $(this).parents('li').hasClass('now');

//Add
$('.depth02>li>a').next('ul').stop().slideUp();
$('.depth02>li>a').parents('li').removeClass('open');
//$('.depth02>li.now').addClass('leave');

if(open == false){
$('.depth01>li').removeClass('open');
$('.depth02').stop().slideUp(); //close all depth02
$(this).next('ul').stop().slideDown(); //close depth02 menu

$('.depth02>li').removeClass('open');
$('.depth03').stop().slideUp();
//$('.depth03').stop().slideDown();
//$(this).next('ul').stop().slideDown();
//$(this).next('ul').next('ul').stop().slideDown();

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
$('.depth02>li>a').on('click', function(){
var open = $(this).parent('li').hasClass('open');
var now = $(this).parent('li').hasClass('now');

if(open == false){
$('.depth02>li').removeClass('open');
$('.depth03').stop().slideUp();
$(this).next('ul').stop().slideDown();

//added 201125
$('.depth03>li').removeClass('open');
//$('.depth03').stop().slideUp();


$(this).parent('li').addClass('open');
if(now == false){
$('.depth02>li.now').addClass('leave'); 
}else{
$('.depth02>li.now').removeClass('leave'); 
}
}else{
$(this).next('ul').stop().slideUp();
$(this).parent('li').removeClass('open');
//$('.depth02>li.now').addClass('leave');
}
});




$(window).resize(function(){
nav_out();
});
nav_out();
function nav_out(){
$('#nav').on('mouseleave', function(){
var window_w = $(window).width();
//if(window_w > 1280){
if(window_w > 1366){
//$('.depth01>li').removeClass('open');
//$('.depth02').stop().slideUp();
//$('.depth01>li.now .depth02').stop().slideDown();
//$('.depth01>li.now').addClass('open');
//$('.depth01>li.now').removeClass('leave'); 

//added
//$('.depth02>li').removeClass('open');
//$('.depth03').stop().slideUp();
//$('.depth02>li.now .depth02').stop().slideDown();
//$('.depth02>li.now').addClass('open');
//$('.depth02>li.now').removeClass('leave'); 

//$('.depth02>li>a').next('ul').stop().slideUp();
//$('.depth02>li>a').parents('li').removeClass('open');
}
});
}


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
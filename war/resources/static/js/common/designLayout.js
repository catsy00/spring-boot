$(document).ready(function () {    	
	// hide #back-top first
	$("#back-top").hide();
	
	// fade in #back-top
	$(function () {
		$(window).scroll(function () {
			if ($(this).scrollTop() > 100) {
				$('#back-top').fadeIn();
			} else {
				$('#back-top').fadeOut();
			}
		});

		// scroll body to 0px on click
		$('#back-top a').click(function () {
			$('body,html').animate({
				scrollTop: 0
			}, 800);
			return false;
		});
	});
	

	//scrollbar
	$('.scrollbar-dynamic').scrollbar();
	$('.scrollbar-inner').scrollbar();
	$('.scrollbar-outer').scrollbar();
	 $('.textarea-scrollbar').scrollbar();

	 $(".popReport").colorbox({inline:true, width:"640px"}); //점검보고서 다운 팝업
	 $(".realView").colorbox({inline:true, width:"640px"}); //장애상세 팝업

	 $(".operView").colorbox({inline:true, width:"930px"}); //변전소 운영현황 상세보기 팝업	 
	 $( "#operDate" ).datepicker({ inline: true}); //변전소운영현황날짜
	 $( "#operDate_time" ).datetimepicker({inline: false,format:'Y-m-d H:i',lang:'kr', step:30}); //변전소운영현황날짜
	 $( "#operPopDate" ).datepicker({ inline: true}); //변전소운영현황상세 팝업 날짜
	 $( "#operPopDate_time" ).datetimepicker({inline: false,format:'Y-m-d H:i',lang:'kr', step:30});
	
	 $( "#startDate" ).datepicker({  dateFormat : 'yy-mm-dd', inline: true}); //시작 날짜선택 
	 $( "#endDate" ).datepicker({  dateFormat : 'yy-mm-dd', inline: true, maxDate: 0   }); //종료 날짜선택
	 
	 $( "#startDate_list").datetimepicker({inline: false,format:'Y-m-d H:i',lang:'kr', step:30}); //실시간 장애 감시 시작 날짜선택 
	 $( "#endDate_list").datetimepicker({inline: false,format:'Y-m-d H:i', maxDate: 0 ,lang:'kr' ,step:30 }); //실시간 장애 감시 종료 날짜선택
   
});

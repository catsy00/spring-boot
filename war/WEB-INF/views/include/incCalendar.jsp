<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<link rel="stylesheet" type="text/css" href="/resources/datetimepicker/jquery.datetimepicker.css"/>	
<script src="/resources/datetimepicker/jquery.js"></script>
<script src="/resources/datetimepicker/build/jquery.datetimepicker.full.min.js"></script> 
<script>
function getDt(date){
	var nowFlag = false;
	var mm="";
	var showDt = "";
	var dbDt = "";
	
	if(date == null)	{	// 캘린더 선택 안함
		// 전 : 선택하지 않을경우  / 후 : 쿠키 없을 경우
		if(getCookie("selectCal")==null || getCookie("stdDt") == null){	
			date = new Date();		
			mm = date.getMonth()+1;
			nowFlag = true;
		// 쿠키 존재			
		}else{		
			date = getCookieDate("stdDt");
			mm = date.getMonth();
		}
	
	// 캘린더 선택
	}else{
		setCookie("selectCal", 1,1);
		mm = date.getMonth()+1;
	}
	
	var yy = date.getFullYear(); 	var dd = date.getDate();		var hh = date.getHours(); 		var mi = date.getMinutes();
	
	//if(mi <= 30 && mi > 0)	mi = 30;   //else if(mi > 30)	// 30분 넘어가면 다음 시간 00분
	if(date.getMinutes() > 0){
		// show dt
		if(mm < 10)	mm = "0"+mm;
		if(dd < 10)	dd = "0"+dd;		
		if(hh < 10)		hh = "0"+hh;		
		if(mi < 10)  	mi = "0"+mi;
		showDt = yy + "-" + mm + "-" + dd +" " + hh + ":" + mi;
		
		// database dt
		date.setMinutes(date.getMinutes() + (60 - mi));
		yy =date.getFullYear();				mm = date.getMonth()+1;		dd = date.getDate();		hh = date.getHours(); 		mi = date.getMinutes();
	}
	
	// database dt
	if(dd < 10)	dd = "0"+dd;		
	if(mm < 10)	mm = "0"+mm;	
	if(hh < 10)		hh = "0"+hh;		
	if(mi < 10)  	mi = "0"+mi;
	dbDt = yy+mm+dd+hh+mi;
	if(showDt == "") showDt = yy + "-" + mm + "-" + dd +" " + hh + ":" + mi;
	
	// dt setting
	$("#stdDt").val(showDt);
	setCookie("stdDt", dbDt);
	if(nowFlag) setCookie("now", dbDt,1);
}
</script>
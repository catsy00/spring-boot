<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="/static/vendor/jquery/jquery-3.6.0.min.js" type="text/javascript"></script>
<script src="/static/vendor/jquery/jquery.modal.min.js" type="text/javascript"></script>

<link rel="stylesheet" type="text/css" href="/static/vendor/datetimepicker/jquery.datetimepicker.css" />
<script src="/static/vendor/datetimepicker/jquery.js"></script>
<script src="/static/vendor/datetimepicker/build/jquery.datetimepicker.full.min.js"></script>
<script src="/resources/js/com-util.js"></script>


<%@ include file="/WEB-INF/views/include/subTop2.jsp"%>
<!--validation-->
<script src="/static/vendor/jquery/jquery.validate.min.js" type="text/javascript"></script>
<script src="/static/vendor/jquery/additional-methods.min.js" type="text/javascript"></script>
</head>
<body>
	<!--subConTop-->
	<div class="subConTop">
		<h2>실시간 장애 감시 모니터링</h2>
		<div class="subTabBox">
			<div class="left">
				<ul class="tabMenu1 List2">
					<li class="on"><a href="#">관리운용현황</a></li>
					<li><a href="/facility/real_list">실시간 장애 감시</a></li>
				</ul>
			</div>
			<div class="right">
				<a href="#reportCon" class="popReport btn_report">점검보고서 <i></i></a>
				<!--******** 점검보고서 다운로드 출력 pop ********-->
				<div class="hide">
					<div id="reportCon" class="modal_style">
						<h2 class="tit">점검보고서 다운로드</h2>
						<div class="con">
							<div class="conTop">
								<button type="button" class="btn_report"
									onclick="btnReportOnClick()">
									광주전남본부 점검보고서 <i></i>
								</button>
							</div>
							<div class="conBottom">
								<!--전력지사명 출력-->
								<div class="stit">광주전력지사</div>
								<ul class="downList">
									<!--변전소 출력 반복-->
									<li><span class="txt">금천 변전소</span>
										<button type="button" class="btn_down"
											onclick="btnReportOnClick2()">
											다운로드<i></i>
										</button> <!--//변전소 출력 반복-->
									<li><span class="txt">변전소명</span> <a href="#"
										class="btn_down">다운로드 <i></i></a></li>
									<li><span class="txt">변전소명</span> <a href="#"
										class="btn_down">다운로드 <i></i></a></li>
									<li><span class="txt">변전소명</span> <a href="#"
										class="btn_down">다운로드 <i></i></a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<!--//******** 점검보고서 다운로드 출력 pop ********-->
			</div>
		</div>
	</div>
	<!--//subConTop-->
	<!--subConBox-->
	<div class="subConBox">
		<!--tabs 추가 -jbk -->
		<div id="tabs">
			<ul class="tabMenu3 List5" style="border-left-width: 0px;">
				<li role="tab" id="tab1"><a href="#bizpBox" >광주전남본부</a></li>
				<li role="tab" id="tab2"><a href="#pssBox">직할</a></li>
			</ul>
			<!--tab1 추가 -jbk -->
			<div id="bizpBox">
				<div class="operInfo">
					<ul>
						<li><i class="count"></i><span>장애수량</span></li>
						<li><i class="allcount"></i><span>정상수량</span></li>
					</ul>
				</div>
				<!--operListBox-->
				<div class="operListBox">
					<div class="bonbu">
						<span class="outer">
							<h3 class="in">광주전남본부</h3>
						</span>
					</div>
					<div class="oper_line"></div>
					<!--jighal-->
					<div class="jighal">
						<div class="inBox">
							<c:forEach var="b" items="${result}">
								<c:forEach var="c" items="${result2}">
									<!-- /check/operation_view -->
									<!--  <button type="submit"><h3 class="on">직할</h3></button> -->
									<!--  tab 관련 변경 - jbk -->
									<!--<a href="/check/operation_view"><h3 class="on">직할</h3></a> -->
									<a href="#" onclick="pssOnClick()"><h3 class="on">직할</h3></a>

									<!--<h3>직할</h3>-->
									<ul>
										<li><span class="nomalTit ico01_off" id="afac">통합제어장치</span>
											<span class="count" id="acheck"> ${c.ACHECK}</span> <span
											class="allcount">${b.ACNT}</span></li>
										<li><span class="nomalTit ico02_off" id="bfac">녹화장치</span> <span
											class="count" id="bcheck">${c.BCHECK}</span> <span
											class="allcount">${b.BCNT}</span></li>
										<li><span class="pointTit ico03_off" id="cfac">카메라</span> <span
											class="count" id="ccheck">${c.CCHECK}</span> <span
											class="allcount">${b.CCNT}</span></li>
										<li><span class="nomalTit ico04_off" id="dfac">출입리더기</span> <span
											class="count" id="dcheck">${c.DCHECK}</span> <span
											class="allcount">${b.DCNT}</span></li>
										<li><span class="pointTit ico05_off" id="efac">경보주장치</span> <span
											class="count" id="echeck">${c.ECHECK}</span> <span
											class="allcount">${b.ECNT}</span></li>
									</ul>
								</c:forEach>
							</c:forEach>
						</div>
					</div>
					<!--//jighal-->
					<!--sun-->
					<div class="sun" id="test1">
						<div class="inBox">
							<!-- <a href="operation_view_ver1.0.html"><h3 class="on">순천</h3></a> -->
							<h3>순천</h3>
							<ul>
								<li><span class="nomalTit ico01_off">통합제어장치</span> <span
									class="disablecount">0</span> <span class="disablecount">0</span></li>
								<li><span class="nomalTit ico02_off">녹화장치</span> <span
									class="disablecount">0</span> <span class="disablecount">0</span></li>
								<li><span class="nomalTit ico03_off">카메라</span> <span
									class="disablecount">0</span> <span class="disablecount">0</span></li>
								<li><span class="nomalTit ico04_off">출입리더기</span> <span
									class="disablecount">0</span> <span class="disablecount">0</span></li>
								<li><span class="nomalTit ico05_off">경보주장치</span> <span
									class="disablecount">0</span> <span class="disablecount">0</span></li>
							</ul>
						</div>
					</div>
					<!--//sun-->
					<!--gang-->
					<div class="gang">
						<div class="inBox">
							<!-- <a href="operation_view_ver1.0.html"><h3 class="on">강진</h3></a> -->
							<h3>강진</h3>
							<ul>
								<li><span class="nomalTit ico01_off">통합제어장치</span> <span
									class="disablecount">0</span> <span class="disablecount">0</span></li>
								<li><span class="nomalTit ico02_off">녹화장치</span> <span
									class="disablecount">0</span> <span class="disablecount">0</span></li>
								<li><span class="nomalTit ico03_off">카메라</span> <span
									class="disablecount">0</span> <span class="disablecount">0</span></li>
								<li><span class="nomalTit ico04_off">출입리더기</span> <span
									class="disablecount">0</span> <span class="disablecount">0</span></li>
								<li><span class="nomalTit ico05_off">경보주장치</span> <span
									class="disablecount">0</span> <span class="disablecount">0</span></li>
							</ul>
						</div>
					</div>
					<!--//gang-->
					<!--gwang-->
					<div class="gwang">
						<div class="inBox">
							<!-- <a href="operation_view_ver1.0.html"><h3 class="on">광주</h3></a> -->
							<h3>광주</h3>
							<ul>
								<li><span class="nomalTit ico01_off">통합제어장치</span> <span
									class="disablecount">0</span> <span class="disablecount">0</span></li>
								<li><span class="nomalTit ico02_off">녹화장치</span> <span
									class="disablecount">0</span> <span class="disablecount">0</span></li>
								<li><span class="nomalTit ico03_off">카메라</span> <span
									class="disablecount">0</span> <span class="disablecount">0</span></li>
								<li><span class="nomalTit ico04_off">출입리더기</span> <span
									class="disablecount">0</span> <span class="disablecount">0</span></li>
								<li><span class="nomalTit ico05_off">경보주장치</span> <span
									class="disablecount">0</span> <span class="disablecount">0</span></li>
							</ul>
						</div>
					</div>
					<!--//gwang-->
					<!--mok-->
					<div class="mok">
						<div class="inBox">
							<!-- <a href="operation_view_ver1.0.html"><h3 class="on">목포</h3></a> -->
							<h3>목포</h3>
							<ul>
								<li><span class="nomalTit ico01_off">통합제어장치</span> <span
									class="disablecount">0</span> <span class="disablecount">0</span></li>
								<li><span class="nomalTit ico02_off">녹화장치</span> <span
									class="disablecount">0</span> <span class="disablecount">0</span></li>
								<li><span class="nomalTit ico03_off">카메라</span> <span
									class="disablecount">0</span> <span class="disablecount">0</span></li>
								<li><span class="nomalTit ico04_off">출입리더기</span> <span
									class="disablecount">0</span> <span class="disablecount">0</span></li>
								<li><span class="nomalTit ico05_off">경보주장치</span> <span
									class="disablecount">0</span> <span class="disablecount">0</span></li>
							</ul>
						</div>
					</div>
					<!--//mok-->
				</div>
				<!--//operListBox-->
			</div>
		<!--tab2 추가 -jbk -->
			<div id="pssBox">
				<div class="operInfo">
					<ul>
						<li><i class="count"></i><span>장애수량</span></li>
						<li><i class="allcount"></i><span>정상수량</span></li>
					</ul>
				</div>
				<!--operListBox-->
				<div class="operListBox">
					<div class="bonbu">
						<span class="outer">
							<h3 class="in">직할</h3>
						</span>
					</div>
					<div class="oper_line2"></div>
					<!--jighal-->
					<div class=center>
						<div class="inBox">
							<c:forEach var="b" items="${result}">
								<c:forEach var="c" items="${result2}">
									<a href="/check/operation_view"><h3 class="on">금천</h3></a>
									<!--<h3>직할</h3>-->
									<ul>
										<li><span class="nomalTit ico01_off" id="afacTab">통합제어장치</span>
											<span class="count" id="acheckTab">${c.ACHECK}</span> <span
											class="allcount">${b.ACNT}</span></li>
										<li><span class="nomalTit ico02_off" id="bfacTab">녹화장치</span>
											<span class="count" id="bcheckTab">${c.BCHECK}</span> <span
											class="allcount">${b.BCNT}</span></li>
										<li><span class="pointTit ico03_off" id="cfacTab">카메라</span>
											<span class="count" id="ccheckTab">${c.CCHECK}</span> <span
											class="allcount">${b.CCNT}</span></li>
										<li><span class="nomalTit ico04_off" id="dfacTab">출입리더기</span>
											<span class="count" id="dcheckTab">${c.DCHECK}</span> <span
											class="allcount">${b.DCNT}</span></li>
										<li><span class="pointTit ico05_off" id="efacTab">경보주장치</span>
											<span class="count" id="echeckTab">${c.ECHECK}</span> <span
											class="allcount">${b.ECNT}</span></li>
									</ul>
								</c:forEach>
							</c:forEach>
						</div>
					</div>
					<!--//jighal-->
					<!--song-->
					<div class=song>
						<div class="inBox">
							<h3>송정</h3>
							</a>
							<!--<h3>직할</h3>-->
							<ul>
								<li><span class="nomalTit ico01_off">통합제어장치</span> <span
									class="disablecount">0</span> <span class="disablecount">0</span></li>
								<li><span class="nomalTit ico02_off">녹화장치</span> <span
									class="disablecount">0</span> <span class="disablecount">0</span></li>
								<li><span class="nomalTit ico03_off">카메라</span> <span
									class="disablecount">0</span> <span class="disablecount">0</span></li>
								<li><span class="nomalTit ico04_off">출입리더기</span> <span
									class="disablecount">0</span> <span class="disablecount">0</span></li>
								<li><span class="nomalTit ico05_off">경보주장치</span> <span
									class="disablecount">0</span> <span class="disablecount">0</span></li>
							</ul>
						</div>
					</div>
					<!--//song-->
					<!--wang-->
					<div class="wang">
						<div class="inBox">
							<h3>왕곡</h3>
							<ul>
								<li><span class="nomalTit ico01_off">통합제어장치</span> <span
									class="disablecount">0</span> <span class="disablecount">0</span></li>
								<li><span class="nomalTit ico02_off">녹화장치</span> <span
									class="disablecount">0</span> <span class="disablecount">0</span></li>
								<li><span class="nomalTit ico03_off">카메라</span> <span
									class="disablecount">0</span> <span class="disablecount">0</span></li>
								<li><span class="nomalTit ico04_off">출입리더기</span> <span
									class="disablecount">0</span> <span class="disablecount">0</span></li>
								<li><span class="nomalTit ico05_off">경보주장치</span> <span
									class="disablecount">0</span> <span class="disablecount">0</span></li>
							</ul>
						</div>
					</div>
					<!--//wang-->
				</div>
				<!--//operListBox-->
			</div>
		</div>
		<!--//subConBox-->
</body>
<script type="text/javascript">
	var cnt;
	//클래스 변경
	//setaClassName1 -> 에러 없음
	//setaClassName2 -> 에러 있음
	$(function() {

		var cnt1 = document.getElementById('acheck').innerHTML;
		var cnt2 = document.getElementById('bcheck').innerHTML;
		var cnt3 = document.getElementById('ccheck').innerHTML;
		var cnt4 = document.getElementById('dcheck').innerHTML;
		var cnt5 = document.getElementById('echeck').innerHTML;

		Disabled();

		if (cnt1 == 0) {
			setaClassName1();
		} else {
			setaClassName2();
		}

		if (cnt2 == 0) {
			setbClassName1();
		} else {
			setbClassName2();
		}

		if (cnt3 == 0) {
			setcClassName1();
		} else {
			setcClassName2();
		}

		if (cnt4 == 0) {
			setdClassName1();
		} else {
			setdClassName2();
		}

		if (cnt5 == 0) {
			seteClassName1();
		} else {
			seteClassName2();
		}

		//tabs 추가 - jbk
		$("#tabs").tabs();
		$("#tab2").hide();

	});
	function setaClassName1() {
		$('#afac').attr('class', 'nomalTit ico01_off');
		$('#acheck').attr('class', 'clearcount');

		$('#afacTab').attr('class', 'nomalTit ico01_off');
		$('#acheckTab').attr('class', 'clearcount');
	}
	function setaClassName2() {
		$('#afac').attr('class', 'pointTit ico01_on');
		$('#acheck').attr('class', 'count');

		$('#afacTab').attr('class', 'pointTit ico01_on');
		$('#acheckTab').attr('class', 'count');
	}

	function setbClassName1() {
		$('#bfac').attr('class', 'nomalTit ico02_off');
		$('#bcheck').attr('class', 'clearcount');

		$('#bfacTab').attr('class', 'nomalTit ico02_off');
		$('#bcheckTab').attr('class', 'clearcount');
	}
	function setbClassName2() {
		$('#bfac').attr('class', 'pointTit ico02_on');
		$('#bcheck').attr('class', 'count');

		$('#bfacTab').attr('class', 'pointTit ico02_on');
		$('#bcheckTab').attr('class', 'count');
	}
	function setcClassName1() {
		$('#cfac').attr('class', 'nomalTit ico03_off');
		$('#ccheck').attr('class', 'clearcount');

		$('#cfacTab').attr('class', 'nomalTit ico03_off');
		$('#ccheckTab').attr('class', 'clearcount');
	}
	function setcClassName2() {
		$('#cfac').attr('class', 'pointTit ico03_on');
		$('#ccheck').attr('class', 'count');

		$('#cfacTab').attr('class', 'pointTit ico03_on');
		$('#ccheckTab').attr('class', 'count');
	}
	function setdClassName1() {
		$('#dfac').attr('class', 'nomalTit ico04_off');
		$('#dcheck').attr('class', 'clearcount');

		$('#dfacTab').attr('class', 'nomalTit ico04_off');
		$('#dcheckTab').attr('class', 'clearcount');
	}
	function setdClassName2() {
		$('#dfac').attr('class', 'pointTit ico04_on');
		$('#dcheck').attr('class', 'count');

		$('#dfacTab').attr('class', 'pointTit ico04_on');
		$('#dcheckTab').attr('class', 'count');
	}
	function seteClassName1() {
		$('#efac').attr('class', 'nomalTit ico05_off');
		$('#echeck').attr('class', 'clearcount');

		$('#efacTab').attr('class', 'nomalTit ico05_off');
		$('#echeckTab').attr('class', 'clearcount');
	}
	function seteClassName2() {
		$('#efac').attr('class', 'pointTit ico05_on');
		$('#echeck').attr('class', 'count');

		$('#efacTab').attr('class', 'pointTit ico05_on');
		$('#echeckTab').attr('class', 'count');
	}

	function Disabled() {
		const target = document.getElementById('test1');
		target.disabled = true;
	}

	//tabs 추가  - jbk
	function pssOnClick() {
		$("#tab2").show();
		$('a[href="#pssBox"]').trigger('click');
		document.getElementById('pssBox').style.height = "650px";
	}
	//엑셀다운로드 본부
	function btnReportOnClick() {
		var date = "";
		location.href = "/check/download?date=" + date;
	}
	//엑셀다운로드 변전소
	function btnReportOnClick2() {
		var date = "";
		location.href = "/check/download3?date=" + date;
	}
	
	function btnOnClick() {
			$.ajax({
				url : "select",
				type : "POST",
				datatype : "json",
				success : function(data) {
					console.log(data);
					alert(data.result5.acheck);
					alert(data.result);
				},
				error : function() {
					alert("에러")
				}
			});
	}
	
</script>
<%@ include file="/WEB-INF/views/include/subBottom.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
								<button type="button" class="btn_report" onclick="btnReportOnClick()">
									광주전남본부 점검보고서 <i></i>
								</button>
							</div>
							<div class="conBottom">
								<!--전력지사명 출력-->
								<div class="stit">직할</div>
								<ul class="downList">
									<!--변전소 출력 반복-->
									<li><span class="txt">금천 변전소</span>
										<button type="button" class="btn_down" onclick="btnReportOnClick1_2()">
											다운로드<i></i>
										</button></li>
									<!--//변전소 출력 반복-->
									<li><span class="txt">변전소명</span> <a href="#" class="btn_down">다운로드 <i></i></a></li>
									<li><span class="txt">변전소명</span> <a href="#" class="btn_down">다운로드 <i></i></a></li>
									<li><span class="txt">변전소명</span> <a href="#" class="btn_down">다운로드 <i></i></a></li>
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
		<!--realSearch-->
		<form id="frm" name="frm" method="post">
			<div class="realSearch">
				<!--operViewTop-->
				<div class="operViewTop">
					<div class="left">
						<h3 class="mTit">직할</h3>
						<h3 class="sTit">변전소 운영현황</h3>
						<input type="datetime" id="operDate_time" name="operDate_time" class="operDate" title="날짜선택" readonly/>
						<button type="button" class="btn_search" id="btn_search" onclick="btnOnClick()"></button>
					</div>
					<div class="right">
						<a href="operation_list" class="btn_operList">목록</a>
					</div>
				</div>
				<!--//operViewTop-->
			</div>
		</form>
		<!--operViewCon-->
		<div class="operViewCon">
			<ul class="conList">
				<!-- 변전소 리스트 반복-->
				<li>
					<div class="conRepeat">
						<c:forEach var="a" items="${result}">
							<c:forEach var="b" items="${result2}">
								<a href="#operView" class="operView">
									<h4 class="tit">금천 변전소</h4>
								</a>

								<ul class="con">
									<li><span class="txt_name">통합제어장치</span> <span class="ico_signal on" id="afac">경고</span>
									<!--<span class="ico_signal">정상</span>--> <span class="txt_state" id="acheck">${b.ACHECK} / ${a.ACNT}</span></li>
									<li><span class="txt_name">녹화장치</span> <span class="ico_signal" id="bfac">정상</span> <span class="txt_state" id="bcheck">${b.BCHECK} / ${a.BCNT}</span></li>
									<li><span class="txt_name">카메라</span> <span class="ico_signal" id="cfac">정상</span> <span class="txt_state" id="ccheck">${b.CCHECK} / ${a.CCNT}</span></li>
									<li><span class="txt_name">출입리더기</span> <span class="ico_signal" id="dfac">정상</span> <span class="txt_state" id="dcheck">${b.DCHECK} / ${a.DCNT}</span></li>
									<li><span class="txt_name">경보주장치</span> <span class="ico_signal" id="efac">정상</span> <span class="txt_state" id="echeck">${b.ECHECK} / ${a.ECNT}</span></li>
								</ul>
							</c:forEach>
						</c:forEach>
					</div>
				</li>
				<!-- //변전소 리스트 반복-->
				<li>
					<div class="conRepeat">
						
							<h4 class="tit">변전소명</h4>
						
						<ul class="con">
							<li><span class="txt_name">통합제어장치</span> <span class="ico_signal off">경고</span>
							<!--<span class="ico_signal">정상</span>--> <span class="txt_state">0 / 20</span></li>
							<li><span class="txt_name">녹화장치</span> <span class="ico_signal off">정상</span> <span class="txt_state">0 / 20</span></li>
							<li><span class="txt_name">카메라</span> <span class="ico_signal off">정상</span> <span class="txt_state">0 / 20</span></li>
							<li><span class="txt_name">출입리더기</span> <span class="ico_signal off">정상</span> <span class="txt_state">0 / 20</span></li>
							<li><span class="txt_name">경보주장치</span> <span class="ico_signal off">정상</span> <span class="txt_state">0 / 20</span></li>
						</ul>
					</div>
				</li>
				<li>
					<div class="conRepeat">
						
							<h4 class="tit">변전소명</h4>
					
						<ul class="con">
							<li><span class="txt_name">통합제어장치</span> <span class="ico_signal off">경고</span>
							<!--<span class="ico_signal">정상</span>--> <span class="txt_state">0 / 20</span></li>
							<li><span class="txt_name">녹화장치</span> <span class="ico_signal off">정상</span> <span class="txt_state">0 / 20</span></li>
							<li><span class="txt_name">카메라</span> <span class="ico_signal off">정상</span> <span class="txt_state">0 / 20</span></li>
							<li><span class="txt_name">출입리더기</span> <span class="ico_signal off">정상</span> <span class="txt_state">0 / 20</span></li>
							<li><span class="txt_name">경보주장치</span> <span class="ico_signal off">정상</span> <span class="txt_state">0 / 20</span></li>
						</ul>
					</div>
				</li>
				<li>
					<div class="conRepeat">
						
							<h4 class="tit">변전소명</h4>
						
						<ul class="con">
							<li><span class="txt_name">통합제어장치</span> <span class="ico_signal off">경고</span>
							<!--<span class="ico_signal">정상</span>--> <span class="txt_state">0 / 20</span></li>
							<li><span class="txt_name">녹화장치</span> <span class="ico_signal off">정상</span> <span class="txt_state">0 / 20</span></li>
							<li><span class="txt_name">카메라</span> <span class="ico_signal off">정상</span> <span class="txt_state">0 / 20</span></li>
							<li><span class="txt_name">출입리더기</span> <span class="ico_signal off">정상</span> <span class="txt_state">0 / 20</span></li>
							<li><span class="txt_name">경보주장치</span> <span class="ico_signal off">정상</span> <span class="txt_state">0 / 20</span></li>
						</ul>
					</div>
				</li>
				<li>
					<div class="conRepeat">
					
							<h4 class="tit">변전소명</h4>
						
						<ul class="con">
							<li><span class="txt_name">통합제어장치</span> <span class="ico_signal off">경고</span>
							<!--<span class="ico_signal">정상</span>--> <span class="txt_state">0 / 20</span></li>
							<li><span class="txt_name">녹화장치</span> <span class="ico_signal off">정상</span> <span class="txt_state">0 / 20</span></li>
							<li><span class="txt_name">카메라</span> <span class="ico_signal off">정상</span> <span class="txt_state">0 / 20</span></li>
							<li><span class="txt_name">출입리더기</span> <span class="ico_signal off">정상</span> <span class="txt_state">0 / 20</span></li>
							<li><span class="txt_name">경보주장치</span> <span class="ico_signal off">정상</span> <span class="txt_state">0 / 20</span></li>
						</ul>
					</div>
				</li>
				<li>
					<div class="conRepeat">
						
							<h4 class="tit">변전소명</h4>
					
						<ul class="con">
							<li><span class="txt_name">통합제어장치</span> <span class="ico_signal off">경고</span>
							<!--<span class="ico_signal">정상</span>--> <span class="txt_state">0 / 20</span></li>
							<li><span class="txt_name">녹화장치</span> <span class="ico_signal off">정상</span> <span class="txt_state">0 / 20</span></li>
							<li><span class="txt_name">카메라</span> <span class="ico_signal off">정상</span> <span class="txt_state">0 / 20</span></li>
							<li><span class="txt_name">출입리더기</span> <span class="ico_signal off">정상</span> <span class="txt_state">0 / 20</span></li>
							<li><span class="txt_name">경보주장치</span> <span class="ico_signal off">정상</span> <span class="txt_state">0 / 20</span></li>
						</ul>
					</div>
				</li>
				<li>
					<div class="conRepeat">
				
							<h4 class="tit">변전소명</h4>
					
						<ul class="con">
							<li><span class="txt_name">통합제어장치</span> <span class="ico_signal off">경고</span>
							<!--<span class="ico_signal">정상</span>--> <span class="txt_state">0 / 20</span></li>
							<li><span class="txt_name">녹화장치</span> <span class="ico_signal off">정상</span> <span class="txt_state">0 / 20</span></li>
							<li><span class="txt_name">카메라</span> <span class="ico_signal off">정상</span> <span class="txt_state">0 / 20</span></li>
							<li><span class="txt_name">출입리더기</span> <span class="ico_signal off">정상</span> <span class="txt_state">0 / 20</span></li>
							<li><span class="txt_name">경보주장치</span> <span class="ico_signal off">정상</span> <span class="txt_state">0 / 20</span></li>
						</ul>
					</div>
				</li>
				<li>
					<div class="conRepeat">
						
							<h4 class="tit">변전소명</h4>
			
						<ul class="con">
							<li><span class="txt_name">통합제어장치</span> <span class="ico_signal off">경고</span>
							<!--<span class="ico_signal">정상</span>--> <span class="txt_state">0 / 20</span></li>
							<li><span class="txt_name">녹화장치</span> <span class="ico_signal off">정상</span> <span class="txt_state">0 / 20</span></li>
							<li><span class="txt_name">카메라</span> <span class="ico_signal off">정상</span> <span class="txt_state">0 / 20</span></li>
							<li><span class="txt_name">출입리더기</span> <span class="ico_signal off">정상</span> <span class="txt_state">0 / 20</span></li>
							<li><span class="txt_name">경보주장치</span> <span class="ico_signal off">정상</span> <span class="txt_state">0 / 20</span></li>
						</ul>
					</div>
				</li>
				<li>
					<div class="conRepeat">
	
							<h4 class="tit">변전소명</h4>
					
						<ul class="con">
							<li><span class="txt_name">통합제어장치</span> <span class="ico_signal off">경고</span>
							<!--<span class="ico_signal">정상</span>--> <span class="txt_state">0 / 20</span></li>
							<li><span class="txt_name">녹화장치</span> <span class="ico_signal off">정상</span> <span class="txt_state">0 / 20</span></li>
							<li><span class="txt_name">카메라</span> <span class="ico_signal off">정상</span> <span class="txt_state">0 / 20</span></li>
							<li><span class="txt_name">출입리더기</span> <span class="ico_signal off">정상</span> <span class="txt_state">0 / 20</span></li>
							<li><span class="txt_name">경보주장치</span> <span class="ico_signal off">정상</span> <span class="txt_state">0 / 20</span></li>
						</ul>
					</div>
				</li>
				<li>
					<div class="conRepeat">
							<h4 class="tit">변전소명</h4>
						<ul class="con">
							<li><span class="txt_name">통합제어장치</span> <span class="ico_signal off">경고</span>
							<!--<span class="ico_signal">정상</span>--> <span class="txt_state">0 / 20</span></li>
							<li><span class="txt_name">녹화장치</span> <span class="ico_signal off">정상</span> <span class="txt_state">0 / 20</span></li>
							<li><span class="txt_name">카메라</span> <span class="ico_signal off">정상</span> <span class="txt_state">0 / 20</span></li>
							<li><span class="txt_name">출입리더기</span> <span class="ico_signal off">정상</span> <span class="txt_state">0 / 20</span></li>
							<li><span class="txt_name">경보주장치</span> <span class="ico_signal off">정상</span> <span class="txt_state">0 / 20</span></li>
						</ul>
					</div>
				</li>
			</ul>
		</div>
		<!--//operViewCon-->
		<!--//operListBox-->
		<!--******** 변전소 운영현황 상세보기 출력 pop ********-->
		<div class="hide">
			<div id="operView" class="modal_style">
				<h2 class="tit">변전소 운영현황 상세보기</h2>
				<div class="con">
					<!--operViewPopSearch-->
					<form id="frm2" name="frm2" method="post">
						<div class="realSearch">
							<c:forEach var="b" items="${result2}">
								<div class="operViewPopSearch">
									<span class="mTit" style="margin-top: 3px;">직할</span> <span class="sTit">변전소 </span> <select class="comSelectBL" id="pssCd">
										<option value="D368">금천 변전소</option>
									</select> <input type="datetime" id="operPopDate_time" name="operPopDate_time" class="operPopDate" title="날짜선택" readonly/>

									<button type="button" class="btn_search" onclick="btnOnClick2()"></button>
								</div>
							</c:forEach>
							<div class="operViewPopCon">
									<div class="text-right">
										<button type="button" onclick="btnReportOnClick2()" class="btn_excel">엑셀 다운로드</button>
									</div>
							</div>
						</div>
					</form>
					<!--//operViewPopSearch-->
					<!--operViewPopCon-->
					<c:forEach var="a" items="${result}">
						<c:forEach var="b" items="${result2}">
							<c:forEach var="c" items="${result3}">
								<div class="operViewPopCon">
									<div class="top">
										<!--통합제어장치-->
										<div class="conBox control">
											<h3>통합제어장치</h3>
											<div class="conBoxIn">
												<div class="stateBarBox">
													<div class="txt_tit">CPU</div>
													<div class="bar" id="control01"></div>
													<div id="cpu_txt_per" class="txt_per">${c.aCpuUseQnt}%</div>
												</div>
												<div class="stateBarBox">
													<div class="txt_tit">RAM</div>
													<div class="bar" id="control02"></div>
													<div id="ram_txt_per" class="txt_per">${c.aRamUsrQnt}%</div>
												</div>
												<div class="stateBarBox">
													<div class="txt_tit">DISK#1</div>
													<div class="bar" id="control03"></div>
													<div id="hdd_txt_per" class="txt_per">${c.aHddUseQnt}%</div>
												</div>
												<script id="controScript" >
													$("#control01").ProgressBarWars({porcentaje:${c.aCpuUseQnt}});
													$("#control02").ProgressBarWars({porcentaje:${c.aRamUsrQnt}});
													$("#control03").ProgressBarWars({porcentaje:${c.aHddUseQnt}});
												</script>
											</div>
										</div>
										<!--//통합제어장치-->
										<!--녹화장치-->
										<div class="conBox recoding">
											<h3>녹화장치</h3>
											<div class="conBoxIn">
												<div class="stateBarBox">
													<div class="txt_tit">CPU</div>
													<div class="bar" id="recoding01"></div>
													<div id="reco_cpu_txt_per" class="txt_per">${c.bCpuUseQnt}%</div>
												</div>
												<div class="stateBarBox">
													<div class="txt_tit">RAM</div>
													<div class="bar" id="recoding02"></div>
													<div id="reco_ram_txt_per" class="txt_per">${c.bRamUsrQnt}%</div>
												</div>
												<div class="stateBarBox">
													<div class="txt_tit">DISK#1</div>
													<div class="bar" id="recoding03"></div>
													<div id="reco_hdd_txt_per" class="txt_per">${c.bHddUseQnt}%</div>
												</div>
												<div class="stateBarBox">
													<div class="txt_tit">DISK#2</div>
													<div class="bar" id="recoding04"></div>
													<div id="reco_hdd_txt_per2" class="txt_per">${c.bHddUseQnt2}%</div>
												</div>
												<div class="stateBarBox">
													<div class="txt_tit">DISK#3</div>
													<div class="bar" id="recoding05"></div>
													<div id="reco_hdd_txt_per3" class="txt_per">${c.bHddUseQnt3}%</div>
												</div>
												<script>
													$("#recoding01").ProgressBarWars({porcentaje:${c.bCpuUseQnt}});
													$("#recoding02").ProgressBarWars({porcentaje:${c.bRamUsrQnt}});
													$("#recoding03").ProgressBarWars({porcentaje:${c.bHddUseQnt}});
													$("#recoding04").ProgressBarWars({porcentaje:${c.bHddUseQnt2}});
													$("#recoding05").ProgressBarWars({porcentaje:${c.bHddUseQnt3}});
												</script>
												<!--<div  class="con" style="padding-left: 0px;">-->
													<!--<span class="txt_name">실시간 녹화 상태</span>-->
													<!-- <span class="ico_signal on">경고</span> -->
													<!--<span class="ico_signal" id = "bVdoFileYn">${c.bVdoFileYn}%</span> -->
												<!--</div>-->
											</div>
										</div>
										<!--//녹화장치-->
									</div>
									<div class="bottom">
										<!--카메라-->
										<div class="conBox camera">
											<h3 class="title">카메라</h3>
											<div class="con">
												<span class="txt_name">네트워크 연결상태</span> <span class="ico_signal on" id="cameFac">경고</span>
												<!--<span class="ico_signal">정상</span>-->
												<span class="txt_state" id="cameCheck">${b.CCHECK2} / ${a.CCNT}</span>
											</div>
											<!--장애시 리스트 출력-->
											<div class="infoTextBox scrollbar-inner">
												<h4>장애 카메라 식별</h4>
												<ul id="camList">
												</ul>
											</div>
											<!--//장애시 리스트 출력-->
											<div class="con">
												<span class="txt_name">실시간 녹화 상태</span> <span class="ico_signal on" id="cameVdoFac">경고</span>
												<!--<span class="ico_signal">정상</span>-->
												<span class="txt_state" id="cameVdoCheck">${b.vdoFileCHECK} / ${a.CCNT}</span>
											</div>
											<!--장애시 리스트 출력-->
											<div class="infoTextBox scrollbar-inner">
												<h4>장애 카메라 식별</h4>
												<ul id="camVdoList">
												</ul>
											</div>
											<!--//장애시 리스트 출력-->
										</div>
										<!--//카메라-->
										<!--출입리더기-->
										<div class="conBox reder">
											<h3>출입리더기</h3>
											<div class="con">
												<span class="txt_name">네트워크 연결상태</span>
												<!-- <span class="ico_signal on">경고</span> -->
												<span class="ico_signal" id="readFac">정상</span> <span class="txt_state" id="readCheck">${b.DCHECK} / ${a.DCNT}</span>
											</div>
											<!--장애시 리스트 출력-->
											<div class="infoTextBox scrollbar-inner">
												<h4>장애 출입리더기 식별</h4>
												<ul id="readList">
												</ul>
											</div>
											<!--//장애시 리스트 출력-->
										</div>
										<!--//출입리더기-->
										<!--경보주장치-->
										<div class="conBox alarm">
											<h3>경보주장치</h3>
											<div class="con">
												<span class="txt_name">네트워크 연결상태</span>
												<!-- <span class="ico_signal on">경고</span> -->
												<span class="ico_signal" id="alertFac">정상</span> <span class="txt_state" id="alertCheck">${b.ECHECK} / ${a.ECNT}</span>
											</div>
											<!--장애시 리스트 출력-->
											<div class="infoTextBox scrollbar-inner">
												<h4>장애 경보주장치 식별</h4>
												<ul id="alertList">
												</ul>
											</div>
											<!--//장애시 리스트 출력-->
										</div>
										<!--//경보주장치-->
									</div>
								</div>
								<!--//operViewPopCon-->
							</c:forEach>
						</c:forEach>
					</c:forEach>
				</div>
			</div>
		</div>
		<!--******** 변전소 운영현황 상세보기 출력 pop ********-->
		<!--//subConBox-->
</body>
<script type="text/javascript">
let sdate;



$(function() {
	
	var cnt1 = document.getElementById('acheck').innerHTML;
	var changeCnt1 = cnt1.charAt(0);
	var cnt2 = document.getElementById('bcheck').innerHTML;
	var changeCnt2 = cnt2.charAt(0);
	var cnt3 = document.getElementById('ccheck').innerHTML;
	var changeCnt3 = cnt3.charAt(0);
	var cnt4 = document.getElementById('dcheck').innerHTML;
	var changeCnt4 = cnt4.charAt(0);
	var cnt5 = document.getElementById('echeck').innerHTML;
	var changeCnt5 = cnt5.charAt(0);
	
	var cameraCnt = document.getElementById('cameCheck').innerHTML;
	var cameChangeCnt = cameraCnt.charAt(0);
	
	var cameraVdoCnt = document.getElementById('cameVdoCheck').innerHTML;
	var cameVdoChangeCnt = cameraVdoCnt.charAt(0);
	
	var readCnt = document.getElementById('readCheck').innerHTML;
	var readChangeCnt = readCnt.charAt(0);
	
	var alertCnt = document.getElementById('alertCheck').innerHTML;
	var alertChangeCnt = alertCnt.charAt(0);
	
	var mod = "${modal}";
	
	var sdate = "${sdate}"
	
	if(mod == 1){
		$('a[href="#operView"]').click();
		if(sdate != ""){
			$("#operPopDate_time").val(sdate);
		}
	}
	
	if(sdate != ""){
		$("#operDate_time").val(sdate);
	}
	
	addList();

  	
	if(changeCnt1 == 0){
		setaClassName1();
	}else{
		setaClassName2();
	}
	if(changeCnt2 == 0){
		setbClassName1();
	}else{
		setbClassName2();
	}
	if(changeCnt3 == 0){
		setcClassName1();
	}else{
		setcClassName2();
	}
	if(changeCnt4 == 0){
		setdClassName1();
	}else{
		setdClassName2();
	}
	if(changeCnt5 == 0){
		seteClassName1();
	}else{
		seteClassName2();
	}
	
	if(cameChangeCnt == 0){
		setcameClassName1();
	}else{
		setcameClassName2();
	}
	
	if(cameVdoChangeCnt == 0){
		setcameVdoClassName1();
	}else{
		setcameVdoClassName2();
	}
	if(readChangeCnt == 0){
		setreadClassName1();
	}else{
		setreadClassName2();
	}
	
	if(alertChangeCnt == 0){
		setalertClassName1();
	}else{
		setalertClassName2();
	}
	
	//실시간 녹화 정상 유무 0: 정상, 1: 비정상
	//if(bVdoFileYn == 0){
	//	bVdoFileYnClass1();
	//}else{
	//	bVdoFileYnClass2();
	//}
	
	//날짜 기본 셋팅
	var date = new Date();
	var year = date.getFullYear().toString();
	var today = "";

	var month = date.getMonth() + 1;
	month = month < 10 ? '0' + month.toString() : month.toString();

	var day = date.getDate();
	day = day < 10 ? '0' + day.toString() : day.toString();

	var hour = date.getHours();
	hour = hour < 10 ? '0' + hour.toString() : hour.toString();

	var minites = date.getMinutes();
	minites = minites < 10 ? '0' + minites.toString() : minites.toString();

	var seconds = date.getSeconds();
	seconds = seconds < 10 ? '0' + seconds.toString() : seconds.toString();

	today = year + "-" + month + "-" + day + " " + hour + ":" + minites;

	if($("#operDate_time").val() == ""){
		$("#operDate_time").val(today);
	}
	if($("#operPopDate_time").val() == ""){
		$("#operPopDate_time").val($("#operDate_time").val());
	}
	
});	
	function setaClassName1() {
		  $('#afac').attr('class','ico_signal');	  
		}
	function setaClassName2() {
		  $('#afac').attr('class','ico_signal on');
		}
	function setbClassName1() {
		  $('#bfac').attr('class','ico_signal');	  
		}
	function setbClassName2() {
		  $('#bfac').attr('class','ico_signal on');
		}
	function setcClassName1() {
		  $('#cfac').attr('class','ico_signal');	  
		}
	function setcClassName2() {
		  $('#cfac').attr('class','ico_signal on');
		}
	function setdClassName1() {
		  $('#dfac').attr('class','ico_signal');	  
		}
	function setdClassName2() {
		  $('#dfac').attr('class','ico_signal on');
		}
	function seteClassName1() {
		  $('#efac').attr('class','ico_signal');	  
		}
	function seteClassName2() {
		  $('#efac').attr('class','ico_signal on');
		}
	function setcameClassName1() {
		  $('#cameFac').attr('class','ico_signal');	  
		}
	function setcameClassName2() {
		  $('#cameFac').attr('class','ico_signal on');
		}
	function setcameVdoClassName1() {
		  $('#cameVdoFac').attr('class','ico_signal');	  
		}
	function setcameVdoClassName2() {
		  $('#cameVdoFac').attr('class','ico_signal on');
		}
	
	function setreadClassName1() {
		  $('#readFac').attr('class','ico_signal');	  
		}
	function setreadClassName2() {
		  $('#readFac').attr('class','ico_signal on');
		}
	
	function setalertClassName1() {
		  $('#alertFac').attr('class','ico_signal');	  
		}
	function setalertClassName2() {
		  $('#alertFac').attr('class','ico_signal on');
		}
	
	//실시간 녹화 상태
	//function bVdoFileYnClass1() {
	//	  $('#bVdoFileYn').attr('class','ico_signal');	  
	//	}
	//function bVdoFileYnClass2() {
		//  $('#bVdoFileYn').attr('class','ico_signal on');
	//	}
	
	
	function btnOnClick() {
		//var date = $("#operDate_time").val(todayStart);
		var date = $("#operDate_time").val();
		location.href = "/check/operation_view_Date?date="+date;
	}
	
	function btnOnClick2() {
        var date = $("#operPopDate_time").val();
		var str = "";
			$.ajax({
				url : "operation_view_modal",
				data:{"date":date},
				type : "POST",
				datatype : "json",
				success : function(data) {
					/*** 통합제어장치 ***/
					//CPU
					str = data.result3[0].aCpuUseQnt+"%";
					$("#cpu_txt_per").html(str);
					//RAM
					str = data.result3[0].aRamUsrQnt+"%";
					$("#ram_txt_per").html(str);
					//HDD
					str = data.result3[0].aHddUseQnt+"%";
					$("#hdd_txt_per").html(str);
					//ProgressBar
					$("#control01").html("");
					$("#control01").ProgressBarWars({porcentaje:data.result3[0].aCpuUseQnt});
					$("#control02").html("");
					$("#control02").ProgressBarWars({porcentaje:data.result3[0].aRamUsrQnt});
					$("#control03").html("");
					$("#control03").ProgressBarWars({porcentaje:data.result3[0].aHddUseQnt});
					
					/*** 녹화장치 ***/
					//CPU
					str = data.result3[0].bCpuUseQnt+"%";
					$("#reco_cpu_txt_per").html(str);
					//RAM
					str = data.result3[0].bRamUsrQnt+"%";
					$("#reco_ram_txt_per").html(str);
					//HDD
					str = data.result3[0].bHddUseQnt+"%";
					$("#reco_hdd_txt_per").html(str);
					//ProgressBar
					$("#recoding01").html("");
					$("#recoding01").ProgressBarWars({porcentaje:data.result3[0].bCpuUseQnt});
					$("#recoding02").html("");
					$("#recoding02").ProgressBarWars({porcentaje:data.result3[0].bRamUsrQnt});
					$("#recoding03").html("");
					$("#recoding03").ProgressBarWars({porcentaje:data.result3[0].bHddUseQnt});
					
					str = data.result3[0].bHddUseQnt2+"%";
					$("#reco_hdd_txt_per2").html(str);
					$("#recoding04").html("");
					$("#recoding04").ProgressBarWars({porcentaje:data.result3[0].bHddUseQnt2});
					
					str = data.result3[0].bHddUseQnt3+"%";
					$("#reco_hdd_txt_per3").html(str);
					$("#recoding04").html("");
					$("#recoding04").ProgressBarWars({porcentaje:data.result3[0].bHddUseQnt3});

					
					//녹화상태
					//if(data.result3[0].bVdoFileYn == 0){
						//bVdoFileYnClass1();
					//}else{
						//bVdoFileYnClass2();
					//}
					
					/*** 카메라 ***/
					str = data.result2[0].ccheck2 + " / " +  data.result[0].ccnt;
					$("#cameCheck").html(str);
					if(data.cameCnt == 0){
						setcameClassName1();
					}else{
						setcameClassName2();
					}
					str = data.result2[0].vdoFileCHECK + " / " +  data.result[0].ccnt;
					$("#cameVdoCheck").html(str);
					if(data.result2[0].vdoFileCHECK == 0){
						setcameVdoClassName1();
					}else{
						setcameVdoClassName2();
					}					
					
					var cameraList;
					var cameraVdoList;
					var li;
					var textNode;
					var	cnt;
					//초기화
					$("#camList").empty();
					cnt = data.result2[0].ccheck2;
					cameraList = document.getElementById('camList');
					for(var i=0;i<cnt;i++){
						li = document.createElement("li");
						li.appendChild(document.createTextNode(data.cameraJson[i].fcl_NM));
						cameraList.appendChild(li);
					}
					
					
					//초기화
					$("#camVdoList").empty();
					cnt = data.result2[0].vdoFileCHECK;
					cameraVdoList = document.getElementById('camVdoList');
					for(var i=0;i<cnt;i++){
						li = document.createElement("li");
						li.appendChild(document.createTextNode(data.camVdo[i].fcl_NM));
						camVdoList.appendChild(li);
					}
					
					
					/*** 출입리더기 ***/
					str = data.result2[0].dcheck + " / " +  data.result[0].dcnt;
					$("#readCheck").html(str);
					if(data.result2[0].dcheck == 0){
						setreadClassName1();
					}else{
						setreadClassName2();
					}
					//초기화
					$("#readList").empty();
					cnt = data.result2[0].dcheck;
					cameraList = document.getElementById('readList');
					for(var i=0;i<cnt;i++){
						li = document.createElement("li");
						li.appendChild(document.createTextNode(data.reader[i].fcl_NM));
						cameraList.appendChild(li);
					}
					
					/*** 경보주장치 ***/
					str = data.result2[0].echeck + " / " +  data.result[0].ecnt;
					$("#alertCheck").html(str);
					if(data.result2[0].echeck == 0){
						setalertClassName1();
					}else{
						setalertClassName2();
					}
					//초기화
					$("#alertList").empty();
					cnt = data.result2[0].echeck;
					cameraList = document.getElementById('alertList');
					for(var i=0;i<cnt;i++){
						li = document.createElement("li");
						li.appendChild(document.createTextNode(data.alter[i].fcl_NM));
						cameraList.appendChild(li);
					}
					
				},
				error : function() {
					//alert("에러");
				}
			});
		
	}
	
	function btnReportOnClick() {
    	var date = $("#operDate_time").val();
		location.href = "/check/download?date="+date;
	}
	
	function btnReportOnClick1_2() {
    	var date = $("#operDate_time").val();
		location.href = "/check/download3?date="+date;
	}
	
	function btnReportOnClick2() {
    	var date = $("#operPopDate_time").val();
		location.href = "/check/download3?date="+date;
	}
	
	//에러난 카메라 갯수만큼 모달에서 보여주기 
	function addList() {
		//초기화
		$("#camList").empty();
		$("#camVdoList").empty();
		$("#readList").empty();
		$("#alertList").empty();
		
		var li, li2, li3;
		var D = [];
		var D2 = [];
		var	cnt;
		var s;
		var s2;
		
		//카메라
		cnt = "${cameCnt}"
		var cameraList = document.getElementById('camList');
		
		<c:forEach items="${cameraJson}" var="d_list">
		  s = '${d_list.fcl_NM}'
	      D.push(s);
	    </c:forEach>
		
		for(var i=0;i<cnt;i++){
			li = document.createElement("li");
			li.appendChild(document.createTextNode(D[i]));
			cameraList.appendChild(li);
		}
		
		cnt = "${camVdoCnt}"
		var cameraVdoList = document.getElementById('camVdoList');
		<c:forEach items="${camVdo}" var="d_list">
			 s2 = '${d_list.fcl_NM}'
		     D2.push(s2);
		</c:forEach>
		
			for(var i=0;i<cnt;i++){
				li = document.createElement("li");
				li.appendChild(document.createTextNode(D2[i]));
				cameraVdoList.appendChild(li);
			}
		
		//초기화
		D = [];
		s="";
		//출입리더기
		cnt = "${readerCnt}"
		var readList = document.getElementById('readList');
		
		<c:forEach items="${reader}" var="d_list">
			  s = '${d_list.fcl_NM}'
		      D.push(s);
		   </c:forEach>
			
			for(var i=0;i<cnt;i++){
				li2 = document.createElement("li");
				li2.appendChild(document.createTextNode(D[i]));
				readList.appendChild(li2);
			}
		
		//초기화
		D = [];
		s="";
		//경보주장치
		cnt = "${alterCnt}"
		var alertList = document.getElementById('alertList');
		
		<c:forEach items="${alter}" var="d_list">
			  s = '${d_list.fcl_NM}'
			  D.push(s);
		</c:forEach>
				
			for(var i=0;i<cnt;i++){
				li3 = document.createElement("li");
				li3.appendChild(document.createTextNode(D[i]));
				alertList.appendChild(li3);
			}	
		
	}
	
</script>
<%@ include file="/WEB-INF/views/include/subBottom.jsp"%>
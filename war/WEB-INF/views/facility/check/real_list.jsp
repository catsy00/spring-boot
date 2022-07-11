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

	<div id="div_load_image" style="position: absolute; top: 50%; left: 47%; width: 0px; height: 0px; z-index: 9999; background: #f0f0f0; filter: alpha(opacity = 50); opacity: alpha*0.5; margin: auto; padding: 0; text-align: center">
		<img src="/static/images/loading2.gif" style="width: 80px; height: 80px;">
	</div>

	<!--subConTop-->
	<div class="subConTop">
		<h2>실시간 장애 감시 모니터링</h2>
		<div class="subTabBox">
			<div class="left">
				<ul class="tabMenu1 List2">
					<li><a href="/check/operation_list">관리운용현황</a></li>
					<li class="on"><a href="#">실시간 장애 감시</a></li>
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
		<div class="realSearch">
			<form id="frm" name="frm" method="POST">
				<!-- 사용자별선택 지사 출력-->
				<span class="mTit">직할</span> <span class="sTit">변전소</span> <select class="comSelectBL" id="pss_cd" name="pss_cd">
					<option value=0000>전체</option>
					<option value="D368">금천</option>
					<option value="S636">송정</option>
				</select> <span class="sTit">설비</span> <select class="comSelectBL" id="fcl_cl_cd" name="fcl_cl_cd">
					<option value="00">전체</option>
					<option value="01">통합제어장치</option>
					<option value="02">녹화장치</option>
					<option value="03">카메라</option>
					<option value="04">출입리더기</option>
					<option value="05">경보주장치</option>
				</select> <span class="sTit">상태</span> <select class="comSelectBL" id="check_cd" name="check_cd">
					<option value="3">전체</option>
					<option value="0">정상</option>
					<option value="1">비정상</option>
				</select> <input type="text" id="startDate_list" name="startDate_list" class="dateSelect2" title="시작 날짜선택" readonly /> <span class="txt_date">~</span> <input type="text" id="endDate_list" name="endDate_list" class="dateSelect2" title="종료 날짜선택" readonly />
				<button type="button" class="btn_search" id="btn_search" onclick="btnOnClick()"></button>
			</form>
		</div>

		<!--//realSearch-->
		<a href="#realView" class="realView btn_realview hide">모달창띄우기</a>
		<!--realList-->
		<div class="realList3">
			<table class="tableS1 fixtable text-center" summary="실시간 장애 감시리스트 : 장애설비번호, 발생시간, 전력지사, 변전소, 설비, 설치장소, 상태, 원인 에 대한 안내입니다">
				<caption>실시간 장애 감시리스트 : 순번, 장애설비번호, 발생시간, 전력지사, 변전소, 설비, 설치장소, 상태, 원인 에 대한 안내입니다</caption>
				<colgroup>
					<col style="width: 50px">
					<col style="width: 150px">
					<col style="width: 150px">
					<col style="width: 150px">
					<col style="width: 80px">
					<col style="width: 100px">
					<col style="width: 150px">
					<col style="width: 120px">
					<col style="width: auto">
				</colgroup>
				<thead>
					<tr>
						<th scope="col">순번</th>
						<th scope="col">장애설비번호</th>
						<th scope="col">발생시간</th>
						<th scope="col">전력지사</th>
						<th scope="col">변전소</th>
						<th scope="col">설비</th>
						<th scope="col">설치장소</th>
						<th scope="col">상태</th>
						<th scope="col">원인</th>
					</tr>
				</thead>
			</table>
		</div>
		<div class="realList2 scrollbar-outer" id="realList">
			<table class="tableS1 fixtable text-center" summary="실시간 장애 감시리스트 : 장애설비번호, 발생시간, 전력지사, 변전소, 설비, 설치장소, 상태, 원인 에 대한 안내입니다">
				<caption>실시간 장애 감시리스트 : 순번, 장애설비번호, 발생시간, 전력지사, 변전소, 설비, 설치장소, 상태, 원인 에 대한 안내입니다</caption>
				<colgroup>
					<col style="width: 50px">
					<col style="width: 150px">
					<col style="width: 150px">
					<col style="width: 150px">
					<col style="width: 80px">
					<col style="width: 100px">
					<col style="width: 150px">
					<col style="width: 120px">
					<col style="width: auto">
				</colgroup>
				<tbody id="realListTable">
				</tbody>
			</table>
		</div>



		<!--//realList-->
		<!--******** 장애 상세 출력 pop ********-->

		<div class="hide">
			<div id="realView" class="modal_style">
				<div class="tit">실시간 장애 감시 상세조회</div>
				<div class="con">
					<h3>설비내역</h3>
					<div>
						<table class="tableS2 fixtable text-center" summary="장애 이력 : 장애번호, 발생시간, 상태, 원인에 대한 안내입니다">
							<caption>장애 이력 : 장애번호, 발생시간, 상태, 원인에 대한 안내입니다</caption>
							<colgroup>
								<col style="width: 25%">
								<col style="width: 25%">
								<col style="width: 25%">
								<col style="width: 25%">
							</colgroup>
							<tbody id=modalInfo>
								<tr>
									<th scope="row">설비명</th>
									<td class="f-c-point">카메라 #1</td>
									<th>설치장소</th>
									<td>설치장소 출력</td>
								</tr>
								<tr>
									<th scope="row">전력지사</th>
									<td class="f-c-point">광주</td>
									<th>변전소</th>
									<td class="f-c-point">변전소명</td>
								</tr>
							</tbody>
						</table>
					</div>
					<h3 class="m-t-10">장애이력</h3>
					<div class="tableS1 text-center">
						<table class="tableS2 fixtable text-center" summary="장애 이력 : 장애번호, 발생시간, 상태, 원인에 대한 안내입니다">
							<caption>장애 이력 : 장애번호, 발생시간, 상태, 원인에 대한 안내입니다</caption>
							<colgroup>
								<col style="width: 9%">
								<col style="width: 24%">
								<col style="width: 25%">
								<col style="width: 15%">
								<col style="width: auto">
							</colgroup>
							<thead>
								<tr>
									<th scope="col">순번</th>
									<th scope="col">장애설비번호</th>
									<th scope="col">발생시간</th>
									<th scope="col">상태</th>
									<th scope="col">원인</th>
								</tr>
							</thead>
						</table>
					</div>
					<div class="listScrollBox scrollbar-inner">
						<table class="tableS1 fixtable text-center" summary="장애 이력 : 장애번호, 발생시간, 상태, 원인에 대한 안내입니다">
							<caption>장애 이력 : 장애번호, 발생시간, 상태, 원인에 대한 안내입니다</caption>
							<colgroup>
								<col style="width: 9%">
								<col style="width: 24%">
								<col style="width: 25%">
								<col style="width: 15%">
								<col style="width: auto">
							</colgroup>
							<tbody id=realDetailListTable class="text-center">
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<!--//******** 장애 상세 다운로드 출력 pop ********-->
	</div>
	<!--//subConBox-->
</body>
<script type="text/javascript">
	var pageCnt;
	var pageCnt2;
	var mId;
	var mChkDt;
	var mPowerBizpNm;
	var mPssNm;
	var mFdNm;
	var mInsPlceNm;
	var mFclClCd;
	var mPssCd;

	$(function() {

		$("#div_load_image").hide();

		var date = new Date();
		var year = date.getFullYear().toString();
		var todayStart = "";
		var todayEnd = "";

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

		todayStart = year + "-" + month + "-" + day + " " + "00" + ":" + "00";
		todayEnd = year + "-" + month + "-" + day + " " + hour + ":" + minites;

		$("#startDate_list").val(todayStart);
		$("#endDate_list").val(todayEnd);
		
		pageCnt = 1;
		selectList(pageCnt);

	});

	function btnOnClick() {
		

		$(".realList2").scrollTop(0);
		
		//테이블 초기화
		var str = '<TR><td colspan="9"></td></TR>';
		$("#realListTable").html(str);
					
		pageCnt = 1;
		selectList(pageCnt);

	}

	//모달창 띄우기 Table td 클릭
	function fdNmOnclick(id) {
		var tr = $(id).parent();
		var td = tr.children();

		//var td = tr.children(); // tr.text()는 클릭된 Row 즉 tr에 있는 모든 값을 가져온다. 
		console.log("클릭한  td Row의 모든 데이터 : " + td.text());

		mId = td.eq(1).text();
		mChkDt = td.eq(2).text();
		mPowerBizpNm = td.eq(3).text();
		mPssNm = td.eq(4).text();
		mFdNm = td.eq(5).text();
		mInsPlceNm = td.eq(6).text();
		mFclClCd = td.eq(9).text();
		mPssCd = td.eq(10).text();

		var info = '<tr>' + '<th scope="row">설비명</th>'
				+ '<td class="f-c-point">' + mFdNm + '</td>' + '<th>설치장소</th>'
				+ '<td>' + mInsPlceNm + '</td>' + '</tr><tr>'
				+ '<th scope="row">전력지사</th>' + '<td class="f-c-point">'
				+ mPowerBizpNm + '</td>' + '<th>변전소</th>'
				+ '<td class="f-c-point">' + mPssNm + '</td></tr>';

		console.log("id  : " + mId);
		console.log("chkDt  : " + mChkDt);
		console.log("powerBizpNm  : " + mPowerBizpNm);
		console.log("pssNm  : " + mPssNm);
		console.log("fdNm  : " + mFdNm);
		console.log("fclClCd  : " + mFclClCd);
		console.log("pssCd  : " + mPssCd);

		//모달창에 기본내역 셋팅
		$("#modalInfo").html(info);
		pageCnt2 = 1;
		//장애 이력 조회
		selectDetailList(mId, mChkDt, mFclClCd, mPssCd, pageCnt2);

		//모달창 띄우기
		$('a[href="#realView"]').click();
	}

	$(".realList2").scroll(function() { //스크롤이 최하단 으로 내려가면 리스트를 조회하고 page를 증가시킨다.
		var scrollTop = $(this).scrollTop();
		var innerHeight = $(this).innerHeight();
		var scrollHeight = $(this).prop('scrollHeight');
		if (pageCnt > 1 && (scrollTop + innerHeight + 1 >= scrollHeight)) {
			selectList(pageCnt);
		}

	});
	function selectList(page) {
		
		$("#div_load_image").show();

		var fcl_cl_cd = document.getElementById("fcl_cl_cd").value;
		var pss_cd = document.getElementById("pss_cd").value;
		var check_cd = document.getElementById("check_cd").value;
		var startDate = document.getElementById("startDate_list").value;
		var endDate = document.getElementById("endDate_list").value;
		var params = $("#frm").serialize();
		setTimeout(function() {
		$
				.ajax({
					url : "selectRealList",
					data : params + "&page=" + page,
					type : "POST",
					async : false,
					datatype : "json",
					success : function(data) {
						var results = data.list;
						var str = '<TR>';
						var checkYn = '';
						var totCnt;

						totCnt = data.totCnt;

						if (page == 1) { //페이지가 1일경우에만 id가 list인 html을 비운다.
							$("#realListTable").html("");
						}

						if (totCnt == 0) {
							str += '<td colspan="9">' + "장애 내역이 없습니다."
									+ '</td>'
							str += '</TR>';
							$("#realListTable").html(str);
						}

						$.each(
										results,
										function(i) {
											//정상, 비정상 구분
											if (results[i].check_yn == 1  || results[i].vdo_file_yn == 1) {
												checkYn = '<span class="state02">비정상</span>';
											} else {
												checkYn = '<span class="state01">정상</span>';
											}

											str += '<TD>'
													+ results[i].rn
													+ '</TD><TD>'
													+ results[i].id
													+ '</TD><TD>'
													+ results[i].chk_dt
													+ '</TD><TD>'
													+ results[i].power_bizp_nm
													+ '</TD>'
													+ '<TD>'
													+ results[i].pss_nm
													+ '</TD><TD onclick = "fdNmOnclick(this)" style="color:blue"> <a href="#">'
													+ results[i].fd_nm
													+ '</TD><TD>'
													+ results[i].ins_plce_nm
													+ '</TD>' + '<TD>'
													+ checkYn + '</TD><TD>'
													+ results[i].errResult
													+ '</TD><TD class="hide">'
													+ results[i].fcl_cl_cd
													+ '</TD><TD class="hide">'
													+ results[i].pss_cd
													+ '</TD>' + '</TD>'

											str += '</TR>';
										});

						if (totCnt != '0') {
							if (page == 1) { //페이지가 1이 아닐경우 데이터를 붙힌다.
								$("#realListTable").html(str);
							} else {
								$("#realListTable").append(str);
							}
						} else {
							$("#realListTable").html(str);
						}

						pageCnt = page + 1;
						//로딩바
						$("#div_load_image").hide();
					},
					error : function() {
						alert("에러")
						//로딩바
						$("#div_load_image").hide();

					}
				});
		}, 100);

	}

	//장애이력 스크롤
	$(".listScrollBox").scroll(function() { //스크롤이 최하단 으로 내려가면 리스트를 조회하고 page를 증가시킨다.
		var scrollTop = $(this).scrollTop();
		var innerHeight = $(this).innerHeight();
		var scrollHeight = $(this).prop('scrollHeight');

		if (pageCnt > 1 && (scrollTop + innerHeight + 1 >= scrollHeight)) {
			selectDetailList(mId, mChkDt, mFclClCd, mPssCd, pageCnt2);
		}

	});

	//장애이력 조회
	function selectDetailList(id, chkDt, fclClCd, pssCd, page) {
		var data = {
			id : id,
			chkDt : chkDt,
			fclClCd : fclClCd,
			page : page
		}
		$.ajax({
			url : "selectDetailList",
			data : data,
			type : "POST",
			datatype : "json",
			success : function(data) {
				
				var results = data.list;
				var str = '<TR>';
				var totCnt = 0;
				var checkYn = '';

				totCnt = data.totCnt;

				$.each(results, function(i) {
					if (results[i].check_yn == 1 || results[i].vdo_file_yn == 1) {
						checkYn = '<span class="state02_s">비정상</span>';
					} else {
						checkYn = '<span class="state01_s">정상</span>';
					}
					str += '<TD>' + results[i].rn
							+ '</TD><td class="f-c-blue">' + results[i].id
							+ '</TD><TD>' + results[i].chk_dt + '</TD><TD>'
							+ checkYn + '</TD>' + ' <td>'
							+ results[i].errResult + '</td>'
					str += '</TR>';
				});

				if (totCnt != 0) {
					if (page == 1) { //페이지가 1이 아닐경우 데이터를 붙힌다.
						$("#realDetailListTable").html(str);
					} else {
						$("#realDetailListTable").append(str);
					}
				} else {
					str += '<td colspan="5">' + "장애 내역이 없습니다." + '</td>'
					str += '</TR>';
					$("#realDetailListTable").html(str);
				}

				pageCnt2 = page + 1;

			},
			error : function() {
				alert("에러");
			}
		});
	}
	//엑셀다운로드
	function btnReportOnClick() {
    	var date = $("#endDate_list").val();
		location.href = "/check/download?date="+date;
	}
	
	function btnReportOnClick1_2() {
    	var date = $("#endDate_list").val();
		location.href = "/check/download3?date="+date;
	}
</script>

<%@ include file="/WEB-INF/views/include/subBottom.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<%@ include file="WEB-INF/views/include/subTop.jsp" %>
</head>
<body>
	<!--subConTop-->
			<div class="subConTop">
				<h2>실시간 장애 감시 모니터링</h2>
				<div class="subTabBox">
					<div class="left">
						<ul class="tabMenu1 List2">
							<li class="on"><a href="#">실시간 장애 감시</a></li>
							<li><a href="operation_list.jsp">권리운용현황</a></li>
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
										<a href="#" class="btn_report">광주전남본부 점검보고서 <i></i></a>
									</div>
									<div class="conBottom">
										<!--전력지사명 출력-->
										<div class="stit">광주전력지사</div>
										<ul class="downList">
											<!--변전소 출력 반복-->
											<li>
												<span class="txt">변전소명</span>
												<a href="#" class="btn_down">다운로드 <i></i></a>
											</li>
											<!--//변전소 출력 반복-->
											<li>
												<span class="txt">변전소명</span>
												<a href="#" class="btn_down">다운로드 <i></i></a>
											</li>
											<li>
												<span class="txt">변전소명</span>
												<a href="#" class="btn_down">다운로드 <i></i></a>
											</li>
											<li>
												<span class="txt">변전소명</span>
												<a href="#" class="btn_down">다운로드 <i></i></a>
											</li>
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
					<!-- 사용자별선택 지사 출력-->
					<span class="mTit">광주전력지사</span>
					<span class="sTit">변전소</span>
					<select class="comSelectBL">
						<option>선택</option>
						<option value="">변전소명</option>
						<option value="">변전소명</option>
					</select>
					<span class="sTit">설비</span>
					<select class="comSelectBL">
						<option>선택</option>
						<option value="">통합제어장치</option>
						<option value="">녹화장치</option>
						<option value="">카메라</option>
						<option value="">출입리더기</option>
						<option value="">경보주장치</option>
					</select>
					<span class="sTit">상태</span>
					<select class="comSelectBL">
						<option>선택</option>
						<option value="">등록</option>
						<option value="">장애신청</option>
						<option value="">종료</option>
					</select>
					<input type="datetime" id="startDate" class="dateSelect" title="시작 날짜선택"/>
					<span class="txt_date">~</span>
					<input type="datetime" id="endDate" class="dateSelect" title="종료 날짜선택"/>
					<button type="button" class="btn_search">검색</button>
				</div>
				<!--//realSearch-->
				<!--realList-->
				<div class="realList">
					<table class="tableS1 fixtable text-center" summary="실시간 장애 감시리스트 : 장애번호, 발생시간, 전력지사, 변전소, 설비, 설치장소, 상태, 원인 에 대한 안내입니다">
						<caption>
							실시간 장애 감시리스트 : 장애번호, 발생시간, 전력지사, 변전소, 설비, 설치장소, 상태, 원인 에 대한 안내입니다
						</caption>
						<colgroup>
						<col style="width:13%">
						<col style="width:13%">
						<col style="width:10%">
						<col style="width:10%">
						<col style="width:10%">
						<col style="width:10%">
						<col style="width:10%">
						<col style="width:auto">
						</colgroup>
						<thead>
							<tr>
								<th scope="col">장애번호</th>
								<th scope="col">발생시간</th>
								<th scope="col">전력지사</th>
								<th scope="col">변전소</th>
								<th scope="col">설비</th>
								<th scope="col">설치장소</th>
								<th scope="col">상태</th>
								<th scope="col">원인</th>
							</tr>
						</thead>
						<tbody>
							<!--리스트 내역 없을때-->
							<tr>
								<td colspan="8">장애 내역이 없습니다.</td>
							</tr>
							<!--리스트 내역 없을때-->
							<!--리스트 반복 **상태 state01/state02/state03-->
							<tr>
								<td class="f-c-blue">2022012-0001</td>
								<td>2021-01-12 08:40</td>
								<td>광주</td>
								<td>담양</td>
								<td><a href="#realView" class="realView btn_realview">카메라 #1</a></td>
								<td class="ellipsis">설치 장소 설치 장소</td>
								<td><span class="state01">등록</span></td>
								<td class="text-left">영상 스트리밍 이상</td>
							</tr>
							<!--//리스트 반복-->
							<tr>
								<td class="f-c-blue">2022012-0001</td>
								<td>2021-01-12 08:40</td>
								<td>강진</td>
								<td>완도</td>
								<td><a href="#realView" class="realView btn_realview">카메라 #1</a></td>
								<td class="ellipsis">설치 장소 설치 장소</td>
								<td><span class="state02">장애신청</span></td>
								<td class="text-left">영상 스트리밍 이상</td>
							</tr>
							<tr>
								<td class="f-c-blue">2022012-0001</td>
								<td>2021-01-12 08:40</td>
								<td>강진</td>
								<td>완도</td>
								<td><a href="#realView" class="realView btn_realview">카메라 #1</a></td>
								<td class="ellipsis">설치 장소 설치 장소</td>
								<td><span class="state03">종료</span></td>
								<td class="text-left">영상 스트리밍 이상</td>
							</tr>
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
									<caption>
										장애 이력 : 장애번호, 발생시간, 상태, 원인에 대한 안내입니다
									</caption>
									<colgroup>
									<col style="width:25%">
									<col style="width:25%">
									<col style="width:25%">
									<col style="width:25%">
									</colgroup>
									<tbody>
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
							<div class="listScrollBox scrollbar-inner">
								<table class="tableS1 fixtable text-center" summary="장애 이력 : 장애번호, 발생시간, 상태, 원인에 대한 안내입니다">
									<caption>
										장애 이력 : 장애번호, 발생시간, 상태, 원인에 대한 안내입니다
									</caption>
									<colgroup>
									<col style="width:20%">
									<col style="width:30%">
									<col style="width:20%">
									<col style="width:auto">
									</colgroup>
									<thead>
										<tr>
											<th scope="col">장애번호</th>
											<th scope="col">발생시간</th>								
											<th scope="col">상태</th>
											<th scope="col">원인</th>
										</tr>
									</thead>
									<tbody>
										<!--리스트 내역 없을때-->
										<tr>
											<td colspan="4">장애 내역이 없습니다.</td>
										</tr>
										<!--리스트 내역 없을때-->
										<!--리스트 반복 상태 state01_s/ state02_s / state03_s-->
										<tr>
											<td class="f-c-blue">2022012-0001</td>
											<td>2021-01-12 08:40</td>									
											<td><span class="state01_s">등록</span></td>
											<td class="text-left">영상 스트리밍 이상</td>
										</tr>
										<!--//리스트 반복-->
										<tr>
											<td class="f-c-blue">2022012-0001</td>
											<td>2021-01-12 08:40</td>
											<td><span class="state02_s">장애신청</span></td>
											<td class="text-left">영상 스트리밍 이상</td>
										</tr>
										<tr>
											<td class="f-c-blue">2022012-0001</td>
											<td>2021-01-12 08:40</td>
											<td><span class="state03_s">종료</span></td>
											<td class="text-left">영상 스트리밍 이상</td>
										</tr>
										<tr>
											<td class="f-c-blue">2022012-0001</td>
											<td>2021-01-12 08:40</td>
											<td><span class="state01_s">등록</span></td>
											<td class="text-left">네트워크 이상</td>
										</tr>
										<tr>
											<td class="f-c-blue">2022012-0001</td>
											<td>2021-01-12 08:40</td>
											<td><span class="state01_s">등록</span></td>
											<td class="text-left">네트워크 이상</td>
										</tr>
									</tbody>
								</table>	
							</div>
						</div>
					</div>
				</div>	
				<!--//******** 장애 상세 다운로드 출력 pop ********-->
				<!--pagination-->
				<div class="pagination4">
					<span class="firstPage">첫페이지</span>
					<span class="preBlock">이전</span>
					<a href="#" title="1페이지 이동">1</a>
					<a href="#" title="2페이지 이동">2</a>
					<a href="#" title="3페이지 이동">3</a>
					<a href="#" title="4페이지 이동">4</a>
					<strong>5</strong> 
					<span class="nextBlock">다음</span>
					<span class="lastPage">마지막페이지</span>
				</div>
				<!--//pagination-->
			</div>
			<!--//subConBox-->
</body>
<script type="text/javascript">
	$(document).ready(function(){
	});
</script>			
<%@ include file="WEB-INF/views/include/subBottom.jsp" %>
	
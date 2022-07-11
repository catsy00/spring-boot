<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="short icon" href="#">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/basic.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/fonts.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/layout.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/main_content.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/sub_contents.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/mem_contents.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/styleGuide.css">


<script src="/static/vendor/jquery/jquery-3.6.0.min.js"></script>

<link rel="stylesheet" type="text/css" href="/static/vendor/datetimepicker/jquery.datetimepicker.css" />
<script src="/static/vendor/datetimepicker/jquery.js"></script>
<script src="/static/vendor/datetimepicker/build/jquery.datetimepicker.full.min.js"></script>

<!--벤더프리픽스-->
<script src="/static/vendor/prefixfree/prefixfree.dynamic-dom.min.js" type="text/javascript"></script>
<!--공통 js-->
<script src="/static/js/common/designLayout.js"></script>
<!--scrollbar-->
<link rel="stylesheet" href="/static/vendor/scrollbar/jquery.scrollbar.css" />
<script src="/static/vendor/scrollbar/jquery.scrollbar.min.js"></script>
<!--모달-->
<link rel="stylesheet" href="/static/vendor/colorbox/colorbox.css" />
<script src="/static/vendor/colorbox/jquery.colorbox.js"></script>
<!--달력-->
<link rel="stylesheet" href="/static/vendor/jqueryui/jquery-ui.css" />
<script src="/static/vendor/jqueryui/jquery-ui.js"></script>
</head>
<body>
	<!-- join -->
	<div id="wrap">
		<div class="joinWap">
			<div class="joinIn">
				<!--joinCon-->
				<div class="joinCon">
					<div class="joinTit">
						<h1>
							<i></i><span>무인보안시스템</span><span>설비점검 효율화</span>
						</h1>
						<h2>회원가입</h2>
					</div>
					<!-- form -->
					<form:form role="form" commandName="registerRequest" action="${pageContext.request.contextPath }/joinup/step3" method="post">
						<div class="txt_join">아래의 가입 정보를 입력후 회원가입버튼을 눌러 주세요.</div>
						<div class="inputBox">
							<label for="id">아이디</label> <input type="text" class="id_input" path="id" name="id" placeholder="아이디를 입력하세요.(사번형태 숫자 8자)" />
							<form:errors path="id" class="signup-errors" />
						</div>
						<div class="inputBox">
							<label for="password">비밀번호</label> <input type="password" path="password" name="password" placeholder="비밀번호를 입력하세요." />
							<form:errors path="password" class="signup-errors" />
						</div>
						<div class="inputBox">
							<label for="checkPassword">비밀번호 확인</label> <input type="password" path="checkPassword" name="checkPassword" placeholder="비밀번호를 입력하세요." />
							<form:errors path="checkPassword" class="signup-errors" />
						</div>
						<div class="inputBox">
							<label for="name">이름</label> <input type="text" path="name" name="name" placeholder="이름을 입력하세요." />
							<form:errors path="name" class="signup-errors" />
						</div>
						<div class="inputBox">
							<label for="email">이메일</label> <input type="text" path="email" name="email" placeholder="이메일을 입력하세요." />
							<form:errors path="email" class="signup-errors" />
						</div>
						<div class="stitBox">
							<h4>
								전력지사 선택
								</h4>
						</div>
						<div class="sconBox">
							<div class="top">
								<select class="comSelectBL" name="hdqrCd" path="hdqrCd">
									<option value="2461">광주전남본부직할</option>
								</select>
							</div>
							<!--전력지사 선택 후 출력-->

							<!--//전력지사 선택 후 출력-->
						</div>
						<!-- <button type="submit" class="btn_join">회원가입</button> -->
						<button type="submit" class="btn_join">회원가입</button>
					</form:form>
					<!-- //form -->
				</div>
				<!--//joinCon-->
			</div>
			<!--//footer-->
		</div>
		<!-- //join -->
		<footer id="footer">
		<div class="footerIn">
			<div class="footText">COPYRIGHT ⓒ KEPCO All rights reserved.</div>
			<div class="footQna">
				<span class="txt_tit">업무문의</span> <span class="txt_depart">부서명</span><span class="txt_tel">061-1234</span>
			</div>
			<div class="footQna m-l-125">
				<span class="txt_tit">시스템문의</span> <span class="txt_depart">부서명</span><span class="txt_tel">061-1234</span>
			</div>
		</div>
		</footer>
	</div>
</body>
<script type="text/javascript">
$(function() {

	
});

function fnLogin() {

		var memberId = $('.id_input').val(); // .id_input에 입력되는 값
		var data = {
			memberId : memberId
		} // '컨트롤에 넘길 데이터 이름' : '데이터(.id_input에 입력되는 값)'

		$.ajax({
			type : "post",
			url : "/joinup/memberIdChk",
			data : data,
			success : function(data) {
				if (data >= 1) {
					alert("이미 사용중인 아이디입니다.");
				} else {
					alert("사용가능한 아이디입니다.")
				}
			}
		});

	}
</script>
</html>

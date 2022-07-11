<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%@ include file="/WEB-INF/views/include/top.jsp" %>
    <title>Sign In | todyDev</title>
</head>
<body>
<!-- login -->
	<div class="loginWap">
		<div class="loginIn">
			<!-- form -->
			
				<h1 class="blind">로그인</h1>
				<!-- loginCon -->
				<section class="loginCon">
					<h2>무인보안시스템 설비 점검 효율화</h2>
					<form:form role="form" commandName="loginCommand" action="${pageContext.request.contextPath }/loginIn" method="post">	
						<div class="inputBox">
							<label for="userId" class="ico_id">아이디</label>
							<input type="text" id="id" name="id" placeholder="아이디를 입력하세요. " path="id"/>
							<form:errors path="id" class="signup-errors" />
						</div>
						<div class="inputBox">
							<label for="userPwd" class="ico_pw">비밀번호</label>
							<input type="password" id="password" name="password" placeholder="비밀번호를 입력하세요." path="password" />
							<form:errors path="password" class="signup-errors" />
						</div>	
						
						<button type="submit" class="btn_login">로그인</button>
					</form:form>
				</section>
				
				<!-- //loginCon -->	
				<!-- joinCon -->
					<form action="/joinup/join" method="post">
					<section class="joinCon">
						<span>아이디가 없다면 회원가입을 진행해주세요.</span>
						<button type="submit" class="btn_join">회원가입</button>
					</section>
				</form>
				<!-- //joinCon -->	
			<!--// form -->
		</div>
	</div>
	<!-- //login --> 
</body>
<%@ include file="/WEB-INF/views/include/footer.jsp" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="WEB-INF/views/include/top.jsp" %>

<!-- error_wrap -->
	<div id="error_wrap">        	
		<div class="errorIn">
			<h1 class="errorTit">5<span class="error0">0</span>0</h1> 	
			<p class="errorTxt">내부서버 오류가 발생했습니다. 잠시 후 다시 이용 부탁드립니다.</p>
			<a href='#' onclick='history.back(-1); return false;' class="btnPrePage"><span class="txt">이전 페이지로 이동</span> <span class="ti-angle-right"></span></a>
		</div>
	</div>
	<!-- //error_wrap -->

<%@ include file="WEB-INF/views/include/footer.jsp" %>

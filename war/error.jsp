<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="WEB-INF/views/include/top.jsp" %>

<!-- error_wrap -->
	<div id="error_wrap">        	
		<div class="errorIn">
			<h1 class="errorTit">Err<span class="error0">o</span>r</h1> 	
			<p class="errorTxt">Error가 발생했습니다.</p>
			<a href='#' onclick='history.back(-1); return false;' class="btnPrePage"><span class="txt">이전 페이지로 이동</span> <span class="ti-angle-right"></span></a>
		</div>
	</div>
	<!-- //error_wrap -->

<%@ include file="WEB-INF/views/include/footer.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/views/common/header.jsp" %>
	<section id="content">
		<h2 align="center" style="margin-top:200px;">안녕하세요, MVC입니다.</h2>
	</section>
	<script>
		const fn_updatePassword=()=>{
			//새창으로 패스워드 수정페이지 연결
			open("<%=request.getContextPath()%>/member.updatePassword.do/");
		}
	</script>
<%@ include file="/views/common/footer.jsp" %>

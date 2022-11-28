<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.web.member.model.vo.Member" %>
<%
	Member loginMember=(Member)session.getAttribute("loginMember");
	Cookie[] cookies=request.getCookies();
	String saveId=null;
	if(cookies!=null) {
		for(Cookie c : cookies){
			if(c.getName().equals("saveId")){
				saveId=c.getValue();
				break;
			}
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello MVC 프로젝트</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style.css">
<script src="<%= request.getContextPath()%>/js/jquery-3.6.1.min.js"></script>
</head>
<body>
	<div id="container">
		<header>
			<h1>Hello MVC</h1>
			<div class="login-container">
			<%if(loginMember==null) {%>
				<form action="<%=request.getContextPath() %>/login.do" method="post" id="loginFrm">
					<table>
						<tr>
							<td>
								<input type="text" name="userId" id="userId"
								placeholder="아이디입력" value="<%=saveId!=null?saveId:""%>",<%=saveId==null?"":saveId %>">
							</td>
						</tr>
						<tr>
							<td>
								<input type="password" name="password" id="password" placeholder="비밀번호">
							</td>
							<td>
								<input type="submit" value="로그인"> 
							</td>
						</tr>
						<tr>
							<td>
								<input type="checkbox" name="saveId" id="saveId" 
								<%=saveId!=null?"checked":"" %>
								 >
								<label for="saveId">아이디저장</label>
								<input type="button" value="회원가입" 
								onclick="location.assign('<%=request.getContextPath()%>/member/enrollMember.do');">
							</td>
						</tr>
					</table>
				</form>
				<%}else{ %>
					<table id="logged-in">
						<tr>
							<td colspan="2">
								<%=loginMember.getUserName() %>님, 환영합니다.
							</td>
						</tr>
						<tr>
							<td>
								<input type="button" value="내 정보보기"
								onclick="location.replace('<%=request.getContextPath()%>/member/memberView.do?id=<%=loginMember.getUserId()%>')">
							</td>
							<td>
								<input type="button" value="로그아웃"
								onclick="location.replace('<%=request.getContextPath()%>/logout.do');">
							</td>
						</tr>
					</table>
				<%} %>
			</div>
			<nav>
				<ul class="main-nav">
					<li class="home"><a href="">Home</a></li>
					<li id="notice"><a href="">Notice</a></li>
					<li id="board"><a href="">Board</a></li>
					<li id="gallray"><a href="">Gallary</a></li>
				</ul>
			</nav>
		</header>
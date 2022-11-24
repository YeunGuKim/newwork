<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				<form action="<%=request.getContextPath() %>/login.do" method="post" id="loginFrm">
					<table>
						<tr>
							<td>
								<input type="text" name="userId" id="userId" placeholder="아이디입력">
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
								<input type="checkbox" name="saveId" id="saveId" >
								<label for="saveId">아이디저장</label>
								<input type="button" value="회원가입">
							</td>
						</tr>
					</table>
				</form>
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
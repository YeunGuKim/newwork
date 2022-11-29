<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test</title>
<style>	
	body{
		font-family:"휴먼모음T";
	}
	
	div,section,header,footer{padding:10px;}
	
	div#container{
		background-color:#F0F0F0;
		width:100%;
		margin:0 auto;
	}
	
	header{
		background-color:coral;
		height:130px;
		position:relative;
		padding:10px 0 0 0;
	}
	header h1{
		margin-left : 10px;
	}
	
	section#content{
		background-color:#F5F5F5;
		float:left;
		width:100%;
		min-height:500px;
	}
	
	footer{
		background-color:#00BCD4;
		clear:both;
		height:75px;
		text-align:center;
		padding-top:40px;
	}

	/* 로그인컨테이너 */
	header div.login-container{width:250px; position:absolute; right: 0px; top: 10px;}

	#loginFrm table{empty-cells:hide;}
	#loginFrm input[type=submit]{width:60px; height:50px; color:white; background:cornflowerblue; position:absolute; top:10px;}
	#loginFrm input[type=button]{background:cornflowerblue;}
	#saveId+label{font-size:12px;font-family:'고딕'}
	
	/* 메뉴관련스타일 */
	header nav {background:#5283de; width:100%; margin-top:40px;}
	
	/* ul태그의 가운데정렬 */
	ul.main-nav{
		/* width:80%; */
		display:table;
		padding:0px;
		margin:auto;
	}
	ul.main-nav li { 
		list-style-type: none; 
		width: 8em; 
		height: 2em;
		float: left; 
		text-align: center; 
		font-family: "휴먼모음T", sans-serif; 
		border-left: 1px #00bcd4 solid;
		background-color: #5283de; 
	}
	ul.main-nav li:last-of-type{border-right:1px #00bcd4 solid;;}
	ul.main-nav li a {
		display: block;
		padding:.5em;
		text-decoration: none;
		color: #292929;
	}
	
	/* hover시 배경색 변경 */
	ul.main-nav li:hover{
		background-color: #3300ff;
	}
	ul.main-nav li:hover > a{
		color:#FFF; /* 글자색*/
	}
	section#enroll-container {text-align:center;}
    section#enroll-container input{margin:3px;}
    section#enroll-container table{margin:0 auto;}
    section#enroll-container table th {padding:0 10px; text-align:right;}
    section#enroll-container table td {padding:0 10px; text-align:left;}
</style>
</head>
<body>
	<div id="container">
		<header>
			<h1>UI디자인</h1>
			<div class="login-container">
				<form action="<%=request.getContextPath() %>/member/memberenroll.do" method="post" id="loginFrm">
					<table>
						<tr>
							<td>
								<input type="text" name="userId" id="userId"
								placeholder="아이디입력">
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
								<input type="button" value="회원가입" 
								onclick="location.assign('<%=request.getContextPath()%>/memberenroll.do');">
							</td>
						</tr>
					</table>
				</form>
					<table id="logged-in">
						<tr>
							<td colspan="2">
							</td>
						</tr>
						<tr>
<!-- 							<td> -->
<!-- 								<input type="button" value="내 정보보기" -->
<%-- 								onclick="location.replace('<%=request.getContextPath()%>/member/memberView.do')"> --%>
<!-- 							</td> -->
<!-- 							<td> -->
<!-- 								<input type="button" value="로그아웃" -->
<%-- 								onclick="location.replace('<%=request.getContextPath()%>/logout.do');"> --%>
<!-- 							</td> -->
						</tr>
					</table>
			</div>
			<nav>
				<ul class="main-nav">
					<li class="home"><a href="">Home</a></li>
					<li id="notice"><a href="">공지사항</a></li>
					<li id="board"><a href="">게시판</a></li>

				</ul>
			</nav>
			</header>
		</div>
	<section class="content">
		<h2>UI디자인테스트</h2>
	</section>
</body>
</html>
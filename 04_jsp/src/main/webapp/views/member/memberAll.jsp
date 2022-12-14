<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.jsp.model.vo.Member" %>
<%
	List<Member> list=(List<Member>)request.getAttribute("members");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원전체 조회결과</title>
</head>
<body>
	<h2>회원전체 조회</h2>
	<div id="content">
		<table>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>성별</th>
				<th>나이</th>
				<th>이메일</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>취미</th>
				<th>가입일</th>
			</tr>
			<%if(list.isEmpty()){%>
			<!-- 비어있을때 -->
				<tr>
					<td><h3>조회된 회원이 없습니다 :(</h3></td>
				</tr>
			<%}
			else{
				for(Member m :list) {%>
				<tr>
					<td><%=m.getMemberId()%></td>
					<td><%=m.getMemberName()%></td>
					<td><%=m.getGender()%></td>
					<td><%=m.getAge()%></td>
					<td><%=m.getEmail()%></td>
					<td><%=m.getPhone()%></td>
					<td><%=m.getAddress()%></td>
					<td>
						<ul>
							<%if(m.getHobby().length>0){
								for(String h:m.getHobby()){%>
								<li><%=h %></li>
								<%}
								}%>
						</ul>
					</td>
					<td><%=m.getEnrollDate() %></td>
				</tr>
			<%}
			}%>
		</table>
	</div>


</body>
</html>
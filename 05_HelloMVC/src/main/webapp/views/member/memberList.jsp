<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%
	List<Member> members=(List<Member>)request.getAttribute("members");
%>
<%@ include file="/views/common/header.jsp" %>
<style type="text/css">
    section#memberList-container {text-align:center;}
    
    section#memberList-container table#tbl-member {width:100%; border:1px solid gray; border-collapse:collapse;}
    section#memberList-container table#tbl-member th, table#tbl-member td {border:1px solid gray; padding:10px; }
</style>
<body>
	<section id="memberList-container">
        <h2>회원관리</h2>
        <table id="tbl-member">
            <thead>
                <tr>
                    <th>아이디</th>
				    <th>이름</th>
				    <th>성별</th>
				    <th>나이</th>
				    <th>이메일</th>
				    <th>전화번호</th>
				    <th>주소</th>
				    <th>취미</th>
				    <th>가입날짜</th>
                </tr>
            </thead>
            <tbody>
				<%if(members.isEmpty()){ %>
					<tr>
						<td><h3>조회된 회원이 없습니다.</h3></td>
					</tr>
				<%}else{ 
					for(int i=0; i<members.size();i++){
				%>
					<tr>
						<td><%=members.get(i).getUserId() %></td>
						<td><%=members.get(i).getUserName() %></td>
						<td><%=members.get(i).getGender() %></td>
						<td><%=members.get(i).getAge() %></td>
						<td><%=members.get(i).getEmail() %></td>
						<td><%=members.get(i).getPhone() %></td>
						<td><%=members.get(i).getAddress() %></td>
						<td><%=String.join(",",members.get(i).getHobby()) %></td>
						<td><%=members.get(i).getEnrollDate() %></td>
					</tr>
				<%} 
				}%>
            </tbody>
        </table>
    </section>
<%@ include file="/views/common/footer.jsp"%>
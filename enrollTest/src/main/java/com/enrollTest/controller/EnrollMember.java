package com.enrollTest.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EnrollMember
 */
@WebServlet("/enrollData.do")
public class EnrollMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollMember() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out=response.getWriter();
		
		String userId=request.getParameter("userId");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String nickname=request.getParameter("nickname");
		String[] languages=request.getParameterValues("language");	
		String gender=request.getParameter("gender");
		
		String html="<html>";
		html+="<head>";
		html+="<title>자기소개</title>";
		html+="</head>";
		html+="<body>";
		html+="<h2>자기소개</h2>";
		html+="<p>아이디 : "+userId+"</p><br>";
		html+="<p>패스워드 : "+password+"</p><br>";
		html+="<p>이름 : "+name+"</p><br>";
		html+="<p>닉네임 : "+nickname+"<p><br>";
		html+="<ul>사용가능언어(중복선택) : ";
		for(String a : languages) {
			html+="<li>"+a+"</li>";
		}
		html+="</ul><br>";
		html+="<p>성별 : "+gender+"</p>";
		html+="</body>";
		html+="</html>";
		
		out.write(html);
//		System.out.println(html);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

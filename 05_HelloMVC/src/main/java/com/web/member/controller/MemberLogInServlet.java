package com.web.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.member.model.service.MemberService;
import com.web.member.model.vo.Member;

/**
 * Servlet implementation class MemberLogInServlet
 */
@WebServlet("/login.do")
public class MemberLogInServlet extends HttpServlet {
//	private MemberService service=new MemberService();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLogInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인기능 하는 서블릿
		//클라이언트가 보낸 id,password를 가지고 
		//DB에 일치하는 데이터가 있는지 확인하고 있으면 데이터를 가져오고
		//없으면 null값을 가져오는 기능
		request.setCharacterEncoding("utf-8");
		String userId=request.getParameter("userId");
		String password=request.getParameter("password");
//		System.out.println(userId);
//		System.out.println(password);
		Member m=new MemberService().searchMember(userId,password);
		System.out.println(m);
//		request.getRequestDispatcher("/views/member/welcome.jsp")
//		.forward(request, response);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package com.test.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.member.vo.Member;
import com.test.model.dao.MemberDao;
import com.test.model.service.MemberService;

/**
 * Servlet implementation class MemberJoinEndServlet
 */
@WebServlet("/member/memberenrollend.do")
public class MemberJoinEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberJoinEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//데이터를 가져와 저장하는 기능
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("userId");
		String pw=request.getParameter("password");
		String name=request.getParameter("userName");
		int age=Integer.parseInt(request.getParameter("age"));
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		String gender=String.valueOf(request.getParameter("gender"));
		String[] hobby=request.getParameterValues("hobby");
		Member m=Member.builder()
				.userId(id)
				.password(pw)
				.userName(name)
				.age(age)
				.email(email)
				.phone(phone)
				.address(address)
				.gender(gender.charAt(0))
				.hobby(hobby)
				.build();
		System.out.println(m);
		int result=new MemberService().insertMember(m);
		
		String loc,msg="";
		if(result>0) {
			msg="회원가입이 완료되었습니다.";
			loc="/member/memberenroll.jsp";
		}
		else {
			msg="x";
			loc="/member/memberenroll.jsp";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		
		request.getRequestDispatcher("/views/member/msg.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

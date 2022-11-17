package com.firstWepProject.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//클래스를 서블릿으로 만들려면 서블릿규약을 준수
//HttpServlet클래스를 상속받아야함. -> Servlet클래스가 됨.
public class FirstServlet extends HttpServlet {

	private static final long serialVersionUID = -4820957398970106732L;
	
	//Http로 사용자의 요청을 받아서 응답처리하는 클래스
	//정해진 메소드를 구현(재정의)하여 사용함
	//2가지의 메소드
	//1. doGet(HttpServletRequest, HttpServletResponse) : 사용자(client)가 get방식으로 요청한 것을 받을때 이용하는 메소드
	//2. doPost(HttpServletRequestm, HttpServletResponese) : 사용자(client)가 post방식으로 요청한 것을 받을때 이용하는 메소드
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("get메소드로 요청");
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("post메소드로 요청");
	}
	
	//서버가 요청주소에 따라 서블릿을 실행할 수 있게 설정하기
	//1. web.xml파일을 이용하기
	//	- <servlet>태그를 이용해서 생성한 servlet클래스를 등옥
	//	- <servlet-mapping>태그를 이용해서 url주소와 servlet클래스를 연결
	//2. 어노테이션(@)를 이용하기
	
	
	
	
}

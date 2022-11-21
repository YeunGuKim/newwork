package com.servletdata.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestPersonServlet
 */
@WebServlet("/testPerson.do")
public class TestPersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestPersonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//데이터 인코딩하기
		request.setCharacterEncoding("utf-8");
		
		//1. 단일데이터 값 받아오기
		//request.getParameter() -> 기본적인 데이터를 받아올때 사용
		String name=request.getParameter("name");
		int age=Integer.parseInt(request.getParameter("age"));
		double height=Double.parseDouble(request.getParameter("height"));
		String color=request.getParameter("color");
		String lunchMenu=request.getParameter("lunch");
		
		//2. 하나의 이름으로 여러값이 전송될 때 값 받아오기
		//request.getParameterValues() -> 다수의 값을 받을때 사용
		//다수의 값이기 때문에 반환형이 String[]임
		String[] animals=request.getParameterValues("animal");
		
		System.out.println("이름 : "+name);
		System.out.println("나이 : "+age);
		System.out.println("키 : "+height);
		System.out.println("색상 : "+color);
		System.out.println("동물 : "+Arrays.toString(animals));
		System.out.println("점심메뉴 : "+lunchMenu);
		
//		for(String a : animals) {
//			System.out.println(a);
//		}
		
		//단일값도 getParameterValues()메소드를 이용해서 가져올 수 있다.
		String[] names=request.getParameterValues("name");
		//단일값을 배열 0번인덱스에 값을 대입 후 반환
		System.out.println("values로 가져온 name : "+Arrays.toString(names));
		
		//클라이언트에서 전송된 name값을 모를 때 name값만 가져오기
		//getParameterNames()메소드 이용 -> Enumerration클래스로 반환
		Enumeration<String> paramName=request.getParameterNames();
		while(paramName.hasMoreElements()) {
			String key=paramName.nextElement();
			String[] values=request.getParameterValues(key);
			System.out.println(Arrays.toString(values));
		}
		
		//전송된 데이터를 key:value형식으로 반환하기 -> Map
		//request.getParameterMap();
		Map<String, String[]> param=request.getParameterMap();
		System.out.println("===== map으로 데이터 받기 =====");
		Set<String> keys=param.keySet();
		Iterator<String> it=keys.iterator();
		while(it.hasNext()) {
			String key=it.next();
			System.out.println(key);
			System.out.println(Arrays.toString(param.get(key)));
		}
		
		//entry set으로 출력해보기(집)
		
		//클라이언트의 요청에 대한 응답페이지를 작성
		//HttpServletResponse클래스를 이용한다.
		//1. 응답데이터에 대한 타입을 설정 -> MIME타입
		response.setContentType("text/html;charset=utf-8");
		
		//2. 클라이언트의 Stream을 가져온다.
		// 1) getWriter() : html코드를 전송할 때, 일반 문자열 데이터 보낼때
		// 2) getOutputStream() : 파일전송할 때
		PrintWriter out=response.getWriter();
		
		//3. 연결된 스트림으로 원하는 데이터를 전송
		//write(), append() 메소드를 이용
		
		String html="<html>";
		html+="<head>";
		html+="<title>당신의 취향 분석</title>";
		html+="</head>";
		html+="<body>";
		html+="<h1>"+name+"님의 취향은</h1>";
		html+="<h2>당신의 이름은 "+name+"이고 나이는 "+age+"살입니다.</h2>";
		html+="<h3>키는 "+height+"cm이고 좋아하는 색은<span style='color:"+color+";'>"+color+"</span>입니다.</h3>";
		html+="<ul>좋아하는 동물은";
		for(String a : animals) {
//			html+="<li>"+a+"</li>";
			html+="<li>";
			String src="";
			switch(a) {
			case "강아지" : 
				src="data:image/jpeg;base64,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";break;
			case "고양이" : 
				src="data:image/jpeg;base64,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";break;
			}
			html+="<img src='"+src+"' width='100' height='100'>";
			html+="</li>";
		}
		html+="</ul>";
		html+="<h3>오늘의 점심은 "+lunchMenu+"였습니다.</h3>";
		html+="</body>";
		html+="</html>";
		
		out.write(html);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}

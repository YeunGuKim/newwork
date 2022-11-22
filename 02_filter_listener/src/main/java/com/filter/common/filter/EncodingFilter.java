package com.filter.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class EncodingFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		System.out.println("필터실행");
		
		//wrapper클래스 적용하기
//		HttpServletRequestTest hrt=new HttpServletRequestTest((HttpServletRequest)request);
		
		
		
		//다음 서블릿이나 필터가 실행
		chain.doFilter(request, response);
	}

	
}	

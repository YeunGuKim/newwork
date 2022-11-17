package com.myWeb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//서블릿클래스

public class myFirst extends HttpServlet {

	private static final long serialVersionUID = 8253588057542328901L;
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("우와 내가 만든게 실행되다니");
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post");
	}
}

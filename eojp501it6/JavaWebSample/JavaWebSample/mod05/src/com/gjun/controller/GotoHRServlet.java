package com.gjun.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/GotoHRServlet")
public class GotoHRServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//透過Request參考出RequestDispatcher
		RequestDispatcher dispatcher=request.getRequestDispatcher("hr/hr01.jsp");
		dispatcher.forward(request, response);
		return;
		
	}
	
	

}

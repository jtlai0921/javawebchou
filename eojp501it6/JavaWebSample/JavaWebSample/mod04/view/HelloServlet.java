package com.gjun.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//�ڪ��Ĥ@��Servlet 
@WebServlet(name="hello",urlPatterns="hellolinda")
public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		//�z�LHttpServletResponse�ѦҥXPrintWriter
		PrintWriter out=response.getWriter();
		//��X��r���e��
		out.println("<font size='7' color='red'>Hello World!!!</font>");
	}
	

}

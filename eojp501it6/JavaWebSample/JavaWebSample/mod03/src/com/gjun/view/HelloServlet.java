package com.gjun.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//我的第一個Servlet 
@WebServlet(name="hello",urlPatterns="hellolinda")
public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		//透過HttpServletResponse參考出PrintWriter
		PrintWriter out=response.getWriter();
		//輸出文字串到前端
		out.println("<font size='7' color='red'>Hello World!!!</font>");
	}
	

}

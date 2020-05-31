package com.gjun.view;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/showrequestheader")
public class ShowRequestHeaderServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		//取出Request 所有的Header Name
		Enumeration<String> headerNames=request.getHeaderNames();
		//走訪每一個Header Name
		while(headerNames.hasMoreElements()) {
			//問出相對的Header Name
			String name=headerNames.nextElement();
			//取出相對的Header name對應的value
			String value=request.getHeader(name);
			//輸出
			response.getWriter().printf("<li>Header Name:%s --> Header Value:%s",name,value);
		}
	}

}

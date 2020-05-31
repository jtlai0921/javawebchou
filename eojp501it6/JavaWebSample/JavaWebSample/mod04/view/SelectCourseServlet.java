package com.gjun.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/selectcourse")
public class SelectCourseServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		//設定回應編碼
		response.setContentType("text/html;charset=UTF-8");
		String item=request.getParameter("selcourse");
		response.getWriter().println("<li>您挑選的課程:"+item);
			
	}

}

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
		//���XRequest �Ҧ���Header Name
		Enumeration<String> headerNames=request.getHeaderNames();
		//���X�C�@��Header Name
		while(headerNames.hasMoreElements()) {
			//�ݥX�۹諸Header Name
			String name=headerNames.nextElement();
			//���X�۹諸Header name������value
			String value=request.getHeader(name);
			//��X
			response.getWriter().printf("<li>Header Name:%s --> Header Value:%s",name,value);
		}
	}

}

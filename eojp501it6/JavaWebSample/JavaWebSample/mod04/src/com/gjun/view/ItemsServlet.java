package com.gjun.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ItemsServlet extends HttpServlet {
	private String[] items;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//�]�w�^���s�X
		response.setContentType("text/html;charset=UTF-8");
		//�ѦҥXPrintWriter
		PrintWriter out=response.getWriter();
		out.println("<select>");
		//���X��l�ưѼ��ഫ���r��}�C
		for(String item : items) {
			out.println(String.format("<option value='%s'>%s</option>",item,item));
		}
		out.println("</select>");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		//�ϥ�ServletConfig�����l�ưѼƳ]�w���e
		items=config.getInitParameter("items").split(",");
	}
	
	
}

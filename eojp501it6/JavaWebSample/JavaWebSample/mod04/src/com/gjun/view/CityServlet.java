package com.gjun.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name="city",urlPatterns="/city",
initParams=@WebInitParam(name="cities",value="�x�_��,�s�_��,��饫,�x����,�x�n��,������"))
public class CityServlet extends HttpServlet {
	private String[] cities;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//�]�w�^���s�X
		response.setContentType("text/html;charset=UTF-8");
		//�ѦҥXPrintWriter
		PrintWriter out=response.getWriter();
		out.println("<div>����</div>");
		out.println("<select>");
		//���X��l�ưѼ��ഫ���r��}�C
		for(String item : cities) {
			out.println(String.format("<option value='%s'>%s</option>",item,item));
		}
		out.println("</select>");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		//�ϥ�ServletConfig�����l�ưѼƳ]�w���e
		cities=config.getInitParameter("cities").split(",");
	}
	
	
}


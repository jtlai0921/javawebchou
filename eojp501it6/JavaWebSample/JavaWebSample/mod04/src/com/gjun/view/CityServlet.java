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
initParams=@WebInitParam(name="cities",value="カ,穝カ,堕カ,いカ,玭カ,蔼动カ"))
public class CityServlet extends HttpServlet {
	private String[] cities;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//砞﹚莱絪絏
		response.setContentType("text/html;charset=UTF-8");
		//把σPrintWriter
		PrintWriter out=response.getWriter();
		out.println("<div>カ</div>");
		out.println("<select>");
		//ǐ砐﹍て把计锣传﹃皚
		for(String item : cities) {
			out.println(String.format("<option value='%s'>%s</option>",item,item));
		}
		out.println("</select>");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		//ㄏノServletConfig莉﹍て把计砞﹚ず甧
		cities=config.getInitParameter("cities").split(",");
	}
	
	
}


package com.gjun.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name="EricHelloServlet",urlPatterns= {"/erichello.view"})
public class EricHelloServlet extends HttpServlet {

	//支援前端採用Http Request GET方式
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//透過HttpServletResponse參考出PrintWriter物件，輸出文字串到前端
		response.getWriter().println("<font size='6' color='blue'>Hello World Eric</font>");
	}

}

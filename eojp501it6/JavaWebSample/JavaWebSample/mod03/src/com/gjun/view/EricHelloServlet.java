package com.gjun.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name="EricHelloServlet",urlPatterns= {"/erichello.view"})
public class EricHelloServlet extends HttpServlet {

	//�䴩�e�ݱĥ�Http Request GET�覡
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//�z�LHttpServletResponse�ѦҥXPrintWriter����A��X��r���e��
		response.getWriter().println("<font size='6' color='blue'>Hello World Eric</font>");
	}

}

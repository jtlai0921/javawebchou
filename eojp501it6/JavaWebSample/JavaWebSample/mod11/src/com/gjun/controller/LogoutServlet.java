package com.gjun.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//取出HttpSession
		HttpSession session=request.getSession();
		if(session.getAttribute("cred")!=null) {
			//釋放掉參考的憑證
			session.removeAttribute("cred");
			
			//導向輸出
			response.sendRedirect("login.html");
		}
	}
}

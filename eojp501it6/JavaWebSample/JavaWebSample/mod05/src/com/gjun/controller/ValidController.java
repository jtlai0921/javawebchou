package com.gjun.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ValidController")
public class ValidController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//取出使用者名稱與密碼
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		//進行使用者驗證
		//發出前端Cookie憑證
		Cookie cookie=new Cookie("cred",username);
		response.addCookie(cookie);
		response.getWriter().println("驗證通過了!!");
	}

}

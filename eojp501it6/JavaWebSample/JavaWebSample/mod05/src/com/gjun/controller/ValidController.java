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
		//���X�ϥΪ̦W�ٻP�K�X
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		//�i��ϥΪ�����
		//�o�X�e��Cookie����
		Cookie cookie=new Cookie("cred",username);
		response.addCookie(cookie);
		response.getWriter().println("���ҳq�L�F!!");
	}

}

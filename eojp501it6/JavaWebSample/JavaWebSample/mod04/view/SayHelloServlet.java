package com.gjun.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sayhello")
public class SayHelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//設定回應編碼與Content Type
		response.setContentType("text/html;charset=UTF-8");
		//取出PrintWriter 寫出字串
		PrintWriter out=response.getWriter();
		out.println("<font size='6' color='blue'>您好 世界和平!!</font>");
		
	}

}

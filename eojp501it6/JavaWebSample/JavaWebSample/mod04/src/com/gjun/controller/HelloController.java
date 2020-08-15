package com.gjun.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/HelloController")
public class HelloController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//擷取編碼設定
		request.setCharacterEncoding("UTF-8");
		//擷取表單欄位內容 打招呼訊息
		String message=request.getParameter("message");
		//處理
		String result=String.format("您說:%s 謝謝您的祝福!!!",message);
		//透過Request參考出RequestDispatcher介面
		RequestDispatcher dispatcher=request.getRequestDispatcher("showhello.jsp");
		//透過ServletRequest參照處理結過
		request.setAttribute("result",result);
		//分派到目標去
		dispatcher.forward(request, response);
		//後面不要撰寫了 因為採用forward控制權已交付到目標去
		return;
		
		
	}
	

}

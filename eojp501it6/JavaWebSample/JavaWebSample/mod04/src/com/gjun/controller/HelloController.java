package com.gjun.controller;

import java.io.IOException;

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
		//�^���s�X�]�w
		request.setCharacterEncoding("UTF-8");
		//�^�������줺�e ���۩I�T��
		String message=request.getParameter("message");
		//�B�z
		String result=String.format("�z��:%s ���±z������!!!",message);
		//�z�LRequest�ѦҥXRequestDispatcher����
		RequestDispatcher dispatcher=request.getRequestDispatcher("showhello.jsp");
		//�z�LServletRequest�ѷӳB�z���L
		request.setAttribute("result",result);
		//������ؼХh
		dispatcher.forward(request, response);
		//�᭱���n���g�F �]���ĥ�forward�����v�w��I��ؼХh
		return;
		
		
	}
	

}

package com.gjun.view;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ServletContextFile")
public class ServletContextFileServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//�]�w�^����Content Type
		response.setContentType("application/pdf");
		//�ѷӥXServletContext����
		ServletContext application=this.getServletContext();
		//�������w�����ؿ��U�ɮ׶}��Ū����y����
		InputStream is=application.getResourceAsStream("/files/Persistence JPA.pdf");
		//�غc�w�s��
		byte[] buffer=new byte[is.available()];
		//Ū���ɮ�
		is.read(buffer, 0, buffer.length);
		//�z�LResponse OutputStream�N�ɮפU���ܫe��
		ServletOutputStream out=response.getOutputStream();
		out.write(buffer, 0, buffer.length);
		out.flush();
		is.close();
	
	}
	

}

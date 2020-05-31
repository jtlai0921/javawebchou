package com.gjun.view;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//�ɮפU��Servlet
@WebServlet("/photoload")
public class PhotoLoadServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�]�w�^����ContentType
		response.setContentType("application/pdf");
		//�����۹�ؿ��U������ڥؿ����� ���o���Ψt�ι���������ServletContext
		ServletContext context=this.getServletContext();
		InputStream is=new FileInputStream(context.getRealPath("/docs/Persistence JPA.pdf"));
		//Ū���ɮצ�byte�}�C�w�s��
		byte[] buffer=new byte[is.available()];
		is.read(buffer,0,buffer.length);
		//���XResponse�ѷӤU��OutputStream
		OutputStream out=response.getOutputStream();
		out.write(buffer,0,buffer.length);
		out.flush();
		is.close();
		out.close();
		
		
	}
	
}

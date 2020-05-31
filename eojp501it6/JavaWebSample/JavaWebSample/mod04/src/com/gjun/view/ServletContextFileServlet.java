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
		//設定回應的Content Type
		response.setContentType("application/pdf");
		//參照出ServletContext物件
		ServletContext application=this.getServletContext();
		//直接指定虛擬目錄下檔案開啟讀取串流物件
		InputStream is=application.getResourceAsStream("/files/Persistence JPA.pdf");
		//建構緩存取
		byte[] buffer=new byte[is.available()];
		//讀取檔案
		is.read(buffer, 0, buffer.length);
		//透過Response OutputStream將檔案下載至前端
		ServletOutputStream out=response.getOutputStream();
		out.write(buffer, 0, buffer.length);
		out.flush();
		is.close();
	
	}
	

}

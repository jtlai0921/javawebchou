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

//檔案下載Servlet
@WebServlet("/photoload")
public class PhotoLoadServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//設定回應的ContentType
		response.setContentType("application/pdf");
		//網站相對目錄下的文件實際目錄對應 取得應用系統對應的物件ServletContext
		ServletContext context=this.getServletContext();
		InputStream is=new FileInputStream(context.getRealPath("/docs/Persistence JPA.pdf"));
		//讀取檔案至byte陣列緩存區
		byte[] buffer=new byte[is.available()];
		is.read(buffer,0,buffer.length);
		//取出Response參照下的OutputStream
		OutputStream out=response.getOutputStream();
		out.write(buffer,0,buffer.length);
		out.flush();
		is.close();
		out.close();
		
		
	}
	
}

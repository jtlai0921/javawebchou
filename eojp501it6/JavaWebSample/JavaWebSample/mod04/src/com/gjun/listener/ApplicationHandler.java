package com.gjun.listener;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.gjun.entity.DBConfig;

public class ApplicationHandler implements ServletContextListener{
	

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContextListener.super.contextDestroyed(sce);
		//開啟Log File
		//參考出聆聽的應用系統
		ServletContext application=sce.getServletContext();
		//取出相對虛擬目錄下的log file 實際目錄
		String realPath=application.getRealPath("/log/log.txt");
		//建構OutputStream
		try {
			OutputStream os=new FileOutputStream(realPath,true);
			Writer writer=new OutputStreamWriter(os);
			writer.write(String.format("系統停止:%s",new Date()));
			writer.flush();
			writer.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContextListener.super.contextInitialized(sce);
		
		//取出介接聆聽的應用系統介面ServletContext
		ServletContext application=sce.getServletContext();
		//取出初始化參數
		String url=application.getInitParameter("url");
		String driverClassName=application.getInitParameter("driverClassName");
		String username=application.getInitParameter("username");
		String password=application.getInitParameter("password");
		//封裝成Entity物件 納入應用系統狀態管理
		DBConfig config=new DBConfig();
		config.setUrl(url);
		config.setDriverClassName(driverClassName);
		config.setUsername(username);
		config.setPassword(password);
		//應用系統生命週期參考物件設定
		application.setAttribute("dbconfig", config);
		
	}
	
	
}

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
		//�}��Log File
		//�ѦҥX��ť�����Ψt��
		ServletContext application=sce.getServletContext();
		//���X�۹�����ؿ��U��log file ��ڥؿ�
		String realPath=application.getRealPath("/log/log.txt");
		//�غcOutputStream
		try {
			OutputStream os=new FileOutputStream(realPath,true);
			Writer writer=new OutputStreamWriter(os);
			writer.write(String.format("�t�ΰ���:%s",new Date()));
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
		
		//���X������ť�����Ψt�Τ���ServletContext
		ServletContext application=sce.getServletContext();
		//���X��l�ưѼ�
		String url=application.getInitParameter("url");
		String driverClassName=application.getInitParameter("driverClassName");
		String username=application.getInitParameter("username");
		String password=application.getInitParameter("password");
		//�ʸ˦�Entity���� �ǤJ���Ψt�Ϊ��A�޲z
		DBConfig config=new DBConfig();
		config.setUrl(url);
		config.setDriverClassName(driverClassName);
		config.setUsername(username);
		config.setPassword(password);
		//���Ψt�ΥͩR�g���ѦҪ���]�w
		application.setAttribute("dbconfig", config);
		
	}
	
	
}

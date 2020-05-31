package com.gjun.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbcp2.BasicDataSource;

import com.gjun.domain.Customer;
import com.gjun.domain.CustomerDao;
import com.gjun.domain.IDao;


@WebServlet("/CustomersQry")
public class CustomersQry extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//擷取客戶編號
		String customerid=request.getParameter("customerid");
		//建構DataSource物件
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/sakila?useSSL=false"
				+ "&serverTimezone=UTC&characterEncoding=utf-8");
		dataSource.setUsername("root");
		dataSource.setPassword("1111");
		//呼叫DAO模組進行資料查詢
		IDao<Customer> dao=new CustomerDao();
		dao.setDataSource(dataSource); //注入DataSource(Dependency Injection)
		//呼叫查詢方法
		Customer customer;
		try {
			customer = dao.selectForObject("select * from customer where customer_id=?",customerid);
		
		//判斷是否查詢有記錄
		if(customer==null) {
			String msg=String.format("您查詢的客戶編號:%s 記錄不存在!!",customerid);
			//進入request狀態管理
			request.setAttribute("msg",msg);
			//派送到View
			RequestDispatcher disp=request.getRequestDispatcher("notfound.jsp");
			disp.forward(request, response);
			
		}else {
			//透過 ServletRequest進行查詢結果狀態管理
			request.setAttribute("customer",customer);
			//派送到View
			RequestDispatcher disp=request.getRequestDispatcher("found.jsp");
			disp.forward(request, response);
			
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}

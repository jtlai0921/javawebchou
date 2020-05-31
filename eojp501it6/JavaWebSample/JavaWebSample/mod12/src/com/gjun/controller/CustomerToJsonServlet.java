package com.gjun.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbcp2.BasicDataSource;

import com.gjun.domain.Customer;
import com.gjun.domain.CustomerDao;
import com.gjun.domain.IDao;
import com.google.gson.Gson;


@WebServlet("/CustomerToJsonServlet")
public class CustomerToJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//擷取參數內容(查詢鍵值)
		String customerid=request.getParameter("cid");
		//建構DataSource
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/sakila?useSSL=false"
				+ "&serverTimezone=UTC&characterEncoding=utf-8");
		dataSource.setUsername("root");
		dataSource.setPassword("1111");
		//建構自訂的DAO物件
		IDao<Customer> dao=new CustomerDao();
		//入住DataSource
		dao.setDataSource(dataSource);
		//建構Customer物件
		Customer customer;
		try {
			customer = dao.selectForObject("select customer_id,first_name,last_name,email "
					+ "0from customer where customer_id=?"
					, customerid);
			//建構GSON物件
			Gson gson=new Gson();
			String data=gson.toJson(customer); //序列化物件為JSON
			//設定回應Content-Type與內容
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			PrintWriter out=response.getWriter();
			out.println(data);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

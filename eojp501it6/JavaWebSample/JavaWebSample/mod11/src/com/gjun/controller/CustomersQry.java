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
		//�^���Ȥ�s��
		String customerid=request.getParameter("customerid");
		//�غcDataSource����
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/sakila?useSSL=false"
				+ "&serverTimezone=UTC&characterEncoding=utf-8");
		dataSource.setUsername("root");
		dataSource.setPassword("1111");
		//�I�sDAO�Ҳնi���Ƭd��
		IDao<Customer> dao=new CustomerDao();
		dao.setDataSource(dataSource); //�`�JDataSource(Dependency Injection)
		//�I�s�d�ߤ�k
		Customer customer;
		try {
			customer = dao.selectForObject("select * from customer where customer_id=?",customerid);
		
		//�P�_�O�_�d�ߦ��O��
		if(customer==null) {
			String msg=String.format("�z�d�ߪ��Ȥ�s��:%s �O�����s�b!!",customerid);
			//�i�Jrequest���A�޲z
			request.setAttribute("msg",msg);
			//���e��View
			RequestDispatcher disp=request.getRequestDispatcher("notfound.jsp");
			disp.forward(request, response);
			
		}else {
			//�z�L ServletRequest�i��d�ߵ��G���A�޲z
			request.setAttribute("customer",customer);
			//���e��View
			RequestDispatcher disp=request.getRequestDispatcher("found.jsp");
			disp.forward(request, response);
			
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}

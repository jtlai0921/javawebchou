package com.gjun.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.dbcp2.BasicDataSource;

import com.gjun.domain.IDao;
import com.gjun.domain.Member;
import com.gjun.domain.MemberDao;


@WebServlet("/LoginValidServlet")
public class LoginValidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//擷取表單欄位
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		//建構DataSource物件
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/sakila?useSSL=false"
				+ "&serverTimezone=UTC&characterEncoding=utf-8");
		dataSource.setUsername("root");
		dataSource.setPassword("1111");
		//建構自訂DAO物件 進行登入會員驗證
		IDao<Member> dao=new MemberDao();
		//注入DataSource
		dao.setDataSource(dataSource);
		try {
			Member member=dao.selectForObject("select username,password from member where username=? and password=?"
					,username,password);
			if(member==null) {
				//登入失敗
				String msg=String.format("%s 帳號不存在!登入失敗!!!",username);
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("loginfailure.jsp").forward(request, response);
				
			}else
			{
				//登入成功
				//Session管理憑證
				HttpSession session=request.getSession();
				session.setAttribute("cred",member.getUsername());
				request.setAttribute("member",member);
				//派送頁面
				request.getRequestDispatcher("loginok.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}

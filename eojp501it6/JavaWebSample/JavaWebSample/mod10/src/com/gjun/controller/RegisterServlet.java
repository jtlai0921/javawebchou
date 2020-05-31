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

import com.gjun.domain.IDao;
import com.gjun.domain.Member;
import com.gjun.domain.MemberDao;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//擷取表單欄位
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		//建構Entity物件用來封裝表單欄位內容
		Member member=new Member();
		member.setUsername(username);
		member.setPassword(password);
		//建構DataSource物件
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/sakila?useSSL=false"
				+ "&serverTimezone=UTC&characterEncoding=utf-8");
		dataSource.setUsername("root");
		dataSource.setPassword("1111");
		//進行資料驗證 是否使用者名稱重複
		IDao<Member> dao=new MemberDao();
		//注入dataSource
		dao.setDataSource(dataSource);
		try {
			Member result=dao.selectForObject("select username,password from member where username=?",username);
			//判斷是否已經存在
			if(result!=null) {
				//名稱已經被註冊
				//透過ServletRequest參照出RequestDispatcher物件
				RequestDispatcher dispatcher=request.getRequestDispatcher("addfailure.jsp");
				//訊息狀態
				String msg=String.format("%s 使者名稱重複!!", username);
				request.setAttribute("msg",msg);
				//分送
				dispatcher.forward(request, response);
			}else
			{
				//進行會員註冊作業(新增)
				boolean rs=dao.insert(member);
				//透過ServletRequest參照出RequestDispatcher物件
				RequestDispatcher dispatcher=request.getRequestDispatcher("addok.jsp");
				//訊息狀態
				String msg=String.format("使用者 %s 完成註冊!!", username);
				request.setAttribute("msg",msg);
				//分送
				dispatcher.forward(request, response);
				
			}
		}catch(SQLException ex) {
			RequestDispatcher dispatcher=request.getRequestDispatcher("addfailure.jsp");
			//訊息狀態
			String msg=ex.getMessage();
			request.setAttribute("msg",msg);
			//分送
			dispatcher.forward(request, response);
		}
		//如果重複分派到一個View去進行提醒
		//進行會員資料儲存
		//儲存成功 則分派一個View進行註冊資訊狀態呈現
		
	}

}

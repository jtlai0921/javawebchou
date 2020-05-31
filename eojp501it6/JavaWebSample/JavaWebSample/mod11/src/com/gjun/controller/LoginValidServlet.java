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
		//�^��������
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		//�غcDataSource����
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/sakila?useSSL=false"
				+ "&serverTimezone=UTC&characterEncoding=utf-8");
		dataSource.setUsername("root");
		dataSource.setPassword("1111");
		//�غc�ۭqDAO���� �i��n�J�|������
		IDao<Member> dao=new MemberDao();
		//�`�JDataSource
		dao.setDataSource(dataSource);
		try {
			Member member=dao.selectForObject("select username,password from member where username=? and password=?"
					,username,password);
			if(member==null) {
				//�n�J����
				String msg=String.format("%s �b�����s�b!�n�J����!!!",username);
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("loginfailure.jsp").forward(request, response);
				
			}else
			{
				//�n�J���\
				//Session�޲z����
				HttpSession session=request.getSession();
				session.setAttribute("cred",member.getUsername());
				request.setAttribute("member",member);
				//���e����
				request.getRequestDispatcher("loginok.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}

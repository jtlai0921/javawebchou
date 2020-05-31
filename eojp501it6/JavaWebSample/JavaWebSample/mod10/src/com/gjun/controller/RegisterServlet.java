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
		//�^��������
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		//�غcEntity����Ψӫʸ˪����줺�e
		Member member=new Member();
		member.setUsername(username);
		member.setPassword(password);
		//�غcDataSource����
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/sakila?useSSL=false"
				+ "&serverTimezone=UTC&characterEncoding=utf-8");
		dataSource.setUsername("root");
		dataSource.setPassword("1111");
		//�i�������� �O�_�ϥΪ̦W�٭���
		IDao<Member> dao=new MemberDao();
		//�`�JdataSource
		dao.setDataSource(dataSource);
		try {
			Member result=dao.selectForObject("select username,password from member where username=?",username);
			//�P�_�O�_�w�g�s�b
			if(result!=null) {
				//�W�٤w�g�Q���U
				//�z�LServletRequest�ѷӥXRequestDispatcher����
				RequestDispatcher dispatcher=request.getRequestDispatcher("addfailure.jsp");
				//�T�����A
				String msg=String.format("%s �Ϫ̦W�٭���!!", username);
				request.setAttribute("msg",msg);
				//���e
				dispatcher.forward(request, response);
			}else
			{
				//�i��|�����U�@�~(�s�W)
				boolean rs=dao.insert(member);
				//�z�LServletRequest�ѷӥXRequestDispatcher����
				RequestDispatcher dispatcher=request.getRequestDispatcher("addok.jsp");
				//�T�����A
				String msg=String.format("�ϥΪ� %s �������U!!", username);
				request.setAttribute("msg",msg);
				//���e
				dispatcher.forward(request, response);
				
			}
		}catch(SQLException ex) {
			RequestDispatcher dispatcher=request.getRequestDispatcher("addfailure.jsp");
			//�T�����A
			String msg=ex.getMessage();
			request.setAttribute("msg",msg);
			//���e
			dispatcher.forward(request, response);
		}
		//�p�G���Ƥ�����@��View�h�i�洣��
		//�i��|������x�s
		//�x�s���\ �h�����@��View�i����U��T���A�e�{
		
	}

}

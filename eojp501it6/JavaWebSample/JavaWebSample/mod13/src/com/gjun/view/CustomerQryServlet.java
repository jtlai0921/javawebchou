package com.gjun.view;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gjun.entity.Customer;
import com.gjun.entity.CustomerDAO;
import com.gjun.entity.IDao;

/**
 * Servlet implementation class CustomerQryServlet
 */
@WebServlet("/CustomerQryServlet")
public class CustomerQryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//�ϥ�Persistence ���ͤu�t �t�mUnitName
		String customerid=request.getParameter("cid");
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("mod13");
        //�h�@�Ӻ޲z�o�@��PersistenceContext���޲z��
        EntityManager entityManager=factory.createEntityManager();
        //�غcDao����
        IDao<Customer> dao=new CustomerDAO();
        dao.setEntityManager(entityManager);
        //�d�ߧ@�~
        Customer customer=dao.select(customerid);
	        if(customer!=null) {
	        request.setAttribute("result",customer);
	        //Dispatcher
	        request.getRequestDispatcher("showcustomers.jsp").forward(request, response);
        }else
        {
        	String msg=String.format("�d�L�Ȥ�s��:%s �O��!!",customerid);
        	request.setAttribute("msg", msg);
        	//Dispatcher
	        request.getRequestDispatcher("notfound.jsp").forward(request, response);
        }
       
	}

}

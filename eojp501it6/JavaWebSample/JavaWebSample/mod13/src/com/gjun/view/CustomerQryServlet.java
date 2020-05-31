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
		//使用Persistence 產生工廠 配置UnitName
		String customerid=request.getParameter("cid");
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("mod13");
        //去一個管理這一個PersistenceContext的管理員
        EntityManager entityManager=factory.createEntityManager();
        //建構Dao物件
        IDao<Customer> dao=new CustomerDAO();
        dao.setEntityManager(entityManager);
        //查詢作業
        Customer customer=dao.select(customerid);
	        if(customer!=null) {
	        request.setAttribute("result",customer);
	        //Dispatcher
	        request.getRequestDispatcher("showcustomers.jsp").forward(request, response);
        }else
        {
        	String msg=String.format("查無客戶編號:%s 記錄!!",customerid);
        	request.setAttribute("msg", msg);
        	//Dispatcher
	        request.getRequestDispatcher("notfound.jsp").forward(request, response);
        }
       
	}

}

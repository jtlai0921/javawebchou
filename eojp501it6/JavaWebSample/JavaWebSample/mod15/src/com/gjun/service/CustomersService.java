package com.gjun.service;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.apache.commons.dbcp.BasicDataSource;

import com.gjun.domain.CustomerDao;
import com.gjun.domain.Customers;
import com.gjun.domain.GjunCustomers;
import com.gjun.domain.IDao;
import com.gjun.domain.Message;

@Path("customers")
public class CustomersService {
	
	@Path("getcustomers")
	@GET
	@Produces("application/json")
	public Customers getCustomers() {
		Customers customers=new Customers();
		customers.setCustomerId("0001");
		customers.setCompanyName("���K�q��");
		customers.setAddress("�x�_��");
		customers.setPhone("02-12345678");
		return customers;
	}
	
	//�s�W�Ȥ���
	@Path("addcustomers")
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Message addCustomers(Customers customers) {
		//�B�z
		Message msg=new Message();
		msg.setMessage(String.format("�Ȥ�s��:%s ���q�渹:%s",
				customers.getCustomerId(),customers.getCompanyName()));
		msg.setCode(200);
		return msg;
	}
	
	@Path("saycustomers")
	@GET
	@Produces("application/json")
	public Response sayCustomers(@QueryParam("key")String key) {
		if(key!=null) {
			Customers customers=new Customers();
			customers.setCustomerId("0001");
			customers.setCompanyName("���K�q��");
			customers.setAddress("�x�_��");
			customers.setPhone("02-12345678");
			//�^��statuscode 200���T�T��
			return Response.ok()
			.header("status","ok")
			.encoding("UTF-8")
			.entity(customers)
			.build();
		}else
		{
			Message msg=new Message();
			msg.setMessage("�d����ȩ|����J");
			msg.setCode(400);
			//�^��statuscode 400-bad request�T��
			return Response.status(400)
					.entity(msg)
					.build();
		}
		
	}

	//�Ȥ��Ƭd�� By �Ȥ�s��
	@Path("customersqry/id/{customerid}/rawdata")
	@GET
	@Produces("application/json")
	public GjunCustomers custqryById(@PathParam("customerid")short customerid) {
		GjunCustomers result=null;
		//�غcDataSource����
		BasicDataSource datasource=new BasicDataSource();
		datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/sakila?serverTimezone=UTC"
				+ "&useUnicode=true&characterEncoding=utf8&useSSL=false");
		datasource.setUsername("root");
		datasource.setPassword("1111");
		//�غcDAO
		IDao<GjunCustomers> dao=new CustomerDao();
		dao.setDataSource(datasource);
		try {
			result=dao.selectForObject("select customer_id,first_name,last_name,email "
					+ "from customer where customer_id=?",
					new Object[] {customerid});
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	
		
	}
}

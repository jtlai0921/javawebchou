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
		customers.setCompanyName("巨匠電腦");
		customers.setAddress("台北市");
		customers.setPhone("02-12345678");
		return customers;
	}
	
	//新增客戶資料
	@Path("addcustomers")
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Message addCustomers(Customers customers) {
		//處理
		Message msg=new Message();
		msg.setMessage(String.format("客戶編號:%s 公司行號:%s",
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
			customers.setCompanyName("巨匠電腦");
			customers.setAddress("台北市");
			customers.setPhone("02-12345678");
			//回應statuscode 200正確訊息
			return Response.ok()
			.header("status","ok")
			.encoding("UTF-8")
			.entity(customers)
			.build();
		}else
		{
			Message msg=new Message();
			msg.setMessage("查詢鍵值尚未輸入");
			msg.setCode(400);
			//回應statuscode 400-bad request訊息
			return Response.status(400)
					.entity(msg)
					.build();
		}
		
	}

	//客戶資料查詢 By 客戶編號
	@Path("customersqry/id/{customerid}/rawdata")
	@GET
	@Produces("application/json")
	public GjunCustomers custqryById(@PathParam("customerid")short customerid) {
		GjunCustomers result=null;
		//建構DataSource物件
		BasicDataSource datasource=new BasicDataSource();
		datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/sakila?serverTimezone=UTC"
				+ "&useUnicode=true&characterEncoding=utf8&useSSL=false");
		datasource.setUsername("root");
		datasource.setPassword("1111");
		//建構DAO
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

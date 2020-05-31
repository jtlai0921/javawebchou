package com.gjun.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class CustomerDao implements IDao<Customer>{
	//Attribute
	private DataSource datasource;

	//注入DataSource物件(連接工廠)
	@Override
	public void setDataSource(DataSource datasource) {
		this.datasource=datasource;
		
	}

	@Override
	public Customer selectForObject(String sql, Object... args) throws SQLException {
		Customer customer=null;
		//判斷DataSource
		if(datasource==null) {
			throw new SQLException("資料來源物件尚未注入!!!");
		}else
		{
			//透過DataSource物件生產一個連接物件(及時連接資料庫)
			Connection connection=datasource.getConnection();
			//配合傳遞進來的SQL語法產生PreparedStatement物件
			PreparedStatement pre=connection.prepareStatement(sql);
			//掃描參數 設定參數內容
			for(int index=0;index<args.length;index++) {
				pre.setObject(index+1, args[index]);
			}
			//執行查詢產生ResultSet
			ResultSet rs=pre.executeQuery();
			//判斷是否有找到相對客戶資料
			if(rs.next()) {
				//建構Customer Javabean物件
				customer=new Customer();
				customer.setCustomerId(Short.parseShort(rs.getObject("Customer_id").toString()));
				customer.setFirstName(rs.getObject("First_Name").toString());
				customer.setLastName(rs.getObject("Last_Name").toString());
				customer.setEmail(rs.getObject("Email").toString());
			}
			connection.close();
			return customer;
		}
		
		
		
	}

	

}

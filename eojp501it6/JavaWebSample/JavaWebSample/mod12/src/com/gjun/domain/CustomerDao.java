package com.gjun.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class CustomerDao implements IDao<Customer>{
	//Attribute
	private DataSource datasource;

	//�`�JDataSource����(�s���u�t)
	@Override
	public void setDataSource(DataSource datasource) {
		this.datasource=datasource;
		
	}

	@Override
	public Customer selectForObject(String sql, Object... args) throws SQLException {
		Customer customer=null;
		//�P�_DataSource
		if(datasource==null) {
			throw new SQLException("��ƨӷ�����|���`�J!!!");
		}else
		{
			//�z�LDataSource����Ͳ��@�ӳs������(�ήɳs����Ʈw)
			Connection connection=datasource.getConnection();
			//�t�X�ǻ��i�Ӫ�SQL�y�k����PreparedStatement����
			PreparedStatement pre=connection.prepareStatement(sql);
			//���y�Ѽ� �]�w�ѼƤ��e
			for(int index=0;index<args.length;index++) {
				pre.setObject(index+1, args[index]);
			}
			//����d�߲���ResultSet
			ResultSet rs=pre.executeQuery();
			//�P�_�O�_�����۹�Ȥ���
			if(rs.next()) {
				//�غcCustomer Javabean����
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

	@Override
	public boolean insert(Customer customer) throws SQLException {
		boolean r=false;
		//�P�_DataSource
		if(datasource==null) {
			throw new SQLException("��ƨӷ�����|���`�J!!!");
		}else
		{
			//�z�LDataSource����Ͳ��@�ӳs������(�ήɳs����Ʈw)
			Connection connection=datasource.getConnection();
			//�t�X�ǻ��i�Ӫ�SQL�y�k����PreparedStatement����
			String sql="insert into customer(customer_id,first_name,last_name,email) values(?,?,?,?)";
			PreparedStatement pre=connection.prepareStatement(sql);
			//�]�w�ѼƤ��e
			pre.setShort(1, customer.getCustomerId());
			pre.setString(2, customer.getFirstName());
			pre.setString(3, customer.getLastName());
			pre.setString(4, customer.getEmail());
			//�s�W�O��
			int result=pre.executeUpdate();
			connection.close();
			if(result>0) {
				r=true;
			}
			
		}	
		return r;
	}

	

}

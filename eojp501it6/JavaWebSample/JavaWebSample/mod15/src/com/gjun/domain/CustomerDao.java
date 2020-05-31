package com.gjun.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class CustomerDao implements IDao<GjunCustomers> {
	//attribute
	private DataSource datasource;

	@Override
	public GjunCustomers selectForObject(String sqlString, Object[] args) throws SQLException {
		GjunCustomers customers=null;
		if(this.datasource==null) {
			throw new SQLException("DataSource����|���`�J");
					}
		//1.�z�LDataSource���o�s������
		Connection connection=datasource.getConnection();
		//2.���ͩR�O����
		PreparedStatement st=connection.prepareStatement(sqlString);
		//���X�Ѽƭ� �]�w�]�w���e
		int start=1;
		for(Object value:args) {
			st.setObject(start, value);
			start++;
		}
		//����d��
		ResultSet rs=st.executeQuery();
		if (rs.next()) {
			customers=new GjunCustomers();
			customers.setCustomer_id(rs.getShort("customer_id"));
			customers.setFirst_name(rs.getString("first_name"));
			customers.setLast_name(rs.getString("last_name"));
			customers.setEmail(rs.getString("email"));
		}
		connection.close();
		return customers;
				
	}

	@Override
	public void setDataSource(DataSource datasource) {
		this.datasource=datasource;
		
	}

	@Override
	public List<GjunCustomers> selectForList(String sqlString, Object[] args) throws SQLException {
		List<GjunCustomers> customers=new ArrayList<>();
		if(this.datasource==null) {
			throw new SQLException("DataSource����|���`�J");
					}
		//1.�z�LDataSource���o�s������
		Connection connection=datasource.getConnection();
		//2.���ͩR�O����
		PreparedStatement st=connection.prepareStatement(sqlString);
		//���X�Ѽƭ� �]�w�]�w���e
		int start=1;
		for(Object value:args) {
			st.setObject(start, value);
			start++;
		}
		//����d��
		ResultSet rs=st.executeQuery();
		while(rs.next()) {
			GjunCustomers customer=new GjunCustomers();
			customer=new GjunCustomers();
			customer.setCustomer_id(rs.getShort("customer_id"));
			customer.setFirst_name(rs.getString("first_name"));
			customer.setLast_name(rs.getString("last_name"));
			customer.setEmail(rs.getString("email"));
			//���X�Ѧ�
			customers.add(customer);
		}
		connection.close();
		return customers;
	}

}

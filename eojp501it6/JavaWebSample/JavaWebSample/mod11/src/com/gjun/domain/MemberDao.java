package com.gjun.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class MemberDao implements IDao<Member>{
	//Attribute
	private DataSource datasource;

	@Override
	public void setDataSource(DataSource datasource) {
		this.datasource=datasource;
		
	}

	@Override
	public Member selectForObject(String sql, Object... args) throws SQLException {
		Member member=null;
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
				member=new Member();
				member.setUsername(rs.getString("username"));
				member.setPassword(rs.getString("password"));
			}
			connection.close();
			return member;
		}
	}

}

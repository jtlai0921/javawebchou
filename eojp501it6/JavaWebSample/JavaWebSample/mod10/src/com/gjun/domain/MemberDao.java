package com.gjun.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class MemberDao implements IDao<Member> {
	//attribute
	private DataSource datasource;

	//�j���`�JDataSource����(�s���u�t)
	@Override
	public void setDataSource(DataSource datasource) {
		this.datasource=datasource;
		
	}
	@Override
	public Member selectForObject(String sql, Object... args) throws SQLException {
		Member member=null;
		//�P�_DataSource����O�_�`�J
		if(this.datasource==null) {
			throw new SQLException("�|���`�JDataSource����");
		}
		//�z�LDataSource����n�@���s������
		Connection connection=datasource.getConnection();
		//���ͤ@�ӱa�ѼƬd�ߪ�PreparedStatement����
		PreparedStatement st=connection.prepareStatement(sql);
		//���X�Ѽƶi�椺�e�]�w
		for(int pos=0;pos<args.length;pos++) {
			st.setObject(pos+1,args[pos]);
		}
		//����d�� ���͵��G
		ResultSet rs=st.executeQuery();
		//�P�_�O�_���O��
		if(rs.next())
		{
			//�d���O��
			member=new Member();
			member.setUsername(rs.getString("username"));
			member.setPassword(rs.getString("password"));
		}
		connection.close();
		return member;
	}

	@Override
	public boolean insert(Member object) throws SQLException {
		//�P�_DataSource����O�_�`�J
		if(this.datasource==null) {
			throw new SQLException("�|���`�JDataSource����");
		}
		//�z�LDataSource����n�@���s������
		Connection connection=datasource.getConnection();
		//���ͤ@�ӱa�ѼƬd�ߪ�PreparedStatement����
		String sql="insert into member(username,password) values(?,?)";
		PreparedStatement st=connection.prepareStatement(sql);
		st.setString(1, object.getUsername());
		st.setString(2, object.getPassword());
				
		boolean result=false;
		//����s�W
		int r=st.executeUpdate();
		if(r>0) {
			result=true;
		}
		connection.close();
		return result;
	}

}

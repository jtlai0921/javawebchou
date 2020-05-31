package com.gjun.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class MemberDao implements IDao<Member> {
	//attribute
	private DataSource datasource;

	//強迫注入DataSource物件(連接工廠)
	@Override
	public void setDataSource(DataSource datasource) {
		this.datasource=datasource;
		
	}
	@Override
	public Member selectForObject(String sql, Object... args) throws SQLException {
		Member member=null;
		//判斷DataSource物件是否注入
		if(this.datasource==null) {
			throw new SQLException("尚未注入DataSource物件");
		}
		//透過DataSource物件要一條連接物件
		Connection connection=datasource.getConnection();
		//產生一個帶參數查詢的PreparedStatement物件
		PreparedStatement st=connection.prepareStatement(sql);
		//走訪參數進行內容設定
		for(int pos=0;pos<args.length;pos++) {
			st.setObject(pos+1,args[pos]);
		}
		//執行查詢 產生結果
		ResultSet rs=st.executeQuery();
		//判斷是否有記錄
		if(rs.next())
		{
			//查有記錄
			member=new Member();
			member.setUsername(rs.getString("username"));
			member.setPassword(rs.getString("password"));
		}
		connection.close();
		return member;
	}

	@Override
	public boolean insert(Member object) throws SQLException {
		//判斷DataSource物件是否注入
		if(this.datasource==null) {
			throw new SQLException("尚未注入DataSource物件");
		}
		//透過DataSource物件要一條連接物件
		Connection connection=datasource.getConnection();
		//產生一個帶參數查詢的PreparedStatement物件
		String sql="insert into member(username,password) values(?,?)";
		PreparedStatement st=connection.prepareStatement(sql);
		st.setString(1, object.getUsername());
		st.setString(2, object.getPassword());
				
		boolean result=false;
		//執行新增
		int r=st.executeUpdate();
		if(r>0) {
			result=true;
		}
		connection.close();
		return result;
	}

}

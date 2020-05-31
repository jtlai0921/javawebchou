package com.gjun.domain;

import java.sql.SQLException;

import javax.sql.DataSource;
//使用Generic設計，可以配合類別實作時設定相對的Entity class
public interface IDao<T> {
	public void setDataSource(DataSource datasource);
	//查詢單筆方法
	public T selectForObject(String sql,Object...args) throws SQLException;
	//新增客戶資料
	public boolean insert(T Object) throws SQLException;
	

}

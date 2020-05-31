package com.gjun.domain;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

//DAOe功能規範設計
//採用泛型 決定查詢回應值類型
public interface IDao<T> {
	//單筆查詢
	public T selectForObject(String sqlString,Object[] args) throws SQLException;
	//注入DataSource
	public void setDataSource(DataSource datasource);
	//多筆資料查詢
	public List<T> selectForList(String sqlString,Object[] args) throws SQLException;
}

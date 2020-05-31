package com.gjun.domain;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

//DAOe�\��W�d�]�p
//�ĥΪx�� �M�w�d�ߦ^��������
public interface IDao<T> {
	//�浧�d��
	public T selectForObject(String sqlString,Object[] args) throws SQLException;
	//�`�JDataSource
	public void setDataSource(DataSource datasource);
	//�h����Ƭd��
	public List<T> selectForList(String sqlString,Object[] args) throws SQLException;
}

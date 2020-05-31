package com.gjun.domain;

import java.sql.SQLException;

import javax.sql.DataSource;
//�ϥ�Generic�]�p�A�i�H�t�X���O��@�ɳ]�w�۹諸Entity class
public interface IDao<T> {
	public void setDataSource(DataSource datasource);
	//�d�߳浧��k
	public T selectForObject(String sql,Object...args) throws SQLException;
	

}

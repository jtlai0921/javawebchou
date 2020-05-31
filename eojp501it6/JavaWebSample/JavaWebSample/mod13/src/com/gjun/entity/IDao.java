
package com.gjun.entity;

import java.util.List;
import javax.persistence.EntityManager;


public interface IDao<T> {
    //查詢
    public T select(Object key);
    //多筆查詢
    public List<T> selectAll();
    //新增
    public boolean insert(T object);
    //DI 注入EntityManager Interface
    public void setEntityManager(EntityManager entityManager);
    
}

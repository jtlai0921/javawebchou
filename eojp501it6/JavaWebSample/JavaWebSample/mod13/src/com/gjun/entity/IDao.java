
package com.gjun.entity;

import java.util.List;
import javax.persistence.EntityManager;


public interface IDao<T> {
    //�d��
    public T select(Object key);
    //�h���d��
    public List<T> selectAll();
    //�s�W
    public boolean insert(T object);
    //DI �`�JEntityManager Interface
    public void setEntityManager(EntityManager entityManager);
    
}

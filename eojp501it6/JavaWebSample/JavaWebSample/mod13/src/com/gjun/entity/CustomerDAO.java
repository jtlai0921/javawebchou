
package com.gjun.entity;

import java.util.List;
import javax.persistence.EntityManager;

//��@IDao����
public class CustomerDAO implements IDao<Customer>{
    //attribute
    private EntityManager entityManager;

    @Override
    public Customer select(Object key) {
        //�d��
        return this.entityManager.find(Customer.class,key.toString());
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Customer> selectAll() {
  	List<Customer> result=
  			(List<Customer>)this.entityManager.createQuery("Select t from Customer t").getResultList();
  	return result;
    }

    @Override
    public boolean insert(Customer object) {
        this.entityManager.persist(object); //�s�W�O��
        return true;
    }
    @Override
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager=entityManager;
    }
    
}

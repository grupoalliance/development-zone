package org.tourandino.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.tourandino.dao.interfaces.InsurancePassengerDaoInterface;
import org.tourandino.hibernate.util.HibernateUtil;
import org.tourandino.model.InsurancePassenger;

@SuppressWarnings("unchecked")
public class InsurancePassengerDao extends HibernateUtil implements InsurancePassengerDaoInterface{
	private Session session;
	private Transaction transaction;
	
	public InsurancePassengerDao(){
		super();
	}
	
	public Session openSession() {
		session = getSessionFactory().openSession();
		return session;
	}
	
	public void beginTransaction(){
		transaction = session.beginTransaction();
	}
	
	public void commitTransaction(){
		transaction.commit();
	}
	
	public void rollbackTransaction(){
		if (transaction!=null) transaction.rollback();
	}
	
	public void closeSession() {
		session.close();
	}
	
	public Session getSession() {
		return session;
	}
	
	public Integer create(InsurancePassenger entity) {
		return (Integer) getSession().save(entity);
	}
	
	public void update(InsurancePassenger entity){
		getSession().update(entity);
	}
	
	public InsurancePassenger readById(Integer id){
		InsurancePassenger customer = (InsurancePassenger) getSession().get(InsurancePassenger.class, id);
		return customer;
	}
	
	public List<InsurancePassenger> readByOrder(Integer orderId){
		return getSession().createCriteria(InsurancePassenger.class, "insurancePassenger").createAlias("insurancePassenger.order", "order")
				.add(Restrictions.eq("order.orderId", orderId)).list();
	}
	
	public void delete(InsurancePassenger entity){
		getSession().delete(entity);
	}
	
	public List<InsurancePassenger> readAll(){
		return getSession().createCriteria(InsurancePassenger.class).list();
		
	}
	public void deleteAll(){
		List<InsurancePassenger> entityList = readAll();
		for (InsurancePassenger entity : entityList) {
			delete(entity);
		}
	}

}

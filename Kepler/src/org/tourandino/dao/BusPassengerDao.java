package org.tourandino.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.tourandino.dao.interfaces.BusPassengerDaoInterface;
import org.tourandino.hibernate.util.HibernateUtil;
import org.tourandino.model.BusPassenger;

@SuppressWarnings("unchecked")
public class BusPassengerDao extends HibernateUtil implements BusPassengerDaoInterface{
	private Session session;
	private Transaction transaction;
	
	public BusPassengerDao(){
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
	
	public Integer create(BusPassenger entity) {
		return (Integer) getSession().save(entity);
	}
	
	public void update(BusPassenger entity){
		getSession().update(entity);
	}
	
	public BusPassenger readById(Integer id){
		BusPassenger customer = (BusPassenger) getSession().get(BusPassenger.class, id);
		return customer;
	}
	
	public List<BusPassenger> readByOrder(Integer orderId){
		return getSession().createCriteria(BusPassenger.class, "busPassenger").createAlias("busPassenger.order", "order").add(Restrictions.eq("order.orderId", orderId)).list();
	}
	
	public void delete(BusPassenger entity){
		getSession().delete(entity);
	}
	
	public List<BusPassenger> readAll(){
		return getSession().createCriteria(BusPassenger.class).list();
		
	}
	public void deleteAll(){
		List<BusPassenger> entityList = readAll();
		for (BusPassenger entity : entityList) {
			delete(entity);
		}
	}

}

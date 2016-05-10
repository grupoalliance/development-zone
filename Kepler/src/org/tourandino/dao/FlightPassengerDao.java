package org.tourandino.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.tourandino.dao.interfaces.FlightPassengerDaoInterface;
import org.tourandino.hibernate.util.HibernateUtil;
import org.tourandino.model.FlightPassenger;

@SuppressWarnings("unchecked")
public class FlightPassengerDao extends HibernateUtil implements FlightPassengerDaoInterface{
	private Session session;
	private Transaction transaction;
	
	public FlightPassengerDao(){
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
	
	public Integer create(FlightPassenger entity) {
		return (Integer) getSession().save(entity);
	}
	
	public void update(FlightPassenger entity){
		getSession().update(entity);
	}
	
	public FlightPassenger readById(Integer id){
		FlightPassenger customer = (FlightPassenger) getSession().get(FlightPassenger.class, id);
		return customer;
	}
	
	public List<FlightPassenger> readByOrder(Integer orderId){
		return getSession().createCriteria(FlightPassenger.class, "flightPassenger").createAlias("flightPassenger.order", "order")
				.add(Restrictions.eq("order.orderId", orderId)).list();
	}
	
	public void delete(FlightPassenger entity){
		getSession().delete(entity);
	}
	
	public List<FlightPassenger> readAll(){
		return getSession().createCriteria(FlightPassenger.class).list();
		
	}
	public void deleteAll(){
		List<FlightPassenger> entityList = readAll();
		for (FlightPassenger entity : entityList) {
			delete(entity);
		}
	}

}

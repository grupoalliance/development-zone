package org.tourandino.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.tourandino.dao.interfaces.HotelPassengerDaoInterface;
import org.tourandino.hibernate.util.HibernateUtil;
import org.tourandino.model.HotelPassenger;

@SuppressWarnings("unchecked")
public class HotelPassengerDao extends HibernateUtil implements HotelPassengerDaoInterface{
	private Session session;
	private Transaction transaction;
	
	public HotelPassengerDao(){
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
	
	public Integer create(HotelPassenger entity) {
		return (Integer) getSession().save(entity);
	}
	
	public void update(HotelPassenger entity){
		getSession().update(entity);
	}
	
	public HotelPassenger readById(Integer id){
		HotelPassenger customer = (HotelPassenger) getSession().get(HotelPassenger.class, id);
		return customer;
	}
	
	public List<HotelPassenger> readByOrder(Integer orderId){
		return getSession().createCriteria(HotelPassenger.class, "hotelPassenger").createAlias("hotelPassenger.order", "order")
				.add(Restrictions.eq("order.oderId", orderId)).list();
	}
	
	public void delete(HotelPassenger entity){
		getSession().delete(entity);
	}
	
	public List<HotelPassenger> readAll(){
		return getSession().createCriteria(HotelPassenger.class).list();
		
	}
	public void deleteAll(){
		List<HotelPassenger> entityList = readAll();
		for (HotelPassenger entity : entityList) {
			delete(entity);
		}
	}

}

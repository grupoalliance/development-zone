package org.tourandino.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.tourandino.dao.interfaces.PassengerDaoInterface;
import org.tourandino.hibernate.util.HibernateUtil;
import org.tourandino.model.Passenger;

public class PassengerDao extends HibernateUtil implements PassengerDaoInterface{
	private Session session;
	private Transaction transaction;
	
	public PassengerDao(){
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
	
	public Integer create(Passenger entity) {
		return (Integer) getSession().save(entity);
	}
	
	public void update(Passenger entity){
		getSession().update(entity);
	}
	
	public Passenger readById(Integer id){
		Passenger customer = (Passenger) getSession().get(Passenger.class, id);
		return customer;
	}
	
	@SuppressWarnings("unchecked")
	public List<Passenger> readByName(String name){
		return getSession().createCriteria(Passenger.class).add(Restrictions.ilike("passengerFullname", name, MatchMode.ANYWHERE)).list();
	}
	
	public void delete(Passenger entity){
		getSession().delete(entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<Passenger> readAll(){
		return getSession().createCriteria(Passenger.class).list();
		
	}
	public void deleteAll(){
		List<Passenger> entityList = readAll();
		for (Passenger entity : entityList) {
			delete(entity);
		}
	}

}

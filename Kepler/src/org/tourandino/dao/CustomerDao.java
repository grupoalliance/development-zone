package org.tourandino.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.tourandino.dao.interfaces.CustomerDaoInterface;
import org.tourandino.hibernate.util.HibernateUtil;
import org.tourandino.model.Customer;

@SuppressWarnings("unchecked")
public class CustomerDao extends HibernateUtil implements CustomerDaoInterface{

	private Session session;
	private Transaction transaction;
	
	public CustomerDao(){
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
	
	public Integer create(Customer entity) {
		return (Integer) getSession().save(entity);
	}
	
	public void update(Customer entity){
		getSession().update(entity);
	}
	
	public Customer readById(Integer id){
		Customer customer = (Customer) getSession().get(Customer.class, id);
		return customer;
	}
	
	public List<Customer> readByName(String name){
		return getSession().createCriteria(Customer.class).add(Restrictions.ilike("customerFullname", name, MatchMode.ANYWHERE)).list();
	}
	
	public List<Customer> readByCuit(String cuit){
		return getSession().createCriteria(Customer.class).add(Restrictions.ilike("customerCuit", cuit, MatchMode.ANYWHERE)).list();
	}
	
	public void delete(Customer entity){
		getSession().delete(entity);
	}
	
	public List<Customer> readAll(){
		return getSession().createCriteria(Customer.class).list();
		
	}
	public void deleteAll(){
		List<Customer> entityList = readAll();
		for (Customer entity : entityList) {
			delete(entity);
		}
	}
}

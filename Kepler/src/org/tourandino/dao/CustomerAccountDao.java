package org.tourandino.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.tourandino.dao.interfaces.CustomerAccountDaoInterface;
import org.tourandino.hibernate.util.HibernateUtil;
import org.tourandino.model.Customer;
import org.tourandino.model.CustomerAccount;

@SuppressWarnings("unchecked")
public class CustomerAccountDao extends HibernateUtil implements CustomerAccountDaoInterface{

	private Session session;
	private Transaction transaction;
	
	public CustomerAccountDao(){
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
	
	public Integer create(CustomerAccount entity) {
		Integer id = (Integer) getSession().save(entity);
		return id;
	}
	
	public void update(CustomerAccount entity){
		getSession().update(entity);
	}
	
	public CustomerAccount readById(Integer id){
		CustomerAccount customerAccount = (CustomerAccount) getSession().get(CustomerAccount.class, id);
		return customerAccount;
	}
	
	public CustomerAccount readByCustomerId(Integer id){
		CustomerAccount customerAccount = null;
		List<CustomerAccount> entityList = readAll();
		for (CustomerAccount entity : entityList) {
			if(entity.getCustomer().getCustomerId() == id){
				customerAccount = entity;
			}
		}
		return customerAccount;
	}
	
	public CustomerAccount readByCustomer(Customer customer){
		return (CustomerAccount)getSession().createCriteria(CustomerAccount.class, "customerAccount").createAlias("customerAccount.customer", "customer")
				.add(Restrictions.eq("customer.customerId", customer.getCustomerId())).uniqueResult();
	}
	
	public List<CustomerAccount> readByCustomer(String customer){
		return getSession().createCriteria(CustomerAccount.class, "customerAccount").createAlias("customerAccount.customer", "customer")
				.add(Restrictions.ilike("customer.customerFullname", customer, MatchMode.ANYWHERE)).list();
	}
	
	public void delete(CustomerAccount entity){
		getSession().delete(entity);
	}
	
	public List<CustomerAccount> readAll(){
		return getSession().createCriteria(CustomerAccount.class).list();
		
	}
	public void deleteAll(){
		List<CustomerAccount> entityList = readAll();
		for (CustomerAccount entity : entityList) {
			delete(entity);
		}
	}
}

package org.tourandino.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.tourandino.dao.interfaces.PaymentDaoInterface;
import org.tourandino.hibernate.util.HibernateUtil;
import org.tourandino.model.Payment;

@SuppressWarnings("unchecked")
public class PaymentDao extends HibernateUtil implements PaymentDaoInterface{
	private Session session;
	private Transaction transaction;
	
	public PaymentDao(){
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
	
	public Integer create(Payment entity) {
		return (Integer) getSession().save(entity);
	}
	
	public void update(Payment entity){
		getSession().update(entity);
	}
	
	public Payment readById(Integer id){
		Payment customer = (Payment) getSession().get(Payment.class, id);
		return customer;
	}
	
	public List<Payment> readByOrder(Integer orderId){
		return getSession().createCriteria(Payment.class, "payment").createAlias("payment.order", "order")
				.add(Restrictions.eq("order.orderId", orderId)).list();
	}
	
	public void delete(Payment entity){
		getSession().delete(entity);
	}
	
	public List<Payment> readAll(){
		return getSession().createCriteria(Payment.class).list();
		
	}
	public void deleteAll(){
		List<Payment> entityList = readAll();
		for (Payment entity : entityList) {
			delete(entity);
		}
	}

}

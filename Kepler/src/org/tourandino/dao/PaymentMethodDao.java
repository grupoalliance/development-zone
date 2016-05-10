package org.tourandino.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.tourandino.dao.interfaces.PaymentMethodDaoInterface;
import org.tourandino.hibernate.util.HibernateUtil;
import org.tourandino.model.PaymentMethod;

@SuppressWarnings("unchecked")
public class PaymentMethodDao extends HibernateUtil implements PaymentMethodDaoInterface{
	private Session session;
	private Transaction transaction;
	
	public PaymentMethodDao(){
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
	
	public void create(PaymentMethod entity) {
		getSession().save(entity);
	}
	
	public void update(PaymentMethod entity){
		getSession().update(entity);
	}
	
	public PaymentMethod readById(Integer id){
		PaymentMethod paymentMethod = (PaymentMethod) getSession().get(PaymentMethod.class, id);
		return paymentMethod;
	}
	
	public void delete(PaymentMethod entity){
		getSession().delete(entity);
	}
	
	public List<PaymentMethod> readAll(){
		return getSession().createCriteria(PaymentMethod.class).list();
		
	}
	public void deleteAll(){
		List<PaymentMethod> entityList = readAll();
		for (PaymentMethod entity : entityList) {
			delete(entity);
		}
	}

}

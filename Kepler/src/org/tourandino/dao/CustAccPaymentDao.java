package org.tourandino.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.tourandino.dao.interfaces.CustAccPaymentDaoInterface;
import org.tourandino.hibernate.util.HibernateUtil;
import org.tourandino.model.CustAccPayment;

@SuppressWarnings("unchecked")
public class CustAccPaymentDao extends HibernateUtil implements CustAccPaymentDaoInterface{
	private Session session;
	private Transaction transaction;
	
	public CustAccPaymentDao(){
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
	
	public Integer create(CustAccPayment entity) {
		return (Integer) getSession().save(entity);
	}
	
	public void update(CustAccPayment entity){
		getSession().update(entity);
	}
	
	public CustAccPayment readById(Integer id){
		CustAccPayment entity = (CustAccPayment) getSession().get(CustAccPayment.class, id);
		return entity;
	}
	
	public void delete(CustAccPayment entity){
		getSession().delete(entity);
	}
	
	public List<CustAccPayment> readAll(){
		return getSession().createCriteria(CustAccPayment.class).list();
		
	}
	public void deleteAll(){
		List<CustAccPayment> entityList = readAll();
		for (CustAccPayment entity : entityList) {
			delete(entity);
		}
	}

}

package org.tourandino.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.tourandino.dao.interfaces.TaxConditionDaoInterface;
import org.tourandino.hibernate.util.HibernateUtil;
import org.tourandino.model.TaxCondition;

public class TaxConditionDao extends HibernateUtil implements TaxConditionDaoInterface{

	private Session session;
	private Transaction transaction;
	
	public TaxConditionDao(){
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
	
	public Integer create(TaxCondition entity) {
		return (Integer) getSession().save(entity);
	}
	
	public void update(TaxCondition entity){
		getSession().update(entity);
	}
	
	public TaxCondition readById(Integer id){
		TaxCondition entity = (TaxCondition) getSession().get(TaxCondition.class, id);
		return entity;
	}
	
	public void delete(TaxCondition entity){
		getSession().delete(entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<TaxCondition> readAll(){
		return getSession().createCriteria(TaxCondition.class).list();
		
	}
	public void deleteAll(){
		List<TaxCondition> entityList = readAll();
		for (TaxCondition entity : entityList) {
			delete(entity);
		}
	}
}

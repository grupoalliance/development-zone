package org.tourandino.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.tourandino.dao.interfaces.ErrorLogDaoInterface;
import org.tourandino.hibernate.util.HibernateUtil;
import org.tourandino.model.ErrorLog;

public class ErrorLogDao extends HibernateUtil implements ErrorLogDaoInterface{

	private Session session;
	private Transaction transaction;
	
	public ErrorLogDao(){
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
	
	public Integer create(ErrorLog entity) {
		Integer id = (Integer) getSession().save(entity);
		return id;
	}
	
	public void update(ErrorLog entity){
		getSession().update(entity);
	}
	
	public ErrorLog readById(Integer errorLogId){
		ErrorLog errorLog = (ErrorLog) getSession().get(ErrorLog.class, errorLogId);
		return errorLog;
	}
	
	public void delete(ErrorLog entity){
		getSession().delete(entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<ErrorLog> readAll(){
		return getSession().createCriteria(ErrorLog.class).list();
		
	}
	public void deleteAll(){
		List<ErrorLog> entityList = readAll();
		for (ErrorLog entity : entityList) {
			delete(entity);
		}
	}
}

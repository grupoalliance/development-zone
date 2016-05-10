package org.tourandino.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.tourandino.dao.interfaces.UserSessionDaoInterface;
import org.tourandino.hibernate.util.HibernateUtil;
import org.tourandino.model.UserSession;

public class UserSessionDao extends HibernateUtil implements UserSessionDaoInterface{
	private Session session;
	private Transaction transaction;
	
	public UserSessionDao(){
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
	
	public Integer create(UserSession entity) {
		int r = (Integer) getSession().save(entity);
		return r;
	}
	
	public void update(UserSession entity){
		getSession().update(entity);
	}
	
	public UserSession readById(Integer userSessionId){
		UserSession userSession = (UserSession) getSession().get(UserSession.class, userSessionId);
		return userSession;
	}
	
	public void delete(UserSession entity){
		getSession().delete(entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<UserSession> readAll(){
		return getSession().createCriteria(UserSession.class).list();
		
	}
	public void deleteAll(){
		List<UserSession> entityList = readAll();
		for (UserSession entity : entityList) {
			delete(entity);
		}
	}
}

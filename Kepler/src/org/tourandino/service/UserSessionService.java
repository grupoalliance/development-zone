package org.tourandino.service;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.tourandino.controller.ErrorLogController;
import org.tourandino.dao.UserSessionDao;
import org.tourandino.model.UserSession;

public class UserSessionService {

	private UserSessionDao userSessionDao;
	private ErrorLogController errorLogController;
	
	public UserSessionService(){
		userSessionDao = new UserSessionDao();
		this.errorLogController = new ErrorLogController();
	}
	
	public Integer create(UserSession entity) {
		userSessionDao.openSession();
		Integer r;
		try{
			userSessionDao.beginTransaction();
			r = userSessionDao.create(entity);
			userSessionDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			userSessionDao.rollbackTransaction();
			r = -1;
		}
		finally{
			userSessionDao.closeSession();
		}
		return r;
	}
	
	public void update(UserSession userSession, Date date, Boolean isClosed) {
		userSessionDao.openSession();
		try{
			userSession.setUserSessionEndtime(date);
			userSession.setUserSessionIsClosed(isClosed);
			userSessionDao.beginTransaction();
			userSessionDao.update(userSession);
			userSessionDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			userSessionDao.rollbackTransaction();
		}
		finally{
			userSessionDao.closeSession();
		}
	}
	
	public UserSession readById(Integer userSessionId) {
		userSessionDao.openSession();
		UserSession userSession = null;
		try{
			userSession = userSessionDao.readById(userSessionId);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			userSessionDao.closeSession();
		}
		return userSession;
	}
	
	public void delete(Integer userSessionId) {
		userSessionDao.openSession();
		try{
			UserSession userSession = userSessionDao.readById(userSessionId);
			userSessionDao.beginTransaction();
			userSessionDao.delete(userSession);
			userSessionDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			userSessionDao.rollbackTransaction();
		}
		finally{
			userSessionDao.closeSession();
		}
	}
	
	public List<UserSession> readAll() {
		userSessionDao.openSession();
		List<UserSession> userSessions = null;
		try{
			userSessions = userSessionDao.readAll();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			userSessionDao.closeSession();
		}
	    return userSessions;
	}
	
	public void deleteAll() {
		userSessionDao.openSession();
		try{
			userSessionDao.beginTransaction();
			userSessionDao.deleteAll();
			userSessionDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			userSessionDao.rollbackTransaction();
		}
		finally{
			userSessionDao.closeSession();
		}
	}
}

package org.tourandino.service;

import java.util.List;

import org.tourandino.dao.ErrorLogDao;
import org.tourandino.model.ErrorLog;

public class ErrorLogService {

	private ErrorLogDao errorLogDao;
	
	public ErrorLogService(){
		errorLogDao = new ErrorLogDao();
	}
	
	public Integer create(ErrorLog entity) {
		errorLogDao.openSession();
		Integer id;
		try{
			errorLogDao.beginTransaction();
			id = errorLogDao.create(entity);
			errorLogDao.commitTransaction();
		}
		catch(Exception e){
			e.printStackTrace();
			errorLogDao.rollbackTransaction();
			id = 0;
		}
		finally{
			errorLogDao.closeSession();
		}
		return id;
	}
	
	public void update(ErrorLog entity) {
		errorLogDao.openSession();
		try{
			errorLogDao.beginTransaction();
			errorLogDao.update(entity);
			errorLogDao.commitTransaction();
		}
		catch(Exception e){
			e.printStackTrace();
			errorLogDao.rollbackTransaction();
		}
		finally{
			errorLogDao.closeSession();
		}
	}
	
	public ErrorLog readById(Integer errorLogId) {
		errorLogDao.openSession();
		ErrorLog errorLog = null;
		try{
			errorLog = errorLogDao.readById(errorLogId);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			errorLogDao.closeSession();
		}
		return errorLog;
	}
	
	public void delete(Integer errorLogId) {
		errorLogDao.openSession();
		try{
			ErrorLog errorLog = errorLogDao.readById(errorLogId);
			errorLogDao.beginTransaction();
			errorLogDao.delete(errorLog);
			errorLogDao.commitTransaction();
		}
		catch(Exception e){
			e.printStackTrace();
			errorLogDao.rollbackTransaction();
		}
		finally{
			errorLogDao.closeSession();
		}
	}
	
	public List<ErrorLog> readAll() {
		errorLogDao.openSession();
		List<ErrorLog> errorLogs = null;
		try{
			errorLogs = errorLogDao.readAll();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			errorLogDao.closeSession();
		}
	    return errorLogs;
	}
	
	public void deleteAll() {
		errorLogDao.openSession();
		try{
			errorLogDao.beginTransaction();
			errorLogDao.deleteAll();
			errorLogDao.commitTransaction();
		}
		catch(Exception e){
			e.printStackTrace();
			errorLogDao.rollbackTransaction();
		}
		finally{
			errorLogDao.closeSession();
		}
	}
	
	
}

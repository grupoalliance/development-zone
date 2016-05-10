package org.tourandino.service;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.tourandino.controller.ErrorLogController;
import org.tourandino.dao.TaxConditionDao;
import org.tourandino.model.TaxCondition;

public class TaxConditionService {

	private TaxConditionDao taxConditionDao;
	private ErrorLogController errorLogController;
	
	public TaxConditionService(){
		this.taxConditionDao = new TaxConditionDao();
		this.errorLogController = new ErrorLogController();
	}
	
	public Integer create(TaxCondition entity) {
		taxConditionDao.openSession();
		Integer id;
		try{
			taxConditionDao.beginTransaction();
			id = taxConditionDao.create(entity);
			taxConditionDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			taxConditionDao.rollbackTransaction();
			id = 0;
		}
		finally{
			taxConditionDao.closeSession();
		}
		return id;
	}
	
	public void update(TaxCondition entity) {
		taxConditionDao.openSession();
		try{
			taxConditionDao.beginTransaction();
			taxConditionDao.update(entity);
			taxConditionDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			taxConditionDao.rollbackTransaction();
		}
		finally{
			taxConditionDao.closeSession();
		}
	}
	
	public TaxCondition readById(Integer id) {
		taxConditionDao.openSession();
		TaxCondition taxCondition = null;
		try{
			taxCondition = taxConditionDao.readById(id);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			taxConditionDao.closeSession();
		}
		return taxCondition;
	}
	
	public void delete(Integer id) {
		taxConditionDao.openSession();
		try{
			TaxCondition taxCondition = taxConditionDao.readById(id);
			taxConditionDao.beginTransaction();
			taxConditionDao.delete(taxCondition);
			taxConditionDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			taxConditionDao.rollbackTransaction();
		}
		finally{
			taxConditionDao.closeSession();
		}
	}
	
	public List<TaxCondition> readAll() {
		taxConditionDao.openSession();
		List<TaxCondition> taxConditions = null;
		try{
			taxConditions = taxConditionDao.readAll();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			taxConditionDao.closeSession();
		}
	    return taxConditions;
	}
	
	public void deleteAll() {
		taxConditionDao.openSession();
		try{
			taxConditionDao.beginTransaction();
			taxConditionDao.deleteAll();
			taxConditionDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			taxConditionDao.rollbackTransaction();
		}
		finally{
			taxConditionDao.closeSession();
		}
	}
}

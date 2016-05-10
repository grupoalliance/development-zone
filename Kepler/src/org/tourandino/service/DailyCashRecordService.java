package org.tourandino.service;

import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.tourandino.controller.ErrorLogController;
import org.tourandino.dao.DailyCashRecordDao;
import org.tourandino.model.DailyCashRecord;

public class DailyCashRecordService {
	private DailyCashRecordDao dailyCashRecordDao;
	private ErrorLogController errorLogController;
	
	public DailyCashRecordService(){
		this.dailyCashRecordDao = new DailyCashRecordDao();
		this.errorLogController = new ErrorLogController();
	}
	
	public Integer create(DailyCashRecord entity) {
		dailyCashRecordDao.openSession();
		Integer id;
		try{
			dailyCashRecordDao.beginTransaction();
			id = dailyCashRecordDao.create(entity);
			dailyCashRecordDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			dailyCashRecordDao.rollbackTransaction();
			id = 0;
		}
		finally{
			dailyCashRecordDao.closeSession();
		}
		return id;
	}
	
	public void update(DailyCashRecord entity) {
		dailyCashRecordDao.openSession();
		try{
			dailyCashRecordDao.beginTransaction();
			dailyCashRecordDao.update(entity);
			dailyCashRecordDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			dailyCashRecordDao.rollbackTransaction();
		}
		finally{
			dailyCashRecordDao.closeSession();
		}
	}
	
	public DailyCashRecord readById(Integer id) {
		dailyCashRecordDao.openSession();
		DailyCashRecord dailyCashRecord = null;
		try{
			dailyCashRecord = dailyCashRecordDao.readById(id);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			dailyCashRecordDao.closeSession();
		}
		return dailyCashRecord;
	}
	
	public DailyCashRecord readDailyCashRecord(){
		dailyCashRecordDao.openSession();
		DailyCashRecord dailyCashRecord = null;
		try{
			dailyCashRecord = dailyCashRecordDao.readDailyCashRecord();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			dailyCashRecordDao.closeSession();
		}
		return dailyCashRecord;
	}
	
	public List<DailyCashRecord> readByDate(Date dateFrom, Date dateTo){
		dailyCashRecordDao.openSession();
		List<DailyCashRecord> dailyCashRecords = null;
		try{
			dailyCashRecords = dailyCashRecordDao.readByDate(dateFrom, dateTo);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			dailyCashRecordDao.closeSession();
		}
		return dailyCashRecords;
	}
	
	public void delete(Integer userId) {
		dailyCashRecordDao.openSession();
		try{
			DailyCashRecord dailyCashRecord = dailyCashRecordDao.readById(userId);
			dailyCashRecordDao.beginTransaction();
			dailyCashRecordDao.delete(dailyCashRecord);
			dailyCashRecordDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			dailyCashRecordDao.rollbackTransaction();
		}
		finally{
			dailyCashRecordDao.closeSession();
		}
	}
	
	public List<DailyCashRecord> readAll() {
		dailyCashRecordDao.openSession();
		List<DailyCashRecord> dailyCashRecords = null;
		try{
			dailyCashRecords = dailyCashRecordDao.readAll();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			dailyCashRecordDao.closeSession();
		}
	    return dailyCashRecords;
	}
	
	public void deleteAll() {
		dailyCashRecordDao.openSession();
		try{
			dailyCashRecordDao.beginTransaction();
			dailyCashRecordDao.deleteAll();
			dailyCashRecordDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			dailyCashRecordDao.rollbackTransaction();
		}
		finally{
			dailyCashRecordDao.closeSession();
		}
	}

}

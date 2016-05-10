package org.tourandino.service;

import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.tourandino.controller.ErrorLogController;
import org.tourandino.dao.CashMovementDao;
import org.tourandino.model.CashMovement;
import org.tourandino.model.DailyCashRecord;

public class CashMovementService {
	private CashMovementDao cashMovementDao;
	private ErrorLogController errorLogController;
	
	public CashMovementService(){
		this.cashMovementDao = new CashMovementDao();
		this.errorLogController = new ErrorLogController();
	}
	
	public Integer create(CashMovement entity) {
		cashMovementDao.openSession();
		Integer id;
		try{
			cashMovementDao.beginTransaction();
			id = cashMovementDao.create(entity);
			cashMovementDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			cashMovementDao.rollbackTransaction();
			id = 0;
		}
		finally{
			cashMovementDao.closeSession();
		}
		if(id>0){
			DailyCashRecord dailyCashRecord = entity.getDailyCashRecord();
			dailyCashRecord.setBalance(dailyCashRecord.getBalance()+entity.getCashMovementIncome()-entity.getCashMovementOutcome());
			dailyCashRecord.setIncomeTotal(dailyCashRecord.getIncomeTotal()+entity.getCashMovementIncome());
			dailyCashRecord.setOutcomeTotal(dailyCashRecord.getOutcomeTotal()+entity.getCashMovementOutcome());
			DailyCashRecordService svc = new DailyCashRecordService();
			svc.update(dailyCashRecord);
		}
		return id;
	}
	
	public void update(CashMovement entity) {
		cashMovementDao.openSession();
		try{
			cashMovementDao.beginTransaction();
			cashMovementDao.update(entity);
			cashMovementDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			cashMovementDao.rollbackTransaction();
		}
		finally{
			cashMovementDao.closeSession();
		}
	}
	
	public CashMovement readById(Integer cashMovementId) {
		cashMovementDao.openSession();
		CashMovement cashMovement = null;
		try{
			cashMovement = cashMovementDao.readById(cashMovementId);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			cashMovementDao.closeSession();
		}
		return cashMovement;
	}
	
	public List<CashMovement> read(Date dateFrom, Date dateTo) {
		cashMovementDao.openSession();
		List<CashMovement> cashMovements = null;
		try{
			cashMovements = cashMovementDao.read(dateFrom, dateTo);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			cashMovementDao.closeSession();
		}
		return cashMovements;
	}
	
	public List<CashMovement> readByDescr(String search, Date dateFrom, Date dateTo) {
		cashMovementDao.openSession();
		List<CashMovement> cashMovements = null;
		try{
			cashMovements = cashMovementDao.readByDescr(search, dateFrom, dateTo);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			cashMovementDao.closeSession();
		}
		return cashMovements;
	}
	
	public List<CashMovement> readByDescr(String search) {
		cashMovementDao.openSession();
		List<CashMovement> cashMovements = null;
		try{
			cashMovements = cashMovementDao.readByDescr(search);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			cashMovementDao.closeSession();
		}
		return cashMovements;
	}
	
	public List<CashMovement> readByDailyCash(Integer dailyCashId) {
		cashMovementDao.openSession();
		List<CashMovement> cashMovements = null;
		try{
			cashMovements = cashMovementDao.readByDailyCash(dailyCashId);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			cashMovementDao.closeSession();
		}
		return cashMovements;
	}
	
	public void delete(Integer cashMovementId) {
		cashMovementDao.openSession();
		try{
			CashMovement cashMovement = cashMovementDao.readById(cashMovementId);
			cashMovementDao.beginTransaction();
			cashMovementDao.delete(cashMovement);
			cashMovementDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			cashMovementDao.rollbackTransaction();
		}
		finally{
			cashMovementDao.closeSession();
		}
	}
	
	public List<CashMovement> readAll() {
		cashMovementDao.openSession();
		List<CashMovement> cashMovements = null;
		try{
			cashMovements = cashMovementDao.readAll();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			cashMovementDao.closeSession();
		}
	    return cashMovements;
	}
	
	public void deleteAll() {
		cashMovementDao.openSession();
		try{
			cashMovementDao.beginTransaction();
			cashMovementDao.deleteAll();
			cashMovementDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			cashMovementDao.rollbackTransaction();
		}
		finally{
			cashMovementDao.closeSession();
		}
	}

}

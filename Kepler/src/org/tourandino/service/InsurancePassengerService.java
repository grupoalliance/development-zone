package org.tourandino.service;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.tourandino.controller.ErrorLogController;
import org.tourandino.dao.InsurancePassengerDao;
import org.tourandino.model.InsurancePassenger;

public class InsurancePassengerService {
	private InsurancePassengerDao insurancePassengerDao;
	private ErrorLogController errorLogController;
	
	public InsurancePassengerService(){
		this.insurancePassengerDao = new InsurancePassengerDao();
		this.errorLogController = new ErrorLogController();
	}
	
	public Integer create(InsurancePassenger entity) {
		insurancePassengerDao.openSession();
		Integer id;
		try{
			insurancePassengerDao.beginTransaction();
			id = insurancePassengerDao.create(entity);
			insurancePassengerDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			insurancePassengerDao.rollbackTransaction();
			id = 0;
		}
		finally{
			insurancePassengerDao.closeSession();
		}
		return id;
	}
	
	public void update(InsurancePassenger entity) {
		insurancePassengerDao.openSession();
		try{
			insurancePassengerDao.beginTransaction();
			insurancePassengerDao.update(entity);
			insurancePassengerDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			insurancePassengerDao.rollbackTransaction();
		}
		finally{
			insurancePassengerDao.closeSession();
		}
	}
	
	public InsurancePassenger readById(Integer id) {
		insurancePassengerDao.openSession();
		InsurancePassenger insurancePassenger = null;
		try{
			insurancePassenger = insurancePassengerDao.readById(id);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			insurancePassengerDao.closeSession();
		}
		return insurancePassenger;
	}
	
	public List<InsurancePassenger> readByOrder(Integer orderId) {
		insurancePassengerDao.openSession();
		List<InsurancePassenger> insurancePassengers = null;
		try{
			insurancePassengers = insurancePassengerDao.readByOrder(orderId);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			insurancePassengerDao.closeSession();
		}
		return insurancePassengers;
	}
	
	public void delete(Integer userId) {
		insurancePassengerDao.openSession();
		try{
			InsurancePassenger insurancePassenger = insurancePassengerDao.readById(userId);
			insurancePassengerDao.beginTransaction();
			insurancePassengerDao.delete(insurancePassenger);
			insurancePassengerDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			insurancePassengerDao.rollbackTransaction();
		}
		finally{
			insurancePassengerDao.closeSession();
		}
	}
	
	public List<InsurancePassenger> readAll() {
		insurancePassengerDao.openSession();
		List<InsurancePassenger> insurancePassengers = null;
		try{
			insurancePassengers = insurancePassengerDao.readAll();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			insurancePassengerDao.closeSession();
		}
	    return insurancePassengers;
	}
	
	public void deleteAll() {
		insurancePassengerDao.openSession();
		try{
			insurancePassengerDao.beginTransaction();
			insurancePassengerDao.deleteAll();
			insurancePassengerDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			insurancePassengerDao.rollbackTransaction();
		}
		finally{
			insurancePassengerDao.closeSession();
		}
	}

}

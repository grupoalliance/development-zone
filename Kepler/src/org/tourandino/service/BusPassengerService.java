package org.tourandino.service;

import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.tourandino.controller.ErrorLogController;
import org.tourandino.dao.BusPassengerDao;
import org.tourandino.model.BusPassenger;

public class BusPassengerService {
	private BusPassengerDao busPassengerDao;
	private ErrorLogController errorLogController;
	
	public BusPassengerService(){
		this.busPassengerDao = new BusPassengerDao();
		this.errorLogController = new ErrorLogController();
	}
	
	public Integer create(BusPassenger entity) {
		busPassengerDao.openSession();
		Integer id;
		try{
			busPassengerDao.beginTransaction();
			id = busPassengerDao.create(entity);
			busPassengerDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			busPassengerDao.rollbackTransaction();
			id = 0;
		}
		finally{
			busPassengerDao.closeSession();
		}
		return id;
	}
	
	public void update(BusPassenger entity) {
		busPassengerDao.openSession();
		try{
			busPassengerDao.beginTransaction();
			busPassengerDao.update(entity);
			busPassengerDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			busPassengerDao.rollbackTransaction();
		}
		finally{
			busPassengerDao.closeSession();
		}
	}
	
	public BusPassenger readById(Integer id) {
		busPassengerDao.openSession();
		BusPassenger busPassenger = null;
		try{
			busPassenger = busPassengerDao.readById(id);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			busPassengerDao.closeSession();
		}
		return busPassenger;
	}
	
	public List<BusPassenger> readByOrder(Integer orderId) {
		busPassengerDao.openSession();
		List<BusPassenger> busPassengers = null;
		try{
			busPassengers = busPassengerDao.readByOrder(orderId);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			busPassengerDao.closeSession();
		}
		return busPassengers;
	}
	
	public void delete(Integer userId) {
		busPassengerDao.openSession();
		try{
			BusPassenger busPassenger = busPassengerDao.readById(userId);
			busPassengerDao.beginTransaction();
			busPassengerDao.delete(busPassenger);
			busPassengerDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			busPassengerDao.rollbackTransaction();
		}
		finally{
			busPassengerDao.closeSession();
		}
	}
	
	public List<BusPassenger> readAll() {
		busPassengerDao.openSession();
		List<BusPassenger> busPassengers = null;
		try{
			busPassengers = busPassengerDao.readAll();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			busPassengerDao.closeSession();
		}
	    return busPassengers;
	}
	
	public void deleteAll() {
		busPassengerDao.openSession();
		try{
			busPassengerDao.beginTransaction();
			busPassengerDao.deleteAll();
			busPassengerDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			busPassengerDao.rollbackTransaction();
		}
		finally{
			busPassengerDao.closeSession();
		}
	}

}

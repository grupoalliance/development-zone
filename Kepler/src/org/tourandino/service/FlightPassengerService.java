package org.tourandino.service;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.tourandino.controller.ErrorLogController;
import org.tourandino.dao.FlightPassengerDao;
import org.tourandino.model.FlightPassenger;

public class FlightPassengerService {
	private FlightPassengerDao flightPassengerDao;
	private ErrorLogController errorLogController;
	
	public FlightPassengerService(){
		this.flightPassengerDao = new FlightPassengerDao();
		this.errorLogController = new ErrorLogController();
	}
	
	public Integer create(FlightPassenger entity) {
		flightPassengerDao.openSession();
		Integer id;
		try{
			flightPassengerDao.beginTransaction();
			id = flightPassengerDao.create(entity);
			flightPassengerDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			flightPassengerDao.rollbackTransaction();
			id = 0;
		}
		finally{
			flightPassengerDao.closeSession();
		}
		return id;
	}
	
	public void update(FlightPassenger entity) {
		flightPassengerDao.openSession();
		try{
			flightPassengerDao.beginTransaction();
			flightPassengerDao.update(entity);
			flightPassengerDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			flightPassengerDao.rollbackTransaction();
		}
		finally{
			flightPassengerDao.closeSession();
		}
	}
	
	public FlightPassenger readById(Integer id) {
		flightPassengerDao.openSession();
		FlightPassenger flightPassenger = null;
		try{
			flightPassenger = flightPassengerDao.readById(id);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			flightPassengerDao.closeSession();
		}
		return flightPassenger;
	}
	
	public List<FlightPassenger> readByOrder(Integer orderId) {
		flightPassengerDao.openSession();
		List<FlightPassenger> flightPassengers = null;
		try{
			flightPassengers = flightPassengerDao.readByOrder(orderId);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			flightPassengerDao.closeSession();
		}
		return flightPassengers;
	}
	
	public void delete(Integer userId) {
		flightPassengerDao.openSession();
		try{
			FlightPassenger flightPassenger = flightPassengerDao.readById(userId);
			flightPassengerDao.beginTransaction();
			flightPassengerDao.delete(flightPassenger);
			flightPassengerDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			flightPassengerDao.rollbackTransaction();
		}
		finally{
			flightPassengerDao.closeSession();
		}
	}
	
	public List<FlightPassenger> readAll() {
		flightPassengerDao.openSession();
		List<FlightPassenger> flightPassengers = null;
		try{
			flightPassengers = flightPassengerDao.readAll();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			flightPassengerDao.closeSession();
		}
	    return flightPassengers;
	}
	
	public void deleteAll() {
		flightPassengerDao.openSession();
		try{
			flightPassengerDao.beginTransaction();
			flightPassengerDao.deleteAll();
			flightPassengerDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			flightPassengerDao.rollbackTransaction();
		}
		finally{
			flightPassengerDao.closeSession();
		}
	}

}

package org.tourandino.service;

import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.tourandino.controller.ErrorLogController;
import org.tourandino.dao.PassengerDao;
import org.tourandino.model.Passenger;

public class PassengerService {
	private PassengerDao passengerDao;
	private ErrorLogController errorLogController;
	
	public PassengerService(){
		this.passengerDao = new PassengerDao();
		this.errorLogController = new ErrorLogController();
	}
	
	public Integer create(Passenger entity) {
		passengerDao.openSession();
		Integer id;
		try{
			passengerDao.beginTransaction();
			id = passengerDao.create(entity);
			passengerDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			passengerDao.rollbackTransaction();
			id = 0;
		}
		finally{
			passengerDao.closeSession();
		}
		return id;
	}
	
	public void update(Passenger entity) {
		passengerDao.openSession();
		try{
			passengerDao.beginTransaction();
			passengerDao.update(entity);
			passengerDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			passengerDao.rollbackTransaction();
		}
		finally{
			passengerDao.closeSession();
		}
	}
	
	public Passenger readById(Integer id) {
		passengerDao.openSession();
		Passenger passenger = null;
		try{
			passenger = passengerDao.readById(id);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			passengerDao.closeSession();
		}
		return passenger;
	}
	
	public List<Passenger> readByName(String name){
		passengerDao.openSession();
		List<Passenger> passengers = null;
		try{
			passengers = passengerDao.readByName(name);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			passengerDao.closeSession();
		}
		return passengers;
	}
	
	public void delete(Integer userId) {
		passengerDao.openSession();
		try{
			Passenger passenger = passengerDao.readById(userId);
			passengerDao.beginTransaction();
			passengerDao.delete(passenger);
			passengerDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			passengerDao.rollbackTransaction();
		}
		finally{
			passengerDao.closeSession();
		}
	}
	
	public List<Passenger> readAll() {
		passengerDao.openSession();
		List<Passenger> passengers = null;
		try{
			passengers = passengerDao.readAll();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			passengerDao.closeSession();
		}
	    return passengers;
	}
	
	public void deleteAll() {
		passengerDao.openSession();
		try{
			passengerDao.beginTransaction();
			passengerDao.deleteAll();
			passengerDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			passengerDao.rollbackTransaction();
		}
		finally{
			passengerDao.closeSession();
		}
	}

}

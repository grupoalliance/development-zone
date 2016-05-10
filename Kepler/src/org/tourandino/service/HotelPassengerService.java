package org.tourandino.service;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.tourandino.controller.ErrorLogController;
import org.tourandino.dao.HotelPassengerDao;
import org.tourandino.model.HotelPassenger;

public class HotelPassengerService {
	private HotelPassengerDao hotelPassengerDao;
	private ErrorLogController errorLogController;
	
	public HotelPassengerService(){
		this.hotelPassengerDao = new HotelPassengerDao();
		this.errorLogController = new ErrorLogController();
	}
	
	public Integer create(HotelPassenger entity) {
		hotelPassengerDao.openSession();
		Integer id;
		try{
			hotelPassengerDao.beginTransaction();
			id = hotelPassengerDao.create(entity);
			hotelPassengerDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			hotelPassengerDao.rollbackTransaction();
			id = 0;
		}
		finally{
			hotelPassengerDao.closeSession();
		}
		return id;
	}
	
	public void update(HotelPassenger entity) {
		hotelPassengerDao.openSession();
		try{
			hotelPassengerDao.beginTransaction();
			hotelPassengerDao.update(entity);
			hotelPassengerDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			hotelPassengerDao.rollbackTransaction();
		}
		finally{
			hotelPassengerDao.closeSession();
		}
	}
	
	public HotelPassenger readById(Integer id) {
		hotelPassengerDao.openSession();
		HotelPassenger hotelPassenger = null;
		try{
			hotelPassenger = hotelPassengerDao.readById(id);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			hotelPassengerDao.closeSession();
		}
		return hotelPassenger;
	}
	
	public List<HotelPassenger> readByOrder(Integer orderId) {
		hotelPassengerDao.openSession();
		List<HotelPassenger> hotelPassengers = null;
		try{
			hotelPassengers = hotelPassengerDao.readByOrder(orderId);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			hotelPassengerDao.closeSession();
		}
		return hotelPassengers;
	}
	
	public void delete(Integer userId) {
		hotelPassengerDao.openSession();
		try{
			HotelPassenger hotelPassenger = hotelPassengerDao.readById(userId);
			hotelPassengerDao.beginTransaction();
			hotelPassengerDao.delete(hotelPassenger);
			hotelPassengerDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			hotelPassengerDao.rollbackTransaction();
		}
		finally{
			hotelPassengerDao.closeSession();
		}
	}
	
	public List<HotelPassenger> readAll() {
		hotelPassengerDao.openSession();
		List<HotelPassenger> hotelPassengers = null;
		try{
			hotelPassengers = hotelPassengerDao.readAll();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			hotelPassengerDao.closeSession();
		}
	    return hotelPassengers;
	}
	
	public void deleteAll() {
		hotelPassengerDao.openSession();
		try{
			hotelPassengerDao.beginTransaction();
			hotelPassengerDao.deleteAll();
			hotelPassengerDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			hotelPassengerDao.rollbackTransaction();
		}
		finally{
			hotelPassengerDao.closeSession();
		}
	}

}

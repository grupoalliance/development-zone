package org.tourandino.service;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.tourandino.controller.ErrorLogController;
import org.tourandino.dao.PackagePassengerDao;
import org.tourandino.model.PackagePassenger;

public class PackagePassengerService {
	private PackagePassengerDao packagePassengerDao;
	private ErrorLogController errorLogController;
	
	public PackagePassengerService(){
		this.packagePassengerDao = new PackagePassengerDao();
		this.errorLogController = new ErrorLogController();
	}
	
	public Integer create(PackagePassenger entity) {
		packagePassengerDao.openSession();
		Integer id;
		try{
			packagePassengerDao.beginTransaction();
			id = packagePassengerDao.create(entity);
			packagePassengerDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			packagePassengerDao.rollbackTransaction();
			id = 0;
		}
		finally{
			packagePassengerDao.closeSession();
		}
		return id;
	}
	
	public void update(PackagePassenger entity) {
		packagePassengerDao.openSession();
		try{
			packagePassengerDao.beginTransaction();
			packagePassengerDao.update(entity);
			packagePassengerDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			packagePassengerDao.rollbackTransaction();
		}
		finally{
			packagePassengerDao.closeSession();
		}
	}
	
	public PackagePassenger readById(Integer id) {
		packagePassengerDao.openSession();
		PackagePassenger packagePassenger = null;
		try{
			packagePassenger = packagePassengerDao.readById(id);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			packagePassengerDao.closeSession();
		}
		return packagePassenger;
	}
	
	public List<PackagePassenger> readByOrder(Integer orderId) {
		packagePassengerDao.openSession();
		List<PackagePassenger> packagePassengers = null;
		try{
			packagePassengers = packagePassengerDao.readByOrder(orderId);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			packagePassengerDao.closeSession();
		}
		return packagePassengers;
	}
	
	public void delete(Integer userId) {
		packagePassengerDao.openSession();
		try{
			PackagePassenger packagePassenger = packagePassengerDao.readById(userId);
			packagePassengerDao.beginTransaction();
			packagePassengerDao.delete(packagePassenger);
			packagePassengerDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			packagePassengerDao.rollbackTransaction();
		}
		finally{
			packagePassengerDao.closeSession();
		}
	}
	
	public List<PackagePassenger> readAll() {
		packagePassengerDao.openSession();
		List<PackagePassenger> packagePassengers = null;
		try{
			packagePassengers = packagePassengerDao.readAll();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			packagePassengerDao.closeSession();
		}
	    return packagePassengers;
	}
	
	public void deleteAll() {
		packagePassengerDao.openSession();
		try{
			packagePassengerDao.beginTransaction();
			packagePassengerDao.deleteAll();
			packagePassengerDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			packagePassengerDao.rollbackTransaction();
		}
		finally{
			packagePassengerDao.closeSession();
		}
	}

}

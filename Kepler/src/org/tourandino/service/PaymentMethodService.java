package org.tourandino.service;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.tourandino.controller.ErrorLogController;
import org.tourandino.dao.PaymentMethodDao;
import org.tourandino.model.PaymentMethod;

public class PaymentMethodService {
	private PaymentMethodDao paymentMethodDao;
	private ErrorLogController errorLogController;
	
	public PaymentMethodService(){
		this.paymentMethodDao = new PaymentMethodDao();
		this.errorLogController = new ErrorLogController();
	}
	
	public void create(PaymentMethod entity) {
		paymentMethodDao.openSession();
		try{
			paymentMethodDao.beginTransaction();
			paymentMethodDao.create(entity);
			paymentMethodDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			paymentMethodDao.rollbackTransaction();
		}
		finally{
			paymentMethodDao.closeSession();
		}
	}
	
	public void update(PaymentMethod entity) {
		paymentMethodDao.openSession();
		try{
			paymentMethodDao.beginTransaction();
			paymentMethodDao.update(entity);
			paymentMethodDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			paymentMethodDao.rollbackTransaction();
		}
		finally{
			paymentMethodDao.closeSession();
		}
	}
	
	public PaymentMethod readById(Integer paymentMethodId) {
		paymentMethodDao.openSession();
		PaymentMethod paymentMethod = null;
		try{
			paymentMethod = paymentMethodDao.readById(paymentMethodId);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			paymentMethodDao.closeSession();
		}
		return paymentMethod;
	}
	
	public void delete(Integer paymentMethodId) {
		paymentMethodDao.openSession();
		try{
			PaymentMethod paymentMethod = paymentMethodDao.readById(paymentMethodId);
			paymentMethodDao.beginTransaction();
			paymentMethodDao.delete(paymentMethod);
			paymentMethodDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			paymentMethodDao.rollbackTransaction();
		}
		finally{
			paymentMethodDao.closeSession();
		}
	}
	
	public List<PaymentMethod> readAll() {
		paymentMethodDao.openSession();
		List<PaymentMethod> paymentMethods = null;
		try{
			paymentMethods = paymentMethodDao.readAll();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			paymentMethodDao.closeSession();
		}
	    return paymentMethods;
	}
	
	public void deleteAll() {
		paymentMethodDao.openSession();
		try{
			paymentMethodDao.beginTransaction();
			paymentMethodDao.deleteAll();
			paymentMethodDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			paymentMethodDao.rollbackTransaction();
		}
		finally{
			paymentMethodDao.closeSession();
		}
	}

}

package org.tourandino.service;

import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.tourandino.controller.ErrorLogController;
import org.tourandino.dao.PaymentDao;
import org.tourandino.model.Payment;

public class PaymentService {
	private PaymentDao paymentDao;
	private ErrorLogController errorLogController;
	
	public PaymentService(){
		this.errorLogController = new ErrorLogController();
		this.paymentDao = new PaymentDao();
	}
	
	public Integer create(Payment entity) {
		paymentDao.openSession();
		Integer id;
		try{
			paymentDao.beginTransaction();
			id = paymentDao.create(entity);
			paymentDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			paymentDao.rollbackTransaction();
			id = 0;
		}
		finally{
			paymentDao.closeSession();
		}
		return id;
	}
	
	public void update(Payment entity) {
		paymentDao.openSession();
		try{
			paymentDao.beginTransaction();
			paymentDao.update(entity);
			paymentDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			paymentDao.rollbackTransaction();
		}
		finally{
			paymentDao.closeSession();
		}
	}
	
	public Payment readById(Integer id) {
		paymentDao.openSession();
		Payment payment = null;
		try{
			payment = paymentDao.readById(id);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			paymentDao.closeSession();
		}
		return payment;
	}
	
	public List<Payment> readByOrder(Integer id) {
		paymentDao.openSession();
		List<Payment> payments = null;
		try{
			payments = paymentDao.readByOrder(id);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			paymentDao.closeSession();
		}
		return payments;
	}
	
	public void delete(Integer userId) {
		paymentDao.openSession();
		try{
			Payment payment = paymentDao.readById(userId);
			paymentDao.beginTransaction();
			paymentDao.delete(payment);
			paymentDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			paymentDao.rollbackTransaction();
		}
		finally{
			paymentDao.closeSession();
		}
	}
	
	public List<Payment> readAll() {
		paymentDao.openSession();
		List<Payment> payments = null;
		try{
			payments = paymentDao.readAll();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			paymentDao.closeSession();
		}
	    return payments;
	}
	
	public void deleteAll() {
		paymentDao.openSession();
		try{
			paymentDao.beginTransaction();
			paymentDao.deleteAll();
			paymentDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			paymentDao.rollbackTransaction();
		}
		finally{
			paymentDao.closeSession();
		}
	}

}

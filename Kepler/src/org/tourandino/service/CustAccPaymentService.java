package org.tourandino.service;

import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.tourandino.controller.ErrorLogController;
import org.tourandino.dao.CustAccPaymentDao;
import org.tourandino.model.CustAccPayment;

public class CustAccPaymentService {
	private CustAccPaymentDao custAccPaymentDao;
	private ErrorLogController errorLogController;
	
	public CustAccPaymentService(){
		this.errorLogController = new ErrorLogController();
		this.custAccPaymentDao = new CustAccPaymentDao();
	}
	
	public Integer create(CustAccPayment entity) {
		custAccPaymentDao.openSession();
		Integer id;
		try{
			custAccPaymentDao.beginTransaction();
			id = custAccPaymentDao.create(entity);
			custAccPaymentDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			custAccPaymentDao.rollbackTransaction();
			id = 0;
		}
		finally{
			custAccPaymentDao.closeSession();
		}
		return id;
	}
	
	public void update(CustAccPayment entity) {
		custAccPaymentDao.openSession();
		try{
			custAccPaymentDao.beginTransaction();
			custAccPaymentDao.update(entity);
			custAccPaymentDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			custAccPaymentDao.rollbackTransaction();
		}
		finally{
			custAccPaymentDao.closeSession();
		}
	}
	
	public CustAccPayment readById(Integer id) {
		custAccPaymentDao.openSession();
		CustAccPayment custAccPayment = null;
		try{
			custAccPayment = custAccPaymentDao.readById(id);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			custAccPaymentDao.closeSession();
		}
		return custAccPayment;
	}
	
	public void delete(Integer userId) {
		custAccPaymentDao.openSession();
		try{
			CustAccPayment custAccPayment = custAccPaymentDao.readById(userId);
			custAccPaymentDao.beginTransaction();
			custAccPaymentDao.delete(custAccPayment);
			custAccPaymentDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			custAccPaymentDao.rollbackTransaction();
		}
		finally{
			custAccPaymentDao.closeSession();
		}
	}
	
	public List<CustAccPayment> readAll() {
		custAccPaymentDao.openSession();
		List<CustAccPayment> custAccPayments = null;
		try{
			custAccPayments = custAccPaymentDao.readAll();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			custAccPaymentDao.closeSession();
		}
	    return custAccPayments;
	}
	
	public void deleteAll() {
		custAccPaymentDao.openSession();
		try{
			custAccPaymentDao.beginTransaction();
			custAccPaymentDao.deleteAll();
			custAccPaymentDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			custAccPaymentDao.rollbackTransaction();
		}
		finally{
			custAccPaymentDao.closeSession();
		}
	}

}

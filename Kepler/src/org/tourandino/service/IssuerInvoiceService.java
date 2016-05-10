package org.tourandino.service;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.tourandino.controller.ErrorLogController;
import org.tourandino.dao.IssuerInvoiceDao;
import org.tourandino.model.IssuerInvoice;

public class IssuerInvoiceService {
	private IssuerInvoiceDao issuerInvoiceDao;
	private ErrorLogController errorLogController;
	
	public IssuerInvoiceService(){
		this.issuerInvoiceDao = new IssuerInvoiceDao();
		this.errorLogController = new ErrorLogController();
	}
	
	public Integer create(IssuerInvoice entity) {
		issuerInvoiceDao.openSession();
		Integer id;
		try{
			issuerInvoiceDao.beginTransaction();
			id = issuerInvoiceDao.create(entity);
			issuerInvoiceDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			issuerInvoiceDao.rollbackTransaction();
			id = 0;
		}
		finally{
			issuerInvoiceDao.closeSession();
		}
		return id;
	}
	
	public void update(IssuerInvoice entity) {
		issuerInvoiceDao.openSession();
		try{
			issuerInvoiceDao.beginTransaction();
			issuerInvoiceDao.update(entity);
			issuerInvoiceDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			issuerInvoiceDao.rollbackTransaction();
		}
		finally{
			issuerInvoiceDao.closeSession();
		}
	}
	
	public IssuerInvoice readById(Integer issuerInvoiceId) {
		issuerInvoiceDao.openSession();
		IssuerInvoice issuerInvoice = null;
		try{
			issuerInvoice = issuerInvoiceDao.readById(issuerInvoiceId);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			issuerInvoiceDao.closeSession();
		}
		return issuerInvoice;
	}
	
	public List<IssuerInvoice> readByDate(Date date) {
		issuerInvoiceDao.openSession();
		List<IssuerInvoice> entities = null;
		try{
			entities = issuerInvoiceDao.readByDate(date);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			issuerInvoiceDao.closeSession();
		}
		return entities;
	}
	
	public List<IssuerInvoice> readByIssuer(String search) {
		issuerInvoiceDao.openSession();
		List<IssuerInvoice> entities = null;
		try{
			entities = issuerInvoiceDao.readByIssuer(search);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			issuerInvoiceDao.closeSession();
		}
		return entities;
	}
	
	public void delete(Integer issuerInvoiceId) {
		issuerInvoiceDao.openSession();
		try{
			IssuerInvoice issuerInvoice = issuerInvoiceDao.readById(issuerInvoiceId);
			issuerInvoiceDao.beginTransaction();
			issuerInvoiceDao.delete(issuerInvoice);
			issuerInvoiceDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			issuerInvoiceDao.rollbackTransaction();
		}
		finally{
			issuerInvoiceDao.closeSession();
		}
	}
	
	public List<IssuerInvoice> readAll() {
		issuerInvoiceDao.openSession();
		List<IssuerInvoice> issuerInvoices = null;
		try{
			issuerInvoices = issuerInvoiceDao.readAll();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			issuerInvoiceDao.closeSession();
		}
	    return issuerInvoices;
	}
	
	public void deleteAll() {
		issuerInvoiceDao.openSession();
		try{
			issuerInvoiceDao.beginTransaction();
			issuerInvoiceDao.deleteAll();
			issuerInvoiceDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			issuerInvoiceDao.rollbackTransaction();
		}
		finally{
			issuerInvoiceDao.closeSession();
		}
	}

}

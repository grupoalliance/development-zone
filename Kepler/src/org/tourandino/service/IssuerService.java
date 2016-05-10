package org.tourandino.service;

import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.tourandino.controller.ErrorLogController;
import org.tourandino.dao.IssuerDao;
import org.tourandino.model.Issuer;;

public class IssuerService {
	private IssuerDao issuerDao;
	private ErrorLogController errorLogController;
	
	public IssuerService(){
		issuerDao = new IssuerDao();
		errorLogController = new ErrorLogController();
	}
	
	public Integer create(Issuer entity) {
		issuerDao.openSession();
		Integer id;
		try{
			issuerDao.beginTransaction();
			id = issuerDao.create(entity);
			issuerDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			issuerDao.rollbackTransaction();
			id = 0;
		}
		finally{
			issuerDao.closeSession();
		}
		return id;
	}
	
	public void update(Issuer entity) {
		issuerDao.openSession();
		try{
			issuerDao.beginTransaction();
			issuerDao.update(entity);
			issuerDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			issuerDao.rollbackTransaction();
		}
		finally{
			issuerDao.closeSession();
		}
	}
	
	public Issuer readById(Integer id) {
		issuerDao.openSession();
		Issuer issuer = null;
		try{
			issuer = issuerDao.readById(id);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			issuerDao.closeSession();
		}
		return issuer;
	}
	
	public List<Issuer> readByName(String search){
		issuerDao.openSession();
		List<Issuer> issuers = null;
		try{
			issuers = issuerDao.readByName(search);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			issuerDao.closeSession();
		}
		return issuers;
	}
	
	public List<Issuer> readByCuit(String search){
		issuerDao.openSession();
		List<Issuer> issuers = null;
		try{
			issuers = issuerDao.readByCuit(search);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			issuerDao.closeSession();
		}
		return issuers;
	}
	
	public void delete(Integer userId) {
		issuerDao.openSession();
		try{
			Issuer issuer = issuerDao.readById(userId);
			issuerDao.beginTransaction();
			issuerDao.delete(issuer);
			issuerDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			issuerDao.rollbackTransaction();
		}
		finally{
			issuerDao.closeSession();
		}
	}
	
	public List<Issuer> readAll() {
		issuerDao.openSession();
		List<Issuer> issuers = null;
		try{
			issuers = issuerDao.readAll();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			issuerDao.closeSession();
		}
	    return issuers;
	}
	
	public void deleteAll() {
		issuerDao.openSession();
		try{
			issuerDao.beginTransaction();
			issuerDao.deleteAll();
			issuerDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			issuerDao.rollbackTransaction();
		}
		finally{
			issuerDao.closeSession();
		}
	}

}

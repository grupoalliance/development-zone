package org.tourandino.service;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.tourandino.controller.ErrorLogController;
import org.tourandino.dao.CustomerAccountDao;
import org.tourandino.model.Customer;
import org.tourandino.model.CustomerAccount;

public class CustomerAccountService {

	private CustomerAccountDao customerAccountDao;
	private ErrorLogController errorLogController;
	
	
	public CustomerAccountService(){
		this.customerAccountDao = new CustomerAccountDao();
		this.errorLogController = new ErrorLogController();
	}
	
	public Integer create(CustomerAccount entity) {
		customerAccountDao.openSession();
		Integer id;
		try{
			customerAccountDao.beginTransaction();
			id = customerAccountDao.create(entity);
			customerAccountDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			customerAccountDao.rollbackTransaction();
			id = 0;
		}
		finally{
			customerAccountDao.closeSession();
		}
		return id;
	}
	
	public void update(CustomerAccount entity) {
		customerAccountDao.openSession();
		try{
			customerAccountDao.beginTransaction();
			customerAccountDao.update(entity);
			customerAccountDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			customerAccountDao.rollbackTransaction();
		}
		finally{
			customerAccountDao.closeSession();
		}
	}
	
	public CustomerAccount readById(Integer customerAccountId) {
		customerAccountDao.openSession();
		CustomerAccount customerAccount = null;
		try{
			customerAccount = customerAccountDao.readById(customerAccountId);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			customerAccountDao.closeSession();
		}
		return customerAccount;
	}
	
	public CustomerAccount readByCustomer(Customer customer) {
		customerAccountDao.openSession();
		CustomerAccount customerAccount = null;
		try{
			customerAccount = customerAccountDao.readByCustomer(customer);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			customerAccountDao.closeSession();
		}
		return customerAccount;
	}
	
	public List<CustomerAccount> readByCustomer(String search) {
		customerAccountDao.openSession();
		List<CustomerAccount> customerAccount = null;
		try{
			customerAccount = customerAccountDao.readByCustomer(search);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			customerAccountDao.closeSession();
		}
		return customerAccount;
	}
	
	public void delete(Integer customerAccountId) {
		customerAccountDao.openSession();
		try{
			CustomerAccount customerAccount = customerAccountDao.readById(customerAccountId);
			customerAccountDao.beginTransaction();
			customerAccountDao.delete(customerAccount);
			customerAccountDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			customerAccountDao.rollbackTransaction();
		}
		finally{
			customerAccountDao.closeSession();
		}
	}
	
	public List<CustomerAccount> readAll() {
		customerAccountDao.openSession();
		List<CustomerAccount> customerAccounts = null;
		try{
			customerAccounts = customerAccountDao.readAll();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			customerAccountDao.closeSession();
		}
	    return customerAccounts;
	}
	
	public void deleteAll() {
		customerAccountDao.openSession();
		try{
			customerAccountDao.beginTransaction();
			customerAccountDao.deleteAll();
			customerAccountDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			customerAccountDao.rollbackTransaction();
		}
		finally{
			customerAccountDao.closeSession();
		}
	}
}

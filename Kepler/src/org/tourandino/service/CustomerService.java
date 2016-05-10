package org.tourandino.service;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.tourandino.controller.ErrorLogController;
import org.tourandino.dao.CustomerDao;
import org.tourandino.model.Customer;

public class CustomerService {

	private CustomerDao customerDao;
	private ErrorLogController errorLogController;
	
	public CustomerService(){
		this.customerDao = new CustomerDao();
		this.errorLogController = new ErrorLogController();
	}
	
	public Integer create(Customer entity) {
		customerDao.openSession();
		Integer id;
		try{
			customerDao.beginTransaction();
			id = customerDao.create(entity);
			customerDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			customerDao.rollbackTransaction();
			id = 0;
		}
		finally{
			customerDao.closeSession();
		}
		return id;
	}
	
	public void update(Customer entity) {
		customerDao.openSession();
		try{
			customerDao.beginTransaction();
			customerDao.update(entity);
			customerDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			customerDao.rollbackTransaction();
		}
		finally{
			customerDao.closeSession();
		}
	}
	
	public Customer readById(Integer id) {
		customerDao.openSession();
		Customer customer = null;
		try{
			customer = customerDao.readById(id);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			customerDao.closeSession();
		}
		return customer;
	}
	
	public List<Customer> readByCuit(String cuit) {
		customerDao.openSession();
		List<Customer> customers = null;
		try{
			customers = customerDao.readByCuit(cuit);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			customerDao.closeSession();
		}
		return customers;
	}
	
	public List<Customer> readByName(String name){
		customerDao.openSession();
		List<Customer> customers = null;
		try{
			customers = customerDao.readByName(name);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			customerDao.closeSession();
		}
		return customers;
	}
	
	public void delete(Integer userId) {
		customerDao.openSession();
		try{
			Customer customer = customerDao.readById(userId);
			customerDao.beginTransaction();
			customerDao.delete(customer);
			customerDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			customerDao.rollbackTransaction();
		}
		finally{
			customerDao.closeSession();
		}
	}
	
	public List<Customer> readAll() {
		customerDao.openSession();
		List<Customer> customers = null;
		try{
			customers = customerDao.readAll();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			customerDao.closeSession();
		}
	    return customers;
	}
	
	public void deleteAll() {
		customerDao.openSession();
		try{
			customerDao.beginTransaction();
			customerDao.deleteAll();
			customerDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			customerDao.rollbackTransaction();
		}
		finally{
			customerDao.closeSession();
		}
	}
	
}

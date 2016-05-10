package org.tourandino.service;

import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.tourandino.controller.ErrorLogController;
import org.tourandino.dao.OrderDao;
import org.tourandino.model.Order;

public class OrderService {
	private OrderDao orderDao;
	private ErrorLogController errorLogController;
	
	public OrderService(){
		orderDao = new OrderDao();
		errorLogController = new ErrorLogController();
	}
	
	public Integer create(Order entity) {
		orderDao.openSession();
		Integer id;
		try{
			orderDao.beginTransaction();
			id = orderDao.create(entity);
			orderDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.toString());
			orderDao.rollbackTransaction();
			id = 0;
		}
		finally{
			orderDao.closeSession();
		}
		return id;
	}
	
	public void update(Order entity) {
		orderDao.openSession();
		try{
			orderDao.beginTransaction();
			orderDao.update(entity);
			orderDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			orderDao.rollbackTransaction();
		}
		finally{
			orderDao.closeSession();
		}
	}
	
	public Order readById(Integer id) {
		orderDao.openSession();
		Order order = null;
		try{
			order = orderDao.readById(id);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			orderDao.closeSession();
		}
		return order;
	}
	
	public List<Order> readByType(String search) {
		orderDao.openSession();
		List<Order> orders = null;
		try{
			orders = orderDao.readByType(search);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			orderDao.closeSession();
		}
		return orders;
	}
	
	public List<Order> readByCustomer(String search) {
		orderDao.openSession();
		List<Order> orders = null;
		try{
			orders = orderDao.readByCustomer(search);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			orderDao.closeSession();
		}
		return orders;
	}
	
	public List<Order> readByIssuer(String search) {
		orderDao.openSession();
		List<Order> orders = null;
		try{
			orders = orderDao.readByIssuer(search);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			orderDao.closeSession();
		}
		return orders;
	}
	
	public List<Order> readByUser(String search) {
		orderDao.openSession();
		List<Order> orders = null;
		try{
			orders = orderDao.readByUser(search);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			orderDao.closeSession();
		}
		return orders;
	}
	
	public List<Order> read(Date dateFrom, Date dateTo) {
		orderDao.openSession();
		List<Order> orders = null;
		try{
			orders = orderDao.read(dateFrom, dateTo);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			orderDao.closeSession();
		}
	    return orders;
	}
	
	public List<Order> readByType(String search, Date dateFrom, Date dateTo) {
		orderDao.openSession();
		List<Order> orders = null;
		try{
			orders = orderDao.readByType(search, dateFrom, dateTo);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			orderDao.closeSession();
		}
		return orders;
	}
	
	public List<Order> readByCustomer(String search, Date dateFrom, Date dateTo) {
		orderDao.openSession();
		List<Order> orders = null;
		try{
			orders = orderDao.readByCustomer(search, dateFrom, dateTo);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			orderDao.closeSession();
		}
		return orders;
	}
	
	public List<Order> read(Date date) {
		orderDao.openSession();
		List<Order> orders = null;
		try{
			orders = orderDao.read(date);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			orderDao.closeSession();
		}
		return orders;
	}
	
	public List<Order> readByIssuer(String search, Date dateFrom, Date dateTo) {
		orderDao.openSession();
		List<Order> orders = null;
		try{
			orders = orderDao.readByIssuer(search, dateFrom, dateTo);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			orderDao.closeSession();
		}
		return orders;
	}
	
	public List<Order> readByUser(String search, Date dateFrom, Date dateTo) {
		orderDao.openSession();
		List<Order> orders = null;
		try{
			orders = orderDao.readByUser(search, dateFrom, dateTo);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			orderDao.closeSession();
		}
		return orders;
	}
	
	public void delete(Integer userId) {
		orderDao.openSession();
		try{
			Order order = orderDao.readById(userId);
			orderDao.beginTransaction();
			orderDao.delete(order);
			orderDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			orderDao.rollbackTransaction();
		}
		finally{
			orderDao.closeSession();
		}
	}
	
	public List<Order> readAll() {
		orderDao.openSession();
		List<Order> orders = null;
		try{
			orders = orderDao.readAll();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			orderDao.closeSession();
		}
	    return orders;
	}
	
	public void deleteAll() {
		orderDao.openSession();
		try{
			orderDao.beginTransaction();
			orderDao.deleteAll();
			orderDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			orderDao.rollbackTransaction();
		}
		finally{
			orderDao.closeSession();
		}
	}

}

package org.tourandino.service;

import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.tourandino.controller.ErrorLogController;
import org.tourandino.dao.UserDao;
import org.tourandino.model.User;

public class UserService {
	private static UserDao userDao;
	private ErrorLogController errorLogController;
	
	public UserService(){
		userDao = new UserDao();
		errorLogController = new ErrorLogController();
	}
	
	public Integer create(User entity) {
		userDao.openSession();
		Integer id;
		try{
			userDao.beginTransaction();
			id = userDao.create(entity);
			userDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			userDao.rollbackTransaction();
			id = 0;
		}
		finally{
			userDao.closeSession();
		}
		return id;
	}
	
	public void update(User entity) {
		userDao.openSession();
		try{
			userDao.beginTransaction();
			userDao.update(entity);
			userDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			userDao.rollbackTransaction();
		}
		finally{
			userDao.closeSession();
		}
	}
	
	public User readById(Integer userId) {
		userDao.openSession();
		User user = null;
		try{
			user = userDao.readById(userId);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			userDao.closeSession();
		}
		return user;
	}
	
	public User readByUsernamePassword(String username, String password) {
		userDao.openSession();
		User user = null;
		try{
			user = userDao.readByUsernamePassword(username, password);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			userDao.closeSession();
		}
		return user;
	}
	
	public List<User> readByUsernameFullname(String username, String fullname) {
		userDao.openSession();
		List<User> users = null;
		try{
			users = userDao.readByUsernameFullname(username, fullname);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			userDao.closeSession();
		}
		return users;
	}
	
	public List<User> readByUsername(String username) {
		userDao.openSession();
		List<User> users = null;
		try{
			users = userDao.readByUsername(username);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			userDao.closeSession();
		}
		return users;
	}
	
	public User checkUsername(String username) {
		userDao.openSession();
		User user = null;
		try{
			user = userDao.checkUsername(username);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			userDao.closeSession();
		}
		return user;
	}
	
	public List<User> readByFullname(String fullname) {
		userDao.openSession();
		List<User> users = null;
		try{
			users = userDao.readByFullname(fullname);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			userDao.closeSession();
		}
		return users;
	}
	
	public void delete(Integer userId) {
		userDao.openSession();
		try{
			User user = userDao.readById(userId);
			userDao.beginTransaction();
			userDao.delete(user);
			userDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			userDao.rollbackTransaction();
		}
		finally{
			userDao.closeSession();
		}
	}
	
	public List<User> readAll() {
		userDao.openSession();
		List<User> users = null;
		try{
			users = userDao.readAll();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			userDao.closeSession();
		}
	    return users;
	}
	
	public void deleteAll() {
		userDao.openSession();
		try{
			userDao.beginTransaction();
			userDao.deleteAll();
			userDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			userDao.rollbackTransaction();
		}
		finally{
			userDao.closeSession();
		}
	}

}

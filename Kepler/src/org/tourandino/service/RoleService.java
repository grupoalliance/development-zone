package org.tourandino.service;

import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.tourandino.controller.ErrorLogController;
import org.tourandino.dao.RoleDao;
import org.tourandino.model.Role;

public class RoleService {
	private RoleDao roleDao;
	private ErrorLogController errorLogController;
	
	public RoleService(){
		this.roleDao = new RoleDao();
		this.errorLogController = new ErrorLogController();
	}
	
	public void create(Role entity) {
		roleDao.openSession();
		try{
			roleDao.beginTransaction();
			roleDao.create(entity);
			roleDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			roleDao.rollbackTransaction();
		}
		finally{
			roleDao.closeSession();
		}
	}
	
	public void update(Role entity) {
		roleDao.openSession();
		try{
			roleDao.beginTransaction();
			roleDao.update(entity);
			roleDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			roleDao.rollbackTransaction();
		}
		finally{
			roleDao.closeSession();
		}
	}
	
	public Role readById(Integer roleId) {
		roleDao.openSession();
		Role role = null;
		try{
			role = roleDao.readById(roleId);
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			roleDao.closeSession();
		}
		return role;
	}
	
	public void delete(Integer roleId) {
		roleDao.openSession();
		try{
			Role role = roleDao.readById(roleId);
			roleDao.beginTransaction();
			roleDao.delete(role);
			roleDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			roleDao.rollbackTransaction();
		}
		finally{
			roleDao.closeSession();
		}
	}
	
	public List<Role> readAll() {
		roleDao.openSession();
		List<Role> roles = null;
		try{
			roles = roleDao.readAll();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
		}
		finally{
			roleDao.closeSession();
		}
	    return roles;
	}
	
	public void deleteAll() {
		roleDao.openSession();
		try{
			roleDao.beginTransaction();
			roleDao.deleteAll();
			roleDao.commitTransaction();
		}
		catch(HibernateException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getClass().getName(), e.getCause().toString());
			roleDao.rollbackTransaction();
		}
		finally{
			roleDao.closeSession();
		}
	}

}

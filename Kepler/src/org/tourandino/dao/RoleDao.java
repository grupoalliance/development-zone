package org.tourandino.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.tourandino.dao.interfaces.RoleDaoInterface;
import org.tourandino.hibernate.util.HibernateUtil;
import org.tourandino.model.Role;

@SuppressWarnings("unchecked")
public class RoleDao extends HibernateUtil implements RoleDaoInterface{

	private Session session;
	private Transaction transaction;
	
	public RoleDao(){
		super();
	}
	
	public Session openSession() {
		session = getSessionFactory().openSession();
		return session;
	}
	
	public void beginTransaction(){
		transaction = session.beginTransaction();
	}
	
	public void commitTransaction(){
		transaction.commit();
	}
	
	public void rollbackTransaction(){
		if (transaction!=null) transaction.rollback();
	}
	
	public void closeSession() {
		session.close();
	}
	
	public Session getSession() {
		return session;
	}
	
	public void create(Role entity) {
		getSession().save(entity);
	}
	
	public void update(Role entity){
		getSession().update(entity);
	}
	
	public Role readById(Integer id){
		Role role = (Role) getSession().get(Role.class, id);
		return role;
	}
	
	public void delete(Role entity){
		getSession().delete(entity);
	}
	
	public List<Role> readAll(){
		return getSession().createCriteria(Role.class).list();
		
	}
	public void deleteAll(){
		List<Role> entityList = readAll();
		for (Role entity : entityList) {
			delete(entity);
		}
	}
}

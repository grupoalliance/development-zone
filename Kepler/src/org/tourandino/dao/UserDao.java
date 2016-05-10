package org.tourandino.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.tourandino.dao.interfaces.UserDaoInterface;
import org.tourandino.hibernate.util.HibernateUtil;
import org.tourandino.model.User;

@SuppressWarnings("unchecked")
public class UserDao extends HibernateUtil implements UserDaoInterface{
	private Session session;
	private Transaction transaction;
	
	public UserDao(){
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
	
	public Integer create(User entity) {
		Integer id = (Integer) getSession().save(entity);
		return id;
	}
	
	public void update(User entity){
		getSession().update(entity);
	}
	
	public User readById(Integer userId){
		User user = (User) getSession().get(User.class, userId);
		return user;
	}
	
	public User readByUsernamePassword(String username, String password){
		Criteria cr = session.createCriteria(User.class);
		cr.add(Restrictions.eq("userUsername", username));
		cr.add(Restrictions.eq("userPassword", password));
		List<User> users = new ArrayList<User>();
		users = cr.list();
		if (users.size() > 0)
            return users.get(0);
        else
            return null;
	}
	
	public List<User> readByUsernameFullname(String username, String fullname){
		return getSession().createCriteria(User.class)
				.add(Restrictions.ilike("userUsername", username, MatchMode.ANYWHERE))
				.add(Restrictions.ilike("userFullname", fullname, MatchMode.ANYWHERE)).list();
	}
	
	public List<User> readByFullname(String fullname){
		return getSession().createCriteria(User.class).add(Restrictions.ilike("userFullname", fullname, MatchMode.ANYWHERE)).list();
	}
	
	public List<User> readByUsername(String username){
		return getSession().createCriteria(User.class).add(Restrictions.ilike("userUsername", username, MatchMode.ANYWHERE)).list();
	}
	
	public User checkUsername(String username){
		Criteria cr = session.createCriteria(User.class);
		cr.add(Restrictions.eq("userUsername", username));
		List<User> users = cr.list();
		if(users.size() > 0){
			return users.get(0);
		}
		else return null;
	}
	
	public void delete(User entity){
		getSession().delete(entity);
	}
	
	public List<User> readAll(){
		return getSession().createCriteria(User.class).list();
		
	}
	public void deleteAll(){
		List<User> entityList = readAll();
		for (User entity : entityList) {
			delete(entity);
		}
	}
}

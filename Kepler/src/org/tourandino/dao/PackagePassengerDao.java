package org.tourandino.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.tourandino.dao.interfaces.PackagePassengerDaoInterface;
import org.tourandino.hibernate.util.HibernateUtil;
import org.tourandino.model.PackagePassenger;

@SuppressWarnings("unchecked")
public class PackagePassengerDao extends HibernateUtil implements PackagePassengerDaoInterface{
	private Session session;
	private Transaction transaction;
	
	public PackagePassengerDao(){
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
	
	public Integer create(PackagePassenger entity) {
		return (Integer) getSession().save(entity);
	}
	
	public void update(PackagePassenger entity){
		getSession().update(entity);
	}
	
	public PackagePassenger readById(Integer id){
		PackagePassenger customer = (PackagePassenger) getSession().get(PackagePassenger.class, id);
		return customer;
	}
	
	public List<PackagePassenger> readByOrder(Integer orderId){
		return getSession().createCriteria(PackagePassenger.class, "packagePassenger").createAlias("packagePassenger.order", "order")
				.add(Restrictions.eq("order.orderId", orderId)).list();
	}
	
	public void delete(PackagePassenger entity){
		getSession().delete(entity);
	}
	
	public List<PackagePassenger> readAll(){
		return getSession().createCriteria(PackagePassenger.class).list();
		
	}
	public void deleteAll(){
		List<PackagePassenger> entityList = readAll();
		for (PackagePassenger entity : entityList) {
			delete(entity);
		}
	}

}

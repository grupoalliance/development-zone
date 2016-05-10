package org.tourandino.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.tourandino.dao.interfaces.IssuerDaoInterface;
import org.tourandino.hibernate.util.HibernateUtil;
import org.tourandino.model.Issuer;

@SuppressWarnings("unchecked")
public class IssuerDao extends HibernateUtil implements IssuerDaoInterface{
	private Session session;
	private Transaction transaction;
	
	public IssuerDao(){
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
	
	public Integer create(Issuer entity) {
		return (Integer) getSession().save(entity);
	}
	
	public void update(Issuer entity){
		getSession().update(entity);
	}
	
	public Issuer readById(Integer id){
		Issuer customer = (Issuer) getSession().get(Issuer.class, id);
		return customer;
	}
	
	public List<Issuer> readByName(String search){
		return session.createCriteria(Issuer.class).add(Restrictions.ilike("issuerName", search, MatchMode.ANYWHERE)).list();
	}
	
	public List<Issuer> readByCuit(String search){
		return session.createCriteria(Issuer.class).add(Restrictions.ilike("issuerCuit", search, MatchMode.ANYWHERE)).list();
	}
	
	public void delete(Issuer entity){
		getSession().delete(entity);
	}
	
	public List<Issuer> readAll(){
		return getSession().createCriteria(Issuer.class).list();
		
	}
	public void deleteAll(){
		List<Issuer> entityList = readAll();
		for (Issuer entity : entityList) {
			delete(entity);
		}
	}

}

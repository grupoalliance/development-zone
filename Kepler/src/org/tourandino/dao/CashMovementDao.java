package org.tourandino.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.tourandino.dao.interfaces.CashMovementDaoInterface;
import org.tourandino.hibernate.util.HibernateUtil;
import org.tourandino.model.CashMovement;

@SuppressWarnings("unchecked")
public class CashMovementDao extends HibernateUtil implements CashMovementDaoInterface{
	private Session session;
	private Transaction transaction;
	
	public CashMovementDao(){
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
	
	public Integer create(CashMovement entity) {
		return (Integer) getSession().save(entity);
	}
	
	public void update(CashMovement entity){
		getSession().update(entity);
	}
	
	public CashMovement readById(Integer id){
		CashMovement customer = (CashMovement) getSession().get(CashMovement.class, id);
		return customer;
	}
	
	public List<CashMovement> read(Date dateFrom, Date dateTo){
		return getSession().createCriteria(CashMovement.class)
				.add(Restrictions.between("cashMovementDate", dateFrom, dateTo)).list();
	}
	
	public List<CashMovement> readByDescr(String search){
		return getSession().createCriteria(CashMovement.class).add(Restrictions.ilike("cashMovementDescr", search, MatchMode.ANYWHERE)).list();
	}
	
	public List<CashMovement> readByDescr(String search, Date dateFrom, Date dateTo){
		return getSession().createCriteria(CashMovement.class)
				.add(Restrictions.ilike("cashMovementDescr", search, MatchMode.ANYWHERE))
				.add(Restrictions.between("cashMovementDate", dateFrom, dateTo)).list();
	}
	
	public List<CashMovement> readByDailyCash(Integer dailyCashId){
		return getSession().createCriteria(CashMovement.class, "cashMovement").createAlias("cashMovement.dailyCashRecord", "dailyCashRecord")
				.add(Restrictions.eq("dailyCashRecord.dailyCashRecordId", dailyCashId)).list();
	}
	
	public void delete(CashMovement entity){
		getSession().delete(entity);
	}

	public List<CashMovement> readAll(){
		return getSession().createCriteria(CashMovement.class).list();
		
	}
	public void deleteAll(){
		List<CashMovement> entityList = readAll();
		for (CashMovement entity : entityList) {
			delete(entity);
		}
	}

}

package org.tourandino.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.tourandino.dao.interfaces.DailyCashRecordDaoInterface;
import org.tourandino.hibernate.util.HibernateUtil;
import org.tourandino.model.DailyCashRecord;

@SuppressWarnings("unchecked")
public class DailyCashRecordDao extends HibernateUtil implements DailyCashRecordDaoInterface{
	private Session session;
	private Transaction transaction;
	
	public DailyCashRecordDao(){
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
	
	public Integer create(DailyCashRecord entity) {
		return (Integer) getSession().save(entity);
	}
	
	public void update(DailyCashRecord entity){
		getSession().update(entity);
	}
	
	public DailyCashRecord readById(Integer id){
		DailyCashRecord customer = (DailyCashRecord) getSession().get(DailyCashRecord.class, id);
		return customer;
	}
	
	public DailyCashRecord readDailyCashRecord(){
		if(!getSession().createCriteria(DailyCashRecord.class).add(Restrictions.eq("dailyCashRecordDate", new Date())).list().isEmpty()){
			return (DailyCashRecord)getSession().createCriteria(DailyCashRecord.class).add(Restrictions.eq("dailyCashRecordDate", new Date())).uniqueResult();
		}
		else
			return null;
	}
	
	public List<DailyCashRecord> readByDate(Date dateFrom, Date dateTo){
		return getSession().createCriteria(DailyCashRecord.class)
				.add(Restrictions.between("dailyCashRecordDate", dateFrom, dateTo)).list();
	}
	
	public void delete(DailyCashRecord entity){
		getSession().delete(entity);
	}
	
	public List<DailyCashRecord> readAll(){
		return getSession().createCriteria(DailyCashRecord.class).list();
		
	}
	public void deleteAll(){
		List<DailyCashRecord> entityList = readAll();
		for (DailyCashRecord entity : entityList) {
			delete(entity);
		}
	}

}

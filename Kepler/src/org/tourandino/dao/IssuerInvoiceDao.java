package org.tourandino.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.tourandino.dao.interfaces.IssuerInvoiceDaoInterface;
import org.tourandino.hibernate.util.HibernateUtil;
import org.tourandino.model.IssuerInvoice;

@SuppressWarnings("unchecked")
public class IssuerInvoiceDao extends HibernateUtil implements IssuerInvoiceDaoInterface{

	private Session session;
	private Transaction transaction;
	
	public IssuerInvoiceDao(){
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
	
	public Integer create(IssuerInvoice entity) {
		return (Integer)getSession().save(entity);
	}
	
	public void update(IssuerInvoice entity){
		getSession().update(entity);
	}
	
	public IssuerInvoice readById(Integer id){
		IssuerInvoice entity = (IssuerInvoice) getSession().get(IssuerInvoice.class, id);
		return entity;
	}
	
	public List<IssuerInvoice> readByDate(Date date){
		return getSession().createCriteria(IssuerInvoice.class).add(Restrictions.eq("issuerInvoiceDate", date)).list();
	}
	
	public List<IssuerInvoice> readByIssuer(String search){
		return getSession().createCriteria(IssuerInvoice.class, "issuerInvoice").createAlias("issuerInvoice.order", "order").createAlias("order.issuer", "issuer")
				.add(Restrictions.ilike("issuer.issuerName", search, MatchMode.ANYWHERE)).list();
	}
	
	public void delete(IssuerInvoice entity){
		getSession().delete(entity);
	}
	
	public List<IssuerInvoice> readAll(){
		return getSession().createCriteria(IssuerInvoice.class).list();
		
	}
	public void deleteAll(){
		List<IssuerInvoice> entityList = readAll();
		for (IssuerInvoice entity : entityList) {
			delete(entity);
		}
	}
}

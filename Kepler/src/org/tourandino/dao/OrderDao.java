package org.tourandino.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.tourandino.dao.interfaces.OrderDaoInterface;
import org.tourandino.hibernate.util.HibernateUtil;
import org.tourandino.model.Order;

@SuppressWarnings("unchecked")
public class OrderDao extends HibernateUtil implements OrderDaoInterface{
	private Session session;
	private Transaction transaction;
	
	public OrderDao(){
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
	
	public Integer create(Order entity) {
		Integer id = (Integer) getSession().save(entity);
		return id;
	}
	
	public void update(Order entity){
		getSession().update(entity);
	}
	
	public Order readById(Integer orderId){
		Order order = (Order) getSession().get(Order.class, orderId);
		return order;
	}
	
	public List<Order> readByType(String search){
		return getSession().createCriteria(Order.class).add(Restrictions.ilike("orderDescr", search, MatchMode.ANYWHERE)).list();
	}
	
	public List<Order> readByCustomer(String search){
		return getSession().createCriteria(Order.class, "order").createAlias("order.customer", "customer").add(Restrictions.ilike("customer.customerFullname", search, MatchMode.ANYWHERE)).list();
	}
	
	public List<Order> readByUser(String search){
		return getSession().createCriteria(Order.class, "order").createAlias("order.user", "user").add(Restrictions.ilike("user.userFullname", search, MatchMode.ANYWHERE)).list();
	}
	
	public List<Order> readByIssuer(String search){
		return getSession().createCriteria(Order.class, "order").createAlias("order.issuer", "issuer").add(Restrictions.ilike("issuer.issuerName", search, MatchMode.ANYWHERE)).list();
	}
	
	public List<Order> read(Date dateFrom, Date dateTo){
		return getSession().createCriteria(Order.class)
				.add(Restrictions.between("orderDate", dateFrom, dateTo)).list();
		
	}
	
	public List<Order> read(Date date){
		return getSession().createCriteria(Order.class).add(Restrictions.eq("orderDate", date)).list();
		
	}
	
	public List<Order> readByType(String search, Date dateFrom, Date dateTo){
		return getSession().createCriteria(Order.class)
				.add(Restrictions.ilike("orderDescr", search, MatchMode.ANYWHERE))
				.add(Restrictions.between("orderDate", dateFrom, dateTo)).list();
	}
	
	public List<Order> readByCustomer(String search, Date dateFrom, Date dateTo){
		return getSession().createCriteria(Order.class, "order").createAlias("order.customer", "customer")
				.add(Restrictions.ilike("customer.customerFullname", search, MatchMode.ANYWHERE))
				.add(Restrictions.between("orderDate", dateFrom, dateTo)).list();
	}
	
	public List<Order> readByUser(String search, Date dateFrom, Date dateTo){
		return getSession().createCriteria(Order.class, "order").createAlias("order.user", "user")
				.add(Restrictions.ilike("user.userFullname", search, MatchMode.ANYWHERE))
				.add(Restrictions.between("orderDate", dateFrom, dateTo)).list();
	}
	
	public List<Order> readByIssuer(String search, Date dateFrom, Date dateTo){
		return getSession().createCriteria(Order.class, "order").createAlias("order.issuer", "issuer")
				.add(Restrictions.ilike("issuer.issuerName", search, MatchMode.ANYWHERE))
				.add(Restrictions.between("orderDate", dateFrom, dateTo)).list();
	}
	
	public void delete(Order entity){
		getSession().delete(entity);
	}
	
	public List<Order> readAll(){
		return getSession().createCriteria(Order.class).addOrder(org.hibernate.criterion.Order.asc("orderDate")).list();
		
	}
	
	public void deleteAll(){
		List<Order> entityList = readAll();
		for (Order entity : entityList) {
			delete(entity);
		}
	}

}

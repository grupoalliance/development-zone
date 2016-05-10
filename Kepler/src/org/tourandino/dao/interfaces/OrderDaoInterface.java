package org.tourandino.dao.interfaces;

import java.util.List;

import org.tourandino.model.Order;

public interface OrderDaoInterface {
	public Integer create(Order entity);
	public void update(Order entity);
	public Order readById(Integer orderId);
	public void delete(Order entity);
	public List<Order> readAll();
	public void deleteAll();

}

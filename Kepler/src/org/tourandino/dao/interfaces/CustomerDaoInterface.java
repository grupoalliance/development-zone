package org.tourandino.dao.interfaces;

import java.util.List;

import org.tourandino.model.Customer;

public interface CustomerDaoInterface {

	public Integer create(Customer entity);
	public void update(Customer entity);
	public Customer readById(Integer id);
	public void delete(Customer entity);
	public List<Customer> readAll();
	public void deleteAll();
}

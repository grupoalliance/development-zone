package org.tourandino.dao.interfaces;

import java.util.List;

import org.tourandino.model.CustomerAccount;

public interface CustomerAccountDaoInterface {

	public Integer create(CustomerAccount entity);
	public void update(CustomerAccount entity);
	public CustomerAccount readById(Integer id);
	public void delete(CustomerAccount entity);
	public List<CustomerAccount> readAll();
	public void deleteAll();
}

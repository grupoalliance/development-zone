package org.tourandino.dao.interfaces;

import java.util.List;

import org.tourandino.model.InsurancePassenger;

public interface InsurancePassengerDaoInterface {
	public Integer create(InsurancePassenger entity);
	public void update(InsurancePassenger entity);
	public InsurancePassenger readById(Integer id);
	public void delete(InsurancePassenger entity);
	public List<InsurancePassenger> readAll();
	public void deleteAll();

}

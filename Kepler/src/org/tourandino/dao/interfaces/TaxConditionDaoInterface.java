package org.tourandino.dao.interfaces;

import java.util.List;

import org.tourandino.model.TaxCondition;

public interface TaxConditionDaoInterface {

	public Integer create(TaxCondition entity);
	public void update(TaxCondition entity);
	public TaxCondition readById(Integer id);
	public void delete(TaxCondition entity);
	public List<TaxCondition> readAll();
	public void deleteAll();
}

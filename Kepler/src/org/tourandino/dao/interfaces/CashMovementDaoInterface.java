package org.tourandino.dao.interfaces;

import java.util.List;

import org.tourandino.model.CashMovement;

public interface CashMovementDaoInterface {
	public Integer create(CashMovement entity);
	public void update(CashMovement entity);
	public CashMovement readById(Integer id);
	public void delete(CashMovement entity);
	public List<CashMovement> readAll();
	public void deleteAll();

}

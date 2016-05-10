package org.tourandino.dao.interfaces;

import java.util.List;

import org.tourandino.model.BusPassenger;

public interface BusPassengerDaoInterface {
	public Integer create(BusPassenger entity);
	public void update(BusPassenger entity);
	public BusPassenger readById(Integer id);
	public void delete(BusPassenger entity);
	public List<BusPassenger> readAll();
	public void deleteAll();

}

package org.tourandino.dao.interfaces;

import java.util.List;

import org.tourandino.model.FlightPassenger;

public interface FlightPassengerDaoInterface {
	public Integer create(FlightPassenger entity);
	public void update(FlightPassenger entity);
	public FlightPassenger readById(Integer id);
	public List<FlightPassenger> readAll();
	public void deleteAll();

}

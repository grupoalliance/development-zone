package org.tourandino.dao.interfaces;

import java.util.List;

import org.tourandino.model.Passenger;

public interface PassengerDaoInterface {
	public Integer create(Passenger entity);
	public void update(Passenger entity);
	public Passenger readById(Integer id);
	public List<Passenger> readByName(String name);
	public void delete(Passenger entity);
	public List<Passenger> readAll();
	public void deleteAll();

}

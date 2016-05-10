package org.tourandino.dao.interfaces;

import java.util.List;

import org.tourandino.model.HotelPassenger;

public interface HotelPassengerDaoInterface {
	public Integer create(HotelPassenger entity);
	public void update(HotelPassenger entity);
	public HotelPassenger readById(Integer id);
	public void delete(HotelPassenger entity);
	public List<HotelPassenger> readAll();
	public void deleteAll();

}

package org.tourandino.dao.interfaces;

import java.util.List;

import org.tourandino.model.PackagePassenger;

public interface PackagePassengerDaoInterface {
	public Integer create(PackagePassenger entity);
	public void update(PackagePassenger entity);
	public PackagePassenger readById(Integer id);
	public void delete(PackagePassenger entity);
	public List<PackagePassenger> readAll();
	public void deleteAll();

}

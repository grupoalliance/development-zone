package org.tourandino.dao.interfaces;

import java.util.List;

import org.tourandino.model.Issuer;

public interface IssuerDaoInterface {
	public Integer create(Issuer entity);
	public void update(Issuer entity);
	public Issuer readById(Integer id);
	public void delete(Issuer entity);
	public List<Issuer> readAll();
	public void deleteAll();

}

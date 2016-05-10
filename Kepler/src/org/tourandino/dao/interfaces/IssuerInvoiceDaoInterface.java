package org.tourandino.dao.interfaces;

import java.util.List;

import org.tourandino.model.IssuerInvoice;

public interface IssuerInvoiceDaoInterface {
	public Integer create(IssuerInvoice entity);
	public void update(IssuerInvoice entity);
	public IssuerInvoice readById(Integer id);
	public void delete(IssuerInvoice entity);
	public List<IssuerInvoice> readAll();
	public void deleteAll();

}

package org.tourandino.dao.interfaces;

import java.util.List;

import org.tourandino.model.CustAccPayment;

public interface CustAccPmtDaoInterface {
	public Integer create(CustAccPayment entity);
	public void update(CustAccPayment entity);
	public CustAccPayment readById(Integer id);
	public void delete(CustAccPayment entity);
	public List<CustAccPayment> readAll();
	public void deleteAll();

}

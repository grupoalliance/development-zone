package org.tourandino.dao.interfaces;

import java.util.List;

import org.tourandino.model.Payment;

public interface PaymentDaoInterface {
	public Integer create(Payment entity);
	public void update(Payment entity);
	public Payment readById(Integer id);
	public void delete(Payment entity);
	public List<Payment> readAll();
	public void deleteAll();

}

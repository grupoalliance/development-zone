package org.tourandino.dao.interfaces;

import java.util.List;

import org.tourandino.model.PaymentMethod;

public interface PaymentMethodDaoInterface {
	public void create(PaymentMethod entity);
	public void update(PaymentMethod entity);
	public PaymentMethod readById(Integer id);
	public void delete(PaymentMethod entity);
	public List<PaymentMethod> readAll();
	public void deleteAll();

}

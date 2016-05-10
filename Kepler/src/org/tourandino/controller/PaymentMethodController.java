package org.tourandino.controller;

import java.util.List;

import javax.swing.DefaultComboBoxModel;

import org.tourandino.model.PaymentMethod;
import org.tourandino.service.PaymentMethodService;

@SuppressWarnings({ "rawtypes", "unchecked","unused" })
public class PaymentMethodController {
	private PaymentMethodService paymentMethodService;
	private PaymentMethod paymentMethod;
	private List<PaymentMethod> paymentMethods;
	
	public PaymentMethodController(){
		paymentMethodService = new PaymentMethodService();
	}
	
	public DefaultComboBoxModel read(){
		paymentMethods = paymentMethodService.readAll();
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		if(paymentMethods != null){
			for(PaymentMethod paymentMethod: paymentMethods){
				model.addElement(paymentMethod);
			}
		}
		return model;
	}
	
	public PaymentMethod readRoleById(Integer id){
		return paymentMethodService.readById(id);
	}
	
	public DefaultComboBoxModel read(Object r){
		paymentMethods = paymentMethodService.readAll();
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		if(paymentMethods != null){
			for(PaymentMethod paymentMethod: paymentMethods){
				model.addElement(paymentMethod);
			}
			model.setSelectedItem((PaymentMethod)r);
		}
		return model;
	}

}

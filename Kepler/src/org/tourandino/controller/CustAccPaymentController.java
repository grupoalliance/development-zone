package org.tourandino.controller;

import java.util.Date;
import java.util.List;

import org.tourandino.model.CustAccPayment;
import org.tourandino.model.CustomerAccount;
import org.tourandino.service.CustAccPaymentService;

public class CustAccPaymentController {
	private CustAccPayment custAccPayment;
	private List<CustAccPayment> custAccPayments;
	private CustAccPaymentService custAccPaymentService;
	
	public CustAccPaymentController(){
		this.custAccPaymentService = new CustAccPaymentService();
	}
	
	public Integer create(CustomerAccount customerAccount, float tax, float rate, float total, String note){
		CustomerAccountController customerAccountController = new CustomerAccountController();
		CashMovementController cashMovementController = new CashMovementController();
		custAccPayment = new CustAccPayment(customerAccount, new Date(), tax, rate, total, note);	
		Integer id = custAccPaymentService.create(custAccPayment); 
		if(id > 0){
			cashMovementController.create(custAccPayment.getCustAccPaymentTotal(), 0, "COBRANZA DE SALDO A CLIENTE, ".concat(customerAccount.getCustomer().getCustomerFullname()));
			customerAccountController.decreaseBalance(customerAccount.getCustomer(), custAccPayment.getCustAccPaymentTotal());
			return id;
		}
		else
			return 0;
		
	}
	
	public CustAccPayment getCustAccPayment() {
		return custAccPayment;
	}
	public void setCustAccPayment(CustAccPayment custAccPayment) {
		this.custAccPayment = custAccPayment;
	}
	public List<CustAccPayment> getCustAccPayments() {
		return custAccPayments;
	}
	public void setCustAccPayments(List<CustAccPayment> custAccPayments) {
		this.custAccPayments = custAccPayments;
	}
	public CustAccPaymentService getCustAccPaymentService() {
		return custAccPaymentService;
	}
	public void setCustAccPaymentService(CustAccPaymentService custAccPaymentService) {
		this.custAccPaymentService = custAccPaymentService;
	}

	
}

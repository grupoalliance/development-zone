package org.tourandino.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.tourandino.model.Order;
import org.tourandino.model.Payment;
import org.tourandino.model.PaymentMethod;
import org.tourandino.service.PaymentService;

public class PaymentController {
	private PaymentService paymentService;
	private Payment payment;
	private List<Payment> payments;
	private CashMovementController cashMovementController;
	
	public PaymentController(DailyCashRecordController dailyCashRecordController){
		this.paymentService = new PaymentService();
		this.cashMovementController = new CashMovementController();
	}
	
	public PaymentController(){
		this.paymentService = new PaymentService();
	}
	
	public void initializePayment(){
		this.payments = new ArrayList<Payment>();
	}
	
	public void add(Order order, float tax, float rate, float total, String note, Object method){
		payment = new Payment(order, new Date(), tax, rate, total, note, (PaymentMethod)method);
		payments.add(payment);
	}
	
	public void create(){
		if(!payments.isEmpty()){
			for(Payment payment :payments){
				paymentService.create(payment);
				if(payment.getPaymentMethod().getPaymentMethodName().equalsIgnoreCase("EFECTIVO")){
					cashMovementController.create(payment.getPaymentTotal(), 0, "PAGO EN EFECTIVO");
				}
				if(payment.getPaymentMethod().getPaymentMethodName().equalsIgnoreCase("CUENTA CORRIENTE")){
					CustomerAccountController customerAccountController = new CustomerAccountController();
					customerAccountController.increaseBalance(payment.getOrder().getCustomer(), payment.getPaymentTotal());
				}
			}
		}
	}
	
	public DefaultTableModel read(Integer id){
		payments = paymentService.readByOrder(id);
		Object[] columns = new Object[]{"ID","Fecha", "Monto", "Forma", "Observación"};
		DefaultTableModel model = new DefaultTableModel(null, columns);
		SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		if(!payments.isEmpty()){
			for (Payment payment :payments)
	           
	            	model.addRow(new Object[]{
	            			payment.getPaymentId(),
	            			sdfDate.format(payment.getPaymentDatetime()),
	            			payment.getPaymentTotal(),
	            			payment.getPaymentMethod().getPaymentMethodName(),
	            			payment.getPaymentNote()
	            	});
	           
		}
		return model;
	}
	
	public boolean remove(){
		return payments.removeAll(payments);
	}
	
	public float getPaymentTotal(String method){
		float total = 0;
		if(!payments.isEmpty()){
			for(Payment payment :payments){
				if(payment.getPaymentMethod().getPaymentMethodName().equalsIgnoreCase(method)){
					total += payment.getPaymentTotal();
				}
			}
		}
		return total;
	}

}

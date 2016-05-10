package org.tourandino.model;

import java.util.Date;

public class Payment implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1646681813080247465L;
	private Integer paymentId;
	private Order order;
	private Date paymentDatetime;
	private float paymentTax;
	private float paymentRate;
	private float paymentTotal;
	private String paymentNote;
	private PaymentMethod paymentMethod;

	public Payment() {
	}

	public Payment(Order order, Date paymentDatetime, float paymentTax,
			float paymentRate, float paymentTotal) {
		this.order = order;
		this.paymentDatetime = paymentDatetime;
		this.paymentTax = paymentTax;
		this.paymentRate = paymentRate;
		this.paymentTotal = paymentTotal;
	}

	public Payment(Order order, Date paymentDatetime, float paymentTax,
			float paymentRate, float paymentTotal, 
			String paymentNote, PaymentMethod paymentMethod) {
		this.order = order;
		this.paymentDatetime = paymentDatetime;
		this.paymentTax = paymentTax;
		this.paymentRate = paymentRate;
		this.paymentTotal = paymentTotal;
		this.paymentNote = paymentNote;
		this.paymentMethod = paymentMethod;
	}

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Date getPaymentDatetime() {
		return paymentDatetime;
	}

	public void setPaymentDatetime(Date paymentDatetime) {
		this.paymentDatetime = paymentDatetime;
	}

	public float getPaymentTax() {
		return paymentTax;
	}

	public void setPaymentTax(float paymentTax) {
		this.paymentTax = paymentTax;
	}

	public float getPaymentRate() {
		return paymentRate;
	}

	public void setPaymentRate(float paymentRate) {
		this.paymentRate = paymentRate;
	}

	public float getPaymentTotal() {
		return paymentTotal;
	}

	public void setPaymentTotal(float paymentTotal) {
		this.paymentTotal = paymentTotal;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getPaymentNote() {
		return paymentNote;
	}

	public void setPaymentNote(String paymentNote) {
		this.paymentNote = paymentNote;
	}

	

}

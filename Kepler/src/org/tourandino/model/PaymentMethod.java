package org.tourandino.model;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("rawtypes")
public class PaymentMethod implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1061472555721503795L;
	private Integer paymentMethodId;
	private String paymentMethodName;
	private String paymentMethodDescr;
	private Set payments = new HashSet(0);

	public PaymentMethod() {
	}

	public PaymentMethod(String paymentMethodName, String paymentMethodDescr,
			Set payments) {
		this.paymentMethodName = paymentMethodName;
		this.paymentMethodDescr = paymentMethodDescr;
		this.payments = payments;
	}

	public Integer getPaymentMethodId() {
		return paymentMethodId;
	}

	public void setPaymentMethodId(Integer paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}

	public String getPaymentMethodName() {
		return paymentMethodName;
	}

	public void setPaymentMethodName(String paymentMethodName) {
		this.paymentMethodName = paymentMethodName;
	}

	public String getPaymentMethodDescr() {
		return paymentMethodDescr;
	}

	public void setPaymentMethodDescr(String paymentMethodDescr) {
		this.paymentMethodDescr = paymentMethodDescr;
	}

	public Set getPayments() {
		return payments;
	}

	public void setPayments(Set payments) {
		this.payments = payments;
	}

	public String toString(){
		return this.paymentMethodName;
	}
}

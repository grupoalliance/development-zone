package org.tourandino.model;

import java.util.Date;

public class CustAccPayment implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5218808189716811549L;
	private Integer custAccPaymentId;
	private CustomerAccount customerAccount;
	private Date custAccPaymentDatetime;
	private float custAccPaymentTax;
	private float custAccPaymentRate;
	private float custAccPaymentTotal;
	private String custAccPaymentNote;

	public CustAccPayment() {}
	

	public CustAccPayment(CustomerAccount customerAccount,
			Date custAccPaymentsDatetime, float custAccPaymentTax,
			float custAccPaymentRate, float custAccPaymentTotal, String custAccPaymentNote) {
		this.customerAccount = customerAccount;
		this.custAccPaymentDatetime = custAccPaymentsDatetime;
		this.custAccPaymentTax = custAccPaymentTax;
		this.custAccPaymentRate = custAccPaymentRate;
		this.custAccPaymentTotal = custAccPaymentTotal;
		this.custAccPaymentNote = custAccPaymentNote;
	}


	public Integer getCustAccPaymentId() {
		return custAccPaymentId;
	}

	public void setCustAccPaymentId(Integer custAccPaymentId) {
		this.custAccPaymentId = custAccPaymentId;
	}

	public CustomerAccount getCustomerAccount() {
		return customerAccount;
	}

	public void setCustomerAccount(CustomerAccount customerAccount) {
		this.customerAccount = customerAccount;
	}

	public Date getCustAccPaymentDatetime() {
		return custAccPaymentDatetime;
	}


	public void setCustAccPaymentDatetime(Date custAccPaymentDatetime) {
		this.custAccPaymentDatetime = custAccPaymentDatetime;
	}


	public float getCustAccPaymentTax() {
		return custAccPaymentTax;
	}

	public void setCustAccPaymentTax(float custAccPaymentTax) {
		this.custAccPaymentTax = custAccPaymentTax;
	}

	public float getCustAccPaymentRate() {
		return custAccPaymentRate;
	}

	public void setCustAccPaymentRate(float custAccPaymentRate) {
		this.custAccPaymentRate = custAccPaymentRate;
	}

	public float getCustAccPaymentTotal() {
		return custAccPaymentTotal;
	}

	public void setCustAccPaymentTotal(float custAccPaymentTotal) {
		this.custAccPaymentTotal = custAccPaymentTotal;
	}


	public String getCustAccPaymentNote() {
		return custAccPaymentNote;
	}


	public void setCustAccPaymentNote(String custAccPaymentNote) {
		this.custAccPaymentNote = custAccPaymentNote;
	}

}

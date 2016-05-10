package org.tourandino.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("rawtypes")
public class CustomerAccount implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5658391293050093373L;
	private Integer customerAccountId;
	private Customer customer;
	private String customerAccountName;
	private float customerAccountBalance;
	private float customerAccountLimit;
	private Date customerAccountCreationDatetime;
	private Date customerAccountLastMovement;
	private Set custAccPayments = new HashSet(0);

	public CustomerAccount() {
	}

	public CustomerAccount(Customer customer, float customerAccountBalance,
			float customerAccountLimit, Date customerAccountCreationDatetime) {
		this.customer = customer;
		this.customerAccountBalance = customerAccountBalance;
		this.customerAccountLimit = customerAccountLimit;
		this.customerAccountCreationDatetime = customerAccountCreationDatetime;
	}
	
	

	public CustomerAccount(Customer customer, String customerAccountName,
			float customerAccountBalance, float customerAccountLimit,
			Date customerAccountCreationDatetime,
			Date customerAccountLastMovement) {
		this.customer = customer;
		this.customerAccountName = customerAccountName;
		this.customerAccountBalance = customerAccountBalance;
		this.customerAccountLimit = customerAccountLimit;
		this.customerAccountCreationDatetime = customerAccountCreationDatetime;
		this.customerAccountLastMovement = customerAccountLastMovement;
	}

	public Integer getCustomerAccountId() {
		return this.customerAccountId;
	}

	public void setCustomerAccountId(Integer customerAccountId) {
		this.customerAccountId = customerAccountId;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getCustomerAccountName() {
		return this.customerAccountName;
	}

	public void setCustomerAccountName(String customerAccountName) {
		this.customerAccountName = customerAccountName;
	}

	public float getCustomerAccountBalance() {
		return this.customerAccountBalance;
	}

	public void setCustomerAccountBalance(float customerAccountBalance) {
		this.customerAccountBalance = customerAccountBalance;
	}

	public float getCustomerAccountLimit() {
		return this.customerAccountLimit;
	}

	public void setCustomerAccountLimit(float customerAccountLimit) {
		this.customerAccountLimit = customerAccountLimit;
	}

	public Date getCustomerAccountCreationDatetime() {
		return this.customerAccountCreationDatetime;
	}

	public void setCustomerAccountCreationDatetime(
			Date customerAccountCreationDatetime) {
		this.customerAccountCreationDatetime = customerAccountCreationDatetime;
	}

	public Date getCustomerAccountLastMovement() {
		return this.customerAccountLastMovement;
	}

	public void setCustomerAccountLastMovement(Date customerAccountLastMovement) {
		this.customerAccountLastMovement = customerAccountLastMovement;
	}

	public Set getCustAccPayments() {
		return custAccPayments;
	}

	public void setCustAccPayments(Set custAccPayments) {
		this.custAccPayments = custAccPayments;
	}
	
	

}

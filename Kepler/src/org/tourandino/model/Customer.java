package org.tourandino.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("rawtypes")
public class Customer implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4649264630977747409L;
	private Integer customerId;
	private TaxCondition taxCondition;
	private String customerFullname;
	private String customerCuit;
	private float customerCreditLimit;
	private Date customerBirthdate;
	private String customerAddress;
	private String customerCity;
	private String customerPhone;
	private String customerMobile;
	private String customerEmail;
	private Set orders = new HashSet(0);
	private Set customerAccounts = new HashSet(0);

	public Customer() {
	}

	public Customer(TaxCondition taxCondition, String customerFullname,
			float customerCreditLimit, Date customerBirthdate) {
		this.taxCondition = taxCondition;
		this.customerFullname = customerFullname;
		this.customerCreditLimit = customerCreditLimit;
		this.customerBirthdate = customerBirthdate;
	}

	public Customer(TaxCondition taxCondition, String customerFullname,
			String customerCuit, float customerCreditLimit,
			Date customerBirthdate, String customerAddress,
			String customerCity, String customerPhone, String customerMobile,
			String customerEmail, Set orders, Set customerAccounts) {
		this.taxCondition = taxCondition;
		this.customerFullname = customerFullname;
		this.customerCuit = customerCuit;
		this.customerCreditLimit = customerCreditLimit;
		this.customerBirthdate = customerBirthdate;
		this.customerAddress = customerAddress;
		this.customerCity = customerCity;
		this.customerPhone = customerPhone;
		this.customerMobile = customerMobile;
		this.customerEmail = customerEmail;
		this.orders = orders;
		this.customerAccounts = customerAccounts;
	}
	
	public Customer(TaxCondition taxCondition, String customerFullname,
			String customerCuit, float customerCreditLimit,
			Date customerBirthdate, String customerAddress,
			String customerCity, String customerPhone, String customerMobile,
			String customerEmail) {
		this.taxCondition = taxCondition;
		this.customerFullname = customerFullname;
		this.customerCuit = customerCuit;
		this.customerCreditLimit = customerCreditLimit;
		this.customerBirthdate = customerBirthdate;
		this.customerAddress = customerAddress;
		this.customerCity = customerCity;
		this.customerPhone = customerPhone;
		this.customerMobile = customerMobile;
		this.customerEmail = customerEmail;
	}

	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public TaxCondition getTaxCondition() {
		return this.taxCondition;
	}

	public void setTaxCondition(TaxCondition taxCondition) {
		this.taxCondition = taxCondition;
	}

	public String getCustomerFullname() {
		return this.customerFullname;
	}

	public void setCustomerFullname(String customerFullname) {
		this.customerFullname = customerFullname;
	}

	public String getCustomerCuit() {
		return this.customerCuit;
	}

	public void setCustomerCuit(String customerCuit) {
		this.customerCuit = customerCuit;
	}

	public float getCustomerCreditLimit() {
		return this.customerCreditLimit;
	}

	public void setCustomerCreditLimit(float customerCreditLimit) {
		this.customerCreditLimit = customerCreditLimit;
	}

	public Date getCustomerBirthdate() {
		return this.customerBirthdate;
	}

	public void setCustomerBirthdate(Date customerBirthdate) {
		this.customerBirthdate = customerBirthdate;
	}

	public String getCustomerAddress() {
		return this.customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerCity() {
		return this.customerCity;
	}

	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}

	public String getCustomerPhone() {
		return this.customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerMobile() {
		return this.customerMobile;
	}

	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}

	public String getCustomerEmail() {
		return this.customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public Set getOrders() {
		return this.orders;
	}

	public void setOrders(Set orders) {
		this.orders = orders;
	}

	public Set getCustomerAccounts() {
		return this.customerAccounts;
	}

	public void setCustomerAccounts(Set customerAccounts) {
		this.customerAccounts = customerAccounts;
	}

}

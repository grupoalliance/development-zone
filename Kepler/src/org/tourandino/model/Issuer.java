package org.tourandino.model;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("rawtypes")
public class Issuer implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7328332307010333372L;
	private Integer issuerId;
	private TaxCondition taxCondition;
	private String issuerName;
	private String issuerCuit;
	private float issuerCreditLimit;
	private String issuerAddress;
	private String issuerCity;
	private String issuerPhone1;
	private String issuerPhone2;
	private String issuerMobile;
	private String issuerEmail;
	private String issuerWebsite;
	private Set issuerInvoices = new HashSet(0);
	private Set orders = new HashSet(0);

	public Issuer() {
	}

	public Issuer(TaxCondition taxCondition, String issuerName,
			float issuerCreditLimit) {
		this.taxCondition = taxCondition;
		this.issuerName = issuerName;
		this.issuerCreditLimit = issuerCreditLimit;
	}

	public Issuer(TaxCondition taxCondition, String issuerName,
			String issuerCuit, float issuerCreditLimit, String issuerAddress,
			String issuerCity, String issuerPhone1, String issuerPhone2,
			String issuerMobile, String issuerEmail, String issuerWebsite,
			Set issuerInvoices, Set orders) {
		this.taxCondition = taxCondition;
		this.issuerName = issuerName;
		this.issuerCuit = issuerCuit;
		this.issuerCreditLimit = issuerCreditLimit;
		this.issuerAddress = issuerAddress;
		this.issuerCity = issuerCity;
		this.issuerPhone1 = issuerPhone1;
		this.issuerPhone2 = issuerPhone2;
		this.issuerMobile = issuerMobile;
		this.issuerEmail = issuerEmail;
		this.issuerWebsite = issuerWebsite;
		this.issuerInvoices = issuerInvoices;
		this.orders = orders;
	}
	
	public Issuer(TaxCondition taxCondition, String issuerName,
			String issuerCuit, float issuerCreditLimit, String issuerAddress,
			String issuerCity, String issuerPhone1, String issuerPhone2,
			String issuerMobile, String issuerEmail, String issuerWebsite) {
		this.taxCondition = taxCondition;
		this.issuerName = issuerName;
		this.issuerCuit = issuerCuit;
		this.issuerCreditLimit = issuerCreditLimit;
		this.issuerAddress = issuerAddress;
		this.issuerCity = issuerCity;
		this.issuerPhone1 = issuerPhone1;
		this.issuerPhone2 = issuerPhone2;
		this.issuerMobile = issuerMobile;
		this.issuerEmail = issuerEmail;
		this.issuerWebsite = issuerWebsite;
	}

	public Integer getIssuerId() {
		return this.issuerId;
	}

	public void setIssuerId(Integer issuerId) {
		this.issuerId = issuerId;
	}

	public TaxCondition getTaxCondition() {
		return this.taxCondition;
	}

	public void setTaxCondition(TaxCondition taxCondition) {
		this.taxCondition = taxCondition;
	}

	public String getIssuerName() {
		return this.issuerName;
	}

	public void setIssuerName(String issuerName) {
		this.issuerName = issuerName;
	}

	public String getIssuerCuit() {
		return this.issuerCuit;
	}

	public void setIssuerCuit(String issuerCuit) {
		this.issuerCuit = issuerCuit;
	}

	public float getIssuerCreditLimit() {
		return this.issuerCreditLimit;
	}

	public void setIssuerCreditLimit(float issuerCreditLimit) {
		this.issuerCreditLimit = issuerCreditLimit;
	}

	public String getIssuerAddress() {
		return this.issuerAddress;
	}

	public void setIssuerAddress(String issuerAddress) {
		this.issuerAddress = issuerAddress;
	}

	public String getIssuerCity() {
		return this.issuerCity;
	}

	public void setIssuerCity(String issuerCity) {
		this.issuerCity = issuerCity;
	}

	public String getIssuerPhone1() {
		return this.issuerPhone1;
	}

	public void setIssuerPhone1(String issuerPhone1) {
		this.issuerPhone1 = issuerPhone1;
	}

	public String getIssuerPhone2() {
		return this.issuerPhone2;
	}

	public void setIssuerPhone2(String issuerPhone2) {
		this.issuerPhone2 = issuerPhone2;
	}

	public String getIssuerMobile() {
		return this.issuerMobile;
	}

	public void setIssuerMobile(String issuerMobile) {
		this.issuerMobile = issuerMobile;
	}

	public String getIssuerEmail() {
		return this.issuerEmail;
	}

	public void setIssuerEmail(String issuerEmail) {
		this.issuerEmail = issuerEmail;
	}

	public String getIssuerWebsite() {
		return this.issuerWebsite;
	}

	public void setIssuerWebsite(String issuerWebsite) {
		this.issuerWebsite = issuerWebsite;
	}

	public Set getIssuerInvoices() {
		return this.issuerInvoices;
	}

	public void setIssuerInvoices(Set issuerInvoices) {
		this.issuerInvoices = issuerInvoices;
	}

	public Set getOrders() {
		return this.orders;
	}

	public void setOrders(Set orders) {
		this.orders = orders;
	}
	
	public String toString(){
		return this.issuerName;
	}

}

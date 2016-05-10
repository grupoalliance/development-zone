package org.tourandino.model;

// Generated Sep 4, 2015 1:38:42 AM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

/**
 * TaxCondition generated by hbm2java
 */
@SuppressWarnings("rawtypes")
public class TaxCondition implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6481570304344231209L;
	private Integer taxConditionId;
	private String taxConditionName;
	private String taxConditionDescr;
	private String taxConditionCode;
	private Set issuers = new HashSet(0);
	private Set customers = new HashSet(0);

	public TaxCondition() {
	}

	public TaxCondition(String taxConditionName, String taxConditionCode) {
		this.taxConditionName = taxConditionName;
		this.taxConditionCode = taxConditionCode;
	}

	public TaxCondition(String taxConditionName, String taxConditionDescr,
			String taxConditionCode, Set issuers, Set customers) {
		this.taxConditionName = taxConditionName;
		this.taxConditionDescr = taxConditionDescr;
		this.taxConditionCode = taxConditionCode;
		this.issuers = issuers;
		this.customers = customers;
	}

	public Integer getTaxConditionId() {
		return this.taxConditionId;
	}

	public void setTaxConditionId(Integer taxConditionId) {
		this.taxConditionId = taxConditionId;
	}

	public String getTaxConditionName() {
		return this.taxConditionName;
	}

	public void setTaxConditionName(String taxConditionName) {
		this.taxConditionName = taxConditionName;
	}

	public String getTaxConditionDescr() {
		return this.taxConditionDescr;
	}

	public void setTaxConditionDescr(String taxConditionDescr) {
		this.taxConditionDescr = taxConditionDescr;
	}

	public String getTaxConditionCode() {
		return this.taxConditionCode;
	}

	public void setTaxConditionCode(String taxConditionCode) {
		this.taxConditionCode = taxConditionCode;
	}

	public Set getIssuers() {
		return this.issuers;
	}

	public void setIssuers(Set issuers) {
		this.issuers = issuers;
	}

	public Set getCustomers() {
		return this.customers;
	}

	public void setCustomers(Set customers) {
		this.customers = customers;
	}
	
	public String toString(){
		return this.taxConditionName;
	}

}
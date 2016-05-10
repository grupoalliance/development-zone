package org.tourandino.model;

import java.util.Date;

public class IssuerInvoice implements java.io.Serializable {
	private static final long serialVersionUID = -1741381933608942242L;
	private Integer issuerInvoiceId;
	private Order order;
	private String issuerInvoiceNumber;
	private Date issuerInvoiceDate;
	private float issuerInvoiceTax;
	private float issuerInvoiceRate;
	private float issuerInvoiceTotal;
	private String issuerInvoiceStatus;

	public IssuerInvoice() {
	}

	public IssuerInvoice(Order order,
			String issuerInvoiceNumber, Date issuerInvoiceDate,
			float issuerInvoiceTax, float issuerInvoiceRate,
			float issuerInvoiceTotal) {
		this.order = order;
		this.issuerInvoiceNumber = issuerInvoiceNumber;
		this.issuerInvoiceDate = issuerInvoiceDate;
		this.issuerInvoiceTax = issuerInvoiceTax;
		this.issuerInvoiceRate = issuerInvoiceRate;
		this.issuerInvoiceTotal = issuerInvoiceTotal;
	}

	public IssuerInvoice(Order order,
			String issuerInvoiceNumber, Date issuerInvoiceDate,
			float issuerInvoiceTax, float issuerInvoiceRate,
			float issuerInvoiceTotal, String issuerInvoiceStatus) {
		this.order = order;
		this.issuerInvoiceNumber = issuerInvoiceNumber;
		this.issuerInvoiceDate = issuerInvoiceDate;
		this.issuerInvoiceTax = issuerInvoiceTax;
		this.issuerInvoiceRate = issuerInvoiceRate;
		this.issuerInvoiceTotal = issuerInvoiceTotal;
		this.issuerInvoiceStatus = issuerInvoiceStatus;
	}

	public Integer getIssuerInvoiceId() {
		return this.issuerInvoiceId;
	}

	public void setIssuerInvoiceId(Integer issuerInvoiceId) {
		this.issuerInvoiceId = issuerInvoiceId;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getIssuerInvoiceNumber() {
		return this.issuerInvoiceNumber;
	}

	public void setIssuerInvoiceNumber(String issuerInvoiceNumber) {
		this.issuerInvoiceNumber = issuerInvoiceNumber;
	}

	public Date getIssuerInvoiceDate() {
		return this.issuerInvoiceDate;
	}

	public void setIssuerInvoiceDate(Date issuerInvoiceDate) {
		this.issuerInvoiceDate = issuerInvoiceDate;
	}

	public float getIssuerInvoiceTax() {
		return this.issuerInvoiceTax;
	}

	public void setIssuerInvoiceTax(float issuerInvoiceTax) {
		this.issuerInvoiceTax = issuerInvoiceTax;
	}

	public float getIssuerInvoiceRate() {
		return this.issuerInvoiceRate;
	}

	public void setIssuerInvoiceRate(float issuerInvoiceRate) {
		this.issuerInvoiceRate = issuerInvoiceRate;
	}

	public float getIssuerInvoiceTotal() {
		return this.issuerInvoiceTotal;
	}

	public void setIssuerInvoiceTotal(float issuerInvoiceTotal) {
		this.issuerInvoiceTotal = issuerInvoiceTotal;
	}

	public String getIssuerInvoiceStatus() {
		return this.issuerInvoiceStatus;
	}

	public void setIssuerInvoiceStatus(String issuerInvoiceStatus) {
		this.issuerInvoiceStatus = issuerInvoiceStatus;
	}

}

package org.tourandino.model;

import java.util.Date;

public class CashMovement implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6797184566078822444L;
	private Integer cashMovementId;
	private DailyCashRecord dailyCashRecord;
	private Date cashMovementDate;
	private Date cashMovementTime;
	private float cashMovementIncome;
	private float cashMovementOutcome;
	private String cashMovementDescr;

	public CashMovement() {
	}

	public CashMovement(DailyCashRecord dailyCashRecord,
			Date cashMovementDate, Date cashMovementTime, 
			float cashMovementIncome,
			float cashMovementOutcome, String cashMovementDescr) {
		this.dailyCashRecord = dailyCashRecord;
		this.cashMovementDate = cashMovementDate;
		this.cashMovementTime = cashMovementTime;
		this.cashMovementIncome = cashMovementIncome;
		this.cashMovementOutcome = cashMovementOutcome;
		this.cashMovementDescr = cashMovementDescr;
	}

	public Integer getCashMovementId() {
		return this.cashMovementId;
	}

	public void setCashMovementId(Integer cashMovementId) {
		this.cashMovementId = cashMovementId;
	}

	public DailyCashRecord getDailyCashRecord() {
		return this.dailyCashRecord;
	}

	public void setDailyCashRecord(DailyCashRecord dailyCashRecord) {
		this.dailyCashRecord = dailyCashRecord;
	}

	public Date getCashMovementDate() {
		return this.cashMovementDate;
	}

	public void setCashMovementDate(Date cashMovementDate) {
		this.cashMovementDate = cashMovementDate;
	}
	
	public Date getCashMovementTime() {
		return this.cashMovementTime;
	}

	public void setCashMovementTime(Date cashMovementTime) {
		this.cashMovementTime = cashMovementTime;
	}

	public float getCashMovementIncome() {
		return this.cashMovementIncome;
	}

	public void setCashMovementIncome(float cashMovementIncome) {
		this.cashMovementIncome = cashMovementIncome;
	}

	public float getCashMovementOutcome() {
		return this.cashMovementOutcome;
	}

	public void setCashMovementOutcome(float cashMovementOutcome) {
		this.cashMovementOutcome = cashMovementOutcome;
	}

	public String getCashMovementDescr() {
		return this.cashMovementDescr;
	}

	public void setCashMovementDescr(String cashMovementDescr) {
		this.cashMovementDescr = cashMovementDescr;
	}

}

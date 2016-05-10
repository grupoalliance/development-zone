package org.tourandino.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("rawtypes")
public class DailyCashRecord implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -724397172089665796L;
	private Integer dailyCashRecordId;
	private Date openDatetime;
	private Date closeDatetime;
	private float incomeTotal;
	private float outcomeTotal;
	private float balance;
	private boolean isClosed;
	private Date dailyCashRecordDate;
	private Set cashMovements = new HashSet(0);

	public DailyCashRecord() {
	}

	public DailyCashRecord(Date openDatetime, float incomeTotal,
			float outcomeTotal, float balance, boolean isClosed,
			Date dailyCashRecordDate) {
		this.openDatetime = openDatetime;
		this.incomeTotal = incomeTotal;
		this.outcomeTotal = outcomeTotal;
		this.balance = balance;
		this.isClosed = isClosed;
		this.dailyCashRecordDate = dailyCashRecordDate;
	}

	public DailyCashRecord(Date openDatetime, Date closeDatetime,
			float incomeTotal, float outcomeTotal, float balance,
			boolean isClosed, Date dailyCashRecordDate, Set cashMovements) {
		this.openDatetime = openDatetime;
		this.closeDatetime = closeDatetime;
		this.incomeTotal = incomeTotal;
		this.outcomeTotal = outcomeTotal;
		this.balance = balance;
		this.isClosed = isClosed;
		this.dailyCashRecordDate = dailyCashRecordDate;
		this.cashMovements = cashMovements;
	}

	public Integer getDailyCashRecordId() {
		return this.dailyCashRecordId;
	}

	public void setDailyCashRecordId(Integer dailyCashRecordId) {
		this.dailyCashRecordId = dailyCashRecordId;
	}

	public Date getOpenDatetime() {
		return this.openDatetime;
	}

	public void setOpenDatetime(Date openDatetime) {
		this.openDatetime = openDatetime;
	}

	public Date getCloseDatetime() {
		return this.closeDatetime;
	}

	public void setCloseDatetime(Date closeDatetime) {
		this.closeDatetime = closeDatetime;
	}

	public float getIncomeTotal() {
		return this.incomeTotal;
	}

	public void setIncomeTotal(float incomeTotal) {
		this.incomeTotal = incomeTotal;
	}

	public float getOutcomeTotal() {
		return this.outcomeTotal;
	}

	public void setOutcomeTotal(float outcomeTotal) {
		this.outcomeTotal = outcomeTotal;
	}

	public float getBalance() {
		return this.balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public boolean isIsClosed() {
		return this.isClosed;
	}

	public void setIsClosed(boolean isClosed) {
		this.isClosed = isClosed;
	}

	public Date getDailyCashRecordDate() {
		return this.dailyCashRecordDate;
	}

	public void setDailyCashRecordDate(Date dailyCashRecordDate) {
		this.dailyCashRecordDate = dailyCashRecordDate;
	}

	public Set getCashMovements() {
		return this.cashMovements;
	}

	public void setCashMovements(Set cashMovements) {
		this.cashMovements = cashMovements;
	}

}

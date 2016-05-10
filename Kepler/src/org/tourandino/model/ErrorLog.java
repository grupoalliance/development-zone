package org.tourandino.model;

import java.util.Date;

public class ErrorLog implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7489379914041580063L;
	private Integer errorLogId;
	private Date datetime;
	private String message;
	private String location;
	private String detail;

	public ErrorLog() {
	}

	public ErrorLog(Date datetime, String message, String location,
			String detail) {
		this.datetime = datetime;
		this.message = message;
		this.location = location;
		this.detail = detail;
	}

	public Integer getErrorLogId() {
		return this.errorLogId;
	}

	public void setErrorLogId(Integer errorLogId) {
		this.errorLogId = errorLogId;
	}

	public Date getDatetime() {
		return this.datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}

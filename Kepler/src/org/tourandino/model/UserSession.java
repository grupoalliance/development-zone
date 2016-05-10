package org.tourandino.model;

import java.util.Date;

public class UserSession implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2983170426668887616L;
	private Integer userSessionId;
	private User user;
	private Date userSessionBegintime;
	private Date userSessionEndtime;
	private Boolean userSessionIsClosed;

	public UserSession() {
	}

	public UserSession(User user, Date userSessionBegintime) {
		this.user = user;
		this.userSessionBegintime = userSessionBegintime;
	}

	public UserSession(User user, Date userSessionBegintime,
			Date userSessionEndtime, Boolean userSessionIsClosed) {
		this.user = user;
		this.userSessionBegintime = userSessionBegintime;
		this.userSessionEndtime = userSessionEndtime;
		this.userSessionIsClosed = userSessionIsClosed;
	}

	public Integer getUserSessionId() {
		return this.userSessionId;
	}

	public void setUserSessionId(Integer userSessionId) {
		this.userSessionId = userSessionId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getUserSessionBegintime() {
		return this.userSessionBegintime;
	}

	public void setUserSessionBegintime(Date userSessionBegintime) {
		this.userSessionBegintime = userSessionBegintime;
	}

	public Date getUserSessionEndtime() {
		return this.userSessionEndtime;
	}

	public void setUserSessionEndtime(Date userSessionEndtime) {
		this.userSessionEndtime = userSessionEndtime;
	}

	public Boolean getUserSessionIsClosed() {
		return this.userSessionIsClosed;
	}

	public void setUserSessionIsClosed(Boolean userSessionIsClosed) {
		this.userSessionIsClosed = userSessionIsClosed;
	}

}

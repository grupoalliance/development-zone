package org.tourandino.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("rawtypes")
public class User implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4012511193695277198L;
	private Integer userId;
	private Role role;
	private String userUsername;
	private String userPassword;
	private String userFullname;
	private Date userBirthdate;
	private String userAddress;
	private String userCity;
	private String userPhone;
	private String userMobile;
	private String userEmail;
	private Set orders = new HashSet(0);
	private Set userSessions = new HashSet(0);

	public User() {
	}

	public User(Role role, String userUsername, String userPassword,
			String userFullname, Date userBirthdate) {
		this.role = role;
		this.userUsername = userUsername;
		this.userPassword = userPassword;
		this.userFullname = userFullname;
		this.userBirthdate = userBirthdate;
	}

	public User(Role role, String userUsername, String userPassword,
			String userFullname, Date userBirthdate, String userAddress,
			String userCity, String userPhone, String userMobile,
			String userEmail, Set orders, Set userSessions) {
		this.role = role;
		this.userUsername = userUsername;
		this.userPassword = userPassword;
		this.userFullname = userFullname;
		this.userBirthdate = userBirthdate;
		this.userAddress = userAddress;
		this.userCity = userCity;
		this.userPhone = userPhone;
		this.userMobile = userMobile;
		this.userEmail = userEmail;
		this.orders = orders;
		this.userSessions = userSessions;
	}
	
	public User(Role role, String userUsername, String userPassword,
			String userFullname, Date userBirthdate, String userAddress,
			String userCity, String userPhone, String userMobile,
			String userEmail) {
		this.role = role;
		this.userUsername = userUsername;
		this.userPassword = userPassword;
		this.userFullname = userFullname;
		this.userBirthdate = userBirthdate;
		this.userAddress = userAddress;
		this.userCity = userCity;
		this.userPhone = userPhone;
		this.userMobile = userMobile;
		this.userEmail = userEmail;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getUserUsername() {
		return this.userUsername;
	}

	public void setUserUsername(String userUsername) {
		this.userUsername = userUsername;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserFullname() {
		return this.userFullname;
	}

	public void setUserFullname(String userFullname) {
		this.userFullname = userFullname;
	}

	public Date getUserBirthdate() {
		return this.userBirthdate;
	}

	public void setUserBirthdate(Date userBirthdate) {
		this.userBirthdate = userBirthdate;
	}

	public String getUserAddress() {
		return this.userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserCity() {
		return this.userCity;
	}

	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	public String getUserPhone() {
		return this.userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserMobile() {
		return this.userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Set getOrders() {
		return this.orders;
	}

	public void setOrders(Set orders) {
		this.orders = orders;
	}

	public Set getUserSessions() {
		return userSessions;
	}

	public void setUserSessions(Set userSessions) {
		this.userSessions = userSessions;
	}
	
	

}

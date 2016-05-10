package org.tourandino.model;

// Generated Sep 4, 2015 1:38:42 AM by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("rawtypes")
public class Passenger implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3238809725065598893L;
	private Integer passengerId;
	private String passengerFullname;
	private Date passengerBirthdate;
	private String passengerAddress;
	private String passengerCity;
	private String passengerPhone1;
	private String passengerPhone2;
	private String passengerMobile1;
	private String passengerMobile2;
	private String passengerEmail;
	private Set insurancePassengers = new HashSet(0);
	private Set busPassengers = new HashSet(0);
	private Set flightPassengers = new HashSet(0);
	private Set hotelPassengers = new HashSet(0);
	private Set packagePassengers = new HashSet(0);

	public Passenger() {
	}

	public Passenger(String passengerFullname, Date passengerBirthdate) {
		this.passengerFullname = passengerFullname;
		this.passengerBirthdate = passengerBirthdate;
	}

	public Passenger(String passengerFullname, Date passengerBirthdate,
			String passengerAddress, String passengerCity,
			String passengerPhone1, String passengerPhone2,
			String passengerMobile1, String passengerMobile2,
			String passengerEmail, Set insurancePassengers, Set busPassengers,
			Set flightPassengers, Set hotelPassengers, Set packagePassengers) {
		this.passengerFullname = passengerFullname;
		this.passengerBirthdate = passengerBirthdate;
		this.passengerAddress = passengerAddress;
		this.passengerCity = passengerCity;
		this.passengerPhone1 = passengerPhone1;
		this.passengerPhone2 = passengerPhone2;
		this.passengerMobile1 = passengerMobile1;
		this.passengerMobile2 = passengerMobile2;
		this.passengerEmail = passengerEmail;
		this.insurancePassengers = insurancePassengers;
		this.busPassengers = busPassengers;
		this.flightPassengers = flightPassengers;
		this.hotelPassengers = hotelPassengers;
		this.packagePassengers = packagePassengers;
	}
	
	public Passenger(String passengerFullname, Date passengerBirthdate,
			String passengerAddress, String passengerCity,
			String passengerPhone1, String passengerPhone2,
			String passengerMobile1, String passengerMobile2,
			String passengerEmail) {
		this.passengerFullname = passengerFullname;
		this.passengerBirthdate = passengerBirthdate;
		this.passengerAddress = passengerAddress;
		this.passengerCity = passengerCity;
		this.passengerPhone1 = passengerPhone1;
		this.passengerPhone2 = passengerPhone2;
		this.passengerMobile1 = passengerMobile1;
		this.passengerMobile2 = passengerMobile2;
		this.passengerEmail = passengerEmail;
	}

	public Integer getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(Integer passengerId) {
		this.passengerId = passengerId;
	}

	public String getPassengerFullname() {
		return passengerFullname;
	}

	public void setPassengerFullname(String passengerFullname) {
		this.passengerFullname = passengerFullname;
	}

	public Date getPassengerBirthdate() {
		return passengerBirthdate;
	}

	public void setPassengerBirthdate(Date passengerBirthdate) {
		this.passengerBirthdate = passengerBirthdate;
	}

	public String getPassengerAddress() {
		return passengerAddress;
	}

	public void setPassengerAddress(String passengerAddress) {
		this.passengerAddress = passengerAddress;
	}

	public String getPassengerCity() {
		return passengerCity;
	}

	public void setPassengerCity(String passengerCity) {
		this.passengerCity = passengerCity;
	}

	public String getPassengerPhone1() {
		return passengerPhone1;
	}

	public void setPassengerPhone1(String passengerPhone1) {
		this.passengerPhone1 = passengerPhone1;
	}

	public String getPassengerPhone2() {
		return passengerPhone2;
	}

	public void setPassengerPhone2(String passengerPhone2) {
		this.passengerPhone2 = passengerPhone2;
	}

	public String getPassengerMobile1() {
		return passengerMobile1;
	}

	public void setPassengerMobile1(String passengerMobile1) {
		this.passengerMobile1 = passengerMobile1;
	}

	public String getPassengerMobile2() {
		return passengerMobile2;
	}

	public void setPassengerMobile2(String passengerMobile2) {
		this.passengerMobile2 = passengerMobile2;
	}

	public String getPassengerEmail() {
		return passengerEmail;
	}

	public void setPassengerEmail(String passengerEmail) {
		this.passengerEmail = passengerEmail;
	}

	public Set getInsurancePassengers() {
		return insurancePassengers;
	}

	public void setInsurancePassengers(Set insurancePassengers) {
		this.insurancePassengers = insurancePassengers;
	}

	public Set getBusPassengers() {
		return busPassengers;
	}

	public void setBusPassengers(Set busPassengers) {
		this.busPassengers = busPassengers;
	}

	public Set getFlightPassengers() {
		return flightPassengers;
	}

	public void setFlightPassengers(Set flightPassengers) {
		this.flightPassengers = flightPassengers;
	}

	public Set getHotelPassengers() {
		return hotelPassengers;
	}

	public void setHotelPassengers(Set hotelPassengers) {
		this.hotelPassengers = hotelPassengers;
	}

	public Set getPackagePassengers() {
		return packagePassengers;
	}

	public void setPackagePassengers(Set packagePassengers) {
		this.packagePassengers = packagePassengers;
	}

	

}

package org.tourandino.model;

import java.util.Date;

public class HotelPassenger implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2996071463642917837L;
	private Integer hotelPassengerId;
	private Passenger passenger;
	private Order order;
	private String hotelName;
	private String hotelAddressCity;
	private Date checkInDate;
	private Date checkOutDate;
	private String hotelRooms;
	private float hotelPrice;
	private float hotelCost;
	

	public HotelPassenger() {
	}


	public HotelPassenger(Passenger passenger, Order order, String hotelName,
			String hotelAddressCity, Date checkInDate, Date checkOutDate,
			String hotelRooms, float hotelPrice, float hotelCost) {
		this.passenger = passenger;
		this.order = order;
		this.hotelName = hotelName;
		this.hotelAddressCity = hotelAddressCity;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.hotelRooms = hotelRooms;
		this.hotelPrice = hotelPrice;
		this.hotelCost = hotelCost;
	}


	public Integer getHotelPassengerId() {
		return hotelPassengerId;
	}


	public void setHotelPassengerId(Integer hotelPassengerId) {
		this.hotelPassengerId = hotelPassengerId;
	}


	public Passenger getPassenger() {
		return passenger;
	}


	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}


	public Order getOrder() {
		return order;
	}


	public void setOrder(Order order) {
		this.order = order;
	}


	public String getHotelName() {
		return hotelName;
	}


	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}


	public String getHotelAddressCity() {
		return hotelAddressCity;
	}


	public void setHotelAddressCity(String hotelAddressCity) {
		this.hotelAddressCity = hotelAddressCity;
	}


	public Date getCheckInDate() {
		return checkInDate;
	}


	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}


	public Date getCheckOutDate() {
		return checkOutDate;
	}


	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}


	public String getHotelRooms() {
		return hotelRooms;
	}


	public void setHotelRooms(String hotelRooms) {
		this.hotelRooms = hotelRooms;
	}


	public float getHotelPrice() {
		return hotelPrice;
	}


	public void setHotelPrice(float hotelPrice) {
		this.hotelPrice = hotelPrice;
	}


	public float getHotelCost() {
		return hotelCost;
	}


	public void setHotelCost(float hotelCost) {
		this.hotelCost = hotelCost;
	}

	

}

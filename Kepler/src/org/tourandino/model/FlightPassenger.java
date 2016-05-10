package org.tourandino.model;

public class FlightPassenger implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3453780342480921852L;
	private Integer flightPassengerId;
	private Passenger passenger;
	private String flightName;
	private Order order;
	private float flightPrice;
	private float flightCost;
	private String itinerary;

	public FlightPassenger() {
	}

	public Integer getFlightPassengerId() {
		return flightPassengerId;
	}

	public void setFlightPassengerId(Integer flightPassengerId) {
		this.flightPassengerId = flightPassengerId;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	
	public String getFlightName(){
		return this.flightName;
	}
	
	public void setFlightName(String flightName){
		this.flightName = flightName;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public float getFlightPrice() {
		return flightPrice;
	}

	public void setFlightPrice(float flightPrice) {
		this.flightPrice = flightPrice;
	}

	public float getFlightCost() {
		return flightCost;
	}

	public void setFlightCost(float flightCost) {
		this.flightCost = flightCost;
	}

	public String getItinerary() {
		return itinerary;
	}

	public void setItinerary(String itinerary) {
		this.itinerary = itinerary;
	}

	public FlightPassenger(Passenger passenger, String flightName, Order order, 
			float flightPrice, float flightCost, String itinerary) {
		this.passenger = passenger;
		this.flightName = flightName;
		this.order = order;
		this.flightPrice = flightPrice;
		this.flightCost = flightCost;
		this.itinerary = itinerary;
	}

	

}

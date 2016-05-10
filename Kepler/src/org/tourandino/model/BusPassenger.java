package org.tourandino.model;

public class BusPassenger implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2757599708160437385L;
	private Integer busPassengerId;
	private Passenger passenger;
	private String busName;
	private Order order;
	private String itinerary;
	private float busPrice;
	private float busCost;
	
	public BusPassenger() {
	}

	public BusPassenger(Passenger passenger, String busName, Order order, 
			String itinerary, float busPrice, float busCost) {
		this.passenger = passenger;
		this.busName = busName;
		this.order = order;
		this.itinerary = itinerary;
		this.busPrice = busPrice;
		this.busCost = busCost;
	}
	

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getItinerary() {
		return itinerary;
	}

	public void setItinerary(String itinerary) {
		this.itinerary = itinerary;
	}

	public float getBusPrice() {
		return busPrice;
	}

	public void setBusPrice(float busPrice) {
		this.busPrice = busPrice;
	}

	public float getBusCost() {
		return busCost;
	}

	public void setBusCost(float busCost) {
		this.busCost = busCost;
	}

	public Integer getBusPassengerId() {
		return this.busPassengerId;
	}

	public void setBusPassengerId(Integer busPassengerId) {
		this.busPassengerId = busPassengerId;
	}

	public Passenger getPassenger() {
		return this.passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	
	public String getBusName(){
		return this.busName;
	}
	
	public void setBusName(String busName){
		this.busName = busName;
	}

}

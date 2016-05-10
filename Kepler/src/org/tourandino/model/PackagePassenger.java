package org.tourandino.model;

public class PackagePassenger implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -181636179889449320L;
	private Integer packagePassengerId;
	private Passenger passenger;
	private Order order;
	private String itinerary;
	private String packageName;
	private String packageNote;
	private float packagePrice;
	private float packageCost;	

	public PackagePassenger() {
	}

	public PackagePassenger(Passenger passenger, Order order, String itinerary,
			String packageName, String packageNote,
			float packagePrice, float packageCost) {
		this.order = order;
		this.passenger = passenger;
		this.itinerary = itinerary;
		this.packagePrice = packagePrice;
		this.packageCost = packageCost;
		this.packageName = packageName;
		this.packageNote = packageNote;
	}


	public Order getOrder() {
		return order;
	}


	public void setOrder(Order order) {
		this.order = order;
	}


	public Passenger getPassenger() {
		return passenger;
	}


	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}


	public String getItinerary() {
		return itinerary;
	}


	public void setItinerary(String itinerary) {
		this.itinerary = itinerary;
	}


	public float getPackagePrice() {
		return packagePrice;
	}


	public void setPackagePrice(float packagePrice) {
		this.packagePrice = packagePrice;
	}


	public float getPackageCost() {
		return packageCost;
	}


	public void setPackageCost(float packageCost) {
		this.packageCost = packageCost;
	}


	public String getPackageName() {
		return packageName;
	}


	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}


	public String getPackageNote() {
		return packageNote;
	}


	public void setPackageNote(String packageNote) {
		this.packageNote = packageNote;
	}


	public Integer getPackagePassengerId() {
		return packagePassengerId;
	}


	public void setPackagePassengerId(Integer packagePassengerId) {
		this.packagePassengerId = packagePassengerId;
	}

	

}

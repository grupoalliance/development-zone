package org.tourandino.model;

public class InsurancePassenger implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4686961890681379220L;
	private Integer insurancePassengerId;
	private Passenger passenger;
	private Order order;
	private String insuranceName;
	private String insuranceType;
	private String insuranceNote;
	private float insurancePrice;
	private float insuranceCost;
	

	public InsurancePassenger() {
	}


	public InsurancePassenger(Passenger passenger, Order order,
			String insuranceName, String insuranceType, String insuranceNote,
			float insurancePrice, float insuranceCost) {
		this.passenger = passenger;
		this.order = order;
		this.insuranceName = insuranceName;
		this.insuranceType = insuranceType;
		this.insuranceNote = insuranceNote;
		this.insurancePrice = insurancePrice;
		this.insuranceCost = insuranceCost;
	}


	public Integer getInsurancePassengerId() {
		return insurancePassengerId;
	}


	public void setInsurancePassengerId(Integer insurancePassengerId) {
		this.insurancePassengerId = insurancePassengerId;
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


	public String getInsuranceName() {
		return insuranceName;
	}


	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}


	public String getInsuranceType() {
		return insuranceType;
	}


	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}


	public String getInsuranceNote() {
		return insuranceNote;
	}


	public void setInsuranceNote(String insuranceNote) {
		this.insuranceNote = insuranceNote;
	}


	public float getInsurancePrice() {
		return insurancePrice;
	}


	public void setInsurancePrice(float insurancePrice) {
		this.insurancePrice = insurancePrice;
	}


	public float getInsuranceCost() {
		return insuranceCost;
	}


	public void setInsuranceCost(float insuranceCost) {
		this.insuranceCost = insuranceCost;
	}
	
	

}

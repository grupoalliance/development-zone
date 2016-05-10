package org.tourandino.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("rawtypes")
public class Order implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9186583935481580241L;
	private Integer orderId;
	private User user;
	private Issuer issuer;
	private Customer customer;
	private Date orderDate;
	private Date orderTime;
	private float orderSubtotal;
	private float orderRate;
	private float orderTax;
	private float orderDiscount;
	private float orderTotal;
	private float orderCost;
	private float orderProfit;
	private String orderDescr;
	private Set issuerInvoices = new HashSet(0);
	private Set insurancePassengers = new HashSet(0);
	private Set packagePassengers = new HashSet(0);
	private Set flightPassengers = new HashSet(0);
	private Set busPassengers = new HashSet(0);
	private Set hotelPassengers = new HashSet(0);
	private Set payments = new HashSet(0);

	public Order() {
	}

	public Order(User user, Issuer issuer, Customer customer, Date orderDate,
			Date orderTime, float orderSubtotal, float orderRate, float orderTax,
			float orderDiscount, float orderTotal, float orderCost,
			float orderProfit) {
		this.user = user;
		this.issuer = issuer;
		this.customer = customer;
		this.orderDate = orderDate;
		this.orderTime = orderTime;
		this.orderSubtotal = orderSubtotal;
		this.orderRate = orderRate;
		this.orderTax = orderTax;
		this.orderDiscount = orderDiscount;
		this.orderTotal = orderTotal;
		this.orderCost = orderCost;
		this.orderProfit = orderProfit;
	}

	public Order(User user, Issuer issuer, Customer customer,
			Date orderDate, Date orderTime, float orderRate, float orderTax,
			float orderDiscount, float orderTotal, float orderCost,
			float orderProfit, String orderDescr, Set issuerInvoices,
			Set insurancePassengers, Set packagePassengers,
			Set flightPassengers, Set busPassengers, Set hotelPassengers,
			Set payments) {
		this.user = user;
		this.issuer = issuer;
		this.customer = customer;
		this.orderDate = orderDate;
		this.orderTime = orderTime;
		this.orderRate = orderRate;
		this.orderTax = orderTax;
		this.orderDiscount = orderDiscount;
		this.orderTotal = orderTotal;
		this.orderCost = orderCost;
		this.orderProfit = orderProfit;
		this.orderDescr = orderDescr;
		this.issuerInvoices = issuerInvoices;
		this.insurancePassengers = insurancePassengers;
		this.packagePassengers = packagePassengers;
		this.flightPassengers = flightPassengers;
		this.busPassengers = busPassengers;
		this.hotelPassengers = hotelPassengers;
		this.payments = payments;
	}
	
	public Order(User user, float orderSubtotal, float orderRate, float orderTax,
			float orderDiscount, float orderTotal, float orderCost,
			float orderProfit, String orderDescr) {
		this.user = user;
		this.orderSubtotal = orderSubtotal;
		this.orderRate = orderRate;
		this.orderTax = orderTax;
		this.orderDiscount = orderDiscount;
		this.orderTotal = orderTotal;
		this.orderCost = orderCost;
		this.orderProfit = orderProfit;
		this.orderDescr = orderDescr;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Issuer getIssuer() {
		return issuer;
	}

	public void setIssuer(Issuer issuer) {
		this.issuer = issuer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public float getOrderRate() {
		return orderRate;
	}

	public void setOrderRate(float orderRate) {
		this.orderRate = orderRate;
	}

	public float getOrderTax() {
		return orderTax;
	}

	public void setOrderTax(float orderTax) {
		this.orderTax = orderTax;
	}

	public float getOrderDiscount() {
		return orderDiscount;
	}

	public void setOrderDiscount(float orderDiscount) {
		this.orderDiscount = orderDiscount;
	}

	public float getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(float orderTotal) {
		this.orderTotal = orderTotal;
	}

	public float getOrderCost() {
		return orderCost;
	}

	public void setOrderCost(float orderCost) {
		this.orderCost = orderCost;
	}

	public float getOrderProfit() {
		return orderProfit;
	}

	public void setOrderProfit(float orderProfit) {
		this.orderProfit = orderProfit;
	}

	public String getOrderDescr() {
		return orderDescr;
	}

	public void setOrderDescr(String orderDescr) {
		this.orderDescr = orderDescr;
	}

	public Set getIssuerInvoices() {
		return issuerInvoices;
	}

	public void setIssuerInvoices(Set issuerInvoices) {
		this.issuerInvoices = issuerInvoices;
	}

	public Set getInsurancePassengers() {
		return insurancePassengers;
	}

	public void setInsurancePassengers(Set insurancePassengers) {
		this.insurancePassengers = insurancePassengers;
	}

	public Set getPackagePassengers() {
		return packagePassengers;
	}

	public void setPackagePassengers(Set packagePassengers) {
		this.packagePassengers = packagePassengers;
	}

	public Set getFlightPassengers() {
		return flightPassengers;
	}

	public void setFlightPassengers(Set flightPassengers) {
		this.flightPassengers = flightPassengers;
	}

	public Set getBusPassengers() {
		return busPassengers;
	}

	public void setBusPassengers(Set busPassengers) {
		this.busPassengers = busPassengers;
	}

	public Set getHotelPassengers() {
		return hotelPassengers;
	}

	public void setHotelPassengers(Set hotelPassengers) {
		this.hotelPassengers = hotelPassengers;
	}

	public Set getPayments() {
		return payments;
	}

	public void setPayments(Set payments) {
		this.payments = payments;
	}

	public float getOrderSubtotal() {
		return orderSubtotal;
	}

	public void setOrderSubtotal(float orderSubtotal) {
		this.orderSubtotal = orderSubtotal;
	}

}

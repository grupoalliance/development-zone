package org.tourandino.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.tourandino.model.FlightPassenger;
import org.tourandino.model.Order;
import org.tourandino.model.Passenger;
import org.tourandino.service.FlightPassengerService;

public class FlightPassengerController {
	private FlightPassengerService flightPassengerService;
	private FlightPassenger flightPassenger;
	private List<FlightPassenger> flightPassengers;
	
	public FlightPassengerController(){
		this.flightPassengerService = new FlightPassengerService();
	}
	
	public void initializeFlightPassenger(){
		this.flightPassengers = new ArrayList<FlightPassenger>();
	}
	
	public void create(){
		if(flightPassengers != null){
			for(FlightPassenger flightPassenger :flightPassengers){
				flightPassengerService.create(flightPassenger);
			}
		}
	}
	
	public void add(Passenger passenger, String flightName, Order order, float price, float cost, String itinerary){
		flightPassenger = new FlightPassenger(passenger, flightName, order, price, cost, itinerary);
		flightPassengers.add(flightPassenger);
	}
	
	public void remove(Order order, int index){
		order.setOrderTotal(order.getOrderTotal()-flightPassengers.get(index).getFlightPrice());
		order.setOrderSubtotal(order.getOrderTotal());
		order.setOrderCost(order.getOrderCost()-flightPassengers.get(index).getFlightCost());
		order.setOrderProfit(order.getOrderTotal()-order.getOrderCost());
		flightPassengers.remove(index);
	}
	
	public DefaultTableModel readByOrder(Integer orderId){
		flightPassengers = flightPassengerService.readByOrder(orderId);
		Object[] columns = new Object[]{"ID","Pasajero", "Tramo", "Empresa", "Precio", "Costo"};
		DefaultTableModel model = new DefaultTableModel(null, columns);
		if(!flightPassengers.isEmpty()){
			for (FlightPassenger flightPassenger :flightPassengers){
	            	model.addRow(new Object[]{
	            			flightPassenger.getFlightPassengerId(),
	            			flightPassenger.getPassenger().getPassengerFullname(),
	            			flightPassenger.getItinerary(),
	            			flightPassenger.getFlightName(),
	            			flightPassenger.getFlightPrice(),
	            			flightPassenger.getFlightCost()
	            	});
			}
		}
		return model;
	}

	public FlightPassengerService getFlightPassengerService() {
		return flightPassengerService;
	}

	public void setFlightPassengerService(
			FlightPassengerService flightPassengerService) {
		this.flightPassengerService = flightPassengerService;
	}

	public FlightPassenger getFlightPassenger() {
		return flightPassenger;
	}

	public void setFlightPassenger(FlightPassenger flightPassenger) {
		this.flightPassenger = flightPassenger;
	}

	public List<FlightPassenger> getFlightPassengers() {
		return flightPassengers;
	}

	public void setFlightPassengers(List<FlightPassenger> flightPassengers) {
		this.flightPassengers = flightPassengers;
	}
	
}

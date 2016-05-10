package org.tourandino.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.tourandino.model.BusPassenger;
import org.tourandino.model.Order;
import org.tourandino.model.Passenger;
import org.tourandino.service.BusPassengerService;

public class BusPassengerController {
	private BusPassenger busPassenger;
	private List<BusPassenger> busPassengers;
	private BusPassengerService busPassengerService;
	
	public BusPassengerController(){
		this.busPassengerService = new BusPassengerService();
	}
	
	public void initializeBusPassenger(){
		this.busPassengers = new ArrayList<BusPassenger>();
	}
	
	public void create(){
		if(busPassengers != null){
			for(BusPassenger busPassenger :busPassengers){
				busPassengerService.create(busPassenger);
			}
		}
	}
	public void add(Passenger passenger, String busName, Order order, float price, float cost, String itinerary){
		busPassenger = new BusPassenger(passenger, busName, order, itinerary, price, cost);
		busPassengers.add(busPassenger);
	}
	
	public void remove(Order order, int index){
		order.setOrderTotal(order.getOrderTotal()-busPassengers.get(index).getBusPrice());
		order.setOrderSubtotal(order.getOrderTotal());
		order.setOrderCost(order.getOrderCost()-busPassengers.get(index).getBusCost());
		order.setOrderProfit(order.getOrderTotal()-order.getOrderCost());
		busPassengers.remove(index);
	}
	
	public DefaultTableModel readByOrder(Integer orderId){
		busPassengers = busPassengerService.readByOrder(orderId);
		Object[] columns = new Object[]{"ID","Pasajero", "Tramo", "Empresa", "Precio", "Costo"};
		DefaultTableModel model = new DefaultTableModel(null, columns);
		if(!busPassengers.isEmpty()){
			for (BusPassenger busPassenger :busPassengers){
				model.addRow(new Object[]{
						busPassenger.getBusPassengerId(),
						busPassenger.getPassenger().getPassengerFullname(),
						busPassenger.getItinerary(),
						busPassenger.getBusName(),
						busPassenger.getBusPrice(),
						busPassenger.getBusCost()
				});
			}
		}
		return model;
	}

	public BusPassenger getBusPassenger() {
		return busPassenger;
	}

	public void setBusPassenger(BusPassenger busPassenger) {
		this.busPassenger = busPassenger;
	}

	public List<BusPassenger> getBusPassengers() {
		return busPassengers;
	}

	public void setBusPassengers(List<BusPassenger> busPassengers) {
		this.busPassengers = busPassengers;
	}

	public BusPassengerService getBusPassengerService() {
		return busPassengerService;
	}

	public void setBusPassengerService(BusPassengerService busPassengerService) {
		this.busPassengerService = busPassengerService;
	}

}

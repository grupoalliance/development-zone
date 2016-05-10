package org.tourandino.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.tourandino.model.InsurancePassenger;
import org.tourandino.model.Order;
import org.tourandino.model.Passenger;
import org.tourandino.service.InsurancePassengerService;

public class InsurancePassengerController {
	private InsurancePassenger insurancePassenger;
	private List<InsurancePassenger> insurancePassengers;
	private InsurancePassengerService insurancePassengerService;
	
	public InsurancePassengerController(){
		this.insurancePassengerService = new InsurancePassengerService();
	}
	
	public void initializeInsurancePassenger(){
		this.insurancePassengers = new ArrayList<InsurancePassenger>();
	}
	
	public void create(){
		if(insurancePassengers != null){
			for(InsurancePassenger insurancePassenger :insurancePassengers){
				insurancePassengerService.create(insurancePassenger);
			}
		}
	}
	public void add(Passenger passenger, Order order, String insuranceName, String insuranceType,
			String insuranceNote, float price, float cost){
		insurancePassenger = new InsurancePassenger(passenger, order, insuranceName, insuranceType, insuranceNote, price, cost);
		insurancePassengers.add(insurancePassenger);
	}
	
	public void remove(Order order, int index){
		order.setOrderTotal(order.getOrderTotal()-insurancePassengers.get(index).getInsurancePrice());
		order.setOrderSubtotal(order.getOrderTotal());
		order.setOrderCost(order.getOrderCost()-insurancePassengers.get(index).getInsuranceCost());
		order.setOrderProfit(order.getOrderTotal()-order.getOrderCost());
		insurancePassengers.remove(index);
	}
	
	public DefaultTableModel readByOrder(Integer orderId){
		insurancePassengers = insurancePassengerService.readByOrder(orderId);
		Object[] columns = new Object[]{"ID","Pasajero", "Seguro", "Tipo", "Descripción", "Precio", "Costo"};
		DefaultTableModel model = new DefaultTableModel(null, columns);
		if(!insurancePassengers.isEmpty()){
			for (InsurancePassenger insurancePassenger :insurancePassengers)
	            
	            	model.addRow(new Object[]{
	            			insurancePassenger.getInsurancePassengerId(),
	            			insurancePassenger.getPassenger().getPassengerFullname(),
	            			insurancePassenger.getInsuranceName(),
	            			insurancePassenger.getInsuranceType(),
	            			insurancePassenger.getInsuranceNote(),
	            			insurancePassenger.getInsurancePrice(),
	            			insurancePassenger.getInsuranceCost()
	            	});
	            
		}
		return model;
	}

	public InsurancePassenger getInsurancePassenger() {
		return insurancePassenger;
	}

	public void setInsurancePassenger(InsurancePassenger insurancePassenger) {
		this.insurancePassenger = insurancePassenger;
	}

	public List<InsurancePassenger> getInsurancePassengers() {
		return insurancePassengers;
	}

	public void setInsurancePassengers(List<InsurancePassenger> insurancePassengers) {
		this.insurancePassengers = insurancePassengers;
	}

	public InsurancePassengerService getInsurancePassengerService() {
		return insurancePassengerService;
	}

	public void setInsurancePassengerService(
			InsurancePassengerService insurancePassengerService) {
		this.insurancePassengerService = insurancePassengerService;
	}

}

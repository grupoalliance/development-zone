package org.tourandino.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.tourandino.model.Order;
import org.tourandino.model.PackagePassenger;
import org.tourandino.model.Passenger;
import org.tourandino.service.PackagePassengerService;

public class PackagePassengerController {
	private PackagePassenger packagePassenger;
	private List<PackagePassenger> packagePassengers;
	private PackagePassengerService packagePassengerService;
	
	public PackagePassengerController(){
		this.packagePassengerService = new PackagePassengerService();
	}
	
	public void initializePackagePassenger(){
		this.packagePassengers = new ArrayList<PackagePassenger>();
	}
	
	public void create(){
		if(packagePassengers != null){
			for(PackagePassenger packagePassenger :packagePassengers){
				packagePassengerService.create(packagePassenger);
			}
		}
	}
	public void add(Passenger passenger, Order order, String itinerary, String packageName, String packageNote, float price, float cost){
		packagePassenger = new PackagePassenger(passenger, order, itinerary, packageName, packageNote, price, cost);
		packagePassengers.add(packagePassenger);
	}
	
	public void remove(Order order, int index){
		order.setOrderTotal(order.getOrderTotal()-packagePassengers.get(index).getPackagePrice());
		order.setOrderSubtotal(order.getOrderTotal());
		order.setOrderCost(order.getOrderCost()-packagePassengers.get(index).getPackageCost());
		order.setOrderProfit(order.getOrderTotal()-order.getOrderCost());
		packagePassengers.remove(index);
	}
	
	public DefaultTableModel readByOrder(Integer orderId){
		packagePassengers = packagePassengerService.readByOrder(orderId);
		Object[] columns = new Object[]{"ID","Pasajero", "Paquete", "Itinerario", "Descripción", "Precio", "Costo"};
		DefaultTableModel model = new DefaultTableModel(null, columns);
		if(!packagePassengers.isEmpty()){
			for (PackagePassenger packagePassenger :packagePassengers)
	            
	            	model.addRow(new Object[]{
	            			packagePassenger.getPackagePassengerId(),
	            			packagePassenger.getPassenger().getPassengerFullname(),
	            			packagePassenger.getPackageName(),
	            			packagePassenger.getItinerary(),
	            			packagePassenger.getPackageNote(),
	            			packagePassenger.getPackagePrice(),
	            			packagePassenger.getPackageCost()
	            	});
	            
		}
		return model;
	}

	public PackagePassenger getPackagePassenger() {
		return packagePassenger;
	}

	public void setPackagePassenger(PackagePassenger packagePassenger) {
		this.packagePassenger = packagePassenger;
	}

	public List<PackagePassenger> getPackagePassengers() {
		return packagePassengers;
	}

	public void setPackagePassengers(List<PackagePassenger> packagePassengers) {
		this.packagePassengers = packagePassengers;
	}

	public PackagePassengerService getPackagePassengerService() {
		return packagePassengerService;
	}

	public void setPackagePassengerService(
			PackagePassengerService packagePassengerService) {
		this.packagePassengerService = packagePassengerService;
	}

}

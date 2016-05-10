package org.tourandino.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.tourandino.model.HotelPassenger;
import org.tourandino.model.Order;
import org.tourandino.model.Passenger;
import org.tourandino.service.HotelPassengerService;

public class HotelPassengerController {
	private HotelPassenger hotelPassenger;
	private List<HotelPassenger> hotelPassengers;
	private HotelPassengerService hotelPassengerService;
	
	public HotelPassengerController(){
		this.hotelPassengerService = new HotelPassengerService();
	}
	
	public void initializeHotelPassenger(){
		this.hotelPassengers = new ArrayList<HotelPassenger>();
	}
	
	public void create(){
		if(hotelPassengers != null){
			for(HotelPassenger hotelPassenger :hotelPassengers){
				hotelPassengerService.create(hotelPassenger);
			}
		}
	}
	public void add(Passenger passenger, Order order, String hotelName, String hotelAddressCity, Date checkIn, Date checkOut,
			String hotelRoom, float price, float cost){
		hotelPassenger = new HotelPassenger(passenger, order, hotelName, hotelAddressCity, checkIn, checkOut, hotelRoom , price, cost);
		hotelPassengers.add(hotelPassenger);
	}
	
	public void remove(Order order, int index){
		order.setOrderTotal(order.getOrderTotal()-hotelPassengers.get(index).getHotelPrice());
		order.setOrderSubtotal(order.getOrderTotal());
		order.setOrderCost(order.getOrderCost()-hotelPassengers.get(index).getHotelCost());
		order.setOrderProfit(order.getOrderTotal()-order.getOrderCost());
		hotelPassengers.remove(index);
	}
	
	public DefaultTableModel readByOrder(Integer orderId){
		hotelPassengers = hotelPassengerService.readByOrder(orderId);
		Object[] columns = new Object[]{"ID","Pasajero", "Hotel", "Domicilio", "Check-in", "Check-out", "Habitaciones", "Precio", "Costo"};
		DefaultTableModel model = new DefaultTableModel(null, columns);
		if(!hotelPassengers.isEmpty()){
			SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy");
			for (HotelPassenger hotelPassenger :hotelPassengers){
	            
	            	model.addRow(new Object[]{
	            			hotelPassenger.getHotelPassengerId(),
	            			hotelPassenger.getPassenger().getPassengerFullname(),
	            			hotelPassenger.getHotelName(),
	            			hotelPassenger.getHotelAddressCity(),
	            			sdfDate.format(hotelPassenger.getCheckInDate()),
	            			sdfDate.format(hotelPassenger.getCheckOutDate()),
	            			hotelPassenger.getHotelRooms(),
	            			hotelPassenger.getHotelPrice(),
	            			hotelPassenger.getHotelCost()
	            	});
			}  
		}
		return model;
	}

	public HotelPassenger getHotelPassenger() {
		return hotelPassenger;
	}

	public void setHotelPassenger(HotelPassenger hotelPassenger) {
		this.hotelPassenger = hotelPassenger;
	}

	public List<HotelPassenger> getHotelPassengers() {
		return hotelPassengers;
	}

	public void setHotelPassengers(List<HotelPassenger> hotelPassengers) {
		this.hotelPassengers = hotelPassengers;
	}

	public HotelPassengerService getHotelPassengerService() {
		return hotelPassengerService;
	}

	public void setHotelPassengerService(HotelPassengerService hotelPassengerService) {
		this.hotelPassengerService = hotelPassengerService;
	}

}

package org.tourandino.controller;

import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

import org.tourandino.model.Passenger;
import org.tourandino.service.PassengerService;

public class PassengerController {
	private Passenger passenger;
	private PassengerService passengerService;
	private List<Passenger> passengers;
	
	public PassengerController(){
		this.passengerService = new PassengerService();
	}
	
	public DefaultTableModel read(){
		passengers = passengerService.readAll();
		Object[] columns = new Object[]{"ID","Pasajero","Teléfono","Móvil","e-mail"};
		DefaultTableModel model = new DefaultTableModel(null, columns);
		if(!passengers.isEmpty()){
			for(Passenger passenger :passengers){
				model.addRow(new Object[]{
					passenger.getPassengerId(),
					passenger.getPassengerFullname(),
					passenger.getPassengerPhone1(),
					passenger.getPassengerMobile1(),
					passenger.getPassengerEmail()
				});
			}
		}
		return model;
	}
	
	public DefaultTableModel read(String name){
		passengers = passengerService.readByName(name);
		Object[] columns = new Object[]{"ID","Pasajero","Teléfono","Móvil","e-mail"};
		DefaultTableModel model = new DefaultTableModel(null, columns);
		if(!passengers.isEmpty()){
			for(Passenger passenger :passengers){
				model.addRow(new Object[]{
					passenger.getPassengerId(),
					passenger.getPassengerFullname(),
					passenger.getPassengerPhone1(),
					passenger.getPassengerMobile1(),
					passenger.getPassengerEmail()
				});
			}
		}
		return model;
	}
	
	public Integer create(String passengerFullname, Date passengerBirthdate,
			String passengerAddress, String passengerCity, String passengerPhone1,
			String passengerPhone2, String passengerMobile1, String passengerMobile2,
			String passengerEmail){
		passenger = new Passenger(passengerFullname, passengerBirthdate, passengerAddress,
				passengerCity, passengerPhone1, passengerPhone2, passengerMobile1,
				passengerMobile2, passengerEmail);
		return passengerService.create(passenger);
	}
	
	public void create(Integer id){
		passenger = passengerService.readById(id);
	}
	
	public Object[] readPassenger(Integer id){
		passenger = passengerService.readById(id);
		Object[] item = new Object[]{
				passenger.getPassengerFullname(),
				passenger.getPassengerBirthdate(),
				passenger.getPassengerAddress(),
				passenger.getPassengerCity(),
				passenger.getPassengerPhone1(),
				passenger.getPassengerPhone2(),
				passenger.getPassengerMobile1(),
				passenger.getPassengerMobile2(),
				passenger.getPassengerEmail()
		};
		return item;
	}
	
	public void updatePassenger(String fullname, Date birthdate, String address, String city, String phone1,
			String phone2, String mobile1, String mobile2, String email, Integer id){
		passenger = passengerService.readById(id);
		passenger.setPassengerFullname(fullname);
		passenger.setPassengerBirthdate(birthdate);
		passenger.setPassengerAddress(address);
		passenger.setPassengerCity(city);
		passenger.setPassengerPhone1(phone1);
		passenger.setPassengerPhone2(phone2);
		passenger.setPassengerMobile1(mobile1);
		passenger.setPassengerMobile2(mobile2);
		passenger.setPassengerEmail(email);
		passengerService.update(passenger);
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public PassengerService getPassengerService() {
		return passengerService;
	}

	public void setPassengerService(PassengerService passengerService) {
		this.passengerService = passengerService;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}
	
	

}

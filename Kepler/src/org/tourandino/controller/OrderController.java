package org.tourandino.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.einstein.controller.LoginController;
import org.tourandino.model.BusPassenger;
import org.tourandino.model.FlightPassenger;
import org.tourandino.model.HotelPassenger;
import org.tourandino.model.InsurancePassenger;
import org.tourandino.model.Issuer;
import org.tourandino.model.Order;
import org.tourandino.model.PackagePassenger;
import org.tourandino.model.User;
import org.tourandino.service.OrderService;

public class OrderController {
	private OrderService orderService;
	private Order order;
	private List<Order> orders;
	private CustomerController customerController;
	private PassengerController passengerController;
	private LoginController loginController;
	private FlightPassengerController flightPassengerController;
	private BusPassengerController busPassengerController;
	private HotelPassengerController hotelPassengerController;
	private PackagePassengerController packagePassengerController;
	private InsurancePassengerController insurancePassengerController;
	private PaymentController paymentController;
	
	
	public OrderController(CustomerController customerController, PassengerController passengerController, 
			LoginController loginController, DailyCashRecordController dailyCashRecordController){
		this.orderService = new OrderService();
		this.customerController = customerController;
		this.passengerController = passengerController;
		this.loginController = loginController;
		this.paymentController = new PaymentController(dailyCashRecordController);
		this.flightPassengerController = new FlightPassengerController();
		this.busPassengerController = new BusPassengerController();
		this.hotelPassengerController = new HotelPassengerController();
		this.packagePassengerController = new PackagePassengerController();
		this.insurancePassengerController = new InsurancePassengerController();
	}
	
	public OrderController(){
		this.orderService = new OrderService();
	}
	
	public Object[] read(Integer id){
		order = orderService.readById(id);
		Object[] items = new Object[]{
				order.getOrderId(),                        //0
				order.getOrderDate(),                      //1
				order.getOrderTime(),                      //2
				order.getOrderCost(),                      //3 
				order.getOrderTotal(),                     //4
				order.getOrderProfit(),                    //5
				order.getCustomer().getCustomerFullname(), //6
				order.getIssuer().getIssuerName(),         //7
				order.getUser().getUserFullname(),         //8
				order.getOrderDescr()					   //9
		};
		return items;
	}
	
	public DefaultTableModel readUnique(){
		Object[] columns = new Object[]{"ID","Fecha", "Hora", "Vendedor", "Operador", "Costo"};
		DefaultTableModel model = new DefaultTableModel(null, columns);
		if(order != null){
			SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm");
			model.addRow(new Object[]{
	            		order.getOrderId(),
	            		sdfDate.format(order.getOrderDate()),
	            		sdfTime.format(order.getOrderTime()),
	            		order.getUser().getUserFullname(),
	            		order.getIssuer().getIssuerName(),
	            		order.getOrderCost()
	            		
	            });
		}
		return model;
	}
	
	public DefaultTableModel read(){
		orders = orderService.readAll();
		Object[] columns = new Object[]{"ID","Fecha", "Hora", "Cliente", "Operador", "Total", "Costo", "Beneficio", "Tipo", "Vendedor"};
		DefaultTableModel model = new DefaultTableModel(null, columns);
		if(!orders.isEmpty()){
			SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm");
			for (Order order :orders)
	            model.addRow(new Object[]{
	            		order.getOrderId(),
	            		sdfDate.format(order.getOrderDate()),
	            		sdfTime.format(order.getOrderTime()),
	            		order.getCustomer().getCustomerFullname(),
	            		order.getIssuer().getIssuerName(),
	            		order.getOrderTotal(),
	            		order.getOrderCost(),
	            		order.getOrderProfit(),
	            		order.getOrderDescr(),
	            		order.getUser().getUserFullname()
	            });
		}
		return model;
	}
	
	public DefaultTableModel read(Date date){
		orders = orderService.read(date);
		Object[] columns = new Object[]{"ID","Fecha", "Hora", "Cliente", "Operador", "Total", "Costo", "Beneficio", "Tipo", "Vendedor"};
		DefaultTableModel model = new DefaultTableModel(null, columns);
		if(!orders.isEmpty()){
			SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm");
			for (Order order :orders)
					model.addRow(new Object[]{
							order.getOrderId(),
							sdfDate.format(order.getOrderDate()),
							sdfTime.format(order.getOrderTime()),
							order.getCustomer().getCustomerFullname(),
							order.getIssuer().getIssuerName(),
							order.getOrderTotal(),
							order.getOrderCost(),
							order.getOrderProfit(),
							order.getOrderDescr(),
							order.getUser().getUserFullname()
					});
		}
		return model;
	}
	
	
	public DefaultTableModel readByCustomer(String customer){
		orders = orderService.readByCustomer(customer);
		Object[] columns = new Object[]{"ID","Fecha", "Hora", "Cliente", "Operador", "Total", "Costo", "Beneficio", "Tipo", "Vendedor"};
		DefaultTableModel model = new DefaultTableModel(null, columns);
		if(!orders.isEmpty()){
			SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm");
			for (Order order :orders)
					model.addRow(new Object[]{
							order.getOrderId(),
							sdfDate.format(order.getOrderDate()),
							sdfTime.format(order.getOrderTime()),
							order.getCustomer().getCustomerFullname(),
							order.getIssuer().getIssuerName(),
							order.getOrderTotal(),
							order.getOrderCost(),
							order.getOrderProfit(),
							order.getOrderDescr(),
							order.getUser().getUserFullname()
					});
		}
		return model;
	}
	
	public DefaultTableModel readByIssuer(String search){
		orders = orderService.readByIssuer(search);
		Object[] columns = new Object[]{"ID","Fecha", "Hora", "Cliente", "Operador", "Total", "Costo", "Beneficio", "Tipo", "Vendedor"};
		DefaultTableModel model = new DefaultTableModel(null, columns);
		if(!orders.isEmpty()){
			SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm");
			for (Order order :orders)
					model.addRow(new Object[]{
							order.getOrderId(),
							sdfDate.format(order.getOrderDate()),
							sdfTime.format(order.getOrderTime()),
							order.getCustomer().getCustomerFullname(),
							order.getIssuer().getIssuerName(),
							order.getOrderTotal(),
							order.getOrderCost(),
							order.getOrderProfit(),
							order.getOrderDescr(),
							order.getUser().getUserFullname()
					});
		}
		return model;
	}
	
	public DefaultTableModel readByUser(String search){
		orders = orderService.readByUser(search);
		Object[] columns = new Object[]{"ID","Fecha", "Hora", "Cliente", "Operador", "Total", "Costo", "Beneficio", "Tipo", "Vendedor"};
		DefaultTableModel model = new DefaultTableModel(null, columns);
		if(!orders.isEmpty()){
			SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm");
			for (Order order :orders)
					model.addRow(new Object[]{
							order.getOrderId(),
							sdfDate.format(order.getOrderDate()),
							sdfTime.format(order.getOrderTime()),
							order.getCustomer().getCustomerFullname(),
							order.getIssuer().getIssuerName(),
							order.getOrderTotal(),
							order.getOrderCost(),
							order.getOrderProfit(),
							order.getOrderDescr(),
							order.getUser().getUserFullname()
					});
		}
		return model;
	}
	
	public DefaultTableModel readByType(String type){
		orders = orderService.readByType(type);
		Object[] columns = new Object[]{"ID","Fecha", "Hora", "Cliente", "Operador", "Total", "Costo", "Beneficio", "Tipo", "Vendedor"};
		DefaultTableModel model = new DefaultTableModel(null, columns);
		if(!orders.isEmpty()){
			SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm");
			for (Order order :orders)
	            model.addRow(new Object[]{
	            		order.getOrderId(),
	            		sdfDate.format(order.getOrderDate()),
	            		sdfTime.format(order.getOrderTime()),
	            		order.getCustomer().getCustomerFullname(),
	            		order.getIssuer().getIssuerName(),
	            		order.getOrderTotal(),
	            		order.getOrderCost(),
	            		order.getOrderProfit(),
	            		order.getOrderDescr(),
	            		order.getUser().getUserFullname()
	            });
		}
		return model;
	}
	
	public DefaultTableModel read(Date dateFrom, Date dateTo){
		orders = orderService.read(dateFrom, dateTo);
		Object[] columns = new Object[]{"ID","Fecha", "Hora", "Cliente", "Operador", "Total", "Costo", "Beneficio", "Tipo", "Vendedor"};
		DefaultTableModel model = new DefaultTableModel(null, columns);
		if(!orders.isEmpty()){
			SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm");
			for (Order order :orders)
	            model.addRow(new Object[]{
	            		order.getOrderId(),
	            		sdfDate.format(order.getOrderDate()),
	            		sdfTime.format(order.getOrderTime()),
	            		order.getCustomer().getCustomerFullname(),
	            		order.getIssuer().getIssuerName(),
	            		order.getOrderTotal(),
	            		order.getOrderCost(),
	            		order.getOrderProfit(),
	            		order.getOrderDescr(),
	            		order.getUser().getUserFullname()
	            });
		}
		return model;
	}
	
	public DefaultTableModel readByCustomer(String customer, Date dateFrom, Date dateTo){
		orders = orderService.readByCustomer(customer, dateFrom, dateTo);
		Object[] columns = new Object[]{"ID","Fecha", "Hora", "Cliente", "Operador", "Total", "Costo", "Beneficio", "Tipo", "Vendedor"};
		DefaultTableModel model = new DefaultTableModel(null, columns);
		if(!orders.isEmpty()){
			SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm");
			for (Order order :orders)
					model.addRow(new Object[]{
							order.getOrderId(),
							sdfDate.format(order.getOrderDate()),
							sdfTime.format(order.getOrderTime()),
							order.getCustomer().getCustomerFullname(),
							order.getIssuer().getIssuerName(),
							order.getOrderTotal(),
							order.getOrderCost(),
							order.getOrderProfit(),
							order.getOrderDescr(),
							order.getUser().getUserFullname()
					});
		}
		return model;
	}
	
	public DefaultTableModel readByIssuer(String search, Date dateFrom, Date dateTo){
		orders = orderService.readByIssuer(search, dateFrom, dateTo);
		Object[] columns = new Object[]{"ID","Fecha", "Hora", "Cliente", "Operador", "Total", "Costo", "Beneficio", "Tipo", "Vendedor"};
		DefaultTableModel model = new DefaultTableModel(null, columns);
		if(!orders.isEmpty()){
			SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm");
			for (Order order :orders)
					model.addRow(new Object[]{
							order.getOrderId(),
							sdfDate.format(order.getOrderDate()),
							sdfTime.format(order.getOrderTime()),
							order.getCustomer().getCustomerFullname(),
							order.getIssuer().getIssuerName(),
							order.getOrderTotal(),
							order.getOrderCost(),
							order.getOrderProfit(),
							order.getOrderDescr(),
							order.getUser().getUserFullname()
					});
		}
		return model;
	}
	
	public DefaultTableModel readByUser(String search, Date dateFrom, Date dateTo){
		orders = orderService.readByUser(search, dateFrom, dateTo);
		Object[] columns = new Object[]{"ID","Fecha", "Hora", "Cliente", "Operador", "Total", "Costo", "Beneficio", "Tipo", "Vendedor"};
		DefaultTableModel model = new DefaultTableModel(null, columns);
		if(!orders.isEmpty()){
			SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm");
			for (Order order :orders)
					model.addRow(new Object[]{
							order.getOrderId(),
							sdfDate.format(order.getOrderDate()),
							sdfTime.format(order.getOrderTime()),
							order.getCustomer().getCustomerFullname(),
							order.getIssuer().getIssuerName(),
							order.getOrderTotal(),
							order.getOrderCost(),
							order.getOrderProfit(),
							order.getOrderDescr(),
							order.getUser().getUserFullname()
					});
		}
		return model;
	}
	
	public DefaultTableModel readByType(String type, Date dateFrom, Date dateTo){
		orders = orderService.readByType(type, dateFrom, dateTo);
		Object[] columns = new Object[]{"ID","Fecha", "Hora", "Cliente", "Operador", "Total", "Costo", "Beneficio", "Tipo", "Vendedor"};
		DefaultTableModel model = new DefaultTableModel(null, columns);
		if(!orders.isEmpty()){
			SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm");
			for (Order order :orders)
	            model.addRow(new Object[]{
	            		order.getOrderId(),
	            		sdfDate.format(order.getOrderDate()),
	            		sdfTime.format(order.getOrderTime()),
	            		order.getCustomer().getCustomerFullname(),
	            		order.getIssuer().getIssuerName(),
	            		order.getOrderTotal(),
	            		order.getOrderCost(),
	            		order.getOrderProfit(),
	            		order.getOrderDescr(),
	            		order.getUser().getUserFullname()
	            });
		}
		return model;
	}
	
	public void initializeFlightOrder(User user, String descr){
		order = new Order(user, 0, 0, 0, 0, 0, 0, 0, descr);
		flightPassengerController.initializeFlightPassenger();
		paymentController.initializePayment();
	}
	
	public void initializeBusOrder(User user, String descr){
		order = new Order(user, 0, 0, 0, 0, 0, 0, 0, descr);
		busPassengerController.initializeBusPassenger();
		paymentController.initializePayment();
	}
	
	public void initializeHotelOrder(User user, String descr){
		order = new Order(user, 0, 0, 0, 0, 0, 0, 0, descr);
		hotelPassengerController.initializeHotelPassenger();
		paymentController.initializePayment();
	}
	
	public void initializePackageOrder(User user, String descr){
		order = new Order(user, 0, 0, 0, 0, 0, 0, 0, descr);
		packagePassengerController.initializePackagePassenger();
		paymentController.initializePayment();
	}
	
	public void initializeInsuranceOrder(User user, String descr){
		order = new Order(user, 0, 0, 0, 0, 0, 0, 0, descr);
		insurancePassengerController.initializeInsurancePassenger();
		paymentController.initializePayment();
	}
	
	public Integer createFlight(Object issuer){
		Integer i = 0;
		if(customerController.getCustomer() != null){
			order.setCustomer(customerController.getCustomer());
			order.setIssuer((Issuer)issuer);
			order.setOrderDate(new Date());
			order.setOrderTime(new Date());
			i = orderService.create(order); 
			if(i > 0){
				flightPassengerController.create();
				paymentController.create();
			}
		}
		return i;
	}
	
	public void create(Integer id){
		order = orderService.readById(id);
	}
	
	public void delete(Integer entityId){
		orderService.delete(entityId);
	}
	
	public Integer createBus(Object issuer){
		Integer i = 0;
		if(customerController.getCustomer() != null){
			order.setCustomer(customerController.getCustomer());
			order.setIssuer((Issuer)issuer);
			order.setOrderDate(new Date());
			order.setOrderTime(new Date());
			i = orderService.create(order); 
			if(i > 0){
				busPassengerController.create();
				paymentController.create();
			}
		}
		return i;
	}
	
	public Integer createHotel(Object issuer){
		Integer i = 0;
		if(customerController.getCustomer() != null){
			order.setCustomer(customerController.getCustomer());
			order.setIssuer((Issuer)issuer);
			order.setOrderDate(new Date());
			order.setOrderTime(new Date());
			i = orderService.create(order); 
			if(i > 0){
				hotelPassengerController.create();
				paymentController.create();
			}
		}
		return i;
	}
	
	public Integer createPackage(Object issuer){
		Integer i = 0;
		if(customerController.getCustomer() != null){
			order.setCustomer(customerController.getCustomer());
			order.setIssuer((Issuer)issuer);
			order.setOrderDate(new Date());
			order.setOrderTime(new Date());
			i = orderService.create(order); 
			if(i > 0){
				packagePassengerController.create();
				paymentController.create();
			}
		}
		return i;
	}
	
	public Integer createInsurance(Object issuer){
		Integer i = 0;
		if(customerController.getCustomer() != null){
			order.setCustomer(customerController.getCustomer());
			order.setIssuer((Issuer)issuer);
			order.setOrderDate(new Date());
			order.setOrderTime(new Date());
			i = orderService.create(order); 
			if(i > 0){
				insurancePassengerController.create();
				paymentController.create();
			}
		}
		return i;
	}
	
	public float getTotalCash(){
		return paymentController.getPaymentTotal("EFECTIVO");
	}
	
	public float getTotalAccount(){
		return paymentController.getPaymentTotal("CUENTA CORRIENTE");
	}
	
	public float getTotalDebit(){
		return paymentController.getPaymentTotal("TARJETA DE DEBITO");
	}
	
	public float getTotalCredit(){
		return paymentController.getPaymentTotal("TARJETA DE CREDITO");
	}
	
	public float getTotalCheque(){
		return paymentController.getPaymentTotal("CHEQUE");
	}	
	
	public void addPayment(float total, String notes, Object method){
		paymentController.add(order, 0, 0, total, notes, method);
	}
	
	public boolean removePayment(){
		return paymentController.remove();
	}
	
	public boolean paidInFull(){
		float total = getTotalCash() + getTotalAccount() + getTotalDebit() + getTotalCredit() + getTotalCheque();
		return (total == order.getOrderTotal() ? true:false);
	}
	
	public void addFlightItinerary(float price, float cost, String itinerary, String flightName){
		order.setOrderTotal(order.getOrderTotal()+price);
		order.setOrderSubtotal(order.getOrderSubtotal()+price);
		order.setOrderCost(order.getOrderCost()+cost);
		order.setOrderProfit(order.getOrderTotal()-order.getOrderCost());
		flightPassengerController.add(passengerController.getPassenger(), flightName, this.order, price, cost, itinerary);
	}
	
	public void addBusItinerary(float price, float cost, String itinerary, String busName){
		order.setOrderTotal(order.getOrderTotal()+price);
		order.setOrderSubtotal(order.getOrderSubtotal()+price);
		order.setOrderCost(order.getOrderCost()+cost);
		order.setOrderProfit(order.getOrderTotal()-order.getOrderCost());
		busPassengerController.add(passengerController.getPassenger(), busName, this.order, price, cost, itinerary);
	}
	
	public void addHotelItinerary(float price, float cost, String hotelName, String hotelAddressCity, Date checkIn, Date checkOut,
			String hotelRoom){
		order.setOrderTotal(order.getOrderTotal()+price);
		order.setOrderSubtotal(order.getOrderSubtotal()+price);
		order.setOrderCost(order.getOrderCost()+cost);
		order.setOrderProfit(order.getOrderTotal()-order.getOrderCost());
		hotelPassengerController.add(passengerController.getPassenger(), this.order, hotelName, hotelAddressCity, checkIn, checkOut, hotelRoom, price, cost);
	}
	
	public void addPackageItinerary(String itinerary, String packageName, String packageNote, float price, float cost){
		order.setOrderTotal(order.getOrderTotal()+price);
		order.setOrderSubtotal(order.getOrderSubtotal()+price);
		order.setOrderCost(order.getOrderCost()+cost);
		order.setOrderProfit(order.getOrderTotal()-order.getOrderCost());
		packagePassengerController.add(passengerController.getPassenger(), this.order, itinerary, packageName, packageNote, price, cost);
	}
	
	public void addInsuranceItinerary(String insuranceName, String insuranceType, String insuranceNote, float price, float cost){
		order.setOrderTotal(order.getOrderTotal()+price);
		order.setOrderSubtotal(order.getOrderSubtotal()+price);
		order.setOrderCost(order.getOrderCost()+cost);
		order.setOrderProfit(order.getOrderTotal()-order.getOrderCost());
		insurancePassengerController.add(passengerController.getPassenger(), this.order,insuranceName, insuranceType, insuranceNote, price, cost);
	}
	
	public void removeFlightItinerary(int index){
		flightPassengerController.remove(order, index);
	}
	
	public void removeBusItinerary(int index){
		busPassengerController.remove(order, index);
	}
	
	public void removeHotelItinerary(int index){
		hotelPassengerController.remove(order, index);
	}
	
	public void removePackageItinerary(int index){
		packagePassengerController.remove(order, index);
	}
	
	public void removeInsuranceItinerary(int index){
		insurancePassengerController.remove(order, index);
	}
	
	public DefaultTableModel readFlightPassengers(){
		Object[] columns = new Object[]{"ID","Pasajero", "Tramo", "Empresa", "Precio", "Costo"};
		DefaultTableModel model = new DefaultTableModel(null, columns);
		if(!flightPassengerController.getFlightPassengers().isEmpty()){
			for (FlightPassenger flightPassenger: flightPassengerController.getFlightPassengers())
	            model.addRow(new Object[]{
	            		flightPassengerController.getFlightPassengers().indexOf(flightPassenger),
	            		flightPassenger.getPassenger().getPassengerFullname(),
	            		flightPassenger.getItinerary(),
	            		flightPassenger.getFlightName(),
	            		flightPassenger.getFlightPrice(),
	            		flightPassenger.getFlightCost()
	            });
		}
		return model;
	}
	
	public DefaultTableModel readBusPassengers(){
		Object[] columns = new Object[]{"ID","Pasajero", "Tramo", "Empresa", "Precio", "Costo"};
		DefaultTableModel model = new DefaultTableModel(null, columns);
		if(!busPassengerController.getBusPassengers().isEmpty()){
			for (BusPassenger busPassenger: busPassengerController.getBusPassengers())
	            model.addRow(new Object[]{
	            		busPassengerController.getBusPassengers().indexOf(busPassenger),
	            		busPassenger.getPassenger().getPassengerFullname(),
	            		busPassenger.getItinerary(),
	            		busPassenger.getBusName(),
	            		busPassenger.getBusPrice(),
	            		busPassenger.getBusCost()
	            });
		}
		return model;
	}
	
	public DefaultTableModel readHotelPassengers(){
		Object[] columns = new Object[]{"ID","Pasajero", "Hotel", "Domicilio", "Check-in", "Check-out", "Habitaciones", "Precio", "Costo"};
		DefaultTableModel model = new DefaultTableModel(null, columns);
		if(!hotelPassengerController.getHotelPassengers().isEmpty()){
			for (HotelPassenger hotelPassenger: hotelPassengerController.getHotelPassengers())
	            model.addRow(new Object[]{
	            		hotelPassengerController.getHotelPassengers().indexOf(hotelPassenger),
	            		hotelPassenger.getPassenger().getPassengerFullname(),
	            		hotelPassenger.getHotelName(),
	            		hotelPassenger.getHotelAddressCity(),
	            		hotelPassenger.getCheckInDate(),
	            		hotelPassenger.getCheckOutDate(),
	            		hotelPassenger.getHotelRooms(),
	            		hotelPassenger.getHotelPrice(),
	            		hotelPassenger.getHotelCost()
	            });
		}
		return model;
	}
	
	public DefaultTableModel readPackagePassengers(){
		Object[] columns = new Object[]{"ID","Pasajero", "Paquete", "Itinerario", "Descripción", "Precio", "Costo"};
		DefaultTableModel model = new DefaultTableModel(null, columns);
		if(!packagePassengerController.getPackagePassengers().isEmpty()){
			for (PackagePassenger packagePassenger: packagePassengerController.getPackagePassengers())
	            model.addRow(new Object[]{
	            		packagePassengerController.getPackagePassengers().indexOf(packagePassenger),
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
	
	public DefaultTableModel readInsurancePassengers(){
		Object[] columns = new Object[]{"ID","Pasajero", "Seguro", "Tipo", "Descripción", "Precio", "Costo"};
		DefaultTableModel model = new DefaultTableModel(null, columns);
		if(!insurancePassengerController.getInsurancePassengers().isEmpty()){
			for (InsurancePassenger insurancePassenger: insurancePassengerController.getInsurancePassengers())
	            model.addRow(new Object[]{
	            		insurancePassengerController.getInsurancePassengers().indexOf(insurancePassenger),
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

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public CustomerController getCustomerController() {
		return customerController;
	}

	public void setCustomerController(CustomerController customerController) {
		this.customerController = customerController;
	}

	public PassengerController getPassengerController() {
		return passengerController;
	}

	public void setPassengerController(PassengerController passengerController) {
		this.passengerController = passengerController;
	}

	public LoginController getLoginController() {
		return loginController;
	}

	public void setLoginController(LoginController loginController) {
		this.loginController = loginController;
	}

	public FlightPassengerController getFlightPassengerController() {
		return flightPassengerController;
	}

	public void setFlightPassengerController(
			FlightPassengerController flightPassengerController) {
		this.flightPassengerController = flightPassengerController;
	}

	public PaymentController getPaymentController() {
		return paymentController;
	}

	public void setPaymentController(PaymentController paymentController) {
		this.paymentController = paymentController;
	}

}

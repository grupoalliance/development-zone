package org.tourandino.controller;

import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

import org.tourandino.model.Customer;
import org.tourandino.model.TaxCondition;
import org.tourandino.service.CustomerService;

public class CustomerController {

	private CustomerService customerService;
	private Customer customer;
	private List<Customer> customers;
	private CustomerAccountController customerAccountController;
	
	public CustomerController(){
		customerService = new CustomerService();
		customerAccountController = new CustomerAccountController();
	}
	
	public DefaultTableModel read(){
		customers = customerService.readAll();
		Object[] columns = new Object[]{"ID","Cliente","CUIT","Condición IVA", "Domicilio"};
		DefaultTableModel model = new DefaultTableModel(null, columns);
		if(!customers.isEmpty()){
			for (Customer customer: customers)
	            model.addRow(new Object[]{
	            		customer.getCustomerId(),
	            		customer.getCustomerFullname(),
	            		customer.getCustomerCuit(),
	            		customer.getTaxCondition().getTaxConditionName(),
	            		customer.getCustomerAddress()
	            });
		}
		return model;
	}
	
	public DefaultTableModel readByName(String search){
		customers = customerService.readByName(search);
		Object[] columns = new Object[]{"ID","Cliente","CUIT","Condición IVA", "Domicilio"};
		DefaultTableModel model = new DefaultTableModel(null, columns);
		if(!customers.isEmpty()){
			for (Customer customer: customers)
	            model.addRow(new Object[]{
	            		customer.getCustomerId(),
	            		customer.getCustomerFullname(),
	            		customer.getCustomerCuit(),
	            		customer.getTaxCondition().getTaxConditionName(),
	            		customer.getCustomerAddress()
	            });
		}
		return model;
	}
	
	public DefaultTableModel readByCuit(String search){
		customers = customerService.readByCuit(search);
		Object[] columns = new Object[]{"ID","Cliente","CUIT","Condición IVA", "Domicilio"};
		DefaultTableModel model = new DefaultTableModel(null, columns);
		if(!customers.isEmpty()){
			for (Customer customer: customers)
	            model.addRow(new Object[]{
	            		customer.getCustomerId(),
	            		customer.getCustomerFullname(),
	            		customer.getCustomerCuit(),
	            		customer.getTaxCondition().getTaxConditionName(),
	            		customer.getCustomerAddress()
	            });
		}
		return model;
	}
	
	public Integer create(Object taxCondition, String fullname, String cuit, 
			float creditLimit, Date birthdate, String address, String city, String phone, 
			String mobile, String email){
		customer = new Customer((TaxCondition)taxCondition, fullname, cuit, 
				creditLimit, birthdate, address, city, phone, mobile, email);
		 return customerAccountController.createCustomerAccount(customerService.create(customer));
		
	}
	
	public void create(Integer id){
		customer = customerService.readById(id);
	}
	
	public void updateCustomer(Object taxCondition, Integer id, String name, String cuit, 
			float creditLimit, Date birthdate, String address, String city, String phone, 
			String mobile, String email){
		customer = customerService.readById(id);
		customer.setTaxCondition((TaxCondition) taxCondition);
		customer.setCustomerFullname(name);
		customer.setCustomerCuit(cuit);
		customer.setCustomerCreditLimit(creditLimit);
		customer.setCustomerBirthdate(birthdate);
		customer.setCustomerAddress(address);
		customer.setCustomerCity(city);
		customer.setCustomerPhone(phone);
		customer.setCustomerMobile(mobile);
		customer.setCustomerEmail(email);
		customerService.update(customer);
	}
	
	public Object[] readCustomer(Integer id){
		customer = customerService.readById(id);
		Object[] items = new Object[]{
				customer.getTaxCondition().getTaxConditionName(),
				customer.getCustomerFullname(),
				customer.getCustomerCuit(),
				customer.getCustomerCreditLimit(),
				customer.getCustomerBirthdate(),
				customer.getCustomerAddress(),
				customer.getCustomerCity(),
				customer.getCustomerPhone(),
				customer.getCustomerMobile(),
				customer.getCustomerEmail()
		};
		return items;
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
	
}

package org.tourandino.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.tourandino.model.Customer;
import org.tourandino.model.CustomerAccount;
import org.tourandino.service.CustomerAccountService;
import org.tourandino.service.CustomerService;

public class CustomerAccountController {
	private CustomerAccountService customerAccountService;
	private CustomerAccount customerAccount;
	private List<CustomerAccount> customerAccounts;
	
	public CustomerAccountController(){
		this.customerAccountService = new CustomerAccountService();
	}
	
	public boolean checkCustomerAccount(Integer id){
		boolean response = true;
		customerAccounts = customerAccountService.readAll();
		if(!customerAccounts.isEmpty()){
			for(CustomerAccount customerAccount: customerAccounts){
				if(customerAccount.getCustomer().getCustomerId() == id)
					response = false;
			}
		}
		return response;
	}
	
	public Integer createCustomerAccount(Integer id){
		CustomerService customerService = new CustomerService();
		customerAccount = new CustomerAccount(customerService.readById(id), 0, customerService.readById(id).getCustomerCreditLimit(), new Date());
		return customerAccountService.create(customerAccount);
	}
	
	public Object[] read(Integer id){
		customerAccount = customerAccountService.readById(id);
		return new Object[]{
				customerAccount.getCustomerAccountId(),
				customerAccount.getCustomerAccountName(),
				customerAccount.getCustomerAccountBalance()
		};
	}
	
	public DefaultTableModel read(boolean active){
		customerAccounts = customerAccountService.readAll();
		Object[] columns = new Object[]{"ID","Fecha Creación","Cliente","Saldo"};
		DefaultTableModel model = new DefaultTableModel(null, columns);
		if(!customerAccounts.isEmpty()){
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
			for (CustomerAccount customerAccount: customerAccounts)
				if(active){
					if(customerAccount.getCustomerAccountBalance()>0){
						model.addRow(new Object[]{
							customerAccount.getCustomerAccountId(),
							sdf.format(customerAccount.getCustomerAccountCreationDatetime()),
							customerAccount.getCustomer().getCustomerFullname(),
							customerAccount.getCustomerAccountBalance()
					});
					}
				}
				else{
					model.addRow(new Object[]{
							customerAccount.getCustomerAccountId(),
							sdf.format(customerAccount.getCustomerAccountCreationDatetime()),
							customerAccount.getCustomer().getCustomerFullname(),
							customerAccount.getCustomerAccountBalance()
					});
				}
		}
		return model;
	}
	
	public DefaultTableModel read(String search, boolean active){
		customerAccounts = customerAccountService.readByCustomer(search);
		Object[] columns = new Object[]{"ID","Fecha Creación","Cliente","Saldo"};
		DefaultTableModel model = new DefaultTableModel(null, columns);
		if(!customerAccounts.isEmpty()){
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
			for (CustomerAccount customerAccount: customerAccounts)
				if(active){
					if(customerAccount.getCustomerAccountBalance()>0){
					model.addRow(new Object[]{
							customerAccount.getCustomerAccountId(),
							sdf.format(customerAccount.getCustomerAccountCreationDatetime()),
							customerAccount.getCustomer().getCustomerFullname(),
							customerAccount.getCustomerAccountBalance()
					});
					}
				}
				else{
					model.addRow(new Object[]{
							customerAccount.getCustomerAccountId(),
							sdf.format(customerAccount.getCustomerAccountCreationDatetime()),
							customerAccount.getCustomer().getCustomerFullname(),
							customerAccount.getCustomerAccountBalance()
					});
				}
		}
		return model;
	}
	
	public CustomerAccount getByCustomer(Integer id){
		 return customerAccountService.readById(id);
	}
	
	public CustomerAccount getById(Integer id){
		return customerAccountService.readById(id);
	}
	
	public void update(CustomerAccount customerAccount){
		customerAccountService.update(customerAccount);
	}
	
	public void increaseBalance(Customer customer, float payment){
		customerAccount = customerAccountService.readByCustomer(customer);
		customerAccount.setCustomerAccountBalance(customerAccount.getCustomerAccountBalance() + payment);
		customerAccountService.update(customerAccount);
	}
	
	public void decreaseBalance(Customer customer, float payment){
		customerAccount = customerAccountService.readByCustomer(customer);
		customerAccount.setCustomerAccountBalance(customerAccount.getCustomerAccountBalance() - payment);
		customerAccountService.update(customerAccount);
	}

	public CustomerAccountService getCustomerAccountService() {
		return customerAccountService;
	}

	public void setCustomerAccountService(
			CustomerAccountService customerAccountService) {
		this.customerAccountService = customerAccountService;
	}

	public CustomerAccount getCustomerAccount() {
		return customerAccount;
	}

	public void setCustomerAccount(CustomerAccount customerAccount) {
		this.customerAccount = customerAccount;
	}

	public List<CustomerAccount> getCustomerAccounts() {
		return customerAccounts;
	}

	public void setCustomerAccounts(List<CustomerAccount> customerAccounts) {
		this.customerAccounts = customerAccounts;
	}
	
	

}

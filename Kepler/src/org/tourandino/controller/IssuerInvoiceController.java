package org.tourandino.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.tourandino.model.IssuerInvoice;
import org.tourandino.model.Order;
import org.tourandino.service.IssuerInvoiceService;

public class IssuerInvoiceController {
	private IssuerInvoice issuerInvoice;
	private List<IssuerInvoice> issuerInvoices;
	private IssuerInvoiceService issuerInvoiceService;
	
	public IssuerInvoiceController(){
		this.issuerInvoiceService = new IssuerInvoiceService();
	}
	
	public IssuerInvoice getById(Integer id){
		return issuerInvoiceService.readById(id);
	}
	
	public Object[] read(Integer id){
		issuerInvoice = issuerInvoiceService.readById(id);
		Object[] items = new Object[]{
				issuerInvoice.getIssuerInvoiceId(),
				issuerInvoice.getIssuerInvoiceNumber(),
				issuerInvoice.getIssuerInvoiceDate(),
				issuerInvoice.getIssuerInvoiceTotal()
		};
		return items;
	}
	
	public DefaultTableModel read(){
		issuerInvoices = issuerInvoiceService.readAll();
		Object[] columns = new Object[]{"ID","Fecha", "Hora", "Operador", "Costo", "No. Factura", "Fecha Facturación", "Monto factura", "Estado"};
		DefaultTableModel model = new DefaultTableModel(null, columns);
		if(!issuerInvoices.isEmpty()){
			SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm");
			for (IssuerInvoice issuerInvoice :issuerInvoices)
	            model.addRow(new Object[]{
	            		issuerInvoice.getIssuerInvoiceId(),
	            		sdfDate.format(issuerInvoice.getOrder().getOrderDate()),
	            		sdfTime.format(issuerInvoice.getOrder().getOrderTime()),
	            		issuerInvoice.getOrder().getIssuer().getIssuerName(),
	            		issuerInvoice.getOrder().getOrderCost(),
	            		issuerInvoice.getIssuerInvoiceNumber(),
	            		sdfDate.format(issuerInvoice.getIssuerInvoiceDate()),
	            		issuerInvoice.getIssuerInvoiceTotal(),
	            		issuerInvoice.getIssuerInvoiceStatus()
	            });
		}
		return model;
	}
	
	public DefaultTableModel read(Date date){
		issuerInvoices = issuerInvoiceService.readByDate(date);
		Object[] columns = new Object[]{"ID","Fecha", "Hora", "Operador", "Costo", "No. Factura", "Fecha Facturación", "Monto factura", "Estado"};
		DefaultTableModel model = new DefaultTableModel(null, columns);
		if(!issuerInvoices.isEmpty()){
			SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm");
			for (IssuerInvoice issuerInvoice :issuerInvoices)
	            model.addRow(new Object[]{
	            		issuerInvoice.getIssuerInvoiceId(),
	            		sdfDate.format(issuerInvoice.getOrder().getOrderDate()),
	            		sdfTime.format(issuerInvoice.getOrder().getOrderTime()),
	            		issuerInvoice.getOrder().getIssuer().getIssuerName(),
	            		issuerInvoice.getOrder().getOrderCost(),
	            		issuerInvoice.getIssuerInvoiceNumber(),
	            		sdfDate.format(issuerInvoice.getIssuerInvoiceDate()),
	            		issuerInvoice.getIssuerInvoiceTotal(),
	            		issuerInvoice.getIssuerInvoiceStatus()
	            });
		}
		return model;
	}
	
	public DefaultTableModel readByIssuer(String issuer){
		issuerInvoices = issuerInvoiceService.readByIssuer(issuer);
		Object[] columns = new Object[]{"ID","Fecha", "Hora", "Operador", "Costo", "No. Factura", "Fecha Facturación", "Monto factura", "Estado"};
		DefaultTableModel model = new DefaultTableModel(null, columns);
		if(!issuerInvoices.isEmpty()){
			SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm");
			for (IssuerInvoice issuerInvoice :issuerInvoices)
				
					model.addRow(new Object[]{
							issuerInvoice.getIssuerInvoiceId(),
		            		sdfDate.format(issuerInvoice.getOrder().getOrderDate()),
		            		sdfTime.format(issuerInvoice.getOrder().getOrderTime()),
		            		issuerInvoice.getOrder().getIssuer().getIssuerName(),
		            		issuerInvoice.getOrder().getOrderCost(),
		            		issuerInvoice.getIssuerInvoiceNumber(),
		            		sdfDate.format(issuerInvoice.getIssuerInvoiceDate()),
		            		issuerInvoice.getIssuerInvoiceTotal(),
		            		issuerInvoice.getIssuerInvoiceStatus()
					});
				
		}
		return model;
	}
	
	public Integer create(Order order, String number, Date date, float tax, float rate, float total){
		issuerInvoice = new IssuerInvoice(order, number, date, tax, rate, total, "INGRESADO");
		return issuerInvoiceService.create(issuerInvoice);
	}
	
	public void update(String number, Date date, float tax, float rate, float total){
		issuerInvoice.setIssuerInvoiceNumber(number);
		issuerInvoice.setIssuerInvoiceDate(date);
		issuerInvoice.setIssuerInvoiceTotal(total);
		issuerInvoice.setIssuerInvoiceStatus("INGRESADO/EDITADO");
		issuerInvoiceService.update(issuerInvoice);
	}

	public IssuerInvoice getIssuerInvoice() {
		return issuerInvoice;
	}

	public void setIssuerInvoice(IssuerInvoice issuerInvoice) {
		this.issuerInvoice = issuerInvoice;
	}

	public List<IssuerInvoice> getIssuerInvoices() {
		return issuerInvoices;
	}

	public void setIssuerInvoices(List<IssuerInvoice> issuerInvoices) {
		this.issuerInvoices = issuerInvoices;
	}

	public IssuerInvoiceService getIssuerInvoiceService() {
		return issuerInvoiceService;
	}

	public void setIssuerInvoiceService(IssuerInvoiceService issuerInvoiceService) {
		this.issuerInvoiceService = issuerInvoiceService;
	}

}

package org.tourandino.controller;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import org.tourandino.model.Issuer;
import org.tourandino.model.TaxCondition;
import org.tourandino.service.IssuerService;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class IssuerController {
	private Issuer issuer;
	private IssuerService issuerService;
	private List<Issuer> issuers;
	
	public IssuerController(){
		this.issuerService = new IssuerService();
	}
	
	public DefaultComboBoxModel readIssuers(){
		issuers = issuerService.readAll();
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		if(issuers != null){
			for(Issuer issuer: issuers){
				model.addElement(issuer);
			}
		}
		return model;
	}
	
	public Integer createIssuer(Object taxCondition, String name, String cuit, float limit,
			String address, String city, String phone1, String phone2, String mobile, String email,
			String website){
		issuer = new Issuer((TaxCondition)taxCondition, name, cuit, limit, address, city,
				phone1, phone2, mobile, email, website);
		return issuerService.create(issuer);
	}
	
	public void update(Object taxCondition, String name, String cuit, float limit,
			String address, String city, String phone1, String phone2, String mobile, String email,
			String website){
		issuer.setTaxCondition((TaxCondition)taxCondition);
		issuer.setIssuerName(name);
		issuer.setIssuerCuit(cuit);
		issuer.setIssuerCreditLimit(limit);
		issuer.setIssuerAddress(address);
		issuer.setIssuerCity(city);
		issuer.setIssuerPhone1(phone1);
		issuer.setIssuerPhone2(phone2);
		issuer.setIssuerMobile(mobile);
		issuer.setIssuerEmail(email);
		issuer.setIssuerWebsite(website);
		issuerService.update(issuer);
	}
	
	public DefaultTableModel read(){
		issuers = issuerService.readAll();
		Object[] columns = new Object[]{"ID","Operador","CUIT","Condición IVA", "Domicilio"};
		DefaultTableModel model = new DefaultTableModel(null, columns);
		if(!issuers.isEmpty()){
			for (Issuer issuer :issuers)
	            model.addRow(new Object[]{
	            		issuer.getIssuerId(),
	            		issuer.getIssuerName(),
	            		issuer.getTaxCondition().getTaxConditionName(),
	            		issuer.getIssuerCuit(),
	            		issuer.getIssuerAddress()
	            });
		}
		return model;
	}
	
	public DefaultTableModel readByName(String search){
		issuers = issuerService.readByName(search);
		Object[] columns = new Object[]{"ID","Operador","CUIT","Condición IVA", "Domicilio"};
		DefaultTableModel model = new DefaultTableModel(null, columns);
		if(!issuers.isEmpty()){
			for (Issuer issuer :issuers)
	            model.addRow(new Object[]{
	            		issuer.getIssuerId(),
	            		issuer.getIssuerName(),
	            		issuer.getTaxCondition().getTaxConditionName(),
	            		issuer.getIssuerCuit(),
	            		issuer.getIssuerAddress()
	            });
		}
		return model;
	}
	
	public DefaultTableModel readByCuit(String search){
		issuers = issuerService.readByCuit(search);
		Object[] columns = new Object[]{"ID","Operador","CUIT","Condición IVA", "Domicilio"};
		DefaultTableModel model = new DefaultTableModel(null, columns);
		if(!issuers.isEmpty()){
			for (Issuer issuer :issuers)
	            model.addRow(new Object[]{
	            		issuer.getIssuerId(),
	            		issuer.getIssuerName(),
	            		issuer.getTaxCondition().getTaxConditionName(),
	            		issuer.getIssuerCuit(),
	            		issuer.getIssuerAddress()
	            });
		}
		return model;
	}
	
	public Object[] read(Integer id){
		issuer = issuerService.readById(id);
		Object[] items = new Object[]{
				issuer.getIssuerName(),
				issuer.getTaxCondition().getTaxConditionName(),
				issuer.getIssuerCuit(),
				issuer.getIssuerAddress(),
				issuer.getIssuerCity(),
				issuer.getIssuerPhone1(),
				issuer.getIssuerPhone2(),
				issuer.getIssuerMobile(),
				issuer.getIssuerEmail(),
				issuer.getIssuerWebsite(),
				issuer.getIssuerCreditLimit(),
		};
		return items;
	}

	public Issuer getIssuer() {
		return issuer;
	}

	public void setIssuer(Issuer issuer) {
		this.issuer = issuer;
	}

	public IssuerService getIssuerService() {
		return issuerService;
	}

	public void setIssuerService(IssuerService issuerService) {
		this.issuerService = issuerService;
	}

	public List<Issuer> getIssuers() {
		return issuers;
	}

	public void setIssuers(List<Issuer> issuers) {
		this.issuers = issuers;
	}
	
	

}

package org.tourandino.controller;

import java.util.List;
import javax.swing.DefaultComboBoxModel;

import org.tourandino.model.TaxCondition;
import org.tourandino.service.TaxConditionService;

@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
public class TaxConditionController {
	private TaxCondition taxCondition;
	private List<TaxCondition> taxConditions;
	private TaxConditionService taxConditionService = new TaxConditionService();
	
	public DefaultComboBoxModel loadRoles(){
		taxConditions = taxConditionService.readAll();
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		if(!taxConditions.isEmpty()){
			for(TaxCondition taxCondition: taxConditions){
				model.addElement(taxCondition);
			}
		}
		return model;
	}
	
	public DefaultComboBoxModel loadRoles(Object entity){
		taxConditions = taxConditionService.readAll();
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		if(!taxConditions.isEmpty()){
			for(TaxCondition taxCondition: taxConditions){
				model.addElement(taxCondition);
			}
			model.setSelectedItem(entity);
		}
		return model;
	}

}

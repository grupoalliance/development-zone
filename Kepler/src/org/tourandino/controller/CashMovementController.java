package org.tourandino.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.tourandino.model.CashMovement;
import org.tourandino.service.CashMovementService;

public class CashMovementController {
	private CashMovementService cashMovementService;
	private CashMovement cashMovement;
	private List<CashMovement> cashMovements;
	
	public CashMovementController(){
		this.cashMovementService = new CashMovementService();
	}
	
	public DefaultTableModel readByDailyCash(Integer dailyCashId){
		cashMovements = cashMovementService.readByDailyCash(dailyCashId);
		Object[] columns = new Object[]{"ID","Hora","Concepto","Ingreso","Egreso"};
		DefaultTableModel model = new DefaultTableModel(null, columns);
		if(!cashMovements.isEmpty()){
			for(CashMovement cashMovement :cashMovements){
					SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
					model.addRow(new Object[]{
						cashMovement.getCashMovementId(),
						sdf.format(cashMovement.getCashMovementTime()),
						cashMovement.getCashMovementDescr(),
						cashMovement.getCashMovementIncome(),
						cashMovement.getCashMovementOutcome()
					});
			}
		}
		return model;
	}
	
	public Integer create(float cashMovementIncome, float cashMovementOutcome, String cashMovementDescr){
		DailyCashRecordController dailyCashRecordController = new DailyCashRecordController();
		if(dailyCashRecordController.dailyRecordExist()){
			if(!dailyCashRecordController.DailyRecordIsClosed()){
				cashMovement = new CashMovement(dailyCashRecordController.readDailyCashRecord(), new Date(), new Date(), cashMovementIncome, cashMovementOutcome, cashMovementDescr);
				if(cashMovementIncome > cashMovementOutcome){
					dailyCashRecordController.increaseBalance(cashMovementIncome);
				}
				else
					dailyCashRecordController.decreaseBalance(cashMovementOutcome);
				return cashMovementService.create(cashMovement);
			}
			return 0;
		}
		return 0;
	}
	
	public DefaultTableModel read(){
		cashMovements = cashMovementService.readAll();
		Object[] columns = new Object[]{"ID","Fecha","Hora","Descripción","Monto"};
		DefaultTableModel model = new DefaultTableModel(null, columns);
		if(!cashMovements.isEmpty()){
			SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm");
			for (CashMovement cashMovement :cashMovements)
				if(cashMovement.getCashMovementOutcome() > 0){
					model.addRow(new Object[]{
							cashMovement.getCashMovementId(),
							sdfDate.format(cashMovement.getCashMovementDate()),
							sdfTime.format(cashMovement.getCashMovementTime()),
							cashMovement.getCashMovementDescr(),
							cashMovement.getCashMovementOutcome()
					});
				}
		}
		return model;
	}
	
	public DefaultTableModel read(Date dateFrom, Date dateTo){
		cashMovements = cashMovementService.read(dateFrom, dateTo);
		Object[] columns = new Object[]{"ID","Fecha","Hora","Descripción","Monto"};
		DefaultTableModel model = new DefaultTableModel(null, columns);
		if(!cashMovements.isEmpty()){
			SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm");
			for (CashMovement cashMovement :cashMovements)
				if(cashMovement.getCashMovementOutcome() > 0){
					model.addRow(new Object[]{
							cashMovement.getCashMovementId(),
							sdfDate.format(cashMovement.getCashMovementDate()),
							sdfTime.format(cashMovement.getCashMovementTime()),
							cashMovement.getCashMovementDescr(),
							cashMovement.getCashMovementOutcome()
					});
				}
		}
		return model;
	}
	
	public DefaultTableModel read(String search){
		cashMovements = cashMovementService.readByDescr(search);
		Object[] columns = new Object[]{"ID","Fecha","Hora","Descripción","Monto"};
		DefaultTableModel model = new DefaultTableModel(null, columns);
		if(!cashMovements.isEmpty()){
			SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm");
			for (CashMovement cashMovement :cashMovements)
					if(cashMovement.getCashMovementOutcome() > 0){
						model.addRow(new Object[]{
								cashMovement.getCashMovementId(),
								sdfDate.format(cashMovement.getCashMovementDate()),
								sdfTime.format(cashMovement.getCashMovementTime()),
								cashMovement.getCashMovementDescr(),
								cashMovement.getCashMovementOutcome()
						});
					}
		}
		return model;
	}
	
	public DefaultTableModel read(String search, Date dateFrom, Date dateTo){
		cashMovements = cashMovementService.readByDescr(search, dateFrom, dateTo);
		Object[] columns = new Object[]{"ID","Fecha","Hora","Descripción","Monto"};
		DefaultTableModel model = new DefaultTableModel(null, columns);
		if(!cashMovements.isEmpty()){
			SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm");
			for (CashMovement cashMovement :cashMovements)
					if(cashMovement.getCashMovementOutcome() > 0){
						model.addRow(new Object[]{
								cashMovement.getCashMovementId(),
								sdfDate.format(cashMovement.getCashMovementDate()),
								sdfTime.format(cashMovement.getCashMovementTime()),
								cashMovement.getCashMovementDescr(),
								cashMovement.getCashMovementOutcome()
						});
					}
		}
		return model;
	}

}

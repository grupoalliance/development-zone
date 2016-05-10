package org.tourandino.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

import org.tourandino.model.DailyCashRecord;
import org.tourandino.service.DailyCashRecordService;

public class DailyCashRecordController {
	private DailyCashRecord dailyCashRecord;
	private List<DailyCashRecord> dailyCashRecords;
	private DailyCashRecordService dailyCashRecordService;
	
	public DailyCashRecordController(){
		this.dailyCashRecordService = new DailyCashRecordService();
	}
	
	public DefaultTableModel read(){
		dailyCashRecords = dailyCashRecordService.readAll();
		Object[] columns = new Object[]{"ID","Fecha","Apertura","Cierre", "Total Ingreso", "Total Egreso", "Balance"};
		DefaultTableModel model = new DefaultTableModel(null, columns);
		if(!dailyCashRecords.isEmpty()){
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
			for(DailyCashRecord dailyCashRecord :dailyCashRecords){
				if(dailyCashRecord.getCloseDatetime() != null){
					model.addRow(new Object[]{
							dailyCashRecord.getDailyCashRecordId(),
							sdf.format(dailyCashRecord.getDailyCashRecordDate()),
							sdf2.format(dailyCashRecord.getOpenDatetime()),
							sdf2.format(dailyCashRecord.getCloseDatetime()),
							dailyCashRecord.getIncomeTotal(),
							dailyCashRecord.getOutcomeTotal(),
							dailyCashRecord.getBalance()
					});
				}
				else{
					model.addRow(new Object[]{
							dailyCashRecord.getDailyCashRecordId(),
							sdf.format(dailyCashRecord.getDailyCashRecordDate()),
							sdf2.format(dailyCashRecord.getOpenDatetime()),
							dailyCashRecord.getCloseDatetime(),
							dailyCashRecord.getIncomeTotal(),
							dailyCashRecord.getOutcomeTotal(),
							dailyCashRecord.getBalance()
							});
				}
			}
		}
		return model;
	}
	
	public DefaultTableModel read(Date dateFrom, Date dateTo){
		dailyCashRecords = dailyCashRecordService.readByDate(dateFrom, dateTo);
		Object[] columns = new Object[]{"ID","Fecha","Apertura","Cierre", "Total Ingreso", "Total Egreso", "Balance"};
		DefaultTableModel model = new DefaultTableModel(null, columns);
		if(!dailyCashRecords.isEmpty()){
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
			for(DailyCashRecord dailyCashRecord :dailyCashRecords){
				if(dailyCashRecord.getCloseDatetime() != null){
					model.addRow(new Object[]{
							dailyCashRecord.getDailyCashRecordId(),
							sdf.format(dailyCashRecord.getDailyCashRecordDate()),
							sdf2.format(dailyCashRecord.getOpenDatetime()),
							sdf2.format(dailyCashRecord.getCloseDatetime()),
							dailyCashRecord.getIncomeTotal(),
							dailyCashRecord.getOutcomeTotal(),
							dailyCashRecord.getBalance()
					});
				}
				else{
					model.addRow(new Object[]{
							dailyCashRecord.getDailyCashRecordId(),
							sdf.format(dailyCashRecord.getDailyCashRecordDate()),
							sdf2.format(dailyCashRecord.getOpenDatetime()),
							dailyCashRecord.getCloseDatetime(),
							dailyCashRecord.getIncomeTotal(),
							dailyCashRecord.getOutcomeTotal(),
							dailyCashRecord.getBalance()
							});
				}
			}
		}
		return model;
	}
	
	public Integer createRecord(){
		dailyCashRecord = new DailyCashRecord(new Date(), 0, 0, 0, false, new Date());
		return dailyCashRecordService.create(dailyCashRecord);
	}
	
	public boolean dailyRecordExist(){
		dailyCashRecord = dailyCashRecordService.readDailyCashRecord();
		if(dailyCashRecord != null){
			return true;
		}
		else return false;
	}
	
	public boolean DailyRecordIsClosed(){
		dailyCashRecord = dailyCashRecordService.readDailyCashRecord();
		if(dailyCashRecord.isIsClosed()){
			return true;
		}
		else return false;
	}
	
	public void increaseBalance(float amount){
		dailyCashRecord = dailyCashRecordService.readDailyCashRecord();
		dailyCashRecord.setBalance(dailyCashRecord.getBalance() + amount);
		dailyCashRecordService.update(dailyCashRecord);
	}
	
	public void decreaseBalance(float amount){
		dailyCashRecord = dailyCashRecordService.readDailyCashRecord();
		dailyCashRecord.setBalance(dailyCashRecord.getBalance() - amount);
		dailyCashRecordService.update(dailyCashRecord);
	}
	
	public Object[] loadDailyCashRecord(Integer id){
		dailyCashRecord = dailyCashRecordService.readById(id);
		return new Object[]{
				dailyCashRecord.getDailyCashRecordDate(),
				dailyCashRecord.getOpenDatetime(),
				dailyCashRecord.getCloseDatetime(),
				dailyCashRecord.getIncomeTotal(),
				dailyCashRecord.getOutcomeTotal(),
				dailyCashRecord.getBalance()
		};
	}
	
	public DailyCashRecord readDailyCashRecord(){
		return dailyCashRecordService.readDailyCashRecord();
	}
	
	public void closeRecord(Integer id){
		dailyCashRecord = dailyCashRecordService.readById(id);
		if(!dailyCashRecord.isIsClosed()){
			dailyCashRecord.setCloseDatetime(new Date());
			dailyCashRecord.setIsClosed(true);
			dailyCashRecordService.update(dailyCashRecord);
		}
	}

	public DailyCashRecord getDailyCashRecord() {
		return dailyCashRecord;
	}

	public void setDailyCashRecord(DailyCashRecord dailyCashRecord) {
		this.dailyCashRecord = dailyCashRecord;
	}

	public List<DailyCashRecord> getDailyCashRecords() {
		return dailyCashRecords;
	}

	public void setDailyCashRecords(List<DailyCashRecord> dailyCashRecords) {
		this.dailyCashRecords = dailyCashRecords;
	}

	public DailyCashRecordService getDailyCashRecordService() {
		return dailyCashRecordService;
	}

	public void setDailyCashRecordService(
			DailyCashRecordService dailyCashRecordService) {
		this.dailyCashRecordService = dailyCashRecordService;
	}
	
	

}

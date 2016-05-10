package org.tourandino.controller;

import java.util.Date;
import java.util.List;

import org.tourandino.model.ErrorLog;
import org.tourandino.service.ErrorLogService;

public class ErrorLogController {
	ErrorLogService errorLogService = new ErrorLogService();
	ErrorLog errorLog;
	List<ErrorLog> errorLogs;
	
	public Integer createErrorLog(Date datetime, String message, String location, String detail){
		errorLog = new ErrorLog(new Date(), message, location, detail);
		return errorLogService.create(errorLog);
	}

}

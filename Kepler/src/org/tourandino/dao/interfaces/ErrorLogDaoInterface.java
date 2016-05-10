package org.tourandino.dao.interfaces;

import java.util.List;

import org.tourandino.model.ErrorLog;

public interface ErrorLogDaoInterface {

	public Integer create(ErrorLog entity);
	public void update(ErrorLog entity);
	public ErrorLog readById(Integer errorLogId);
	public void delete(ErrorLog entity);
	public List<ErrorLog> readAll();
	public void deleteAll();
}

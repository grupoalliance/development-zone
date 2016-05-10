package org.tourandino.dao.interfaces;

import java.util.Date;
import java.util.List;

import org.tourandino.model.DailyCashRecord;

public interface DailyCashRecordDaoInterface {
	public Integer create(DailyCashRecord entity);
	public void update(DailyCashRecord entity);
	public DailyCashRecord readById(Integer id);
	public List<DailyCashRecord> readByDate(Date dateFrom, Date dateTo);
	public void delete(DailyCashRecord entity);
	public List<DailyCashRecord> readAll();
	public void deleteAll();

}

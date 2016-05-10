package org.tourandino.dao.interfaces;

import java.util.List;

import org.tourandino.model.UserSession;

public interface UserSessionDaoInterface {

	public Integer create(UserSession entity);
	public UserSession readById(Integer userSessionId);
	public List<UserSession> readAll();
	public void update(UserSession entity);
	public void delete(UserSession entity);
	public void deleteAll();
}

package org.tourandino.dao.interfaces;

import java.util.List;

import org.tourandino.model.User;

public interface UserDaoInterface {
	public Integer create(User entity);
	public User readById(Integer userId);
	public List<User> readAll();
	public User readByUsernamePassword(String username, String password);
	public List<User> readByUsername(String username);
	public List<User> readByFullname(String fullname);
	public List<User> readByUsernameFullname(String username, String fullname);
	public void update(User entity);
	public void delete(User entity);
	public void deleteAll();
}

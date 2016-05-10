package org.tourandino.dao.interfaces;

import java.util.List;

import org.tourandino.model.Role;

public interface RoleDaoInterface {

	public void create(Role entity);
	public Role readById(Integer userId);
	public List<Role> readAll();
	public void update(Role entity);
	public void delete(Role entity);
	public void deleteAll();
}

package org.tourandino.controller;

import java.util.List;
import javax.swing.DefaultComboBoxModel;

import org.tourandino.model.Role;
import org.tourandino.service.RoleService;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class RoleController {

	private Role role;
	private List<Role> roles;
	private RoleService roleService = new RoleService();
	
	public DefaultComboBoxModel read(){
		roles = roleService.readAll();
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		if(roles != null){
			for(Role role: roles){
				model.addElement(role);
			}
		}
		return model;
	}
	
	public Role readRoleById(Integer id){
		role = roleService.readById(id);
		return role;
	}
	
	public DefaultComboBoxModel read(Object r){
		roles = roleService.readAll();
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		if(roles != null){
			for(Role role: roles){
				model.addElement(role);
			}
			model.setSelectedItem((Role)r);
		}
		return model;
	}
	
	
}

package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.RoleDao;
import com.ecommerce.model.Role;

@Service
public class RoleService {
	
	@Autowired
	private RoleDao roleDao;
	
	public Role createNewRole(Role role) {
		return roleDao.save(role);
	}

}

package com.ecommerce.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.Role;

@Repository
public interface RoleDao extends CrudRepository<Role, String>{
	
	

}

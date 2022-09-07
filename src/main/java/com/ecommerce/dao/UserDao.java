package com.ecommerce.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.User;

@Repository
public interface UserDao extends CrudRepository<User, String> {
	
	

}

package com.ecommerce.service;

import com.ecommerce.dao.RoleDao;
import com.ecommerce.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.UserDao;
import com.ecommerce.model.User;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User registerNewuser(User user) {

		Role role = roleDao.findById("User").get();

		Set<Role> roles = new HashSet<>();
		roles.add(role);
		user.setUserRole(roles);

		user.setUserPassword(getEncodedPassword(user.getUserPassword()));

		return userDao.save(user);
	}

	public void initRolesAndUser(){
		Role adminRole =  new Role();
		adminRole.setRoleName("Admin");
		adminRole.setRoleDescription("Admin Role");
		roleDao.save(adminRole);

		Role userRole =  new Role();
		userRole.setRoleName("User");
		userRole.setRoleDescription("Default Role for New Users");
		roleDao.save(userRole);

		User adminUser = new User();
		adminUser.setUserFirstName("admin");
		adminUser.setUserLastName("admin");
		adminUser.setUserName("admin123");
		adminUser.setUserPassword(getEncodedPassword("admin@123"));
		Set<Role> adminRoles = new HashSet<>();
		adminRoles.add(adminRole);
		adminUser.setUserRole(adminRoles);
		userDao.save(adminUser);

		User user = new User();
		user.setUserFirstName("John");
		user.setUserLastName("Smith");
		user.setUserName("john123");
		user.setUserPassword(getEncodedPassword("john@pass"));
		Set<Role> userRoles = new HashSet<>();
		userRoles.add(userRole);
		user.setUserRole(userRoles);
		userDao.save(user);

	}

	public String getEncodedPassword(String password){
		return passwordEncoder.encode(password);
	}

}

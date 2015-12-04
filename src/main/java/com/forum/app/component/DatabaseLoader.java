package com.forum.app.component;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.forum.app.entity.User;
import com.forum.app.repository.CrudService;

/**
 * Demo Data Loader
 * 
 * @author dzigar
 *
 */

@Component
public class DatabaseLoader {

	
	@Autowired
	private CrudService crudService;

	private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseLoader.class);

	@PostConstruct
	private void initDatabase() {
		// User #1: "user", with password "p1" and role "USER"
		GrantedAuthority[] userRoles = { new SimpleGrantedAuthority("ROLE_USER") };
		crudService.create(new User("user", "p1", Arrays.asList(userRoles)));
		
		// User #2: "root", with password "p2" and roles "USER" and "ADMIN"
		GrantedAuthority[] adminRoles = { new SimpleGrantedAuthority("ROLE_USER"),
				new SimpleGrantedAuthority("ROLE_ADMIN") };
		crudService.create(new User("root", "p1", Arrays.asList(adminRoles)));
		
	}

}

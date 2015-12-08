package com.forum.app.component;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.forum.app.entity.Branch;
import com.forum.app.entity.Section;
import com.forum.app.entity.Topic;
import com.forum.app.entity.User;
import com.forum.app.service.CrudService;

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

	@PostConstruct
	private void initDatabase() {
		// User #1: "user", with password "p1" and role "USER"
		GrantedAuthority[] userRoles = { new SimpleGrantedAuthority("ROLE_USER") };
		crudService.create(new User("user", "user@mail.ru", "p1", Arrays.asList(userRoles)));

		// User #2: "root", with password "p2" and roles "USER" and "ADMIN"
		GrantedAuthority[] adminRoles = { new SimpleGrantedAuthority("ROLE_USER"),
				new SimpleGrantedAuthority("ROLE_ADMIN") };
		crudService.create(new User("root", "userRoot@gmail.com", "p1", Arrays.asList(adminRoles)));

		Section section = new Section("Section 1");
		Branch branch = new Branch("Branch 1");
		Topic t = new Topic("Topic 1");
		t.setBranch(branch);
		branch.addTopic(t);
		branch.setSection(section);
		section.addBranch(branch);

		crudService.create(t);

	}

}

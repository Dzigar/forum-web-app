package com.forum.app.entity;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@NamedQueries({ @NamedQuery(name = User.ALL, query = "Select u from User u"),
		@NamedQuery(name = User.BY_USERNAME, query = "Select u from User u where u.username = :username") })
public class User {

	public static final String ALL = "User.All";
	public static final String BY_USERNAME = "User.byUsername";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String username;

	private String email;

	private String password;

	@ElementCollection(fetch = FetchType.EAGER)
	private List<GrantedAuthority> roles;

	public User() {
	}

	public User(String username, String email, String password, List<GrantedAuthority> roles) {
		this.username = username;
		this.email = email;
		this.setPassword(new BCryptPasswordEncoder().encode(password));
		this.setRoles(roles);
	}

	// getters, setters

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the roles
	 */
	public List<GrantedAuthority> getRoles() {
		return roles;
	}

	/**
	 * @param roles
	 *            the roles to set
	 */
	public void setRoles(List<GrantedAuthority> roles) {
		this.roles = roles;
	}

}
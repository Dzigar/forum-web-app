package com.forum.app.entity.dto;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.forum.app.entity.dto.validation.PasswordsNotEqual;

@PasswordsNotEqual(passwordFieldName = "password", passwordVerificationFieldName = "passwordVerification")
public class UserForm {

	@NotEmpty
	@Size(max = 100)
	private String username;

	@Email
	@NotEmpty
	@Size(max = 100)
	private String email;

	private String password;

	private String passwordVerification;

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
	 * @return the passwordVerification
	 */
	public String getPasswordVerification() {
		return passwordVerification;
	}

	/**
	 * @param passwordVerification
	 *            the passwordVerification to set
	 */
	public void setPasswordVerification(String passwordVerification) {
		this.passwordVerification = passwordVerification;
	}

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

}

package com.forum.app.entity.dto.validation;

/**
 * The exception is thrown when the email given during the registration phase is
 * already found from the database.
 * 
 * @author dzigar
 */
public class DuplicateEmailException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1892059858739177018L;

	public DuplicateEmailException(String message) {
		super(message);
	}
}

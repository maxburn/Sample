package com.saban.example.validation;

/**
 * This interface defines the methods available to validate credential.
 *
 */
public interface CredentialsValidator {
	/**
	 * Validates both userName and password
	 * @param userName
	 * @param password
	 * @return
	 */
	boolean validateCredentials (String userName, String password);
	
	/**
	 * Used to validate userName
	 * @param userName
	 * @return
	 */
	boolean validateUserName (String userName);
}

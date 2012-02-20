package com.saban.example.validation.impl;

import com.saban.example.validation.CredentialsValidator;

/**
 * An implementation of {@link CredentialsValidator} that has no database
 * support. Used during initial framing of classes and to show different
 * implementation possibilities.
 * 
 */
public class HardCodedCredentialsValidator implements CredentialsValidator {

	private static final String SECRET_PASSWORD = "password";

	@Override
	public boolean validateCredentials(String userName, String password) {
		return SECRET_PASSWORD.equals(password);
	}

	@Override
	public boolean validateUserName(String userName) {
		return true;
	}

}

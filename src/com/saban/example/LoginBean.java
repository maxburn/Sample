package com.saban.example;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.saban.example.validation.CredentialsValidator;

/**
 *  This class interacts with the login page.
 *  It is used to validate the information entered. *
 */
public class LoginBean {

	// this will match the navigation rules in faces-config.xml
	private static final String SUCCESS_PAGE = "success";
	private static final String FAIL_PAGE = "fail";
	
	private String name;
	private String password;
	
	// Using strategy pattern here
	// CredentialsValidator implementation will be decided at runtime.
	private CredentialsValidator credentialsValidator;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public CredentialsValidator getCredentialsValidator() {
		return credentialsValidator;
	}

	public void setCredentialsValidator(CredentialsValidator credentialsValidator) {
		this.credentialsValidator = credentialsValidator;
	}

	/**
	 * This method will assist in the navigation of the request.
	 * @return
	 */
	public String validateCredentials() {
		if (credentialsValidator.validateCredentials(name, password)) {
			// forward onto subsequent page.
			return SUCCESS_PAGE;
		}
		
		// Ideally this message would be localized, but for the purpose of this exercise it is not.
		FacesContext.getCurrentInstance().addMessage("myForm", new FacesMessage("Please insert correct username / password"));

		return FAIL_PAGE;
	}
}

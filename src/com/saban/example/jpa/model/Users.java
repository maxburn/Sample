package com.saban.example.jpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Users", schema = "EXAMPLE")
@NamedQueries({
		@NamedQuery(name = "findByUsername", query = "select t from Users t where t.username = :username"),
		@NamedQuery(name = "findByUsernameAndPassword", query = "select t from Users t where t.username = :username and t.password = :password"), })
/**
 * This class represents an Table on the database.
 * I have defined a couple of queries to be used against it for convenience.
 */
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // Although never used I imagine this would be needed.
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Users [username=" + username + ", password=" + password + "]";
	}
}

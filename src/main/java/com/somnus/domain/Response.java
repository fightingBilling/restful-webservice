package com.somnus.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Response implements Serializable {

	private static final long serialVersionUID = 1L;

	private String username;
	private String password;

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public String getPassword() {
		return this.password;
	}

	@Override
	public String toString() {
		return "account:{" + username + "|" + password + "}";
	}

}

package dto;

import java.io.Serializable;

public class User implements Serializable {
	private String username;
	private String password;
	private String mail_address;
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
	public String getMail_address() {
		return mail_address;
	}
	public void setMail_address(String mail_address) {
		this.mail_address = mail_address;
	}
	public User() {
		this.username="";
		this.password="";
		this.mail_address="";
	}
	public User(String username,String password,String mail_address) {
		this.username = username;
		this.password = password;
		this.mail_address = mail_address;
	}
public User(String username,String password) {
	this.username = username;
	this.password = password;
}
}

package dto;

import java.io.Serializable;

public class User implements Serializable {
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

	
	public User() {
		this.username="";
		this.password="";
		
	}
	public User(String username,String password) {
		this.username = username;
		this.password = password;
		
	}
//DAO DA0 DAO
}

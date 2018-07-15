package com.pojos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SteamEmailUser {
	
     private String username;
	
	@NotNull(message="this field is required")
	@Pattern(regexp="^[a-zA-Z0-9]{5}",message="must be 5 chars")
     private String emailcode;
	public SteamEmailUser() {
		super();
	}
	public SteamEmailUser(String username, String emailcode) {
		super();
		this.username = username;
		this.emailcode = emailcode;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmailcode() {
		return emailcode;
	}
	public void setEmailcode(String emailcode) {
		this.emailcode = emailcode;
	}
}

package com.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
@Table(name="steamuser")
public class SteamUser {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="systemusername")
	private String systemusername;
	
	@Column(name="authority")
	private String authority;
	
	@Column(name="starttime")
	private long starttime;
	
	@Column(name="username")
	@NotNull(message="this field is required")
	@Size(min=1,message="this field is required")
	private String username;
	
	@Column(name="password")
	@NotNull(message="this field is required")
	@Size(min=6,message="password length should >=6")
    private String password;
	
	@Column(name="facode")
	@OneTimeCode
    private String facode;
	
	@Column(name="appid")
	@ForAppID
    private String gamesPlayedWhileIdle;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSystemusername() {
		return systemusername;
	}
	public void setSystemusername(String systemusername) {
		this.systemusername = systemusername;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public long getStarttime() {
		return starttime;
	}
	public void setStarttime(long starttime) {
		this.starttime = starttime;
	}
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
	public String getFacode() {
		return facode;
	}
	public void setFacode(String facode) {
		this.facode = facode;
	}
	public String getGamesPlayedWhileIdle() {
		return gamesPlayedWhileIdle;
	}
	public void setGamesPlayedWhileIdle(String gamesPlayedWhileIdle) {
		this.gamesPlayedWhileIdle = gamesPlayedWhileIdle;
	}

}
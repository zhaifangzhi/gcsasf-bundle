package com.databasemodel;

import java.util.List;

import com.pojos.SteamUser;

public interface SteamUserDAO {
	public List<SteamUser> getAllSteamUsers();
	   public void save(SteamUser d);
	   public void delete(SteamUser d);
	   public SteamUser get(int theId);
	   public SteamUser getFromSystemuser(String systemusername);
	   public void updateusername(SteamUser d,String username);
}

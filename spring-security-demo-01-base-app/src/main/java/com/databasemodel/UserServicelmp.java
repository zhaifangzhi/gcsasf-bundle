package com.databasemodel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pojos.SteamUser;

@Service
public class UserServicelmp implements UserService {  
	
	@Autowired
	private SteamUserDAO sud;

	@Override
	@Transactional
	public void save(SteamUser d) {
		sud.save(d);
	}

	@Override
	@Transactional
	public void delete(SteamUser d) {
		sud.delete(d);
	}


	@Override
	@Transactional
	public List<SteamUser> getAllSteamUsers() {
		// TODO Auto-generated method stub
		return sud.getAllSteamUsers();
	}

	@Override
	@Transactional
	public SteamUser get(int theId) {
		// TODO Auto-generated method stub
		return sud.get(theId);
	}

	@Override
	@Transactional
	public SteamUser getFromSystemuser(String systemusername) {
		// TODO Auto-generated method stub
		return sud.getFromSystemuser(systemusername);
	}

	@Override
	@Transactional
	public void updateusername(SteamUser d, String username) {
		sud.updateusername(d, username);
	}

}

package com.databasemodel;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pojos.SteamUser;

@Repository
public class SteamUserDAOImpl implements SteamUserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<SteamUser> getAllSteamUsers() {
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query  ... sort by last name
		Query<SteamUser> theQuery = 
				currentSession.createQuery("from SteamUser order by id",
						SteamUser.class);
		
		// execute query and get result list
		List<SteamUser> steamusers = theQuery.getResultList();
				
		// return the results		
		return steamusers;
	}

	@Override
	public void save(SteamUser d) {
        Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(d);
	}

	@Override
	public void delete(SteamUser d) {
		Session currentSession = sessionFactory.getCurrentSession();
		int theId=d.getId();
		Query theQuery = 
				currentSession.createQuery("delete from SteamUser where id=:customerId");
		theQuery.setParameter("customerId", theId);
		theQuery.executeUpdate();

	}

	@Override
	public SteamUser get(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
        SteamUser steamuser = currentSession.get(SteamUser.class, theId);
		
		return steamuser;
	}

	@Override
	public SteamUser getFromSystemuser(String systemusername) {
		Session currentSession = sessionFactory.getCurrentSession();
		List<SteamUser> steamusers=currentSession.
				createQuery("from SteamUser s where s.systemusername='"+systemusername+"'")
				.getResultList();		
		return steamusers.get(0);
	}

	@Override
	public void updateusername(SteamUser d, String username) {
		Session currentSession = sessionFactory.getCurrentSession();
        SteamUser steamuser=currentSession.get(SteamUser.class, d.getId());
        steamuser.setUsername(username);
	}

}

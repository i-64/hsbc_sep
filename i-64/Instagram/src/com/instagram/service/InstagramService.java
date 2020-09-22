package com.instagram.service;

import com.instagram.dao.InstagramDAO;
import com.instagram.utility.*;
import java.util.*;
import com.instagram.entity.InstagramUser;
import com.instagram.utility.InstagramException;

public class InstagramService implements InstagramServiceInterface {
	
	private InstagramDAO d;
	
	public InstagramService () {
		
		d = DAOFactory.DAOObject("admindao");
	}

	@Override
	public int createAccountService(InstagramUser u) {
		// TODO Auto-generated method stub
		return d.createAccountDAO(u);
	}
	
	@Override
	public InstagramUser authService (InstagramUser u) {
		
		return d.authDAO(u);
	}

	@Override
	public int updateAccountService(InstagramUser u, InstagramUser newU) {
		// TODO Auto-generated method stub
		return d.updateAccountDAO(u, newU);
	}

	@Override
	public InstagramUser viewAccountService(InstagramUser u) throws InstagramException {
		// TODO Auto-generated method stub
		return d.viewAccountDAO(u);
	}

	@Override
	public ArrayList<InstagramUser> viewAllProfiles() {
		// TODO Auto-generated method stub
		return d.viewAllProfiles();
	}

	@Override
	public int deleteAccountService(InstagramUser u) {
		// TODO Auto-generated method stub
		return d.deleteAccountDAO(u);
	}
	
	public Map <String, ArrayList <InstagramUser>> mapDemoService() {
		
		return d.mapDemo();
	}

	@Override
	public void exportDataService() {
		// TODO Auto-generated method stub
		
		d.exportDataDAO();
	}

}

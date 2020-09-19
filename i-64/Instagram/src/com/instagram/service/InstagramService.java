package com.instagram.service;

import com.instagram.dao.InstagramDAO;
import java.util.*;
import com.instagram.entity.InstagramUser;

public class InstagramService implements InstagramServiceInterface {
	
	private InstagramDAO d;
	
	public InstagramService () {
		
		d = new InstagramDAO();
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
	public InstagramUser viewAccountService(InstagramUser u) {
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

}

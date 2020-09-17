package com.instagram.service;

import com.instagram.dao.InstagramDAO;
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
	public void updateAccountService() {
		// TODO Auto-generated method stub
		d.updateAccountDAO();
	}

	@Override
	public void postService() {
		// TODO Auto-generated method stub
		d.postDAO();
	}

	@Override
	public void disableAccountService() {
		// TODO Auto-generated method stub
		d.disableAccountDAO();
	}

	@Override
	public void deleteAccountService() {
		// TODO Auto-generated method stub
		d.deleteAccountDAO();
	}

}

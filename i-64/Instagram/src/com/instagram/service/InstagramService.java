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
	public int updateAccountService(InstagramUser u, InstagramUser newU) {
		// TODO Auto-generated method stub
		return d.updateAccountDAO(u, newU);
	}

	@Override
	public int postService(InstagramUser u) {
		// TODO Auto-generated method stub
		return d.postDAO(u);
	}

	@Override
	public int disableAccountService(InstagramUser u) {
		// TODO Auto-generated method stub
		return d.disableAccountDAO(u);
	}

	@Override
	public int deleteAccountService(InstagramUser u) {
		// TODO Auto-generated method stub
		return d.deleteAccountDAO(u);
	}

}

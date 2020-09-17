package com.instagram.dao;

import com.instagram.entity.InstagramUser;

public class InstagramDAO implements InstagramDAOInterface {

	@Override
	public int createAccountDAO(InstagramUser u) {
		// TODO Auto-generated method stub
		
		if (u.getName().equalsIgnoreCase("Mrunal"))
			return 1;
		else
			return 0;
		
//		System.out.println("Creating Account ...");
	}

	@Override
	public void updateAccountDAO() {
		// TODO Auto-generated method stub
		System.out.println("Updating Account ...");
	}

	@Override
	public void postDAO() {
		// TODO Auto-generated method stub
		System.out.println("Posting ...");
	}

	@Override
	public void disableAccountDAO() {
		// TODO Auto-generated method stub
		System.out.println("Disabling Account ...");
	}

	@Override
	public void deleteAccountDAO() {
		// TODO Auto-generated method stub
		System.out.println("Deleting Account ...");
	}

}

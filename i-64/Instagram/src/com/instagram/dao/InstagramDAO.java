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
	public int updateAccountDAO(InstagramUser u, InstagramUser newU) {
		// TODO Auto-generated method stub
		if (u.getPassword().equalsIgnoreCase("Mrunal")) {
			
			u.setName(newU.getName());
			u.setEmail(newU.getEmail());
			u.setUsername(newU.getUsername());
			u.setPassword(newU.getPassword());
			return 1;
		}
		else
			return 0;
	}

	@Override
	public int postDAO(InstagramUser u) {
		// TODO Auto-generated method stub
		if (u.getPassword().equalsIgnoreCase("Mrunal"))
			return 1;
		else
			return 0;
	}

	@Override
	public int disableAccountDAO(InstagramUser u) {
		// TODO Auto-generated method stub
		if (u.getPassword().equalsIgnoreCase("Mrunal"))
			return 1;
		else
			return 0;
	}

	@Override
	public int deleteAccountDAO(InstagramUser u) {
		// TODO Auto-generated method stub
		if (u.getPassword().equalsIgnoreCase("Mrunal"))
			return 1;
		else
			return 0;
	}

}

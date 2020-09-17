package com.instagram.dao;

import com.instagram.entity.InstagramUser;

public interface InstagramDAOInterface {
	
	public int createAccountDAO(InstagramUser u);
	public int updateAccountDAO(InstagramUser u, InstagramUser newU);
	public int postDAO(InstagramUser u);
	public int disableAccountDAO(InstagramUser u);
	public int deleteAccountDAO(InstagramUser u);
}

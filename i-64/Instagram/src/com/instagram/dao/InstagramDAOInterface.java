package com.instagram.dao;

import com.instagram.entity.InstagramUser;

public interface InstagramDAOInterface {
	
	public int createAccountDAO(InstagramUser u);
	public void updateAccountDAO();
	public void postDAO();
	public void disableAccountDAO();
	public void deleteAccountDAO();
}

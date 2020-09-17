package com.instagram.service;

import com.instagram.entity.InstagramUser;

public interface InstagramServiceInterface {

	public int createAccountService(InstagramUser u);
	public void updateAccountService();
	public void postService();
	public void disableAccountService();
	public void deleteAccountService();
}

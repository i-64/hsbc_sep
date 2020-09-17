package com.instagram.service;

import com.instagram.entity.InstagramUser;

public interface InstagramServiceInterface {

	public int createAccountService(InstagramUser u);
	public int updateAccountService(InstagramUser u, InstagramUser newU);
	public int postService(InstagramUser u);
	public int disableAccountService(InstagramUser u);
	public int deleteAccountService(InstagramUser u);
}

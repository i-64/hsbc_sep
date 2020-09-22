package com.instagram.service;

import com.instagram.entity.InstagramUser;
import com.instagram.utility.InstagramException;

import java.util.*;

public interface InstagramServiceInterface {

	public int createAccountService(InstagramUser u);
	public InstagramUser authService(InstagramUser u);
	public int updateAccountService(InstagramUser u, InstagramUser newU);
	public InstagramUser viewAccountService(InstagramUser u) throws InstagramException;
	public ArrayList<InstagramUser> viewAllProfiles();
	public int deleteAccountService(InstagramUser u);
	public void exportDataService ();
}

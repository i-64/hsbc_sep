package com.instagram.dao;

import com.instagram.entity.InstagramUser;
import com.instagram.utility.InstagramException;

import java.util.*;

public interface InstagramDAOInterface {
	
	public int createAccountDAO(InstagramUser u);
	public int updateAccountDAO(InstagramUser u, InstagramUser newU);
	public InstagramUser viewAccountDAO(InstagramUser u) throws InstagramException;
	public InstagramUser authDAO(InstagramUser u);
	public ArrayList<InstagramUser> viewAllProfiles();
	public int deleteAccountDAO(InstagramUser u);
	public void exportDataDAO ();
}

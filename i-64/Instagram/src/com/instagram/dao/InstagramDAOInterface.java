package com.instagram.dao;

import com.instagram.entity.InstagramUser;
import java.util.*;

public interface InstagramDAOInterface {
	
	public int createAccountDAO(InstagramUser u);
	public int updateAccountDAO(InstagramUser u, InstagramUser newU);
	public InstagramUser viewAccountDAO(InstagramUser u);
	public InstagramUser authDAO(InstagramUser u);
	public ArrayList<InstagramUser> viewAllProfiles();
	public int deleteAccountDAO(InstagramUser u);
}

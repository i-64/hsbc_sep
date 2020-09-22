package com.instagram.controller;

import com.instagram.entity.*;

public interface InstagramControllerInterface {

	public InstagramUser createAccount();
	public void viewAccount();
	public int resetPassword();
	public void viewAllProfiles();
	public void deleteAccount(InstagramUser u);
	public InstagramUser updateAccount(InstagramUser u);
	public void exportData ();
}

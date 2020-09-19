package com.instagram.controller;

import java.io.*;

import com.instagram.entity.InstagramUser;
import com.instagram.service.InstagramService;
import java.util.*;

public class IntsagramController implements InstagramControllerInterface {
	
	private InstagramService is;
	
	public IntsagramController () {
		
		is = new InstagramService();
	}

	@Override
	public InstagramUser createAccount() {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String name = "", email = "", username = "", password = "";
		try {
			
			System.out.println("Enter your name >> ");
			name = in.readLine();
			System.out.println("Enter your email >> ");
			email = in.readLine();
			System.out.println("Enter your username >> ");
			username = in.readLine();
			System.out.println("Enter your password >> ");
			password = in.readLine();
		}
		catch (IOException e) {
			
			System.out.println("An error occurred :\n" + e.toString());
		}
		InstagramUser u = new InstagramUser();
		u.setEmail(email);
		u.setName(name);
		u.setUsername(username);
		u.setPassword(password);
		
		int res = is.createAccountService(u);
		
		if (res > 0) {
			
			System.out.println("User successfully created");
			return u;
		}
		else {
			
			System.out.println("Could not create new user :(");
			return null;
		}
	}
	
	public InstagramUser signIn () {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String username = "", password = "";
		
		try {
			System.out.println("Enter your username >> ");
			username = in.readLine();
			System.out.println("Enter your password >> ");
			password = in.readLine();
		}
		catch (IOException e) {
			
			System.out.println("An error occurred :\n" + e.toString());
		}
		InstagramUser u = new InstagramUser();
		u.setUsername(username);
		u.setPassword(password);
		
		InstagramUser user = is.authService(u);
		
		if (user != null) {
			
			System.out.println("Signed in as " + user.getUsername());
			return user;
		}
		else {
			
			System.out.println("Authentication error :(");
			return null;
		}
	}

	@Override
	public InstagramUser updateAccount(InstagramUser u) {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String newUsername = "", newPassword = "", name = "", email = "";
		try {
			System.out.println("Enter new name >> ");
			name = in.readLine();
			System.out.println("Enter new email >> ");
			email = in.readLine();
			System.out.println("Enter new username >> ");
			newUsername = in.readLine();
			System.out.println("Enter new password >> ");
			newPassword = in.readLine();
		}
		catch (IOException e) {
			
			System.out.println("An error occurred :\n" + e.toString());
		}
		InstagramUser newU = new InstagramUser();
		newU.setEmail(email);
		newU.setName(name);
		newU.setUsername(newUsername);
		newU.setPassword(newPassword);
		
		int res = is.updateAccountService(u, newU);
		
		if (res > 0) {
			
			System.out.println("User successfully updated");
			return newU;
		}
		else {
			
			System.out.println("Could not update new user :(");
			return null;
		}
	}

	@Override
	public void viewAccount() {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String username = "";
		try {
			System.out.println("Enter username >> ");
			username = in.readLine();
		}
		catch (IOException e) {
			
			System.out.println("An error occurred :\n" + e.toString());
		}
		InstagramUser u = new InstagramUser();
		u.setUsername(username);
		
		InstagramUser user = is.viewAccountService(u);
		
		if (user != null) {
			System.out.println("User profile found:\nName: " + user.getName() + "\nEmail: " + user.getEmail() + "\nUsername: " + user.getUsername());
		}
		else {
			
			System.out.println("Could not find such user :(");
		}
	}

	@Override
	public void viewAllProfiles() {
		// TODO Auto-generated method stub
		
		ArrayList<InstagramUser> l = is.viewAllProfiles();
		
		if (l.size() >= 1) {
			
			for (InstagramUser u: l) {
				
				System.out.println("Name: " + u.getName() + "\temail: " + u.getEmail() + "\tusername: " + u.getUsername());
			}
			System.out.println("\n");
		}
		else {
			
			System.out.println("Could not verify your account :(");
		}
	}

	@Override
	public void deleteAccount(InstagramUser u) {
		
		int res = is.deleteAccountService(u);
		if (res > 0) {
			
			System.out.println("Account  deleted");
		}
		else {
			
			System.out.println("Could not delete account :(");
		}
	}

	@Override
	public int resetPassword() {
		// TODO Auto-generated method stub
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		String username = "", oldPassword = "", newPassword = "";
//		try {
//			
//			oldPassword = in.readLine();
//			
//			int verifyPassword = is.verifyPassword(u);
//		}
//		catch (IOException e) {
//			
//			System.out.println("An error occurred :\n" + e.toString());
//		}
		return 0;
	}

}

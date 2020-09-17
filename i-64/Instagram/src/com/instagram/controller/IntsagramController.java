package com.instagram.controller;

import java.io.*;

import com.instagram.entity.InstagramUser;
import com.instagram.service.InstagramService;

public class IntsagramController implements InstagramControllerInterface {
	
	private InstagramService is;
	
	public IntsagramController () {
		
		is = new InstagramService();
	}

	@Override
	public void createAccount() {
		// TODO Auto-generated method stub
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
		}
		else {
			
			System.out.println("Could not create new user :(");
		}
	}

	@Override
	public void updateAccount() {
		// TODO Auto-generated method stub
		is.updateAccountService();
	}

	@Override
	public void post() {
		// TODO Auto-generated method stub
		is.postService();
	}

	@Override
	public void disableAccount() {
		// TODO Auto-generated method stub
		is.disableAccountService();
	}

	@Override
	public void deleteAccount() {
		// TODO Auto-generated method stub
		is.disableAccountService();
	}

}

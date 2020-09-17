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
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String newUsername = "", newPassword = "", name = "", email = "", username = "", password = "";
		try {
			System.out.println("Enter your username >> ");
			username = in.readLine();
			System.out.println("Enter your password >> ");
			password = in.readLine();
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
		InstagramUser u = new InstagramUser();
		InstagramUser newU = new InstagramUser();
		u.setUsername(username);
		u.setPassword(password);
		newU.setEmail(email);
		newU.setName(name);
		newU.setUsername(newUsername);
		newU.setPassword(newPassword);
		
		int res = is.updateAccountService(u, newU);
		
		if (res > 0) {
			
			System.out.println("User successfully updated");
		}
		else {
			
			System.out.println("Could not update new user :(");
		}
	}

	@Override
	public void post() {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String name = "", email = "", username = "", password = "";
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
		
		int res = is.postService(u);
		
		if (res > 0) {
			
			System.out.println("Post made");
		}
		else {
			
			System.out.println("Could not post :(");
		}
	}

	@Override
	public void disableAccount() {
		// TODO Auto-generated method stub
BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String name = "", email = "", username = "", password = "";
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
		
		int res = is.disableAccountService(u);
		
		if (res > 0) {
			
			System.out.println("Account  disabled");
		}
		else {
			
			System.out.println("Could not verify your account :(");
		}
	}

	@Override
	public void deleteAccount() {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String name = "", email = "", username = "", password = "";
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
		
		int res = is.deleteAccountService(u);
		
		if (res > 0) {
			
			System.out.println("Account  deleted");
		}
		else {
			
			System.out.println("Authentication error :(");
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

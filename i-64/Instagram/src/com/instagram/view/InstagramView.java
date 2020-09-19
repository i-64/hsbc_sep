package com.instagram.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.instagram.controller.IntsagramController;
import com.instagram.entity.InstagramUser;

public class InstagramView {

	public static void main(String[] args) {
		
		try {
		
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			while (true) {
				
				System.out.println("Menu: \n1. signup\n2. signin\n >> ");
				int mainChoice = Integer.parseInt(in.readLine());
				IntsagramController ic = new IntsagramController();
				InstagramUser currUser = null;
				switch (mainChoice) {
				
					case 0:
						return;
					case 1:
						currUser = ic.createAccount();
						break;
					case 2:
						currUser = ic.signIn();
						break;
					default:
						System.out.println("Invalid choice :(");
				}
				while (currUser != null) {
					System.out.println("************* Menu **************");
					System.out.println("1. Update Account\n2. View Profile\n3. View All Profiles\n4. Delete Account\n");
					int choice = Integer.parseInt(in.readLine());
					boolean flag = false;
					switch (choice) {
					
						case 0:
							flag = true;
							break;
						case 1:
							ic.updateAccount(currUser);
							break;
						case 2:
							ic.viewAccount();
							break;
						case 3:
							ic.viewAllProfiles();
							break;
						case 4:
							ic.deleteAccount(currUser);
							currUser = null;
							break;
						default:
								System.out.println("Invalid Choice");
					}
					if (flag) break;
				}
			}
		}
		catch (IOException e) {
			
			System.out.println("Exception occurred: \n" + e.toString());
		}
	}

}

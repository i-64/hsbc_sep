package com.instagram.utility;


public class InstagramException extends Exception {
	
	@Override
	public String toString () {
		
		return "User does not exist :(";
	}
}

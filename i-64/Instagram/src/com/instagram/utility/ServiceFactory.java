package com.instagram.utility;

import com.instagram.service.InstagramService;

public class ServiceFactory {
	
	private ServiceFactory () {
		;
	}
	
	public static InstagramService createObject (String tp) {
		
		if (tp.equalsIgnoreCase("adminservice")) {
			
			return (new InstagramService());
		}
		else return null;
	}
}

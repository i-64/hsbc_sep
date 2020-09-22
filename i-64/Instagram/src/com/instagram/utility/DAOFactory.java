package com.instagram.utility;

import com.instagram.dao.InstagramDAO;

public class DAOFactory {
	
	private DAOFactory () {
		;
	}
	
	public static InstagramDAO DAOObject (String tp) {
		
		if (tp.equalsIgnoreCase("admindao")) {
			
			return (new InstagramDAO());
		}
		else return null;
	}
}

package com.instagram.utility;

import java.util.Comparator;

import com.instagram.entity.InstagramUser;

public class SortByName implements Comparator<InstagramUser> {

	@Override
	public int compare(InstagramUser arg0, InstagramUser arg1) {
		// TODO Auto-generated method stub
		return -1 * (arg0.getName().compareTo(arg1.getName()));
	}
	

}

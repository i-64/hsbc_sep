package com.instagram.dao;

import java.sql.Connection;
import java.util.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.instagram.entity.InstagramUser;

public class InstagramDAO implements InstagramDAOInterface {
	
	public InstagramDAO () {
	}
	
	@Override
	public int createAccountDAO(InstagramUser u) {
		
		try {
			
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			Connection con = DriverManager.getConnection("jdbc:derby:/home/i-64/Downloads/mydb;create=true;","mrunal","0348");
			PreparedStatement ps = con.prepareStatement("insert into INSTA values(?,?,?,?)");
			ps.setString(1,  u.getName());
			ps.setString(2,  u.getUsername());
			ps.setString(3,  u.getEmail());
			ps.setString(4,  u.getPassword());
			
			int res = ps.executeUpdate();
			return res;
		}
		catch (Exception e) {
		
			System.out.println("ERROR ..." + e);
		}
		return 0;
	}

	@Override
	public int updateAccountDAO(InstagramUser u, InstagramUser newU) {

		InstagramUser user = null;
		try {
			
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			Connection con = DriverManager.getConnection("jdbc:derby:/home/i-64/Downloads/mydb;","mrunal","0348");
			PreparedStatement ps = con.prepareStatement("update INSTA set NAME=?, USERNAME=?, EMAIL=?, PASSWORD=? where USERNAME=?");
			ps.setString(1, newU.getName());
			ps.setString(2, newU.getUsername());
			ps.setString(3, newU.getEmail());
			ps.setString(4, newU.getPassword());
			ps.setString(5, u.getUsername());
			int res = ps.executeUpdate();
			
			return res;
		}
		catch (Exception e) {
			
			System.out.println(e);
		}
		return 0;
	}
	
	@Override
	public InstagramUser authDAO (InstagramUser u) {
		
		InstagramUser user = null;
		try {
			
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			Connection con = DriverManager.getConnection("jdbc:derby:/home/i-64/Downloads/mydb;","mrunal","0348");
			PreparedStatement ps = con.prepareStatement("select * from INSTA where USERNAME=? AND PASSWORD=?");
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ResultSet res = ps.executeQuery();
			
			if (res.next()) {
				
				user = new InstagramUser();
				user.setName(res.getString(1));
				user.setEmail(res.getString(3));
				user.setUsername(res.getString(2));
			}
			return user;
		}
		catch (Exception e) {
			
			System.out.println(e);
		}
		return null;
	}

	@Override
	public InstagramUser viewAccountDAO(InstagramUser u) {
		
		InstagramUser user = null;
		try {
			
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			Connection con = DriverManager.getConnection("jdbc:derby:/home/i-64/Downloads/mydb;","mrunal","0348");
			PreparedStatement ps = con.prepareStatement("select * from INSTA where USERNAME=?");
			ps.setString(1,  u.getUsername());
			ResultSet res = ps.executeQuery();
			
			if (res.next()) {
				
				user = new InstagramUser();
				user.setName(res.getString(1));
				user.setEmail(res.getString(3));
				user.setUsername(res.getString(2));
			}
			return user;
		}
		catch (Exception e) {
			
			System.out.println(e);
		}
		return null;
	}

	@Override
	public ArrayList<InstagramUser> viewAllProfiles() {
		
		try {

			// TABLE NAME IS INSTA (NAME, USERNAME, EMAIL, PASSWORD);
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			ArrayList<InstagramUser> l = new ArrayList <InstagramUser> ();
			Connection con = DriverManager.getConnection("jdbc:derby:/home/i-64/Downloads/mydb;create=true;","mrunal","0348");
			PreparedStatement ps = con.prepareStatement("select * from INSTA");
			ResultSet res = ps.executeQuery();
			
			while (res.next()) {
				InstagramUser u = new InstagramUser();
				u.setName(res.getString(1));
				u.setEmail(res.getString(2));
				u.setUsername(res.getString(3));				
				l.add(u);
			}
			return l;
		}
		catch (Exception e) {
			System.out.println("ERROR ..." + e);
		}
		return null;
	}

	@Override
	public int deleteAccountDAO(InstagramUser u) {
		
		try {

			// TABLE NAME IS INSTA (NAME, USERNAME, EMAIL, PASSWORD);
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			Connection con = DriverManager.getConnection("jdbc:derby:/home/i-64/Downloads/mydb;create=true;","mrunal","0348");			
			PreparedStatement ps = con.prepareStatement("delete from INSTA where EMAIL=?");
			ps.setString(1,  u.getEmail());
			System.out.println("prepared statement ...");
			
			int res = ps.executeUpdate();
			return res;
		}
		catch (Exception e) {
			System.out.println("ERROR ..." + e);
		}
		return 0;
	}

}

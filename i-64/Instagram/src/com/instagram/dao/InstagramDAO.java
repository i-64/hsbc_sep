package com.instagram.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.util.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.instagram.entity.InstagramUser;
import com.instagram.utility.InstagramException;

public class InstagramDAO implements InstagramDAOInterface {
	
	public InstagramDAO () {
	}
	
	@Override
	public int createAccountDAO(InstagramUser u) {
		
		Connection con = null;
		try {
			
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con = DriverManager.getConnection("jdbc:derby:/home/i-64/Downloads/mydb;create=true;","mrunal","0348");
			PreparedStatement ps = con.prepareStatement("insert into INSTA values(?,?,?,?)");
			ps.setString(1,  u.getName());
			ps.setString(2,  u.getUsername());
			ps.setString(3,  u.getEmail());
			ps.setString(4,  u.getPassword());
			
			int res = ps.executeUpdate();
			return res;
		}
		catch (SQLException|ClassNotFoundException e) {
		
			e.printStackTrace();
		}
		finally {
			
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public int updateAccountDAO(InstagramUser u, InstagramUser newU) {

		Connection con = null;
		try {
			
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con = DriverManager.getConnection("jdbc:derby:/home/i-64/Downloads/mydb;","mrunal","0348");
			PreparedStatement ps = con.prepareStatement("update INSTA set NAME=?, USERNAME=?, EMAIL=?, PASSWORD=? where USERNAME=?");
			ps.setString(1, newU.getName());
			ps.setString(2, newU.getUsername());
			ps.setString(3, newU.getEmail());
			ps.setString(4, newU.getPassword());
			ps.setString(5, u.getUsername());
			int res = ps.executeUpdate();
			
			return res;
		}
		catch (SQLException|ClassNotFoundException e) {
			
			System.out.println(e);
		}
		finally {
			
			try {
				
				con.close();
			}
			catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	@Override
	public InstagramUser authDAO (InstagramUser u) {
		
		InstagramUser user = null;
		Connection con = null;
		try {
			
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con = DriverManager.getConnection("jdbc:derby:/home/i-64/Downloads/mydb;","mrunal","0348");
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
		catch (SQLException|ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		finally {
			
			try {
				con.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public InstagramUser viewAccountDAO (InstagramUser u) throws InstagramException {
		
		InstagramUser user = null;
		Connection con = null;
		try {
			
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con = DriverManager.getConnection("jdbc:derby:/home/i-64/Downloads/mydb;","mrunal","0348");
			PreparedStatement ps = con.prepareStatement("select * from INSTA where USERNAME=?");
			ps.setString(1,  u.getUsername());
			ResultSet res = ps.executeQuery();
			
			if (res.next()) {
				
				user = new InstagramUser();
				user.setName(res.getString(1));
				user.setEmail(res.getString(3));
				user.setUsername(res.getString(2));
			}
			if (user == null) {
				
				throw (new InstagramException());
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
		
		Connection con = null;
		try {

			// TABLE NAME IS INSTA (NAME, USERNAME, EMAIL, PASSWORD);
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			ArrayList<InstagramUser> l = new ArrayList <InstagramUser> ();
			con = DriverManager.getConnection("jdbc:derby:/home/i-64/Downloads/mydb;create=true;","mrunal","0348");
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
		catch (SQLException|ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		finally {
			
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public int deleteAccountDAO(InstagramUser u) {
		
		Connection con = null;
		try {

			// TABLE NAME IS INSTA (NAME, USERNAME, EMAIL, PASSWORD);
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con = DriverManager.getConnection("jdbc:derby:/home/i-64/Downloads/mydb;create=true;","mrunal","0348");			
			PreparedStatement ps = con.prepareStatement("delete from INSTA where EMAIL=?");
			ps.setString(1,  u.getEmail());
			System.out.println("prepared statement ...");
			
			int res = ps.executeUpdate();
			return res;
		}
		catch (SQLException|ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		finally {
			
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public Map <String,ArrayList<InstagramUser>> mapDemo () {
		
		Map <String, ArrayList <InstagramUser>> ret = new Hashtable <String, ArrayList <InstagramUser>> ();
		
		ArrayList <InstagramUser> users = new ArrayList<>(), users2 = new ArrayList<>();
		
		Connection con = null;
		try {

			// TABLE NAME IS INSTA (NAME, USERNAME, EMAIL, PASSWORD);
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con = DriverManager.getConnection("jdbc:derby:/home/i-64/Downloads/mydb;create=true;","mrunal","0348");
			PreparedStatement ps = con.prepareStatement("select * from INSTA");
			ResultSet res = ps.executeQuery();
			
			while (res.next()) {
				InstagramUser u = new InstagramUser();
				u.setName(res.getString(1));
				u.setEmail(res.getString(2));
				u.setUsername(res.getString(3));				
				users.add(u);
			}
			
			ret.put("users", users);
			ret.put("users2", users2);
			
			return ret;
		}
		catch (SQLException|ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		finally {
			
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public void exportDataDAO() {
		// TODO Auto-generated method stub
		
		Connection con = null;
		try {

			// TABLE NAME IS INSTA (NAME, USERNAME, EMAIL, PASSWORD);
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			ArrayList<InstagramUser> l = new ArrayList <InstagramUser> ();
			con = DriverManager.getConnection("jdbc:derby:/home/i-64/Downloads/mydb;create=true;","mrunal","0348");
			PreparedStatement ps = con.prepareStatement("select * from INSTA");
			ResultSet res = ps.executeQuery();
			
			while (res.next()) {
				InstagramUser u = new InstagramUser();
				u.setName(res.getString(1));
				u.setEmail(res.getString(2));
				u.setUsername(res.getString(3));				
				l.add(u);
			}
			
			String homedir = System.getProperty("user.home");
			File f = new File(homedir, "Downloads/mydata0.txt");
			
			FileOutputStream out = new FileOutputStream(f);
			for (InstagramUser usr: l) {
				
				String str = usr.getName() + " " + usr.getEmail() + " " + usr.getUsername();
				for (int i = 0; i < str.length(); i++)
					out.write(str.charAt(i));
				out.write('\n');
			}
			out.close();
		}
		catch (Exception/*SQLException|ClassNotFoundException|FileNotFoundException|IOException*/ e) {
			
			e.printStackTrace();
		}
		finally {
			
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

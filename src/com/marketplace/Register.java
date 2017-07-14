package com.marketplace;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dao.DBConnection;

public class Register {
	DBConnection con=new DBConnection();
	Connection connect= con.getconnection(); 
	PreparedStatement ps;
	public boolean doRegister(String firstName, String phone, String email, String add, String type ){
		 
		String sql = "insert into users(uname, phone,uemail,utype) values(?,?,?,?)";
		try {
			ps = connect.prepareStatement(sql);
			ps.setString(1, firstName);
			ps.setString(2, phone);
			ps.setString(3, email);
			ps.setString(4, type);
			
			ps.executeUpdate();
			System.out.println("******successfully registered*********");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
		
		
	}
	
	public String checkType(String firstName){
		String uType=null;
		String sql = "select utype from users where uname= ?";
		
		try {
			ps= connect.prepareStatement(sql);
			ps.setString(1, firstName);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				uType = rs.getString("utype");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return uType;
		
		
	}
	
	public int getID(String email){
		int uid;
		String sql = "select uid from users where uemail= ?";
		
		try {
			ps= connect.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				uid = rs.getInt("uid");
				
				System.out.println("inside get method"+uid);
				return uid;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
		
		
	}

	public void registerSeeker(int uid, int no_of_child, String spouse_name) {
		// TODO Auto-generated method stub
		String sql = "insert into seeker values(?, ?, ?)";
		try {
			ps= connect.prepareStatement(sql);
			ps.setInt(1, uid);
			ps.setInt(2, no_of_child);
			ps.setString(3, spouse_name);
			
			ps.executeUpdate();
			System.out.println("*****sseekers details inserted******");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	

	

}

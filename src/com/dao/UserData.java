package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Member;
import com.model.Seeker;
import com.model.Sitter;

public class UserData {
		private DBConnection con=new DBConnection();
	private Connection connect= con.getconnection(); 
	PreparedStatement ps;
	public boolean putUserData(Member mem){
		 
		String sql = "insert into users(uname, phone,uemail,utype) values(?,?,?,?)";
		try {
			ps = connect.prepareStatement(sql);
			ps.setString(1, mem.getFirstName());
			ps.setString(2, mem.getPhone());
			ps.setString(3, mem.getEmail());
			ps.setString(4, mem.getMemberType());
			
			ps.executeUpdate();
			System.out.println("******successfully registered*********");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return false;
		}
		
		
		
	}
	
	public String checkType(Member mem){
		String uType=null;
		String sql = "select utype from users where uname= ?";
		
		try {
			ps= connect.prepareStatement(sql);
			ps.setString(1, mem.getFirstName());
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

	public void registerSeeker(int uid, Seeker seeker) {
		// TODO Auto-generated method stub
		String sql = "insert into seeker values(?, ?, ?)";
		try {
			ps= connect.prepareStatement(sql);
			ps.setInt(1, uid);
			ps.setInt(2, seeker.getNoOfChilds());
			ps.setString(3, seeker.getSpouseName());
			
			ps.executeUpdate();
			System.out.println("*****Seekers details inserted******");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void registerSitter(int uid, Sitter sitter) {
		// TODO Auto-generated method stub
		
		String sql = "insert into sitter(sitter_id, years_of_exp, expected_pay) values(?, ?, ?)";
		try {
			ps= connect.prepareStatement(sql);
			ps.setInt(1, uid);
			ps.setInt(2, sitter.getYearsOfExperience());
			ps.setInt(3, sitter.getExpectedPay());
			
			ps.executeUpdate();
			System.out.println("*****Sitters details inserted******");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	public List listAllJobs() {
		// TODO Auto-generated method stub
		String sql = "select job_title from Jobs";
		List<String>  jobs= new ArrayList<>();
		
		try {
			ps= connect.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				jobs.add(rs.getString("job_title"));
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jobs;
		
	}
	
	public int getExpectedPay(int user_id){
		String sql = "select expected_pay from sitter where sitter_id = ?";
		int expected_pay = 0;
		try {
			ps= connect.prepareStatement(sql);
			ps.setInt(1, user_id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				expected_pay = rs.getInt("expected_pay");
			}
			return expected_pay;
		  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return expected_pay;
	}
	
	

	public boolean appliedForThisJob(int job_id,int user_id) {
		// TODO Auto-generated method stub
		int expected_pay=getExpectedPay(user_id);
		String sql = "insert into Application(jobId, Expected_pay, member_id) values(?, ? , ?)";
		
		try {
			ps= connect.prepareStatement(sql);
			ps.setInt(1, job_id);
			ps.setInt(2, expected_pay);
			ps.setInt(3, user_id);
			ps.executeUpdate();
		
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
		
	}

	public List<String> getAppliedJobs(int uid) {
		// TODO Auto-generated method stub
		String sql = "select job_title from Jobs where job_id IN (select jobId from Application where member_id=?)";
         List<String>  jobApplied= new ArrayList<>();
		
		try {
			ps= connect.prepareStatement(sql);
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				jobApplied.add(rs.getString("job_title"));
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jobApplied;
	
	}

	public boolean deleteApplication(String jobTitle, int uid) {
		// TODO Auto-generated method stub
		String sql = "delete from Application where jobId =(select job_id from Jobs where job_title=?) AND member_id=?";
		try {
			ps= connect.prepareStatement(sql);
			ps.setString(1, jobTitle);
			ps.setInt(2, uid);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return false;
	}

	public int checkPostedBy(String job_title) {
		// TODO Auto-generated method stub
		String sql = "select posted_by from Jobs where job_title=?";
		int postedBy=0;
		try {
			ps= connect.prepareStatement(sql);
			ps.setString(1,job_title);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
				postedBy = rs.getInt("posted_by");
			return postedBy;
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

}

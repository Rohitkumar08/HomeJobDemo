package com.dao;
import java.text.ParseException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Jobs {
	int jobId;
	static String jobTitle;
	static int postedBy;
	
	static String startDate;
	static String endDate;
	static String startTime;
	static String endTime;
	static int payPerHour;
	
	DBConnection con=new DBConnection();
	Connection connect= con.getconnection(); 
	PreparedStatement ps;
	String sql;
	
	
	public boolean createJob(int uid) {
		// TODO Auto-generated method stub
		
		Scanner sc= new Scanner(System.in);
		//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter Job Title: ");
		jobTitle=sc.nextLine();
		
		System.out.println("Enter Start date(\"dd/MM/yyyy\"): ");
		startDate =sc.nextLine();
//		try {
//			Date startdate = (Date) sdf.parse(startDate);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		System.out.println("Enter End date(\"dd/MM/yyyy\"): ");
		endDate = sc.next();
//		try {
//			Date enddate = (Date) sdf.parse(endDate);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		System.out.println("Enter Start Time: ");
		startTime = sc.next();
		
		
		System.out.println("Enter End time: ");
		endTime = sc.next();
		
		System.out.println("Enter pay per hour: ");
		payPerHour=sc.nextInt();
		
		sc.close();
		sql = "insert into Jobs(job_title, posted_by, start_date, end_date, start_time, end_time, pay_per_hour) values(?,?,?,?,?,?,?)";
		try {
			ps = connect.prepareStatement(sql);
			ps.setString(1, jobTitle);
			ps.setInt(2, uid);
			ps.setString(3, startDate);
			ps.setString(4, endDate);
			ps.setString(5, startTime);
			ps.setString(6,endTime);
			ps.setInt(7, payPerHour);
			
			ps.executeUpdate();
			System.out.println("*****JOB SUCCESSFULLY CREATED***********");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return false;
	}

	public void updateJob(String job_title, String updateParameter) {
		// TODO Auto-generated method stub
//		sql = "update "
		
		
		
		
	}

	public boolean deleteJob(String job_title, int uid) {
		
		// TODO Auto-generated method stub
		int posted_By=0;
		sql = "select posted_by from Jobs where job_title= ?";
		try {
			ps = connect.prepareStatement(sql);
			ps.setString(1, job_title);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				posted_By = rs.getInt("posted_by");
				System.out.println("Posted by:    "+posted_By);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(posted_By == uid){
			
			sql = "delete from Jobs where job_title= ?";
			try {
				ps = connect.prepareStatement(sql);
				ps.setString(1, job_title);
				ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		else
			return false;
		
		return true;
		
	
	}

	public boolean updateJobTitle(String job_title, String newJobTitle) {
		// TODO Auto-generated method stub
		sql = "update Jobs set job_title =? where job_title = ?";
		try {
			ps = connect.prepareStatement(sql);
			ps.setString(1, newJobTitle);
			ps.setString(2, job_title);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}

	public boolean updateJobStart(String job_title, String newStartDate) {
		// TODO Auto-generated method stub
		sql = "update Jobs set start_date = ? where job_title = ?";
		try {
			ps = connect.prepareStatement(sql);
			ps.setString(1, newStartDate);
			ps.setString(2, job_title);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateJobEnds(String job_title, String newEndDate) {
		// TODO Auto-generated method stub
		sql = "update Jobs set end_date = ? where job_title = ?";
		try {
			ps = connect.prepareStatement(sql);
			ps.setString(1, newEndDate);
			ps.setString(2, job_title);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	

}

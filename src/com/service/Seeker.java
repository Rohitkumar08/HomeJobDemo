package com.service;

import java.util.ArrayList;

import java.util.Scanner;

import com.dao.Jobs;
import com.dao.UserData;


public class Seeker{
	private static int noOfChilds;
	private static String spouseName;
	UserData userd = new UserData();
   
	public void goAsSeeker(String email, Scanner sc){
		
		int uid=userd.getID(email);
		
		System.out.println(uid);
		if(uid!=0)
		performSeekerTask(uid,sc);
		else{
			System.out.println("****NOT A VALID EMAIL*****");
			System.exit(0);
		}
			
		
	}
	
	public void fillSeekerDetails(int uid, Scanner sc){
		System.out.println("Enter no of Childs: ");
		noOfChilds = sc.nextInt();
		
		System.out.println("Enter spouse name: ");
		spouseName = sc.next();	 
		
		UserData rs = new UserData();
		rs.registerSeeker(uid,noOfChilds,spouseName);
	
	 }

	public void performSeekerTask(int uid, Scanner sc) {
		// TODO Auto-generated method stub
		Jobs job = new Jobs();
		//Scanner sc2 = new Scanner(System.in);
		System.out.println("***YOU ARE SEEKER ENTER YOUR CHOICE******");
		int ch;
		System.out.println("ENTER \"1\" TO CREATE A NEW JOB");
		System.out.println("ENTER \"2\" TO UPDATE A JOB");
		System.out.println("ENTER \"3\" TO DELETE A JOB");
		System.out.println("ENTER ANYTHING ELSE TO EXIT");
		ch = sc.nextInt();
		sc.nextLine();
		switch(ch){
		case 1:{
			System.out.println("******ENTER YOUR USER ID********");
			int temp_uid = sc.nextInt();
			if(temp_uid==uid){
				boolean jobCreated=job.createJob(uid);
				if(jobCreated)
					return ;
				
			}
			else
				System.out.println("*******NOT A VALID USER ID********");
			break;
		}
		case 2:{
			System.out.println("******ENTER THE JOB TITLE WHICH YOU WANT TO UPDATE*****");
			String job_title = sc.nextLine();
			ArrayList<String> alst = new ArrayList<>();
			alst.add("job_title");
			alst.add("start_date");
			alst.add("end_date");
		
			
			System.out.println("****HERE IS THE LIST OF PARAMETERS WITH WHICH YOU CAN UPDATE : ");
			for(String s:alst)
				System.out.println(s);
			
			System.out.println("ENTER PARAMETER WHICH YOU WANT TO UPDATE: ");
			String updateParameter = sc.next();
			if(updateParameter.equals("job_title")){
				
				System.out.println("ENTER NEW job_title: ");
				
				String newJobTitle = sc.next(); 
				boolean updated=job.updateJobTitle(job_title, newJobTitle);
				if(updated)
						System.out.println("*****JOB TITLE UPDATED SUCCESSFULLY******");
			}
			if(updateParameter.equals("start_date")){
					System.out.println("ENTER NEW start_date: ");
				
				String newStartDate = sc.next(); 
				boolean updated=job.updateJobStart(job_title, newStartDate);
				if(updated)
					System.out.println("*****JOB UPDATED SUCCESSFULLY******");
				
			}
			if(updateParameter.equals("end_date")){
				System.out.println("ENTER NEW end_Date: ");
				
				String newEndDate = sc.next(); 
				boolean updated=job.updateJobEnds(job_title, newEndDate);
				if(updated)
					System.out.println("*****JOB UPDATED SUCCESSFULLY******");
				
			}
			
			break;
		}
		case 3:{
			
			System.out.println("******ENTER THE JOB TITLE WHICH YOU WANT TO DELETE*****");
			String job_title  = sc.next();
			boolean deleted=job.deleteJob(job_title,uid);
			if(deleted)
				System.out.println("*******JOB DELETED SUCCESSFULLY*********");
			else
				System.out.println("***YOU ARE NOT AUTHORIZED TO DELETE THIS JOB****");
			
			break;
		}
		default:
			return;
		
		}
		
	}
	

}

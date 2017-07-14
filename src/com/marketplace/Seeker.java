package com.marketplace;

import java.util.Scanner;

public class Seeker extends Member {
	int noOfChilds;
	String spouseName;
	Scanner sc= new Scanner(System.in);
	public void fillSeekerDetails(int uid){
		System.out.println("Enter no of Childs: ");
		noOfChilds = sc.nextInt();
		
		System.out.println("Enter spouse name: ");
		spouseName = sc.nextLine();	 
		
		Register rs = new Register();
		rs.registerSeeker(uid,noOfChilds,spouseName);
	
	 }

	public void performSeekerTask(int uid) {
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
		switch(ch){
		case 1:{
			System.out.println("******ENTER YOUR USER ID********");
			int temp_uid = sc.nextInt();
			if(temp_uid==uid)
				job.createJob(uid);
			else
				System.out.println("*******NOT A VALID USER ID********");
			break;
		}
		case 2:{
			System.out.println("******ENTER THE JOB TITLE WHICH YOU WANT TO UPDATE*****");
			String job_title = sc.nextLine();
			job.updateJob(job_title);
			break;
		}
		case 3:{
			
			System.out.println("******ENTER THE JOB TITLE WHICH YOU WANT TO DELETE*****");
			String job_title  = sc.next();
			boolean deleted=job.deleteJob(job_title,uid);
			if(deleted)
				System.out.println("*******JOB DELETED SUCCESSFULLY*********");
			
			break;
		}
		default:
			return;
		
		}
		
	}
	

}

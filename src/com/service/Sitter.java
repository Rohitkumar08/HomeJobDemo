package com.service;

import java.util.List;
import java.util.Scanner;

import com.dao.UserData;
import com.marketplace.MainClass;

public class Sitter extends MainClass{
	int yearsOfExperience;
	int expectedPay;
	UserData usrdata = new UserData();
	public void performSitterTask(int uid) {
		// TODO Auto-generated method stub
		
	}
	
	public void goAsSitter(String email,Scanner sc){
		
		int uid=usrdata.getID(email);
		performSitterTask(uid,sc);
		
		
	}

	public void fillSitterDetails(int uid, Scanner sc) {
		// TODO Auto-generated method stub
		
		System.out.println("ENTER YEARS OF EXPERIENCE: ");
		yearsOfExperience= sc.nextInt();
		
		System.out.println("ENTER YOUR EXPECTED PAY: ");
		expectedPay= sc.nextInt();
		usrdata.registerSitter(uid, yearsOfExperience, expectedPay);
		
		
	}

	public void performSitterTask(int uid, Scanner sc) {
		// TODO Auto-generated method stub
		
		System.out.println("****YOU ARE A SITTER WANT TO APPLY FOR A JOB (Y/N)****");
		char ch;
		ch =sc.next(".").charAt(0);;
		if(ch =='Y'){
			System.out.println("HERE IS THE LIST OF JOB-TITLES ALONG WITH JOB-ID:  ");
			List<String> jobs=usrdata.listAllJobs();
			int i=1;
			for(String s:jobs){
				System.out.println(s + " : "+ i);
				i++;
			}
			System.out.println("ENTER CORRESPONDING JOB-ID FOR WHICH YOU WANT TO APPLY:  ");
			int job_id = sc.nextInt();
			boolean check=usrdata.appliedForThisJob(job_id,uid);
			
			if(check){
				System.out.println("*********THANKS!!! YOU SUCCESSFULLY APPLIED FOR THIS JOB***********");
			}
			else{
				System.out.println("*******SOME EROOR OCCURRED********");
			}
		
			
		}
		else
			System.exit(1);
		
	}
	
	

}

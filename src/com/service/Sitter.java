package com.service;

import java.util.ArrayList;
import java.util.HashMap;
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
		do{
			System.out.println("****YOU ARE A SITTER ENTER YOUR CHOICE****");
			System.out.println("ENTER \"1\" TO APPLY FOR A JOB");
			System.out.println("ENTER \"2\" TO SEE ALL JOBS");
			System.out.println("ENTER \"3\" TO DELETE AN APPLICATION");
			System.out.println("ENTER ANYTHING ELSE TO EXIT");
			int ch;
			ch = sc.nextInt();
			switch(ch){
			
			case 1:{
				System.out.println("***HERE IS THE LIST OF JOB-TITLES ALONG WITH JOB-ID***  ");
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
				break;
			}
			case 2:{
				
				System.out.println("***HERE IS THE LIST OF JOB-TITLES ALONG WITH JOB-ID***  ");
				List<String> jobs=usrdata.listAllJobs();
				int i=1;
				for(String s:jobs){
					System.out.println(s + " : "+ i);
					i++;
				}
				break;
			}
				
			case 3:
			{
				System.out.println("***HERE IS THE LIST OF JOB-TITLES ALONG WITH JOB-ID WHICH YOU HAVE APPLIED***  ");
				List<String> jobsApplied = usrdata.getAppliedJobs(uid);
				int i=1;
				HashMap<Integer, String> hmap = new HashMap<>();
				
				for(String s:jobsApplied){
					hmap.put(i,s);
					System.out.println(i + " : "+ s);
					i++;
				}
				System.out.println("****ENTER CORRESPONDING APPLICATION ID WHICH YOU WANT TO DELETE*****");
				int id = sc.nextInt();
				String jobTitle = hmap.get(i);
				boolean deleteApp = usrdata.deleteApplication(jobTitle,uid);
				if(deleteApp)
					System.out.println("*****SUCCESSFULLY DELETED THE APPLICATION*****");
				
			 }
			default:
				return;
			}//for switch case
			
		}while(true);
		
		
	}
	
	

}

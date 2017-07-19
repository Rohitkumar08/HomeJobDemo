package com.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.dao.Jobs;
import com.dao.UserData;
import com.model.Member;
import com.model.Seeker;
import com.model.Sitter;
import com.validations.validation;

public class ServiceImp implements ServiceInt {

	
	UserData ud = new UserData();
	validation validate = new validation();
	Sitter sitter= new Sitter();
	Seeker seeker = new Seeker();
	//for registration
	public void doRegister(Scanner sc,Member mem){
	
		do{
			System.out.println("Enter First Name: ");
			mem.setFirstName(sc.nextLine());
		}while(!validate.validateName(mem));
		
		do{
			System.out.println("Enter Mobile no: ");
			mem.setPhone(sc.nextLine());
		}while(!validate.validatePhone(mem));
		
//		sc.nextLine();
		do{
			System.out.println("Enter Email: ");
			mem.setEmail(sc.nextLine());
		}while(!validate.validateEmail(mem));
		
		
		System.out.println("Enter Address: ");
		mem.setAdd(sc.nextLine());
		
		System.out.println("Enter Member Type: ");
		mem.setMemberType(sc.nextLine());
		//sc.close();
		
		boolean registered=ud.putUserData(mem);
		if(registered){
			String uType = ud.checkType(mem);
			int uid = ud.getID(mem.getEmail());
			if(uType.equals("sitter")){
					//TODO sitter operations
				fillSitterDetails(uid,sc);
				performSitterTask(uid,sc);
			}
			else{
				
				fillSeekerDetails(uid,sc);
				performSeekerTask(uid,sc);
			
			}
		
	}
		else{
			System.out.println("****EMAIL ID ALREADY EXISTS****");
		}
	
  }
	
	
	public void performSeekerTask(int uid, Scanner sc) {
		// TODO Auto-generated method stub
		Jobs job = new Jobs();
		//Scanner sc2 = new Scanner(System.in);
		System.out.println("***YOU ARE SEEKER ENTER YOUR CHOICE******");
		
		do{
			
			System.out.println("ENTER \"1\" TO CREATE A NEW JOB");
			System.out.println("ENTER \"2\" TO UPDATE A JOB");
			System.out.println("ENTER \"3\" TO DELETE A JOB");
			System.out.println("ENTER ANYTHING ELSE TO EXIT");
			int ch;
			ch = sc.nextInt();
			switch(ch){
			
			//for creating a anew job
			case 1:{
				System.out.println("******ENTER YOUR USER ID********");
				int temp_uid = sc.nextInt();
				
				if(temp_uid<0)
					System.out.println("******NOT A VALID USER******");
				if(temp_uid==uid)
				{
					boolean jobCreated=job.createJob(uid,sc);
					if(jobCreated){
						
						System.out.println("*****JOB SUCCESSFULLY CREATED***********");
						System.out.println("*****PRESS ENTER FOR MORE OPTION***********");
						sc.nextLine();
					}
						
					
				}
				else
					System.out.println("*******INCORRECT USER ID********");
				
				break;
			}
			
			//for updating a job
			case 2:{
				System.out.println("******ENTER THE JOB TITLE WHICH YOU WANT TO UPDATE*****");
				sc.nextLine();
				String job_title = sc.nextLine();
				
				int postedby = ud.checkPostedBy(job_title);
				if(postedby==uid){
					System.out.println("****HERE IS THE LIST OF PARAMETERS WITH WHICH YOU CAN UPDATE : ");
					ArrayList<String> alst = new ArrayList<>();
					alst.add("job_title");
					alst.add("start_date");
					alst.add("end_date");
					for(String s:alst)
						System.out.println(s);
					
					System.out.println("ENTER PARAMETER WHICH YOU WANT TO UPDATE: ");
					String updateParameter = sc.nextLine();
					if(updateParameter.equals("job_title")){
						
						System.out.println("ENTER NEW job_title: ");
						
						String newJobTitle = sc.nextLine(); 
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
					
				}
				else{
					System.out.println("***YOU ARE NOT AUTHORIZED TO UPDATE THIS JOB****");
				}
				
				break;
			}
			
			//for deletion of a job
			case 3:{
				System.out.println("****HERE IS THE LIST OF ALL JOBS: ");
				@SuppressWarnings("unchecked")
				List<String> jobs=ud.listAllJobs();
				int i=1;
				for(String s:jobs){
					System.out.println(i + ": "+ s);
					i++;
				}
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
		}while(true);
	
		
	}
	//fill sitter details
	public void fillSitterDetails(int uid, Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("ENTER YEARS OF EXPERIENCE: ");
		sitter.setYearsOfExperience(sc.nextInt());
		
		System.out.println("ENTER YOUR EXPECTED PAY: ");
		sitter.setExpectedPay(sc.nextInt());
		ud.registerSitter(uid, sitter);
		
		
	}
		
	//perform sitter tasks
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
				List<String> jobs=ud.listAllJobs();
				int i=1;
				for(String s:jobs){
					System.out.println(i + ": "+ s);
					i++;
				}
				System.out.println("ENTER CORRESPONDING JOB-ID FOR WHICH YOU WANT TO APPLY:  ");
				int job_id = sc.nextInt();
				boolean check=ud.appliedForThisJob(job_id,uid);
				
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
				List<String> jobs=ud.listAllJobs();
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
				List<String> jobsApplied = ud.getAppliedJobs(uid);
				int i=1;
				HashMap<Integer, String> hmap = new HashMap<>();
				
				for(String s:jobsApplied){
					hmap.put(i,s);
					System.out.println(i + " : "+ s);
					i++;
				}
				boolean completed = true;
				while(completed){
					System.out.println("****ENTER CORRESPONDING APPLICATION ID WHICH YOU WANT TO DELETE*****");
					int id = sc.nextInt();
					if(hmap.containsKey(id)){
						
						String jobTitle = hmap.get(id);
						System.out.println(jobTitle);
						boolean deleteApp = ud.deleteApplication(jobTitle,uid);
						if(deleteApp)
							System.out.println("*****SUCCESSFULLY DELETED THE APPLICATION*****");
							completed=false;
					}
					else{
						System.out.println("*****NOT A VALID APPLICATION ID********");
						
					}
				
				}
				
				
			 }
			default:
				return;
			}//for switch case
			
		}while(true);
		
		
	}
	
	//go as sitter
	public void goAsSitter(String email,Scanner sc){
		
		int uid=ud.getID(email);
		if(uid==0){
			System.out.println("*****NOT A VALID MEMEBER PLEASE REGISTER FIRST*****");
		}
		else
		performSitterTask(uid,sc);
		
		
	}
	public void goAsSeeker(String email, Scanner sc){
	
	int uid=ud.getID(email);
	
	System.out.println(uid);
	if(uid!=0)
	performSeekerTask(uid,sc);
	else{
		System.out.println("****NOT A VALID EMAIL*****");
		
	}
		
	
}
	public void fillSeekerDetails(int uid, Scanner sc){
	System.out.println("Enter no of Childs: ");
	seeker.setNoOfChilds(sc.nextInt());
	
	System.out.println("Enter spouse name: ");
	seeker.setSpouseName(sc.next());	 

	ud.registerSeeker(uid,seeker);

 }

}

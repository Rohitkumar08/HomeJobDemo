package com.marketplace;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.dao.DBConnection;

public class Member {
	static int memberId;
	static String firstName;
	static String phone;
	static String email;
	static String add;
	static String memberType;
	
	
	public static int getMemberId() {
		return memberId;
	}


	public static void setMemberId(int memberId) {
		Member.memberId = memberId;
	}


	public static String getFirstName() {
		return firstName;
	}


	public static void setFirstName(String firstName) {
		Member.firstName = firstName;
	}

	public static String getPhone() {
		return phone;
	}


	public static void setPhone(String phone) {
		Member.phone = phone;
	}


	public static String getEmail() {
		return email;
	}


	public static void setEmail(String email) {
		Member.email = email;
	}


	public static String getAdd() {
		return add;
	}


	public static void setAdd(String add) {
		Member.add = add;
	}


	public static String getMemberType() {
		return memberType;
	}


	public static void setMemberType(String memberType) {
		Member.memberType = memberType;
	}


	public static void main(String []args){
		
		Scanner sc= new Scanner(System.in);
		Seeker seeker = new Seeker();
		Sitter sitter = new Sitter();
		Jobs job = new Jobs();
		Register reg = new Register();
		int ch;
		
		System.out.println("ENTER \"1\" FOR NEW REGISTRATION");
		System.out.println("ENTER \"2\" FOR LOGIN AS SEEKER");
		System.out.println("ENTER \"3\" FOR LOGIN AS SITTER");
		System.out.println("ENTER \"4\" FOR EXIT");
		ch = sc.nextInt();
		
		
		switch(ch){
		
		case 1:{
			
			System.out.println("Enter First Name: ");
			firstName= sc.nextLine();
			
			System.out.println("Enter Mobile no: ");
			phone= sc.nextLine();
			
			System.out.println("Enter Email: ");
			email= sc.nextLine();
			
			System.out.println("Enter Address: ");
			add= sc.nextLine();
			
			System.out.println("Enter Member Type: ");
			memberType= sc.nextLine();
			sc.close();
			
			
			
			boolean registered=reg.doRegister(firstName, phone, email, add, memberType);
			if(registered){
				String uType = reg.checkType(firstName);
				int uid = reg.getID(email);
				if(uType=="sitter"){
						//TODO sitter operations
				}
				else{
					
					seeker.fillSeekerDetails(uid);
					seeker.performSeekerTask(uid);
				
				}
			}
			break;
		   }
		case 2:{
			System.out.println("Enter Email: ");
			String email = sc.next();
			
			int uid=reg.getID(email);
			System.out.println(uid);
			seeker.performSeekerTask(uid);
			
			break;
		   }
		case 3:{
			
			System.out.println("Enter Email: ");
			String email = sc.next();
			
			int uid=reg.getID(email);
			sitter.performSitterTask(uid);
			
			break;	
		   }
		case 4:
			return;
		
		}      //switch case ends here
	}			//main method ends here

}

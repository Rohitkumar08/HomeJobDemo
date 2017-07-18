package com.service;

import java.util.Scanner;

import com.dao.UserData;
import com.validations.validation;

public class Member {
	
	public static String firstName;
	public static String phone;
	public static String email;
	public static String add;
	public static String memberType;
	
	Seeker seeker = new Seeker();
	Sitter sitter = new Sitter();
	
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


	
	UserData ud = new UserData();
	validation validate = new validation();
	
	//for registration
	public void doRegister(Scanner sc){
	
		do{
			System.out.println("Enter First Name: ");
			firstName= sc.nextLine();
		}while(!validate.validateName(firstName));
		
		do{
			System.out.println("Enter Mobile no: ");
			phone= sc.nextLine();
		}while(!validate.validatePhone(phone));
		
//		sc.nextLine();
		do{
			System.out.println("Enter Email: ");
			email= sc.nextLine();
		}while(!validate.validateEmail(email));
		
		
		System.out.println("Enter Address: ");
		add= sc.nextLine();
		
		System.out.println("Enter Member Type: ");
		memberType= sc.nextLine();
		//sc.close();
		
		boolean registered=ud.putUserData(firstName, phone, email, add, memberType);
		if(registered){
			String uType = ud.checkType(firstName);
			int uid = ud.getID(email);
			if(uType.equals("sitter")){
					//TODO sitter operations
				sitter.fillSitterDetails(uid,sc);
				sitter.performSitterTask(uid,sc);
				
				
			}
			else{
				
				seeker.fillSeekerDetails(uid,sc);
				seeker.performSeekerTask(uid,sc);
			
			}
		
	}
	
  }
}

package com.marketplace;

import java.util.Scanner;

import com.dao.Jobs;
import com.dao.UserData;
import com.service.Member;
import com.service.Seeker;
import com.service.Sitter;

public class MainClass {
	
	static Scanner sc= new Scanner(System.in);

	public static void main(String []args){
		
		
		Seeker seeker = new Seeker();
		Sitter sitter = new Sitter();
	
		Member reg = new Member();
		int ch;
		
		System.out.println("ENTER \"1\" FOR NEW REGISTRATION");
		System.out.println("ENTER \"2\" FOR LOGIN AS SEEKER");
		System.out.println("ENTER \"3\" FOR LOGIN AS SITTER");
		System.out.println("ENTER \"4\" FOR EXIT");
		ch = sc.nextInt();
		sc.nextLine();
		
		switch(ch){
		
		case 1:{
			   reg.doRegister(sc);
	
			break;
		   }
		case 2:{
			System.out.println("Enter Email: ");
			String email = sc.next();
			
			seeker.goAsSeeker(email, sc);
			break;
		   }
		case 3:{
			
			System.out.println("Enter Email: ");
			String email = sc.next();
			
			sitter.goAsSitter(email,sc);
		
			break;	
		   }
		case 4:
			System.exit(0);
		
		}      //switch case ends here
	}			//main method ends here

}

package com.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class validation {
	
	public boolean validateName(String firstName){
//		char[] arr = firstName.toCharArray();
		Pattern p = Pattern.compile("[0-9]");
		Matcher m = p.matcher(firstName);
		boolean b = m.find();
		//System.out.println(b);
		if(b){
			System.out.println("***Enter valid name*****");
			return false;
		}
		
		else
			return true;
	}
	
	public boolean validatePhone(){
		
		
		return false;
	}
	public boolean validateEmail(String email){
		
		
		return false;
	}

}

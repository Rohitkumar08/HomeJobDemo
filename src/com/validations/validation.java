package com.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.model.Member;

public class validation {
	
	public boolean validateName(Member mem){
//		char[] arr = firstName.toCharArray();
		Pattern p = Pattern.compile("[0-9]");
		Matcher m = p.matcher(mem.getFirstName());
		boolean b = m.find();
		//System.out.println(b);
		if(b){
			System.out.println("***Enter valid name*****");
			return false;
		}
		
		else
			return true;
	}
	
	
	//VAlidation for Phone no
	public boolean validatePhone(Member mem){
		
//		Pattern p = Pattern.compile("\\d{3}");
//		Matcher m = p.matcher(phone);
	
//		if(b){
//			System.out.println("***Enter valid Mobile no with 10 digits*****");
//			return false;
//		}
//		
//		else
//			return true;
		
		if (mem.getPhone().matches("\\d{10}")) 
			return true;
		
	      else
	      {
	    	  System.out.println("Phone Number must be in the form XXX-XXXXXXX");
	    	  return false;
	      }
		
	}
	
	//validation for Email
	
	public boolean validateEmail(Member mem){
		final String EMAIL_REGEX="^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})";
	    //static Pattern object, since pattern is fixed
	    Pattern pattern;
	    //non-static Matcher object because it's created from the input String
	    Matcher matcher;
	    pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
	    matcher = pattern.matcher(mem.getEmail());
	    if(matcher.matches()){
	    	return true;
	    }
	    else{
	    	System.out.println("*******PLEASE ENTER VALID EMAIL ADD******");
	    	return false;
	    }
		
	}

	

}

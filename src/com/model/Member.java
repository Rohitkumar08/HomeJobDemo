package com.model;

import java.util.Scanner;

import com.dao.UserData;
import com.validations.validation;

public class Member {
	
	private  String firstName;
	private String phone;
	private String email;
	private String add;
	private  String memberType;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public String getMemberType() {
		return memberType;
	}
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}
	public Seeker getSeeker() {
		return seeker;
	}
	public void setSeeker(Seeker seeker) {
		this.seeker = seeker;
	}
	public Sitter getSitter() {
		return sitter;
	}
	public void setSitter(Sitter sitter) {
		this.sitter = sitter;
	}
	Seeker seeker = new Seeker();
	Sitter sitter = new Sitter();
	
	}

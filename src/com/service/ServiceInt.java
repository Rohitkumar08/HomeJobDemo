package com.service;


import java.util.Scanner;

import com.model.Member;

public interface ServiceInt {

 public	void doRegister(Scanner scm,Member mem);
 
 public void goAsSeeker(String email, Scanner sc);
 public void fillSeekerDetails(int uid, Scanner sc);
 public void performSeekerTask(int uid, Scanner sc);

 public void goAsSitter(String email,Scanner sc);
public void fillSitterDetails(int uid, Scanner sc);
public void performSitterTask(int uid, Scanner sc);



}

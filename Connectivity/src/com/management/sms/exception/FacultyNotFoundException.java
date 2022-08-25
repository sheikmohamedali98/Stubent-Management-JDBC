package com.management.sms.exception;

@SuppressWarnings("serial")
public class FacultyNotFoundException extends Exception {
 private int Facultyid;
	public FacultyNotFoundException(int Facultyid) {
		this.Facultyid = Facultyid;
	}
	public String toString(){
		return "Faculty Not Found Exception"+this.Facultyid;
	}
}

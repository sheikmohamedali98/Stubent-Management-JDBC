package com.management.sms.exception;

@SuppressWarnings("serial")
public class StudentNotFoundException extends Exception {
	private int sid;

	public StudentNotFoundException(int sid) {
		this.sid = sid;
	}
	public String toString(){
		return "Student Not Found Exception "+this.sid;
	}

}

package com.student.sms.dto;

public class Student {
	private int sid;
	private int age;
	private String sname;
	private String gender;
	private String saddress;
//	enum Gender{
//		MALE,FEMALE
//	};
	private int sattends;
	private String sphone;
	
	public Student() {
		super();
	}

	public Student(int sid, String sname,int age, String gender, String saddress,
			int sattends,String sphone) {
		super();
		this.sid = sid;
		this.age = age;
		this.sname = sname;
		this.gender = gender;
		this.saddress = saddress;
		this.sattends = sattends;
		this.sphone = sphone;
	}
	
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSphone() {
		return sphone;
	}
	public void setSphone(String sphone) {
		this.sphone = sphone;
	}
	public String getSaddress(){
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	public int getSattends() {
		return sattends;
	}
	public void setSattends(int sattends) {
		this.sattends = sattends;
	}

}
                      

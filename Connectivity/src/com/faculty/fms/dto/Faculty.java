package com.faculty.fms.dto;

import com.course.cms.dto.CourseDAOmysqlImpl;
import com.management.ms.common.Person;
import com.management.ms.common.TimeUtil;


public class Faculty extends Person {
	private int facultyid;
	private String facultyname;
	private String facultygender;
	// private String taddress;
	private String qalification;
	private String exprience;
	private int facultyattends;
	private String subject;
	private String position;
	private String facultyphone;
	private String joineddate;

	public Faculty() {
		super();
	}
	
	public Faculty(int facultyid, String facultyname, String facultygender,
			String qalification, String exprience, int facultyattends,
			String subject, String position, String facultyphone,
			String joineddate) {
		super();
		this.facultyid = facultyid;
		this.facultyname = facultyname;
		this.facultygender = facultygender;
		this.qalification = qalification;
		this.exprience = exprience;
		this.facultyattends = facultyattends;
		this.subject = subject;
		this.position = position;
		this.facultyphone = facultyphone;
		this.joineddate = joineddate;
	}


	public String getCourseName() {
		return new CourseDAOmysqlImpl().getCoursename(this.getCourseCode());
	}

	

	public String getJoineddate() {
		return joineddate;
	}

	public void setJoineddate(String joineddate) {
		this.joineddate = joineddate;
	}

	public String generateJoinedDate() {
		joineddate = TimeUtil.getCurrentTime();
		return joineddate;
	}

	public int getFacultyattends() {
		return facultyattends;
	}

	public void setFacultyattends(int facultyattends) {
		this.facultyattends = facultyattends;
	}

	public int getFacultyid() {
		return facultyid;
	}

	public void setFacultyid(int facultyid) {
		this.facultyid = facultyid;
	}

	public String getFacultyname() {
		return facultyname;
	}

	public void setFacultyname(String facultyname) {
		this.facultyname = facultyname;
	}

	public String getQalification() {
		return qalification;
	}

	public void setQalification(String qalification) {
		this.qalification = qalification;
	}

	public String getExprience() {
		return exprience;
	}

	public void setExprience(String exprience) {
		this.exprience = exprience;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getFacultyphone() {
		return facultyphone;
	}

	public String getFacultygender() {
		return facultygender;
	}

	public void setFacultygender(String facultygender) {
		this.facultygender = facultygender;
	}

	public void setFacultyphone(String facultyphone) {
		this.facultyphone = facultyphone;
	}

}
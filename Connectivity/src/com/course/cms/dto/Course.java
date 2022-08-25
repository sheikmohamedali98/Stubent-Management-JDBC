package com.course.cms.dto;

public class Course {
	private String coursecode;
	private int semyear;
	private boolean isDeclared;
	private String coursename;

	public String getCourseCode() {
		return coursecode;
	}

	public void setCourseCode(String coursecode) {
		this.coursecode = coursecode;
	}

	public int getSemYear() {
		return semyear;
	}

	public void setSemYear(int semyear) {
		this.semyear = semyear;
	}

	public boolean getIsDeclared() {
		return isDeclared;
	}

	public void setIsDeclared(boolean isDeclared) {
		this.isDeclared = isDeclared;
	}

	public String getCoursename() {
		return coursename!= null?coursename:new CourseDAOmysqlImpl().getCoursename(coursecode);
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}


}

package com.Subject.subms.dto;

import com.course.cms.dto.Course;

public class Subject extends Course {
	
	private String subjectname;
	private String subjectcode;
	private int maxsemmark =0;
	private int maxinternalmark =0;
	private String subjecttype;
	
	public void setSemYear(int semyear){
		super.setSemYear(semyear);
	}
	
	public String getSubjectname() {
		return subjectname;
	}
	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}
	public String getSubjectcode() {
		return subjectcode;
	}
	public void setSubjectcode(String subjectcode) {
		this.subjectcode = subjectcode;
	}
	public int getMaxsemmark() {
		return maxsemmark;
	}
	public void setMaxsemmark(int maxsemmark) {
		this.maxsemmark = maxsemmark;
	}
	public int getMaxinternalmark() {
		return maxinternalmark;
	}
	public void setMaxinternalmark(int maxinternalmark) {
		this.maxinternalmark = maxinternalmark;
	}
	public String getSubjecttype() {
		return subjecttype;
	}
	public void setSubjecttype(String subjecttype) {
		this.subjecttype = subjecttype;
	}

}

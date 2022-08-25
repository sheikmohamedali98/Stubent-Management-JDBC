package com.Subject.subms.service;

import java.sql.ResultSet;

import com.Subject.subms.dto.Subject;

public interface SubjectService {
	public abstract int getMaxsemMarkOfSubject(String subjectcode);
	public abstract int getMaxInternalMarkOfSubject(String subjectcode);
	
	public abstract String createSubjectcode(String Coursecode, int sem);
	public abstract String getSubjectName(String subjectcode);
	public abstract String getSubjectCode(String coursecode, int sem, String subjectname);
	
	public abstract boolean addSubject(Subject su);
	public abstract ResultSet getSubjectInfo(String coursecode, int sem);

}

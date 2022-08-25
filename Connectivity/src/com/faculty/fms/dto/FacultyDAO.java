package com.faculty.fms.dto;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.management.sms.exception.FacultyNotFoundException;



public interface FacultyDAO {
	

	public abstract int getTotalFaculty();
	public abstract int getFaculty(String coursecode, int sem);
	
	public abstract boolean isActive(String facultyid);
	public abstract boolean addFaculty(Faculty f);
	public abstract boolean updateFacultyData(Faculty f);
	public abstract boolean deleteFaculty(int facultyid);
	
	public abstract String getFacultyName(String facultyid) throws FacultyNotFoundException;
	
	public abstract ResultSet getFAcultyInfo(String condition);
	public abstract ArrayList<Faculty> getTotalFaculty(String condition);
	
	public abstract void setActiveStatus(boolean activestatus, int facultyid);

}

package com.faculty.fms.service;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.faculty.fms.dto.Faculty;
import com.faculty.fms.dto.FacultyDAO;
import com.faculty.fms.dto.FacultyDAOmysqlImpl;
import com.management.sms.exception.FacultyNotFoundException;

public class FacultyServiceImpl implements FacultyService{
	
	private FacultyDAO fadao = new FacultyDAOmysqlImpl();

	@Override
	public int getTotalFaculty() {
		return fadao.getTotalFaculty();
	}

	@Override
	public int getFaculty(String coursecode, int sem) {
		return fadao.getFaculty(coursecode, sem);
	}

	@Override
	public boolean isActive(String facultyid) {
		fadao.isActive(facultyid);
		return true;
	}

	@Override
	public boolean addFaculty(Faculty f) {
		fadao.addFaculty(f);
		return true;
		
	}

	@Override
	public boolean updateFacultyData(Faculty f) {
		fadao.updateFacultyData(f);
		return true;
	}

	@Override
	public boolean deleteFaculty(int facultyid) {
		fadao.deleteFaculty(facultyid);
		return true;
	}

	@Override
	public String getFacultyName(String facultyid)
			throws FacultyNotFoundException {
		return fadao.getFacultyName(facultyid);
	}

	@Override
	public ResultSet getFAcultyInfo(String condition) {
		return fadao.getFAcultyInfo(condition);
	}

	@Override
	public ArrayList<Faculty> getTotalFaculty(String condition) {
		return fadao.getTotalFaculty(condition);
	}

	@Override
	public void setActiveStatus(boolean activestatus, int facultyid) {
		fadao.setActiveStatus(activestatus, facultyid);
	}

}

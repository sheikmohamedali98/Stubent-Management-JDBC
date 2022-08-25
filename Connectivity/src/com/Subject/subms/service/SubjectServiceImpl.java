package com.Subject.subms.service;

import java.sql.ResultSet;

import com.Subject.subms.dto.Subject;
import com.Subject.subms.dto.SubjectDAO;
import com.Subject.subms.dto.SubjectDAOmysqlImpl;

public class SubjectServiceImpl implements SubjectService{
	private SubjectDAO subdao = new SubjectDAOmysqlImpl();

	@Override
	public int getMaxsemMarkOfSubject(String subjectcode) {
		return subdao.getMaxsemMarkOfSubject(subjectcode);
	}

	@Override
	public int getMaxInternalMarkOfSubject(String subjectcode) {
		// TODO Auto-generated method stub
		return subdao.getMaxInternalMarkOfSubject(subjectcode);
	}

	@Override
	public String createSubjectcode(String Coursecode, int sem) {
		return subdao.createSubjectcode(Coursecode, sem);
	}

	@Override
	public String getSubjectName(String subjectcode) {
		return subdao.getSubjectName(subjectcode);
	}

	@Override
	public String getSubjectCode(String coursecode, int sem, String subjectname) {
		return subdao.getSubjectCode(coursecode, sem, subjectname);
	}

	@Override
	public boolean addSubject(Subject su) {
		subdao.addSubject(su);
		return true;
	}

	@Override
	public ResultSet getSubjectInfo(String coursecode, int sem) {
		return subdao.getSubjectInfo(coursecode, sem);
	}

}

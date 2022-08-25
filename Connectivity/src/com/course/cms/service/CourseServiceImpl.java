package com.course.cms.service;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.course.cms.dto.Course;
import com.course.cms.dto.CourseDAO;
import com.course.cms.dto.CourseDAOmysqlImpl;

public class CourseServiceImpl implements CourseService{
	private CourseDAO coudo = new CourseDAOmysqlImpl();

	@Override
	public boolean addCourse(String coursecode, String coursename,
			String semyear, int totalyear) {
		coudo.addCourse(coursecode, coursename, semyear, totalyear);
		return false;
	}

	@Override
	public boolean isDeclared(String coursecode, int semyear) {
		coudo.isDeclared(coursecode, semyear);
		return true;
	}

	@Override
	public boolean updateResult(Course c) {
		coudo.updateResult(c);
		return true;
	}

	@Override
	public String getCoursecode(String coursename) {
		return coudo.getCoursecode(coursename);
	}

	@Override
	public String getCoursename(String coursecode) {
		return coudo.getCoursename(coursecode);
	}

	@Override
	public ResultSet getCourseInfo() {
		return coudo.getCourseInfo();
	}

	@Override
	public ArrayList<Course> getCoursesForDeclareResult(String coursename) {
		return coudo.getCoursesForDeclareResult(coursename);
	}

}

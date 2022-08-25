package com.course.cms.service;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.course.cms.dto.Course;

public interface CourseService {
	public abstract boolean addCourse(String coursecode, String coursename,String semyear, int totalyear);
	public abstract boolean isDeclared(String coursecode,int semyear);
	public abstract boolean updateResult(Course c);

	public abstract String getCoursecode(String coursename);
	public abstract String getCoursename(String coursecode);

	public abstract ResultSet getCourseInfo();

	public abstract ArrayList<Course> getCoursesForDeclareResult(String coursename);
}

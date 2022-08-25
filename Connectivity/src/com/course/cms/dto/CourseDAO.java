package com.course.cms.dto;

import java.sql.ResultSet;
import java.util.ArrayList;

public interface CourseDAO {
	
public abstract boolean addCourse(String coursecode, String coursename,String semyear, int totalyear);
public abstract boolean isDeclared(String coursecode,int semyear);
public abstract boolean updateResult(Course c);

public abstract String getCoursecode(String coursename);
public abstract String getCoursename(String coursecode);

public abstract ResultSet getCourseInfo();

public abstract ArrayList<Course> getCoursesForDeclareResult(String coursename);
}

package com.course.cms.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.student.sms.server.Server;

public class CourseDAOmysqlImpl implements CourseDAO {
	private Connection cn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	public static final String INSERT_COMMAND = "INSERT INTO course VALUES(?,?,?,?,?)";

	public CourseDAOmysqlImpl() {

		try {
			cn = DriverManager.getConnection(Server.URL, Server.USERNAME,
					Server.PASSWORD);
		} catch (SQLException e) {
			System.out.println("Server Cannot Connet...:(");
			e.printStackTrace();
		}
	}

	@Override
	public boolean addCourse(String coursecode, String coursename,
			String semyear, int totalyear) {
		@SuppressWarnings("unused")
		int count = 0;
		try {
			ps = cn.prepareStatement(INSERT_COMMAND);
			ps.setInt(1, 0);
			ps.setString(2, coursecode.toUpperCase());
			ps.setString(3, coursename);
			ps.setString(4, semyear);
			ps.setInt(6, totalyear);
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return true;
	}

	@Override
	public ResultSet getCourseInfo() {
		rs = null;
		try {
			ps = cn.prepareStatement("SELECT c.sr_no AS 'Index_no',c.coursecode AS 'Course_Code',c.coursename AS 'Course_Name',(SELECT COUNT(*) FROM subject WHERE subject.coursecode = c.coursecode) AS 'Subject',(SELECT COUNT(*) FROM student WHERE student.coursecode = c.coursecode) AS 'Student',CONCAT(c.totalyear,'',c.semyear) AS 'Total Sem/Year' FROM course AS c;");
			rs = ps.executeQuery();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public String getCoursecode(String coursename) {
		String coursecode = null;
		try {
			ps = cn.prepareStatement("SELECT coursecode FROM course WHERE coursename ='"
					+ coursename + "'");
			rs = ps.executeQuery();
			rs.next();
			coursecode = rs.getString(1);
			return coursecode;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return coursecode;
	}

	@Override
	public String getCoursename(String coursecode) {
		String coursename = null;
		try {
			ps = cn.prepareStatement("SELECT coursename FROM course WHERE coursecode ='"
					+ coursecode + "'");
			rs = ps.executeQuery();
			rs.next();
			coursename = rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return coursename;
	}

	@Override
	public boolean isDeclared(String coursecode, int semyear) {
		boolean isdeclared = false;
		try {
			ps = cn.prepareStatement("SELECT isdeclared FROM result WHERE coursecode = '"
					+ coursecode + "' AND semyear =" + semyear);
			rs = ps.executeQuery();
			while (rs.next()) {
				isdeclared = rs.getBoolean(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isdeclared;

	}

	@Override
	public ArrayList<Course> getCoursesForDeclareResult(String coursename) {
		ArrayList<Course> list = new ArrayList<Course>();

		try {
			ps = cn.prepareStatement("SELECT coursename,coursecode,totalyear FROM course WHERE coursename = '"
					+ coursename + "'");
			rs = ps.executeQuery();
			while (rs.next()) {
				int totalsem = rs.getInt(3);
				for (int i = 0; i < totalsem; i++) {
					Course course = new Course();
					course.setCoursename(rs.getString(1));
					course.setCourseCode(rs.getString(2));
					course.setSemYear(i + 1);
					course.setIsDeclared(isDeclared(rs.getString(2), (i + 1)));

				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public boolean updateResult(Course c) {

		try {
			@SuppressWarnings("unused")
			int result = 0;
			ps = cn.prepareStatement("UPSATE result SET isdeclared ="
					+ c.getIsDeclared() + "WHERE coursecode = '"
					+ c.getCourseCode() + "' AND semyear = " + c.getSemYear());
			result = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

}

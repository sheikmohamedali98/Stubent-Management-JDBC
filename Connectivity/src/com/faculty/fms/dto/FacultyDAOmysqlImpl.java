package com.faculty.fms.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.management.sms.exception.FacultyNotFoundException;
import com.student.sms.server.Server;

public class FacultyDAOmysqlImpl implements FacultyDAO {
	private Connection cn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	private static final String INSER_COMMAND = "INSERT INTO faculty VALUES(?,?,?,?,?,?,?,?,?,?)";
	private static final String COUNT_COMMAND = "SELECT COUNT(*) FROM faculty";
	public static final String UPDATE_COMMAND = "UPDATE faculty SET facultyid = ?,facultyname = ?,facultygender = ?,facultyattends = ?,joineddate = ?,qualification = ?,exprience = ?,facultyphone = ?";
	public static final String DELETE_COMMAND = "DELETE FROM faculty WHERE facultyid = ?";
	public static final String DISPLAY_COMMAND = "SELECT * FROM faculty";

	public FacultyDAOmysqlImpl() {
		try {
			cn = DriverManager.getConnection(Server.URL, Server.USERNAME,
					Server.PASSWORD);
		} catch (SQLException e) {
			System.out.println("Unable to Connect DataBase .....:(");
			e.printStackTrace();
		}
	}

	@Override
	public int getTotalFaculty() {
		int totalfaculty = 0;
		try {
			ps = cn.prepareStatement(COUNT_COMMAND);
			rs = ps.executeQuery();
			rs.next();
			totalfaculty = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return totalfaculty;
	}

	@Override
	public int getFaculty(String coursecode, int sem) {
		int totalfaculty = 0;
		try {
			ps = cn.prepareStatement("select cont(*) from faculty where coursecode='"
					+ coursecode + "' and semyear=" + sem);
			rs = ps.executeQuery();
			rs.next();
			totalfaculty = rs.getInt(1);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return totalfaculty;
	}

	@Override
	public ResultSet getFAcultyInfo(String condition) {
		try {
			ps = cn.prepareStatement("select facultyid as 'Faculty ID',facultyname as 'Faculty Name',emailid as 'Email ID',qualification as 'Qualification',experience as 'Experience' from faculties  "
					+ condition + " order by facultyid");
			rs = ps.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public boolean isActive(String facultyid) {

		try {
			ps = cn.prepareStatement("select activestatus from faculties where facultyid="
					+ facultyid);
			rs = ps.executeQuery();
			return rs.getBoolean(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}

		return false;
		// true
	}

	@Override
	public String getFacultyName(String facultyid)
			throws FacultyNotFoundException {
		try {
			ps = cn.prepareStatement("select facultyname from faculties where facultyid="
					+ facultyid);
			rs = ps.executeQuery();
			rs.next();
			return rs.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return "";
		// null
	}

	@Override
	public boolean addFaculty(Faculty f) {
		int count = 0;
		try {
			ps = cn.prepareStatement(INSER_COMMAND);
			ps.setInt(1, f.getFacultyid());
			ps.setString(2, f.getFacultyname());
			ps.setString(3, f.getFacultygender());
			ps.setString(4, f.getQalification());
			ps.setInt(5, f.getFacultyattends());
			ps.setString(6, f.getFacultyphone());
			ps.setString(7, f.getPosition());
			ps.setString(8, f.generateJoinedDate());
			ps.setString(9, f.getExprience());
			ps.setString(10, f.getSubject());
			count = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (count > 0) {
			System.out.println("Record Added SucessFully.....:)");
		}
		return true;

	}

	@Override
	public boolean updateFacultyData(Faculty f) {
		int count = 0;
		try {
			ps = cn.prepareStatement(UPDATE_COMMAND);
			ps.setInt(1, f.getFacultyid());
			ps.setString(2, f.getFacultyname());
			ps.setString(3, f.getFacultygender());
			ps.setString(4, f.getQalification());
			ps.setInt(5, f.getFacultyattends());
			ps.setString(6, f.getFacultyphone());
			ps.setString(7, f.getPosition());
			ps.setString(8, f.generateJoinedDate());
			ps.setString(9, f.getExprience());
			ps.setString(10, f.getSubject());
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (count > 0) {
			System.out.println("faculty Data has Been Updated .......:)");
		}
		return true;
	}

	@Override
	public void setActiveStatus(boolean activestatus, int facultyid) {
		try {

			ps = cn.prepareStatement("UPDATE faculty SET activestatus="
					+ activestatus + " WHERE facultyid=" + facultyid);
			rs = ps.executeQuery();
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean deleteFaculty(int facultyid) {
		@SuppressWarnings("unused")
		int count = 0;
		try {
			ps = cn.prepareStatement(DELETE_COMMAND);
			ps.setInt(1, facultyid);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	@Override
	public ArrayList<Faculty> getTotalFaculty(String condition) {
		ArrayList<Faculty> list = new ArrayList<Faculty>();
		try {
			ps = cn.prepareStatement("SELECT * FROM faculty " + condition
					+ " ORDER BY facultyid ASC");
			rs = ps.executeQuery();
			while (rs.next()) {

				Faculty f = new Faculty();
				f.setFacultyid(rs.getInt(1));
				f.setFacultyname(rs.getString(2));
				f.setFacultygender(rs.getString(3));
				f.setQalification(rs.getString(4));
				f.setFacultyattends(rs.getInt(5));
				f.setFacultyphone(rs.getString(6));
				f.setPosition(rs.getString(7));
				f.setJoineddate(rs.getString(8));
				f.setExprience(rs.getString(9));
				f.setSubject(rs.getString(10));
				list.add(f);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

}

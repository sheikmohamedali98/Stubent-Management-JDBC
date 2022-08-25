package com.Subject.subms.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.student.sms.server.Server;

public class SubjectDAOmysqlImpl implements SubjectDAO {
	PreparedStatement ps = null;
	ResultSet rs = null;
	Connection cn = null;
	public static final String INSERT_COMMAND = "INSERT INTO subject VALUES(?,?,?,?,?,?,?)";
	public static final String DELETE_COMMAND = "DELETE FROM subject WHERE subjectcode = ?";

	public SubjectDAOmysqlImpl() {
		try {
			cn = DriverManager.getConnection(Server.URL, Server.USERNAME,
					Server.PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int getMaxsemMarkOfSubject(String subjectcode) {
		int mark = 0;

		try {
			ps = cn.prepareStatement("SELECT semmark FROM subject WHERE subjectcode ='"
					+ subjectcode + "'");
			rs = ps.executeQuery();
			rs.next();
			mark = rs.getInt(1);
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
		return mark;
	}

	@Override
	public int getMaxInternalMarkOfSubject(String subjectcode) {
		int mark = 0;
		try {
			ps = cn.prepareStatement("SELECT practicalmark FROM subject WHERE subcode ='"
					+ subjectcode + "'");
			rs = ps.executeQuery();
			rs.next();
			mark = rs.getInt(1);
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
		return mark;
	}

	@Override
	public String createSubjectcode(String Coursecode, int sem) {
		int code = 101;
		String subjectcode = Coursecode + sem + code;

		try {
			ps = cn.prepareStatement("SELECT coursecode,semyear FROM subject WHERE coursecode ='"
					+ Coursecode + "'");
			rs = ps.executeQuery();
			while (rs.next()) {
				code++;
			}
			subjectcode = Coursecode + sem + code;
			return subjectcode;
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
		return subjectcode;
	}

	@Override
	public boolean addSubject(Subject su) {

		try {
			ps = cn.prepareStatement(INSERT_COMMAND);
			ps.setString(1, su.getSubjectcode());
			ps.setString(2, su.getSubjectname());
			ps.setString(3, su.getCourseCode());
			ps.setInt(4, su.getSemYear());
			ps.setString(5, su.getSubjecttype());
			ps.setInt(6, su.getMaxsemmark());
			ps.setInt(7, su.getMaxinternalmark());
			rs = ps.executeQuery();

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

	// public boolean deleteSubject(Subject s){
	// ps = cn.prepareStatement(arg0);
	// return true;
	// }
	@Override
	public ResultSet getSubjectInfo(String coursecode, int sem) {
		rs = null;
		try {
			ps = cn.prepareStatement("SELECT subjectcode AS 'Subject_Code',subjectname AS 'Subject_Name',semyear AS 'Sem/Year',subjecttype AS 'Subject_Type',semmark AS 'Sem_Mark',internalmark AS 'Internal_Mark' FROM subject WHERE coursecode ='"
					+ coursecode + "' AND semyear =" + sem);
			rs = ps.executeQuery();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public String getSubjectName(String subjectcode) {
		String subjectname = null;
		try {
			ps = cn.prepareStatement("SELECT subjectname FROM subject WHERE subjectcode ='"
					+ subjectcode + "'");
			rs = ps.executeQuery();
			subjectname = rs.getString(1);
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
		return subjectname;
	}

	@Override
	public String getSubjectCode(String coursecode, int sem, String subjectname) {
		String subcode = null;
		try {
			ps = cn.prepareStatement("SELECT subjectcode FROM subject WHERE coursecode ='"
					+ coursecode
					+ "' AND semyear ="
					+ sem
					+ " AND subjectname ='" + subjectname);
			rs = ps.executeQuery();
			rs.next();
			subcode = rs.getString(1);

		} catch (Exception e) {
			e.printStackTrace();

		}

		return subcode;

	}

}

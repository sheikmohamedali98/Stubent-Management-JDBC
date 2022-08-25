package com.student.sms.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.management.sms.exception.StudentNotFoundException;
import com.student.sms.server.Server;

public class StudentDAOmysqlmpl implements StudentDAO {
	private Connection cn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	public static final String INSERT_COMMAND = "INSERT INTO student VALUES (?,?,?,?,?,?,?)";
	public static final String UPDATE_COMMAND = "UPDATE student SET sid = ?,sname = ?,sage = ?,sgender = ?,saddress = ?,sattends = ?,sphone = ?";
	public static final String DELETE_COMMAND = "DELETE FROM student WHERE sid = ?";
	public static final String FIND_COMMAND = "SELECT * FROM student WHERE sid = ?";
	public static final String SHOW_COMMAND = "SELECT * FROM student";

	public StudentDAOmysqlmpl() {
		try {
			cn = DriverManager.getConnection(Server.URL,Server.USERNAME, Server.PASSWORD);
		} catch (SQLException e) {
			System.out.println("Unable to Connect DataBase :(");
			e.printStackTrace();
		}
	}

	@Override
	public boolean addStudent(Student s) {
		int count = 0;
		try {
			ps = cn.prepareStatement(INSERT_COMMAND);
			ps.setInt(1, s.getSid());
			ps.setString(2,s.getSname());
			ps.setInt(3, s.getAge());
			ps.setString(4, s.getGender());
			ps.setString(5, s.getSaddress());
			ps.setInt(6, s.getSattends());
			ps.setString(7, s.getSphone());
			count = ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Add Student Details in DataBase is Failled....:( ");
			e.printStackTrace();
		} //catch 
		finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//finally block 
		if (count > 0) {
			System.out.println("Record Added SucessFully.....:)");
		}
		return false;
	}

	@Override
	public boolean deleteStudent(int sid) {
		int count = 0;
		try {
			ps = cn.prepareStatement(DELETE_COMMAND);
			ps.setInt(1, sid);
			count = ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Delete Operation Failed....:(");
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (count > 0) {
			System.out.println("Data has been Deleted Sucessfully.....:)");
		}
		return true;

	}

	@Override
	public boolean updateStudent(Student s) {
		int count = 0;
		try {
			ps = cn.prepareStatement(UPDATE_COMMAND);
			ps.setInt(1, s.getSid());
			ps.setString(2, s.getSname());
			ps.setInt(3, s.getAge());
			ps.setString(4, s.getGender());
			ps.setString(5, s.getSaddress());
			ps.setInt(6, s.getSattends());
			ps.setString(7, s.getSphone());
			count = ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Data Can't Been Updated....:(");
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (count > 0) {
			System.out.println("Data Has Been Updated Sucessfully.....:)");
		}
		return false;
	}

	@Override
	public Student findStudent(Student s) throws StudentNotFoundException {
		Student findtemp = null;
		try {
			ps = cn.prepareStatement(FIND_COMMAND);
			ps.setInt(1, s.getSid());
			rs = ps.executeQuery();
			if (!rs.next()) {
				throw new StudentNotFoundException(s.getSid());
			}
			findtemp = new Student();
			findtemp.setSname(rs.getString(2));
			findtemp.setGender(rs.getString(4));
			findtemp.setSaddress(rs.getString(5));
			findtemp.setSphone(rs.getString(7));
			findtemp.setAge(rs.getInt(3));
			findtemp.setSattends(rs.getInt(6));
			findtemp.setSid(s.getSid());

		} catch (SQLException e) {
			System.out.println("Invali Student Id.....:(");
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return findtemp;
	}

	@Override
	public List<Student> displayAllStudent() {
		Student selectAll = null;
		List<Student> slist = new ArrayList<>();
		try {
			while (rs.next()) {
				selectAll = new Student();
				selectAll.setSid(rs.getInt("sid"));
				selectAll.setSname(rs.getString("sname"));
				selectAll.setAge(rs.getInt("sage"));
				selectAll.setGender(rs.getString("sgender"));
				selectAll.setSaddress(rs.getString("saddress"));
				selectAll.setSattends(rs.getInt("sattends"));
				selectAll.setSphone(rs.getString("sphone"));
				slist.add(selectAll);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return slist;
	}

}

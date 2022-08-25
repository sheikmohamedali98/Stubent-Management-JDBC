package com.student.sms.Service;

import java.util.List;

import com.management.sms.exception.StudentNotFoundException;
import com.student.sms.dto.Student;
import com.student.sms.dto.StudentDAO;
import com.student.sms.dto.StudentDAOmysqlmpl;

public class StudentServiceImpl implements StudentService {
	private StudentDAO studao = new StudentDAOmysqlmpl();

	@Override
	public boolean addStudent(Student s) {
		studao.addStudent(s);
		return true;
	}

	@Override
	public boolean deleteStudent(int sid) {
		studao.deleteStudent(sid);
		return true;
	}

	@Override
	public boolean updateStudent(Student s) {
		studao.updateStudent(s);
		return true;
	}

	@Override
	public Student findStudent(Student s) throws StudentNotFoundException {
		return studao.findStudent(s);
	}

	@Override
	public List<Student> displayAllStudent() {
		return studao.displayAllStudent();
	}

}

package com.student.sms.Service;

import java.util.List;

import com.management.sms.exception.StudentNotFoundException;
import com.student.sms.dto.Student;

public interface StudentService {
	 public abstract boolean addStudent(Student s);
	 public abstract boolean deleteStudent(int sid);
	 public abstract boolean updateStudent(Student s);
	 public abstract Student findStudent(Student s) throws StudentNotFoundException;
	 public abstract List<Student> displayAllStudent();
}

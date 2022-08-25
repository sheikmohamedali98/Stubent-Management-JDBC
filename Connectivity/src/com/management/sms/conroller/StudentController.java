package com.management.sms.conroller;

import com.management.sms.exception.StudentNotFoundException;
import com.student.sms.Service.StudentService;
import com.student.sms.Service.StudentServiceImpl;
import com.student.sms.dto.Student;

public class StudentController {
	public static void main(String[] args) throws StudentNotFoundException{
		StudentService stdser = new StudentServiceImpl();
		stdser.updateStudent(new Student(4,"sheik",23,"male","Madurai",30,"9472233022"));
//		stdser.updateStudent(new Student(,"surya",25,"male","salem",30,"9047773302"));
//		stdser.deleteStudent(2);
		
		
 
	}

}

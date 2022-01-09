package com.selenium.express.service;

import java.util.List;

import com.selenium.express.dto.Student;


public interface StudentServiceInt {

	public Student addStudent(Student student);
	
	public Student findById(int id);
	
	public List<Student> findAllStudent();
	
	public String deleteStudent(int id);
	
	

}

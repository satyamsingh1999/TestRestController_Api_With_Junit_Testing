package com.selenium.express.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selenium.express.dao.StudentRepo;
import com.selenium.express.dto.Student;

@Service
public class StudentServiceImpl implements StudentServiceInt {

	@Autowired
	private StudentRepo studentRepo;

	public StudentServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
   public StudentServiceImpl(StudentRepo repo) {
		this .studentRepo = repo;
	}

	@Override
	public Student addStudent(Student student) {
		Student stu = null;
		try {
			stu = studentRepo.save(student);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stu;
	}

	@Override
	public Student findById(int id) {
		Student st = null;
		try {

			st = studentRepo.findById(id).orElse(new Student());

		} catch (Exception e) {
			e.getMessage();
		}
		return st;
	}

	@Override
	public List<Student> findAllStudent() {
		List list = null;
		try {
		list = studentRepo.findAll();
		}catch (Exception e) {
			e.getMessage();
		}
		return list;
	}

	@Override
	public String deleteStudent(int id) {
		studentRepo.deleteById(id);
		String s ="Student has been deleted successfully";
		return s;
	}


}

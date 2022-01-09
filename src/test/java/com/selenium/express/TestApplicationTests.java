package com.selenium.express;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.selenium.express.dao.StudentRepo;
import com.selenium.express.dto.Student;
import com.selenium.express.service.StudentServiceImpl;

@SpringBootTest
class TestApplicationTests {

	@Mock
	private StudentRepo dao;

	@InjectMocks
	private StudentServiceImpl service;

	@Disabled
	public void testFindStudent() {
		
		Mockito.when(dao.findById(1)).thenReturn(Optional.of(new Student(1,"Satyam","singh","Sagar")));
		Student stu = service.findById(1);
		assertEquals(1, stu.getStuId());
		
	}
	
	@Disabled
	void testAddStudent() {
		Student student = new Student();
		student.setStuId(2);
		student.setStuName("Abhilash");
		student.setStuLastName("panigrahi");
		student.setStuAddress("blr");
		
		Mockito.when(dao.save(student)).thenReturn(student);
		Student stu = service.addStudent(student);
		assertEquals(student, stu);
		
	}
	
	@Test
	void testDeleteStudent() {
		int id = 1;	
		
	String s =	service.deleteStudent(1);
	verify(dao, times(1)).deleteById(id);
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

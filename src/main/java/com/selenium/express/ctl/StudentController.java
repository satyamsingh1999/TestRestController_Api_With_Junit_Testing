package com.selenium.express.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.selenium.express.dto.Student;
import com.selenium.express.service.StudentServiceInt;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentServiceInt studentService;

	/**
	 * This method adding Student in dataBase
	 */
	@PostMapping("/save")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {

		Student stu = studentService.addStudent(student);

		return ResponseEntity.ok().body(stu);
	}

	/**
	 * this Methods getStudent by id
	 */
	@GetMapping("/findStudentById/{id}")
	public ResponseEntity<Student> findById(@PathVariable("id") int id) {
		if(id>0) {
		Student st = studentService.findById(id);
		return ResponseEntity.ok().body(st);
		}
		return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
	}

	/**
	 * this methods getList of all Student
	 */
	@GetMapping("/allStudent")
	public ResponseEntity<List<Student>> allStudent() {

		List<Student> student = studentService.findAllStudent();
		return ResponseEntity.ok().body(student);
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") int id) {
		if (id < 0) {
			return new ResponseEntity<>("not Acceptable", HttpStatus.BAD_REQUEST);
		}
		if (id > 0) {
			String s = studentService.deleteStudent(id);
			return new ResponseEntity<>(s, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Id is not exists", HttpStatus.NOT_FOUND);
		}
	}

}

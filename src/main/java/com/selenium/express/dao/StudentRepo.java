package com.selenium.express.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.selenium.express.dto.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

		
}

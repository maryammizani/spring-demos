package com.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	// Define an endpoint for /students
	@GetMapping("/students")
	public List<Student> getStudents() {
		
		List<Student> lStudents = new ArrayList<>();
		lStudents.add(new Student("mary", "m"));
		lStudents.add(new Student("john", "j"));
		lStudents.add(new Student("susan", "s"));
		return lStudents;
	}
}

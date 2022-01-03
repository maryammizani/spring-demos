package com.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> students;
	
	// define @PostConstruct to load the student data ... only once!
	@PostConstruct
	public void loadData() {
		students = new ArrayList<>();
		students.add(new Student("mary", "m"));
		students.add(new Student("john", "j"));
		students.add(new Student("susan", "s"));
	}
	
	// Define an endpoint for "/students"
	@GetMapping("/students")
	public List<Student> getStudents() {	
		return students;
	}
	
	// Define an endpoint for "/students/{studentId}" - return student at index
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {	
		return students.get(studentId);
	}
}

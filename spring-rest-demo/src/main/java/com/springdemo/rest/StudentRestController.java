package com.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
		
		if((studentId>= students.size()) || studentId < 0) {
			throw new StudentNotFoundException("Student id not found - " + studentId);
		}
		return students.get(studentId);
	}
	
	// Add an Exception Handler to catch StudentNotFoundException exception
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
		
		// Create a StudentErrorResponse
		StudentErrorResponse lError= new StudentErrorResponse();
		lError.setStatus(HttpStatus.NOT_FOUND.value());
		lError.setMessage(exc.getMessage());
		lError.setTimeStamp(System.currentTimeMillis());
		
		// Return a ResponseEntity
		return new ResponseEntity<>(lError, HttpStatus.NOT_FOUND);
	}
	
	// Add another Exception Handler ... to catch any exception
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
		
		StudentErrorResponse lError= new StudentErrorResponse();
		lError.setStatus(HttpStatus.BAD_REQUEST.value());
		lError.setMessage(exc.getMessage());
		lError.setTimeStamp(System.currentTimeMillis());
		
		// Return a ResponseEntity
		return new ResponseEntity<>(lError, HttpStatus.BAD_REQUEST);
	}
}

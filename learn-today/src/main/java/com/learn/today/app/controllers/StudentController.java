package com.learn.today.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.today.app.model.Course;
import com.learn.today.app.model.Student;
import com.learn.today.app.services.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/student/courses")
	public List<Course> getAllCourses() {
		return studentService.getAllCourses();
	}
	
	@PostMapping("/student")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		studentService.saveStudent(student);
		ResponseEntity<Student> responseEntity = new ResponseEntity<Student>(student, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@DeleteMapping("/student/{id}")
	public void deleteStudent(@PathVariable int id) {
		studentService.deleteStudent(id);
	}

}

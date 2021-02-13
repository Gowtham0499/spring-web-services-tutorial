package com.learn.today.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.learn.today.app.model.Course;
import com.learn.today.app.services.CourseService;

@RestController
public class AdminController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/admin/courses")
	public List<Course> getAllCourses() {
		return courseService.getAllCourses();
	}
	
	@GetMapping("/admin/courses/{id}")
	public Course getCourseById(@PathVariable int id) {
		Course courseById = courseService.getCourseById(id);
		return courseById;
	}

}

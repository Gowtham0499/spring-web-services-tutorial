package com.learn.today.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.today.app.dao.CoursesDao;
import com.learn.today.app.model.Course;

@Service
public class CourseService {
	
	@Autowired
	private CoursesDao courseDao;
	
	public List<Course> getAllCourses() {
		return courseDao.findAll();
	}

	public Course getCourseById(int id) {
		return courseDao.findById(id);
	}

}

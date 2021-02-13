package com.learn.today.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.learn.today.app.exceptions.CourseNotFoundException;
import com.learn.today.app.model.Course;
import com.learn.today.app.rowmappers.CourseRowMapper;

@Component
public class CoursesDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private CourseRowMapper rowMapper;
	
	public List<Course> findAll() {
		List<Course> coursesList = jdbcTemplate.query("select * from course", rowMapper);
		return coursesList;
	}

	public Course findById(int id) {
		Course course;
		try {
			course = jdbcTemplate.queryForObject("select * from course where course_id=?", rowMapper, id);
		}
		catch (RuntimeException ex) {
			throw new CourseNotFoundException("Searched data not found.");
		}
		return course;
	}

}

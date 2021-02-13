package com.learn.today.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.learn.today.app.exceptions.EnrollmentNotFoundException;
import com.learn.today.app.model.Course;
import com.learn.today.app.model.Student;
import com.learn.today.app.rowmappers.CourseRowMapper;

@Component
public class StudentDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private CourseRowMapper rowMapper;
	
	public List<Course> findAll() {
		List<Course> coursesList = jdbcTemplate.query("select * from course order by start_date asc", rowMapper);
		return coursesList;
	}
	
	public int save(Student student) {
		int result = jdbcTemplate.update("insert into student (enrollment_id, student_id, course_id) values (?, ?, ?)", new Object[] { student.getEnrollmentId(), student.getStudentId(), student.getCourseId() });
		return result;
	}

	public void delete(int id) {
		int result = jdbcTemplate.update("delete from student where student_id=?", new Object[] { id });
		if(result == 0) {
			throw new EnrollmentNotFoundException("No Enrollment Information Found");
		}
	}

}

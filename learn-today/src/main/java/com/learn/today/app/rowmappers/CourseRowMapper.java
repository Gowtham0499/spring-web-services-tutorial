package com.learn.today.app.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.learn.today.app.model.Course;

@Component
public class CourseRowMapper implements RowMapper<Course> {

	@Override
	public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
		Course course = new Course();
		course.setCourseId(rs.getInt(1));
		course.setTitle(rs.getString(2));
		course.setFees(rs.getFloat(3));
		course.setDescription(rs.getString(4));
		course.setTrainer(rs.getString(5));
		course.setStartDate(rs.getDate(6));
		return course;
	}

}

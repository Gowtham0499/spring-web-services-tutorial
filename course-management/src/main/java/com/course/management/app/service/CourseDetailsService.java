package com.course.management.app.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.course.management.app.bean.Course;

@Service
public class CourseDetailsService {

	private static List<Course> courses = new ArrayList<Course>();

	static {
		Course course1 = new Course(1, "Spring", "Spring Core Course for Beginners");
		courses.add(course1);

		Course course2 = new Course(2, "Spring MVC", "Spring MVC Course for Beginners");
		courses.add(course2);

		Course course3 = new Course(3, "Spring Boot", "Spring Boot Course for Beginners");
		courses.add(course3);

		Course course4 = new Course(4, "Spring Web Services", "Spring Web Services Course for Pro");
		courses.add(course4);
	}

	public Course findById(int id) {
		for (Course course : courses) {
			if (course.getId() == id) {
				return course;
			}
		}
		return null;
	}

	public List<Course> findAll() {
		return courses;
	}

	public int deleteById(int id) {
		Iterator<Course> iterator = courses.iterator();
		while (iterator.hasNext()) {
			Course course = iterator.next();
			if (course.getId() == id) {
				iterator.remove();
				return 1;
			}
		}
		return 0;
	}

}

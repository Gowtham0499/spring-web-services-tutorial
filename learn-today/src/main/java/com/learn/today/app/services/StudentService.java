package com.learn.today.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.today.app.dao.StudentDao;
import com.learn.today.app.model.Course;
import com.learn.today.app.model.Student;

@Service
public class StudentService {
	
	@Autowired
	private StudentDao studentDao;
	
	public List<Course> getAllCourses() {
		return studentDao.findAll();
	}
	
	public int saveStudent(Student student) {
		return studentDao.save(student);
	}

	public void deleteStudent(int id) {
		studentDao.delete(id);
	}
	
}

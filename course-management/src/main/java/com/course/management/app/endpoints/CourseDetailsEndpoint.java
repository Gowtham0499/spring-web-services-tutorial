package com.course.management.app.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.app.management.course.course_details.CourseDetails;
import com.app.management.course.course_details.DeleteCourseRequest;
import com.app.management.course.course_details.DeleteCourseResponse;
import com.app.management.course.course_details.GetAllCoursesRequest;
import com.app.management.course.course_details.GetAllCoursesResponse;
import com.app.management.course.course_details.GetCourseDetailsRequest;
import com.app.management.course.course_details.GetCourseDetailsResponse;
import com.course.management.app.bean.Course;
import com.course.management.app.service.CourseDetailsService;

@Endpoint
public class CourseDetailsEndpoint {
	
	@Autowired
	CourseDetailsService service;
	
	@PayloadRoot(namespace = "http://course.management.app.com/course-details", localPart = "getCourseDetailsRequest")
	@ResponsePayload
	public GetCourseDetailsResponse processGetCourseDetailsRequest(@RequestPayload GetCourseDetailsRequest request) {
		Course course = service.findById(request.getId());
		return mapCourseDetails(course);
	}
	
	@PayloadRoot(namespace = "http://course.management.app.com/course-details", localPart = "getAllCoursesRequest")
	@ResponsePayload
	public GetAllCoursesResponse processGetAllCoursesRequest(@RequestPayload GetAllCoursesRequest request) {
		List<Course> courses = service.findAll();
		return mapAllCoursesDetails(courses);
	}
	
	@PayloadRoot(namespace = "http://course.management.app.com/course-details", localPart = "deleteCourseRequest")
	@ResponsePayload
	public DeleteCourseResponse processDeleteCoursesRequest(@RequestPayload DeleteCourseRequest request) {
		int status = service.deleteById(request.getId());
		DeleteCourseResponse response = new DeleteCourseResponse();
		response.setStatus(status);
		return response;		
	}

	private GetCourseDetailsResponse mapCourseDetails(Course course) {
		GetCourseDetailsResponse response = new GetCourseDetailsResponse();
		CourseDetails courseDetails = mapCourse(course);
		response.setCourseDetails(courseDetails);
		return response;
	}
	
	private GetAllCoursesResponse mapAllCoursesDetails(List<Course> courses) {
		GetAllCoursesResponse response = new GetAllCoursesResponse();
		for (Course course : courses) {
			CourseDetails mappedCourse = mapCourse(course);
			response.getCourseDetails().add(mappedCourse);
		}
		return response;
	}

	private CourseDetails mapCourse(Course course) {
		CourseDetails courseDetails = new CourseDetails();
		courseDetails.setId(course.getId());
		courseDetails.setName(course.getName());
		courseDetails.setDescription(course.getDescription());
		return courseDetails;
	}

}

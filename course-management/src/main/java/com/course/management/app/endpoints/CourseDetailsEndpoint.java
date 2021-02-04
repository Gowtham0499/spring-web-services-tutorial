package com.course.management.app.endpoints;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.app.management.course.course_details.CourseDetails;
import com.app.management.course.course_details.GetCourseDetailsRequest;
import com.app.management.course.course_details.GetCourseDetailsResponse;

@Endpoint
public class CourseDetailsEndpoint {
	
	@PayloadRoot(namespace = "http://course.management.app.com/course-details", localPart = "getCourseDetailsRequest")
	@ResponsePayload
	public GetCourseDetailsResponse processGetCourseDetailsRequest(@RequestPayload GetCourseDetailsRequest request) {
		GetCourseDetailsResponse response = new GetCourseDetailsResponse();
		CourseDetails courseDetails = new CourseDetails();
		courseDetails.setId(request.getId());
		courseDetails.setName("Web Services Course");
		courseDetails.setDescription("Awesome Course");
		response.setCourseDetails(courseDetails);
		return response;
	}

}

package com.ws.soap.webservices.soapcoursemanagement.soap;

import org.example.course_details.CourseDetails;
import org.example.course_details.GetCourseDetailsRequest;
import org.example.course_details.GetCourseDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.ws.soap.webservices.soapcoursemanagement.soap.bean.Course;
import com.ws.soap.webservices.soapcoursemanagement.soap.service.CourseDetailsService;
@Endpoint
public class CourseDetailsEndpoint {
	
	@Autowired
	CourseDetailsService service;
	//method
	//input -GetCourseDetailsRequest
	//output - GetCourseDetailsResponse
	//http://www.example.org/Course-details
	//GetCourseDetailsRequest
	@PayloadRoot(namespace = "http://www.example.org/Course-details", localPart ="GetCourseDetailsRequest" )
	@ResponsePayload
	public GetCourseDetailsResponse processCourseDetailsRequest (@RequestPayload GetCourseDetailsRequest request) {
		
	Course course =	service.findById(request.getId());
		
		return mapCourse(course);
		
	}
	private GetCourseDetailsResponse mapCourse(Course course) {
		GetCourseDetailsResponse response = new GetCourseDetailsResponse();
		CourseDetails courseDetails = new CourseDetails();
		courseDetails.setId(course.getId());
		courseDetails.setName(course.getName());
		courseDetails.setDescription(course.getDescription());
		response.setCourseDetails(courseDetails);
		
		return response;
	}

}

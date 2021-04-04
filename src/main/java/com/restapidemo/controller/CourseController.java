package com.restapidemo.controller;

import com.restapidemo.model.Course;
import com.restapidemo.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
	private CourseService courseService;

	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}

	@GetMapping(value = "list/courses")
	public ResponseEntity<List<Course>> getAllCourses() {
		List<Course> etkenMaddeler = courseService.findAllCourses();
		return ResponseEntity.ok(etkenMaddeler);
	}

	@GetMapping(value = "list/courses/{courseName}")
	public ResponseEntity<Course> getCourseByName(@PathVariable("courseName") String courseName) {
		Course etkenMaddeler = courseService.findCourseByName(courseName);
		return ResponseEntity.ok(etkenMaddeler);
	}

	@PostMapping(value = "add/course")
	public ResponseEntity<Course> addCourse(@RequestBody Course course) {
		courseService.addCourse(course);
		return ResponseEntity.ok(course);
	}

	@DeleteMapping(value = "delete/courses")
	public ResponseEntity<String> deleteAllCourses() {
		return new ResponseEntity<>(courseService.deleteAllCourses(), HttpStatus.OK);
	}

	@DeleteMapping(value = "delete/courses/{courseName}")
	public ResponseEntity<String> deleteCourseByName(@PathVariable("courseName") String courseName) {
		return new ResponseEntity<>(courseService.deleteCourseByName(courseName), HttpStatus.OK);
	}
}

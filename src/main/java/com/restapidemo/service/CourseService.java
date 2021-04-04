package com.restapidemo.service;

import com.restapidemo.model.Course;
import com.restapidemo.repository.CourseRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
	private CourseRepo courseRepo;

	public CourseService(CourseRepo courseRepo) {
		this.courseRepo = courseRepo;
	}

	public void addCourse(Course course) {
		courseRepo.addCourse(course);
	}

	public List<Course> findAllCourses() {
		return courseRepo.findAllCourses();
	}

	public Course findCourseByName(String courseName) {
		return courseRepo.findCourseById(courseName);
	}

	public String deleteAllCourses() {
		return courseRepo.deleteAllCourses();
	}

	public String deleteCourseByName(String courseName) {
		return courseRepo.deleteCourseByName(courseName);
	}

}

package com.zettamine.cms.service;

import java.util.List;

import com.zettamine.cms.entities.Course;


public interface CourseService {

	void saveCourse(Course course);

	void getCourseById(int id);

	void getAllCourse();

	void deleteStudent(int id);

	void addStudentToCourse(int studentId, int courseId);

	void removeStudentFromCourse(int studentId, int courseId);

}

package com.zettamine.cms.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zettamine.cms.entities.Course;
import com.zettamine.cms.entities.Student;
import com.zettamine.cms.repository.CourseRepository;
import com.zettamine.cms.repository.StudentRepository;
import com.zettamine.cms.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepo;
	@Autowired
	private StudentRepository studentRepo;

	private final static Logger LOGGER = LoggerFactory.getLogger(CourseServiceImpl.class);

	@Override
	public void saveCourse(Course course) {

		courseRepo.save(course);

	}

	@Override
	public void getCourseById(int id) {

		Optional<Course> course = courseRepo.findById(id);

		if (course.isPresent()) {
			LOGGER.info(course.get().toString());
		} else {
			LOGGER.info("No course found " + id);
		}
	}

	@Override
	public void getAllCourse() {

		List<Course> courses = courseRepo.findAll();
		System.out.println(courses);
	}

	@Override
	public void deleteStudent(int id) {

		courseRepo.deleteById(id);
	}

	@Override
	public void addStudentToCourse(int studentId, int courseId) {
		Student student = studentRepo.findById(studentId).get();
		
		Course course = courseRepo.findById(courseId).get();
		student.getCourse().add(course);
		
		course.getStudents().add(student);
		
		courseRepo.save(course);
		
	}

	@Override
	public void removeStudentFromCourse(int studentId, int courseId) {
		// TODO Auto-generated method stub

	}

}

package com.zettamine.cms.service.impl;

import java.util.ArrayList;
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
import com.zettamine.cms.service.StudentService;

import jakarta.transaction.Transactional;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepo;
	
	@Autowired
	private CourseRepository courseRepo;

	private final static Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

	public StudentServiceImpl(StudentRepository studentRepo) {
		super();
		this.studentRepo = studentRepo;
	}

	@Override
	public void saveStudent(Student student) {

		studentRepo.save(student);
		LOGGER.info("Student saved successfully");

	}

	@Override
	public Student getStudentById(int id) {

		Optional<Student> student = studentRepo.findById(id);
		
		if(student.isPresent())
		{
			LOGGER.info(student.get().toString());
		}else
		{
			LOGGER.info("No student found " + id);
		}
		return null;
	}

	@Override
	public void getAllStudents() {

		List<Student> students = studentRepo.findAll();
		System.out.println(students);
	}

	@Override
	public void deleteStudent(int id) {

		studentRepo.deleteById(id);
	}

	
	@Override
	public void enrollStudentInCourse(int studentId, int courseId) {

		Student student = studentRepo.findById(studentId).get();
		
		Course course = courseRepo.findById(courseId).get();
		
		System.out.println(student.getCourse());
		student.getCourse().add(course);
		System.out.println(student.getCourse());

		studentRepo.save(student);
	}

	@Override
	public void unEnrollStudentFromCourse(int studentId, int courseId) {
		// TODO Auto-generated method stub

	}

}

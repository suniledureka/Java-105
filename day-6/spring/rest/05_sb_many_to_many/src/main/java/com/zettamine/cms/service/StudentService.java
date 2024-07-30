package com.zettamine.cms.service;

import java.util.List;

import com.zettamine.cms.entities.Student;

public interface StudentService {
	
	void saveStudent(Student student);

	Student getStudentById(int id);

	void getAllStudents();

	void deleteStudent(int id);

	void enrollStudentInCourse(int studentId, int courseId);

	void unEnrollStudentFromCourse(int studentId, int courseId);

}

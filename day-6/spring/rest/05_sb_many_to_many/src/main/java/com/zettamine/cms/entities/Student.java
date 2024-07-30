package com.zettamine.cms.entities;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer studentId;
	
	private String studentName;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "student_courses"
    		//inverseJoinColumns = @JoinColumn(name = "course_id",referencedColumnName = "courseId"),
    		//joinColumns = @JoinColumn(name = "student_id",referencedColumnName = "studentId")
    )
	private Set<Course> course;
}

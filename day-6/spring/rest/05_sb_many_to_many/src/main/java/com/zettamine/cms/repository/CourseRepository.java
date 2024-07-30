package com.zettamine.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zettamine.cms.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}

package com.zettamine.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zettamine.cms.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}

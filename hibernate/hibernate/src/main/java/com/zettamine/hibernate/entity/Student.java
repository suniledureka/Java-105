package com.zettamine.hibernate.entity;

public class Student {
	private Integer studentId;
	private String studentName;
	private String studentEmail;

	public Student() {
		super();
		//System.out.println("inside no args constructor");
	}
	
	public Student(String studentName, String studentEmail) {
		super();
		this.studentName = studentName;
		this.studentEmail = studentEmail;
	}

	
	public Student(Integer studentId, String studentName, String studentEmail) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentEmail = studentEmail;
	}

	public Integer getStudentId() {		
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;		
	}

	public String getStudentName() {		
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;		
	}

	public String getStudentEmail() {	
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {		
		this.studentEmail = studentEmail;
	}

	@Override
	public String toString() {
		return String.format("Student [%3d | %-15s | %-23s]",studentId, studentName, studentEmail);
	}
	
}

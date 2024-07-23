package com.zettamine.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Batch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer batchId;
	private String couse;
	@ManyToOne
	@JoinColumn(name = "faculty")
	private Faculty faculty;
	public Batch(String couse, Faculty faculty) {
		super();
		this.couse = couse;
		this.faculty = faculty;
	}
	@Override
	public String toString() {
		return "Batch [batchId=" + batchId + ", couse=" + couse + "]";
	}
	
}

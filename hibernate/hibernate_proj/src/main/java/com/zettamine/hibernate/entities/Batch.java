package com.zettamine.hibernate.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
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

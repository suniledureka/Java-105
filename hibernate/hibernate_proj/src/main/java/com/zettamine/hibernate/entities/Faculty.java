package com.zettamine.hibernate.entities;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
@Entity
@Data
public class Faculty {
	@Id
	private Integer facultyId;
	private String facultyName;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Batch> batches;

	@Override
	public String toString() {
		return "Faculty [facultyId=" + facultyId + ", facultyName=" + facultyName + "]";
	}
	
	
}

package com.zettamine.hibernate.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Entity
//@Data
@Getter
@Setter
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

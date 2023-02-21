package com.mis.studentdata.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")

public class Students {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String email;
	
	protected Students() {}
	
	public Students(String name, String email) {
		this.name = name;
		this.email = email;
	}
	
	@Override
	public String toString() {
		return String.format(
			"Students[id=%d, name='%s', email='%s']",
	        id, name, email);
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
}

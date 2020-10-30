package com.demo.entity;

public class Emplo {

	//define the fields 
	private Integer id;
	
	private String name;
	
	private String dob;
	
	private String department;

	
	//Generate setter and getter
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	
	//Generate toString method
	
	@Override
	public String toString() {
		return "Emplo [id=" + id + ", name=" + name + ", dob=" + dob + ", department=" + department + "]";
	}
	
	
	
	
	
	
}

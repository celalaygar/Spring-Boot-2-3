package com.example.demo.entity;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

@Entity
@Table(name = "subject")
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;

	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY,mappedBy = "subjects")
	private Set<Student> students;

	public Subject() {
	}

	public Subject(String name) {
		this.name = name;
	}

	public Subject(String name, Set<Student> students) {
		this.name = name;
		this.students = students;
	}

	// name
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// students
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {

		String info = "<br/> - - Subject id : "+this.id+" name : "+this.name;
		return info;
	}
	

}

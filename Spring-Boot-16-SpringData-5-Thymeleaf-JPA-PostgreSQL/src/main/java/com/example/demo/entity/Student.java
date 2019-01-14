package com.example.demo.entity;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;


@Entity
@Table(name = "student")
public class Student {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;

	@JsonIgnore
	@ManyToMany( fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "student_subject", joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"), 
    inverseJoinColumns = @JoinColumn(name = "subject_id", referencedColumnName = "id"))
	private Set<Subject> subjects;
	
	public Student(){
		
	}
	
	public Student(String name){
		this.name = name;
	}
	
	public Student(String name, Set<Subject> subjects){
		this.name = name;
		this.subjects = subjects;
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// subjects
	public Set<Subject> getSubjects() {
		return subjects;
	}
	
	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}
	
	@Override
	public String toString(){

		String info = "Student id : "+this.id+" name : "+this.name+" { "+this.subjects.toString()+" <br/> }";
		return info;
	}
	public String writeDetails() {
		String info = "Student id : "+this.id+" name : "+this.name+" { "+this.subjects.toString()+" <br/> }";
		return info;
		
	}
}

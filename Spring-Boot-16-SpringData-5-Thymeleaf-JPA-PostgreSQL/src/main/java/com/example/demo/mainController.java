package com.example.demo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.SubjectRepository;

@Controller
public class mainController {
	
	@Autowired
	StudentRepository studentRepository;

	@Autowired
	SubjectRepository subjectRepository;

	@Value("${welcome.message}")
	private String message = "Hello World";
	
	@RequestMapping("/")
	public String index(Map<String, Object> model) {

		List<Student> students = studentRepository.findAll();
		model.put("students", students);
		model.put("message", "This Page is Home page as İndex.html");
		return "index";
	}
	// 
	@RequestMapping("/student-details/{id}")
	public String student_details(Map<String, Object> model,@PathVariable("id") int id) {
		Student student = studentRepository.findById(id);
		model.put("student", student);
		model.put("message", "This Page is about student details page");
		return "student-details";
	}
	
	@RequestMapping("/hello")
	public String hello(Map<String, Object> model) {
		model.put("message", this.message);
		return "hello";
	}

	@RequestMapping("/students-details")
	@ResponseBody
	public String getAllStuents() {
		List<Student> students = studentRepository.findAll();

		return students.toString();
	}

	@RequestMapping("/student/{id}")
	@ResponseBody
	public String getStuent(@PathVariable("id") int id) {
		Student students = studentRepository.findById(id);

		return students.writeDetails();
	}
}

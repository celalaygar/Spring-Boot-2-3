package com.example.demo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.entity.Subject;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.SubjectRepository;

@RestController
@RequestMapping("/rest")
public class mainRestController {
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	SubjectRepository subjectRepository;
	
	@RequestMapping("/students")
	public List<Student> student(){
		List<Student> students=studentRepository.findAll();
		return students;
	}
	@RequestMapping("/student/{id}")
	public Student getStuent(@PathVariable("id") int id) {
		Student students = studentRepository.findById(id);
		return students;
	}
	@RequestMapping("/insert")
	public String insert() {
		
		Student mehmet = new Student("Mehmet Ali");
		Student fatih = new Student("Fatih Terim");
		Student arda = new Student("Arda Turan");
		Student veli = new Student("Veli Kavlak");
		Student necati = new Student("Necati Ateş");
		Student volkan = new Student("Volkan Demirel");
		
		Subject math = new Subject("Mathematics");
		Subject computer = new Subject("Compter");
		Subject turkish = new Subject("Turkish");
		Subject spanish = new Subject("Spanish");
		Subject chemistry = new Subject("Chemistry");
		Subject statistics = new Subject("Statistics");
		
		Set<Subject> subjects = new HashSet<Subject>();
		subjects.add(math);
		subjects.add(computer);
		subjects.add(turkish);
		subjects.add(spanish);
		subjects.add(chemistry);
		subjects.add(statistics);
		
		mehmet.setSubjects(subjects);
		fatih.setSubjects(subjects);
		arda.setSubjects(subjects);
		veli.setSubjects(subjects);
		necati.setSubjects(subjects);
		volkan.setSubjects(subjects);
		
		studentRepository.save(mehmet);
		studentRepository.save(fatih);
		studentRepository.save(arda);
		studentRepository.save(veli);
		studentRepository.save(necati);
		studentRepository.save(volkan);
		
		
		Set<Student> students = new HashSet<Student>();
		students.add(mehmet);
		students.add(fatih);
		students.add(arda);
		students.add(veli);
		students.add(necati);
		students.add(volkan);
		
		math.setStudents(students);
		computer.setStudents(students);
		turkish.setStudents(students);
		spanish.setStudents(students);
		chemistry.setStudents(students);
		statistics.setStudents(students);
		
		
		subjectRepository.save(math);
		subjectRepository.save(computer);
		subjectRepository.save(turkish);
		subjectRepository.save(spanish);
		subjectRepository.save(chemistry);
		subjectRepository.save(statistics);
		
		List<Student> studentLst = studentRepository.findAll();
		List<Subject> subLst = subjectRepository.findAll();
		
		System.out.println("studentLst.size : "+studentLst.size());
		System.out.println("subLst.size : "+subLst.size());
		
		
		System.out.println("===================Students info:==================");
		studentLst.forEach(student->System.out.println(student.toString()));
		
		System.out.println("===================Students info:==================");
		subLst.forEach(subject->System.out.println(subject.toString()));
		
		return "inserting data.....";
	}
}

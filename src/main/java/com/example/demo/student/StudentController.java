package com.example.demo.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api")
public class StudentController {
	
	StudentService service;
	@Autowired
	public StudentController(StudentService studentservice) {
		this.service=studentservice;
	}
	
	@GetMapping
	public List<Student> GetStudents() {
		return service.GetStudent();
	}

	@PostMapping
	public void registreNewStudent(@RequestBody Student student) {
		service.addNewStudent(student);
	}
	
	@DeleteMapping(path= "{StudentId}")
	public void deleteStudent(@PathVariable("StudentId") Double StudentId) {
		
		service.DeleteStudent(StudentId);
	}
	
	@PutMapping
	public void updateStudent(@PathVariable("StudentId") Double StudentId,@RequestParam String name,@RequestParam String email) {
		
		service.updateStudent(StudentId, name, email);
	}
}

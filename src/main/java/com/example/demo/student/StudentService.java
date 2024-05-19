package com.example.demo.student;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {
	private final StudentRepository studentrepo;
	@Autowired
	StudentService(StudentRepository studentrepo){
		this.studentrepo=studentrepo;
	}
	
	public List<Student> GetStudent(){
		return studentrepo.findAll();
	}

	public void addNewStudent(Student student) {
			Optional<Student> studentOp =studentrepo.findStudentByEmail(student.getEmail());
			 if (studentOp.isPresent()) {
				 throw new IllegalStateException("Email taken");
			 }
			 studentrepo.save(student);
	}

	public void DeleteStudent(Double StudentId) {
		boolean exist=studentrepo.existsById(StudentId);
		if(!exist) {
			throw new IllegalStateException("Student with id:"+StudentId+" does not exist");
		}
		studentrepo.deleteById(StudentId);
	}
	
	@Transactional
	public void updateStudent(Double id,String name,String email) {
		Student student = studentrepo.findById(id).orElseThrow(()->new IllegalStateException("Student with th id :"+id+"does not exist"))  ;
		if(!Objects.equals(name,student.getName()) && name.length()>0 && name != null) {
			student.setName(name);
		}
		if(!Objects.equals(email, student.getEmail()) && email.length()>0 && email != null ) {
			Optional<Student> studentop =studentrepo.findStudentByEmail(email);
			if(studentop.isPresent()) {
				throw new IllegalStateException("this Email is already taken ");
			}
			student.setEmail(email);
		}
	}
}
package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.StudentException;
import com.example.demo.models.Student;
import com.example.demo.repositories.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository sr;
	
	//Gets all Students
	public Iterable<Student> findStudents() {
		return sr.findAll();
	}

	//Deletes student
	public void deleteBySid(String sid)  throws StudentException{
		sr.deleteBySid(sid);		
	}
}

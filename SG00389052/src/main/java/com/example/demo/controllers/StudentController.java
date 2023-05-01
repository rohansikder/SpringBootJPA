package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.exceptions.StudentException;
import com.example.demo.models.Student;
import com.example.demo.services.StudentService;

@RestController
@Validated
//Needed to avoid cors policy
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StudentController {
	
	@Autowired
	StudentService ss;
	
	//Gets All students
	@GetMapping(path = "/students")
	public Iterable<Student> getStudents(){
		return ss.findStudents();	
	}
	
	//Deletes student by sid
	@DeleteMapping(path = "/students/{sid}")
	public void deleteStudent(@PathVariable String sid) throws StudentException{
		ss.deleteBySid(sid);
		
		if(sid.isEmpty()) 
		{
			throw new ResponseStatusException(HttpStatus.OK, "Successfully deleted: " + sid);
		}
	}
}

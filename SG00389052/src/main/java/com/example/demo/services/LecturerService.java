package com.example.demo.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.exceptions.LecturerException;
import com.example.demo.models.Lecturer;
import com.example.demo.repositories.LecturerRepository;

@Service
public class LecturerService {

	@Autowired
	LecturerRepository lr;
	
	//Getting all lecturers
	public Iterable<Lecturer> getLecturers(){
		return lr.findAll();
	}
	
	//Adding Lecturer
	public void save(Lecturer lecturer) throws LecturerException{
		try {
			lr.save(lecturer);
			
		} catch(DataIntegrityViolationException e) {
			//throws error
			throw new LecturerException ("Lecturer: " + lecturer.getLid() + " already exists");
		}
	}
	
	//Updating Lecturer
	public void updateLecturer(String lid, Lecturer lecturer) throws LecturerException{
	Optional<Lecturer> lec =  lr.findByLid(lid);
	
	if(lec.isEmpty()) {
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Lecturer ID: " + lid + " doesnt exist");

	}
	
	lec.get().setName(lecturer.getName());
	lec.get().setTaxBand(lecturer.getTaxBand());
	lec.get().setSalaryScale(lecturer.getSalaryScale());
	lr.save(lec.get());
	
	}

	//Find by taxband
	public List<Lecturer> findByTaxBand(String taxBand) throws LecturerException{
		return lr.findByTaxBand(taxBand);

	}

	//Find by taxband
	public List<Lecturer> findBySalaryScale(int salaryScale) throws LecturerException{
		return lr.findBySalaryScale(salaryScale);
	}
	
}

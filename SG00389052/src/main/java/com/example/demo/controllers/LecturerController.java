package com.example.demo.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.example.demo.exceptions.LecturerException;
import com.example.demo.models.Lecturer;
import com.example.demo.services.LecturerService;
import com.example.demo.validations.LecturerPOSTValidations;
import com.example.demo.validations.LecturerPUTValidations;
import com.example.demo.validations.LecturerValidations;
import jakarta.validation.Valid;

@RestController
@Validated
//Needed to avoid cors policy
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LecturerController {

	@Autowired
	LecturerService ls;
	
	//Show all lecturers
	@GetMapping(path = "/lecturers")
	public Iterable<Lecturer> getLecturers(){
			return ls.getLecturers();
	}
	
	//Add Lecturer
	@Validated(LecturerPOSTValidations.class)
	@PostMapping(path = "/lecturer")
	public void addLecturer(@Valid @RequestBody Lecturer lecturer) {
		try {
			ls.save(lecturer);
		} catch (LecturerException e) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN,e.getMessage());
		}
	}
	
	//Put Lecturer
	@Validated(LecturerPUTValidations.class)
    @PutMapping(path = "/lecturer/{lid}")
	public void updateLecturer(@PathVariable String lid, @Valid @RequestBody Lecturer lecturer) {
		try {
			ls.updateLecturer(lid, lecturer);
		} catch (LecturerException e) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, e.getMessage());
		}
	}
	
	//Outputs taxband and salaryscale
	@Validated(LecturerValidations.class)
	@GetMapping("/lecturers/search")
	public List<Lecturer> findByTaxBandAndSalaryScale(@RequestParam("taxBand") String taxBand, @RequestParam(value = "salaryScale", required = false) Integer salaryScale) {
	    try {
	    	List<Lecturer> taxBandResults = ls.findByTaxBand(taxBand);
	    	
	    	if (salaryScale != null) {
	        List<Lecturer> salaryScaleResults = ls.findBySalaryScale(salaryScale);
	        taxBandResults.addAll(salaryScaleResults);
	        return taxBandResults;
	    	}
	        return taxBandResults;	    
	        } catch (LecturerException e) {
	        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
	    }
	}
	
}
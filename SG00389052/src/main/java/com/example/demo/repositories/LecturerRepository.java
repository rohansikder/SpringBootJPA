package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Lecturer;


public interface LecturerRepository extends CrudRepository<Lecturer, Integer>{

	public Optional<Lecturer> findByLid(String lid);

	public List<Lecturer> findByTaxBand(String taxBand);

	public List<Lecturer> findBySalaryScale(int salaryScale);


}

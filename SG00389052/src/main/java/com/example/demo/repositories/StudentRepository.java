package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Student;

import jakarta.transaction.Transactional;

public interface StudentRepository extends CrudRepository<Student, Integer>{
	@Transactional
	public Optional<Student> deleteBySid(String sid);
}

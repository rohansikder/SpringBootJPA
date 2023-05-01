package com.example.demo.models;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.validations.LecturerPOSTValidations;
import com.example.demo.validations.LecturerPUTValidations;
import com.example.demo.validations.LecturerValidations;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

@Entity
public class Lecturer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Null(message = "id must not be provided", groups = LecturerPOSTValidations.class)
	@Null(message = "id must not be provided", groups = LecturerPUTValidations.class)
	private Integer id;
	@Column(unique = true)
	@NotNull(message = "Lid must be provided", groups = LecturerPOSTValidations.class)
	@Null(message = "lid must not be provided", groups = LecturerPUTValidations.class)
	private String lid;
	@NotNull(message = "Name must be provided", groups = LecturerPOSTValidations.class)
	@NotNull(message = "Name must be provided", groups = LecturerPUTValidations.class)
	private String name;
	//Needed to fix error - Cannot render error page for request [/lecturers] and exception [Could not write JSON: Infinite recursion (StackOverflowError)] as the response has already been committed. 
	@JsonBackReference
	@OneToMany(mappedBy = "lecturer")
	//Needed to fix error - Cannot render error page for request [/lecturers] and exception [Could not write JSON: Infinite recursion (StackOverflowError)] as the response has already been committed. 
	@JsonIgnore
	private List<Module> modules = new ArrayList<Module>();
	private String taxBand;
	private Integer salaryScale;
	public String getTaxBand() {
		return taxBand;
	}
	public void setTaxBand(String taxBand) {
		this.taxBand = taxBand;
	}
	public Integer getSalaryScale() {
		return salaryScale;
	}
	public void setSalaryScale(Integer salaryScale) {
		this.salaryScale = salaryScale;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLid() {
		return lid;
	}
	public void setLid(String lid) {
		this.lid = lid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Module> getModules() {
		return modules;
	}
	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	

}

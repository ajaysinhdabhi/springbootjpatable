package com.luv2code.crudopdemo.dao;

import java.util.List;

import com.luv2code.crudopdemo.entity.Student;

public interface StudentDao {

	void save(Student theStudent);
	
	Student findById(Integer id);
	
	List<Student> findAll();
	
	List<Student> findByLastName(String theLastName);
	
    void update(Student theStudent);
    void delete(Integer id);
    
    int deleteAll();

	
}

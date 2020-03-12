package com.SpringJDBC1.service;

import java.util.List;

import com.SpringJDBC1.bean.Student;

public interface StudentService {

	List<Student> viewAll();

	void save(Student student);

	Student edit(int parseInt);

	void delete(int id);

}

package com.SpringJDBC1.dao;

import java.util.List;

import com.SpringJDBC1.bean.Student;

public interface StudentDao {

	List<Student> viewAll();

	void save(Student student);

	Student edit(int id);

	void delete(int id);

}

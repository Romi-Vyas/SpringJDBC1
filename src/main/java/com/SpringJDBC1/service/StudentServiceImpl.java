package com.SpringJDBC1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.SpringJDBC1.bean.Student;
import com.SpringJDBC1.dao.StudentDao;

public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao dao;

	@Override
	public List<Student> viewAll() {
		List<Student> lst = dao.viewAll();
		return lst;
	}

	@Override
	public void save(Student student) {
		dao.save(student);
	}

	@Override
	public Student edit(int id) {
		return dao.edit(id);
	}

	@Override
	public void delete(int id) {
		dao.delete(id);
	}

}

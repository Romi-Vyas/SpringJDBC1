package com.SpringJDBC1.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.SpringJDBC1.bean.Student;
import com.SpringJDBC1.service.StudentService;

@Controller
public class MyAction {

	@Autowired
	StudentService service;

	@RequestMapping(value = "/")
	public ModelAndView viewAll() {
		List<Student> lst = service.viewAll();
		ModelAndView mv = new ModelAndView("view");
		mv.addObject("lst", lst);
		return mv;
	}

	@RequestMapping(value = "add")
	public ModelAndView add() {
		ModelAndView mv = new ModelAndView("add");
		mv.addObject("student", new Student());
		return mv;
	}

	@RequestMapping(value = "save")
	public String save(@ModelAttribute Student student) {
		service.save(student);
		return "redirect:/";
	}

	@RequestMapping(value = "edit")
	public ModelAndView save(HttpServletRequest request) {
		Student student = service.edit(Integer.parseInt(request.getParameter("id")));
		ModelAndView mv = new ModelAndView("add");
		mv.addObject("student", student);
		return mv;
	}

	@RequestMapping(value = "delete/{id}")
	public String delete(@PathVariable int id) {
		service.delete(id);
		return "redirect:/";
	}

	@ModelAttribute("countryLst")
	public List<String> countryLst() {
		List<String> lst = new ArrayList<String>();
		lst.add("INDIA");
		lst.add("USA");
		lst.add("SINGAPORE");
		lst.add("RUSSIA");
		return lst;
	}

	@ModelAttribute("subjsLst")
	public List<String> subjsLst() {
		List<String> lst = new ArrayList<String>();
		lst.add("JAVA");
		lst.add(".NET");
		lst.add("PHP");
		lst.add("ANDROID");
		return lst;
	}

	@ModelAttribute("educationLst")
	public List<String> educationLst() {
		List<String> lst = new ArrayList<String>();
		lst.add("GRADUATE");
		lst.add("POST GRADUATE");
		lst.add("RESEARCH");
		return lst;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
}

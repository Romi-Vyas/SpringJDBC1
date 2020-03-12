package com.SpringJDBC1.bean;

import java.util.Date;
import java.util.List;

public class Student {
	private int sid;
	private String sname;
	private String gender;
	private String country;
	private List<String> subjs;
	private String education;
	private Date dob;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<String> getSubjs() {
		return subjs;
	}

	public void setSubjs(List<String> subjs) {
		this.subjs = subjs;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
}

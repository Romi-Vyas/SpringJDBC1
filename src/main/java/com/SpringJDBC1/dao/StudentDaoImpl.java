package com.SpringJDBC1.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.StringUtils;

import com.SpringJDBC1.bean.Student;

public class StudentDaoImpl implements StudentDao {

	@Autowired
	JdbcTemplate template;

	@Override
	public List<Student> viewAll() {
		List<Student> lst = template.query("SELECT * FROM `student_jdbc`", new RowMapper<Student>() {
			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student s = new Student();
				s.setSid(rs.getInt("sid"));
				s.setSname(rs.getString("sname"));
				s.setGender(rs.getString("gender"));
				s.setCountry(rs.getString("country"));
				s.setSubjs(convertToList(rs.getString("subjs")));
				s.setEducation(rs.getString("education"));
				s.setDob(rs.getDate("dob"));
				return s;
			}
		});
		return lst;
	}

	protected List<String> convertToList(String subjs) {
		List<String> lst = Arrays.asList(StringUtils.delimitedListToStringArray(subjs, ","));
		return lst;
	}

	@Override
	public void save(Student student) {
		if (student.getSid() == 0) {
			String insertQuery = "INSERT INTO `student_jdbc` (`sname`,`gender`,`country`,`subjs`,`education`,`dob`) "
					+ "VALUES ('" + student.getSname() + "','" + student.getGender() + "','" + student.getCountry()
					+ "','" + convertToArray(student.getSubjs()) + "','" + student.getEducation() + "','"
					+ covertDate(student.getDob()) + "')";

			template.execute(insertQuery);
		} else {
			String updateQuery = "UPDATE `student_jdbc` SET `sname`='" + student.getSname() + "',`gender`='"
					+ student.getGender() + "',`country`='" + student.getCountry() + "',`subjs`='"
					+ convertToArray(student.getSubjs()) + "',`education`='" + student.getEducation() + "',`dob`='"
					+ covertDate(student.getDob()) + "' WHERE sid=" + student.getSid();

			template.execute(updateQuery);
		}
	}

	private String covertDate(Date dob) {
		String formattedDate = "";
		SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy");
		Date date = null;
		try {
			date = sdf.parse(dob.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		formattedDate = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DATE);
		return formattedDate;
	}

	private String convertToArray(List<String> subjs) {
		String subj = "";
		if (subjs != null) {
			subj = StringUtils.arrayToCommaDelimitedString(subjs.toArray());
		}
		return subj;
	}

	@Override
	public Student edit(int id) {
		return template.query("SELECT * FROM `student_jdbc` WHERE sid=" + id, new ResultSetExtractor<Student>() {
			Student s = new Student();

			@Override
			public Student extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					s.setSid(rs.getInt("sid"));
					s.setSname(rs.getString("sname"));
					s.setGender(rs.getString("gender"));
					s.setCountry(rs.getString("country"));
					s.setSubjs(convertToList(rs.getString("subjs")));
					s.setEducation(rs.getString("education"));
					s.setDob(rs.getDate("dob"));
				}
				return s;
			}
		});
	}

	@Override
	public void delete(int id) {
		String deleteQuery = "DELETE FROM `student_jdbc` WHERE sid=" + id;
		template.execute(deleteQuery);
	}

}

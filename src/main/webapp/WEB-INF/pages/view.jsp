<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td><a href="add">Add</a></td>
		</tr>
		<tr>
			<td>Sr No</td>
			<td>Name</td>
			<td>Gender</td>
			<td>Country</td>
			<td>Subjects</td>
			<td>Education</td>
			<td>Date Of Birth</td>
			<td>Edit</td>
			<td>Delete</td>
		</tr>
		<c:forEach items="${lst}" var="d" varStatus="status">
			<tr>
				<td>${status.index+1}</td>
				<td>${d.sname}</td>
				<td>${d.gender}</td>
				<td>${d.country}</td>
				<td>${d.subjs}</td>
				<td>${d.education}</td>
				<td>${d.dob}</td>
				<td><a href="edit?id=${d.sid}">Edit</a></td>
				<td><a href="delete/${d.sid}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
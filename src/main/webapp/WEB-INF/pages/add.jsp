<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="save" method="post" modelAttribute="student">
		<table>
			<tr>
				<td><form:hidden path="sid"></form:hidden></td>
			</tr>
			<tr>
				<td><form:label path="sname">Name</form:label></td>
				<td><form:input path="sname"></form:input></td>
			</tr>
			<tr>
				<td><form:label path="gender">Gender</form:label></td>
				<td><form:radiobutton path="gender" value="M" />Male <form:radiobutton
						path="gender" value="F" />Female</td>
			</tr>
			<tr>
				<td><form:label path="country">Country</form:label></td>
				<td><form:select path="country">
						<form:option value="">-------Select--------</form:option>
						<form:options items="${countryLst}"></form:options>
					</form:select></td>
			</tr>
			<tr>
				<td><form:label path="subjs">Subjects</form:label></td>
				<td><form:select path="subjs" multiple="true">
						<form:options items="${subjsLst}"></form:options>
					</form:select></td>
			</tr>
			<tr>
				<td><form:label path="education">Educations</form:label></td>
				<td><form:radiobuttons path="education" items="${educationLst}"></form:radiobuttons></td>
			</tr>
			<tr>
				<td><form:label path="dob">Date Of Birth</form:label></td>
				<td><form:input path="dob"></form:input></td>
			</tr>
			<tr>
				<td colspan="2"><form:button value="save">Save</form:button></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>User form</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h3 id="form_header" class="text-warning" align="center">Employee
			Form</h3>
		<div></div>

		<!-- User input form to add a new user or update the existing user-->

		<form:form id="employee_form" modelAttribute="employeeAttr"
			method="POST" action="./save">
			<form:hidden path="id" />
			<div class="form-group">
				<label for="name">Enter Name: </label>
				<form:input id="name" cssClass="form-control" path="name" />
				<font color="red"><form:errors path="name"></form:errors></font>
			</div>

			<div class="form-group">
				<label for="lastName">Enter Last Name: </label>
				<form:input id="lastName" cssClass="form-control" path="lastName" />
				<font color="red"><form:errors path="lastName"></form:errors></font>
			</div>

			<div class="form-group">
				<label for="birthDate">Enter Birth Date: </label>
				<form:input id="birthDate" cssClass="form-control" path="birthDate" />
				<font color="red"><form:errors path="birthDate"></form:errors></font>
			</div>

			<div class="form-group">
				<label for="role">Enter Role: </label>
				<form:input id="role" cssClass="form-control" path="role" />
				<font color="red"><form:errors path="role"></form:errors></font>
			</div>

			<div class="form-group">
				<label for="department">Enter Department: </label>
				<form:input id="department" cssClass="form-control"
					path="department" />
				<font color="red"><form:errors path="role"></form:errors></font>
			</div>

			<div class="form-group">
				<label for="email">Enter Email: </label>
				<form:input id="email" cssClass="form-control" path="email" />
				<font color="red"><form:errors path="email"></form:errors></font>
			</div>

			<button id="saveBtn" type="submit" class="btn btn-primary">Save</button>
		</form:form>
	</div>
</body>
</html>
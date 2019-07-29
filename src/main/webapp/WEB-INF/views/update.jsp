<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
</head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employees Info</title>
<%@ page isELIgnored="false"%>
</head>
<body>
	<%@include file="navbar.jsp"%>

	<div class="container">
		<h3 id="form_header" class="text-warning" align="center">Employee
			Form</h3>
		<div></div>

		<!-- User input form to add a new user or update the existing user-->

		<form:form id="employee_form" modelAttribute="employee" method="POST"
			action="./updated">
			<label for="id">Enter Id: </label>
			<form:input id="id" cssClass="form-control" path="id" value="${employee.id}" />
			
			<label for="name">Enter Name: </label>
			<form:input id="name" cssClass="form-control" path="name" value="${employee.name}"  />

			<label for="lastName">Enter Last Name: </label>
			<form:input id="lastName" cssClass="form-control" path="lastName"  value="${employee.lastName}" />

			<label for="birthDate">Enter Birth Date: </label>
			<form:input id="birthDate" cssClass="form-control" path="birthDate" value="${employee.birthDate}"  />

			<label for="role">Enter Role: </label>
			<form:input id="role" cssClass="form-control" path="role" value="${employee.role}"  />

			<label for="department">Enter Department: </label>
			<form:input id="department" cssClass="form-control" path="department" value="${employee.department}"  />

			<label for="email">Enter Email: </label>
			<form:input id="email" cssClass="form-control" path="email" value="${employee.email}"  />

			<div></div> 

			<button id="saveBtn" type="submit" class="btn btn-primary">Save</button>
		</form:form>
	</div>


	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
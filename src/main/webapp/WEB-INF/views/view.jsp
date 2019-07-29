<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<form action="EmployeeServlet">
		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col">Employee Details</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th scope="row">Id:</th>
					<td>${employee.id}</td>
				</tr>
				<tr>
					<th scope="row">Name:</th>
					<td>${employee.name}</td>
				</tr>
				<tr>
					<th scope="row">Last Name:</th>
					<td>${employee.lastName}</td>
				</tr>
				<tr>
					<th scope="row">Email:</th>
					<td>${employee.email}</td>
				</tr>
				<tr>
					<th scope="row">Birth Date:</th>
					<td>${employee.birthDate}</td>
				</tr>
				<tr>
					<th scope="row">Department:</th>
					<td>${employee.department}</td>
				</tr>
				<tr>
					<th scope="row">Role:</th>
					<td>${employee.role}</td>
				</tr>

			</tbody>
		</table>
	</form>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
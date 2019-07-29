<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page isELIgnored="false"%>
<title>Welcome</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
	<%@ include file="navbar.jsp"%>
	<div class="container">
		<!-- Div to add a new user to the mongo database -->
		<div id="add_new_user">
			<c:url var="addUrl" value="./add" />
			<a id="add" href="./add" class="btn btn-success">Add user</a>
		</div>
		<div></div>

		<!-- Table to display the user list from the mongo database -->
		<table id="users_table" class="table">
			<thead>
				<tr align="center">
					<th>Name</th>
					<th>Department</th>
					<th></th>
					<th colspan="2"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${employees}" var="employee">
					<tr align="center">
						<td><c:out value="${employee.name}" /></td>
						<td><c:out value="${employee.department}" /></td>
						<td><c:url var="viewUrl" value="./view?id=${employee.id}" />
							<a id="view" href="./view?id=${employee.id}"
							class="btn btn-warning">View</a></td>

						<td><c:url var="updateUrl" value="./update?id=${employee.id}" />
							<a id="update" href="./update?id=${employee.id}"
							class="btn btn-warning">Update</a></td>

						<td><c:url var="deleteUrl" value="./delete?id=${employee.id}" /> 
						<a id="delete" href="./delete?id=${employee.id}" class="btn btn-danger">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false" %>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"/>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4 mt-4">
				<h3>Login</h3>
				<form:form method="POST"  modelAttribute="loginAttr" action="./login">
					<div class="form-group">
						<input type="text" class="form-control" name="username" placeholder="Username"
							value="" />
						<font color="red"><form:errors path="username"></form:errors></font>
					</div>
					<div class="form-group">
						<input type="password" name="password" class="form-control"
							placeholder="Password *" value="" />
						<font color="red"><form:errors path="password"></form:errors></font>
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Login" />
					</div>
				</form:form>
				${message}
				${error} 
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
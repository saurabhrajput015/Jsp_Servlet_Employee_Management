<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Employee</title>
</head>
</head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<body>
	<div class="container">
	<h1>Employee Directory</h1>
	<hr/>
		<div class="row">

			<div class="col-md-4">
				<form action="${pageContext.request.contextPath}/EmployeeController"
					method="POST">
					<div class="form-group">
						<input type="text" name="firstname" value="${employee.name}"
							placeholder="Enter Name" class="form-control" /><br />
					</div>
					<div class="form-group">
						<input type="date" name="dob" value="${employee.dob}"
							placeholder="Enter Date Of Birth" class="form-control" /><br />
					</div>
					<div class="form-group">
						<input type="text" name="department"
							value="${employee.department}" placeholder="Enter Department"
							class="form-control" /><br />
					</div>
					<input type="hidden" value="${employee.id}" name="id" />
					<button class="btn btn-primary" type="submit">Save
						Employee</button>
				</form>
			</div>
		</div>

	</div>

</body>
</html>
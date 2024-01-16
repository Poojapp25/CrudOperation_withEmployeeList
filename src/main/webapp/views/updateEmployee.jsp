<%@ include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Employee Details</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>	
</head>
<body>
	<br />
	<form action="employeeUpdated">
		<p style="color:red; padding-left:10px">${message}</p>
		<label class="col-md-3 p-3">Update Employee Name to: </label>
		<input style="margin-left: 17px;" class="col-sm-4 w-25 p-3 form-control" type="text" name="name" value="${name}">
		<br />
		<label class="col-md-3 p-3">Update Employee Country to: </label>
		<input style="margin-left: 17px;" class="col-sm-4 w-25 p-3 form-control" type="text" name="country" value="${country}">
		<br />
		<input type="hidden" name="search" value="${search}">
		<input class="btn btn-primary w-25 m-3 p-3" style="margin-top: 20px; margin-left: 10px;" type="submit" value="Update Employee Details">
 	</form>
</body>
</html>
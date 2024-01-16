<%@ include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Employees</title>
</head>
<body>

<br />
	<div class="container">
		<table class="table table-hover">
			<thead style="height: 70px; vertical-align: middle; text-align: center;">
			<tr class="table-primary"><th scope="col">Employee ID</th><th scope="col">Employee Name</th><th scope="col">Country</th><th scope="col">Operation</th></tr>
			</thead>
			<tbody>
			<c:forEach items="${list}" var="emp">
				<tr style="height: 70px; vertical-align: middle; text-align: center;">
					<td>${emp.empId}</td>
					<td>${emp.name}</td>  
					<td>${emp.country}</td>
					<td><form style="display: inline-block;" action="/updateEmployee">
						<input type="hidden" name="search" value="${emp.empId}" />
						<input style="width: 100px;" class="btn btn-primary m-1 p-2" type="submit" value="Update">
					</form>
					<form style="display: inline-block;" action="/deleteEmployee">
						<input type="hidden" name="search" value="${emp.empId}" />
						<input style="width: 100px;" class="btn btn-primary m-1 p-2" type="submit" value="Delete">
					</form></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
 
 
</body>
</html>
<%@ include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
</head>
<body>
	 <br />
	 <form action="employeeAdded">
		<p style="color:red;">${message}</p>
		 <label class="col-md-3 p-3">Employee Name: </label>
		 <input style="margin-left: 17px;" class="col-sm-4 w-25 p-3 form-control" type="text" name="name" value="${name}" placeholder="Employee name">
		 <br />
		 <label class="col-md-3 p-3">Country: </label>
		 <input style="margin-left: 17px;" class="col-sm-4 w-25 p-3 form-control" type="text" name="country" value="${country}" placeholder="Country">
		 <br />
		 <input class="btn btn-primary w-25 m-3 p-3" style="margin-top: 20px; margin-left: 10px;" type="submit" value="Add Employee Details">
	  </form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Details</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>	
</head>
<body>
  <nav class="navbar navbar-expand-lg navbar-dark bg-success">
    <a style="padding-left: 10px;" class="navbar-brand" href="#">Employee-Details</a>
    <button class="nadvbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarColor01">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
          <a class="nav-link" href="getEmployees">All Employees</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="addEmployee">Add Employee</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/">Register</a>
        </li>
      </ul>
      
        <form style="margin-left: 30px;" action="searchEmployee" class="d-flex">
          <div class="dropdown">
          <select class="btn" name="item">
            <option class="dropdown-item" value="Id">Employee Id</option>
            <option class="dropdown-item" value="name">Employee Name</option>
            <option class="dropdown-item"  value="country">Employee Country</option>
          </select>
          </div>
            <input class="form-control me-2" type="text"  name="search" placeholder="Search (Employee Id)">
            <input type="hidden" value="item">
            <input class="btn btn-light" type="submit" value="Search">
        </form>
      	<a class="btn btn-light text-dark" style="margin-left: 150px; padding: 5px 10px;" href="/login">Logout</a>
      </div>
	</nav>
</body>
</html>
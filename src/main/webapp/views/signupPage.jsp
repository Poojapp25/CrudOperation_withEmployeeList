<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign-Up Page</title>
<title>trial</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>	
</head>
<body>
	<section class="bg-secondary" style="height: 100%;">
		<div class="container" style="padding: 3.5px;">
		  <div class="row justify-content-center align-items-center">
			<div class="col-xl-10">
			  <div class="row g-0 card col-md-6 align-items-center card-body p-lg-5 text-black" style="margin-left: 250px; border-radius: 1rem; height: 570px;">
					  <form action="/userLogin" oninput='password2.setCustomValidity(password2.value != password.value ? "Passwords do not match." : "")'>
						<h5 class="fw-normal mb-3 pb-3 text-center" style="letter-spacing: 1px;">Create new account</h5>
						<p style="color:red;">${message}</p>
						<div class="form-outline mb-4">
						  <input type="email" name="email" value="${email}" class="form-control form-control-lg"  required="required"/>
						  <label class="form-label">Email address</label>
						</div>
	  
						<div class="form-outline mb-4">
						  <input type="password" name="password" id="password" class="form-control form-control-lg"  required="required"/>
						  <label class="form-label">Password</label>
						</div>
	  
						<div class="form-outline mb-4">
							<input type="password" id="password2" class="form-control form-control-lg"  required="required"/>
							<label class="form-label">Confirm Password</label>
						  </div>
						<div class="pt-1 mb-4">
						  <input class="btn btn-success btn-lg btn-block w-100" type="submit" value="Sign In"></button>
						</div><p style="width: 10px;"></p>
						<p class="mb-5 pb-lg-2 text-center" style="color: #393f81;">Already have an account? <a href="/login" style="color: #393f81;">Login here</a></p>
					</form>
			  </div>
			</div>
		  </div>
		</div>
	  </section>
</body>
</html>
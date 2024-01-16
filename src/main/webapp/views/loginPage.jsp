<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css" />
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>	
</head>
<body>
	<section class="bg-secondary" style="height: 100%;">
		<div class="container" style="padding: 53px;">
		  <div class="row justify-content-center align-items-center">
			<div class="col-xl-10">
			  <div class="row g-0 card col-md-6 align-items-center card-body p-lg-5 text-black" style="margin-left: 250px; border-radius: 1rem; height: 470px;">
					  <form action="checkUser">
						<h5 class="fw-normal mb-3 pb-3 text-center" style="letter-spacing: 1px;">Sign into your account</h5>
	  
						<div class="form-outline mb-4">
						  <input type="email" name="email" value="${oldEmail}" class="form-control form-control-lg" required/>
						  <label class="form-label">Email address</label>
						</div>
	  
						<div class="form-outline mb-4">
              <div style="position: relative;">
                <input type="password" style="position: absolute;" id="input_pswd" name="password" class="form-control form-control-lg" required/>
                <h4><i style="position: absolute; margin-left: 290px; margin-top: 5px; color: rgb(47, 121, 78);" class="bi bi-eye-fill" id="eye_icon" onclick="togglePassword()"></i></h4>
              </div>
              <label class="form-label pt-5">Password</label>
						</div>

            <script>
              function togglePassword(){
                var x = document.getElementById("input_pswd");
                var y = document.getElementById("eye_icon");
                if(x.type === "password"){
                  x.type = "text"
                  y.className = "bi bi-eye-slash-fill"
                }else{
                  x.type = "password"
                  y.className = "bi bi-eye-fill"
                }
              }
            </script>
						<div class="pt-1 mb-4">
						  <input class="btn btn-success btn-lg btn-block w-100" type="submit">
						</div>
						<p class="mb-5 pb-lg-2 text-center" style="color: #393f81;">Don't have an account? <a href="/" style="color: #393f81;">Register here</a></p>
					  </form>
			  </div>
			</div>
		  </div>
		</div>
	  </section>
</body>
</html>
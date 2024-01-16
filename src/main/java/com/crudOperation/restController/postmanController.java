package com.crudOperation.restController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crudOperation.entities.employee1;
import com.crudOperation.services.postmanServices;

@RestController
public class postmanController {

	@Autowired
	private postmanServices postman; 
	
	@GetMapping("/employeesPostman")
	public List<employee1> getEmployeesPostman(){
		return this.postman.getEmployeesPostman();
	}
	
	@GetMapping("/employeesPostman/{empId}")
	public Optional<employee1> getEmployeePostman(@PathVariable long empId) {
		return this.postman.getEmployeePostman(empId);
	}
	
	@GetMapping("/employeesPostman/name/{name}")
	public List<employee1> getEmployeeByNamePostman(@PathVariable String name) {
		return this.postman.getEmployeeByNamePostman(name);
	}	
	
	@GetMapping("/employeesPostman/country/{country}")
	public List<employee1> getEmployeeBycountryPostman(@PathVariable String country) {
		return this.postman.getEmployeeBycountryPostman(country);
	}	
	
	@PostMapping("/employeesPostman")
	public employee1 addEmployee(@RequestBody employee1 emp) {
			return this.postman.addEmployeePostman(emp);
	}
	
	@PutMapping("/employeesPostman")
	public employee1 updateEmployee(@RequestBody employee1 emp) {
		return this.postman.updateEmployeePostman(emp);
	}
	
	@DeleteMapping("/employeesPostman/{empId}")
	public void deleteEmployee(@PathVariable long empId) {
			this.postman.deleteEmployeePostman(empId);
	}
}

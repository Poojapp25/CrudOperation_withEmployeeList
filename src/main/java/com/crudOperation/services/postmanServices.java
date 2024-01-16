package com.crudOperation.services;

import java.util.List;
import java.util.Optional;

import com.crudOperation.entities.employee1;

public interface postmanServices {

	public List<employee1> getEmployeesPostman();

	public Optional<employee1> getEmployeePostman(long empId);

	public employee1 updateEmployeePostman(employee1 emp);

	public void deleteEmployeePostman(long empId);

	public employee1 addEmployeePostman(employee1 emp);

	public List<employee1> getEmployeeByNamePostman(String name);

	public List<employee1> getEmployeeBycountryPostman(String country);

}

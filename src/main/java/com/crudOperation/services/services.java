package com.crudOperation.services;

import java.util.List;
import java.util.Optional;

import com.crudOperation.entities.employee1;

public interface services {

		public String addEmployee(String name, String country);
		public employee1 searchEmployee(long empId);
		public String userExist(long search);
		public String updateEmployee(long search, String name, String country);
		public String deleteEmployee(long search);
		public List<employee1> getEmployees();
		public List<employee1> getEmployeeByName(String search);
		public List<employee1> getEmployeeByCountry(String search);
}

package com.crudOperation.services;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudOperation.dao.daoRepository;
import com.crudOperation.entities.employee1;

@Service
public class employeeServices implements services{

	@Autowired
	daoRepository dao;
	
	@Override
	public String addEmployee(String name, String country) {
			employee1 emp = new employee1(1, name, country);
			dao.save(emp);
			return "Employee added successfully";
		
//		Avoid from updating already existing employee when saving new employee with same id
//		employee1 emp = dao.findById(search).orElse(null);
//		if(emp == null) {
//			return "employee already exist";
//		}else {
//			return "added new employee";
//		}
		
	}

	List <String> list;
//	@Override
//	public List<String> searchEmployee(long empId) {
//		Optional<employee1> emp = dao.findById(empId);
//		list.add("pooja");
//		return list;
//	}

//	@Override
//	public Optional<employee1> searchEmployee(long empId) {
//		// TODO Auto-generated method stub
//		return dao.findById(empId);
//	}
	@Override
	public employee1 searchEmployee(long empId) {
		// TODO Auto-generated method stub
		return dao.findById(empId).orElse(null);
	}

	@Override
	public String userExist(long search) {
		employee1 emp = dao.findById(search).orElse(null);
		if(emp == null) {
			return "No User Exist";
		}else {
			return emp.getName();
		}
	}

	@Override
	public String updateEmployee(long search, String name, String country) {
		employee1 emp = new employee1(search, name, country);
		dao.save(emp);
		return "Employee details Updated";
	}

	@Override
	public String deleteEmployee(long search) {
		employee1 emp = dao.findById(search).orElse(null);
		dao.delete(emp);
		return "Employee deleted successfully";
	}

	@Override
	public List<employee1> getEmployees() { 
		return dao.findAll();
	}

	@Override
	public List<employee1> getEmployeeByName(String search) {
		List<employee1> list = dao.findAll();
		for(Iterator<employee1> iterator = list.iterator(); iterator.hasNext();) {
			employee1 emp = iterator.next();
			if(!emp.getName().equals(search)) {
				iterator.remove();
			}
		}
		return list;
	}

	@Override
	public List<employee1> getEmployeeByCountry(String search) {
		List<employee1> list = dao.findAll();
		for(Iterator<employee1> iterator = list.iterator(); iterator.hasNext();) {
			employee1 emp = iterator.next();
			if(!emp.getCountry().equals(search)) {
				iterator.remove();
			}
		}
		return list;
	}

}

package com.crudOperation.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudOperation.dao.daoRepository;
import com.crudOperation.entities.employee1;

@Service
public class postmanService implements postmanServices {

	@Autowired
	private daoRepository dao1;

	@Override
	public employee1 addEmployeePostman(employee1 emp) {
		//		Avoid from updating already existing employee when saving new employee with same id
		employee1 e = dao1.findById(emp.getEmpId()).orElse(null);
		if(e == null) {
			return dao1.save(emp);
		}else {
//			employee1 e1 = new employee1(1, emp.getName(), emp.getCountry());
//			return dao1.save(e1);
			return e;
		}
//		return pdao.save(emp);
	}
	
	@Override
	public List<employee1> getEmployeesPostman() {
		return dao1.findAll();
	}

	@Override
	public Optional<employee1> getEmployeePostman(long empId) {
		return dao1.findById(empId);
	}

	@Override
	public employee1 updateEmployeePostman(employee1 emp) {
		return dao1.save(emp);
	}

	@Override
	public void deleteEmployeePostman(long empId) {
		dao1.deleteById(empId);
		
	}

	@Override
	public List<employee1> getEmployeeByNamePostman(String name) {
		List<employee1> list = dao1.findAll();
//		for (employee1 l:list){
//			if(l.getName() != name) {
//				list.remove(l);
//			}
//		}
		
		for(Iterator<employee1> iterator = list.iterator(); iterator.hasNext();) {
			employee1 emp = iterator.next();
			if(!emp.getName().equals(name)) {
				iterator.remove();
			}
		}
		return list;
	}

	@Override
	public List<employee1> getEmployeeBycountryPostman(String country) {
		List<employee1> list = dao1.findAll();
//		for (employee1 l:list){
//			if(l.getCountry() != country) {
//				list.remove(l);
//			}
//		}
		
//		Iterator<employee1> l = list.iterator();
//		while (l.hasNext()) {
//		   employee1 e = l.next(); // must be called before you can call i.remove()
//		   // Do something
//			if(e.getCountry() != country) {
//				l.remove();
//			}
//		}
//		list = l;
		
		for(Iterator<employee1> iterator = list.iterator(); iterator.hasNext();) {
			employee1 emp = iterator.next();
			if(!emp.getCountry().equals(country)) {
				iterator.remove();
			}
		}
		return list;
	}
}

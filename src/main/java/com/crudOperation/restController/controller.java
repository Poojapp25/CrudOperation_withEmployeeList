package com.crudOperation.restController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.crudOperation.entities.employee1;
import com.crudOperation.entities.member;
import com.crudOperation.services.services;
import com.crudOperation.services.userRegistrationServices;

@Controller
public class controller {
	
	@Autowired
	private services user;

	@RequestMapping("/getEmployees")
	public ModelAndView getEmployees() {
		ModelAndView mv = new ModelAndView();
		List<employee1> list = new ArrayList<employee1>();
		list  = user.getEmployees();
		int length = list.size();
		mv.addObject("list", list);
		mv.addObject("length", length);
		mv.setViewName("allEmployees");
		return mv;
	}
			
	@RequestMapping("/allEmployees")
	public ModelAndView allEmployee(@RequestParam("email") String email, @RequestParam("password") String password) {
		ModelAndView mv = new ModelAndView();
		List<employee1> list = new ArrayList<employee1>();
		list  = user.getEmployees();
		int length = list.size();
		mv.addObject("list", list);
		mv.addObject("length", length);
		mv.setViewName("allEmployees");
		return mv;
	}

	@RequestMapping("/addEmployee")
	public ModelAndView addEmployee(Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addEmployee");
		return mv;
	}	
	
	@RequestMapping("/employeeAdded")
	public ModelAndView employeeAdded(@RequestParam("name") String name, @RequestParam("country") String country) {
		ModelAndView mv = new ModelAndView();		
		if(name == "" || name == null || country == "" || country == null) {
			mv.addObject("message", "Please provide complete Employee details");
			mv.addObject("name", name);
			mv.addObject("country", country);
			mv.setViewName("addEmployee");
			return mv;
		}else {
			String message = user.addEmployee(name, country);
			mv.addObject("message", message);
			mv.setViewName("employeeAdded");
			return mv;
		}
	}
	
	@RequestMapping("/searchEmployee")
	public ModelAndView searchEmployee(@RequestParam("item") String item, @RequestParam("search") String search) {
		ModelAndView mv = new ModelAndView();
		if(item.equals("Id")) {
	        try{
	            Long number = Long.valueOf(search);
	    		if(user.userExist(number) == "No User Exist") {
					mv.addObject("message", "No Employee exist with Id: "+search);
					mv.setViewName("noSuchEmployee");
				}else{
					mv.addObject("emp", user.searchEmployee(number));
					mv.setViewName("searchEmployee");
				}
	        }
	        catch (NumberFormatException ex){
				mv.addObject("message", "Invalid Id number: "+search);
				mv.setViewName("noSuchEmployee");
	        }
		}else {
			if(item.equals("name")) {
				List<employee1> list = user.getEmployeeByName(search);
				if(list == null || list.isEmpty()) {
					mv.addObject("message", "No Employee exist with Name: "+search);
					mv.setViewName("noSuchEmployee");
				}else {
					mv.addObject("list", list);
					mv.setViewName("searchEmployeeByN_C");
				}
			}else {
				if(item.equals("country")) {
					List<employee1> list = user.getEmployeeByCountry(search);
					if(list == null || list.isEmpty()) {
						mv.addObject("message", "No Employee exist with Country: "+search);
						mv.setViewName("noSuchEmployee");
					}else {
						mv.addObject("list", list);
						mv.setViewName("searchEmployeeByN_C");
					}
				}
			}
		}
		return mv;
	}
	
	@RequestMapping("/updateEmployee")
	public ModelAndView updateEmployee(@RequestParam("search") long search) {
		ModelAndView mv = new ModelAndView();
		employee1 emp = user.searchEmployee(search);
		mv.addObject("search", search);
		mv.addObject("name", emp.getName());
		mv.addObject("country", emp.getCountry());
		mv.setViewName("updateEmployee");
		return mv;
	}
	
	@RequestMapping("/employeeUpdated")
	public ModelAndView employeeUpdated(@RequestParam("name") String name, @RequestParam("country") String country, @RequestParam("search") long search) {
		ModelAndView mv = new ModelAndView();
//		emp.setName(name);
//		emp.setCountry(country);
		if(name == "" || name == null || country == "" || country == null) {
			mv.addObject("message", "Please provide complete Employee details");
			mv.addObject("search", search);
			mv.addObject("name", name);
			mv.addObject("country", country);
			mv.setViewName("updateEmployee");
			return mv;
		}else {
			String message = user.updateEmployee(search, name, country);
			mv.addObject("message", message);
			mv.setViewName("employeeUpdated");
			return mv;
		}
	}
	
	@RequestMapping("/deleteEmployee")
	public ModelAndView deleteEmployee(@RequestParam("search") long search) {
		ModelAndView mv = new ModelAndView();
		String message = user.deleteEmployee(search);
		mv.addObject("message", message);
		mv.setViewName("employeeDeleted");
		return mv;
	}
	
	
//User Registration controller code
	@Autowired
	userRegistrationServices mem;
	
	@RequestMapping("/")
	public String registerUser(Model model) {
		return "signupPage";
	}
	
	@RequestMapping("/login")
	public String getLogin(Model model) {
		//remove next 4 lines
//		ModelAndView mv = new ModelAndView();
//		String message = "";
//		mv.addObject("message", message);
//		String oldEmail = "";
//		mv.addObject("email1", oldEmail);
		return "loginPage";
	}
	
	@RequestMapping("/userLogin")
	public ModelAndView userLogin(@RequestParam("email") String email, @RequestParam("password") String password) {
		ModelAndView mv = new ModelAndView();
		if(this.mem.alreadyMember(email)) {
			mv.addObject("message", "Already a member.");
			mv.addObject("email", email);
			mv.setViewName("signupPage");
		}else {
			this.mem.createMember(email, password);
			mv.setViewName("loginPage");
		}
		return mv;
	}
	
	@RequestMapping("/checkUser")
	public ModelAndView checkUser(@RequestParam("email") String email, @RequestParam("password") String password){
		ModelAndView mv = new ModelAndView();
		String message = this.mem.checkMember(email, password);
		if(message.equals("No user found.")) {
			mv.addObject("message", message);
			mv.addObject("oldEmail", email);
			mv.setViewName("loginPage");
			return mv;
		}else {
			if(message.equals("Incorrect Password.")) {
				mv.addObject("message", message);
				mv.addObject("oldEmail", email);
				mv.setViewName("loginPage");
				return mv;
			}
		}
		member m = new member(email, password);
		mv.addObject("m", m);
		mv.setViewName("header");
		return mv;
	}
}








//@RequestMapping("")
//public ModelAndView homepage(Model model) {
//	ModelAndView mv = new ModelAndView();
//	List<employee1> list = new ArrayList<employee1>();
//	list  = user.getEmployees();
//	mv.addObject("list", list);
//	mv.setViewName("allEmployees");
//	return mv;
//}


//@RequestMapping("/allEmployees")
//public ModelAndView allEmployee(employee1 emp) {
//	ModelAndView mv = new ModelAndView();
//	mv.addObject("emp", emp);
//	user.addEmployee(emp);
//	List<employee1> list = new ArrayList<employee1>();
//	list  = user.getEmployees();
//	mv.addObject("list", list);
//	mv.setViewName("allEmployees");
//	return mv;
//}


//@RequestMapping("/searchEmployee")
//public ModelAndView searchEmployee(@RequestParam("search") long search) {
//	ModelAndView mv = new ModelAndView();
//	if(user.userExist(search) == "No User Exist") {
//		String message = "Sorry, No Employee exist with Id: "+search;
//		mv.addObject("message", message);
////		String message = "No Employee exist with id "+search;
////		mv.addObject("message", message);
//		mv.setViewName("noSuchEmployee");
//	}else {
//		employee1 emp = user.searchEmployee(search);
//		mv.addObject("emp", emp);
//		mv.addObject("search", search);
//		mv.setViewName("searchEmployee");
//	}
//	return mv;
//}


//Additional update employee
//@PostMapping("/addExistingEmployee")
//public String addExistingEmployee(@PathVariable long empId) {
//	
//	return "";
//}

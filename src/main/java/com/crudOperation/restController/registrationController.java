//package com.crudOperation.restController;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.crudOperation.entities.member;
//import com.crudOperation.services.userRegistrationServices;
//
//@Controller
//public class registrationController {
//
//	@Autowired
//	userRegistrationServices mem;
//	
//	@RequestMapping("/")
//	public String registerUser(Model model) {
//		return "signupPage";
//	}
//	
//	@RequestMapping("/login")
//	public String getLogin(Model model) {
//		//remove next 4 lines
////		ModelAndView mv = new ModelAndView();
////		String message = "";
////		mv.addObject("message", message);
////		String oldEmail = "";
////		mv.addObject("email1", oldEmail);
//		return "loginPage";
//	}
//	
//	@RequestMapping("/userLogin")
//	public ModelAndView userLogin(@RequestParam("email") String email, @RequestParam("password") String password) {
//		ModelAndView mv = new ModelAndView();
//		if(this.mem.alreadyMember(email)) {
//			mv.addObject("message", "Already a member.");
//			mv.addObject("email", email);
//			mv.setViewName("signupPage");
//		}else {
//			this.mem.createMember(email, password);
//			mv.setViewName("loginPage");
//		}
//		return mv;
//	}
//	
//	@RequestMapping("/checkUser")
//	public ModelAndView checkUser(@RequestParam("email") String email, @RequestParam("password") String password){
//		ModelAndView mv = new ModelAndView();
//		String message = this.mem.checkMember(email, password);
//		if(message.equals("No user found.")) {
//			mv.addObject("message", message);
//			mv.addObject("oldEmail", email);
//			mv.setViewName("loginPage");
//			return mv;
//		}else {
//			if(message.equals("Incorrect Password.")) {
//				mv.addObject("message", message);
//				mv.addObject("oldEmail", email);
//				mv.setViewName("loginPage");
//				return mv;
//			}
//		}
//		member m = new member(email, password);
//		mv.addObject("m", m);
//		mv.setViewName("header");
//		return mv;
//	}
//}

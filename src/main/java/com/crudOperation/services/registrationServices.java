package com.crudOperation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudOperation.dao.registrationDao;
import com.crudOperation.entities.member;

@Service
public class registrationServices implements userRegistrationServices{

	@Autowired
	registrationDao regdao;
	
	@Override
	public void createMember(String email, String password) {
		member m = new member(email, password);
		regdao.save(m);
	}

	@Override
	public String checkMember(String email, String password) {
		member m = regdao.findById(email).orElse(null);
		if(m == null) {
			return "No user found.";
		}else {
			String p = m.getPassword();
			if(p.equals(password)) {
				return "correct"+p+" = "+password;
			}
		}
		return "Incorrect Password.";
	}

	@Override
	public boolean alreadyMember(String email) {
		member m = regdao.findById(email).orElse(null);
		if(m == null) {
			return false;
		}else{
			return true;
		}
	}

}

package com.crudOperation.services;

public interface userRegistrationServices {

	void createMember(String email, String password);

	String checkMember(String email, String password);

	boolean alreadyMember(String email);

}

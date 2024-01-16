package com.crudOperation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudOperation.entities.member;

public interface registrationDao extends JpaRepository<member, String>{

}

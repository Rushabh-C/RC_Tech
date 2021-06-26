package com.E_comm.repository;

import org.springframework.data.repository.CrudRepository;

import com.E_comm.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsername(String username);
	
	User findByEmail(String email);
}

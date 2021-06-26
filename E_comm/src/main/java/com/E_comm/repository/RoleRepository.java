package com.E_comm.repository;

import org.springframework.data.repository.CrudRepository;

import com.E_comm.domain.security.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
	
	Role findByname(String name);

}

package com.E_comm;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.E_comm.domain.User;
import com.E_comm.domain.security.Role;
import com.E_comm.domain.security.UserRole;
import com.E_comm.service.UserService;
import com.E_comm.utility.SecurityUtility;


@SpringBootApplication
public class ECommApplication implements CommandLineRunner{
	
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(ECommApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
		User user1 = new User();
		user1.setFirstName("Rushabh");
		user1.setLastName("Chheda");
		user1.setUsername("r");
		user1.setPassword(SecurityUtility.bCryptpasswordEncoder().encode("password"));
		user1.setEmail("rushabhchheda02@gmail.com");
		Set<UserRole> userRoles = new HashSet<>();
		Role role1 = new Role();
		role1.setRoleId(1);
		role1.setName("ROLE_ADMIN");
		userRoles.add(new UserRole(user1, role1));

		userService.createUser(user1, userRoles);
	}

}

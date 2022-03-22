package com.exam;
import com.exam.entity.*;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exam.entity.User;
import com.exam.serviceImpl.UserServiceImpl;

@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner{
	
	@Autowired
	UserServiceImpl usi;

	public static void main(String[] args) {
		SpringApplication.run(ExamserverApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
		System.out.println("starting code");
//		User user = new User();
//		user.setFirstName("Aman");
//		user.setLastName("Roy");
//		user.setUsername("aman1234");
//		user.setPassword("Aman@123");
//		user.setProfile("default.png");
//		
//		Role role1 = new Role();
//		
//		role1.setRoleId(44L);
//		role1.setRoleName("ADMIN");
//		
//		Set<UserRole> userRoleSet = new HashSet<>();
//		
//		userRoleSet.add(new UserRole(user,role1));
//		
//		User user1 = this.usi.createUser(user, userRoleSet);
//		
//		System.out.println(user1.getUsername());
	}
	
	
	

}


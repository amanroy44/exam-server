package com.exam.controller;

import java.util.HashSet;
import java.util.Set;

import org.aspectj.weaver.patterns.HasThisTypePatternTriedToSneakInSomeGenericOrParameterizedTypePatternMatchingStuffAnywhereVisitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.entity.Role;
import com.exam.entity.User;
import com.exam.entity.UserDTO;
import com.exam.entity.UserRole;
import com.exam.serviceImpl.UserServiceImpl;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")

public class UserController {
	
	@Autowired
	private UserServiceImpl usi;
	
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {
		
		Set<UserRole> userRoleSet = new HashSet<>();
		Role role = new Role();
		role.setRoleId(45L);
		role.setRoleName("NORMAL");
		
		userRoleSet.add(new UserRole(user,role));
		
		return this.usi.createUser(user, userRoleSet);
	}
	
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {
		return this.usi.getUser(username);
	}
	
	@DeleteMapping("/{userId}")
	@ResponseBody
	public String deleteUser(@PathVariable("userId") Long userId) {
		this.usi.deleteUser(userId);
		return "the user deleted successfully";
	}
	
	@PutMapping("/update/{userId}")
	public User updateUser(@PathVariable("userId") Long userId, @RequestBody UserDTO userDTO) {
		return this.usi.updateUser(userId,userDTO);
	} 
	
	
}

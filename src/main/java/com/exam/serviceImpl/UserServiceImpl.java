package com.exam.serviceImpl;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.entity.User;
import com.exam.entity.UserDTO;
import com.exam.entity.UserRole;
import com.exam.repo.RoleRepository;
import com.exam.repo.UserRepository;
import com.exam.service.*;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	public  UserRepository userRepository;
	
	@Autowired
	public  RoleRepository roleRepository;
	
	
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception{
		
		User local = userRepository.findByUsername(user.getUsername());
		if(local!=null) {
			System.out.println(" user already present !!");
			throw new Exception(" user already present ");
		}
		else {
			for(UserRole ur: userRoles) {
				roleRepository.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			local = userRepository.save(user);
			
		}
		return local;
	}
	
	//gettin user by username
	@Override
	public User getUser(String username) {
		return this.userRepository.findByUsername(username);
	}
	
	@Override
	public void deleteUser(Long userId) {
		this.userRepository.deleteById(userId);
	}
	
	@Override
	public User updateUser(Long userId, UserDTO userDTO) {
		User local = userRepository.getById(userId);
		if(local!=null) {
	        local.setFirstName(userDTO.getFirstName());
		    local.setLastName(userDTO.getLastName());
			local.setUsername(userDTO.getUsername());
			local.setPassword(userDTO.getPassword());
			local.setPhone(userDTO.getPhone());
			local.setEmail(userDTO.getEmail());
			local.setEnabled(userDTO.isEnabled());
			local.setProfile(userDTO.getProfile());
			local.setUserRoles(userDTO.getUserRoles());
			User updatedUser = userRepository.save(local);
			return new User(updatedUser.getUsername(), updatedUser.getPassword(), updatedUser.getFirstName(), updatedUser.getLastName(),updatedUser.getEmail(), updatedUser.getPhone(), updatedUser.isEnabled(), updatedUser.getProfile(), updatedUser.getUserRoles());
			
		}
		else {
			return null;
		}
	}
	 
	
}

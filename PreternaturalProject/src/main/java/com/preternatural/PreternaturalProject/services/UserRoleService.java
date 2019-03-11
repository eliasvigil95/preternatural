package com.preternatural.PreternaturalProject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.preternatural.PreternaturalProject.models.UserRole;
import com.preternatural.PreternaturalProject.repositories.UserRoleRepository;

@Service("userRoleService")
public class UserRoleService {

	private UserRoleRepository userRoleRepository;
	
	@Autowired
	public void setUserRoleRepository(UserRoleRepository userRoleRepository) {
		this.userRoleRepository = userRoleRepository;
	}
	
	public UserRole getUserRoleByTitle(String title) {
		return userRoleRepository.getUserRoleByTitle(title);
	}
}

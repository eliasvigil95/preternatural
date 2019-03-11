package com.preternatural.PreternaturalProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.preternatural.PreternaturalProject.models.UserRole;

/*
 * UserRoleRepository contains CRUD methods that will be used in the UserRoleService. 
 * These methods are associated with the USER_ROLES table.
 */
public interface UserRoleRepository extends JpaRepository <UserRole, Integer> {

	 UserRole getUserRoleByTitle(String title);
}

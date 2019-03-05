package com.preternatural.PreternaturalProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.preternatural.PreternaturalProject.models.UserRole;

public interface UserRoleRepository extends JpaRepository <UserRole, Integer> {

	 UserRole getUserRoleByTitle(String title);
}

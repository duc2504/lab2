
package com.example.java6.repository;

import com.example.java6.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleDAO extends JpaRepository<UserRole, Long> {
    List<UserRole> findByUserUsername(String username);
}

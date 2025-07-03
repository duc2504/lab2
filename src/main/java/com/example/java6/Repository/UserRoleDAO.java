package com.example.java6.Repository;

import com.example.java6.Model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRoleDAO extends JpaRepository<UserRole, Long> {
    List<UserRole> findByUsername(String username);
}
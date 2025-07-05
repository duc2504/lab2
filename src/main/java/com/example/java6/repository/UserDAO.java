
package com.example.java6.repository;

import com.example.java6.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<AppUser, String> {}

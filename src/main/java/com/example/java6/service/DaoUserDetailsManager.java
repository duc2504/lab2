
package com.example.java6.service;

import com.example.java6.model.AppUser;
import com.example.java6.repository.UserDAO;
import com.example.java6.repository.UserRoleDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DaoUserDetailsManager implements UserDetailsService {

    private final UserDAO userDAO;
    private final UserRoleDAO userRoleDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = userDAO.findById(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        List<GrantedAuthority> authorities = userRoleDAO.findByUserUsername(username).stream()
            .map(ur -> new SimpleGrantedAuthority("ROLE_" + ur.getRole().getId()))
            .collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.isEnabled(),
                true, true, true,
                authorities
        );
    }
}

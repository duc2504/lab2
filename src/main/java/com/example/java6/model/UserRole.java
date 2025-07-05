
package com.example.java6.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "UserRoles")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "username")
    private AppUser user;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}

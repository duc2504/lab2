
package com.example.java6.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Users")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class AppUser {
    @Id
    private String username;
    private String password;
    private Integer enabled;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<UserRole> userRoles;

    public boolean isEnabled() {
        return enabled != null && enabled == 1;
    }
}

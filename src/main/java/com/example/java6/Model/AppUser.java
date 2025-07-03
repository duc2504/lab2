package com.example.java6.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// User.java
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Users")
public class AppUser {
    @Id
    private String username;

    private String password;
    private Integer enabled;

    // getters, setters



    public boolean isEnabled() {
        return enabled != null && enabled == 1;
    }



}


package com.example.java6.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Roles")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Role {
    @Id
    private String id;
}

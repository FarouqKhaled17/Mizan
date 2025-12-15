package com.Mizan.MizanApp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Id;
    private String name;
    private String email;
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    private java.util.List<String> roles;
}

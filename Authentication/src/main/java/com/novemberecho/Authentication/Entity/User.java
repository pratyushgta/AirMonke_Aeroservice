package com.novemberecho.Authentication.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@Entity
@Table(name = "User", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String gender;
    private String dob;

    public User(){

    }

    public User(String firstName, String lastName, String email, String password, String gender, String dob, Collection<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.dob = dob;
        this.roles = roles;
    }


    // to establish many-to-many relationship between User and roles. Unidirectional mapping
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //Eager means, whenever we want to retrieve user, we will also retrieve roles
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

}

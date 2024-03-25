package com.novemberecho.AdminModule.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Routes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int routes_id;

    private String city;
    private String airport;
    private String country;
    private String state;
}

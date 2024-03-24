package com.novemberecho.Authentication.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class UserRegistrationDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String dob;
    private String gender;

    public UserRegistrationDto() {

    }

    public UserRegistrationDto(String firstName, String lastName, String email, String password, String dob, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.gender = gender;
    }


}

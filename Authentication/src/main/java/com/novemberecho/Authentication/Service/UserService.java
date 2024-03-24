package com.novemberecho.Authentication.Service;

import com.novemberecho.Authentication.DTO.UserRegistrationDto;
import com.novemberecho.Authentication.Entity.Role;
import com.novemberecho.Authentication.Entity.User;
import com.novemberecho.Authentication.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@AllArgsConstructor
@Service
public class UserService implements UserServiceInterface {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(UserRegistrationDto registrationDto) {
        User user = new User(registrationDto.getFirstName(), registrationDto.getLastName(),
                registrationDto.getEmail(), registrationDto.getPassword(), registrationDto.getGender(), registrationDto.getDob(), Arrays.asList(new Role("ROLE_USER")));
        return userRepository.save(user);
    }
}

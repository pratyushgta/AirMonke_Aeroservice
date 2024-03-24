package com.novemberecho.Authentication.Service;

import com.novemberecho.Authentication.DTO.UserRegistrationDto;
import com.novemberecho.Authentication.Entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserServiceInterface extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}
